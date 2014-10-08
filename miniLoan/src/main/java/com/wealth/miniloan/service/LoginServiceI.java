package com.wealth.miniloan.service;

import com.wealth.miniloan.entity.MlUser;
import com.wealth.miniloan.entity.User;

public abstract interface LoginServiceI {
	public User getLoginUserPersistInfo(String loginId);

	public MlUser getUserInfoByLoginId(String loginId);
}