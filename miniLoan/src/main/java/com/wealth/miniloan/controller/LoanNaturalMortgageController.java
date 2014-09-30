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
import com.wealth.miniloan.entity.MlNaturalApp;
import com.wealth.miniloan.entity.MlNaturalAttach;
import com.wealth.miniloan.entity.MlNaturalMortgage;
import com.wealth.miniloan.entity.MlUser;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.CommonServiceI;

@Controller
@RequestMapping(value = "/loan/natural/mortgage")
@SessionAttributes("user")
public class LoanNaturalMortgageController extends BaseController{
	private CommonServiceI<MlNaturalMortgage> loanNaturalMortgageService = null;

	@Autowired
	public void setloanNaturalMortgageService(CommonServiceI<MlNaturalMortgage> loanNaturalMortgageService) {
		this.loanNaturalMortgageService = loanNaturalMortgageService;
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

    @RequestMapping(value="MortgageList")
	@ResponseBody
	public ModelAndView MortgageList(MlNaturalMortgage natural)
	{
    	   String appNo=natural.getAppNo();
    	    ModelAndView modelAndView = new ModelAndView(); 
    		modelAndView.setViewName("loan/NaturalMortgageList");
    		modelAndView.addObject("appNo",appNo);
    	return modelAndView;
	}
    @RequestMapping(value = "loanNaturalMortgageList")
	@ResponseBody
	public DataGrid getNaturalMortgageList(Page page, MlNaturalMortgage NaturalMortgage) {
		DataGrid resut = new DataGrid();
		PageList<MlNaturalMortgage> loanNaturalMortgageList = null;
		loanNaturalMortgageList = loanNaturalMortgageService.getPageList(page, NaturalMortgage);

		if (loanNaturalMortgageList != null) {
			resut.setRows(loanNaturalMortgageList);
			resut.setTotal(Long.valueOf(loanNaturalMortgageList.getPaginator()
					.getTotalCount()));
		}

		return resut;
	}
    
    @RequestMapping(value="toAddNaturalMortgage")
	public ModelAndView toAddNaturalMortgage(String appNo) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("loan/modifyNaturalMortgage");
		modelAndView.addObject("flag", "ADD");
		modelAndView.addObject("appNo",appNo);
		return modelAndView;
	}
    
    
    @RequestMapping(value="toUpdateNaturalMortgage")
    public ModelAndView toUpdateNaturalMortgage(MlNaturalMortgage naturalMortgage)
    {
    	try {
    		naturalMortgage = this.loanNaturalMortgageService.getByPriKey(naturalMortgage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("loan/modifyNaturalMortgage");
		modelAndView.addObject("flag", "UPDATE");
		modelAndView.addObject("naturalAttach", naturalMortgage);
		return modelAndView;
    }
	@RequestMapping(value = "modifyNaturalMortgage")
	@ResponseBody
	public Map<String, Object> modifyNaturalMortgage(MlNaturalMortgage NaturalMortgage, String flag,
			@ModelAttribute("user") MlUser user)
	{
		Map<String, Object> result = new HashMap<String, Object>();

		if ("ADD".equals(flag)) {
			result =addNaturalMortgage(NaturalMortgage);
		} else if ("UPDATE".equals(flag)) {
			result = updateNaturalMortgage(NaturalMortgage);
		} else {
			result.put("success", false);
			result.put("msg", "自然人信息添加异常，服务器端无法正常获取请求数据！");
		}

		return result;
	}
	public Map<String, Object> addNaturalMortgage(MlNaturalMortgage NaturalMortgage) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			if (NaturalMortgage != null) {
				this.loanNaturalMortgageService.create(NaturalMortgage);
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

	public Map<String, Object> updateNaturalMortgage(MlNaturalMortgage NaturalMortgage) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			if (NaturalMortgage != null) {
				this.loanNaturalMortgageService.update(NaturalMortgage);
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
	
	@RequestMapping(value="deleteNaturalMortgage")
	@ResponseBody
	public Map<String, Object> deleteNaturalMortgage(String ids) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			if ((ids != null) && (!"".equals(ids.trim()))) {
				this.loanNaturalMortgageService.delete(ids);
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
}
