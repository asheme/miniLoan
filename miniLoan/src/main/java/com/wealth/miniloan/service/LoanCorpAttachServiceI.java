package com.wealth.miniloan.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.MlCorpAttach;
import com.wealth.miniloan.entity.Page;

public interface LoanCorpAttachServiceI {
	  public PageList<MlCorpAttach> getCorpAttachPageList(Page paramPage,MlCorpAttach CorpAttachApp);
	  public abstract int createCorpAttachApp(MlCorpAttach paramMlCorpAttach);
	  public abstract int updateCorpAttachApp(MlCorpAttach paramMlCorpAttach);
	  public abstract MlCorpAttach getCorpAttachByPriKey(MlCorpAttach paramMlCorpAttachApp);

}
