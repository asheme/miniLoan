package com.wealth.miniloan.dao;

import org.springframework.stereotype.Repository;

import com.wealth.miniloan.entity.MlAppCheckResult;
import com.wealth.miniloan.utils.orm.mybatis.BaseMybatisDao;

@Repository
public class AppCheckResultDao  extends BaseMybatisDao<MlAppCheckResult, Long>{
	@Override
	public String getNamespace() {
		return MlAppCheckResultMapper.class.getCanonicalName();
	}

}
