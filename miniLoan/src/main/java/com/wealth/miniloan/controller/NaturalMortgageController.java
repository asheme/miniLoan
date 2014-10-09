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
import com.wealth.miniloan.entity.MlNaturalMortgage;
import com.wealth.miniloan.entity.MlUser;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.CommonServiceI;
import com.wealth.miniloan.utils.key.KeyGenerator;

@Controller
@RequestMapping(value = "/natural/mortgage")
@SessionAttributes("user")
public class NaturalMortgageController extends BaseController {
	private CommonServiceI<MlNaturalMortgage> naturalMortgageService = null;

	@Autowired
	public void setNaturalMortgageService(CommonServiceI<MlNaturalMortgage> naturalMortgageService) {
		this.naturalMortgageService = naturalMortgageService;
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

	@RequestMapping(value = "toMortgageList")
	@ResponseBody
	public ModelAndView MortgageList(MlNaturalMortgage naturalMortgage) {
		String appNo = naturalMortgage.getAppNo();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("naturalApp/naturalMortgageList");
		modelAndView.addObject("appNo", appNo);
		return modelAndView;
	}

	@RequestMapping("naturalCheckMortgage")
	@ResponseBody
	public ModelAndView naturalCheckMortgage(String appNo) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("check/naturalMortgageDetail");
		modelAndView.addObject("flag", "CHECK");
		modelAndView.addObject("appNo", appNo);
		return modelAndView;
	}

	@RequestMapping(value = "naturalMortgageList")
	@ResponseBody
	public DataGrid getNaturalMortgageList(Page page, MlNaturalMortgage naturalMortgage) {
		DataGrid resut = new DataGrid();
		PageList<MlNaturalMortgage> loanNaturalMortgageList = null;
		loanNaturalMortgageList = naturalMortgageService.getPageList(page, naturalMortgage);

		if (loanNaturalMortgageList != null) {
			resut.setRows(loanNaturalMortgageList);
			resut.setTotal(Long.valueOf(loanNaturalMortgageList.getPaginator().getTotalCount()));
		}

		return resut;
	}

	@RequestMapping(value = "toAddNaturalMortgage")
	public ModelAndView toAddNaturalMortgage(MlNaturalMortgage naturalMortgage) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("naturalApp/modifyNaturalMortgage");
		modelAndView.addObject("flag", "ADD");
		modelAndView.addObject("naturalMortgage", naturalMortgage);
		return modelAndView;
	}

	@RequestMapping(value = "naturalMortgageShow")
	@ResponseBody
	public ModelAndView naturalMortgageShow(MlNaturalMortgage naturalMortgage) {
		try {
			naturalMortgage = this.naturalMortgageService.getByPriKey(naturalMortgage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("check/naturalMortgageShow");
		modelAndView.addObject("flag", "DETAIL");
		modelAndView.addObject("naturalMortgage", naturalMortgage);
		return modelAndView;
	}

	@RequestMapping(value = "toUpdateNaturalMortgage")
	public ModelAndView toUpdateNaturalMortgage(MlNaturalMortgage naturalMortgage) {
		try {
			naturalMortgage = this.naturalMortgageService.getByPriKey(naturalMortgage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("naturalApp/modifyNaturalMortgage");
		modelAndView.addObject("flag", "UPDATE");
		modelAndView.addObject("naturalMortgage", naturalMortgage);
		return modelAndView;
	}

	@RequestMapping(value = "modifyNaturalMortgage")
	@ResponseBody
	public Map<String, Object> modifyNaturalMortgage(MlNaturalMortgage naturalMortgage, String flag,
			@ModelAttribute("user") MlUser user) {
		Map<String, Object> result = new HashMap<String, Object>();

		if ("ADD".equals(flag)) {
			naturalMortgage.setMortgageId(KeyGenerator.getNextKey("ML_MORTGAGE_INFO", "MORTGAGE_ID"));
			result = addNaturalMortgage(naturalMortgage);
		} else if ("UPDATE".equals(flag)) {
			result = updateNaturalMortgage(naturalMortgage);
		} else {
			result.put("success", false);
			result.put("msg", "抵押物信息添加异常，服务器端无法正常获取请求数据！");
		}

		return result;
	}

	public Map<String, Object> addNaturalMortgage(MlNaturalMortgage naturalMortgage) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if (naturalMortgage != null) {
				this.naturalMortgageService.create(naturalMortgage);
				result.put("success", true);
				result.put("msg", "抵押物申请信息添加成功！");
			} else {
				result.put("success", true);
				result.put("msg", "抵押物申请信息添加失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "服务器端出现异常！");
		}

		return result;
	}

	public Map<String, Object> updateNaturalMortgage(MlNaturalMortgage naturalMortgage) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if (naturalMortgage != null) {
				this.naturalMortgageService.update(naturalMortgage);
				result.put("success", true);
				result.put("msg", "抵押物申请信息修改成功！");
			} else {
				result.put("success", false);
				result.put("msg", "抵押物申请信息修改失败，服务器端未获得要修改的机构信息！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "抵押物申请信息修改失败，服务器端处理异常！");
		}

		return result;
	}

	@RequestMapping(value = "deleteNaturalMortgage")
	@ResponseBody
	public Map<String, Object> deleteNaturalMortgage(String ids) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if ((ids != null) && (!"".equals(ids.trim()))) {
				this.naturalMortgageService.delete(ids);
				result.put("success", true);
				result.put("msg", "抵押物申请信息删除成功！");
			} else {
				result.put("success", false);
				result.put("msg", "抵押物申请信息删除失败，服务器端未获得要修改的机构信息！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "抵押物申请信息删除失败，服务器端处理异常！");
		}

		return result;
	}
}
