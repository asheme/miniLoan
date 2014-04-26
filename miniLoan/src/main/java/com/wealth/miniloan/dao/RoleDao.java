package com.wealth.miniloan.dao;

import java.util.List;

import com.wealth.miniloan.entity.MlRole;
import com.wealth.miniloan.utils.orm.mybatis.BaseMybatisDao;

import org.springframework.stereotype.Repository;

@Repository
public class RoleDao extends BaseMybatisDao<MlRole, Long> {
	public String getNamespace() {
		return MlRoleMapper.class.getCanonicalName();
	}

	/**
	 * 查询用户所具有的角色信息
	 * 
	 * @param userId
	 * @return
	 */
	public List<MlRole> selectByUserId(Long userId) {
		return getSqlSession().selectList(
				getMybatisMapperNamesapce() + ".selectByUserId", userId);
	}
}