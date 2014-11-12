package com.wealth.miniloan.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.dao.ContributorInfoDao;
import com.wealth.miniloan.entity.MlContributorInfo;
import com.wealth.miniloan.entity.MlContributorInfoExample;
import com.wealth.miniloan.entity.MlContributorInfoExample.Criteria;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.ContributorInfoServiceI;
import com.wealth.miniloan.utils.SysUtil;

@Service
public class ContributorInfoServiceImpl implements ContributorInfoServiceI {
	private ContributorInfoDao contributorInfoDao = null;
	private final String _ORDER_ATTRS = "contributorId";
	private final String _ORDER_FIELDS = "CONTRIBUTOR_ID";

	@Autowired
	public void setContributorInfoDao(ContributorInfoDao contributorInfoDao) {
		this.contributorInfoDao = contributorInfoDao;
	}

	@Override
	public PageList<MlContributorInfo> getPageList(Page paramPage, MlContributorInfo obj) {

		MlContributorInfoExample example = new MlContributorInfoExample();
		Criteria c = example.createCriteria();
		if(StringUtils.isNotEmpty(obj.getName())){
			c.andNameLike(obj.getName() + "%");
		}
		if(StringUtils.isNotEmpty(obj.getIdNo())){
			c.andIdNoLike(obj.getIdNo() + "%");
		}
		String order = SysUtil.dealOrderby(paramPage, _ORDER_ATTRS, _ORDER_FIELDS);
		if (!order.equals("")) {
			example.setOrderByClause(order);
		}
		return this.contributorInfoDao.findPage(SysUtil.convertPage(paramPage), example);
	}

	@Override
	public int create(MlContributorInfo obj) {
		return this.contributorInfoDao.save(obj);
	}

	@Override
	public int update(MlContributorInfo obj) {
		return this.contributorInfoDao.update(obj);
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
		return this.contributorInfoDao.deleteByExample(example);
	}

	@Override
	public MlContributorInfo getByPriKey(MlContributorInfo obj) {
		return (MlContributorInfo) this.contributorInfoDao.getById(obj.getContributorId());
	}

	@Override
	public Object getByExample(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
