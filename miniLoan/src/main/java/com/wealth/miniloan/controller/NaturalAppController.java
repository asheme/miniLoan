package com.wealth.miniloan.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
import com.wealth.miniloan.entity.MlMortgageInfo;
import com.wealth.miniloan.entity.MlMortgageInfoExample;
import com.wealth.miniloan.entity.MlNaturalApp;
import com.wealth.miniloan.entity.MlUser;
import com.wealth.miniloan.entity.NaturalAppInfo;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.AppFlowServiceI;
import com.wealth.miniloan.service.AppSummaryServiceI;
import com.wealth.miniloan.service.CheckResultServiceI;
import com.wealth.miniloan.service.CommonServiceI;
import com.wealth.miniloan.service.FraudCheckResultServiceI;
import com.wealth.miniloan.service.LoanNaturalAppServiceI;
import com.wealth.miniloan.service.StrategyServiceI;
import com.wealth.miniloan.utils.Constant;
import com.wealth.miniloan.utils.key.KeyGenerator;

@Controller
@RequestMapping(value = "/natural/app")
@SessionAttributes("user")
@Transactional(rollbackFor={Exception.class})
public class NaturalAppController extends BaseController {
	private LoanNaturalAppServiceI naturalAppService = null;
	private AppSummaryServiceI appSummaryService = null;
	private CommonServiceI<MlMortgageInfo> mortgageInfoService = null;
	private AppFlowServiceI appFlowService = null;
	private CheckResultServiceI checkResultService = null;
	private StrategyServiceI strategyService = null;
	private FraudCheckResultServiceI fraudCheckResultService = null;

	@Autowired
	public void setFraudCheckResultService(
			FraudCheckResultServiceI fraudCheckResultService) {
		this.fraudCheckResultService = fraudCheckResultService;
	}
	
	@Autowired
	public void setMortgageInfoService(
			CommonServiceI<MlMortgageInfo> mortgageInfoService) {
		this.mortgageInfoService = mortgageInfoService;
	}

	@Autowired
	public void setNaturalAppService(LoanNaturalAppServiceI naturalAppService) {
		this.naturalAppService = naturalAppService;
	}

	@Autowired
	public void setAppSummaryService(AppSummaryServiceI appSummaryService) {
		this.appSummaryService = appSummaryService;
	}

	@Autowired
	public void setAppFlowService(AppFlowServiceI appFlowService) {
		this.appFlowService = appFlowService;
	}

	@Autowired
	public void setCheckResultService(CheckResultServiceI checkResultService) {
		this.checkResultService = checkResultService;
	}

	@Autowired
	public void setStrategyService(StrategyServiceI strategyService) {
		this.strategyService = strategyService;
	}

