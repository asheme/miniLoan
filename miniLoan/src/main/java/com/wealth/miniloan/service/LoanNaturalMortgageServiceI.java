package com.wealth.miniloan.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.MlNaturalMortgage;
import com.wealth.miniloan.entity.Page;

public interface LoanNaturalMortgageServiceI {
	  public PageList<MlNaturalMortgage> getNaturalMortgagePageList(Page paramPage,MlNaturalMortgage NaturalMortgageApp);
	  public abstract int createNaturalMortgageApp(MlNaturalMortgage paramMlNaturalMortgage);
	  public abstract int updateNaturalMortgageApp(MlNaturalMortgage paramMlNaturalMortgage);
	  public abstract MlNaturalMortgage getNaturalMortgageByPriKey(MlNaturalMortgage paramMlNaturalMortgageApp);

}
