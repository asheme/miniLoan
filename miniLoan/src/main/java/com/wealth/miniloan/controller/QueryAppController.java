package com.wealth.miniloan.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.AppSummaryExtend;
import com.wealth.miniloan.entity.DataGrid;
import com.wealth.miniloan.entity.MlAppSummary;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.AppSummaryServiceI;

@Controller
@RequestMapping(value = "/query/app")
@SessionAttributes("user")
public class QueryAppController extends BaseController {
	private AppSummaryServiceI appSummaryService = null;
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

	@RequestMapping(value = "queryAppList")
	@ResponseBody
	public DataGrid getAppSummaryList(Page page, MlAppSummary appSummary) {
		DataGrid resut = new DataGrid();
		PageList<AppSummaryExtend> appSummaryList = null;
		appSummaryList = appSummaryService.getAllPageList(page, appSummary);

		if (appSummaryList != null) {
			resut.setRows(appSummaryList);
			resut.setTotal(Long.valueOf(appSummaryList.getPaginator().getTotalCount()));
		}

		return resut;
	}
	
	@RequestMapping(value = "toQueryApp")
	public ModelAndView toQueryApp(String appNo, String appType) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("appNo", appNo);
		modelAndView.addObject("appType", appType);
		modelAndView.setViewName("query/queryApp");
		return modelAndView;
	}
}
