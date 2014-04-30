package com.wealth.miniloan.controller;

import com.wealth.miniloan.entity.Menu;
import com.wealth.miniloan.entity.User;
import com.wealth.miniloan.service.MenuServiceI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping(value = "/menu")
@SessionAttributes("user")
public class MenuController {
	private MenuServiceI menuService = null;

	public MenuServiceI getMenuService() {
		return this.menuService;
	}

	@Autowired
	public void setMenuService(MenuServiceI menuService) {
		this.menuService = menuService;
	}

	@RequestMapping(value = "loadMenu")
	@ResponseBody
	public Map<String, Object> loadMenu(@ModelAttribute User user) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<Menu> menuList = null;

		try {
			menuList = this.menuService.loadMenu(user);
			result.put("success", "Y");
			result.put("data", menuList);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", "N");
		}

		return result;
	}

	@RequestMapping(value = "userList")
	public String toUserLits() {
		return "system/userList";
	}

	@RequestMapping(value = "roleList")
	public String toRoleLits() {
		return "system/roleList";
	}

	@RequestMapping(value = "rescList")
	public String toRescLits() {
		return "system/rescList";
	}

	@RequestMapping(value = "dictList")
	public String toDictLits() {
		return "config/dictList";
	}
}