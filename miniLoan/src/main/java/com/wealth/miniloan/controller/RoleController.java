 package com.wealth.miniloan.controller;
 
 import com.github.miemiedev.mybatis.paginator.domain.PageList;
 import com.github.miemiedev.mybatis.paginator.domain.Paginator;
 import com.wealth.miniloan.entity.DataGrid;
 import com.wealth.miniloan.entity.MlRole;
 import com.wealth.miniloan.entity.Page;
 import com.wealth.miniloan.service.RoleServiceI;
 import com.wealth.miniloan.service.UserServiceI;
 import java.util.Date;
 import java.util.HashMap;
 import java.util.Map;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Controller;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.ResponseBody;
 import org.springframework.web.servlet.ModelAndView;
 
 @Controller
 @RequestMapping({"/role"})
 public class RoleController
 {
   private RoleServiceI roleService = null;
   private UserServiceI userService = null;
 
   public RoleServiceI getRoleService() {
     return this.roleService;
   }
   @Autowired
   public void setRoleService(RoleServiceI roleService) {
     this.roleService = roleService;
   }
 
   public UserServiceI getUserService() {
     return this.userService;
   }
   @Autowired
   public void setUserService(UserServiceI userService) {
     this.userService = userService;
   }
   @RequestMapping({"roleList"})
   @ResponseBody
   public DataGrid getRoleList(Page page, MlRole role) { PageList roleList = null;
     DataGrid result = new DataGrid();
     try
     {
       roleList = this.roleService.getRolePageList(page, role);
       if (roleList != null) {
         result.setTotal(Long.valueOf(roleList.getPaginator().getTotalCount()));
         result.setRows(roleList);
       }
     } catch (Exception e) {
       e.printStackTrace();
     }
 
     return result; }
 
   @RequestMapping({"toAddRole"})
   public ModelAndView toAddRole() {
     ModelAndView modelViewRole = new ModelAndView();
     modelViewRole.setViewName("system/modifyRole");
     modelViewRole.addObject("flag", "ADD");
     return modelViewRole;
   }
   @RequestMapping({"toUpdateRole"})
   public ModelAndView toUpdateRole(MlRole role) {
     role = this.roleService.getRoleByPrikey(role);
     ModelAndView modelViewRole = new ModelAndView();
     modelViewRole.setViewName("system/modifyRole");
     modelViewRole.addObject("flag", "UPDATE");
     modelViewRole.addObject("role", role);
     return modelViewRole;
   }
   @RequestMapping({"modifyRole"})
   @ResponseBody
   public Map<String, Object> modifyRole(MlRole role, String flag) { Map result = new HashMap();
 
     if ("ADD".equals(flag))
     {
       result = addRole(role);
     } else if ("UPDATE".equals(flag))
     {
       result = updateRole(role);
     } else {
       result.put("success", Boolean.valueOf(false));
       result.put("msg", "角色信息添加异常，服务器端无法正常获取请求数据！");
     }
 
     return result; }
 
   public Map<String, Object> addRole(MlRole role)
   {
     Map result = new HashMap();
     try
     {
       if (role != null) {
         role.setCreateDate(new Date());
         this.roleService.createRole(role);
         result.put("success", Boolean.valueOf(true));
         result.put("msg", "角色信息添加成功！");
       } else {
         result.put("success", Boolean.valueOf(true));
         result.put("msg", "角色信息添加失敗！");
       }
     } catch (Exception e) {
       e.printStackTrace();
       result.put("success", Boolean.valueOf(false));
       result.put("msg", "角色信息添加失败，服务器端未获得要添加的角色信息！");
     }
 
     return result;
   }
 
   private Map<String, Object> updateRole(MlRole role) {
     Map result = new HashMap();
     try
     {
       if (role != null) {
         this.roleService.updateRoleByPriKey(role);
         result.put("success", Boolean.valueOf(true));
         result.put("msg", "角色信息修改成功！");
       } else {
         result.put("success", Boolean.valueOf(false));
         result.put("msg", "角色信息修改失败，填写的角色信息不完整！");
       }
     } catch (Exception e) {
       e.printStackTrace();
       result.put("success", Boolean.valueOf(false));
       result.put("msg", "角色信息修改失败，服务器端处理异常！");
     }
 
     return result;
   }
   @RequestMapping({"deleteRole"})
   @ResponseBody
   public Map<String, Object> deleteRole(long[] roleIds) { Map result = new HashMap();
     try {
       if (roleIds != null) {
         for (int i = 0; i < roleIds.length; i++)
           if (!this.userService.isRoleBindWithUser(roleIds[i])) {
             this.roleService.deleteRoleByPriKey(roleIds[i]);
             result.put("success", Boolean.valueOf(true));
             result.put("msg", "角色信息删除成功！");
           } else {
             result.put("success", Boolean.valueOf(false));
             result.put("msg", "角色信息删除失败，用户正在使用该角色！");
           }
       }
       else
       {
         result.put("success", Boolean.valueOf(false));
         result.put("msg", "角色信息删除失败，服务器端未获得要修改的机构信息！");
       }
     } catch (Exception e) {
       e.printStackTrace();
       result.put("success", Boolean.valueOf(false));
       result.put("msg", "角色信息删除失败，服务器端处理异常！");
     }
 
     return result;
   }
 }