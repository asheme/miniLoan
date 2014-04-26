package com.wealth.miniloan.service;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.MlRole;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.entity.RescAuthModel;

public abstract interface RoleServiceI {
	public PageList<MlRole> getRolePageList(Page page, MlRole role);

	public MlRole getRoleByPrikey(MlRole role);

	public int createRole(MlRole role);

	public int updateRoleByPriKey(MlRole role);

	public int deleteRoleByPriKey(long roleId);

	public List<RescAuthModel> loadRoleAuthTree(MlRole role);
}