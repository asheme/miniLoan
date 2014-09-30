package com.wealth.miniloan.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.dao.CorpAttachDao;
import com.wealth.miniloan.entity.MlCorpAttach;
import com.wealth.miniloan.entity.MlCorpAttachExample;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.CommonServiceI;
import com.wealth.miniloan.utils.SysUtil;

@Service
public class LoanCorpAttachServiceImpl implements CommonServiceI<MlCorpAttach> {
	private CorpAttachDao CorpAttachDao = null;
	private final String _ORDER_ATTRS = "appNo";
	private final String _ORDER_FIELDS = "APP_NO";
	
	@Autowired
	public void setCorpAttachDao(CorpAttachDao CorpAttachDao) {
		this.CorpAttachDao = CorpAttachDao;
	}

	@Override
	public PageList<MlCorpAttach> getPageList(Page paramPage, MlCorpAttach obj) {
		MlCorpAttachExample example = new MlCorpAttachExample();
		String appNo = obj.getAppNo();
		com.wealth.miniloan.entity.MlCorpAttachExample.Criteria criteria = example.createCriteria();
		if (appNo != null && !"".equals(appNo)) {
			criteria.andAppNoEqualTo(appNo);
		}
		return this.CorpAttachDao.findPage(SysUtil.convertPage(paramPage), example);
	}

	@Override
	public int create(MlCorpAttach obj) {
		return this.CorpAttachDao.save(obj);
	}

	@Override
	public int update(MlCorpAttach obj) {
		return this.CorpAttachDao.update(obj);
	}

	@Override
	public int delete(String ids) {
		String[] idArray = ids.split(",");
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < idArray.length; i++) {
			list.add(idArray[i]);
		}
		MlCorpAttachExample example = new MlCorpAttachExample();
		example.createCriteria().andAppNoIn(list);
		return this.CorpAttachDao.deleteByExample(example);
	}

	@Override
	public MlCorpAttach getByPriKey(MlCorpAttach obj) {
		return (MlCorpAttach) this.CorpAttachDao.getById(obj.getAppNo());
	}

	

}
