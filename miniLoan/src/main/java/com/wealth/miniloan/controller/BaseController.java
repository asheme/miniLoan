package com.wealth.miniloan.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.wealth.miniloan.serviceImpl.GetAppNoService;

public class BaseController {

	private GetAppNoService getAppNoService;

	@Autowired
	public void setGetAppNoService(GetAppNoService getAppNoService) {
		this.getAppNoService = getAppNoService;
	}

	public String getAppNo() {
		return getAppNoService.getAppNo();
	}
}
