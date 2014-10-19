package com.wealth.miniloan.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.dao.AppCheckResultDao;
import com.wealth.miniloan.entity.MlAppCheckResult;
import com.wealth.miniloan.entity.MlAppCheckResultExample;
import com.wealth.miniloan.entity.MlAppCheckResultExample.Criteria;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.CheckResultServiceI;
import com.wealth.miniloan.service.CommonServiceI;
import com.wealth.miniloan.utils.SysUtil;

@Service
public class CheckResultServiceImpl implements CheckResultServiceI {
	private AppCheckResultDao appCheckResultDao;

	private final String _ORDER_ATTRS = "approveTime";
	private final String _ORDER_FIELDS = "APPROVE_TIME";

	@Autowired
	public void setAppCheckResultDao(AppCheckResultDao appCheckResultDao) {
		this.appCheckResultDao = appCheckResultDao;
	}

	public List<MlAppCheckResult> getAllList(MlAppCheckResultExample example) {
		return this.appCheckResultDao.findAll(example);
	}

	@Override
	public PageList<MlAppCheckResult> getPageList(Page paramPage, MlAppCheckResult obj) {
		MlAppCheckResultExample example = new MlAppCheckResultExample();
		String appNo = obj.getAppNo();
		Criteria criteria = example.createCriteria();
		if (appNo != null && !"".equals(appNo)) {
			criteria.andAppNoEqualTo(appNo);
		}
		String order = SysUtil.dealOrderby(paramPage, _ORDER_ATTRS, _ORDER_FIELDS);
		if (!order.equals("")) {
			example.setOrderByClause(order);
		}
		return this.appCheckResultDao.findPage(SysUtil.convertPage(paramPage), example);
	}

	@Override
	public int create(MlAppCheckResult obj) {
		return this.appCheckResultDao.save(obj);
	}

	@Override
	public int update(MlAppCheckResult obj) {
		return this.appCheckResultDao.update(obj);
	}

	@Override
	public MlAppCheckResult getByPriKey(MlAppCheckResult obj) {
		return this.appCheckResultDao.getById(obj.getCheckId());
	}

	@Override
	public Object getByExample(Object obj) {
		return appCheckResultDao.findOne(obj);
	}

	@Override
	public int delete(String ids) {
		return 0;
	}

	@Override
	public int updateByLastStatus(MlAppCheckResult appCheckResult) {
		return appCheckResultDao.updateByLastStatus(appCheckResult);
	}

}
