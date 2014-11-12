package com.wealth.miniloan.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.MlLoanInfo;
import com.wealth.miniloan.entity.MlLoanReceipt;
import com.wealth.miniloan.entity.Page;

public interface LoanReceiptServiceI {
	public PageList<MlLoanReceipt> getPageList(Page page, MlLoanInfo loanInfo);
	
	public abstract int create(MlLoanReceipt obj);

	public abstract int update(MlLoanReceipt obj);

	public abstract int delete(String ids);

	public abstract MlLoanReceipt getByPriKey(MlLoanReceipt obj);

	public abstract Object getByExample(Object obj);

}
