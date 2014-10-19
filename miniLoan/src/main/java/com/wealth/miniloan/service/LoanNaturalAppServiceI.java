package com.wealth.miniloan.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.AppSummaryExtend;
import com.wealth.miniloan.entity.MlNaturalApp;
import com.wealth.miniloan.entity.Page;

public interface LoanNaturalAppServiceI {
	public PageList<MlNaturalApp> getPageList(Page paramPage, MlNaturalApp obj);
	
	public PageList<AppSummaryExtend> getSummaryPageList(Page paramPage, MlNaturalApp obj);

	public abstract int create(MlNaturalApp obj);

	public abstract int update(MlNaturalApp obj);

	public abstract int delete(String ids);

	public abstract MlNaturalApp getByPriKey(MlNaturalApp obj);

	public abstract Object getByExample(Object obj);

}
