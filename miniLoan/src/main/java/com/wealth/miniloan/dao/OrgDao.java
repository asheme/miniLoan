package com.wealth.miniloan.dao;

import org.springframework.stereotype.Repository;

import com.wealth.miniloan.entity.MlOrg;
import com.wealth.miniloan.utils.orm.mybatis.BaseMybatisDao;

@Repository
public class OrgDao extends BaseMybatisDao<MlOrg, String> {

	@Override
	public String getNamespace() {
		return MlOrgMapper.class.getCanonicalName();
	}

}
