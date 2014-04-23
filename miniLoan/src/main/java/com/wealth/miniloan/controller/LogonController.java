 package com.wealth.miniloan.controller;
 
 import com.wealth.miniloan.entity.MlUser;
 import com.wealth.miniloan.service.LoginServiceI;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Controller;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.SessionAttributes;
 import org.springframework.web.servlet.ModelAndView;
 
 @Controller
 @RequestMapping({"/"})
 @SessionAttributes({"user"})
 public class LogonController
 {
   private static final Logger logger = LoggerFactory.getLogger(LogonController.class);
 
   private LoginServiceI loginService = null;
 
   public LoginServiceI getLoginService()
   {
     return this.loginService;
   }
   @Autowired
   public void setLoginService(LoginServiceI loginService) {
     this.loginService = loginService;
   }
   @RequestMapping({"toLogin"})
   public String toLogin() {
     return "index";
   }
   @RequestMapping(value={"logon"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
   public ModelAndView logon(String loginId, String password) {
     ModelAndView modelAndView = new ModelAndView();
     MlUser user = this.loginService.getLoginUserInfo("sysadmin");
 
     modelAndView.setViewName("main");
     return modelAndView;
   }
   @RequestMapping({"toMenu"})
   public String toMenu() {
     return "menu";
   }
   @RequestMapping({"toContent"})
   public String toContent() {
     return "content";
   }
   @RequestMapping({"toHome"})
   public String toHome() {
     return "home";
   }
 }