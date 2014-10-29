package com.wealth.miniloan.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.DataGrid;
import com.wealth.miniloan.entity.MlAppCheckResult;
import com.wealth.miniloan.entity.MlAppSummary;
import com.wealth.miniloan.entity.MlRole;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.entity.UnionLoanApp;
import com.wealth.miniloan.entity.User;
import com.wealth.miniloan.service.AppSummaryServiceI;
import com.wealth.miniloan.service.CheckResultServiceI;
import com.wealth.miniloan.utils.Constant;
import com.wealth.miniloan.utils.key.KeyGenerator;

@Controller
@Transactional(rollbackFor={Exception.class})
@RequestMapping(value = "/strategycheck/app")
@SessionAttributes("user")
public class StrategyCheckAppController extends BaseController {
	private AppSummaryServiceI appSummaryService = null;
	private CheckResultServiceI checkResultService = null;

	@Autowired
	public void setCheckResultService(CheckResultServiceI checkResultService) {
		this.checkResultService = checkResultService;
	}

	@Autowired
	public void setAppSummaryService(AppSummaryServiceI appSummaryService) {
		this.appSummaryService = appSummaryService;
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

	@RequestMapping(value = "strategycheckAppList")
	@ResponseBody
	public DataGrid getAppSummaryList(Page page, UnionLoanApp unionLoanApp, @ModelAttribute("user") User user) {
		DataGrid resut = new DataGrid();
		PageList<UnionLoanApp> loanAppList = null;
		unionLoanApp.setCurrStep(Constant.STEP_APP_APPR);
		loanAppList = this.appSummaryService.getLoanAppPageList(page, unionLoanApp,user);

		if (loanAppList != null) {
			resut.setRows(loanAppList);
			resut.setTotal(Long.valueOf(loanAppList.getPaginator().getTotalCount()));
		}

		return resut;
	}

	@RequestMapping(value = "toCheckApp")
	public ModelAndView toCheckApp(String appNo, String appType) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("appNo", appNo);
		modelAndView.addObject("appType", appType);
		modelAndView.setViewName("check/strategyCheckApp");
		return modelAndView;
	}

