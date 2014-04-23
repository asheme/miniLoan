/*     */ package com.wealth.miniloan.entity;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ public class Menu
/*     */ {
/*     */   private String pid;
/*     */   private String pname;
/*     */   private String id;
/*  11 */   private String text = "";
/*  12 */   private String status = "open";
/*  13 */   private boolean checked = false;
/*  14 */   private Map<String, Object> attributes = new HashMap();
/*     */   private List<Menu> children;
/*     */   private String url;
/*     */   private String iconCls;
/*     */   private String isLeaf;
/*     */   private int seq;
/*     */ 
/*     */   public String getPid()
/*     */   {
/*  22 */     return this.pid;
/*     */   }
/*     */ 
/*     */   public void setPid(String pid) {
/*  26 */     this.pid = pid;
/*     */   }
/*     */ 
/*     */   public String getPname() {
/*  30 */     return this.pname;
/*     */   }
/*     */ 
/*     */   public void setPname(String pname) {
/*  34 */     this.pname = pname;
/*     */   }
/*     */ 
/*     */   public String getId() {
/*  38 */     return this.id;
/*     */   }
/*     */ 
/*     */   public void setId(String id) {
/*  42 */     this.id = id;
/*     */   }
/*     */ 
/*     */   public String getText() {
/*  46 */     return this.text;
/*     */   }
/*     */ 
/*     */   public void setText(String text) {
/*  50 */     this.text = text;
/*     */   }
/*     */ 
/*     */   public String getStatus() {
/*  54 */     return this.status;
/*     */   }
/*     */ 
/*     */   public void setStatus(String status) {
/*  58 */     this.status = status;
/*     */   }
/*     */ 
/*     */   public boolean isChecked() {
/*  62 */     return this.checked;
/*     */   }
/*     */ 
/*     */   public void setChecked(boolean checked) {
/*  66 */     this.checked = checked;
/*     */   }
/*     */ 
/*     */   public Map<String, Object> getAttributes() {
/*  70 */     return this.attributes;
/*     */   }
/*     */ 
/*     */   public void setAttributes(Map<String, Object> attributes) {
/*  74 */     this.attributes = attributes;
/*     */   }
/*     */ 
/*     */   public List getChildren() {
/*  78 */     return this.children;
/*     */   }
/*     */ 
/*     */   public void setChildren(List children) {
/*  82 */     this.children = children;
/*     */   }
/*     */ 
/*     */   public String getUrl() {
/*  86 */     return this.url;
/*     */   }
/*     */ 
/*     */   public void setUrl(String url) {
/*  90 */     this.url = url;
/*     */   }
/*     */ 
/*     */   public String getIconCls() {
/*  94 */     return this.iconCls;
/*     */   }
/*     */ 
/*     */   public void setIconCls(String iconCls) {
/*  98 */     this.iconCls = iconCls;
/*     */   }
/*     */ 
/*     */   public String getIsLeaf() {
/* 102 */     return this.isLeaf;
/*     */   }
/*     */ 
/*     */   public void setIsLeaf(String isLeaf) {
/* 106 */     this.isLeaf = isLeaf;
/*     */   }
/*     */ 
/*     */   public int getSeq() {
/* 110 */     return this.seq;
/*     */   }
/*     */ 
/*     */   public void setSeq(int seq) {
/* 114 */     this.seq = seq;
/*     */   }
/*     */ }

/* Location:           C:\Users\春国\Desktop\miniLoan_ol\WEB-INF\classes\
 * Qualified Name:     com.wealth.miniloan.entity.Menu
 * JD-Core Version:    0.6.0
 */