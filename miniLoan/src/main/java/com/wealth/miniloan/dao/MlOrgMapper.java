package com.wealth.miniloan.dao;

import com.wealth.miniloan.entity.MlOrg;
import com.wealth.miniloan.entity.MlOrgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface MlOrgMapper
{
  public abstract int countByExample(MlOrgExample paramMlOrgExample);

  public abstract int deleteByExample(MlOrgExample paramMlOrgExample);

  public abstract int deleteByPrimaryKey(String paramString);

  public abstract int insert(MlOrg paramMlOrg);

  public abstract int insertSelective(MlOrg paramMlOrg);

  public abstract List<MlOrg> selectByExample(MlOrgExample paramMlOrgExample);

  public abstract MlOrg selectByPrimaryKey(String paramString);

  public abstract int updateByExampleSelective(@Param("record") MlOrg paramMlOrg, @Param("example") MlOrgExample paramMlOrgExample);

  public abstract int updateByExample(@Param("record") MlOrg paramMlOrg, @Param("example") MlOrgExample paramMlOrgExample);

  public abstract int updateByPrimaryKeySelective(MlOrg paramMlOrg);

  public abstract int updateByPrimaryKey(MlOrg paramMlOrg);
}