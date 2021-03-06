package com.wealth.miniloan.dao;


import org.springframework.stereotype.Repository;

import com.wealth.miniloan.entity.MlCapitalContrInfo;
import com.wealth.miniloan.utils.orm.mybatis.BaseMybatisDao;

@Repository
public class CapitalContrInfoDao extends BaseMybatisDao<MlCapitalContrInfo, Long> {

	@Override
	public String getNamespace() {
		return MlCapitalContrInfoMapper.class.getCanonicalName();
	}

}
