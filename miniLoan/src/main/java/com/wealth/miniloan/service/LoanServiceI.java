package com.wealth.miniloan.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.entity.UnionLoanInfo;
import com.wealth.miniloan.entity.User;

public interface LoanServiceI {
	public abstract boolean saveLoanInfo(String appNo,String appType,User user);
	public abstract PageList<UnionLoanInfo> getLoanPageList(Page page,UnionLoanInfo unionLoanInfo);
}
