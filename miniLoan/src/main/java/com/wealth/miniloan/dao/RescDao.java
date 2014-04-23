 package com.wealth.miniloan.dao;
 
 import com.wealth.miniloan.entity.MlSysResc;
 import com.wealth.miniloan.utils.orm.mybatis.BaseMybatisDao;
 import org.springframework.stereotype.Repository;
 
 @Repository
 public class RescDao extends BaseMybatisDao<MlSysResc, Long>
 {
   public String getNamespace()
   {
     return MlSysRescMapper.class.getCanonicalName();
   }
 }