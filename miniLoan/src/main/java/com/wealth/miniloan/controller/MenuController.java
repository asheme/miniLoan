/*    */ package com.wealth.miniloan.controller;
/*    */ 
/*    */ import com.wealth.miniloan.service.MenuServiceI;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ import org.springframework.web.bind.annotation.SessionAttributes;
/*    */ 
/*    */ @Controller
/*    */ @RequestMapping({"/menu"})
/*    */ @SessionAttributes({"user"})
/*    */ public class MenuController
/*    */ {
/* 20 */   private MenuServiceI menuService = null;
/*    */ 
/*    */   public MenuServiceI getMenuService() {
/* 23 */     return this.menuService;
/*    */   }
/*    */   @Autowired
/*    */   public void setMenuService(MenuServiceI menuService) {
/* 28 */     this.menuService = menuService;
/*    */   }
/* 34 */   @RequestMapping({"loadMenu"})
/*    */   @ResponseBody
/*    */   public Map<String, Object> loadMenu() { Map result = new HashMap();
/* 35 */     List menuList = null;
/*    */     try
/*    */     {
/* 38 */       menuList = this.menuService.loadMenu();
/* 39 */       result.put("success", "Y");
/* 40 */       result.put("data", menuList);
/*    */     } catch (Exception e) {
/* 42 */       e.printStackTrace();
/* 43 */       result.put("success", "N");
/*    */     }
/*    */ 
/* 46 */     return result; }
/*    */ 
/*    */   @RequestMapping({"userList"})
/*    */   public String toUserLits() {
/* 51 */     return "system/userList";
/*    */   }
/*    */   @RequestMapping({"roleList"})
/*    */   public String toRoleLits() {
/* 56 */     return "system/roleList";
/*    */   }
/*    */   @RequestMapping({"rescList"})
/*    */   public String toRescLits() {
/* 61 */     return "system/rescList";
/*    */   }
/*    */   @RequestMapping({"dictList"})
/*    */   public String toDictLits() {
/* 66 */     return "config/dictList";
/*    */   }
/*    */ }

/* Location:           C:\Users\春国\Desktop\miniLoan_ol\WEB-INF\classes\
 * Qualified Name:     com.wealth.miniloan.controller.MenuController
 * JD-Core Version:    0.6.0
 */