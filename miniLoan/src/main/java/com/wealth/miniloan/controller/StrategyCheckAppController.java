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
import com.wealth.miniloan.entity.MlUser;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.AppSummaryServiceI;
import com.wealth.miniloan.service.CheckResultServiceI;
import com.wealth.miniloan.utils.Constant;
import com.wealth.miniloan.utils.key.KeyGenerator;

@Controller
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
	public DataGrid getAppSummaryList(Page page, MlAppSummary appSummary) {
		DataGrid resut = new DataGrid();
		PageList<AppSummaryExtend> appSummaryList = null;
		appSummary.setCurrStep(Constant.STEP_APP_APPR);
		appSummaryList = appSummaryService.getPageList(page, appSummary);

		if (appSummaryList != null) {
			resut.setRows(appSummaryList);
			resut.setTotal(Long.valueOf(appSummaryList.getPaginator().getTotalCount()));
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
	public Map<String, Object> appApprove(String appNo, MlAppCheckResult checkResult,@ModelAttribute("user") MlUser user) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			MlAppSummary obj = new MlAppSummary();
			obj.setAppNo(appNo);
			MlAppSummary as = this.appSummaryService.getByPriKey(obj);
			if (Constant.APP_STATUS_APPROVE.equals(checkResult.getStatus())) {
				as.setStatus(Constant.APP_STATUS_APPROVE);
				as.setFinishTime(new Date());
			} else if (Constant.APP_STATUS_BACK.equals(checkResult.getStatus())) {
				as.setStatus(Constant.APP_STATUS_REJECT);
			} else if (checkResult.getStatus() == null || "".equals(checkResult.getStatus())) {
				result.put("success", false);
				result.put("msg", "请选择审核结果！");
				return result;
			}
			this.appSummaryService.update(as);
			
			MlAppCheckResult appCheckResult = new MlAppCheckResult();
			appCheckResult.setAppNo(appNo);
			appCheckResult.setFinishTime(new Date());
			if(Constant.APP_STATUS_APPROVE.equals(checkResult.getStatus())){
				appCheckResult.setStatus(Constant.STEP_STATUS_END);
				appCheckResult.setCheckDesc("申请件审批完成");
			}else{
				appCheckResult.setStatus(Constant.STEP_STATUS_BACK);
				appCheckResult.setCheckDesc("申请件被打回");
			}
			this.checkResultService.updateByLastStatus(appCheckResult);
			
			if(!Constant.APP_STATUS_APPROVE.equals(checkResult.getStatus())){
				appCheckResult = new MlAppCheckResult();
				appCheckResult.setAppNo(as.getAppNo());
				appCheckResult.setCheckId(KeyGenerator.getNextKey("ML_APP_CHECK_RESULT", "CHECK_ID"));
				appCheckResult.setBeginTime(as.getEnterTime());
				appCheckResult.setPreviousStep(as.getPreviousStep());
				appCheckResult.setCurrStep(as.getCurrStep());
				appCheckResult.setStatus(Constant.APP_STATUS_BACK);
				appCheckResult.setHandler(user.getUserId());
				appCheckResult.setCheckDesc("审核信息被打回");
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

	public void saveCheckResult(MlAppCheckResult checkResult) {
		try {
			MlAppCheckResult ar = new MlAppCheckResult();
			ar.setAppNo(checkResult.getAppNo());
			ar.setCheckId(KeyGenerator.getNextKey("ML_APP_CHECK_RESULT", "CHECK_ID"));
			ar.setCheckDesc(checkResult.getCheckDesc());
			this.checkResultService.create(ar);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
