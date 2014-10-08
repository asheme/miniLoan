package com.wealth.miniloan.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.dao.CorpCreditDao;
import com.wealth.miniloan.entity.MlCorpCredit;
import com.wealth.miniloan.entity.MlCorpCreditExample;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.CommonServiceI;

@Service
public class LoanCorpCreditServiceImpl implements CommonServiceI<MlCorpCredit> {
	private CorpCreditDao corpCreditDao = null;

	// private final String _ORDER_ATTRS = "appNo";
	// private final String _ORDER_FIELDS = "APP_NO";

	@Autowired
	public void setCorpCreditDao(CorpCreditDao corpCreditDao) {
		this.corpCreditDao = corpCreditDao;
	}

	/*
	 * @Override public PageList<MlCorpCredit> getPageList(Page paramPage,
	 * MlCorpCredit obj) { MlCorpAppExample example = new MlCorpAppExample();
	 * Integer ccCount = obj.getBadLoansCount(); Criteria criteria =
	 * example.createCriteria(); if (ccCount != null && !"".equals(ccCount)) {
	 * criteria.andCompNameLike("%" + ccCount + "%"); }
	 * 
	 * String order = SysUtil.dealOrderby(paramPage, _ORDER_ATTRS,
	 * _ORDER_FIELDS); if (!order.equals("")) { example.setOrderByClause(order);
	 * } return this.corpCreditDao.findPage(SysUtil.convertPage(paramPage),
	 * example); }
	 */

	@Override
	public int create(MlCorpCredit obj) {
		return this.corpCreditDao.save(obj);
	}

	@Override
	public int update(MlCorpCredit obj) {
		return this.corpCreditDao.update(obj);
	}

	@Override
	public int delete(String ids) {
		String[] idArray = ids.split(",");
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < idArray.length; i++) {
			list.add(idArray[i]);
		}
		MlCorpCreditExample example = new MlCorpCreditExample();
		example.createCriteria().andAppNoIn(list);
		return this.corpCreditDao.deleteByExample(example);
	}

	@Override
	public MlCorpCredit getByPriKey(MlCorpCredit obj) {
		return (MlCorpCredit) this.corpCreditDao.getById(obj.getAppNo());
	}

	@Override
	public PageList<MlCorpCredit> getPageList(Page paramPage, MlCorpCredit obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getByExample(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
