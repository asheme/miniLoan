package com.wealth.miniloan.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.MlNaturalAttach;
import com.wealth.miniloan.entity.Page;

public interface LoanNaturalAttachServiceI {
	public PageList<MlNaturalAttach> getNaturalAttachPageList(Page paramPage, MlNaturalAttach NaturalAttachApp);

	public abstract int createNaturalAttachApp(MlNaturalAttach paramMlNaturalAttach);

	public abstract int updateNaturalAttachApp(MlNaturalAttach paramMlNaturalAttach);

	public abstract MlNaturalAttach getNaturalAttachByPriKey(MlNaturalAttach paramMlNaturalAttachApp);

}
