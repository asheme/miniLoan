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
import com.wealth.miniloan.entity.MlNameList;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.CommonServiceI;
import com.wealth.miniloan.utils.key.KeyGenerator;

@Controller
@RequestMapping(value = "/blacknames")
public class BlackNameListController extends BaseController {
	private CommonServiceI<MlNameList> nameListService = null;

	@Autowired
	public void setNameListService(CommonServiceI<MlNameList> nameListService) {
		this.nameListService = nameListService;
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

	@RequestMapping(value = "toGetNameList")
	public ModelAndView toGetNameList(String nameType) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("nameList/blackNameList");
		modelAndView.addObject("nameType", nameType);
		return modelAndView;
	}

	@RequestMapping(value = "getNameList")
	@ResponseBody
	public DataGrid getNameList(Page page, MlNameList name) {
		DataGrid resut = new DataGrid();
		PageList<MlNameList> nameList = null;
		nameList = this.nameListService.getPageList(page, name);

		if (nameList != null) {
			resut.setRows(nameList);
			resut.setTotal(Long.valueOf(nameList.getPaginator().getTotalCount()));
		}

		return resut;
	}

	@RequestMapping(value = "toAddName")
	public ModelAndView toAddName() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("nameList/modifyBlackName");
		modelAndView.addObject("flag", "ADD");
		return modelAndView;
	}

	@RequestMapping(value = "toUpdateName")
	public ModelAndView toUpdateName(MlNameList name) {
		try {
			name = this.nameListService.getByPriKey(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("nameList/modifyBlackName");
		modelAndView.addObject("flag", "UPDATE");
		modelAndView.addObject("name", name);
		return modelAndView;
	}

	@RequestMapping(value = "modifyName")
	@ResponseBody
	public Map<String, Object> modifyName(MlNameList name, String flag) {
		Map<String, Object> result = new HashMap<String, Object>();

		if ("ADD".equals(flag)) {
			result = addName(name);
		} else if ("UPDATE".equals(flag)) {
			result = updateName(name);
		} else {
			result.put("success", false);
			result.put("msg", "名单信息添加异常，服务器端无法正常获取请求数据！");
		}

		return result;
	}

	public Map<String, Object> addName(MlNameList name) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if (name != null) {
				name.setNameId(KeyGenerator.getNextKey("ML_NAME_LIST", "NAME_ID"));
				this.nameListService.create(name);
				result.put("success", true);
				result.put("msg", "名单信息添加成功！");
			} else {
				result.put("success", true);
				result.put("msg", "名单信息添加失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "服务器端出现异常！");
		}

		return result;
	}

	public Map<String, Object> updateName(MlNameList name) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if (name != null) {
				this.nameListService.update(name);
				result.put("success", true);
				result.put("msg", "名单信息修改成功！");
			} else {
				result.put("success", false);
				result.put("msg", "名单信息修改失败，服务器端未获得要修改的机构信息！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "名单信息修改失败，服务器端处理异常！");
		}

		return result;
	}

	@RequestMapping(value = "deleteName")
	@ResponseBody
	public Map<String, Object> deleteName(String ids) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if ((ids != null) && (!"".equals(ids.trim()))) {
				this.nameListService.delete(ids);
				result.put("success", true);
				result.put("msg", "名单信息删除成功！");
			} else {
				result.put("success", false);
				result.put("msg", "名单信息删除失败，服务器端未获得要修改信息！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "名单信息删除失败，服务器端处理异常！");
		}

		return result;
	}

}
