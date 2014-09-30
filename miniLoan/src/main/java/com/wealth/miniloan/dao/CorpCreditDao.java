package com.wealth.miniloan.dao;

import org.springframework.stereotype.Repository;

import com.wealth.miniloan.entity.MlCorpCredit;
import com.wealth.miniloan.entity.MlNaturalApp;
import com.wealth.miniloan.entity.MlNaturalCredit;
import com.wealth.miniloan.utils.orm.mybatis.BaseMybatisDao;

@Repository
public class CorpCreditDao  extends BaseMybatisDao<MlCorpCredit, String>{
	@Override
	public String getNamespace() {
		return MlCorpCreditMapper.class.getCanonicalName();
	}

}
