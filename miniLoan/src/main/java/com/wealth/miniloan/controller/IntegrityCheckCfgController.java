package com.wealth.miniloan.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.DataGrid;
import com.wealth.miniloan.entity.MlInteCheckItem;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.IntegrityCheckCfgServiceI;

@Controller
@RequestMapping(value = "/integrity/cfg")
@SessionAttributes("user")
public class IntegrityCheckCfgController {
	private IntegrityCheckCfgServiceI integrityCheckCfgService;
	
	@Autowired
	public void setIntegrityCheckCfgService(
			IntegrityCheckCfgServiceI integrityCheckCfgService) {
		this.integrityCheckCfgService = integrityCheckCfgService;
	}


	@RequestMapping(value = "integrityCfgList")
	@ResponseBody
	public DataGrid getNaturalAttachList(Page page,MlInteCheckItem inteCheckItem) {
		DataGrid resut = new DataGrid();
		PageList<MlInteCheckItem> integrityCfgList = null;
		integrityCfgList = integrityCheckCfgService.getPageList(page, inteCheckItem);

		if (integrityCfgList != null) {
			resut.setRows(integrityCfgList);
			resut.setTotal(Long.valueOf(integrityCfgList.getPaginator().getTotalCount()));
		}

		return resut;
	}
	
	@RequestMapping(value = "toAddIntegrityCheckItem")
	@ResponseBody
	public ModelAndView toAddIntegrityCheckItem() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("flag", "ADD");
		modelAndView.setViewName("config/modifyIntegrityCheckItem");
		return modelAndView;
	}
	
	@RequestMapping(value = "toUpdateIntegrityCheckItem")
	@ResponseBody
	public ModelAndView toUpdateIntegrityCheckItem(MlInteCheckItem inteCheckItem) {
		try {
			inteCheckItem = this.integrityCheckCfgService.queryIntegrityCheckItemById(inteCheckItem);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("config/modifyIntegrityCheckItem");
		modelAndView.addObject("inteCheckItem", inteCheckItem);
		modelAndView.addObject("flag", "UPDATE");
		return modelAndView;
	}
	
	@RequestMapping(value = "modifyIntegrityCheckItem")
	@ResponseBody
	public Map<String, Object> modifyIntegrityCheckItem(MlInteCheckItem inteCheckItem, String flag) {
		Map<String, Object> result = new HashMap<String, Object>();

		if ("ADD".equals(flag)) {
			result = addIntegrityCheckItem(inteCheckItem);
		} else if ("UPDATE".equals(flag)) {
			result = updateIntegrityCheckItem(inteCheckItem);
		} else {
			result.put("success", Boolean.valueOf(false));
			result.put("msg", "完整性检查项配置处理异常，服务器端无法正常获取请求数据！");
		}

		return result;
	}

	public Map<String, Object> addIntegrityCheckItem(MlInteCheckItem inteCheckItem) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if (inteCheckItem != null) {
				this.integrityCheckCfgService.createIntegrityCheckItem(inteCheckItem);
				result.put("success", true);
				result.put("msg", "完整性检查项配置添加成功！");
			} else {
				result.put("success", true);
				result.put("msg", "完整性检查项配置添加失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "服务器端出现异常");
		}

		return result;
	}

	public Map<String, Object> updateIntegrityCheckItem(MlInteCheckItem inteCheckItem) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			if (inteCheckItem != null) {
				this.integrityCheckCfgService.updateIntegrityCheckItem(inteCheckItem);
				result.put("success", Boolean.valueOf(true));
				result.put("msg", "完整性检查项配置修改成功！");
			} else {
				result.put("success", Boolean.valueOf(false));
				result.put("msg", "完整性检查项配置修改失败，服务器端未获得要修改的数据字典信息！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", Boolean.valueOf(false));
			result.put("msg", "完整性检查项配置修改失败，服务器端处理异常！");
		}

		return result;
	}

	@RequestMapping(value = "deleteIntegrityCheckItem")
	@ResponseBody
	public Map<String, Object> deleteIntegrityCheckItem(String ids) {
		Map<String, Object> result = new HashMap<String, Object>();
		
		try {
			if ((ids != null) && (!"".equals(ids.trim()))) {
				this.integrityCheckCfgService.deleteIntegrityCheckItem(ids);
				result.put("success", true);
				result.put("msg", "完整性检查项配置信息删除成功！");
			} else {
				result.put("success", false);
				result.put("msg", "完整性检查项配置信息删除失败，服务器端未获得要删除的完整性检查项配置！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "完整性检查项配置信息删除失败，服务器端处理异常！");
		}

		return result;
	}
}
