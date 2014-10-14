package com.wealth.miniloan.controller;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import com.wealth.miniloan.entity.MlCorpAttach;
import com.wealth.miniloan.entity.MlSysParam;
import com.wealth.miniloan.entity.MlUser;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.LoanCorpAttachServiceI;
import com.wealth.miniloan.service.ParamServiceI;
import com.wealth.miniloan.utils.key.KeyGenerator;

@Controller
@RequestMapping(value = "/corp/attach")
@SessionAttributes("user")
public class CorpAttachController extends BaseController {
	private LoanCorpAttachServiceI corpAttachService = null;
	private ParamServiceI paramService = null;

	@Autowired
	public void setCorpAttachService(LoanCorpAttachServiceI corpAttachService) {
		this.corpAttachService = corpAttachService;
	}

	@Autowired
	public void setParamService(ParamServiceI paramService){
		this.paramService=paramService;
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

	@RequestMapping(value = "toCorpAttachList")
	@ResponseBody
	public ModelAndView AttachList(MlCorpAttach corpAttach) {
		String appNo = corpAttach.getAppNo();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("corpApp/corpAttachList");
		modelAndView.addObject("appNo", appNo);
		return modelAndView;
	}

	@RequestMapping("corpCheckAttach")
	@ResponseBody
	public ModelAndView corpCheckAttach(String appNo) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("check/corpAttachDetail");
		modelAndView.addObject("flag", "CHECK");
		modelAndView.addObject("appNo", appNo);
		return modelAndView;

	}

	@RequestMapping(value = "corpAttachList")
	@ResponseBody
	public DataGrid getCorpAttachList(Page page, MlCorpAttach corpAttach) {
		DataGrid resut = new DataGrid();
		PageList<MlCorpAttach> loanCorpAttachList = null;
		loanCorpAttachList = corpAttachService.getCorpAttachPageList(page, corpAttach);

		if (loanCorpAttachList != null) {
			resut.setRows(loanCorpAttachList);
			resut.setTotal(Long.valueOf(loanCorpAttachList.getPaginator().getTotalCount()));
		}

		return resut;
	}

	@RequestMapping(value = "toAddCorpAttach")
	public ModelAndView toAddCorpAttach(MlCorpAttach corpAttach) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("corpApp/modifyCorpAttach");
		modelAndView.addObject("flag", "ADD");
		modelAndView.addObject("corpAttach", corpAttach);
		return modelAndView;
	}

	@RequestMapping(value = "toUpdateCorpAttach")
	public ModelAndView toUpdateCorpAttach(MlCorpAttach corpAttach) {
		try {
			corpAttach = this.corpAttachService.getCorpAttachByPriKey(corpAttach);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("corpApp/modifyCorpAttach");
		modelAndView.addObject("flag", "UPDATE");
		modelAndView.addObject("corpAttach", corpAttach);
		return modelAndView;
	}

	@RequestMapping(value = "modifyCorpAttach", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> modifyNaturalattach(MlCorpAttach corpAttach, @RequestParam("file") MultipartFile[] file,
			String flag, @ModelAttribute("user") MlUser user) {
		String fileName=file[0].getOriginalFilename();
		String prefix=fileName.substring(fileName.lastIndexOf(".")+1);
		DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");		
		String physicalFileName="CAA_"+user.getUserId()+"_"+format.format(new Date())+"."+prefix;
		boolean uploadFlag = uploadAttach(file,physicalFileName);

		if (file != null && file[0] != null) {
			corpAttach.setFileName(fileName);
		}
		Map<String, Object> result = new HashMap<String, Object>();
		if ("ADD".equals(flag)) {
			corpAttach.setPhysicalName(physicalFileName);
			result = addCorpAttach(corpAttach);
		} else if ("UPDATE".equals(flag)) {
			deleteAttachFile(corpAttach);
			corpAttach.setPhysicalName(physicalFileName);
			result = updateCorpAttach(corpAttach);
		}
		if (uploadFlag) {
			result.put("success", true);
			result.put("msg", "附件信息添加成功！");
		} else {
			result.put("success", false);
			result.put("msg", "附件信息添加异常，服务器端无法正常获取请求数据！");
		}

		return result;
	}

	public Map<String, Object> addCorpAttach(MlCorpAttach corpAttach) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if (corpAttach != null) {
				corpAttach.setFileNo(KeyGenerator.getNextKey("ML_CORP_ATTACH", "FILE_NO"));
				this.corpAttachService.createCorpAttach(corpAttach);
				result.put("success", true);
				result.put("msg", "附件申请信息添加成功！");
			} else {
				result.put("success", true);
				result.put("msg", "附件申请信息添加失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "服务器端出现异常！");
		}

		return result;
	}

	public Map<String, Object> updateCorpAttach(MlCorpAttach corpAttach) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if (corpAttach != null) {
				this.corpAttachService.updateCorpAttach(corpAttach);
				result.put("success", true);
				result.put("msg", "附件申请信息修改成功！");
			} else {
				result.put("success", false);
				result.put("msg", "附件申请信息修改失败，服务器端未获得要修改的机构信息！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "附件申请信息修改失败，服务器端处理异常！");
		}

		return result;
	}

	/**
	 * 删除已上传的附件信息
	 * @param naturalAttach
	 * @return
	 */
	private boolean deleteAttachFile(MlCorpAttach corpAttach){
		boolean result = true;
		String attachFolder=null;
		
		try {
			if (corpAttach != null) {
				MlSysParam param=this.paramService.getParamByCode("ATTACH_SAVE_FOLDER");
				attachFolder=param.getParamVal();
				File file = new File(attachFolder+"/"+corpAttach.getPhysicalName());

				if (file.exists()) {
					file.delete();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}

		return result;
	}
	
	@RequestMapping(value = "deleteCorpAttach")
	@ResponseBody
	public Map<String, Object> deleteCorpAttach(String ids) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if ((ids != null) && (!"".equals(ids.trim()))) {
				List<MlCorpAttach> attachList=this.corpAttachService.getCorpAttachListByIds(ids);
				for(int i=0;i<attachList.size();++i){
					this.deleteAttachFile(attachList.get(i));
				}
				this.corpAttachService.deleteCorpAttach(ids);
				result.put("success", true);
				result.put("msg", "附件申请信息删除成功！");
			} else {
				result.put("success", false);
				result.put("msg", "附件申请信息删除失败，服务器端未获得要修改的机构信息！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "附件申请信息删除失败，服务器端处理异常！");
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
	public ResponseEntity<byte[]> downloadAttach(String fileName,String physicalName) throws IOException {
		String attachFolder=null;

		try {
			MlSysParam param=this.paramService.getParamByCode("ATTACH_SAVE_FOLDER");
			attachFolder=param.getParamVal();
			File file = new File(attachFolder + "/" + physicalName);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.setContentDispositionFormData("attachment", new String(fileName.getBytes("utf-8"), "ISO8859-1"));
			return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
