 package com.wealth.miniloan.utils;
 
 import com.github.miemiedev.mybatis.paginator.domain.Order;
 import com.github.miemiedev.mybatis.paginator.domain.Order.Direction;
 import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
 import com.wealth.miniloan.entity.Page;
 
 public class SysUtil
 {
   public static PageBounds convertPage(Page page)
   {
     if (page == null) return null;
 
     return new PageBounds(page.getPage(), page.getRows(), new Order[] { new Order(page.getSort(), Order.Direction.fromString(page.getOrder()), null) });
   }
 
   public static String dealOrderby(Page page, String attrStr, String fieldStr)
   {
     String orderByStr = "";
     String sortAttr = page.getSort();
     String order = page.getOrder();
     String[] attrs = null;
     String[] fields = null;
 
     if ((attrStr != null) && (!"".equals(attrStr.trim()))) {
       attrs = attrStr.split(",");
     }
     if ((fieldStr != null) && (!"".equals(fieldStr.trim()))) {
       fields = fieldStr.split(",");
     }
     if ((attrs == null) || (fields == null))
       return "";
     if ((sortAttr == null) || ("".equals(sortAttr.trim()))) {
       return "";
     }
     if ((order == null) || ("".equals(order.trim()))) {
       order = "asc";
     }
     for (int i = 0; i < attrs.length; i++) {
       if (sortAttr.equals(attrs[i])) {
         orderByStr = fields[i] + " " + order;
       }
     }
 
     return orderByStr;
   }
 }