package com.wealth.miniloan.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.dao.PayRecordDao;
import com.wealth.miniloan.entity.MlLoanInfo;
import com.wealth.miniloan.entity.MlPayRecordExample;
import com.wealth.miniloan.entity.MlPayRecord;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.PayRecordServiceI;
import com.wealth.miniloan.utils.SysUtil;

@Service
public class PayRecordServiceImpl implements PayRecordServiceI {
	private PayRecordDao payRecordDao = null;
	private final String _ORDER_ATTRS = "recordId";
	private final String _ORDER_FIELDS = "RECORD_ID";

	@Autowired
	public void setPayRecordDao(PayRecordDao payRecordDao) {
		this.payRecordDao = payRecordDao;
	}

	@Override
	public PageList<MlPayRecord> getPageList(Page paramPage, MlLoanInfo loanInfo) {
		MlPayRecordExample example = new MlPayRecordExample();
		example.createCriteria().andLoanIdEqualTo(loanInfo.getLoanId());
		String order = SysUtil.dealOrderby(paramPage, _ORDER_ATTRS, _ORDER_FIELDS);
		if (!order.equals("")) {
			example.setOrderByClause(order);
		}
		return this.payRecordDao.findPage(SysUtil.convertPage(paramPage), example);
	}

	@Override
	public int create(MlPayRecord obj) {
		return this.payRecordDao.save(obj);
	}

	@Override
	public int update(MlPayRecord obj) {
		return this.payRecordDao.update(obj);
	}

	@Override
	public int delete(String ids) {
		String[] idArray = ids.split(",");
		List<Long> list = new ArrayList<Long>();
		for (int i = 0; i < idArray.length; i++) {
			list.add(Long.valueOf(idArray[i]));
		}
		MlPayRecordExample example = new MlPayRecordExample();
		example.createCriteria().andRecordIdIn(list);
		return this.payRecordDao.deleteByExample(example);
	}

	@Override
	public MlPayRecord getByPriKey(MlPayRecord obj) {
		return (MlPayRecord) this.payRecordDao.getById(obj.getRecordId());
	}

	@Override
	public Object getByExample(Object obj) {
		return this.payRecordDao.findAll(obj);
	}

}
