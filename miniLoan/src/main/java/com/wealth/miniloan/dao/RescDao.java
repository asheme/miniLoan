package com.wealth.miniloan.dao;

import java.util.List;

import com.wealth.miniloan.entity.MlSysResc;
import com.wealth.miniloan.utils.orm.mybatis.BaseMybatisDao;

import org.springframework.stereotype.Repository;

@Repository
public class RescDao extends BaseMybatisDao<MlSysResc, Long> {
	public String getNamespace() {
		return MlSysRescMapper.class.getCanonicalName();
	}

	/**
	 * 查询角色对应的菜单
	 * 
	 * @param roleId
	 * @return
	 */
	public List<MlSysResc> selectByRoleId(Long roleId) {
		return getSqlSession().selectList(
				getMybatisMapperNamesapce() + ".selectByRoleId", roleId);
	}
}