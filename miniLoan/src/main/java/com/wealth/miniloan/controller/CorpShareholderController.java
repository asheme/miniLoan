package com.wealth.miniloan.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.DataGrid;
import com.wealth.miniloan.entity.MlShareholder;
import com.wealth.miniloan.entity.MlUser;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.CommonServiceI;
import com.wealth.miniloan.utils.key.KeyGenerator;

@Controller
@RequestMapping(value = "/corp/shareholder")
@SessionAttributes("user")
public class CorpShareholderController extends BaseController {
	private CommonServiceI<MlShareholder> shareholderService = null;

	@Autowired
	public void setShareholderService(CommonServiceI<MlShareholder> shareholderService) {
		this.shareholderService = shareholderService;
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

	@RequestMapping(value = "toShareholderList")
	@ResponseBody
	public ModelAndView ShareholderList(MlShareholder natural) {
		String appNo = natural.getAppNo();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("corpApp/shareholderList");
		modelAndView.addObject("appNo", appNo);
		return modelAndView;
	}

	@RequestMapping(value = "corpCheckShareholder")
	@ResponseBody
	public ModelAndView corpCheckShareholder(MlShareholder natural) {
		String appNo = natural.getAppNo();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("check/shareholderDetail");
		modelAndView.addObject("appNo", appNo);
		return modelAndView;
	}

	@RequestMapping(value = "shareholderList")
	@ResponseBody
	public DataGrid getShareholderList(Page page, MlShareholder Shareholder) {
		DataGrid resut = new DataGrid();
		PageList<MlShareholder> loanShareholderList = null;
		loanShareholderList = shareholderService.getPageList(page, Shareholder);

		if (loanShareholderList != null) {
			resut.setRows(loanShareholderList);
			resut.setTotal(Long.valueOf(loanShareholderList.getPaginator().getTotalCount()));
		}

		return resut;
	}

	@RequestMapping(value = "toAddShareholder")
	public ModelAndView toAddShareholder(MlShareholder shareholder) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("corpApp/modifyShareholder");
		modelAndView.addObject("flag", "ADD");
		modelAndView.addObject("shareholder", shareholder);
		return modelAndView;
	}

	@RequestMapping(value = "toUpdateShareholder")
	public ModelAndView toUpdateShareholder(MlShareholder shareholder) {
		try {
			shareholder = this.shareholderService.getByPriKey(shareholder);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("corpApp/modifyShareholder");
		modelAndView.addObject("flag", "UPDATE");
		modelAndView.addObject("shareholder", shareholder);
		return modelAndView;
	}

	@RequestMapping(value = "modifyShareholder")
	@ResponseBody
	public Map<String, Object> modifyShareholder(MlShareholder shareholder, String flag,
			@ModelAttribute("user") MlUser user) {
		Map<String, Object> result = new HashMap<String, Object>();

		if ("ADD".equals(flag)) {
			result = addShareholder(shareholder);
		} else if ("UPDATE".equals(flag)) {
			result = updateShareholder(shareholder);
		} else {
			result.put("success", false);
			result.put("msg", "股东信息添加异常，服务器端无法正常获取请求数据！");
		}

		return result;
	}

	public Map<String, Object> addShareholder(MlShareholder shareholder) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if (shareholder != null) {
				shareholder.setShareholderId(KeyGenerator.getNextKey("ML_SHAREHOLDER_INFO", "SHAREHOLDER_ID"));
				this.shareholderService.create(shareholder);
				result.put("success", true);
				result.put("msg", "股东申请信息添加成功！");
			} else {
				result.put("success", true);
				result.put("msg", "股东申请信息添加失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "服务器端出现异常！");
		}

		return result;
	}

	public Map<String, Object> updateShareholder(MlShareholder shareholder) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if (shareholder != null) {
				this.shareholderService.update(shareholder);
				result.put("success", true);
				result.put("msg", "股东申请信息修改成功！");
			} else {
				result.put("success", false);
				result.put("msg", "股东申请信息修改失败，服务器端未获得要修改的机构信息！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "股东申请信息修改失败，服务器端处理异常！");
		}

		return result;
	}

	@RequestMapping(value = "deleteShareholder")
	@ResponseBody
	public Map<String, Object> deleteShareholder(String ids) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if ((ids != null) && (!"".equals(ids.trim()))) {
				this.shareholderService.delete(ids);
				result.put("success", true);
				result.put("msg", "股东申请信息删除成功！");
			} else {
				result.put("success", false);
				result.put("msg", "股东申请信息删除失败，服务器端未获得要修改的机构信息！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "股东申请信息删除失败，服务器端处理异常！");
		}

		return result;
	}
}
