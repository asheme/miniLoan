package com.wealth.miniloan.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.MlLoanInfo;
import com.wealth.miniloan.entity.MlPayRecord;
import com.wealth.miniloan.entity.Page;

public interface PayRecordServiceI {
	public PageList<MlPayRecord> getPageList(Page page, MlLoanInfo loanInfo);
	
	public abstract int create(MlPayRecord obj);

	public abstract int update(MlPayRecord obj);

	public abstract int delete(String ids);

	public abstract MlPayRecord getByPriKey(MlPayRecord obj);

	public abstract Object getByExample(Object obj);

}
