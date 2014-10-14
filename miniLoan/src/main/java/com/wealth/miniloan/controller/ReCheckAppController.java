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
import com.wealth.miniloan.entity.DataGrid;
import com.wealth.miniloan.entity.MlAppCheckResult;
import com.wealth.miniloan.entity.MlAppSummary;
import com.wealth.miniloan.entity.MlUser;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.CommonServiceI;
import com.wealth.miniloan.serviceImpl.CheckResultServiceImpl;
import com.wealth.miniloan.utils.key.KeyGenerator;

@Controller
@RequestMapping(value = "/recheck/app")
@SessionAttributes("user")
public class ReCheckAppController extends BaseController {
	private CommonServiceI<MlAppSummary> appSummaryService = null;
	private CommonServiceI<MlAppCheckResult> checkResultService = null;

	@Autowired
	public void setCheckResultService(CheckResultServiceImpl checkResultService) {
		this.checkResultService = checkResultService;
	}

	@Autowired
	public void setAppSummaryService(CommonServiceI<MlAppSummary> appSummaryService) {
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

	@RequestMapping(value = "recheckAppList")
	@ResponseBody
	public DataGrid getAppSummaryList(Page page, MlAppSummary appSummary) {
		DataGrid resut = new DataGrid();
		PageList<MlAppSummary> appSummaryList = null;
		appSummary.setCurrStep("02");
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
		if ("01".equals(appType)) {
			modelAndView.setViewName("check/checkNaturalApp");
		} else {
			modelAndView.setViewName("check/checkCorpApp");
		}
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

	@RequestMapping(value = "goToNext")
	@ResponseBody
	public Map<String, Object> goToNext(String appNo, MlAppCheckResult checkResult) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			MlAppSummary obj = new MlAppSummary();
			obj.setAppNo(appNo);
			MlAppSummary as = this.appSummaryService.getByPriKey(obj);
			if ("1".equals(checkResult.getCheckResult())) {
				as.setCurrStep("03");
			} else if ("0".equals(checkResult.getCheckResult())) {
				as.setCurrStep("00");
			}
			as.setFinishTime(new Date());
			this.appSummaryService.update(as);
			if (checkResult.getCheckDesc() != null && !"".equals(checkResult.getCheckDesc())) {
				saveCheckResult(checkResult);
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
			ar.setCheckType("03");
			ar.setCheckId(KeyGenerator.getNextKey("ML_APP_CHECK_RESULT", "CHECK_ID"));
			ar.setCheckResult(checkResult.getCheckResult());
			ar.setCheckDesc(checkResult.getCheckDesc());
			this.checkResultService.create(ar);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
