package com.wealth.miniloan.controller;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.DataGrid;
import com.wealth.miniloan.entity.MlCapitalContrInfo;
import com.wealth.miniloan.entity.MlContributorInfo;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.CapitalContrInfoServiceI;
import com.wealth.miniloan.service.ContributorInfoServiceI;
import com.wealth.miniloan.utils.key.KeyGenerator;

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
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/capital")
public class CapitalContrController {
	private CapitalContrInfoServiceI capitalContrInfoService = null;
	private ContributorInfoServiceI contributorInfoService = null;

	@Autowired
	public void setContributorInfoServiceI(ContributorInfoServiceI contributorInfoService) {
		this.contributorInfoService = contributorInfoService;
	}

	@Autowired
	public void setCapitalContrInfoService(CapitalContrInfoServiceI capitalContrInfoService) {
		this.capitalContrInfoService = capitalContrInfoService;
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

	@RequestMapping(value = "toCapitalContrInfoList")
	@ResponseBody
	public ModelAndView toCapitalContrInfoList(MlContributorInfo contributorInfo) {
		ModelAndView view = new ModelAndView();
		contributorInfo = this.contributorInfoService.getByPriKey(contributorInfo);
		view.addObject("title", contributorInfo.getName());
		view.setViewName("contributor/capitalContrInfoList");
		view.addObject("contributorId", contributorInfo.getContributorId());

		return view;
	}

	@RequestMapping(value = "capitalContrInfoList")
	@ResponseBody
	public DataGrid geCapitalContrInfoList(Page page, MlCapitalContrInfo capitalContrInfo) {
		DataGrid result = new DataGrid();
		PageList<MlCapitalContrInfo> list = null;

		try {
			list = this.capitalContrInfoService.getPageList(page, capitalContrInfo);
			if (list.getPaginator().getTotalCount() != 0) {
				result.setTotal(Long.valueOf(list.getPaginator().getTotalCount()));
				result.setRows(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@RequestMapping(value = "toAddCapitalContrInfo")
	public ModelAndView toAddCapitalContrInfo(MlCapitalContrInfo capitalContrInfo) {
		ModelAndView view = new ModelAndView();
		view.setViewName("contributor/modifyCapitalContrInfo");
		view.addObject("flag", "ADD");
		view.addObject("contributorId", capitalContrInfo.getContributorId());
		return view;
	}

	@RequestMapping(value = "toUpdateCapitalContrInfo")
	public ModelAndView toUpdateCapitalContrInfo(MlCapitalContrInfo capitalContrInfo) {
		ModelAndView view = new ModelAndView();
		capitalContrInfo = this.capitalContrInfoService.getByPriKey(capitalContrInfo);
		view.setViewName("contributor/modifyCapitalContrInfo");
		view.addObject("capitalContrInfo", capitalContrInfo);
		view.addObject("flag", "UPDATE");
		view.addObject("contributorId", capitalContrInfo.getContributorId());
		return view;
	}

	@RequestMapping(value = "modifyCapitalContrInfo")
	@ResponseBody
	public Map<String, Object> modifyCapitalContrInfo(MlCapitalContrInfo capitalContrInfo, String flag) {
		Map<String, Object> result = null;

		if ("ADD".equals(flag)) {
			result = addCapitalContrInfo(capitalContrInfo);
		} else if ("UPDATE".equals(flag)) {
			result = updateCapitalContrInfo(capitalContrInfo);
		} else {
			result = new HashMap<String, Object>();
			result.put("success", false);
			result.put("msg", "出资信息处理异常，服务器端无法正常获取请求数据！");
		}

		return result;
	}

	public Map<String, Object> addCapitalContrInfo(MlCapitalContrInfo capitalContrInfo) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if (capitalContrInfo != null) {
				capitalContrInfo.setCapitalId(KeyGenerator.getNextKey("ML_CAPITAL_CONTR_INFO", "CAPITAL_ID"));
				this.capitalContrInfoService.create(capitalContrInfo);
				result.put("success", true);
				result.put("msg", "出资信息添加成功！");
			} else {
				result.put("success", false);
				result.put("msg", "出资信息添加失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "服务器端出现异常！");
		}

		return result;
	}

	public Map<String, Object> updateCapitalContrInfo(MlCapitalContrInfo capitalContrInfo) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if (capitalContrInfo != null) {
				this.capitalContrInfoService.update(capitalContrInfo);
				result.put("success", true);
				result.put("msg", "出资信息修改成功！");
			} else {
				result.put("success", false);
				result.put("msg", "出资信息修改失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "服务器端出现异常！");
		}

		return result;
	}

	@RequestMapping(value = "deleteDictItem")
	@ResponseBody
	public Map<String, Object> deleteDictItem(String ids) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if ((ids != null) && (!"".equals(ids.trim()))) {
				this.capitalContrInfoService.delete(ids);
				result.put("success", true);
				result.put("msg", "出资信息删除成功！");
			} else {
				result.put("success", false);
				result.put("msg", "没有获取到要删除的信息！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "删除失败，服务器端发生内部错误");
		}
		return result;
	}
}