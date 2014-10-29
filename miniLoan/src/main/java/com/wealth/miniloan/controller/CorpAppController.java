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
import org.springframework.web.servlet.ModelAndView;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.CorpAppInfo;
import com.wealth.miniloan.entity.DataGrid;
import com.wealth.miniloan.entity.MlAppCheckResult;
import com.wealth.miniloan.entity.MlAppSummary;
import com.wealth.miniloan.entity.MlCorpApp;
import com.wealth.miniloan.entity.MlMortgageInfo;
import com.wealth.miniloan.entity.MlMortgageInfoExample;
import com.wealth.miniloan.entity.MlUser;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.AppFlowServiceI;
import com.wealth.miniloan.service.AppSummaryServiceI;
import com.wealth.miniloan.service.CheckResultServiceI;
import com.wealth.miniloan.service.CommonServiceI;
import com.wealth.miniloan.service.LoanCorpAppServiceI;
import com.wealth.miniloan.utils.Constant;
import com.wealth.miniloan.utils.key.KeyGenerator;

@Controller
@Transactional(rollbackFor={Exception.class})
@RequestMapping(value = "/corp/app")
public class CorpAppController extends BaseController {
	private LoanCorpAppServiceI corpAppService = null;
	private AppSummaryServiceI appSummaryService = null;
	private CommonServiceI<MlMortgageInfo> mortgageInfoService = null;
	private AppFlowServiceI appFlowService=null;
	private CheckResultServiceI checkResultService = null;
	
	@Autowired
	public void setAppSummaryService(AppSummaryServiceI appSummaryService) {
		this.appSummaryService = appSummaryService;
	}

	@Autowired
	public void setCorpAppService(LoanCorpAppServiceI corpAppService) {
		this.corpAppService = corpAppService;
	}
	
	@Autowired
	public void setMortgageInfoService(
			CommonServiceI<MlMortgageInfo> mortgageInfoService) {
		this.mortgageInfoService = mortgageInfoService;
	}

	@Autowired
	public void setAppFlowService(AppFlowServiceI appFlowService) {
		this.appFlowService = appFlowService;
	}
	
	@Autowired
	public void setCheckResultService(CheckResultServiceI checkResultService) {
		this.checkResultService = checkResultService;
	}

