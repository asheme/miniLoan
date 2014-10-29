package com.wealth.miniloan.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.wealth.miniloan.entity.InteCheckExtend;
import com.wealth.miniloan.entity.MlInteCheckItem;
import com.wealth.miniloan.service.IntegrityCheckServiceI;

@Controller
@RequestMapping(value = "/integrity")
@SessionAttributes("user")
public class IntegrityCheckController {
	private IntegrityCheckServiceI integrityCheckService;
	
	@Autowired
	public void setIntegrityCheckService(
			IntegrityCheckServiceI integrityCheckService) {
		this.integrityCheckService = integrityCheckService;
	}
	
	@RequestMapping(value = "toIntegrityCheck")
	public ModelAndView toIntegrityCheck(String appNo,String appType){
		List<InteCheckExtend> integrityCheckList = this.integrityCheckService.getIntegrityCheckList(appNo,appType);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("integrityCheckList", integrityCheckList);
		modelAndView.addObject("appNo", appNo);
		modelAndView.addObject("appType", appType);
		modelAndView.setViewName("check/integrityCheck");
		return modelAndView;
	}
	
	@RequestMapping(value = "saveIntegrityCheck")
	@ResponseBody
	public Map<String, Object> saveIntegrityCheck(String appNo,String appType,String inteCheckStr) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if ((inteCheckStr != null) && (!"".equals(inteCheckStr.trim()))) {
				if(this.integrityCheckService.saveIntegrityCheck(appNo,appType,inteCheckStr)){
					result.put("success", true);
					result.put("msg", "完整性检查保存成功！");
				}else{
					result.put("success", true);
					result.put("msg", "完整性检查保存失败！");
				}
			} else {
				result.put("success", false);
				result.put("msg", "完整性检查信息保存失败，服务器端未获得要删除的完整性检查信息！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "完整性检查信息保存失败，服务器端处理异常！");
		}

		return result;
	}
	
	@RequestMapping(value = "viewIntegrityCheck")
	public ModelAndView viewIntegrityCheck(String appNo,String appType) {
		List<InteCheckExtend> integrityCheckList = this.integrityCheckService.getIntegrityCheckList(appNo,appType);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("integrityCheckList", integrityCheckList);
		modelAndView.addObject("appNo", appNo);
		modelAndView.addObject("appType", appType);
		modelAndView.setViewName("check/viewIntegrityCheck");
		return modelAndView;
	}
}