	/*
	 * 表单提交日期绑定
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}

	@RequestMapping(value = "naturalAppList")
	@ResponseBody
	public DataGrid getNaturalAppList(Page page, NaturalAppInfo naturalApp) {
		DataGrid resut = new DataGrid();
		PageList<NaturalAppInfo> loanNaturalAppList = null;
		loanNaturalAppList = naturalAppService.getNatrualAppPageList(page,
				naturalApp);

		if (loanNaturalAppList != null) {
			resut.setRows(loanNaturalAppList);
			resut.setTotal(Long.valueOf(loanNaturalAppList.getPaginator()
					.getTotalCount()));
		}

		return resut;
	}

	@RequestMapping(value = "naturalApp")
	public ModelAndView naturalApp(String flag, String appNo) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("naturalApp/naturalApp");
		modelAndView.addObject("flag", flag);
		if ("UPDATE".equals(flag)) {
			modelAndView.addObject("appNo", appNo);
		}
		return modelAndView;
	}

	@RequestMapping(value = "toModifyNaturalApp")
	public ModelAndView toModifyNaturalApp(String flag, MlNaturalApp naturalApp) {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("naturalApp/modifyNaturalApp");
		modelAndView.addObject("flag", flag);
		if ("UPDATE".equals(flag)) {
			naturalApp = this.naturalAppService.getByPriKey(naturalApp);
			modelAndView.addObject("naturalApp", naturalApp);
		}

		return modelAndView;
	}

	@RequestMapping(value = "toShowDetail")
	public ModelAndView toShowDetail(String appNo) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("naturalApp/detailNatural");
		return modelAndView;
	}

	@RequestMapping(value = "viewNaturalApp")
	@ResponseBody
	public ModelAndView viewNaturalApp(MlNaturalApp naturalApp) {
		ModelAndView modelAndView = new ModelAndView();
		naturalApp = this.naturalAppService.getByPriKey(naturalApp);
		modelAndView.addObject("appNo", naturalApp.getAppNo());
		modelAndView.setViewName("naturalApp/naturalAppDetail");
		modelAndView.addObject("naturalApp", naturalApp);
		return modelAndView;
	}

	@RequestMapping(value = "modifyNaturalApp")
	@ResponseBody
	public Map<String, Object> modifyNaturalApp(String flag,
			MlNaturalApp naturalApp, @ModelAttribute("user") MlUser user) {
		Map<String, Object> result = new HashMap<String, Object>();

		if ("ADD".equals(flag)) {
			result = addNaturalApp(naturalApp, user);
		} else if ("UPDATE".equals(flag)) {
			result = updateNaturalApp(naturalApp);
		} else {
			result.put("success", false);
			result.put("msg", "自然人信息添加异常，服务器端无法正常获取请求数据！");
		}

		return result;
	}

	public Map<String, Object> addNaturalApp(MlNaturalApp naturalApp,
			MlUser user) {
		Map<String, Object> result = new HashMap<String, Object>();
		String currStep = null;

		try {
			if (naturalApp != null) {
				naturalApp.setAppNo(super.getAppNo());
				this.naturalAppService.create(naturalApp);
				currStep = this.appFlowService.getFirstStep();

				// 保存概要信息
				MlAppSummary as = new MlAppSummary();
				as.setAppNo(naturalApp.getAppNo());
				as.setAppType(Constant.APP_TYPE_NATURAL);
				as.setCurrStep(currStep);
				as.setStatus(Constant.APP_STATUS_PROCESS);
				as.setEnterTime(new Date());
				as.setHandler(user.getUserId());
				as.setOperTime(as.getEnterTime());
				this.appSummaryService.create(as);

				// 保存check result信息
				MlAppCheckResult appCheckResult = new MlAppCheckResult();
				appCheckResult.setAppNo(as.getAppNo());
				appCheckResult.setCheckId(KeyGenerator.getNextKey(
						"ML_APP_CHECK_RESULT", "CHECK_ID"));
				appCheckResult.setBeginTime(as.getEnterTime());
				appCheckResult.setCurrStep(as.getCurrStep());
				appCheckResult.setStatus(Constant.STEP_STATUS_PROCESS);
				appCheckResult.setHandler(user.getUserId());
				appCheckResult.setCheckDesc("申请信息录入");
				appCheckResult.setOperTime(as.getEnterTime());
				checkResultService.create(appCheckResult);

				result.put("success", true);
				result.put("appNo", naturalApp.getAppNo());
				result.put("msg", "自然人申请信息添加成功！");
			} else {
				result.put("success", false);
				result.put("msg", "自然人申请信息添加失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "服务器端出现异常！");
		}

		return result;
	}

	public Map<String, Object> updateNaturalApp(MlNaturalApp naturalApp) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if (naturalApp != null) {
				this.naturalAppService.update(naturalApp);
				result.put("success", true);
				result.put("msg", "自然人申请信息修改成功！");
			} else {
				result.put("success", false);
				result.put("msg", "自然人申请信息修改失败，服务器端未获得要修改的申请信息！");
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
				this.naturalAppService.delete(ids);
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

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "submitApp")
	@ResponseBody
	public Map<String, Object> submitApp(MlAppSummary as,
			@ModelAttribute("user") MlUser user) {
		Map<String, Object> result = new HashMap<String, Object>();
		String currStep = null;

		try {
			as = this.appSummaryService.getByPriKey(as);

			MlMortgageInfoExample example = new MlMortgageInfoExample();
			MlMortgageInfoExample.Criteria c = example.createCriteria();
			c.andAppNoEqualTo(as.getAppNo());
			List<MlMortgageInfo> nmList = new ArrayList<MlMortgageInfo>();
			nmList = (List<MlMortgageInfo>) this.mortgageInfoService
					.getByExample(example);
			if (nmList != null && nmList.size() > 0) {
				currStep = this.appFlowService.getNextStep(as.getCurrStep());
				as.setPreviousStep(as.getCurrStep());
				as.setCurrStep(currStep);// 押品审核
				as.setStatus(Constant.APP_STATUS_PROCESS);
			} else {
				currStep = this.appFlowService.getNextStep(as.getCurrStep());
				currStep = this.appFlowService.getNextStep(currStep);
				as.setPreviousStep(as.getCurrStep());
				as.setCurrStep(currStep); // 进入申请复核步骤
				as.setStatus(Constant.APP_STATUS_PROCESS);
			}
			as.setHandler(user.getUserId());
			as.setOperTime(new Date());
			this.appSummaryService.update(as);

			MlAppCheckResult appCheckResult = new MlAppCheckResult();
			appCheckResult.setAppNo(as.getAppNo());
			appCheckResult.setFinishTime(new Date());
			appCheckResult.setStatus(Constant.STEP_STATUS_END);
			appCheckResult.setCheckDesc("申请录入已提交");
			appCheckResult.setHandler(user.getUserId());
			appCheckResult.setOperTime(as.getOperTime());
			this.checkResultService.updateByLastStatus(appCheckResult);

			appCheckResult = new MlAppCheckResult();
			appCheckResult.setAppNo(as.getAppNo());
			appCheckResult.setCheckId(KeyGenerator.getNextKey(
					"ML_APP_CHECK_RESULT", "CHECK_ID"));
			appCheckResult.setBeginTime(new Date());
			appCheckResult.setPreviousStep(as.getPreviousStep());
			appCheckResult.setCurrStep(as.getCurrStep());
			appCheckResult.setStatus(Constant.STEP_STATUS_PROCESS);
			appCheckResult.setHandler(user.getUserId());
			if (Constant.STEP_MORT_ESTI.equals(appCheckResult.getCurrStep())) {
				appCheckResult.setCheckDesc("进入押品评估阶段");
			} else if (Constant.STEP_APP_CHECK.equals(appCheckResult
					.getCurrStep())) {
				appCheckResult.setCheckDesc("进入申请复核阶段");
			}
			appCheckResult.setOperTime(as.getOperTime());
			this.checkResultService.create(appCheckResult);

			result.put("success", true);
			result.put("msg", "申请信息提交成功！");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "自然人申请信息提交失败，服务器端处理异常！");
		}
		return result;
	}

	@RequestMapping(value = "submitToFinal")
	@ResponseBody
	public Map<String, Object> submitToFinal(MlAppSummary as,
			@ModelAttribute("user") MlUser user) {
		Map<String, Object> result = new HashMap<String, Object>();
		String currStep = null;

		try {
			as = this.appSummaryService.getByPriKey(as);
			currStep = this.appFlowService.getEndStep();
			as.setPreviousStep(as.getCurrStep());
			as.setCurrStep(currStep);// 终审
			as.setStatus(Constant.APP_STATUS_PROCESS);
			as.setFinishTime(new Date());
			as.setHandler(user.getUserId());
			as.setOperTime(new Date());
			this.appSummaryService.update(as);

			MlAppCheckResult appCheckResult = new MlAppCheckResult();
			appCheckResult.setAppNo(as.getAppNo());
			appCheckResult.setFinishTime(new Date());
			appCheckResult.setStatus(Constant.STEP_STATUS_END);
			appCheckResult.setCheckDesc("申请录入已提交,进入快速审批流程。");
			appCheckResult.setHandler(user.getUserId());
			appCheckResult.setOperTime(as.getOperTime());
			this.checkResultService.updateByLastStatus(appCheckResult);

			appCheckResult = new MlAppCheckResult();
			appCheckResult.setAppNo(as.getAppNo());
			appCheckResult.setCheckId(KeyGenerator.getNextKey(
					"ML_APP_CHECK_RESULT", "CHECK_ID"));
			appCheckResult.setBeginTime(as.getEnterTime());
			appCheckResult.setCurrStep(as.getCurrStep());
			appCheckResult.setStatus(Constant.STEP_STATUS_PROCESS);
			appCheckResult.setHandler(user.getUserId());
			appCheckResult.setCheckDesc("进入终审阶段");
			appCheckResult.setHandler(user.getUserId());
			appCheckResult.setOperTime(as.getOperTime());
			this.checkResultService.create(appCheckResult);
			
			//重新生成欺诈检查结果
			fraudCheckResultService.deleteFraudCheck(as.getAppNo());
			fraudCheckResultService.dealFraudCheck(as.getAppNo());
			
			// 执行策略
			this.strategyService.generatorSysDecisionResult(as.getAppNo(), Constant.APP_TYPE_NATURAL);
						
			result.put("success", true);
			result.put("msg", "申请信息提交成功！");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "自然人申请信息提交失败，服务器端处理异常！");
		}

		return result;
	}
}
