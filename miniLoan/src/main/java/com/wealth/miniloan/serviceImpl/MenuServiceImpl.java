/*     */ package com.wealth.miniloan.serviceImpl;
/*     */ 
/*     */ import com.wealth.miniloan.dao.RescDao;
/*     */ import com.wealth.miniloan.entity.Menu;
/*     */ import com.wealth.miniloan.entity.MlSysResc;
/*     */ import com.wealth.miniloan.entity.MlSysRescExample;
/*     */ import com.wealth.miniloan.entity.MlSysRescExample.Criteria;
/*     */ import com.wealth.miniloan.service.MenuServiceI;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ @Service("menuService")
/*     */ public class MenuServiceImpl
/*     */   implements MenuServiceI
/*     */ {
/*  17 */   private RescDao rescDao = null;
/*     */ 
/*     */   public RescDao getRescDao() {
/*  20 */     return this.rescDao;
/*     */   }
/*     */   @Autowired
/*     */   public void setRescDao(RescDao rescDao) {
/*  25 */     this.rescDao = rescDao;
/*     */   }
/*     */ 
/*     */   public List<Menu> loadMenu()
/*     */   {
/*  30 */     List rescList = null;
/*  31 */     List menuList = null;
/*     */     try
/*     */     {
/*  34 */       MlSysRescExample example = new MlSysRescExample();
/*  35 */       example.createCriteria().andRescTypeEqualTo("M").andRescStatusEqualTo("1");
/*  36 */       example.setOrderByClause("RESC_SEQ ASC");
/*  37 */       rescList = this.rescDao.findAll(example);
/*     */ 
/*  39 */       menuList = new ArrayList();
/*  40 */       generatorMenu(rescList, menuList);
/*     */     } catch (Exception e) {
/*  42 */       e.printStackTrace();
/*     */     }
/*     */ 
/*  45 */     return menuList;
/*     */   }
/*     */ 
/*     */   private void generatorMenu(List<MlSysResc> rescList, List<Menu> menuList)
/*     */   {
/*  55 */     Menu menu = null;
/*  56 */     MlSysResc resc = null;
/*     */ 
/*  58 */     if ((rescList != null) && (rescList.size() > 0))
/*  59 */       for (int i = 0; i < rescList.size(); i++) {
/*  60 */         resc = (MlSysResc)rescList.get(i);
/*     */ 
/*  62 */         if (resc.getParentId().longValue() == 0L) {
/*  63 */           menu = convertMenu(resc);
/*  64 */           generatorChildMenu(menu, rescList);
/*  65 */           menuList.add(menu);
/*     */         }
/*     */       }
/*     */   }
/*     */ 
/*     */   private Menu convertMenu(MlSysResc resc)
/*     */   {
/*  78 */     Menu menu = null;
/*     */ 
/*  80 */     if (resc != null) {
/*  81 */       menu = new Menu();
/*  82 */       menu.setPid("");
/*  83 */       menu.setId(String.valueOf(resc.getRescId()));
/*  84 */       menu.setText(resc.getRescTitle());
/*  85 */       menu.setUrl(resc.getRescUrl() == null ? "" : resc.getRescUrl());
/*  86 */       menu.setIconCls(resc.getRescIcon());
/*  87 */       menu.setIsLeaf(resc.getIsLeaf());
/*  88 */       menu.setSeq(resc.getRescSeq().intValue());
/*     */     }
/*     */ 
/*  91 */     return menu;
/*     */   }
/*     */ 
/*     */   private void generatorChildMenu(Menu menu, List<MlSysResc> rescList)
/*     */   {
/* 101 */     if ("Y".endsWith(menu.getIsLeaf())) return;
/*     */ 
/* 103 */     MlSysResc resc = null;
/* 104 */     Menu childMenu = null;
/* 105 */     List childMenuList = new ArrayList();
/* 106 */     for (int i = 0; i < rescList.size(); i++) {
/* 107 */       resc = (MlSysResc)rescList.get(i);
/* 108 */       if (menu.getId().equals(resc.getParentId().toString())) {
/* 109 */         childMenu = convertMenu(resc);
/* 110 */         generatorChildMenu(childMenu, rescList);
/* 111 */         childMenuList.add(childMenu);
/*     */       }
/*     */     }
/* 114 */     menu.setChildren(childMenuList);
/*     */   }
/*     */ }

/* Location:           C:\Users\春国\Desktop\miniLoan_ol\WEB-INF\classes\
 * Qualified Name:     com.wealth.miniloan.serviceImpl.MenuServiceImpl
 * JD-Core Version:    0.6.0
 */