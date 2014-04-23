/*    */ package com.wealth.miniloan.entity;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class DataGrid
/*    */ {
/*  7 */   private Long total = Long.valueOf(0L);
/*  8 */   private List rows = new ArrayList();
/*    */ 
/*    */   public Long getTotal() {
/* 11 */     return this.total;
/*    */   }
/*    */ 
/*    */   public void setTotal(Long total) {
/* 15 */     this.total = total;
/*    */   }
/*    */ 
/*    */   public List getRows() {
/* 19 */     return this.rows;
/*    */   }
/*    */ 
/*    */   public void setRows(List rows) {
/* 23 */     this.rows = rows;
/*    */   }
/*    */ }

/* Location:           C:\Users\春国\Desktop\miniLoan_ol\WEB-INF\classes\
 * Qualified Name:     com.wealth.miniloan.entity.DataGrid
 * JD-Core Version:    0.6.0
 */