package com.wealth.miniloan.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.MlNaturalApp;
import com.wealth.miniloan.entity.Page;

public interface LoanNaturalAppServiceI {
	public PageList<MlNaturalApp> getLoanNaturalAppPageList(Page paramPage, MlNaturalApp naturalApp);

	public abstract int createNaturalApp(MlNaturalApp paramMlNaturalApp);

	public abstract int updateNaturalApp(MlNaturalApp paramMlNaturalApp);

	public abstract int deleteNaturalApp(String ids);

	public abstract MlNaturalApp getNaturalAppByPriKey(MlNaturalApp paramMlNaturalApp);

}
