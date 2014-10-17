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

import com.wealth.miniloan.entity.MlCorpCredit;
import com.wealth.miniloan.entity.MlNaturalCredit;
import com.wealth.miniloan.entity.MlUser;
import com.wealth.miniloan.service.CommonServiceI;

@Controller
@RequestMapping(value = "/corp/credit")
@SessionAttributes("user")
public class CorpCreditController extends BaseController {
	private CommonServiceI<MlCorpCredit> corpCreditService = null;

	@Autowired
	public void setCorpCreditService(CommonServiceI<MlCorpCredit> corpCreditService) {
		this.corpCreditService = corpCreditService;
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

	@RequestMapping(value = "creditDetail")
	@ResponseBody
	public ModelAndView CorpCredit(MlCorpCredit natural, String name) {
		String appNo = natural.getAppNo();
		try {
			natural = this.corpCreditService.getByPriKey(natural);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView();
		if (natural != null) {
			modelAndView.setViewName("corpApp/corpCreditDetail");
			modelAndView.addObject("flag", "DETAIL");
			modelAndView.addObject("name", name);
			modelAndView.addObject("corpCredit", natural);
		} else {
			modelAndView.addObject("appNo", appNo);
			modelAndView.addObject("flag", "ADD");
			modelAndView.setViewName("corpApp/addCropCredit");
		}

		return modelAndView;
	}

	@RequestMapping(value = "viewCorpCredit")
	@ResponseBody
	public ModelAndView corpCreditCheck(MlCorpCredit corpCredit) {
		try {
			corpCredit = this.corpCreditService.getByPriKey(corpCredit);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("corpApp/corpCreditDetail");
		modelAndView.addObject("corpCredit", corpCredit);
		return modelAndView;
	}

	@RequestMapping(value = "toModifyCorpCredit")
	@ResponseBody
	public ModelAndView toModifyCorpCredit(MlCorpCredit corpCredit){
		ModelAndView modelAndView = new ModelAndView();
		
		String appNo=corpCredit.getAppNo();
		modelAndView.setViewName("corpApp/modifyCorpCredit");
		corpCredit = this.corpCreditService.getByPriKey(corpCredit);
		if(corpCredit!=null){
			modelAndView.addObject("flag", "UPDATE");
		}else{
			corpCredit=new MlCorpCredit();
			corpCredit.setAppNo(appNo);
			modelAndView.addObject("flag", "ADD");
		}
		modelAndView.addObject("corpCredit", corpCredit);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "modifyCorpCredit")
	@ResponseBody
	public Map<String, Object> modifyCorpCredit(MlCorpCredit corpCredit, String flag,
			@ModelAttribute("user") MlUser user) {
		Map<String, Object> result = new HashMap<String, Object>();

		if ("ADD".equals(flag)) {
			result = addCorpCredit(corpCredit);
		} else if ("UPDATE".equals(flag)) {
			result = updateCorpCredit(corpCredit);
		} else {
			result.put("success", false);
			result.put("msg", "征信信息添加异常，服务器端无法正常获取请求数据！");
		}

		return result;
	}

	public Map<String, Object> addCorpCredit(MlCorpCredit CorpCredit) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if (CorpCredit != null) {
				this.corpCreditService.create(CorpCredit);
				result.put("success", true);
				result.put("msg", "征信征信申添加成功！");
			} else {
				result.put("success", true);
				result.put("msg", "征信征信添加失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "服务器端出现异常！");
		}

		return result;
	}

	public Map<String, Object> updateCorpCredit(MlCorpCredit corpCredit) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if (corpCredit != null) {
				this.corpCreditService.update(corpCredit);
				result.put("success", true);
				result.put("msg", "征信征信修改成功！");
			} else {
				result.put("success", false);
				result.put("msg", "征信征信修改失败，服务器端未获得要修改的机构信息！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "征信征信修改失败，服务器端处理异常！");
		}

		return result;
	}
}
