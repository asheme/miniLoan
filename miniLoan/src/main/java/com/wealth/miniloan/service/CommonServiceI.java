package com.wealth.miniloan.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.Page;

public abstract interface CommonServiceI<T> {
	public PageList<T> getPageList(Page paramPage,T obj);
	  public abstract int create(T obj);
	  public abstract int update(T obj);
	  public abstract int delete(String ids);
	  public abstract T getByPriKey(T obj);
}