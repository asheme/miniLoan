package com.wealth.miniloan.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.MlNaturalApp;
import com.wealth.miniloan.entity.Page;

public interface LoanNaturalAppServiceI {
	  public PageList<MlNaturalApp> getLoanNaturalAppPageList(Page paramPage,MlNaturalApp naturalApp);

}
