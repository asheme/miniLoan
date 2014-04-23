 package com.wealth.miniloan.serviceImpl;
 
 import com.github.miemiedev.mybatis.paginator.domain.PageList;
 import com.wealth.miniloan.dao.RoleDao;
 import com.wealth.miniloan.entity.MlRole;
 import com.wealth.miniloan.entity.MlRoleExample;
 import com.wealth.miniloan.entity.MlRoleExample.Criteria;
 import com.wealth.miniloan.entity.Page;
 import com.wealth.miniloan.service.RoleServiceI;
 import com.wealth.miniloan.utils.SysUtil;
 import com.wealth.miniloan.utils.key.KeyGenerator;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;
 
 @Service("roleService")
 public class RoleServiceImpl
   implements RoleServiceI
 {
   private RoleDao roleDao = null;
   private final String _ORDER_ATTRS = "roleName,status";
   private final String _ORDER_FIELDS = "ROLE_NAME,STATUS";
 
   public RoleDao getRoleDao() {
     return this.roleDao;
   }
   @Autowired
   public void setRoleDao(RoleDao roleDao) {
     this.roleDao = roleDao;
   }
 
   public PageList<MlRole> getRolePageList(Page page, MlRole role)
   {
     MlRoleExample example = new MlRoleExample();
     String roleName = role.getRoleName();
     String roleDesc = role.getRoleDesc();
     MlRoleExample.Criteria criteria = example.createCriteria();
     if ((roleName != null) && (!"".equals(roleName))) {
       criteria.andRoleNameLike("%" + roleName + "%");
     }
     if ((roleDesc != null) && (!"".equals(roleDesc))) {
       criteria.andRoleDescLike("%" + roleDesc + "%");
     }
 
     String order = SysUtil.dealOrderby(page, "roleName,status", "ROLE_NAME,STATUS");
     if (!"".equals(order)) {
       example.setOrderByClause(order);
     }
 
     return this.roleDao.findPage(SysUtil.convertPage(page), example);
   }
 
   public MlRole getRoleByPrikey(MlRole role)
   {
     return (MlRole)this.roleDao.getById(role.getRoleId());
   }
 
   public int createRole(MlRole role)
   {
     role.setRoleId(KeyGenerator.getNextKey("ML_ROLE", "ROLE_ID"));
     return this.roleDao.save(role);
   }
 
   public int updateRoleByPriKey(MlRole role)
   {
     return this.roleDao.update(role);
   }
 
   public int deleteRoleByPriKey(long id)
   {
     return this.roleDao.deleteById(Long.valueOf(id));
   }
 }