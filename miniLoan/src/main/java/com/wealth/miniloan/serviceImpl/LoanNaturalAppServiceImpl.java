package com.wealth.miniloan.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.dao.AppSummaryDao;
import com.wealth.miniloan.dao.NaturalAppDao;
import com.wealth.miniloan.entity.MlAppSummary;
import com.wealth.miniloan.entity.MlAppSummaryExample;
import com.wealth.miniloan.entity.MlAppSummaryExample.Criteria;
import com.wealth.miniloan.entity.MlNaturalApp;
import com.wealth.miniloan.entity.MlNaturalAppExample;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.CommonServiceI;
import com.wealth.miniloan.utils.SysUtil;

@Service
public class LoanNaturalAppServiceImpl implements CommonServiceI<MlNaturalApp> {
	private NaturalAppDao naturalAppDao = null;
	private AppSummaryDao appSummaryDao = null;
	private final String _ORDER_ATTRS = "appNo";
	private final String _ORDER_FIELDS = "APP_NO";

	public NaturalAppDao getNaturalAppDao() {
		return naturalAppDao;
	}

	@Autowired
	public void setNaturalAppDao(NaturalAppDao naturalAppDao) {
		this.naturalAppDao = naturalAppDao;
	}

	@Autowired
	public void setAppSummaryDao(AppSummaryDao appSummaryDao) {
		this.appSummaryDao = appSummaryDao;
	}

	@Override
	public PageList<MlNaturalApp> getPageList(Page paramPage, MlNaturalApp obj) {
		List<String> appNoList = new ArrayList<String>();
		MlAppSummaryExample asExample = new MlAppSummaryExample();
		Criteria c = asExample.createCriteria();
		c.andAppTypeEqualTo("01");
		c.andCurrStepEqualTo("00");
		List<MlAppSummary> asList = this.appSummaryDao.findAll(asExample);

		for (MlAppSummary as : asList) {
			appNoList.add(as.getAppNo());
		}
		MlNaturalAppExample example = new MlNaturalAppExample();
		MlNaturalAppExample.Criteria criteria = example.createCriteria();
		// String name = obj.getName();
		// String idNo = obj.getIdNo();
		// if (name != null && !"".equals(name)) {
		// criteria.andNameLike("%" + name + "%");
		// }
		// if (idNo != null && !"".equals(idNo)) {
		// criteria.andIdNoLike("%" + idNo + "%");
		// }

		if (appNoList.size() != 0) {
			criteria.andAppNoIn(appNoList);
		} else {
			criteria.andAppNoEqualTo("0");
		}
		String order = SysUtil.dealOrderby(paramPage, _ORDER_ATTRS, _ORDER_FIELDS);
		if (!order.equals("")) {
			example.setOrderByClause(order);
		}
		return this.naturalAppDao.findPage(SysUtil.convertPage(paramPage), example);
	}

	@Override
	public int create(MlNaturalApp obj) {
		return this.naturalAppDao.save(obj);
	}

	@Override
	public int update(MlNaturalApp obj) {
		return this.naturalAppDao.update(obj);
	}

	@Override
	public int delete(String ids) {
		String[] idArray = ids.split(",");
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < idArray.length; i++) {
			list.add(idArray[i]);
		}
		MlNaturalAppExample example = new MlNaturalAppExample();
		example.createCriteria().andAppNoIn(list);
		return this.naturalAppDao.deleteByExample(example);
	}

	@Override
	public MlNaturalApp getByPriKey(MlNaturalApp obj) {
		return (MlNaturalApp) this.naturalAppDao.getById(obj.getAppNo());
	}

	@Override
	public Object getByExample(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
