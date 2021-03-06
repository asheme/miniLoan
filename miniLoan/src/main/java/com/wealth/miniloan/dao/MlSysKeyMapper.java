package com.wealth.miniloan.dao;

import com.wealth.miniloan.entity.MlSysKey;
import com.wealth.miniloan.entity.MlSysKeyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface MlSysKeyMapper
{
  public abstract int countByExample(MlSysKeyExample paramMlSysKeyExample);

  public abstract int deleteByExample(MlSysKeyExample paramMlSysKeyExample);

  public abstract int insert(MlSysKey paramMlSysKey);

  public abstract int insertSelective(MlSysKey paramMlSysKey);

  public abstract List<MlSysKey> selectByExample(MlSysKeyExample paramMlSysKeyExample);

  public abstract int updateByExampleSelective(@Param("record") MlSysKey paramMlSysKey, @Param("example") MlSysKeyExample paramMlSysKeyExample);

  public abstract int updateByExample(@Param("record") MlSysKey paramMlSysKey, @Param("example") MlSysKeyExample paramMlSysKeyExample);
}