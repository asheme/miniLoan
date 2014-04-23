 package com.wealth.miniloan.serviceImpl;
 
 import com.wealth.miniloan.dao.UserDao;
 import com.wealth.miniloan.entity.MlUser;
 import com.wealth.miniloan.entity.MlUserExample;
 import com.wealth.miniloan.entity.MlUserExample.Criteria;
 import com.wealth.miniloan.service.LoginServiceI;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;
 
 @Service("loginService")
 public class LoginServiceImpl
   implements LoginServiceI
 {
   private UserDao userDao = null;
 
   public UserDao getUserDao() {
     return this.userDao;
   }
   @Autowired
   public void setUserDao(UserDao userDao) {
     this.userDao = userDao;
   }
 
   public MlUser getLoginUserInfo(String loginId)
   {
     MlUserExample example = new MlUserExample();
     example.createCriteria().andLoginIdEqualTo(loginId);
     return (MlUser)this.userDao.findOne(example);
   }
 }