 package com.wealth.miniloan.dao;
 
 import com.wealth.miniloan.entity.MlRole;
 import com.wealth.miniloan.utils.orm.mybatis.BaseMybatisDao;
 import org.springframework.stereotype.Repository;
 
 @Repository
 public class RoleDao extends BaseMybatisDao<MlRole, Long>
 {
   public String getNamespace()
   {
     return MlRoleMapper.class.getCanonicalName();
   }
 }