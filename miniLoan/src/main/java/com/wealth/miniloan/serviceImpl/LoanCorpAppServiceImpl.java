package com.wealth.miniloan.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.dao.CorpAppDao;
import com.wealth.miniloan.entity.MlCorpApp;
import com.wealth.miniloan.entity.MlCorpAppExample;
import com.wealth.miniloan.entity.MlCorpAppExample.Criteria;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.CommonServiceI;
import com.wealth.miniloan.utils.SysUtil;

@Service
public class LoanCorpAppServiceImpl implements CommonServiceI<MlCorpApp> {
	private CorpAppDao corpAppDao = null;
	private final String _ORDER_ATTRS = "appNo";
	private final String _ORDER_FIELDS = "APP_NO";
	
	@Autowired
	public void setCorpAppDao(CorpAppDao corpAppDao) {
		this.corpAppDao = corpAppDao;
	}

	@Override
	public PageList<MlCorpApp> getPageList(Page paramPage, MlCorpApp obj) {
		MlCorpAppExample example = new MlCorpAppExample();
		String name = obj.getCompName();
		Criteria criteria = example.createCriteria();
		if (name != null && !"".equals(name)) {
			criteria.andCompNameLike("%" + name + "%");
		}

		String order = SysUtil.dealOrderby(paramPage, _ORDER_ATTRS, _ORDER_FIELDS);
		if (!order.equals("")) {
			example.setOrderByClause(order);
		}
		return this.corpAppDao.findPage(SysUtil.convertPage(paramPage), example);
	}

	@Override
	public int create(MlCorpApp obj) {
		return this.corpAppDao.save(obj);
	}

	@Override
	public int update(MlCorpApp obj) {
		return this.corpAppDao.update(obj);
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
		return this.corpAppDao.deleteByExample(example);
	}

	@Override
	public MlCorpApp getByPriKey(MlCorpApp obj) {
		return (MlCorpApp) this.corpAppDao.getById(obj.getAppNo());
	}

	

}
