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
import com.wealth.miniloan.entity.MlMortgageInfo;
import com.wealth.miniloan.entity.MlUser;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.CommonServiceI;
import com.wealth.miniloan.utils.key.KeyGenerator;

@Controller
@RequestMapping(value = "/mortgage")
@SessionAttributes("user")
public class MortgageController extends BaseController {
	private CommonServiceI<MlMortgageInfo> mortgageInfoService = null;

	@Autowired
	public void setMortgageInfoService(CommonServiceI<MlMortgageInfo> mortgageInfoService) {
		this.mortgageInfoService = mortgageInfoService;
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
	public ModelAndView MortgageList(MlMortgageInfo mortgageInfo) {
		String appNo = mortgageInfo.getAppNo();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("mortgage/mortgageList");
		modelAndView.addObject("appNo", appNo);
		return modelAndView;
	}
	
	@RequestMapping(value = "mortgageList")
	@ResponseBody
	public DataGrid getMortgageList(Page page, MlMortgageInfo mortgageInfo) {
		DataGrid resut = new DataGrid();
		PageList<MlMortgageInfo> mortgageInfoList = null;
		mortgageInfoList = mortgageInfoService.getPageList(page, mortgageInfo);

		if (mortgageInfoList != null) {
			resut.setRows(mortgageInfoList);
			resut.setTotal(Long.valueOf(mortgageInfoList.getPaginator().getTotalCount()));
		}
		return resut;
	}

	@RequestMapping("checkMortgage")
	@ResponseBody
	public ModelAndView checkMortgage(String appNo,String appType) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("check/checkMortgage");
		modelAndView.addObject("flag", "CHECK");
		modelAndView.addObject("appNo", appNo);
		modelAndView.addObject("appType", appType);
		return modelAndView;
	}
	
	@RequestMapping(value = "toAddMortgage")
	public ModelAndView toAddMortgage(MlMortgageInfo mortgageInfo) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("mortgage/modifyMortgage");
		modelAndView.addObject("flag", "ADD");
		modelAndView.addObject("mortgageInfo", mortgageInfo);
		return modelAndView;
	}

	@RequestMapping(value = "toUpdateMortgage")
	public ModelAndView toUpdateMortgage(MlMortgageInfo mortgageInfo) {
		try {
			mortgageInfo = this.mortgageInfoService.getByPriKey(mortgageInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("mortgage/modifyMortgage");
		modelAndView.addObject("flag", "UPDATE");
		modelAndView.addObject("mortgageInfo", mortgageInfo);
		return modelAndView;
	}
	
	@RequestMapping("revalueMortgage")
	@ResponseBody
	public ModelAndView revalueMortgage(String appNo) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("check/revalueMortgageList");
		modelAndView.addObject("flag", "CHECK");
		modelAndView.addObject("appNo", appNo);
		return modelAndView;
	}

	
	@RequestMapping(value = "toRevalueMortgage")
	public ModelAndView toRevalueMortgage(MlMortgageInfo mortgageInfo) {
		try {
			mortgageInfo = this.mortgageInfoService.getByPriKey(mortgageInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("check/revalueMortgage");
		modelAndView.addObject("flag", "UPDATE");
		modelAndView.addObject("mortgageInfo", mortgageInfo);
		return modelAndView;
	}

	@RequestMapping("showMortgageList")
	@ResponseBody
	public ModelAndView showMortgageList(String appNo) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("check/showMortgageList");
		modelAndView.addObject("flag", "CHECK");
		modelAndView.addObject("appNo", appNo);
		return modelAndView;
	}

	
	@RequestMapping(value = "mortgageShow")
	@ResponseBody
	public ModelAndView mortgageShow(MlMortgageInfo mortgageInfo) {
		try {
			mortgageInfo = this.mortgageInfoService.getByPriKey(mortgageInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("check/mortgageShow");
		modelAndView.addObject("flag", "DETAIL");
		modelAndView.addObject("mortgageInfo", mortgageInfo);
		return modelAndView;
	}
	
	@RequestMapping(value = "modifyMortgageInfo")
	@ResponseBody
	public Map<String, Object> modifyMortgageInfo(MlMortgageInfo mortgageInfo, String flag,
			@ModelAttribute("user") MlUser user) {
		Map<String, Object> result = new HashMap<String, Object>();

		if ("ADD".equals(flag)) {
			mortgageInfo.setMortgageId(KeyGenerator.getNextKey("ML_MORTGAGE_INFO", "MORTGAGE_ID"));
			result = addMortgage(mortgageInfo);
		} else if ("UPDATE".equals(flag)) {
			result = updateMortgage(mortgageInfo);
		} else {
			result.put("success", false);
			result.put("msg", "抵押物信息添加异常，服务器端无法正常获取请求数据！");
		}

		return result;
	}

	public Map<String, Object> addMortgage(MlMortgageInfo mortgageInfo) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if (mortgageInfo != null) {
				this.mortgageInfoService.create(mortgageInfo);
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

	public Map<String, Object> updateMortgage(MlMortgageInfo mortgageInfo) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if (mortgageInfo != null) {
				this.mortgageInfoService.update(mortgageInfo);
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

	@RequestMapping(value = "deleteMortgage")
	@ResponseBody
	public Map<String, Object> deleteMortgage(String ids) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if ((ids != null) && (!"".equals(ids.trim()))) {
				this.mortgageInfoService.delete(ids);
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
