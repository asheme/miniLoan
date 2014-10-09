package com.wealth.miniloan.dao;

import org.springframework.stereotype.Repository;

import com.wealth.miniloan.entity.MlAppStrategyResult;
import com.wealth.miniloan.utils.orm.mybatis.BaseMybatisDao;

@Repository
public class AppStrategyResultDao  extends BaseMybatisDao<MlAppStrategyResult, String>{
	@Override
	public String getNamespace() {
		return MlAppStrategyResultMapper.class.getCanonicalName();
	}

}
