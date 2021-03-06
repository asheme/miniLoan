 package com.wealth.miniloan.dao;
 
 import com.wealth.miniloan.entity.MlDict;
 import com.wealth.miniloan.utils.orm.mybatis.BaseMybatisDao;
 import org.springframework.stereotype.Repository;
 
 @Repository
 public class DictDao extends BaseMybatisDao<MlDict, Long>
 {
   public String getNamespace()
   {
     return MlDictMapper.class.getCanonicalName();
   }
 }