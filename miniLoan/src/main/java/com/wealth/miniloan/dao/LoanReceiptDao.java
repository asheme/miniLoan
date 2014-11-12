package com.wealth.miniloan.dao;

import org.springframework.stereotype.Repository;

import com.wealth.miniloan.entity.MlLoanReceipt;
import com.wealth.miniloan.utils.orm.mybatis.BaseMybatisDao;

@Repository
public class LoanReceiptDao  extends BaseMybatisDao<MlLoanReceipt, Long>{
	@Override
	public String getNamespace() {
		return MlLoanReceiptMapper.class.getCanonicalName();
	}

}
