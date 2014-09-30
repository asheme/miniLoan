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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.DataGrid;
import com.wealth.miniloan.entity.MlCorpApp;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.CommonServiceI;

@Controller
@RequestMapping(value = "/loan/corp/app")
public class LoanCorpAppController extends BaseController{
	private CommonServiceI<MlCorpApp> loanCorpAppService = null;

	@Autowired
	public void setLoanCorpAppService(CommonServiceI<MlCorpApp> loanCorpAppService) {
		this.loanCorpAppService = loanCorpAppService;
	}

	@RequestMapping(value = "loanCorpAppList")
	@ResponseBody
	public DataGrid getCorpAppList(Page page, MlCorpApp corpApp) {
		DataGrid resut = new DataGrid();
		PageList<MlCorpApp> loanCorpAppList = null;
		loanCorpAppList = this.loanCorpAppService.getPageList(page, corpApp);

		if (loanCorpAppList != null) {
			resut.setRows(loanCorpAppList);
			resut.setTotal(Long.valueOf(loanCorpAppList.getPaginator()
					.getTotalCount()));
		}

		return resut;
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
	@RequestMapping(value="toAddCorpApp")
	public ModelAndView toAddCorpApp() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("loan/modifyCorpApp");
		modelAndView.addObject("flag", "ADD");
		return modelAndView;
	}
	@RequestMapping(value="toUpdateCorpApp")
	public ModelAndView toUpdateCorpApp(MlCorpApp corpApp)
	{
		try {
			corpApp = this.loanCorpAppService.getByPriKey(corpApp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("loan/modifyCorpApp");
		modelAndView.addObject("flag", "UPDATE");
		modelAndView.addObject("corpApp", corpApp);
		return modelAndView;
	}
	@RequestMapping(value="toShowDetail")
	public ModelAndView toShowDetail(String appNo )
	{
		ModelAndView modelAndView=new ModelAndView();
		modelAndView.setViewName("loan/detailCorp");
		return modelAndView;
	}
	
	@RequestMapping(value = "modifyCorpApp")
	@ResponseBody
	public Map<String, Object> modifyCorpApp(MlCorpApp corpApp, String flag)
	{
		Map<String, Object> result = new HashMap<String, Object>();

		if ("ADD".equals(flag)) {
			result =addCorpApp(corpApp);
		} else if ("UPDATE".equals(flag)) {
			result = updateCorpApp(corpApp);
		} else {
			result.put("success", false);
			result.put("msg", "公司申请信息添加异常，服务器端无法正常获取请求数据！");
		}

		return result;
	}
	
	public Map<String, Object> addCorpApp(MlCorpApp corpApp) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			if (corpApp != null) {
				corpApp.setAppNo(super.getAppNo());
				this.loanCorpAppService.create(corpApp);
				result.put("success", true);
				result.put("msg", "公司申请信息添加成功！");
			} else {
				result.put("success", true);
				result.put("msg", "公司申请信息添加失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "服务器端出现异常！");
		}

		return result;
	}

	public Map<String, Object> updateCorpApp(MlCorpApp corpApp) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			if (corpApp != null) {
				this.loanCorpAppService.update(corpApp);
				result.put("success", true);
				result.put("msg", "公司申请信息修改成功！");
			} else {
				result.put("success", false);
				result.put("msg", "公司申请信息修改失败，服务器端未获得要修改的机构信息！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "公司申请信息修改失败，服务器端处理异常！");
		}

		return result;
	}
	
	@RequestMapping(value="deleteCorpApp")
	@ResponseBody
	public Map<String, Object> deleteCorpApp(String ids) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			if ((ids != null) && (!"".equals(ids.trim()))) {
				this.loanCorpAppService.delete(ids);
				result.put("success", true);
				result.put("msg", "公司申请信息删除成功！");
			} else {
				result.put("success", false);
				result.put("msg", "公司申请信息删除失败，服务器端未获得要修改的机构信息！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "公司申请信息删除失败，服务器端处理异常！");
		}

		return result;
	}
}
