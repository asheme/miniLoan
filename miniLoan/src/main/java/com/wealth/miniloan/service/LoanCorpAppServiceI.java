package com.wealth.miniloan.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.AppSummaryExtend;
import com.wealth.miniloan.entity.MlCorpApp;
import com.wealth.miniloan.entity.Page;

public interface LoanCorpAppServiceI {
	public PageList<MlCorpApp> getLoanCorpAppPageList(Page paramPage, MlCorpApp corpApp);
	
	public PageList<AppSummaryExtend> getSummaryPageList(Page paramPage, MlCorpApp obj);
	
	public abstract int create(MlCorpApp obj);

	public abstract int update(MlCorpApp obj);

	public abstract int delete(String ids);

	public abstract MlCorpApp getByPriKey(MlCorpApp obj);

	public abstract Object getByExample(Object obj);

}
