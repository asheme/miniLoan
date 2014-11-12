package com.wealth.miniloan.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.dao.CapitalContrInfoDao;
import com.wealth.miniloan.entity.MlCapitalContrInfo;
import com.wealth.miniloan.entity.MlCapitalContrInfoExample;
import com.wealth.miniloan.entity.MlContributorInfoExample;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.CapitalContrInfoServiceI;
import com.wealth.miniloan.utils.SysUtil;

@Service
public class CapitalContInfoServiceImpl implements CapitalContrInfoServiceI {
	private CapitalContrInfoDao capitalContrInfoDao = null;
	private final String _ORDER_ATTRS = "capitalId";
	private final String _ORDER_FIELDS = "CAPITAL_ID";

	@Autowired
	public void setCapitalContrInfoDao(CapitalContrInfoDao capitalContrInfoDao) {
		this.capitalContrInfoDao = capitalContrInfoDao;
	}

	@Override
	public PageList<MlCapitalContrInfo> getPageList(Page paramPage, MlCapitalContrInfo obj) {

		MlCapitalContrInfoExample example = new MlCapitalContrInfoExample();
		com.wealth.miniloan.entity.MlCapitalContrInfoExample.Criteria c = example.createCriteria();
		c.andContributorIdEqualTo(obj.getContributorId());
		String order = SysUtil.dealOrderby(paramPage, _ORDER_ATTRS, _ORDER_FIELDS);
		if (!order.equals("")) {
			example.setOrderByClause(order);
		}
		return this.capitalContrInfoDao.findPage(SysUtil.convertPage(paramPage), example);
	}

	
	@Override
	public int create(MlCapitalContrInfo obj) {
		return this.capitalContrInfoDao.save(obj);
	}

	@Override
	public int update(MlCapitalContrInfo obj) {
		return this.capitalContrInfoDao.update(obj);
	}

	@Override
	public int delete(String ids) {
		String[] idArray = ids.split(",");
		List<Long> list = new ArrayList<Long>();
		for (int i = 0; i < idArray.length; i++) {
			list.add(Long.valueOf(idArray[i]));
		}
		MlContributorInfoExample example = new MlContributorInfoExample();
		example.createCriteria().andContributorIdIn(list);
		return this.capitalContrInfoDao.deleteByExample(example);
	}

	@Override
	public MlCapitalContrInfo getByPriKey(MlCapitalContrInfo obj) {
		return (MlCapitalContrInfo) this.capitalContrInfoDao.getById(obj.getCapitalId());
	}

	@Override
	public Object getByExample(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
