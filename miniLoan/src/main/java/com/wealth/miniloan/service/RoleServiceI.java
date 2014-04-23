package com.wealth.miniloan.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.MlRole;
import com.wealth.miniloan.entity.Page;

public abstract interface RoleServiceI
{
  public abstract PageList<MlRole> getRolePageList(Page paramPage, MlRole paramMlRole);

  public abstract MlRole getRoleByPrikey(MlRole paramMlRole);

  public abstract int createRole(MlRole paramMlRole);

  public abstract int updateRoleByPriKey(MlRole paramMlRole);

  public abstract int deleteRoleByPriKey(long paramLong);
}