package com.wealth.miniloan.service;

import com.wealth.miniloan.entity.MlUser;

public abstract interface LoginServiceI
{
  public abstract MlUser getLoginUserInfo(String paramString);
}