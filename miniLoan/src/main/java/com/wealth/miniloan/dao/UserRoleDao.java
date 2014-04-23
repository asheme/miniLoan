 package com.wealth.miniloan.dao;
 
 import com.wealth.miniloan.entity.MlUserRole;
 import com.wealth.miniloan.utils.orm.mybatis.BaseMybatisDao;
 import org.springframework.stereotype.Repository;
 
 @Repository
 public class UserRoleDao extends BaseMybatisDao<MlUserRole, Long>
 {
   public String getNamespace()
   {
     return MlUserRoleMapper.class.getCanonicalName();
   }
 }