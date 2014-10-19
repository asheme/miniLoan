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
import com.wealth.miniloan.entity.DataGrid;
import com.wealth.miniloan.entity.MlAppCheckResult;
import com.wealth.miniloan.entity.MlAppCheckResultExample;
import com.wealth.miniloan.entity.MlAppCheckResultExample.Criteria;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.serviceImpl.CheckResultServiceImpl;

@Controller
@RequestMapping(value = "/app/checkresult")
@SessionAttributes("user")
public class CheckResultController extends BaseController {
	private CheckResultServiceImpl checkResultService = null;

	@Autowired
	public void setCheckResultService(CheckResultServiceImpl checkResultService) {
		this.checkResultService = checkResultService;
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

	@RequestMapping(value = "viewCheckResultList")
	@ResponseBody
	public ModelAndView viewCheckResultList(String appNo) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("check/checkResultDetail");
		modelAndView.addObject("appNo", appNo);
		return modelAndView;
	}

	@RequestMapping(value = "checkResultList")
	@ResponseBody
	public DataGrid getNaturalAttachList(Page page, MlAppCheckResult checkResult) {
		DataGrid resut = new DataGrid();
		PageList<MlAppCheckResult> checkResultList = null;
		checkResultList = checkResultService.getPageList(page, checkResult);

		if (checkResultList != null) {
			resut.setRows(checkResultList);
			resut.setTotal(Long.valueOf(checkResultList.getPaginator().getTotalCount()));
		}

		return resut;
	}

	@RequestMapping(value = "getCheckResult")
	@ResponseBody
	public MlAppCheckResult getCheckResult(String appNo, String checkType) {
		MlAppCheckResultExample example = new MlAppCheckResultExample();
		Criteria c = example.createCriteria();
		c.andAppNoEqualTo(appNo);
		MlAppCheckResult cr = (MlAppCheckResult) this.checkResultService.getByExample(example);

		return cr;
	}
}
