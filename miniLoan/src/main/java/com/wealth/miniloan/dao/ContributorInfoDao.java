package com.wealth.miniloan.dao;


import org.springframework.stereotype.Repository;

import com.wealth.miniloan.entity.MlContributorInfo;
import com.wealth.miniloan.utils.orm.mybatis.BaseMybatisDao;

@Repository
public class ContributorInfoDao extends BaseMybatisDao<MlContributorInfo, Long> {

	@Override
	public String getNamespace() {
		return MlContributorInfoMapper.class.getCanonicalName();
	}

}
