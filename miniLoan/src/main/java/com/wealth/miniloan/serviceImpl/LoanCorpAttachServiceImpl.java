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
import com.wealth.miniloan.service.LoanCorpAttachServiceI;
import com.wealth.miniloan.utils.SysUtil;

@Service(value="corpAttachService")
public class LoanCorpAttachServiceImpl implements LoanCorpAttachServiceI {
	private CorpAttachDao corpAttachDao = null;
	private final String _ORDER_ATTRS = "fileNo";
	private final String _ORDER_FIELDS = "FILE_NO";

	@Autowired
	public void setCorpAttachDao(CorpAttachDao corpAttachDao) {
		this.corpAttachDao = corpAttachDao;
	}

	@Override
	public PageList<MlCorpAttach> getCorpAttachPageList(Page paramPage, MlCorpAttach obj) {
		MlCorpAttachExample example = new MlCorpAttachExample();
		String appNo = obj.getAppNo();
		com.wealth.miniloan.entity.MlCorpAttachExample.Criteria criteria = example.createCriteria();
		if (appNo != null && !"".equals(appNo)) {
			criteria.andAppNoEqualTo(appNo);
		}
		String order = SysUtil.dealOrderby(paramPage, _ORDER_ATTRS, _ORDER_FIELDS);
		if (!order.equals("")) {
			example.setOrderByClause(order);
		}
		return this.corpAttachDao.findPage(SysUtil.convertPage(paramPage), example);
	}

	@Override
	public int createCorpAttach(MlCorpAttach obj) {
		return this.corpAttachDao.save(obj);
	}

	@Override
	public int updateCorpAttach(MlCorpAttach obj) {
		return this.corpAttachDao.update(obj);
	}

	@Override
	public int deleteCorpAttach(String ids) {
		String[] idArray = ids.split(",");
		List<Long> list = new ArrayList<Long>();
		for (int i = 0; i < idArray.length; i++) {
			list.add(Long.valueOf(idArray[i]));
		}
		MlCorpAttachExample example = new MlCorpAttachExample();
		example.createCriteria().andFileNoIn(list);
		return this.corpAttachDao.deleteByExample(example);
	}

	@Override
	public MlCorpAttach getCorpAttachByPriKey(MlCorpAttach obj) {
		return (MlCorpAttach) this.corpAttachDao.getById(obj.getFileNo());
	}

	@Override
	public List<MlCorpAttach> getCorpAttachListByIds(String ids) {
		String[] idArray = ids.split(",");
		List<Long> list = new ArrayList<Long>();
		for (int i = 0; i < idArray.length; i++) {
			list.add(Long.valueOf(idArray[i]));
		}
		MlCorpAttachExample example = new MlCorpAttachExample();
		example.createCriteria().andFileNoIn(list);
		return this.corpAttachDao.findAll(example);
	}

}
