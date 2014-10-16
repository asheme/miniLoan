package com.wealth.miniloan.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.dao.MortgageInfoDao;
import com.wealth.miniloan.entity.MlMortgageInfo;
import com.wealth.miniloan.entity.MlMortgageInfoExample;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.CommonServiceI;
import com.wealth.miniloan.utils.SysUtil;

@Service
public class MortgageInfoServiceImpl implements CommonServiceI<MlMortgageInfo> {
	private MortgageInfoDao mortgageInfoDao = null;
	private final String _ORDER_ATTRS = "mortgageId";
	private final String _ORDER_FIELDS = "MORTGAGE_ID";

	@Autowired
	public void setMortgageInfoDao(MortgageInfoDao mortgageInfoDao) {
		this.mortgageInfoDao = mortgageInfoDao;
	}

	@Override
	public PageList<MlMortgageInfo> getPageList(Page paramPage, MlMortgageInfo obj) {
		MlMortgageInfoExample example = new MlMortgageInfoExample();
		String appNo = obj.getAppNo();
		com.wealth.miniloan.entity.MlMortgageInfoExample.Criteria criteria = example.createCriteria();
		if (appNo != null && !"".equals(appNo)) {
			criteria.andAppNoEqualTo(appNo);
		}

		String order = SysUtil.dealOrderby(paramPage, _ORDER_ATTRS, _ORDER_FIELDS);
		if (!order.equals("")) {
			example.setOrderByClause(order);
		}
		return this.mortgageInfoDao.findPage(SysUtil.convertPage(paramPage), example);
	}

	@Override
	public int create(MlMortgageInfo obj) {
		return this.mortgageInfoDao.save(obj);
	}

	@Override
	public int update(MlMortgageInfo obj) {
		return this.mortgageInfoDao.update(obj);
	}

	@Override
	public int delete(String ids) {
		String[] idArray = ids.split(",");
		List<Long> list = new ArrayList<Long>();
		for (int i = 0; i < idArray.length; i++) {
			list.add(Long.valueOf(idArray[i]));
		}
		MlMortgageInfoExample example = new MlMortgageInfoExample();
		example.createCriteria().andMortgageIdIn(list);
		return this.mortgageInfoDao.deleteByExample(example);
	}

	@Override
	public MlMortgageInfo getByPriKey(MlMortgageInfo obj) {
		return (MlMortgageInfo) this.mortgageInfoDao.getById(obj.getMortgageId());
	}

	@Override
	public Object getByExample(Object obj) {
		return this.mortgageInfoDao.findAll(obj);
	}

}
