package com.wealth.miniloan.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.AppSummaryExtend;
import com.wealth.miniloan.entity.MlAppSummary;
import com.wealth.miniloan.entity.MlUser;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.entity.UnionLoanApp;
import com.wealth.miniloan.entity.User;

public interface AppSummaryServiceI {
	public PageList<UnionLoanApp> getLoanAppPageList(Page paramPage, UnionLoanApp unionLoanApp, User user);
	public PageList<UnionLoanApp> queryLoanAppPageList(Page paramPage, UnionLoanApp unionLoanApp);
	public PageList<AppSummaryExtend> getAllPageList(Page paramPage, AppSummaryExtend appSummary);
	public int create(MlAppSummary obj);
	public int update(MlAppSummary obj);
	public int delete(String ids);
	public MlAppSummary getByPriKey(MlAppSummary obj);
	public Object getByExample(Object obj);
}
