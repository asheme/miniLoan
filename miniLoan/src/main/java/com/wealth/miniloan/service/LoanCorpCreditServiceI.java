package com.wealth.miniloan.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.MlCorpApp;
import com.wealth.miniloan.entity.MlCorpCredit;
import com.wealth.miniloan.entity.MlNaturalCredit;
import com.wealth.miniloan.entity.Page;

public interface LoanCorpCreditServiceI {
	  public PageList<MlCorpCredit> getLoanCorpAppPageList(Page paramPage,MlNaturalCredit NaturalCreditApp);
	  public abstract int createCorpCreditApp(MlCorpCredit paramMlCorpCredit);
	  public abstract int updateCorpCreditApp(MlCorpCredit paramMlCorpCredit);
	  public abstract MlCorpCredit getCorpCreditByPriKey(MlCorpCredit paramMlCorpCreditApp);

}
