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
import com.wealth.miniloan.entity.MlCorpAttach;
import com.wealth.miniloan.entity.MlUser;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.CommonServiceI;

@Controller
@RequestMapping(value = "/loan/corp/attach")
@SessionAttributes("user")
public class LoanCorpAttachController extends BaseController{
	private CommonServiceI<MlCorpAttach> loanCorpAttachService = null;

	@Autowired
	public void setloanCorpAttachService(CommonServiceI<MlCorpAttach> loanCorpAttachService) {
		this.loanCorpAttachService = loanCorpAttachService;
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
	public ModelAndView AttachList(MlCorpAttach natural)
	{
    	   String appNo=natural.getAppNo();
    	    ModelAndView modelAndView = new ModelAndView(); 
    		modelAndView.setViewName("loan/CorpAttachList");
    		modelAndView.addObject("appNo",appNo);
    	return modelAndView;
	}
    @RequestMapping(value = "loanCorpAttachList")
	@ResponseBody
	public DataGrid getCorpAttachList(Page page, MlCorpAttach CorpAttach) {
		DataGrid resut = new DataGrid();
		PageList<MlCorpAttach> loanCorpAttachList = null;
		loanCorpAttachList = loanCorpAttachService.getPageList(page, CorpAttach);

		if (loanCorpAttachList != null) {
			resut.setRows(loanCorpAttachList);
			resut.setTotal(Long.valueOf(loanCorpAttachList.getPaginator()
					.getTotalCount()));
		}

		return resut;
	}
    
    @RequestMapping(value="toAddCorpAttach")
	public ModelAndView toAddCorpAttach(String appNo) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("loan/modifyCorpAttach");
		modelAndView.addObject("flag", "ADD");
		modelAndView.addObject("appNo",appNo);
		return modelAndView;
	}
    
	@RequestMapping(value="toUpdateCorpAttach")
	public ModelAndView toUpdateCorpAttach(MlCorpAttach CorpAttach)
	{
		try {
			CorpAttach = this.loanCorpAttachService.getByPriKey(CorpAttach);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("loan/modifyCorpAttach");
		modelAndView.addObject("flag", "UPDATE");
		modelAndView.addObject("corpAttach", CorpAttach);
		return modelAndView;
	}
	
	@RequestMapping(value = "modifyCorpAttach")
	@ResponseBody
	public Map<String, Object> modifyCorpAttach(MlCorpAttach CorpAttach, String flag,
			@ModelAttribute("user") MlUser user)
	{
		Map<String, Object> result = new HashMap<String, Object>();

		if ("ADD".equals(flag)) {
			result =addCorpAttach(CorpAttach);
		} else if ("UPDATE".equals(flag)) {
			result = updateCorpAttach(CorpAttach);
		} else {
			result.put("success", false);
			result.put("msg", "自然人信息添加异常，服务器端无法正常获取请求数据！");
		}

		return result;
	}
	public Map<String, Object> addCorpAttach(MlCorpAttach CorpAttach) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			if (CorpAttach != null) {
				this.loanCorpAttachService.create(CorpAttach);
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

	public Map<String, Object> updateCorpAttach(MlCorpAttach CorpAttach) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			if (CorpAttach != null) {
				this.loanCorpAttachService.update(CorpAttach);
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
	
	@RequestMapping(value="deleteCorpAttach")
	@ResponseBody
	public Map<String, Object> deleteCorpAttach(String ids) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			if ((ids != null) && (!"".equals(ids.trim()))) {
				this.loanCorpAttachService.delete(ids);
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
