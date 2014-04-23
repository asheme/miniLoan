package com.wealth.miniloan.dao;

import com.wealth.miniloan.entity.MlDictItem;
import com.wealth.miniloan.entity.MlDictItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface MlDictItemMapper
{
  public abstract int countByExample(MlDictItemExample paramMlDictItemExample);

  public abstract int deleteByExample(MlDictItemExample paramMlDictItemExample);

  public abstract int deleteByPrimaryKey(Long paramLong);

  public abstract int insert(MlDictItem paramMlDictItem);

  public abstract int insertSelective(MlDictItem paramMlDictItem);

  public abstract List<MlDictItem> selectByExample(MlDictItemExample paramMlDictItemExample);

  public abstract MlDictItem selectByPrimaryKey(Long paramLong);

  public abstract int updateByExampleSelective(@Param("record") MlDictItem paramMlDictItem, @Param("example") MlDictItemExample paramMlDictItemExample);

  public abstract int updateByExample(@Param("record") MlDictItem paramMlDictItem, @Param("example") MlDictItemExample paramMlDictItemExample);

  public abstract int updateByPrimaryKeySelective(MlDictItem paramMlDictItem);

  public abstract int updateByPrimaryKey(MlDictItem paramMlDictItem);
}
