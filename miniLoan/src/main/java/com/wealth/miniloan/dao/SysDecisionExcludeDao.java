package com.wealth.miniloan.dao;

import org.springframework.stereotype.Repository;

import com.wealth.miniloan.entity.MlSysDecisionExclude;
import com.wealth.miniloan.utils.orm.mybatis.BaseMybatisDao;

@Repository
public class SysDecisionExcludeDao extends BaseMybatisDao<MlSysDecisionExclude, Long> {

	@Override
	public String getNamespace() {
		return MlSysDecisionExcludeMapper.class.getCanonicalName();
	}

}
