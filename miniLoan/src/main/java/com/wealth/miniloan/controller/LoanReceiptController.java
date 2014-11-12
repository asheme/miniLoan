package com.wealth.miniloan.controller;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.DataGrid;
import com.wealth.miniloan.entity.MlLoanInfo;
import com.wealth.miniloan.entity.MlLoanReceipt;
import com.wealth.miniloan.entity.MlSysParam;
import com.wealth.miniloan.entity.MlUser;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.LoanReceiptServiceI;
import com.wealth.miniloan.service.LoanServiceI;
import com.wealth.miniloan.service.ParamServiceI;
import com.wealth.miniloan.utils.key.KeyGenerator;

@Controller
@RequestMapping(value = "/loan/receipt")
@SessionAttributes("user")
public class LoanReceiptController extends BaseController {
	private LoanReceiptServiceI loanReceiptService = null;
	private LoanServiceI loanService = null;
	private ParamServiceI paramService = null;

	@Autowired
	public void setParamService(ParamServiceI paramService){
		this.paramService=paramService;
	}

	@Autowired
	public void setLoanService(LoanServiceI loanService) {
		this.loanService = loanService;
	}

	@Autowired
	public void setLoanReceiptService(LoanReceiptServiceI loanReceiptService) {
		this.loanReceiptService = loanReceiptService;
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

	@RequestMapping(value = "toLoanReceiptList")
	@ResponseBody
	public ModelAndView toLoanReceiptList(MlLoanInfo loanInfo) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("loan/loanReceiptList");
		modelAndView.addObject("loanId", loanInfo.getLoanId());
		return modelAndView;
	}

	@RequestMapping(value = "loanReceiptList")
	@ResponseBody
	public DataGrid getLoanReceiptList(Page page, MlLoanInfo loanInfo) {
		DataGrid resut = new DataGrid();
		PageList<MlLoanReceipt> LoanReceipts = null;
		LoanReceipts = this.loanReceiptService.getPageList(page, loanInfo);

		if (LoanReceipts != null) {
			resut.setRows(LoanReceipts);
			resut.setTotal(Long.valueOf(LoanReceipts.getPaginator().getTotalCount()));
		}
		return resut;
	}

