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
import com.wealth.miniloan.entity.MlNaturalApp;
import com.wealth.miniloan.entity.MlNaturalCredit;
import com.wealth.miniloan.entity.MlUser;
import com.wealth.miniloan.service.CommonServiceI;

@Controller
@RequestMapping(value = "/natural/credit")
@SessionAttributes("user")
public class NaturalCreditController extends BaseController {
	private CommonServiceI<MlNaturalCredit> naturalCreditService = null;

	@Autowired
	public void setnNaturalCreditService(CommonServiceI<MlNaturalCredit> naturalCreditService) {
		this.naturalCreditService = naturalCreditService;
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
	public ModelAndView NaturalCredit(MlNaturalCredit natural, String Name) {
		String appNo = natural.getAppNo();
		try {
			natural = this.naturalCreditService.getByPriKey(natural);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView();
		if (natural != null) {
			modelAndView.setViewName("naturalApp/creditDetail");
			modelAndView.addObject("flag", "DETAIL");
			modelAndView.addObject("name", Name);
			modelAndView.addObject("naturalCredit", natural);
		} else {
			modelAndView.setViewName("/naturalApp/addNaturalCredit");
			modelAndView.addObject("appNo", appNo);
			modelAndView.addObject("flag", "ADD");
		}
		return modelAndView;
	}

	@RequestMapping(value = "naturalCreditCheck")
	@ResponseBody
	public ModelAndView naturalCreditCheck(MlNaturalCredit natural) {
		String appNo = natural.getAppNo();
		try {
			natural = this.naturalCreditService.getByPriKey(natural);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("check/naturalCreditDetail");
		modelAndView.addObject("flag", "DETAIL");
		modelAndView.addObject("naturalCredit", natural);
		return modelAndView;
	}

	@RequestMapping(value = "getCredit")
	@ResponseBody
	public int getCredit(MlNaturalCredit natural) {
		try {
			natural = this.naturalCreditService.getByPriKey(natural);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (natural != null) {
			return 1;
		} else {
			return 0;
		}
	}

	@RequestMapping(value = "toModifyNaturalCredit")
	public ModelAndView toModifyNaturalApp(MlNaturalCredit naturalCredit){
		ModelAndView modelAndView = new ModelAndView();
		
		String appNo=naturalCredit.getAppNo();
		modelAndView.setViewName("naturalApp/modifyNaturalCredit");
		naturalCredit = this.naturalCreditService.getByPriKey(naturalCredit);
		if(naturalCredit!=null){
			modelAndView.addObject("flag", "UPDATE");
		}else{
			naturalCredit=new MlNaturalCredit();
			naturalCredit.setAppNo(appNo);
			modelAndView.addObject("flag", "ADD");
		}
		modelAndView.addObject("naturalCredit", naturalCredit);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "modifyNaturalCredit")
	@ResponseBody
	public Map<String, Object> modifynaturalCredit(MlNaturalCredit naturalCredit, String flag,
			@ModelAttribute("user") MlUser user) {
		Map<String, Object> result = new HashMap<String, Object>();

		if ("ADD".equals(flag)) {
			result = addNaturalCredit(naturalCredit);
		} else if ("UPDATE".equals(flag)) {
			result = updateNaturalCredit(naturalCredit);
		} else {
			result.put("success", false);
			result.put("msg", "征信信息添加异常，服务器端无法正常获取请求数据！");
		}

		return result;
	}

	public Map<String, Object> addNaturalCredit(MlNaturalCredit naturalCredit) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if (naturalCredit != null) {
				this.naturalCreditService.create(naturalCredit);
				result.put("success", true);
				result.put("msg", "征信申添加成功！");
			} else {
				result.put("success", true);
				result.put("msg", "征信添加失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "服务器端出现异常！");
		}

		return result;
	}

	public Map<String, Object> updateNaturalCredit(MlNaturalCredit naturalCredit) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if (naturalCredit != null) {
				this.naturalCreditService.update(naturalCredit);
				result.put("success", true);
				result.put("msg", "征信修改成功！");
			} else {
				result.put("success", false);
				result.put("msg", "征信修改失败，服务器端未获得要修改的机构信息！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "征信修改失败，服务器端处理异常！");
		}

		return result;
	}
}
