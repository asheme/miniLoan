 package com.wealth.miniloan.controller;
 
 import com.github.miemiedev.mybatis.paginator.domain.PageList;
 import com.github.miemiedev.mybatis.paginator.domain.Paginator;
 import com.wealth.miniloan.entity.ComboOption;
 import com.wealth.miniloan.entity.DataGrid;
 import com.wealth.miniloan.entity.MlSysResc;
 import com.wealth.miniloan.entity.Page;
 import com.wealth.miniloan.service.RescServiceI;
 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Controller;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.ResponseBody;
 import org.springframework.web.servlet.ModelAndView;
 
 @Controller
 @RequestMapping({"/resc"})
 public class RescController
 {
   private RescServiceI rescService = null;
 
   public RescServiceI getRescService() {
     return this.rescService;
   }
   @Autowired
   public void setRescService(RescServiceI rescService) {
     this.rescService = rescService;
   }
   @RequestMapping({"rescList"})
   @ResponseBody
   public DataGrid getRescList(Page page, MlSysResc resc) { DataGrid resut = new DataGrid();
     PageList rescList = null;
     rescList = this.rescService.getRescPageList(page);
     if (rescList != null) {
       resut.setRows(rescList);
       resut.setTotal(Long.valueOf(rescList.getPaginator().getTotalCount()));
     }
 
     return resut; } 
   @RequestMapping({"getParentResc"})
   @ResponseBody
   public List<ComboOption> getParentResc() {
     List rescList = this.rescService.getParentRescList();
     MlSysResc resc = null;
     ComboOption comboOption = null;
     List comboOptionList = new ArrayList();
     comboOption = new ComboOption();
     comboOption.setTitle("请选择");
     comboOption.setValue("");
     comboOptionList.add(comboOption);
     if (rescList != null) {
       for (int i = 0; i < rescList.size(); i++) {
         resc = (MlSysResc)rescList.get(i);
         comboOption = new ComboOption();
         comboOption.setTitle(resc.getRescTitle());
         comboOption.setValue(String.valueOf(resc.getRescId()));
         comboOptionList.add(comboOption);
       }
     }
     return comboOptionList;
   }
   @RequestMapping({"toAddResc"})
   public ModelAndView toAddResc() {
     ModelAndView modelAndView = new ModelAndView();
     modelAndView.setViewName("system/modifyResc");
     modelAndView.addObject("flag", "ADD");
     return modelAndView;
   }
   @RequestMapping({"toUpdate"})
   @ResponseBody
   public ModelAndView toUpdate(MlSysResc resc) {
     try { resc = this.rescService.getRescById(resc);
     } catch (Exception e) {
       e.printStackTrace();
     }
     ModelAndView modelAndView = new ModelAndView();
     modelAndView.setViewName("system/modifyResc");
     modelAndView.addObject("flag", "UPDATE");
     modelAndView.addObject("resc", resc);
     return modelAndView;
   }
   @RequestMapping({"modifyResc"})
   @ResponseBody
   public Map<String, Object> modifyResc(MlSysResc resc, String flag) { Map result = new HashMap();
 
     if ("ADD".equals(flag)) {
       result = addResc(resc);
     } else if ("UPDATE".equals(flag)) {
       result = updateResc(resc);
     } else {
       result.put("success", Boolean.valueOf(false));
       result.put("msg", "模块信息处理异常，服务器端无法正常获取请求数据！");
     }
 
     return result;
   }
 
   public HashMap<String, Object> addResc(MlSysResc resc)
   {
     HashMap result = new HashMap();
     try {
       if (resc != null) {
         this.rescService.createResc(resc);
         result.put("success", Boolean.valueOf(true));
         result.put("msg", "模块信息添加成功！");
       } else {
         result.put("success", Boolean.valueOf(true));
         result.put("msg", "模块信息添加失败！");
       }
     } catch (Exception e) {
       e.printStackTrace();
       result.put("success", Boolean.valueOf(false));
       result.put("msg", "服务器端出现异常");
     }
 
     return result;
   }
 
   public Map<String, Object> updateResc(MlSysResc resc)
   {
     Map result = new HashMap();
     try {
       if (resc != null) {
         this.rescService.updateResc(resc);
         result.put("success", Boolean.valueOf(true));
         result.put("msg", "模块信息修改成功！");
       } else {
         result.put("success", Boolean.valueOf(false));
         result.put("msg", "模块信息修改失败，服务器端未获得要修改的机构信息！");
       }
     } catch (Exception e) {
       e.printStackTrace();
       result.put("success", Boolean.valueOf(false));
       result.put("msg", "模块信息修改失败，服务器端处理异常！");
     }
 
     return result;
   }
   @RequestMapping({"deleteResc"})
   @ResponseBody
   public Map<String, Object> deleteResc(String ids) { Map result = new HashMap();
     try {
       if ((ids != null) && (!"".equals(ids.trim()))) {
         this.rescService.deleteRescByKeys(ids);
         result.put("success", Boolean.valueOf(true));
         result.put("msg", "模块信息删除成功！");
       } else {
         result.put("success", Boolean.valueOf(false));
         result.put("msg", "模块信息删除失败，服务器端未获得要修改的机构信息！");
       }
     } catch (Exception e) {
       e.printStackTrace();
       result.put("success", Boolean.valueOf(false));
       result.put("msg", "模块信息删除失败，服务器端处理异常！");
     }
 
     return result;
   }
 }