	@RequestMapping(value = "toAddLoanReceipt")
	public ModelAndView toAddLoanReceipt(MlLoanReceipt receipt) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("loan/modifyLoanReceipt");
		modelAndView.addObject("flag", "ADD");
		modelAndView.addObject("receipt", receipt);
		return modelAndView;
	}

	@RequestMapping(value = "toUpdateLoanReceipt")
	public ModelAndView toUpdateLoanReceipt(MlLoanReceipt receipt) {
		try {
			receipt = this.loanReceiptService.getByPriKey(receipt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("loan/modifyLoanReceipt");
		modelAndView.addObject("flag", "UPDATE");
		modelAndView.addObject("receipt", receipt);
		return modelAndView;
	}

	@RequestMapping(value = "modifyLoanReceipt", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> modifyLoanReceipt(String flag,
			MlLoanReceipt receipt, @RequestParam("file") MultipartFile[] file, @ModelAttribute("user") MlUser user) {
		Map<String, Object> result = new HashMap<String, Object>();
		MlLoanInfo loanInfo = new MlLoanInfo();
		loanInfo.setLoanId(receipt.getLoanId());
		loanInfo = this.loanService.getLoanInfo(loanInfo);
		//已放款金额
		BigDecimal offerLoan = loanInfo.getOfferLoan();
		//贷款金额
		BigDecimal loanAmount = loanInfo.getLoanAmount();

		if ("ADD".equals(flag)) {
			receipt.setReceiptId(KeyGenerator.getNextKey("ML_LOAN_RECEIPT", "RECEIPT_ID"));
			receipt.setOper(user.getUserId());
			// 累计放款
			if (offerLoan != null) {
				receipt.setOfferAmountSum(offerLoan.add(receipt.getOfferAmount()));
				loanInfo.setOfferLoan(offerLoan.add(receipt.getOfferAmount()));
			}
			// 剩余放款
			if (loanAmount != null) {
				receipt.setOfferAmountRemain(loanAmount.subtract(receipt.getOfferAmountSum()));
				loanInfo.setRemainAmount(loanAmount.subtract(receipt.getOfferAmountSum()));
			}

			// 上传附件
			if (file != null && file.length > 0 && file[0] != null) {
				String fileName = file[0].getOriginalFilename();
				String prefix = fileName.substring(fileName.lastIndexOf(".") + 1);
				DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
				String physicalFileName = "RECEIPT_" + user.getUserId() + "_" + format.format(new Date()) + "."
						+ prefix;
				boolean uploadFlag = uploadAttach(file, physicalFileName);
				receipt.setReceiptName(fileName);
				receipt.setReceiptPhysicalName(physicalFileName);
				if (uploadFlag) {
					result = addLoanReceipt(receipt, user);
					result.put("success", true);
					result.put("msg", "放款信息更新成功！");
				} else {
					result.put("success", false);
					result.put("msg", "附件信息更新成功！");
				}
			} else {
				result = addLoanReceipt(receipt, user);
				result.put("success", true);
				result.put("msg", "放款信息更新成功！");
			}
			
		} else if ("UPDATE".equals(flag)) {
			receipt.setOper(user.getUserId());
			result = updateLoanReceipt(receipt, user);
		} else {
			result.put("success", false);
			result.put("msg", "放款信息添加异常，服务器端无法正常获取请求数据！");
		}

		//更新贷款信息表
		this.loanService.update(loanInfo);
		
		return result;
	}

	public Map<String, Object> addLoanReceipt(MlLoanReceipt record, MlUser user) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			if (record != null) {
				this.loanReceiptService.create(record);
				result.put("success", true);
				result.put("msg", "放款信息添加成功！");
			} else {
				result.put("success", false);
				result.put("msg", "放款信息添加失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "服务器端出现异常！");
		}

		return result;
	}

	public Map<String, Object> updateLoanReceipt(MlLoanReceipt record, MlUser user) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if (user != null) {
				this.loanReceiptService.update(record);
				result.put("success", true);
				result.put("msg", "放款信息修改成功！");
			} else {
				result.put("success", false);
				result.put("msg", "放款信息修改失败，服务器端未获得要修改的信息！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "放款信息修改失败，服务器端处理异常！");
		}

		return result;
	}


	@RequestMapping(value = "deleteLoanReceipt")
	@ResponseBody
	public Map<String, Object> deleteLoanReceipt(String ids) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if ((ids != null) && (!"".equals(ids.trim()))) {
				this.loanReceiptService.delete(ids);
				result.put("success", true);
				result.put("msg", "放款信息删除成功！");
			} else {
				result.put("success", false);
				result.put("msg", "放款信息删除失败，服务器端未获得要删除的信息！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "放款信息删除失败，服务器端处理异常！");
		}

		return result;
	}
	
	public boolean uploadAttach(MultipartFile[] uploadFile,String physicalFileName) {
		boolean flag = true;
		String attachFolder=null;
		
		try {
			if (uploadFile != null) {
				MlSysParam param=this.paramService.getParamByCode("ATTACH_SAVE_FOLDER");
				attachFolder=param.getParamVal();
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
	public ResponseEntity<byte[]> download(String receiptName,String receiptPhysicalName) throws IOException {
		String attachFolder=null;

		try {
			MlSysParam param=this.paramService.getParamByCode("ATTACH_SAVE_FOLDER");
			attachFolder=param.getParamVal();
			File file = new File(attachFolder + "/" + receiptPhysicalName);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.setContentDispositionFormData("attachment", new String(receiptName.getBytes("utf-8"), "ISO8859-1"));
			return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

}
