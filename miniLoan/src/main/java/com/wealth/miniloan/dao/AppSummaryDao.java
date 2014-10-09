package com.wealth.miniloan.dao;

import org.springframework.stereotype.Repository;

import com.wealth.miniloan.entity.MlAppSummary;
import com.wealth.miniloan.utils.orm.mybatis.BaseMybatisDao;

@Repository
public class AppSummaryDao  extends BaseMybatisDao<MlAppSummary, String>{
	@Override
	public String getNamespace() {
		return MlAppSummaryMapper.class.getCanonicalName();
	}

}