	@RequestMapping(value = "toStrategyCheckResult")
	public ModelAndView toStrategyCheckResult(String appNo) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("appNo", appNo);
		modelAndView.setViewName("check/strategyCheckResult");
		return modelAndView;
	}
	
	@RequestMapping(value = "appApprove")
	@ResponseBody
	public Map<String, Object> appApprove(String appNo, float loanLimit, float loanRate, MlAppCheckResult checkResult, @ModelAttribute("user") User user) {
		Map<String, Object> result = new HashMap<String, Object>();
		boolean hasApprovalAuthority=false;
		
		try {
			MlAppSummary obj = new MlAppSummary();
			obj.setAppNo(appNo);
			MlAppSummary as = this.appSummaryService.getByPriKey(obj);
			hasApprovalAuthority=hasApprovalAuthority(loanLimit, user);
			if (Constant.APP_STATUS_APPROVE.equals(checkResult.getStatus())) {
				if(!hasApprovalAuthority){
					result.put("success", false);
					result.put("msg", "当前角色没有审核权限, 请提交上级审批！");
					return result;
				}
				as.setManualResult(Constant.APP_STATUS_APPROVE);
				as.setLoanLimit(BigDecimal.valueOf(loanLimit));
				as.setLoanRate(BigDecimal.valueOf(loanRate));
				as.setReasonDesc(checkResult.getCheckDesc());
				as.setStatus(Constant.APP_STATUS_APPROVE);
				as.setFinishTime(new Date());
			}  else if(Constant.APP_STATUS_REJECT.equals(checkResult.getStatus())) {
				as.setManualResult(Constant.APP_STATUS_REJECT);
				as.setStatus(Constant.APP_STATUS_REJECT);
				as.setFinishTime(new Date());
			} else if (Constant.APP_STATUS_BACK.equals(checkResult.getStatus())) {
				as.setStatus(Constant.APP_STATUS_BACK);
			} else if (checkResult.getStatus() == null || "".equals(checkResult.getStatus())) {
				result.put("success", false);
				result.put("msg", "请选择审核结果！");
				return result;
			}
			as.setHandler(user.getUserId());
			as.setOperTime(new Date());
			this.appSummaryService.update(as);
			
			MlAppCheckResult appCheckResult = new MlAppCheckResult();
			appCheckResult.setAppNo(appNo);
			appCheckResult.setFinishTime(as.getOperTime());
			String checkDesc= checkResult.getCheckDesc();
			if(Constant.APP_STATUS_APPROVE.equals(checkResult.getStatus())){
				checkDesc="审批人确定审批额度："+loanLimit+"，批准利率："+loanRate+"，审批情况说明："+checkResult.getCheckDesc();
				appCheckResult.setStatus(Constant.STEP_STATUS_END);
			} else if(Constant.APP_STATUS_REJECT.equals(checkResult.getStatus())) {
				appCheckResult.setStatus(Constant.STEP_STATUS_REJECT);
			} else{
				appCheckResult.setStatus(Constant.STEP_STATUS_BACK);
			}
			appCheckResult.setCheckDesc(checkDesc);
			appCheckResult.setHandler(user.getUserId());
			appCheckResult.setOperTime(as.getOperTime());
			this.checkResultService.updateByLastStatus(appCheckResult);
			
			//批准操作，但权限不够
			if(Constant.APP_STATUS_APPROVE.equals(checkResult.getStatus())){
				if(!hasApprovalAuthority){
					appCheckResult = new MlAppCheckResult();
					appCheckResult.setAppNo(as.getAppNo());
					appCheckResult.setCheckId(KeyGenerator.getNextKey("ML_APP_CHECK_RESULT", "CHECK_ID"));
					appCheckResult.setBeginTime(as.getOperTime());
					appCheckResult.setPreviousStep(as.getPreviousStep());
					appCheckResult.setCurrStep(as.getCurrStep());
					appCheckResult.setStatus(Constant.APP_STATUS_BACK);
					appCheckResult.setHandler(user.getUserId());
					appCheckResult.setCheckDesc("无审批权限，提交到上级审批！");
					appCheckResult.setOperTime(as.getOperTime());
					this.checkResultService.create(appCheckResult);
				}
			}
			
			//打回操作时
			if(Constant.APP_STATUS_BACK.equals(checkResult.getStatus())){
				appCheckResult = new MlAppCheckResult();
				appCheckResult.setAppNo(as.getAppNo());
				appCheckResult.setCheckId(KeyGenerator.getNextKey("ML_APP_CHECK_RESULT", "CHECK_ID"));
				appCheckResult.setBeginTime(as.getOperTime());
				appCheckResult.setPreviousStep(as.getPreviousStep());
				appCheckResult.setCurrStep(as.getCurrStep());
				appCheckResult.setStatus(Constant.APP_STATUS_BACK);
				appCheckResult.setHandler(user.getUserId());
				appCheckResult.setCheckDesc("审核信息被打回");
				appCheckResult.setOperTime(as.getOperTime());
				this.checkResultService.create(appCheckResult);
			}
			
			result.put("success", true);
			result.put("msg", "审核信息提交成功！");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "审核信息提交失败，服务器端处理异常！");
		}
		return result;
	}
	
	@RequestMapping(value = "submitToHighLevel")
	@ResponseBody
	public Map<String, Object> submitToHighLevel(String appNo,float loanLimit, float loanRate, MlAppCheckResult checkResult, @ModelAttribute("user") User user) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			MlAppSummary obj = new MlAppSummary();
			obj.setAppNo(appNo);
			MlAppSummary as = this.appSummaryService.getByPriKey(obj);
			
			int currApprovalLevel = as.getCurrApproveLvl();
			int nextApprovalLevel = currApprovalLevel + 1;
			
			as.setStatus(Constant.APP_STATUS_PROCESS);
			as.setCurrApproveLvl(nextApprovalLevel);
			as.setHandler(user.getUserId());
			as.setOperTime(new Date());
			this.appSummaryService.update(as);
			
			result.put("success", true);
			result.put("msg", "信息提交成功！");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "信息提交失败，服务器端处理异常！");
		}
		return result;
	}

	
	public boolean hasApprovalAuthority(float loanLimit, User user){
		boolean result = false;
		try{
			BigDecimal ll = BigDecimal.valueOf(loanLimit);
			MlRole role = user.getCurrRole();
			if(role != null && role.getLimitMax() != null){
				if(ll.compareTo(role.getLimitMax()) <= 0){
					result = true;
				}
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return result;
	}
}