	@RequestMapping(value = "corpAppList")
	@ResponseBody
	public DataGrid getCorpAppList(Page page, CorpAppInfo corpApp) {
		DataGrid resut = new DataGrid();
		PageList<CorpAppInfo> loanCorpAppList = null;
		loanCorpAppList = this.corpAppService.getCorpAppPageList(page, corpApp);

		if (loanCorpAppList != null) {
			resut.setRows(loanCorpAppList);
			resut.setTotal(Long.valueOf(loanCorpAppList.getPaginator().getTotalCount()));
		}

		return resut;
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

	@RequestMapping(value = "corpApp")
	public ModelAndView addCropApp(String flag,String appNo) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("corpApp/corpApp");
		modelAndView.addObject("flag", flag);
		if ("UPDATE".equals(flag)) {
			modelAndView.addObject("appNo", appNo);
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "toModifyCorpApp")
	public ModelAndView toModifyCorpApp(String flag,MlCorpApp corpApp) {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("corpApp/modifyCorpApp");
		modelAndView.addObject("flag", flag);
		if("UPDATE".equals(flag)){
			corpApp = this.corpAppService.getByPriKey(corpApp);
			modelAndView.addObject("corpApp", corpApp);
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "toShowDetail")
	public ModelAndView toShowDetail(String appNo) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("corpApp/detailCorp");
		return modelAndView;
	}

	@RequestMapping(value = "viewCorpApp")
	@ResponseBody
	public ModelAndView viewCorpApp(MlCorpApp corpApp) {
		ModelAndView modelAndView = new ModelAndView();
		corpApp = this.corpAppService.getByPriKey(corpApp);
		modelAndView.setViewName("corpApp/corpAppDetail");
		modelAndView.addObject("corpApp", corpApp);
		return modelAndView;
	}
	
	
	@RequestMapping(value = "modifyCorpApp")
	@ResponseBody
	public Map<String, Object> modifyCorpApp(MlCorpApp corpApp, String flag,@ModelAttribute("user") MlUser user) {
		Map<String, Object> result = new HashMap<String, Object>();

		if ("ADD".equals(flag)) {
			result = addCorpApp(corpApp,user);
		} else if ("UPDATE".equals(flag)) {
			result = updateCorpApp(corpApp);
		} else {
			result.put("success", false);
			result.put("msg", "公司申请信息添加异常，服务器端无法正常获取请求数据！");
		}

		return result;
	}

	public Map<String, Object> addCorpApp(MlCorpApp corpApp,MlUser user) {
		Map<String, Object> result = new HashMap<String, Object>();
		String currStep=null;

		try {
			if (corpApp != null) {
				corpApp.setAppNo(super.getAppNo());
				this.corpAppService.create(corpApp);
				currStep=this.appFlowService.getFirstStep();
				
				// 保存概要信息
				MlAppSummary as = new MlAppSummary();
				as.setAppNo(corpApp.getAppNo());
				as.setAppType(Constant.APP_TYPE_CORP);
				as.setCurrStep(currStep);
				as.setStatus(Constant.APP_STATUS_PROCESS);
				as.setEnterTime(new Date());
				as.setHandler(user.getUserId());
				as.setOperTime(new Date());
				this.appSummaryService.create(as);
				
				//保存check result信息
				MlAppCheckResult appCheckResult = new MlAppCheckResult();
				appCheckResult.setAppNo(as.getAppNo());
				appCheckResult.setCheckId(KeyGenerator.getNextKey("ML_APP_CHECK_RESULT", "CHECK_ID"));
				appCheckResult.setBeginTime(as.getEnterTime());
				appCheckResult.setCurrStep(as.getCurrStep());
				appCheckResult.setStatus(Constant.STEP_STATUS_PROCESS);
				appCheckResult.setHandler(user.getUserId());
				appCheckResult.setCheckDesc("申请信息录入");
				appCheckResult.setOperTime(as.getOperTime());
				checkResultService.create(appCheckResult);

				result.put("success", true);
				result.put("appNo", corpApp.getAppNo());
				result.put("msg", "公司申请信息添加成功！");
			} else {
				result.put("success", true);
				result.put("msg", "公司申请信息添加失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "服务器端出现异常！");
		}

		return result;
	}

	public Map<String, Object> updateCorpApp(MlCorpApp corpApp) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if (corpApp != null) {
				this.corpAppService.update(corpApp);
				result.put("success", true);
				result.put("appNo", corpApp.getAppNo());
				result.put("msg", "公司申请信息修改成功！");
			} else {
				result.put("success", false);
				result.put("msg", "公司申请信息修改失败，服务器端未获得要修改的机构信息！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "公司申请信息修改失败，服务器端处理异常！");
		}

		return result;
	}

	@RequestMapping(value = "deleteCorpApp")
	@ResponseBody
	public Map<String, Object> deleteCorpApp(String ids) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if ((ids != null) && (!"".equals(ids.trim()))) {
				this.corpAppService.delete(ids);
				result.put("success", true);
				result.put("msg", "公司申请信息删除成功！");
			} else {
				result.put("success", false);
				result.put("msg", "公司申请信息删除失败，服务器端未获得要修改的机构信息！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "公司申请信息删除失败，服务器端处理异常！");
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "submitApp")
	@ResponseBody
	public Map<String, Object> submitApp(MlAppSummary as,@ModelAttribute("user") MlUser user) {
		Map<String, Object> result = new HashMap<String, Object>();
		String currStep=null;
		
		try {
			as = this.appSummaryService.getByPriKey(as);
			
			MlMortgageInfoExample example = new MlMortgageInfoExample();
			MlMortgageInfoExample.Criteria c = example.createCriteria();
			c.andAppNoEqualTo(as.getAppNo());
			List<MlMortgageInfo> nmList = new ArrayList<MlMortgageInfo>();
			nmList = (List<MlMortgageInfo>) this.mortgageInfoService.getByExample(example);
			if (nmList != null && nmList.size() > 0) {
				currStep=this.appFlowService.getNextStep(as.getCurrStep());
				as.setPreviousStep(as.getCurrStep());
				as.setCurrStep(currStep);// 押品审核
				as.setStatus(Constant.APP_STATUS_PROCESS);
			}else{
				currStep=this.appFlowService.getNextStep(as.getCurrStep());
				currStep=this.appFlowService.getNextStep(currStep);
				as.setPreviousStep(as.getCurrStep());
				as.setCurrStep(currStep); //进入押品审核步骤
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
			appCheckResult.setCheckId(KeyGenerator.getNextKey("ML_APP_CHECK_RESULT", "CHECK_ID"));
			appCheckResult.setBeginTime(new Date());
			appCheckResult.setCurrStep(as.getCurrStep());
			appCheckResult.setStatus(Constant.STEP_STATUS_PROCESS);
			appCheckResult.setHandler(user.getUserId());
			if(Constant.STEP_MORT_ESTI.equals(appCheckResult.getCurrStep())){
				appCheckResult.setCheckDesc("进入押品评估阶段");
			}else if(Constant.STEP_APP_CHECK.equals(appCheckResult.getCurrStep())){
				appCheckResult.setCheckDesc("进入申请复核阶段");
			}
			appCheckResult.setHandler(user.getUserId());
			appCheckResult.setOperTime(as.getOperTime());
			this.checkResultService.create(appCheckResult);
			
			result.put("success", true);
			result.put("msg", "申请信息提交成功！");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "法人申请信息提交失败，服务器端处理异常！");
		}
		return result;
	}

	@RequestMapping(value = "submitToFinal")
	@ResponseBody
	public Map<String, Object> submitToFinal(MlAppSummary as,@ModelAttribute("user") MlUser user) {
		Map<String, Object> result = new HashMap<String, Object>();
		String currStep=null;

		try {
			as = this.appSummaryService.getByPriKey(as);
			currStep=this.appFlowService.getEndStep();
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
			appCheckResult.setCheckId(KeyGenerator.getNextKey("ML_APP_CHECK_RESULT", "CHECK_ID"));
			appCheckResult.setBeginTime(new Date());
			appCheckResult.setPreviousStep(as.getPreviousStep());
			appCheckResult.setCurrStep(as.getCurrStep());
			appCheckResult.setStatus(Constant.STEP_STATUS_PROCESS);
			appCheckResult.setHandler(user.getUserId());
			appCheckResult.setCheckDesc("进入终审阶段");
			appCheckResult.setHandler(user.getUserId());
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
	
}
