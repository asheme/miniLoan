package com.wealth.miniloan.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.MlUser;
import com.wealth.miniloan.entity.Page;

public abstract interface UserServiceI {
	public abstract PageList<MlUser> getUserPageList(Page paramPage, MlUser paramMlUser);

	public abstract MlUser getUserByPriKey(MlUser paramMlUser);

	public abstract int createUser(MlUser paramMlUser);

	public abstract int updateUser(MlUser paramMlUser);

	public abstract int deleteUserByKeys(String paramString);

	public abstract int deleteUserRoleByKeys(String paramString);

	public abstract boolean isRoleBindWithUser(long paramLong);

	public void initializePassword(String ids);

	public void addUserRoles(String ids, long userId);

	public int deleteUserRole(String ids, long userId);
}