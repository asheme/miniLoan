package com.wealth.miniloan.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.MlBorrower;
import com.wealth.miniloan.entity.Page;

public interface BorrowerServiceI {
	public PageList<MlBorrower> getList(Page page, MlBorrower param);
	
	public MlBorrower queryById(MlBorrower param);
	
	public int update(MlBorrower param);
}
