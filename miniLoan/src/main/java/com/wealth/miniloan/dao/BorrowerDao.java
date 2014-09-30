 package com.wealth.miniloan.dao;
 
 import com.wealth.miniloan.entity.MlBorrower;
import com.wealth.miniloan.utils.orm.mybatis.BaseMybatisDao;
import org.springframework.stereotype.Repository;
 
 @Repository
 public class BorrowerDao extends BaseMybatisDao<MlBorrower, Long>
 {
   public String getNamespace()
   {
     return MlBorrowerMapper.class.getCanonicalName();
   }
 }