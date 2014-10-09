package com.wealth.miniloan.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.dao.ShareholderDao;
import com.wealth.miniloan.entity.MlShareholder;
import com.wealth.miniloan.entity.MlShareholderExample;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.CommonServiceI;
import com.wealth.miniloan.utils.SysUtil;

@Service
public class LoanShareholderServiceImpl implements CommonServiceI<MlShareholder> {
	private ShareholderDao shareholderDao = null;
	private final String _ORDER_ATTRS = "appNo";
	private final String _ORDER_FIELDS = "APP_NO";

	@Autowired
	public void setShareholderDao(ShareholderDao shareholderDao) {
		this.shareholderDao = shareholderDao;
	}

	@Override
	public PageList<MlShareholder> getPageList(Page paramPage, MlShareholder obj) {
		MlShareholderExample example = new MlShareholderExample();
		String appNo = obj.getAppNo();
		com.wealth.miniloan.entity.MlShareholderExample.Criteria criteria = example.createCriteria();
		if (appNo != null && !"".equals(appNo)) {
			criteria.andAppNoEqualTo(appNo);
		}
		String order = SysUtil.dealOrderby(paramPage, _ORDER_ATTRS, _ORDER_FIELDS);
		if (!order.equals("")) {
			example.setOrderByClause(order);
		}
		return this.shareholderDao.findPage(SysUtil.convertPage(paramPage), example);
	}

	@Override
	public int create(MlShareholder obj) {
		return this.shareholderDao.save(obj);
	}

	@Override
	public int update(MlShareholder obj) {
		return this.shareholderDao.update(obj);
	}

	@Override
	public int delete(String ids) {
		String[] idArray = ids.split(",");
		List<Long> list = new ArrayList<Long>();
		for (int i = 0; i < idArray.length; i++) {
			list.add(Long.valueOf(idArray[i]));
		}
		MlShareholderExample example = new MlShareholderExample();
		example.createCriteria().andShareholderIdIn(list);
		return this.shareholderDao.deleteByExample(example);
	}

	@Override
	public MlShareholder getByPriKey(MlShareholder obj) {
		return (MlShareholder) this.shareholderDao.getById(obj.getShareholderId());
	}

	@Override
	public Object getByExample(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
