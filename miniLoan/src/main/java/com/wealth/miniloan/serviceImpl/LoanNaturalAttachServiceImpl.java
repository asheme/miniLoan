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
	private NaturalAttachDao naturalAttachDao = null;
	private final String _ORDER_ATTRS = "fileNo";
	private final String _ORDER_FIELDS = "FILE_NO";

	@Autowired
	public void setNaturalAttachDao(NaturalAttachDao naturalAttachDao) {
		this.naturalAttachDao = naturalAttachDao;
	}

	@Override
	public PageList<MlNaturalAttach> getPageList(Page paramPage, MlNaturalAttach obj) {
		MlNaturalAttachExample example = new MlNaturalAttachExample();
		String appNo = obj.getAppNo();
		com.wealth.miniloan.entity.MlNaturalAttachExample.Criteria criteria = example.createCriteria();
		if (appNo != null && !"".equals(appNo)) {
			criteria.andAppNoEqualTo(appNo);
		}

		String order = SysUtil.dealOrderby(paramPage, _ORDER_ATTRS, _ORDER_FIELDS);
		if (!order.equals("")) {
			example.setOrderByClause(order);
		}
		return this.naturalAttachDao.findPage(SysUtil.convertPage(paramPage), example);
	}

	@Override
	public int create(MlNaturalAttach obj) {
		return this.naturalAttachDao.save(obj);
	}

	@Override
	public int update(MlNaturalAttach obj) {
		return this.naturalAttachDao.update(obj);
	}

	@Override
	public int delete(String ids) {
		String[] idArray = ids.split(",");
		List<Long> list = new ArrayList<Long>();
		for (int i = 0; i < idArray.length; i++) {
			list.add(Long.valueOf(idArray[i]));
		}
		MlNaturalAttachExample example = new MlNaturalAttachExample();
		example.createCriteria().andFileNoIn(list);
		return this.naturalAttachDao.deleteByExample(example);
	}

	@Override
	public MlNaturalAttach getByPriKey(MlNaturalAttach obj) {
		return (MlNaturalAttach) this.naturalAttachDao.getById(obj.getFileNo());
	}

	@Override
	public Object getByExample(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
