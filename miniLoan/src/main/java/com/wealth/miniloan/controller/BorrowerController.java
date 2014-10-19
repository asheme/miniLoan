package com.wealth.miniloan.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.DataGrid;
import com.wealth.miniloan.entity.MlBorrower;
import com.wealth.miniloan.entity.MlUser;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.BorrowerServiceI;

//@Controller
//@RequestMapping(value = "/borrower")
//@SessionAttributes("user")
public class BorrowerController {
	private BorrowerServiceI borrowerService = null;

	@Autowired
	public void setBorrowerService(BorrowerServiceI borrowerService) {
		this.borrowerService = borrowerService;
	}

	/***
	 * 分页，查询显示
	 * 
	 * @param page
	 * @param borrower
	 * @return
	 */
	@RequestMapping(value = "borrowerList")
	@ResponseBody
	public DataGrid getParamList(Page page, MlBorrower borrower) {
		DataGrid result = new DataGrid();
		PageList<MlBorrower> borrowerList = null;

		try {
			borrowerList = this.borrowerService.getList(page, borrower);
			if (borrowerList != null) {
				result.setRows(borrowerList);
				result.setTotal(Long.valueOf(borrowerList.getPaginator().getTotalCount()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@RequestMapping(value = "toUpdate")
	@ResponseBody
	public ModelAndView toUpdate(MlBorrower borrower) {
		MlBorrower currentBorrower = this.borrowerService.queryById(borrower);
		ModelAndView view = new ModelAndView();
		view.setViewName("borrower/modifyBorrower");
		view.addObject("flag", "UPDATE");
		view.addObject("currentBorrower", currentBorrower);
		return view;
	}

	@RequestMapping(value = "modifyParam")
	@ResponseBody
	public Map<String, Object> addAndUpdate(MlBorrower borrower, String flag, @ModelAttribute("user") MlUser user) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if (flag != null && !"".equals(flag)) {
				borrower.setLastUpdateTime(new Date());
				this.borrowerService.update(borrower);

				result.put("success", true);
				result.put("msg", "借款人信息修改成功！");
			} else {
				result.put("success", false);
				result.put("msg", "借款人信息修改失败，未从客户端获取到数据！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "借款人信息修改失败，服务器端处理异常！");
		}

		return result;
	}
}
