package com.wealth.miniloan.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.dao.NameListDao;
import com.wealth.miniloan.entity.MlNameList;
import com.wealth.miniloan.entity.MlNameListExample;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.CommonServiceI;
import com.wealth.miniloan.utils.SysUtil;

@Service
public class NameListServiceImpl implements CommonServiceI<MlNameList> {
	private NameListDao nameListDao = null;
	private final String _ORDER_ATTRS = "nameId";
	private final String _ORDER_FIELDS = "NAME_ID";

	@Autowired
	public void setNameListDao(NameListDao nameListDao) {
		this.nameListDao = nameListDao;
	}

	@Override
	public PageList<MlNameList> getPageList(Page paramPage, MlNameList obj) {

		MlNameListExample example = new MlNameListExample();
		com.wealth.miniloan.entity.MlNameListExample.Criteria c = example.createCriteria();
		c.andNameTypeEqualTo(obj.getNameType());
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
		return this.nameListDao.findPage(SysUtil.convertPage(paramPage), example);
	}

	@Override
	public int create(MlNameList obj) {
		return this.nameListDao.save(obj);
	}

	@Override
	public int update(MlNameList obj) {
		return this.nameListDao.update(obj);
	}

	@Override
	public int delete(String ids) {
		String[] idArray = ids.split(",");
		List<Long> list = new ArrayList<Long>();
		for (int i = 0; i < idArray.length; i++) {
			list.add(Long.valueOf(idArray[i]));
		}
		MlNameListExample example = new MlNameListExample();
		example.createCriteria().andNameIdIn(list);
		return this.nameListDao.deleteByExample(example);
	}

	@Override
	public MlNameList getByPriKey(MlNameList obj) {
		return (MlNameList) this.nameListDao.getById(obj.getNameId());
	}

	@Override
	public Object getByExample(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
