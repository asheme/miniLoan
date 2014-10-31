package com.wealth.miniloan.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.wealth.miniloan.serviceImpl.GetMainKeyService;
import com.wealth.miniloan.utils.Constant;

public class BaseController {

	private GetMainKeyService getMainKeyService;

	@Autowired
	public void setGetMainKeyService(GetMainKeyService getMainKeyService) {
		this.getMainKeyService = getMainKeyService;
	}

	public String getAppNo() {
		return getMainKeyService.getKey(Constant.KEY_TYPE_APP_NO);
	}
	
	public String getCustNo() {
		return getMainKeyService.getKey(Constant.KEY_TYPE_CUST_NO);
	}
}
