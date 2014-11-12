package com.wealth.miniloan.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.DataGrid;
import com.wealth.miniloan.entity.MlLoanInfo;
import com.wealth.miniloan.entity.MlPayRecord;
import com.wealth.miniloan.entity.MlUser;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.LoanServiceI;
import com.wealth.miniloan.service.PayRecordServiceI;
import com.wealth.miniloan.utils.key.KeyGenerator;

@Controller
@RequestMapping(value = "/pay/record")
@SessionAttributes("user")
public class PayRecordController extends BaseController {
	private PayRecordServiceI payRecordService = null;
	private LoanServiceI loanService = null;

	@Autowired
	public void setLoanService(LoanServiceI loanService) {
		this.loanService = loanService;
	}
	@Autowired
	public void setPayRecordService(PayRecordServiceI payRecordService) {
		this.payRecordService = payRecordService;
	}
	
	/*
	 * 表单提交日期绑定
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	

	@RequestMapping(value = "toPayRecordList")
	@ResponseBody
	public ModelAndView toPayRecordList(MlLoanInfo loanInfo) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("loan/payRecordList");
		modelAndView.addObject("loanId", loanInfo.getLoanId());
		return modelAndView;
	}

	@RequestMapping(value = "payRecordList")
	@ResponseBody
	public DataGrid getPayRecordList(Page page, MlLoanInfo loanInfo) {
		DataGrid resut = new DataGrid();
		PageList<MlPayRecord> payRecords = null;
		payRecords = this.payRecordService.getPageList(page, loanInfo);

		if (payRecords != null) {
			resut.setRows(payRecords);
			resut.setTotal(Long.valueOf(payRecords.getPaginator().getTotalCount()));
		}
		return resut;
	}

	@RequestMapping(value = "toAddPayRecord")
	public ModelAndView toAddPayRecord(MlPayRecord record) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("loan/modifyPayRecord");
		modelAndView.addObject("flag", "ADD");
		modelAndView.addObject("record", record);
		return modelAndView;
	}

	@RequestMapping(value = "toUpdatePayRecord")
	public ModelAndView toUpdatePayRecord(MlPayRecord record) {
		try {
			record = this.payRecordService.getByPriKey(record);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("loan/modifyPayRecord");
		modelAndView.addObject("flag", "UPDATE");
		modelAndView.addObject("record", record);
		return modelAndView;
	}

	@RequestMapping(value = "modifyPayRecord")
	@ResponseBody
	public Map<String, Object> modifyPayRecord(String flag,
			MlPayRecord record, @ModelAttribute("user") MlUser user) {
		Map<String, Object> result = new HashMap<String, Object>();
		MlLoanInfo loanInfo = new MlLoanInfo();
		loanInfo.setLoanId(record.getLoanId());
		loanInfo = this.loanService.getLoanInfo(loanInfo);
		//已还款金额
		BigDecimal payAmount = loanInfo.getPayAmount();
		//剩余还款金额
		BigDecimal remainAmount = loanInfo.getRemainAmount();
		//贷款金额
		BigDecimal loanAmount = loanInfo.getLoanAmount();
		
		if ("ADD".equals(flag)) {
			record.setRecordId(KeyGenerator.getNextKey("ML_PAY_RECORD", "RECORD_ID"));
			record.setOper(user.getUserId());
			//累计还款
			if(payAmount != null){
				record.setPayAmountSum(payAmount.add(record.getPayAmount()));
				loanInfo.setPayAmount(payAmount.add(record.getPayAmount()));
			}
			//剩余还款
			if(remainAmount != null){
//				record.setp(loanAmount.subtract(record.getPayAmountSum()));
				loanInfo.setRemainAmount(loanAmount.subtract(record.getPayAmountSum()));
			}
			result = addPayRecord(record, user);
		} else if ("UPDATE".equals(flag)) {
			record.setOper(user.getUserId());
			result = updatePayRecord(record, user);
		} else {
			result.put("success", false);
			result.put("msg", "还款信息添加异常，服务器端无法正常获取请求数据！");
		}
		
		//更新贷款信息表
		this.loanService.update(loanInfo);
		return result;
	}

	public Map<String, Object> addPayRecord(MlPayRecord record, MlUser user) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			if (record != null) {
				this.payRecordService.create(record);
				result.put("success", true);
				result.put("msg", "还款信息添加成功！");
			} else {
				result.put("success", false);
				result.put("msg", "还款信息添加失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "服务器端出现异常！");
		}

		return result;
	}

	public Map<String, Object> updatePayRecord(MlPayRecord record, MlUser user) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if (user != null) {
				this.payRecordService.update(record);
				result.put("success", true);
				result.put("msg", "还款信息修改成功！");
			} else {
				result.put("success", false);
				result.put("msg", "还款信息修改失败，服务器端未获得要修改的申请信息！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "还款信息修改失败，服务器端处理异常！");
		}

		return result;
	}


	@RequestMapping(value = "deletePayRecord")
	@ResponseBody
	public Map<String, Object> deletePayRecord(String ids) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if ((ids != null) && (!"".equals(ids.trim()))) {
				this.payRecordService.delete(ids);
				result.put("success", true);
				result.put("msg", "还款信息删除成功！");
			} else {
				result.put("success", false);
				result.put("msg", "还款信息删除失败，服务器端未获得要删除的信息！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "还款信息删除失败，服务器端处理异常！");
		}

		return result;
	}


}
