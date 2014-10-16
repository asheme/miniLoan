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
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.DataGrid;
import com.wealth.miniloan.entity.MlAppSummary;
import com.wealth.miniloan.entity.MlMortgageInfo;
import com.wealth.miniloan.entity.MlMortgageInfoExample;
import com.wealth.miniloan.entity.MlNaturalApp;
import com.wealth.miniloan.entity.MlUser;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.AppFlowServiceI;
import com.wealth.miniloan.service.CommonServiceI;
import com.wealth.miniloan.utils.Constant;

@Controller
@RequestMapping(value = "/natural/app")
@SessionAttributes("user")
public class NaturalAppController extends BaseController {
	private CommonServiceI<MlNaturalApp> naturalAppService = null;
	private CommonServiceI<MlAppSummary> appSummaryService = null;
	private CommonServiceI<MlMortgageInfo> mortgageInfoService = null;
	private AppFlowServiceI appFlowService=null;

	@Autowired
	public void setMortgageInfoService(CommonServiceI<MlMortgageInfo> mortgageInfoService) {
		this.mortgageInfoService = mortgageInfoService;
	}

	@Autowired
	public void setNaturalAppService(CommonServiceI<MlNaturalApp> naturalAppService) {
		this.naturalAppService = naturalAppService;
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

	@RequestMapping(value = "naturalAppList")
	@ResponseBody
	public DataGrid getNaturalAppList(Page page, MlNaturalApp naturalApp) {
		DataGrid resut = new DataGrid();
		PageList<MlNaturalApp> loanNaturalAppList = null;
		loanNaturalAppList = naturalAppService.getPageList(page, naturalApp);

		if (loanNaturalAppList != null) {
			resut.setRows(loanNaturalAppList);
			resut.setTotal(Long.valueOf(loanNaturalAppList.getPaginator().getTotalCount()));
		}

		return resut;
	}

	@RequestMapping(value = "naturalApp")
	public ModelAndView naturalApp(String flag,String appNo) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("naturalApp/naturalApp");
		modelAndView.addObject("flag", flag);
		if ("UPDATE".equals(flag)) {
			modelAndView.addObject("appNo", appNo);
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "toModifyNaturalApp")
	public ModelAndView toModifyNaturalApp(String flag,MlNaturalApp naturalApp){
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("naturalApp/modifyNaturalApp");
		modelAndView.addObject("flag", flag);
		if("UPDATE".equals(flag)){
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

	@RequestMapping(value = "modifyNaturalApp")
	@ResponseBody
	public Map<String, Object> modifyNaturalApp(String flag,MlNaturalApp naturalApp, 
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

	public Map<String, Object> addNaturalApp(MlNaturalApp naturalApp) {
		Map<String, Object> result = new HashMap<String, Object>();
		String currStep=null;

		try {
			if (naturalApp != null) {
				naturalApp.setAppNo(super.getAppNo());
				this.naturalAppService.create(naturalApp);
				currStep=this.appFlowService.getFirstStep();
				
				// 保存概要信息
				MlAppSummary as = new MlAppSummary();
				as.setAppNo(naturalApp.getAppNo());
				as.setAppType(Constant.APP_TYPE_NATURAL);
				as.setCurrStep(currStep);
				as.setStatus(Constant.APP_STATUS_PROCESS);
				as.setEnterTime(new Date());
				this.appSummaryService.create(as);
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
	public Map<String, Object> submitApp(String appNo) {
		Map<String, Object> result = new HashMap<String, Object>();
		String currStep=null;
		
		try {
			MlAppSummary obj = new MlAppSummary();
			obj.setAppNo(appNo);
			MlAppSummary as = this.appSummaryService.getByPriKey(obj);

			MlMortgageInfoExample example = new MlMortgageInfoExample();
			MlMortgageInfoExample.Criteria c = example.createCriteria();
			c.andAppNoEqualTo(appNo);
			List<MlMortgageInfo> nmList = new ArrayList<MlMortgageInfo>();
			nmList = (List<MlMortgageInfo>) this.mortgageInfoService.getByExample(example);
			if (nmList != null && nmList.size() > 0) {
				currStep=this.appFlowService.getNextStep(as.getCurrStep());
				as.setPreviousStep(as.getCurrStep());
				as.setCurrStep(currStep);// 押品审核
				as.setStatus(Constant.APP_STATUS_PROCESS);
			} else {
				currStep=this.appFlowService.getNextStep(as.getCurrStep());
				currStep=this.appFlowService.getNextStep(currStep);
				as.setPreviousStep(as.getCurrStep());
				as.setCurrStep(currStep); //进入押品审核步骤
				as.setStatus(Constant.APP_STATUS_PROCESS);
			}
			as.setFinishTime(new Date());
			this.appSummaryService.update(as);
			result.put("success", true);
			result.put("msg", "申请信息提交成功！");

		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "自然人申请信息提交失败，服务器端处理异常！");
		}
		return result;
	}

	@RequestMapping(value = "recheckNaturalApp")
	@ResponseBody
	public ModelAndView recheckNaturalApp(String appNo) {
		ModelAndView modelAndView = new ModelAndView();
		MlNaturalApp app = new MlNaturalApp();
		app.setAppNo(appNo);
		MlNaturalApp na = this.naturalAppService.getByPriKey(app);
		modelAndView.addObject("appNo", appNo);
		modelAndView.setViewName("check/naturalAppDetail");
		modelAndView.addObject("checkApp", na);
		return modelAndView;
	}

	@RequestMapping(value = "submitToFinal")
	@ResponseBody
	public Map<String, Object> submitToFinal(String appNo) {
		Map<String, Object> result = new HashMap<String, Object>();
		String currStep=null;
		
		try {
			MlAppSummary obj = new MlAppSummary();
			obj.setAppNo(appNo);
			MlAppSummary as = this.appSummaryService.getByPriKey(obj);
			currStep=this.appFlowService.getEndStep();
			as.setPreviousStep(as.getCurrStep());
			as.setCurrStep(currStep);// 终审
			as.setStatus(Constant.APP_STATUS_PROCESS);
			as.setFinishTime(new Date());
			this.appSummaryService.update(as);
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
