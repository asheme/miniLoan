package com.wealth.miniloan.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.DataGrid;
import com.wealth.miniloan.entity.MlCorpCustInfo;
import com.wealth.miniloan.entity.MlLoanInfo;
import com.wealth.miniloan.entity.MlNaturalCustInfo;
import com.wealth.miniloan.entity.MlSysParam;
import com.wealth.miniloan.entity.MlUser;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.entity.UnionLoanInfo;
import com.wealth.miniloan.entity.User;
import com.wealth.miniloan.service.LoanServiceI;
import com.wealth.miniloan.service.ParamServiceI;
import com.wealth.miniloan.utils.Constant;

@Controller
@RequestMapping(value = "/loan")
@SessionAttributes("user")
public class LoanController {
	private LoanServiceI loanService = null;
	private ParamServiceI paramService = null;

	@Autowired
	public void setParamService(ParamServiceI paramService) {
		this.paramService = paramService;
	}

	@Autowired
	public void setLoanService(LoanServiceI loanService) {
		this.loanService = loanService;
	}

	
	/*
	 * 表单提交日期绑定
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	@RequestMapping(value = "loanInfoList")
	@ResponseBody
	public DataGrid getLoanInfoList(Page page, UnionLoanInfo unionLoanInfo, @ModelAttribute("user") User user) {
		DataGrid resut = new DataGrid();
		PageList<UnionLoanInfo> loanInfoList = null;
		loanInfoList = this.loanService.getLoanPageList(page, unionLoanInfo);

		if (loanInfoList != null) {
			resut.setRows(loanInfoList);
			resut.setTotal(Long.valueOf(loanInfoList.getPaginator().getTotalCount()));
		}

		return resut;
	}

	@RequestMapping(value = "viewLoanInfo")
	public ModelAndView viewLoanInfo(MlLoanInfo loanInfo) {
		String custType = null;
		MlNaturalCustInfo naturalCustInfo = null;
		MlCorpCustInfo corpCustInfo = null;
		ModelAndView modelAndView = new ModelAndView();

		loanInfo = this.loanService.getLoanInfo(loanInfo);
		modelAndView.addObject("loanInfo", loanInfo);
		custType = loanInfo.getCustType();
		if (Constant.CUST_TYPE_NATURAL.equals(custType)) {
			naturalCustInfo = this.loanService.getNaturalCustInfoByLoanInfo(loanInfo);
			modelAndView.addObject("naturalCustInfo", naturalCustInfo);
			modelAndView.setViewName("loan/viewNaturalLoanInfo");
		} else {
			corpCustInfo = this.loanService.getCorpCustInfoByLoanInfo(loanInfo);
			modelAndView.addObject("corpCustInfo", corpCustInfo);
			modelAndView.setViewName("loan/viewCorpLoanInfo");
		}

		return modelAndView;
	}

	@RequestMapping(value = "contractMaintain")
	public ModelAndView contractMaintain(MlLoanInfo loanInfo) {
		ModelAndView modelAndView = new ModelAndView();
		loanInfo = this.loanService.getLoanInfo(loanInfo);
		modelAndView.addObject("loanInfo", loanInfo);
		modelAndView.setViewName("loan/contractMaintain");
		return modelAndView;
	}

	@RequestMapping(value = "modifyContract")
	@ResponseBody
	public Map<String, Object> modifyContract(MlLoanInfo loanInfo, @RequestParam("file") MultipartFile[] file,
			@ModelAttribute("user") MlUser user) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if (user != null && loanInfo != null) {

				// 上传附件
				if (file != null && file.length > 0 && file[0] != null) {
					String fileName = file[0].getOriginalFilename();
					String prefix = fileName.substring(fileName.lastIndexOf(".") + 1);
					DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
					String physicalFileName = "CONTRACT_" + user.getUserId() + "_" + format.format(new Date()) + "."
							+ prefix;
					boolean uploadFlag = uploadAttach(file, physicalFileName);
					loanInfo.setContractName(fileName);
					loanInfo.setContractPhysicalName(physicalFileName);

					if (uploadFlag) {
						this.loanService.update(loanInfo);
						result.put("success", true);
						result.put("msg", "合同信息更新成功！");
					} else {
						result.put("success", false);
						result.put("msg", "合同附件信息上传失败！");

					}
				} else {
					this.loanService.update(loanInfo);
					result.put("success", true);
					result.put("msg", "合同信息更新成功！");
				}

			} else {
				result.put("success", false);
				result.put("msg", "合同信息修改失败，服务器端未获得要修改的信息！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "合同信息修改失败，服务器端处理异常！");
		}

		return result;
	}

	public boolean uploadAttach(MultipartFile[] uploadFile, String physicalFileName) {
		boolean flag = true;
		String attachFolder = null;

		try {
			if (uploadFile != null) {
				MlSysParam param = this.paramService.getParamByCode("ATTACH_SAVE_FOLDER");
				attachFolder = param.getParamVal();
				File file = new File(attachFolder);

				if (!file.exists() && !file.isDirectory()) {
					file.mkdirs();
				}
				for (MultipartFile tmpFile : uploadFile) {
					FileCopyUtils.copy(tmpFile.getBytes(), new File(attachFolder + "/" + physicalFileName));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}

		return flag;
	}

	@RequestMapping("download")
	public ResponseEntity<byte[]> download(String contractName, String contractPhysicalName) throws IOException {
		String attachFolder = null;

		try {
			MlSysParam param = this.paramService.getParamByCode("ATTACH_SAVE_FOLDER");
			attachFolder = param.getParamVal();
			File file = new File(attachFolder + "/" + contractPhysicalName);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.setContentDispositionFormData("attachment", new String(contractName.getBytes("utf-8"), "ISO8859-1"));
			return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
