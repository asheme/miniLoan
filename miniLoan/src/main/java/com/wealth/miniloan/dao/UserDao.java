package com.wealth.miniloan.dao;

import com.wealth.miniloan.entity.MlUser;
import com.wealth.miniloan.entity.User;
import com.wealth.miniloan.utils.orm.mybatis.BaseMybatisDao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends BaseMybatisDao<MlUser, Long> {
	public String getNamespace() {
		return MlUserMapper.class.getCanonicalName();
	}
}