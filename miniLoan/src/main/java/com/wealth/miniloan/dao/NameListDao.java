 package com.wealth.miniloan.dao;
 
 import org.springframework.stereotype.Repository;

import com.wealth.miniloan.entity.MlNameList;
import com.wealth.miniloan.utils.orm.mybatis.BaseMybatisDao;
 
 @Repository
 public class NameListDao extends BaseMybatisDao<MlNameList, Long>
 {
   public String getNamespace()
   {
     return MlNameListMapper.class.getCanonicalName();
   }
 }