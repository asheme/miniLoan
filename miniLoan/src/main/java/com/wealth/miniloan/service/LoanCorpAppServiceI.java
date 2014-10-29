package com.wealth.miniloan.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.CorpAppInfo;
import com.wealth.miniloan.entity.MlCorpApp;
import com.wealth.miniloan.entity.Page;

public interface LoanCorpAppServiceI {
	public PageList<CorpAppInfo> getCorpAppPageList(Page page, CorpAppInfo corpAppInfo);
	
	public abstract int create(MlCorpApp obj);

	public abstract int update(MlCorpApp obj);

	public abstract int delete(String ids);

	public abstract MlCorpApp getByPriKey(MlCorpApp obj);

	public abstract Object getByExample(Object obj);

}
