 package com.wealth.miniloan.controller;
 
 import com.github.miemiedev.mybatis.paginator.domain.PageList;
 import com.github.miemiedev.mybatis.paginator.domain.Paginator;
 import com.wealth.miniloan.entity.DataGrid;
 import com.wealth.miniloan.entity.MlUser;
 import com.wealth.miniloan.entity.Page;
 import com.wealth.miniloan.service.UserServiceI;
 import java.util.HashMap;
 import java.util.Map;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Controller;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.ResponseBody;
 import org.springframework.web.bind.annotation.SessionAttributes;
 import org.springframework.web.servlet.ModelAndView;
 
 @Controller
 @RequestMapping({"/user"})
 @SessionAttributes({"user"})
 public class UserController
 {
   private UserServiceI userService = null;
 
   public UserServiceI getUserService() {
     return this.userService;
   }
   @Autowired
   public void setUserService(UserServiceI userService) {
     this.userService = userService;
   }
   @RequestMapping({"userlist"})
   @ResponseBody
   public DataGrid getUserList(Page page, MlUser user) { PageList userList = null;
     DataGrid result = new DataGrid();
     try
     {
       userList = this.userService.getUserPageList(page, user);
       if (userList != null) {
         result.setTotal(Long.valueOf(userList.getPaginator().getTotalCount()));
         result.setRows(userList);
       }
     } catch (Exception e) {
       e.printStackTrace();
     }
 
     return result; }
 
   @RequestMapping({"toAddUser"})
   public ModelAndView toAddUser() {
     ModelAndView modelView = new ModelAndView();
     modelView.setViewName("system/modifyUser");
     modelView.addObject("flag", "ADD");
     return modelView;
   }
   @RequestMapping({"toUpdateUser"})
   public ModelAndView toUpdateUser(MlUser user) {
     try {
       user = this.userService.getUserByPriKey(user);
     } catch (Exception e) {
       e.printStackTrace();
     }
 
     ModelAndView modelView = new ModelAndView();
     modelView.setViewName("system/modifyUser");
     modelView.addObject("flag", "UPDATE");
     modelView.addObject("user", user);
     return modelView;
   }
   @RequestMapping({"modifyUser"})
   @ResponseBody
   public Map<String, Object> modifyUser(MlUser user, String flag) { Map result = new HashMap();
 
     if ("ADD".equals(flag))
     {
       result = addUser(user);
     } else if ("UPDATE".equals(flag))
     {
       result = updateUser(user);
     } else {
       result.put("success", Boolean.valueOf(false));
       result.put("msg", "用户信息添加异常，服务器端无法正常获取请求数据！");
     }
 
     return result; }
 
   public HashMap<String, Object> addUser(MlUser user)
   {
     HashMap result = new HashMap();
     try {
       if (user != null) {
         this.userService.createUser(user);
         result.put("success", Boolean.valueOf(true));
         result.put("msg", "用户信息添加成功！");
       } else {
         result.put("success", Boolean.valueOf(true));
         result.put("msg", "用户信息添加失败！");
       }
     } catch (Exception e) {
       e.printStackTrace();
       result.put("success", Boolean.valueOf(false));
       result.put("msg", "服务器端出现异常");
     }
 
     return result;
   }
 
   public Map<String, Object> updateUser(MlUser user) {
     Map result = new HashMap();
     try {
       if (user != null) {
         this.userService.updateUser(user);
         result.put("success", Boolean.valueOf(true));
         result.put("msg", "用户信息修改成功！");
       } else {
         result.put("success", Boolean.valueOf(false));
         result.put("msg", "用户信息修改失败，服务器端未获得要修改的用户信息！");
       }
     } catch (Exception e) {
       e.printStackTrace();
       result.put("success", Boolean.valueOf(false));
       result.put("msg", "用户信息修改失败，服务器端处理异常！");
     }
 
     return result;
   }
   @RequestMapping({"deleteUser"})
   @ResponseBody
   public Map<String, Object> deleteUser(String ids) { Map result = new HashMap();
     try
     {
       if ((ids != null) && (!"".equals(ids.trim())))
       {
         this.userService.deleteUserRoleByKeys(ids);
 
         this.userService.deleteUserByKeys(ids);
         result.put("success", Boolean.valueOf(true));
         result.put("msg", "用户信息删除成功！");
       } else {
         result.put("success", Boolean.valueOf(false));
         result.put("msg", "用户信息删除失败，服务器端未获得要删除的用户信息！");
       }
     } catch (Exception e) {
       e.printStackTrace();
       result.put("success", Boolean.valueOf(false));
       result.put("msg", "用户信息删除失败，服务器端处理异常！");
     }
 
     return result;
   }
 }