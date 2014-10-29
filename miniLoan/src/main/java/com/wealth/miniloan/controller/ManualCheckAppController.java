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
import com.wealth.miniloan.entity.DataDictionary;
import com.wealth.miniloan.entity.DataGrid;
import com.wealth.miniloan.entity.FraudCheckResultView;
import com.wealth.miniloan.entity.MlAppCheckResult;
import com.wealth.miniloan.entity.MlAppSummary;
import com.wealth.miniloan.entity.MlDictItem;
import com.wealth.miniloan.entity.MlFraudCheckResult;
import com.wealth.miniloan.entity.MlUser;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.entity.UnionLoanApp;
import com.wealth.miniloan.entity.User;
import com.wealth.miniloan.service.AppFlowServiceI;
import com.wealth.miniloan.service.AppSummaryServiceI;
import com.wealth.miniloan.service.CheckResultServiceI;
import com.wealth.miniloan.service.DataDictServiceI;
import com.wealth.miniloan.service.FraudCheckResultServiceI;
import com.wealth.miniloan.service.StrategyServiceI;
import com.wealth.miniloan.utils.Constant;
import com.wealth.miniloan.utils.key.KeyGenerator;

@Controller
@RequestMapping(value = "/manualcheck/app")
@Transactional(rollbackFor={Exception.class})
@SessionAttributes("user")
public class ManualCheckAppController extends BaseController {
	private AppSummaryServiceI appSummaryService = null;
	private CheckResultServiceI checkResultService = null;
	private AppFlowServiceI appFlowService = null;
	private FraudCheckResultServiceI fraudCheckResultService = null;
	private DataDictServiceI dictService = null;
	private StrategyServiceI strategyService = null;

	@Autowired
	public void setDataDictService(DataDictServiceI dictService) {
		this.dictService = dictService;
	}

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

	@RequestMapping(value = "manualcheckAppList")
	@ResponseBody
	public DataGrid getLoanAppList(Page page, UnionLoanApp unionLoanApp, @ModelAttribute("user") User user) {
		DataGrid resut = new DataGrid();
		PageList<UnionLoanApp> loanAppList = null;
		unionLoanApp.setCurrStep(Constant.STEP_MANU_INSP);
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
		modelAndView.setViewName("check/manualCheckApp");
		return modelAndView;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "toCrossCheckResult")
	@ResponseBody
	public ModelAndView toCrossCheckResult(String appNo) {
		ModelAndView modelAndView = new ModelAndView();
		List<MlFraudCheckResult> list = (List<MlFraudCheckResult>) this.fraudCheckResultService.getByExample(appNo);
		List<FraudCheckResultView> viewList = new ArrayList<FraudCheckResultView>();
		for (MlFraudCheckResult result : list) {
			FraudCheckResultView view = new FraudCheckResultView();
			view.setItemCode(result.getItemCode());
			view.setItemType(getDictItem("FRAUD_CHECK_ITEM_TYPE", result.getItemType()));
			view.setItemDesc(result.getItemDesc());
			view.setCheckResult(getDictItem("YES_OR_NO", result.getCheckResult()));
			// view.setCheckResult(result.getCheckResult());
			view.setOpTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(result.getOpTime()));
			viewList.add(view);
		}
		modelAndView.addObject("checkResult", viewList);
		modelAndView.addObject("appNo", appNo);
		modelAndView.setViewName("check/crossCheckResult");
		return modelAndView;
	}

	public String getDictItem(String dictName, String itemCode) {
		DataDictionary dataDictionary = this.dictService
				.getDictItemsByDictName(dictName);
		List<?> dictItemList = dataDictionary.getDictItemList();

		MlDictItem dictItem = null;
		if (dictItemList != null) {
			for (int i = 0; i < dictItemList.size(); i++) {
				dictItem = (MlDictItem) dictItemList.get(i);
				if (itemCode.equals(dictItem.getItemCode())) {
					return dictItem.getItemTitle();
				}
			}

		}

		return "";
	}

	@RequestMapping(value = "submitToApprove")
	@ResponseBody
	public Map<String, Object> submitToApprove(MlAppSummary as,String appType,
			MlAppCheckResult checkResult, @ModelAttribute("user") MlUser user) {
		Map<String, Object> result = new HashMap<String, Object>();
		String currStep = null;

		try {
			as = this.appSummaryService.getByPriKey(as);
			if (Constant.APP_STATUS_APPROVE.equals(checkResult.getStatus())) {
				currStep = this.appFlowService.getNextStep(as.getCurrStep());
				as.setPreviousStep(as.getCurrStep());
				as.setCurrStep(currStep);// 审批阶段
				as.setStatus(Constant.APP_STATUS_PROCESS);
				as.setCurrApproveLvl(Constant.APPRAOVAL_LEVEL_1);

				// 执行策略
				this.strategyService.generatorSysDecisionResult(as.getAppNo(), appType);
			} else if(Constant.APP_STATUS_REJECT.equals(checkResult.getStatus())){
				as.setStatus(Constant.APP_STATUS_REJECT);
				as.setManualResult(Constant.APP_STATUS_REJECT);
				as.setReasonCode("MR0001");
				as.setReasonDesc(checkResult.getCheckDesc());
				as.setFinishTime(new Date());
			} else if (Constant.APP_STATUS_BACK.equals(checkResult.getStatus())) {
				currStep = this.appFlowService.getFirstStep();
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
			if (Constant.APP_STATUS_APPROVE.equals(checkResult.getStatus())) {
				appCheckResult.setStatus(Constant.STEP_STATUS_END);
			} else if(Constant.APP_STATUS_REJECT.equals(checkResult.getStatus())) {
				appCheckResult.setStatus(Constant.STEP_STATUS_REJECT);
			} else {
				appCheckResult.setStatus(Constant.STEP_STATUS_BACK);
			}
			appCheckResult.setCheckDesc(checkResult.getCheckDesc());
			appCheckResult.setHandler(user.getUserId());
			appCheckResult.setOperTime(as.getOperTime());
			this.checkResultService.updateByLastStatus(appCheckResult);

			if(!Constant.APP_STATUS_REJECT.equals(checkResult.getStatus())){
				appCheckResult = new MlAppCheckResult();
				appCheckResult.setAppNo(as.getAppNo());
				appCheckResult.setCheckId(KeyGenerator.getNextKey("ML_APP_CHECK_RESULT", "CHECK_ID"));
				appCheckResult.setBeginTime(new Date());
				appCheckResult.setPreviousStep(as.getPreviousStep());
				appCheckResult.setCurrStep(as.getCurrStep());
				appCheckResult.setStatus(Constant.STEP_STATUS_PROCESS);
				appCheckResult.setHandler(user.getUserId());
				if (Constant.APP_STATUS_APPROVE.equals(checkResult.getStatus())) {
					appCheckResult.setCheckDesc("进入终审阶段");
				} else {
					appCheckResult.setCheckDesc("人工核查信息被打回");
				}
				appCheckResult.setHandler(user.getUserId());
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

}
