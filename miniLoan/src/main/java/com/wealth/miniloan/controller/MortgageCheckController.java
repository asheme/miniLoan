package com.wealth.miniloan.controller;

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

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.AppSummaryExtend;
import com.wealth.miniloan.entity.CorpAppInfo;
import com.wealth.miniloan.entity.DataGrid;
import com.wealth.miniloan.entity.MlAppCheckResult;
import com.wealth.miniloan.entity.MlAppSummary;
import com.wealth.miniloan.entity.MlCorpApp;
import com.wealth.miniloan.entity.MlNaturalApp;
import com.wealth.miniloan.entity.MlUser;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.entity.UnionLoanApp;
import com.wealth.miniloan.entity.User;
import com.wealth.miniloan.service.AppFlowServiceI;
import com.wealth.miniloan.service.AppSummaryServiceI;
import com.wealth.miniloan.service.CheckResultServiceI;
import com.wealth.miniloan.utils.Constant;
import com.wealth.miniloan.utils.key.KeyGenerator;

@Controller
@Transactional(rollbackFor={Exception.class})
@RequestMapping(value = "/mortgage/check")
@SessionAttributes("user")
public class MortgageCheckController extends BaseController {
	private AppSummaryServiceI appSummaryService = null;
	private CheckResultServiceI checkResultService = null;
	private AppFlowServiceI appFlowService=null;

	@Autowired
	public void setCheckResultService(CheckResultServiceI checkResultService) {
		this.checkResultService = checkResultService;
	}

	@Autowired
	public void setAppSummaryService(AppSummaryServiceI appSummaryService) {
		this.appSummaryService = appSummaryService;
	}

	@Autowired
	public void setAppFlowService(AppFlowServiceI appFlowService) {
		this.appFlowService = appFlowService;
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

	@RequestMapping(value = "mortgageCheckList")
	@ResponseBody
	public DataGrid getLoanAppList(Page page, UnionLoanApp unionLoanApp, @ModelAttribute("user") User user) {
		DataGrid resut = new DataGrid();
		PageList<UnionLoanApp> loanAppList = null;
		unionLoanApp.setCurrStep(Constant.STEP_MORT_ESTI);
		loanAppList = this.appSummaryService.getLoanAppPageList(page, unionLoanApp,user);

		if (loanAppList != null) {
			resut.setRows(loanAppList);
			resut.setTotal(Long.valueOf(loanAppList.getPaginator().getTotalCount()));
		}

		return resut;
	}

	@RequestMapping(value = "submitMortgageRevalue")
	@ResponseBody
	public Map<String, Object> submitMortgageRevalue(MlAppSummary as, MlAppCheckResult checkResult,@ModelAttribute("user") MlUser user) {
		Map<String, Object> result = new HashMap<String, Object>();
		String currStep=null;

		try {
			as = this.appSummaryService.getByPriKey(as);
			if (Constant.APP_STATUS_APPROVE.equals(checkResult.getStatus())) {
				currStep=this.appFlowService.getNextStep(as.getCurrStep());
				as.setPreviousStep(as.getCurrStep());
				as.setCurrStep(currStep);// 复核阶段
				as.setStatus(Constant.APP_STATUS_PROCESS);			
			} else if (Constant.APP_STATUS_BACK.equals(checkResult.getStatus())) {
				currStep=this.appFlowService.getFirstStep();
				as.setPreviousStep(as.getCurrStep());
				as.setCurrStep(currStep);// 返回第一步
				as.setStatus(Constant.APP_STATUS_BACK);				
			} else if (checkResult.getStatus() == null || "".equals(checkResult.getStatus())) {
				result.put("success", false);
				result.put("msg", "请选择核查结果！");
				return result;
			}
			as.setHandler(user.getUserId());
			as.setOperTime(new Date());
			this.appSummaryService.update(as);
			
			MlAppCheckResult appCheckResult = new MlAppCheckResult();
			appCheckResult.setAppNo(as.getAppNo());
			appCheckResult.setFinishTime(new Date());
			if(Constant.APP_STATUS_APPROVE.equals(checkResult.getStatus())){
				appCheckResult.setStatus(Constant.STEP_STATUS_END);
			}else{
				appCheckResult.setStatus(Constant.STEP_STATUS_BACK);
			}
			appCheckResult.setCheckDesc(checkResult.getCheckDesc());
			appCheckResult.setHandler(user.getUserId());
			appCheckResult.setOperTime(as.getOperTime());
			this.checkResultService.updateByLastStatus(appCheckResult);
			
			appCheckResult = new MlAppCheckResult();
			appCheckResult.setAppNo(as.getAppNo());
			appCheckResult.setCheckId(KeyGenerator.getNextKey("ML_APP_CHECK_RESULT", "CHECK_ID"));
			appCheckResult.setBeginTime(new Date());
			appCheckResult.setPreviousStep(as.getPreviousStep());
			appCheckResult.setCurrStep(as.getCurrStep());
			appCheckResult.setHandler(user.getUserId());
			if(Constant.APP_STATUS_APPROVE.equals(checkResult.getStatus())){
				appCheckResult.setCheckDesc("进入复核阶段");
				appCheckResult.setStatus(Constant.STEP_STATUS_PROCESS);
			}else{
				appCheckResult.setCheckDesc("申请信息被打回");
				appCheckResult.setStatus(Constant.STEP_STATUS_BACK);
			}
			appCheckResult.setHandler(user.getUserId());
			appCheckResult.setOperTime(as.getOperTime());
			this.checkResultService.create(appCheckResult);
			
			result.put("success", true);
			result.put("msg", "押品评估信息已成功提交！");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "押品评估信息提交失败，服务器端处理异常！");
		}
		return result;
	}
}
