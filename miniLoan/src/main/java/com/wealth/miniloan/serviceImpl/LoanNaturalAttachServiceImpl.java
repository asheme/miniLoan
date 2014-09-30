package com.wealth.miniloan.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.dao.NaturalAttachDao;
import com.wealth.miniloan.entity.MlNaturalAttach;
import com.wealth.miniloan.entity.MlNaturalAttachExample;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.CommonServiceI;
import com.wealth.miniloan.utils.SysUtil;

@Service
public class LoanNaturalAttachServiceImpl implements CommonServiceI<MlNaturalAttach> {
	private NaturalAttachDao NaturalAttachDao = null;
	private final String _ORDER_ATTRS = "appNo";
	private final String _ORDER_FIELDS = "APP_NO";
	
	@Autowired
	public void setNaturalAttachDao(NaturalAttachDao NaturalAttachDao) {
		this.NaturalAttachDao = NaturalAttachDao;
	}

	@Override
	public PageList<MlNaturalAttach> getPageList(Page paramPage, MlNaturalAttach obj) {
		MlNaturalAttachExample example = new MlNaturalAttachExample();
		String appNo = obj.getAppNo();
		com.wealth.miniloan.entity.MlNaturalAttachExample.Criteria criteria = example.createCriteria();
		if (appNo != null && !"".equals(appNo)) {
			criteria.andAppNoEqualTo(appNo);
		}
		return this.NaturalAttachDao.findPage(SysUtil.convertPage(paramPage), example);
	}

	@Override
	public int create(MlNaturalAttach obj) {
		return this.NaturalAttachDao.save(obj);
	}

	@Override
	public int update(MlNaturalAttach obj) {
		return this.NaturalAttachDao.update(obj);
	}

	@Override
	public int delete(String ids) {
		String[] idArray = ids.split(",");
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < idArray.length; i++) {
			list.add(idArray[i]);
		}
		MlNaturalAttachExample example = new MlNaturalAttachExample();
		example.createCriteria().andAppNoIn(list);
		return this.NaturalAttachDao.deleteByExample(example);
	}

	@Override
	public MlNaturalAttach getByPriKey(MlNaturalAttach obj) {
		return (MlNaturalAttach) this.NaturalAttachDao.getById(obj.getAppNo());
	}

	

}
