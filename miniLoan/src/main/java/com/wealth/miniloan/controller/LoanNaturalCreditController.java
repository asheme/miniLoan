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
import com.wealth.miniloan.entity.MlNaturalCredit;
import com.wealth.miniloan.entity.MlUser;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.CommonServiceI;

@Controller
@RequestMapping(value = "/loan/natural/credit")
@SessionAttributes("user")
public class LoanNaturalCreditController extends BaseController{
	private CommonServiceI<MlNaturalCredit> loanNaturalCreditService = null;

	@Autowired
	public void setLoanNaturalCreditService(CommonServiceI<MlNaturalCredit> loanNaturalCreditService) {
		this.loanNaturalCreditService = loanNaturalCreditService;
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

    @RequestMapping(value="CreditDetail")
	@ResponseBody
	public ModelAndView NaturalCredit(MlNaturalCredit natural,String Name)
	{
    	String appNo=natural.getAppNo();
    	try {
    		natural = this.loanNaturalCreditService.getByPriKey(natural);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	   ModelAndView modelAndView = new ModelAndView(); 
    	   if(natural!=null)
    	   {
    		modelAndView.setViewName("loan/CreditDetail");
    		modelAndView.addObject("flag", "DETAIL");
    		modelAndView.addObject("name",Name);
    		modelAndView.addObject("naturalCredit", natural);
    	   }
    	   else{
    		   modelAndView.setViewName("/loan/AddNaturalCredit");
    		   modelAndView.addObject("appNo",appNo);
    		   modelAndView.addObject("flag", "ADD");
    	   }
    	return modelAndView;
	}
	@RequestMapping(value="CreditList")
	@ResponseBody
	public ModelAndView CreditList(String appNo)
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("loan/CreditList");
		modelAndView.addObject("appNo", appNo);
		return modelAndView;
	}
	@RequestMapping(value="CreditAppList")
	@ResponseBody
	public DataGrid getCreditAppList(Page page, MlNaturalCredit naturalcredit) {
		DataGrid resut = new DataGrid();
		PageList<MlNaturalCredit> loanNaturalAppList = null;
		loanNaturalAppList = loanNaturalCreditService.getPageList(page, naturalcredit);

		if (loanNaturalAppList != null) {
			resut.setRows(loanNaturalAppList);
			resut.setTotal(Long.valueOf(loanNaturalAppList.getPaginator()
					.getTotalCount()));
		}

		return resut;
	}
	@RequestMapping(value="toAddNaturalCredit")
	@ResponseBody
	public ModelAndView toAddNaturalCredit(String appNo)
	{
		ModelAndView modelAndView = new ModelAndView();
		MlNaturalCredit naturalCredit=new MlNaturalCredit();
		naturalCredit.setAppNo(appNo);
		modelAndView.setViewName("loan/modifyNaturalCredit");
		modelAndView.addObject("naturalCredit",naturalCredit);
		modelAndView.addObject("flag", "ADD");
		return modelAndView;
	}
	@RequestMapping(value="toUpdateNaturalCredit")
	public ModelAndView toUpdateNaturalCredit(MlNaturalCredit naturalCredit)
	{
		try {
			naturalCredit = this.loanNaturalCreditService.getByPriKey(naturalCredit);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("loan/modifyNaturalCredit");
		modelAndView.addObject("flag", "UPDATE");
		modelAndView.addObject("naturalCredit", naturalCredit);
		return modelAndView;
	}
	@RequestMapping(value = "modifynaturalCredit")
	@ResponseBody
	public Map<String, Object> modifynaturalCredit(MlNaturalCredit naturalCredit, String flag,
			@ModelAttribute("user") MlUser user)
	{
		Map<String, Object> result = new HashMap<String, Object>();

		if ("ADD".equals(flag)) {
			result =addNaturalCredit(naturalCredit);
		} else if ("UPDATE".equals(flag)) {
			result = updateNaturalCredit(naturalCredit);
		} else {
			result.put("success", false);
			result.put("msg", "自然人信息添加异常，服务器端无法正常获取请求数据！");
		}

		return result;
	}
	public Map<String, Object> addNaturalCredit(MlNaturalCredit naturalCredit) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			if (naturalCredit != null) {
				/*naturalCredit.setAppNo(super.getAppNo());*/
				this.loanNaturalCreditService.create(naturalCredit);
				result.put("success", true);
				result.put("msg", "自然人征信申添加成功！");
			} else {
				result.put("success", true);
				result.put("msg", "自然人征信添加失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "服务器端出现异常！");
		}

		return result;
	}

	public Map<String, Object> updateNaturalCredit(MlNaturalCredit naturalCredit) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			if (naturalCredit != null) {
				this.loanNaturalCreditService.update(naturalCredit);
				result.put("success", true);
				result.put("msg", "自然人征信修改成功！");
			} else {
				result.put("success", false);
				result.put("msg", "自然人征信修改失败，服务器端未获得要修改的机构信息！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "自然人征信修改失败，服务器端处理异常！");
		}

		return result;
	}
}
