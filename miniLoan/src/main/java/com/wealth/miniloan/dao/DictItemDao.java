 package com.wealth.miniloan.dao;
 
 import com.wealth.miniloan.entity.MlDictItem;
 import com.wealth.miniloan.utils.orm.mybatis.BaseMybatisDao;
 import org.springframework.stereotype.Repository;
 
 @Repository
 public class DictItemDao extends BaseMybatisDao<MlDictItem, Long>
 {
   public String getNamespace()
   {
     return MlDictItemMapper.class.getCanonicalName();
   }
 }