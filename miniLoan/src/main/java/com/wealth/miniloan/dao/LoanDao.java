package com.wealth.miniloan.dao;

import org.springframework.stereotype.Repository;

import com.wealth.miniloan.entity.MlLoanInfo;
import com.wealth.miniloan.utils.orm.mybatis.BaseMybatisDao;

@Repository
public class LoanDao extends BaseMybatisDao<MlLoanInfo, Long> {

	@Override
	public String getNamespace() {
		return MlLoanInfoMapper.class.getCanonicalName();
	}

}
