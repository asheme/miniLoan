package com.wealth.miniloan.dao;

import org.springframework.stereotype.Repository;

import com.wealth.miniloan.entity.MlRoleResc;
import com.wealth.miniloan.utils.orm.mybatis.BaseMybatisDao;

@Repository
public class RoleRescDao extends BaseMybatisDao<MlRoleResc, Long> {

	@Override
	public String getNamespace() {
		return MlRoleRescMapper.class.getCanonicalName();
	}

}
