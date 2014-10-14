package com.wealth.miniloan.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.DataGrid;
import com.wealth.miniloan.entity.MlApproveTaskCfg;
import com.wealth.miniloan.entity.MlDict;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.AppFlowServiceI;

@Controller
@RequestMapping(value = "/appFlow")
public class AppFlowController {
	private AppFlowServiceI appFlowService=null;
	
	@Autowired
	public void setAppFlowService(AppFlowServiceI appFlowService) {
		this.appFlowService = appFlowService;
	}

	@RequestMapping(value = "appFlowList")
	@ResponseBody
	public DataGrid getAppFlowList(Page page, MlApproveTaskCfg appTask) {
		DataGrid result = new DataGrid();
		PageList<MlApproveTaskCfg> appFlowList = null;

		try {
			appFlowList = this.appFlowService.getAppFlowList(page, appTask);
			if (appFlowList.getPaginator().getTotalCount() != 0) {
				result.setTotal(Long.valueOf(appFlowList.getPaginator().getTotalCount()));
				result.setRows(appFlowList);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping(value = "toAddAppFlow")
	@ResponseBody
	public ModelAndView toAddDict() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("flag", "ADD");
		modelAndView.setViewName("config/modifyAppFlow");
		return modelAndView;
	}
	
	@RequestMapping(value = "toUpdateAppFlow")
	@ResponseBody
	public ModelAndView toUpdateAppFlow(MlApproveTaskCfg appTask) {
		try {
			appTask = this.appFlowService.queryAppFlowById(appTask);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("config/modifyAppFlow");
		modelAndView.addObject("appTask", appTask);
		modelAndView.addObject("flag", "UPDATE");
		return modelAndView;
	}
	
	@RequestMapping(value = "modifyAppFlow")
	@ResponseBody
	public Map<String, Object> modifyAppFlow(MlApproveTaskCfg appTask, String flag) {
		Map<String, Object> result = new HashMap<String, Object>();

		if ("ADD".equals(flag)) {
			result = addAppFlow(appTask);
		} else if ("UPDATE".equals(flag)) {
			result = updateAppFlow(appTask);
		} else {
			result.put("success", Boolean.valueOf(false));
			result.put("msg", "流程任务处理异常，服务器端无法正常获取请求数据！");
		}

		return result;
	}

	public Map<String, Object> addAppFlow(MlApproveTaskCfg appTask) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if (appTask != null) {
				this.appFlowService.createAppFlow(appTask);
				result.put("success", true);
				result.put("msg", "流程任务添加成功！");
			} else {
				result.put("success", true);
				result.put("msg", "流程任务添加失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "服务器端出现异常");
		}

		return result;
	}

	public Map<String, Object> updateAppFlow(MlApproveTaskCfg appTask) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			if (appTask != null) {
				this.appFlowService.updateAppFlow(appTask);
				result.put("success", Boolean.valueOf(true));
				result.put("msg", "流程任务修改成功！");
			} else {
				result.put("success", Boolean.valueOf(false));
				result.put("msg", "流程任务修改失败，服务器端未获得要修改的流程任务信息！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", Boolean.valueOf(false));
			result.put("msg", "流程任务修改失败，服务器端处理异常！");
		}

		return result;
	}
	
	@RequestMapping(value = "deleteAppFlow")
	@ResponseBody
	public Map<String, Object> deleteAppFlow(String ids) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			if ((ids != null) && (!"".equals(ids.trim()))) {
				this.appFlowService.deleteAppFlow(ids);
				result.put("success", true);
				result.put("msg", "流程任务信息删除成功！");
			} else {
				result.put("success", false);
				result.put("msg", "流程任务信息删除失败，服务器端未获得要删除的流程任务信息！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "流程任务信息删除失败，服务器端处理异常！");
		}

		return result;
	}
}
