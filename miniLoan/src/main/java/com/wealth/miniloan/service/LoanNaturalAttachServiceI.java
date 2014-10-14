package com.wealth.miniloan.service;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.MlNaturalAttach;
import com.wealth.miniloan.entity.Page;

public interface LoanNaturalAttachServiceI {
	public PageList<MlNaturalAttach> getNaturalAttachPageList(Page paramPage, MlNaturalAttach NaturalAttachApp);

	public abstract int createNaturalAttach(MlNaturalAttach paramMlNaturalAttach);

	public abstract int updateNaturalAttach(MlNaturalAttach paramMlNaturalAttach);

	public abstract MlNaturalAttach getNaturalAttachByPriKey(MlNaturalAttach paramMlNaturalAttachApp);
	
	public int deleteNaturalAttach(String ids);
	
	public List<MlNaturalAttach> getNaturalAttachListByIds(String ids);

}
