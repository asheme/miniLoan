package com.wealth.miniloan.dao;

import com.wealth.miniloan.entity.MlUserRole;
import com.wealth.miniloan.entity.MlUserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface MlUserRoleMapper
{
  public abstract int countByExample(MlUserRoleExample paramMlUserRoleExample);

  public abstract int deleteByExample(MlUserRoleExample paramMlUserRoleExample);

  public abstract int insert(MlUserRole paramMlUserRole);

  public abstract int insertSelective(MlUserRole paramMlUserRole);

  public abstract List<MlUserRole> selectByExample(MlUserRoleExample paramMlUserRoleExample);

  public abstract int updateByExampleSelective(@Param("record") MlUserRole paramMlUserRole, @Param("example") MlUserRoleExample paramMlUserRoleExample);

  public abstract int updateByExample(@Param("record") MlUserRole paramMlUserRole, @Param("example") MlUserRoleExample paramMlUserRoleExample);
}