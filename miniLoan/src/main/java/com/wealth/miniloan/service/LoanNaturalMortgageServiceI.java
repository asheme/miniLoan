package com.wealth.miniloan.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.MlMortgageInfo;
import com.wealth.miniloan.entity.Page;

public interface LoanNaturalMortgageServiceI {
	public PageList<MlMortgageInfo> getNaturalMortgagePageList(Page paramPage, MlMortgageInfo NaturalMortgageApp);

	public abstract int createNaturalMortgageApp(MlMortgageInfo paramMlNaturalMortgage);

	public abstract int updateNaturalMortgageApp(MlMortgageInfo paramMlNaturalMortgage);

	public abstract MlMortgageInfo getNaturalMortgageByPriKey(MlMortgageInfo paramMlNaturalMortgageApp);

}
