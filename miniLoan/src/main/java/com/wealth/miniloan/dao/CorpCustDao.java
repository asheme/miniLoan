package com.wealth.miniloan.dao;

import org.springframework.stereotype.Repository;

import com.wealth.miniloan.entity.MlCorpCustInfo;
import com.wealth.miniloan.utils.orm.mybatis.BaseMybatisDao;

@Repository
public class CorpCustDao extends BaseMybatisDao<MlCorpCustInfo, String> {

	@Override
	public String getNamespace() {
		return MlCorpCreditMapper.class.getCanonicalName();
	}

}
