package com.wealth.miniloan.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.MlCorpApp;
import com.wealth.miniloan.entity.Page;

public interface LoanCorpAppServiceI {
	public PageList<MlCorpApp> getLoanCorpAppPageList(Page paramPage, MlCorpApp corpApp);

	public abstract int createCorpApp(MlCorpApp paramMlCorpApp);

	public abstract int updateCorpApp(MlCorpApp paramMlCorpApp);

	public abstract MlCorpApp getCorpAppByPriKey(MlCorpApp paramMlCorpApp);

}
