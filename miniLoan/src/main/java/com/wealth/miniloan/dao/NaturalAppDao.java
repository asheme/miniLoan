package com.wealth.miniloan.dao;

import org.springframework.stereotype.Repository;

import com.wealth.miniloan.entity.MlNaturalApp;
import com.wealth.miniloan.utils.orm.mybatis.BaseMybatisDao;

@Repository
public class NaturalAppDao  extends BaseMybatisDao<MlNaturalApp, String>{
	@Override
	public String getNamespace() {
		return MlNaturalAppMapper.class.getCanonicalName();
	}

}
