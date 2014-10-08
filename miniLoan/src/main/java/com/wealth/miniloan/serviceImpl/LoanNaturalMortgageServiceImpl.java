package com.wealth.miniloan.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.dao.NaturalMortgageDao;
import com.wealth.miniloan.entity.MlNaturalMortgage;
import com.wealth.miniloan.entity.MlNaturalMortgageExample;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.CommonServiceI;
import com.wealth.miniloan.utils.SysUtil;

@Service
public class LoanNaturalMortgageServiceImpl implements CommonServiceI<MlNaturalMortgage> {
	private NaturalMortgageDao naturalMortgageDao = null;
	private final String _ORDER_ATTRS = "mortgageId";
	private final String _ORDER_FIELDS = "MORTGAGE_ID";

	@Autowired
	public void setNaturalMortgageDao(NaturalMortgageDao naturalMortgageDao) {
		this.naturalMortgageDao = naturalMortgageDao;
	}

	@Override
	public PageList<MlNaturalMortgage> getPageList(Page paramPage, MlNaturalMortgage obj) {
		MlNaturalMortgageExample example = new MlNaturalMortgageExample();
		String appNo = obj.getAppNo();
		com.wealth.miniloan.entity.MlNaturalMortgageExample.Criteria criteria = example.createCriteria();
		if (appNo != null && !"".equals(appNo)) {
			criteria.andAppNoEqualTo(appNo);
		}

		String order = SysUtil.dealOrderby(paramPage, _ORDER_ATTRS, _ORDER_FIELDS);
		if (!order.equals("")) {
			example.setOrderByClause(order);
		}
		return this.naturalMortgageDao.findPage(SysUtil.convertPage(paramPage), example);
	}

	@Override
	public int create(MlNaturalMortgage obj) {
		return this.naturalMortgageDao.save(obj);
	}

	@Override
	public int update(MlNaturalMortgage obj) {
		return this.naturalMortgageDao.update(obj);
	}

	@Override
	public int delete(String ids) {
		String[] idArray = ids.split(",");
		List<Long> list = new ArrayList<Long>();
		for (int i = 0; i < idArray.length; i++) {
			list.add(Long.valueOf(idArray[i]));
		}
		MlNaturalMortgageExample example = new MlNaturalMortgageExample();
		example.createCriteria().andMortgageIdIn(list);
		return this.naturalMortgageDao.deleteByExample(example);
	}

	@Override
	public MlNaturalMortgage getByPriKey(MlNaturalMortgage obj) {
		return (MlNaturalMortgage) this.naturalMortgageDao.getById(obj.getMortgageId());
	}

	@Override
	public Object getByExample(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
