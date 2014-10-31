package com.wealth.miniloan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.DataGrid;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.entity.UnionLoanApp;
import com.wealth.miniloan.entity.UnionLoanInfo;
import com.wealth.miniloan.entity.User;
import com.wealth.miniloan.service.LoanServiceI;
import com.wealth.miniloan.utils.Constant;

@Controller
@RequestMapping(value = "/loan")
@SessionAttributes("user")
public class LoanController {
	private LoanServiceI loanService;

	@Autowired
	public void setLoanService(LoanServiceI loanService) {
		this.loanService = loanService;
	}

	@RequestMapping(value = "loanInfoList")
	@ResponseBody
	public DataGrid getLoanInfoList(Page page, UnionLoanInfo unionLoanInfo,
			@ModelAttribute("user") User user) {
		DataGrid resut = new DataGrid();
		PageList<UnionLoanInfo> loanInfoList = null;
		loanInfoList = this.loanService.getLoanPageList(page,unionLoanInfo);

		if (loanInfoList != null) {
			resut.setRows(loanInfoList);
			resut.setTotal(Long.valueOf(loanInfoList.getPaginator()
					.getTotalCount()));
		}

		return resut;
	}
}
