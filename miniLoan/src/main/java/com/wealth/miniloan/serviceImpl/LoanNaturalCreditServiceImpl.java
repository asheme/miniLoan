package com.wealth.miniloan.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.dao.NaturalCreditDao;
import com.wealth.miniloan.entity.MlCorpAppExample;
import com.wealth.miniloan.entity.MlCorpAppExample.Criteria;
import com.wealth.miniloan.entity.MlNaturalCredit;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.CommonServiceI;
import com.wealth.miniloan.utils.SysUtil;

@Service
public class LoanNaturalCreditServiceImpl implements CommonServiceI<MlNaturalCredit> {
	private NaturalCreditDao naturalCreditDao = null;
	private final String _ORDER_ATTRS = "appNo";
	private final String _ORDER_FIELDS = "APP_NO";

	@Autowired
	public void setNaturalCreditDao(NaturalCreditDao naturalCreditDao) {
		this.naturalCreditDao = naturalCreditDao;
	}

	@Override
	public PageList<MlNaturalCredit> getPageList(Page paramPage, MlNaturalCredit obj) {
		MlCorpAppExample example = new MlCorpAppExample();
		Integer ccCount = obj.getCcCount();
		Criteria criteria = example.createCriteria();
		if (ccCount != null && !"".equals(ccCount)) {
			criteria.andCompNameLike("%" + ccCount + "%");
		}

		String order = SysUtil.dealOrderby(paramPage, _ORDER_ATTRS, _ORDER_FIELDS);
		if (!order.equals("")) {
			example.setOrderByClause(order);
		}
		return this.naturalCreditDao.findPage(SysUtil.convertPage(paramPage), example);
	}

	@Override
	public int create(MlNaturalCredit obj) {
		return this.naturalCreditDao.save(obj);
	}

	@Override
	public int update(MlNaturalCredit obj) {
		return this.naturalCreditDao.update(obj);
	}

	@Override
	public int delete(String ids) {
		String[] idArray = ids.split(",");
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < idArray.length; i++) {
			list.add(idArray[i]);
		}
		MlCorpAppExample example = new MlCorpAppExample();
		example.createCriteria().andAppNoIn(list);
		return this.naturalCreditDao.deleteByExample(example);
	}

	@Override
	public MlNaturalCredit getByPriKey(MlNaturalCredit obj) {
		return (MlNaturalCredit) this.naturalCreditDao.getById(obj.getAppNo());
	}

	@Override
	public Object getByExample(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
