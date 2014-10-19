package com.wealth.miniloan.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.AppSummaryExtend;
import com.wealth.miniloan.entity.MlAppSummary;
import com.wealth.miniloan.entity.Page;

public interface AppSummaryServiceI {
	public PageList<AppSummaryExtend> getPageList(Page paramPage, MlAppSummary obj);
	public PageList<AppSummaryExtend> getAllPageList(Page paramPage, MlAppSummary obj);
	public int create(MlAppSummary obj);
	public int update(MlAppSummary obj);
	public int delete(String ids);
	public MlAppSummary getByPriKey(MlAppSummary obj);
	public Object getByExample(Object obj);
}
