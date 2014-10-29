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
import com.wealth.miniloan.entity.AppSummaryExtend;
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
import com.wealth.miniloan.service.FraudCheckResultServiceI;
import com.wealth.miniloan.utils.Constant;
import com.wealth.miniloan.utils.key.KeyGenerator;

@Controller
@RequestMapping(value = "/recheck/app")
@SessionAttributes("user")
public class ReCheckAppController extends BaseController {
	private AppSummaryServiceI appSummaryService = null;
	private CheckResultServiceI checkResultService = null;
	private AppFlowServiceI appFlowService=null;
	private FraudCheckResultServiceI fraudCheckResultService = null;

	@Autowired
	public void setFraudCheckResultService(
			FraudCheckResultServiceI fraudCheckResultService) {
		this.fraudCheckResultService = fraudCheckResultService;
	}
	
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

	@RequestMapping(value = "recheckAppList")
	@ResponseBody
	public DataGrid getAppSummaryList(Page page, UnionLoanApp unionLoanApp, @ModelAttribute("user") User user) {
		DataGrid resut = new DataGrid();
		PageList<UnionLoanApp> loanAppList = null;
		unionLoanApp.setCurrStep(Constant.STEP_APP_CHECK);
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
		modelAndView.setViewName("check/checkLoanApp");
		return modelAndView;
	}

	@RequestMapping(value = "toShowDetail")
	public ModelAndView toShowDetail(String appNo) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("naturalApp/detailNatural");
		return modelAndView;
	}

	@RequestMapping(value = "naturalAppDetail")
	public ModelAndView naturalAppDetail(String appNo) {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("naturalApp/naturalAppDetail");
		return modelAndView;
	}

	@RequestMapping(value = "modifyNaturalApp")
	@ResponseBody
	public Map<String, Object> modifyNaturalApp(MlAppSummary naturalApp, String flag,
			@ModelAttribute("user") MlUser user) {
		Map<String, Object> result = new HashMap<String, Object>();

		if ("ADD".equals(flag)) {
			result = addNaturalApp(naturalApp);
		} else if ("UPDATE".equals(flag)) {
			result = updateNaturalApp(naturalApp);
		} else {
			result.put("success", false);
			result.put("msg", "自然人信息添加异常，服务器端无法正常获取请求数据！");
		}

		return result;
	}

	public Map<String, Object> addNaturalApp(MlAppSummary naturalApp) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if (naturalApp != null) {
				naturalApp.setAppNo(super.getAppNo());
				this.appSummaryService.create(naturalApp);
				result.put("success", true);
				result.put("msg", "自然人申请信息添加成功！");
			} else {
				result.put("success", true);
				result.put("msg", "自然人申请信息添加失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "服务器端出现异常！");
		}

		return result;
	}

	public Map<String, Object> updateNaturalApp(MlAppSummary naturalApp) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if (naturalApp != null) {
				this.appSummaryService.update(naturalApp);
				result.put("success", true);
				result.put("msg", "自然人申请信息修改成功！");
			} else {
				result.put("success", false);
				result.put("msg", "自然人申请信息修改失败，服务器端未获得要修改的机构信息！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "自然人申请信息修改失败，服务器端处理异常！");
		}

		return result;
	}

	@RequestMapping(value = "deleteNaturalApp")
	@ResponseBody
	public Map<String, Object> deleteNaturalApp(String ids) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if ((ids != null) && (!"".equals(ids.trim()))) {
				this.appSummaryService.delete(ids);
				result.put("success", true);
				result.put("msg", "自然人申请信息删除成功！");
			} else {
				result.put("success", false);
				result.put("msg", "自然人申请信息删除失败，服务器端未获得要修改的机构信息！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "自然人申请信息删除失败，服务器端处理异常！");
		}

		return result;
	}

	@RequestMapping(value = "submitToInspect")
	@ResponseBody
	public Map<String, Object> submitToInspect(MlAppSummary as, MlAppCheckResult checkResult,@ModelAttribute("user") MlUser user) {
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
				result.put("msg", "请选择审核结果！");
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
			appCheckResult.setStatus(Constant.STEP_STATUS_PROCESS);
			appCheckResult.setHandler(user.getUserId());
			if(Constant.APP_STATUS_APPROVE.equals(checkResult.getStatus())){
				appCheckResult.setCheckDesc("进入人工核查阶段");
			}else{
				appCheckResult.setCheckDesc("申请信息被打回");
			}
			appCheckResult.setHandler(user.getUserId());
			appCheckResult.setOperTime(as.getOperTime());
			this.checkResultService.create(appCheckResult);
			
			//重新生成欺诈检查结果
			if (Constant.APP_STATUS_APPROVE.equals(checkResult.getStatus())) {
				fraudCheckResultService.deleteFraudCheck(as.getAppNo());
				fraudCheckResultService.dealFraudCheck(as.getAppNo());
			}
			
			result.put("success", true);
			result.put("msg", "申请信息复核完成，提交成功！");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "审核信息提交失败，服务器端处理异常！");
		}
		return result;
	}
}
