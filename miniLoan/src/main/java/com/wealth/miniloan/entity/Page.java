/*    */ package com.wealth.miniloan.entity;
/*    */ 
/*    */ public class Page
/*    */ {
/*  4 */   protected int page = 1;
/*  5 */   protected int rows = 10;
/*    */ 
/*  7 */   protected String sort = null;
/*  8 */   protected String order = null;
/*    */ 
/*    */   public int getPage() {
/* 11 */     return this.page;
/*    */   }
/*    */ 
/*    */   public void setPage(int page) {
/* 15 */     this.page = page;
/*    */   }
/*    */ 
/*    */   public int getRows() {
/* 19 */     return this.rows;
/*    */   }
/*    */ 
/*    */   public void setRows(int rows) {
/* 23 */     this.rows = rows;
/*    */   }
/*    */ 
/*    */   public String getSort() {
/* 27 */     return this.sort;
/*    */   }
/*    */ 
/*    */   public void setSort(String sort) {
/* 31 */     this.sort = sort;
/*    */   }
/*    */ 
/*    */   public String getOrder() {
/* 35 */     return this.order;
/*    */   }
/*    */ 
/*    */   public void setOrder(String order) {
/* 39 */     this.order = order;
/*    */   }
/*    */ }

/* Location:           C:\Users\春国\Desktop\miniLoan_ol\WEB-INF\classes\
 * Qualified Name:     com.wealth.miniloan.entity.Page
 * JD-Core Version:    0.6.0
 */