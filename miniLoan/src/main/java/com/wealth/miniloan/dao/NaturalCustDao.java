package com.wealth.miniloan.dao;

import org.springframework.stereotype.Repository;

import com.wealth.miniloan.entity.MlNaturalCustInfo;
import com.wealth.miniloan.utils.orm.mybatis.BaseMybatisDao;

@Repository
public class NaturalCustDao extends BaseMybatisDao<MlNaturalCustInfo, String> {

	@Override
	public String getNamespace() {
		return MlNaturalCustInfoMapper.class.getCanonicalName();
	}

}
