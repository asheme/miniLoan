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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.DataGrid;
import com.wealth.miniloan.entity.MlAppCheckResult;
import com.wealth.miniloan.entity.MlAppSummary;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.AppFlowServiceI;
import com.wealth.miniloan.service.CommonServiceI;
import com.wealth.miniloan.serviceImpl.CheckResultServiceImpl;
import com.wealth.miniloan.utils.Constant;
import com.wealth.miniloan.utils.key.KeyGenerator;

@Controller
@RequestMapping(value = "/mortgage/check")
@SessionAttributes("user")
public class MortgageCheckController extends BaseController {
	private CommonServiceI<MlAppSummary> appSummaryService = null;
	private CommonServiceI<MlAppCheckResult> checkResultService = null;
	private AppFlowServiceI appFlowService=null;

	@Autowired
	public void setCheckResultService(CheckResultServiceImpl checkResultService) {
		this.checkResultService = checkResultService;
	}

	@Autowired
	public void setAppSummaryService(CommonServiceI<MlAppSummary> appSummaryService) {
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
	public DataGrid getAppSummaryList(Page page, MlAppSummary appSummary) {
		DataGrid resut = new DataGrid();
		PageList<MlAppSummary> appSummaryList = null;
		appSummary.setCurrStep(Constant.STEP_MORT_ESTI);
		appSummaryList = appSummaryService.getPageList(page, appSummary);

		if (appSummaryList != null) {
			resut.setRows(appSummaryList);
			resut.setTotal(Long.valueOf(appSummaryList.getPaginator().getTotalCount()));
		}

		return resut;
	}

	@RequestMapping(value = "submitMortgageRevalue")
	@ResponseBody
	public Map<String, Object> submitMortgageRevalue(String appNo, String appType) {
		Map<String, Object> result = new HashMap<String, Object>();
		String currStep=null;

		try {
			MlAppSummary obj = new MlAppSummary();
			obj.setAppNo(appNo);
			MlAppSummary as = this.appSummaryService.getByPriKey(obj);
			currStep=this.appFlowService.getNextStep(as.getCurrStep());
			as.setPreviousStep(as.getCurrStep());
			as.setCurrStep(currStep);// 复核阶段
			as.setStatus(Constant.APP_STATUS_PROCESS);
			this.appSummaryService.update(as);
			result.put("success", true);
			result.put("msg", "押品评估信息已成功提交！");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "押品评估信息提交失败，服务器端处理异常！");
		}
		return result;
	}

	public void saveCheckResult(MlAppCheckResult checkResult) {
		try {
			MlAppCheckResult ar = new MlAppCheckResult();
			ar.setAppNo(checkResult.getAppNo());
			ar.setCheckType("02");
			ar.setCheckId(KeyGenerator.getNextKey("ML_APP_CHECK_RESULT", "CHECK_ID"));
			ar.setCheckResult(checkResult.getCheckResult());
			ar.setCheckDesc(checkResult.getCheckDesc());
			this.checkResultService.create(ar);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
