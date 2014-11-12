package com.wealth.miniloan.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.dao.LoanReceiptDao;
import com.wealth.miniloan.entity.MlLoanInfo;
import com.wealth.miniloan.entity.MlLoanReceipt;
import com.wealth.miniloan.entity.MlLoanReceiptExample;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.LoanReceiptServiceI;
import com.wealth.miniloan.utils.SysUtil;

@Service
public class LoanReceiptServiceImpl implements LoanReceiptServiceI {
	private LoanReceiptDao loanReceiptDao = null;
	private final String _ORDER_ATTRS = "receiptId";
	private final String _ORDER_FIELDS = "RECEIPT_ID";

	@Autowired
	public void setLoanReceiptDao(LoanReceiptDao loanReceiptDao) {
		this.loanReceiptDao = loanReceiptDao;
	}

	@Override
	public PageList<MlLoanReceipt> getPageList(Page paramPage, MlLoanInfo loanInfo) {
		MlLoanReceiptExample example = new MlLoanReceiptExample();
		example.createCriteria().andLoanIdEqualTo(loanInfo.getLoanId());
		String order = SysUtil.dealOrderby(paramPage, _ORDER_ATTRS, _ORDER_FIELDS);
		if (!order.equals("")) {
			example.setOrderByClause(order);
		}
		return this.loanReceiptDao.findPage(SysUtil.convertPage(paramPage), example);
	}

	
	@Override
	public int create(MlLoanReceipt obj) {
		return this.loanReceiptDao.save(obj);
	}

	@Override
	public int update(MlLoanReceipt obj) {
		return this.loanReceiptDao.update(obj);
	}

	@Override
	public int delete(String ids) {
		String[] idArray = ids.split(",");
		List<Long> list = new ArrayList<Long>();
		for (int i = 0; i < idArray.length; i++) {
			list.add(Long.valueOf(idArray[i]));
		}
		MlLoanReceiptExample example = new MlLoanReceiptExample();
		example.createCriteria().andReceiptIdIn(list);
		return this.loanReceiptDao.deleteByExample(example);
	}

	@Override
	public MlLoanReceipt getByPriKey(MlLoanReceipt obj) {
		return (MlLoanReceipt) this.loanReceiptDao.getById(obj.getReceiptId());
	}

	@Override
	public Object getByExample(Object obj) {
		return this.loanReceiptDao.findAll(obj);
	}

}
