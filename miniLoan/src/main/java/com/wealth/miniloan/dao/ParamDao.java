package com.wealth.miniloan.dao;

import org.springframework.stereotype.Repository;

import com.wealth.miniloan.entity.MlSysParam;
import com.wealth.miniloan.utils.orm.mybatis.BaseMybatisDao;

@Repository
public class ParamDao extends BaseMybatisDao<MlSysParam, Long> {

	@Override
	public String getNamespace() {
		return MlSysParamMapper.class.getCanonicalName();
	}

}
