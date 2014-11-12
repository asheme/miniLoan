package com.wealth.miniloan.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.MlCorpCustInfo;
import com.wealth.miniloan.entity.MlLoanInfo;
import com.wealth.miniloan.entity.MlNaturalCustInfo;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.entity.UnionLoanInfo;
import com.wealth.miniloan.entity.User;

public interface LoanServiceI {
	public abstract boolean saveLoanInfo(String appNo,String appType,User user);
	public abstract PageList<UnionLoanInfo> getLoanPageList(Page page,UnionLoanInfo unionLoanInfo);
	public abstract MlLoanInfo getLoanInfo(MlLoanInfo loanInfo);
	public abstract MlNaturalCustInfo getNaturalCustInfoByLoanInfo(MlLoanInfo loanInfo);
	public abstract MlCorpCustInfo getCorpCustInfoByLoanInfo(MlLoanInfo loanInfo);
	public abstract void update(MlLoanInfo loanInfo);
}
