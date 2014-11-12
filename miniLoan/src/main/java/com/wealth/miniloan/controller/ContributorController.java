package com.wealth.miniloan.controller;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.DataGrid;
import com.wealth.miniloan.entity.MlContributorInfo;
import com.wealth.miniloan.entity.Page;
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
@RequestMapping(value = "/contributor")
public class ContributorController {
	private ContributorInfoServiceI contributorInfoService = null;

	@Autowired
	public void setContributorInfoServiceI(ContributorInfoServiceI contributorInfoService) {
		this.contributorInfoService = contributorInfoService;
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

	@RequestMapping(value = "contributorList")
	@ResponseBody
	public DataGrid getContributorList(Page page, MlContributorInfo contributorInfo) {
		DataGrid result = new DataGrid();
		PageList<MlContributorInfo> list = null;

		try {
			list = this.contributorInfoService.getPageList(page, contributorInfo);
			if (list.getPaginator().getTotalCount() != 0) {
				result.setTotal(Long.valueOf(list.getPaginator().getTotalCount()));
				result.setRows(list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	
	@RequestMapping(value = "toAddContributor")
	@ResponseBody
	public ModelAndView toAddContributor() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("flag", "ADD");
		modelAndView.setViewName("contributor/modifyContributor");
		return modelAndView;
	}

	@RequestMapping(value = "toUpdateContributor")
	@ResponseBody
	public ModelAndView toUpdateContributor(MlContributorInfo contributorInfo) {
		try {
			contributorInfo = this.contributorInfoService.getByPriKey(contributorInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("contributor/modifyContributor");
		modelAndView.addObject("contributorInfo", contributorInfo);
		modelAndView.addObject("flag", "UPDATE");
		return modelAndView;
	}

	@RequestMapping(value = "modifyContributor")
	@ResponseBody
	public Map<String, Object> modifyContributor(MlContributorInfo contributorInfo, String flag) {
		Map<String, Object> result = new HashMap<String, Object>();

		if ("ADD".equals(flag)) {
			result = addContributor(contributorInfo);
		} else if ("UPDATE".equals(flag)) {
			result = updateContributor(contributorInfo);
		} else {
			result.put("success", Boolean.valueOf(false));
			result.put("msg", "出资人处理异常，服务器端无法正常获取请求数据！");
		}

		return result;
	}

	public Map<String, Object> addContributor(MlContributorInfo contributorInfo) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if (contributorInfo != null) {
				contributorInfo.setContributorId(KeyGenerator.getNextKey("ML_CONTRIBUTOR_INFO", "CONTRIBUTOR_ID"));
				this.contributorInfoService.create(contributorInfo);
				result.put("success", true);
				result.put("msg", "出资人添加成功！");
			} else {
				result.put("success", true);
				result.put("msg", "出资人添加失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "服务器端出现异常");
		}

		return result;
	}

	public Map<String, Object> updateContributor(MlContributorInfo contributorInfo) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			if (contributorInfo != null) {
				this.contributorInfoService.update(contributorInfo);
				result.put("success", Boolean.valueOf(true));
				result.put("msg", "出资人修改成功！");
			} else {
				result.put("success", Boolean.valueOf(false));
				result.put("msg", "出资人修改失败，服务器端未获得要修改的出资人信息！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", Boolean.valueOf(false));
			result.put("msg", "出资人修改失败，服务器端处理异常！");
		}

		return result;
	}

	@RequestMapping(value = "deleteContributor")
	@ResponseBody
	public Map<String, Object> deleteContributor(String ids) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			if ((ids != null) && (!"".equals(ids.trim()))) {
				this.contributorInfoService.delete(ids);
				result.put("success", true);
				result.put("msg", "出资人信息删除成功！");
			} else {
				result.put("success", false);
				result.put("msg", "出资人信息删除失败，服务器端未获得要删除的出资人信息！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "出资人信息删除失败，服务器端处理异常！");
		}

		return result;
	}

}