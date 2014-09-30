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
	private NaturalMortgageDao NaturalMortgageDao = null;
	private final String _ORDER_ATTRS = "appNo";
	private final String _ORDER_FIELDS = "APP_NO";
	
	@Autowired
	public void setNaturalMortgageDao(NaturalMortgageDao NaturalMortgageDao) {
		this.NaturalMortgageDao = NaturalMortgageDao;
	}

	@Override
	public PageList<MlNaturalMortgage> getPageList(Page paramPage, MlNaturalMortgage obj) {
		MlNaturalMortgageExample example = new MlNaturalMortgageExample();
		String appNo = obj.getAppNo();
		com.wealth.miniloan.entity.MlNaturalMortgageExample.Criteria criteria = example.createCriteria();
		if (appNo != null && !"".equals(appNo)) {
			criteria.andAppNoEqualTo(appNo);
		}
		return this.NaturalMortgageDao.findPage(SysUtil.convertPage(paramPage), example);
	}

	@Override
	public int create(MlNaturalMortgage obj) {
		return this.NaturalMortgageDao.save(obj);
	}

	@Override
	public int update(MlNaturalMortgage obj) {
		return this.NaturalMortgageDao.update(obj);
	}

	@Override
	public int delete(String ids) {
		String[] idArray = ids.split(",");
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < idArray.length; i++) {
			list.add(idArray[i]);
		}
		MlNaturalMortgageExample example = new MlNaturalMortgageExample();
		example.createCriteria().andAppNoIn(list);
		return this.NaturalMortgageDao.deleteByExample(example);
	}

	@Override
	public MlNaturalMortgage getByPriKey(MlNaturalMortgage obj) {
		return (MlNaturalMortgage) this.NaturalMortgageDao.getById(obj.getAppNo());
	}

	

}
