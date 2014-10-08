package com.wealth.miniloan.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.MlNaturalCredit;
import com.wealth.miniloan.entity.Page;

public interface LoanNaturalCreditServiceI {
	public PageList<MlNaturalCredit> getLoanCorpAppPageList(Page paramPage, MlNaturalCredit NaturalCreditApp);

	public abstract int createNaturalCreditApp(MlNaturalCredit paramMlNaturalCredit);

	public abstract int updateNaturalCreditApp(MlNaturalCredit paramMlNaturalCredit);

	public abstract MlNaturalCredit getCorpAppByPriKey(MlNaturalCredit paramMlNaturalCreditApp);

}
