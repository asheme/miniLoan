package com.wealth.miniloan.dao;

import org.springframework.stereotype.Repository;

import com.wealth.miniloan.entity.MlRoleAuth;
import com.wealth.miniloan.utils.orm.mybatis.BaseMybatisDao;

@Repository
public class RoleAuthDao extends BaseMybatisDao<MlRoleAuth, Long> {

	@Override
	public String getNamespace() {
		return MlRoleAuthMapper.class.getCanonicalName();
	}

}
