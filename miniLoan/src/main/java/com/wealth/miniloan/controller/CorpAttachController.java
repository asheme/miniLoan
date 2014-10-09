package com.wealth.miniloan.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import com.wealth.miniloan.entity.MlUser;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.CommonServiceI;
import com.wealth.miniloan.utils.key.KeyGenerator;

@Controller
@RequestMapping(value = "/corp/attach")
@SessionAttributes("user")
public class CorpAttachController extends BaseController {
	private CommonServiceI<MlCorpAttach> corpAttachService = null;

	@Autowired
	public void setCorpAttachService(CommonServiceI<MlCorpAttach> corpAttachService) {
		this.corpAttachService = corpAttachService;
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
		loanCorpAttachList = corpAttachService.getPageList(page, corpAttach);

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
			corpAttach = this.corpAttachService.getByPriKey(corpAttach);
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
			String flag, @ModelAttribute("user") MlUser user, HttpServletRequest request) {
		boolean uploadFlag = uploadAttach(corpAttach, file, request);

		if (file != null && file[0] != null) {
			corpAttach.setFileName(file[0].getOriginalFilename());
		}
		Map<String, Object> result = new HashMap<String, Object>();
		if ("ADD".equals(flag)) {
			result = addCorpAttach(corpAttach);
		} else if ("UPDATE".equals(flag)) {
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
				this.corpAttachService.create(corpAttach);
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
				this.corpAttachService.update(corpAttach);
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

	@RequestMapping(value = "deleteCorpAttach")
	@ResponseBody
	public Map<String, Object> deleteCorpAttach(String ids) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if ((ids != null) && (!"".equals(ids.trim()))) {
				this.corpAttachService.delete(ids);
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

	public boolean uploadAttach(MlCorpAttach corpAttach, MultipartFile[] uploadFile, HttpServletRequest request) {
		boolean flag = true;
		try {
			if (uploadFile != null) {
				// String path =
				// request.getSession().getServletContext().getRealPath("./attachment");
				String path = "D:/miniloan/./attachment";
				File file = new File(path);

				if (!file.exists() && !file.isDirectory()) {
					file.mkdirs();
				}
				for (MultipartFile tmpFile : uploadFile) {
					String newFileName = tmpFile.getOriginalFilename();
					FileCopyUtils.copy(tmpFile.getBytes(), new File(path + "/" + newFileName));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}

		return flag;
	}

	@RequestMapping("downloadAttach")
	public ResponseEntity<byte[]> downloadAttach(HttpServletRequest request, String fileName) throws IOException {
		try {
			// String path =
			// request.getSession().getServletContext().getRealPath("./attachment");
			String path = "D:/miniloan/./attachment";
			File file = new File(path + "/" + fileName);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
			headers.setContentDispositionFormData("attachment", new String(fileName.getBytes("utf-8"), "ISO8859-1"));
			return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
		} catch (Exception e) {
			return null;
		}

	}
}
