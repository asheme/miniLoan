package com.wealth.miniloan.service;

import com.wealth.miniloan.entity.Menu;
import com.wealth.miniloan.entity.User;

import java.util.List;

public abstract interface MenuServiceI {
	public abstract List<Menu> loadMenu(User user);
}