package com.wealth.miniloan.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

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
import com.wealth.miniloan.entity.MlCorpCustInfo;
import com.wealth.miniloan.entity.MlLoanInfo;
import com.wealth.miniloan.entity.MlNaturalCustInfo;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.entity.UnionLoanInfo;
import com.wealth.miniloan.entity.User;
import com.wealth.miniloan.service.LoanServiceI;

@Controller
@RequestMapping(value = "/query/loan")
@SessionAttributes("user")
public class QueryLoanController extends BaseController {
	private LoanServiceI loanService = null;

	@Autowired
	public void setLoanService(LoanServiceI loanService) {
		this.loanService = loanService;
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

	@RequestMapping(value = "queryLoanList")
	@ResponseBody
	public DataGrid queryLoanList(Page page, UnionLoanInfo unionLoanInfo, @ModelAttribute("user") User user) {
		DataGrid resut = new DataGrid();
		PageList<UnionLoanInfo> loanInfoList = null;
		loanInfoList = this.loanService.getLoanPageList(page, unionLoanInfo);

		if (loanInfoList != null) {
			resut.setRows(loanInfoList);
			resut.setTotal(Long.valueOf(loanInfoList.getPaginator().getTotalCount()));
		}

		return resut;
	}
	
	@RequestMapping(value = "viewLoanInfo")
	public ModelAndView viewLoanInfo(MlLoanInfo loanInfo) {
		String custType = null;
		ModelAndView modelAndView = new ModelAndView();

		loanInfo = this.loanService.getLoanInfo(loanInfo);
		modelAndView.addObject("loanInfo", loanInfo);
		custType = loanInfo.getCustType();
		modelAndView.addObject("appType", custType);
		modelAndView.addObject("loanId", loanInfo.getLoanId());
		modelAndView.setViewName("query/viewLoanInfo");
//		if (Constant.CUST_TYPE_NATURAL.equals(custType)) {
//			naturalCustInfo = this.loanService.getNaturalCustInfoByLoanInfo(loanInfo);
//			modelAndView.addObject("naturalCustInfo", naturalCustInfo);
//			modelAndView.setViewName("loan/viewNaturalLoanInfo");
//		} else {
//			modelAndView.addObject("corpCustInfo", corpCustInfo);
//			modelAndView.setViewName("loan/viewCorpLoanInfo");
//		}

		return modelAndView;
	}
	
	@RequestMapping(value = "viewNaturalCustInfo")
	public ModelAndView viewNaturalCustInfo(MlLoanInfo loanInfo) {
		MlNaturalCustInfo naturalCustInfo = null;
		ModelAndView modelAndView = new ModelAndView();
		loanInfo = this.loanService.getLoanInfo(loanInfo);
		modelAndView.addObject("loanInfo", loanInfo);
		naturalCustInfo = this.loanService.getNaturalCustInfoByLoanInfo(loanInfo);
		modelAndView.addObject("naturalCustInfo", naturalCustInfo);
		modelAndView.setViewName("loan/viewNaturalLoanInfo");

		return modelAndView;
	}
	
	@RequestMapping(value = "viewCorpCustInfo")
	public ModelAndView viewCorpCustInfo(MlLoanInfo loanInfo) {
		MlCorpCustInfo corpCustInfo = null;
		ModelAndView modelAndView = new ModelAndView();
		loanInfo = this.loanService.getLoanInfo(loanInfo);
		modelAndView.addObject("loanInfo", loanInfo);
		loanInfo.getCustType();
		corpCustInfo = this.loanService.getCorpCustInfoByLoanInfo(loanInfo);
		modelAndView.addObject("corpCustInfo", corpCustInfo);
		modelAndView.setViewName("loan/viewCorpLoanInfo");
		return modelAndView;
	}
	
	@RequestMapping(value = "viewContract")
	public ModelAndView viewContract(MlLoanInfo loanInfo) {
		ModelAndView modelAndView = new ModelAndView();
		loanInfo = this.loanService.getLoanInfo(loanInfo);
		modelAndView.addObject("loanInfo", loanInfo);
		modelAndView.setViewName("loan/viewContract");
		return modelAndView;
	}
	
	@RequestMapping(value = "viewReceipt")
	public ModelAndView viewReceipt(MlLoanInfo loanInfo) {
		ModelAndView modelAndView = new ModelAndView();
		loanInfo = this.loanService.getLoanInfo(loanInfo);
		modelAndView.addObject("loanId", loanInfo.getLoanId());
		modelAndView.setViewName("loan/viewReceipt");
		return modelAndView;
	}
	
	@RequestMapping(value = "viewPayRecord")
	public ModelAndView viewPayRecord(MlLoanInfo loanInfo) {
		ModelAndView modelAndView = new ModelAndView();
		loanInfo = this.loanService.getLoanInfo(loanInfo);
		modelAndView.addObject("loanId", loanInfo.getLoanId());
		modelAndView.setViewName("loan/viewPayRecord");
		return modelAndView;
	}
}
