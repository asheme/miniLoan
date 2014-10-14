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
import com.wealth.miniloan.entity.MlNaturalAttach;
import com.wealth.miniloan.entity.MlSysParam;
import com.wealth.miniloan.entity.MlUser;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.LoanNaturalAttachServiceI;
import com.wealth.miniloan.service.ParamServiceI;
import com.wealth.miniloan.utils.key.KeyGenerator;

@Controller
@RequestMapping(value = "/natural/attach")
@SessionAttributes("user")
public class NaturalAttachController extends BaseController {
	private LoanNaturalAttachServiceI naturalAttachService = null;
	private ParamServiceI paramService = null;

	@Autowired
	public void setNaturalAttachService(LoanNaturalAttachServiceI naturalAttachService) {
		this.naturalAttachService = naturalAttachService;
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

	@RequestMapping(value = "toNaturalAttachList")
	@ResponseBody
	public ModelAndView AttachList(MlNaturalAttach naturalAttach) {
		String appNo = naturalAttach.getAppNo();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("naturalApp/naturalAttachList");
		modelAndView.addObject("appNo", appNo);
		return modelAndView;
	}

	@RequestMapping(value = "naturalAttachList")
	@ResponseBody
	public DataGrid getNaturalAttachList(Page page, MlNaturalAttach naturalAttach) {
		DataGrid resut = new DataGrid();
		PageList<MlNaturalAttach> loanNaturalAttachList = null;
		loanNaturalAttachList = naturalAttachService.getNaturalAttachPageList(page, naturalAttach);

		if (loanNaturalAttachList != null) {
			resut.setRows(loanNaturalAttachList);
			resut.setTotal(Long.valueOf(loanNaturalAttachList.getPaginator().getTotalCount()));
		}

		return resut;
	}

	@RequestMapping("naturalCheckAttach")
	@ResponseBody
	public ModelAndView naturalCheckAttach(String appNo) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("check/naturalAttachDetail");
		modelAndView.addObject("flag", "CHECK");
		modelAndView.addObject("appNo", appNo);
		return modelAndView;

	}

	@RequestMapping(value = "toAddNaturalAttach")
	public ModelAndView toAddNaturalAttach(MlNaturalAttach naturalAttach) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("naturalApp/modifyNaturalAttach");
		modelAndView.addObject("flag", "ADD");
		modelAndView.addObject("naturalAttach", naturalAttach);
		return modelAndView;
	}

	@RequestMapping(value = "toUpdateNaturalAttach")
	public ModelAndView toUpdateNaturalAttach(MlNaturalAttach naturalAttach) {
		try {
			naturalAttach = this.naturalAttachService.getNaturalAttachByPriKey(naturalAttach);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("naturalApp/modifyNaturalAttach");
		modelAndView.addObject("flag", "UPDATE");
		modelAndView.addObject("naturalAttach", naturalAttach);
		return modelAndView;
	}

	@RequestMapping(value = "modifyNaturalattach", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> modifyNaturalattach(MlNaturalAttach naturalAttach,
			@RequestParam("file") MultipartFile[] file, String flag, @ModelAttribute("user") MlUser user) {
		String fileName=file[0].getOriginalFilename();
		String prefix=fileName.substring(fileName.lastIndexOf(".")+1);
		DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");		
		String physicalFileName="NAA_"+user.getUserId()+"_"+format.format(new Date())+"."+prefix;
		boolean uploadFlag = uploadAttach(file,physicalFileName);

		if (file != null && file[0] != null) {
			naturalAttach.setFileName(fileName);
		}
		Map<String, Object> result = new HashMap<String, Object>();
		if ("ADD".equals(flag)) {
			naturalAttach.setPhysicalName(physicalFileName);
			result = addNaturalAttach(naturalAttach);
		} else if ("UPDATE".equals(flag)) {
			deleteAttachFile(naturalAttach);
			naturalAttach.setPhysicalName(physicalFileName);
			result = updateNaturalAttach(naturalAttach);
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

	/**
	 * 删除已上传的附件信息
	 * @param naturalAttach
	 * @return
	 */
	private boolean deleteAttachFile(MlNaturalAttach naturalAttach){
		boolean result = true;
		String attachFolder=null;
		
		try {
			if (naturalAttach != null) {
				MlSysParam param=this.paramService.getParamByCode("ATTACH_SAVE_FOLDER");
				attachFolder=param.getParamVal();
				File file = new File(attachFolder+"/"+naturalAttach.getPhysicalName());

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
	
	public Map<String, Object> addNaturalAttach(MlNaturalAttach naturalAttach) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if (naturalAttach != null) {
				naturalAttach.setFileNo(KeyGenerator.getNextKey("ML_NATURAL_ATTACH", "FILE_NO"));
				this.naturalAttachService.createNaturalAttach(naturalAttach);
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

	public Map<String, Object> updateNaturalAttach(MlNaturalAttach naturalAttach) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if (naturalAttach != null) {
				this.naturalAttachService.updateNaturalAttach(naturalAttach);
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

	@RequestMapping(value = "deleteNaturalAttach")
	@ResponseBody
	public Map<String, Object> deleteNaturalAttach(String ids) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if ((ids != null) && (!"".equals(ids.trim()))) {
				List<MlNaturalAttach> attachList=this.naturalAttachService.getNaturalAttachListByIds(ids);
				for(int i=0;i<attachList.size();++i){
					this.deleteAttachFile(attachList.get(i));
				}
				this.naturalAttachService.deleteNaturalAttach(ids);
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
