package com.wealth.miniloan.service;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.MlCorpAttach;
import com.wealth.miniloan.entity.Page;

public interface LoanCorpAttachServiceI {
	public PageList<MlCorpAttach> getCorpAttachPageList(Page paramPage, MlCorpAttach CorpAttachApp);

	public abstract int createCorpAttach(MlCorpAttach paramMlCorpAttach);

	public abstract int updateCorpAttach(MlCorpAttach paramMlCorpAttach);

	public abstract MlCorpAttach getCorpAttachByPriKey(MlCorpAttach paramMlCorpAttachApp);

	public int deleteCorpAttach(String ids);
	
	public List<MlCorpAttach> getCorpAttachListByIds(String ids);
}
