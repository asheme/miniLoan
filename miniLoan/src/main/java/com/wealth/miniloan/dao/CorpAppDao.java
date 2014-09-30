package com.wealth.miniloan.dao;

import org.springframework.stereotype.Repository;

import com.wealth.miniloan.entity.MlCorpApp;
import com.wealth.miniloan.utils.orm.mybatis.BaseMybatisDao;

@Repository
public class CorpAppDao  extends BaseMybatisDao<MlCorpApp, String>{
	@Override
	public String getNamespace() {
		return MlCorpAppMapper.class.getCanonicalName();
	}

}
