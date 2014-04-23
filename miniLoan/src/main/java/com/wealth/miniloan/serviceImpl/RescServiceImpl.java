/*    */ package com.wealth.miniloan.serviceImpl;
/*    */ 
/*    */ import com.github.miemiedev.mybatis.paginator.domain.PageList;
/*    */ import com.wealth.miniloan.dao.RescDao;
/*    */ import com.wealth.miniloan.entity.MlSysResc;
/*    */ import com.wealth.miniloan.entity.MlSysRescExample;
/*    */ import com.wealth.miniloan.entity.MlSysRescExample.Criteria;
/*    */ import com.wealth.miniloan.entity.Page;
/*    */ import com.wealth.miniloan.service.RescServiceI;
/*    */ import com.wealth.miniloan.utils.SysUtil;
/*    */ import com.wealth.miniloan.utils.key.KeyGenerator;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ @Service("rescService")
/*    */ public class RescServiceImpl
/*    */   implements RescServiceI
/*    */ {
/* 21 */   private RescDao rescDao = null;
/* 22 */   private final String _ORDER_ATTRS = "rescTitle,rescName,rescDesc,rescUrl,parentId,rescSeq,isLeaf,rescStatus";
/* 23 */   private final String _ORDER_FIELDS = "RESC_TITLE,RESC_NAME,RESC_DESC,RESC_URL,PARENT_ID,RESC_SEQ,IS_LEAF,RESC_STATUS";
/*    */ 
/*    */   public RescDao getRescDao() {
/* 26 */     return this.rescDao;
/*    */   }
/*    */   @Autowired
/*    */   public void setRescDao(RescDao rescDao) {
/* 31 */     this.rescDao = rescDao;
/*    */   }
/*    */ 
/*    */   public PageList<MlSysResc> getRescPageList(Page page)
/*    */   {
/* 36 */     MlSysRescExample example = new MlSysRescExample();
/* 37 */     String order = SysUtil.dealOrderby(page, "rescTitle,rescName,rescDesc,rescUrl,parentId,rescSeq,isLeaf,rescStatus", "RESC_TITLE,RESC_NAME,RESC_DESC,RESC_URL,PARENT_ID,RESC_SEQ,IS_LEAF,RESC_STATUS");
/* 38 */     if (!order.equals("")) {
/* 39 */       example.setOrderByClause(order);
/*    */     }
/* 41 */     return this.rescDao.findPage(SysUtil.convertPage(page), example);
/*    */   }
/*    */ 
/*    */   public int createResc(MlSysResc resc)
/*    */   {
/* 46 */     resc.setRescId(KeyGenerator.getNextKey("ML_SYS_RESC", "RESC_ID"));
/* 47 */     resc.setRescType("M");
/* 48 */     if ("Y".equals(resc.getIsLeaf())) {
/* 49 */       resc.setRescIcon("icon-ui-tree-leaf");
/*    */     }
/* 51 */     return this.rescDao.save(resc);
/*    */   }
/*    */ 
/*    */   public int updateResc(MlSysResc resc)
/*    */   {
/* 56 */     return this.rescDao.update(resc);
/*    */   }
/*    */ 
/*    */   public List<MlSysResc> getParentRescList()
/*    */   {
/* 61 */     MlSysRescExample example = new MlSysRescExample();
/* 62 */     example.createCriteria().andIsLeafEqualTo("N");
/* 63 */     example.setOrderByClause("RESC_SEQ ASC");
/* 64 */     return this.rescDao.findAll(example);
/*    */   }
/*    */ 
/*    */   public MlSysResc getRescById(MlSysResc resc)
/*    */   {
/* 69 */     return (MlSysResc)this.rescDao.getById(resc.getRescId());
/*    */   }
/*    */ 
/*    */   public int deleteRescByKeys(String ids)
/*    */   {
/* 74 */     String[] idArray = ids.split(",");
/* 75 */     List list = new ArrayList();
/* 76 */     for (int i = 0; i < idArray.length; i++) {
/* 77 */       list.add(idArray[i]);
/*    */     }
/* 79 */     MlSysRescExample example = new MlSysRescExample();
/* 80 */     example.createCriteria().andRescIdIn(list);
/* 81 */     return this.rescDao.deleteByExample(example);
/*    */   }
/*    */ }

/* Location:           C:\Users\春国\Desktop\miniLoan_ol\WEB-INF\classes\
 * Qualified Name:     com.wealth.miniloan.serviceImpl.RescServiceImpl
 * JD-Core Version:    0.6.0
 */