package com.wealth.miniloan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.wealth.miniloan.entity.MlAppStrategyResult;
import com.wealth.miniloan.entity.MlCorpCredit;
import com.wealth.miniloan.entity.MlSysDecisionExclude;
import com.wealth.miniloan.service.StrategyServiceI;

@Controller
@RequestMapping(value = "/strategy")
@SessionAttributes("user")
public class SysDecisionController {
	private StrategyServiceI strategyService;

	@Autowired
	public void setStrategyService(StrategyServiceI strategyService) {
		this.strategyService = strategyService;
	}
	
	@RequestMapping(value = "viewSysDecisionResult")
	public ModelAndView viewSysDecisionResult(String appNo) {
		MlAppStrategyResult appStrategyResult=null;;
		List<MlSysDecisionExclude> sysDecisionExcludeList=null;
		
		try {
			appStrategyResult=strategyService.getStrategyResultByPrikey(appNo);
			sysDecisionExcludeList=strategyService.getSysDecisionExcludeList(appNo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("check/viewStrategyResult");
		modelAndView.addObject("appStrategyResult", appStrategyResult);
		modelAndView.addObject("sysDecisionExcludeList", sysDecisionExcludeList);
		return modelAndView;
	}

}
