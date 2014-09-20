package com.wealth.miniloan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.DataGrid;
import com.wealth.miniloan.entity.MlNaturalApp;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.LoanNaturalAppServiceI;

@Controller
@RequestMapping(value = "/loan/natural/app")
public class LoanNaturalAppController {
	private LoanNaturalAppServiceI loanNaturalAppService = null;

	public LoanNaturalAppServiceI getLoanNaturalAppService() {
		return loanNaturalAppService;
	}

	@Autowired
	public void setLoanNaturalAppService(
			LoanNaturalAppServiceI loanNaturalAppService) {
		this.loanNaturalAppService = loanNaturalAppService;
	}

	@RequestMapping(value = "loanNaturalAppList")
	@ResponseBody
	public DataGrid getNaturalAppList(Page page, MlNaturalApp naturalApp) {
		DataGrid resut = new DataGrid();
		PageList<MlNaturalApp> loanNaturalAppList = null;
		loanNaturalAppList = this.loanNaturalAppService.getLoanNaturalAppPageList(
				page, naturalApp);

		if (loanNaturalAppList != null) {
			resut.setRows(loanNaturalAppList);
			resut.setTotal(Long.valueOf(loanNaturalAppList.getPaginator()
					.getTotalCount()));
		}

		return resut;
	}
	
	@RequestMapping(value="toAddNaturalApp")
	public ModelAndView toAddNaturalApp() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("loan/modifyNaturalApp");
		modelAndView.addObject("flag", "ADD");
		return modelAndView;
	}
}
