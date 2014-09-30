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
import com.wealth.miniloan.entity.MlUser;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.CommonServiceI;

@Controller
@RequestMapping(value = "/loan/natural/attach")
@SessionAttributes("user")
public class LoanNaturalAttachController extends BaseController{
	private CommonServiceI<MlNaturalAttach> loanNaturalAttachService = null;

	@Autowired
	public void setloanNaturalAttachService(CommonServiceI<MlNaturalAttach> loanNaturalAttachService) {
		this.loanNaturalAttachService = loanNaturalAttachService;
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

    @RequestMapping(value="AttachList")
	@ResponseBody
	public ModelAndView AttachList(MlNaturalAttach natural)
	{
    	   String appNo=natural.getAppNo();
    	    ModelAndView modelAndView = new ModelAndView(); 
    		modelAndView.setViewName("loan/NaturalAttachList");
    		modelAndView.addObject("appNo",appNo);
    	return modelAndView;
	}
    @RequestMapping(value = "loanNaturalAttachList")
	@ResponseBody
	public DataGrid getNaturalAttachList(Page page, MlNaturalAttach naturalAttach) {
		DataGrid resut = new DataGrid();
		PageList<MlNaturalAttach> loanNaturalAttachList = null;
		loanNaturalAttachList = loanNaturalAttachService.getPageList(page, naturalAttach);

		if (loanNaturalAttachList != null) {
			resut.setRows(loanNaturalAttachList);
			resut.setTotal(Long.valueOf(loanNaturalAttachList.getPaginator()
					.getTotalCount()));
		}

		return resut;
	}
    
    @RequestMapping(value="toAddNaturalAttach")
	public ModelAndView toAddNaturalAttach(String appNo) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("loan/modifyNaturalAttach");
		modelAndView.addObject("flag", "ADD");
		modelAndView.addObject("appNo",appNo);
		return modelAndView;
	}
    @RequestMapping(value="toUpdateNaturalAttach")
    public ModelAndView toUpdateNaturalAttach(MlNaturalAttach naturalAttach)
    {
    	try {
    		naturalAttach = this.loanNaturalAttachService.getByPriKey(naturalAttach);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("loan/modifyNaturalAttach");
		modelAndView.addObject("flag", "UPDATE");
		modelAndView.addObject("naturalAttach", naturalAttach);
		return modelAndView;
    }
	@RequestMapping(value = "modifyNaturalattach")
	@ResponseBody
	public Map<String, Object> modifyNaturalattach(MlNaturalAttach naturalattach, String flag,
			@ModelAttribute("user") MlUser user)
	{
		Map<String, Object> result = new HashMap<String, Object>();

		if ("ADD".equals(flag)) {
			result =addNaturalAttach(naturalattach);
		} else if ("UPDATE".equals(flag)) {
			result = updateNaturalAttach(naturalattach);
		} else {
			result.put("success", false);
			result.put("msg", "自然人信息添加异常，服务器端无法正常获取请求数据！");
		}

		return result;
	}
	public Map<String, Object> addNaturalAttach(MlNaturalAttach naturalAttach) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			if (naturalAttach != null) {
				this.loanNaturalAttachService.create(naturalAttach);
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

	public Map<String, Object> updateNaturalAttach(MlNaturalAttach naturalAttach) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			if (naturalAttach != null) {
				this.loanNaturalAttachService.update(naturalAttach);
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
	
	@RequestMapping(value="deleteNaturalAttach")
	@ResponseBody
	public Map<String, Object> deleteNaturalAttach(String ids) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			if ((ids != null) && (!"".equals(ids.trim()))) {
				this.loanNaturalAttachService.delete(ids);
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
