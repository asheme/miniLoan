package com.wealth.miniloan.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.dao.AppCheckResultDao;
import com.wealth.miniloan.dao.AppSummaryDao;
import com.wealth.miniloan.entity.MlAppSummary;
import com.wealth.miniloan.entity.MlAppSummaryExample;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.CommonServiceI;
import com.wealth.miniloan.utils.SysUtil;

@Service
public class AppSummaryServiceImpl implements CommonServiceI<MlAppSummary> {
	private AppSummaryDao appSummaryDao;
	private AppCheckResultDao appCheckResultDao;
	private final String _ORDER_ATTRS = "appNo";
	private final String _ORDER_FIELDS = "APP_NO";

	@Autowired
	public void setAppSummaryDao(AppSummaryDao appSummaryDao) {
		this.appSummaryDao = appSummaryDao;
	}

	@Autowired
	public void setAppCheckResultDao(AppCheckResultDao appCheckResultDao) {
		this.appCheckResultDao = appCheckResultDao;
	}

	@Override
	public PageList<MlAppSummary> getPageList(Page paramPage, MlAppSummary obj) {
		MlAppSummaryExample example = new MlAppSummaryExample();
		MlAppSummaryExample.Criteria criteria = example.createCriteria();
		// if (name != null && !"".equals(name)) {
		// criteria.andNameLike("%" + name + "%");
		// }
		// if (idNo != null && !"".equals(idNo)) {
		// criteria.andIdNoLike("%" + idNo + "%");
		// }
		criteria.andCurrStepEqualTo(obj.getCurrStep());

		String order = SysUtil.dealOrderby(paramPage, _ORDER_ATTRS, _ORDER_FIELDS);
		if (!order.equals("")) {
			example.setOrderByClause(order);
		}
		return this.appSummaryDao.findPage(SysUtil.convertPage(paramPage), example);
	}

	@Override
	public int create(MlAppSummary obj) {
		return this.appSummaryDao.save(obj);
	}

	@Override
	public int update(MlAppSummary obj) {
		return this.appSummaryDao.update(obj);
	}

	@Override
	public int delete(String ids) {
		String[] idArray = ids.split(",");
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < idArray.length; i++) {
			list.add(idArray[i]);
		}
		MlAppSummaryExample example = new MlAppSummaryExample();
		example.createCriteria().andAppNoIn(list);
		return this.appSummaryDao.deleteByExample(example);
	}

	@Override
	public MlAppSummary getByPriKey(MlAppSummary obj) {
		return (MlAppSummary) this.appSummaryDao.getById(obj.getAppNo());
	}

	@Override
	public Object getByExample(Object obj) {
		return this.appCheckResultDao.findOne(obj);
	}
}
