package com.wealth.miniloan.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.dao.IntegrityCheckCfgDao;
import com.wealth.miniloan.entity.MlInteCheckItem;
import com.wealth.miniloan.entity.MlInteCheckItemExample;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.IntegrityCheckCfgServiceI;
import com.wealth.miniloan.utils.SysUtil;
import com.wealth.miniloan.utils.key.KeyGenerator;

@Service(value="integrityCheckCfgService")
public class IntegrityCheckCfgServiceImpl implements IntegrityCheckCfgServiceI {
	private IntegrityCheckCfgDao integrityCheckCfgDao;
	private final String _ORDER_ATTRS = "itemId,itemName,itemDesc,itemType,status,creator,createTime";
	private final String _ORDER_FIELDS = "ITEM_ID,ITEM_NAME,ITEM_DESC,ITEM_TYPE,STATUS,CREATOR,CREATE_TIME";

	@Autowired
	public void setIntegrityCheckCfgDao(IntegrityCheckCfgDao integrityCheckCfgDao) {
		this.integrityCheckCfgDao = integrityCheckCfgDao;
	}

	@Override
	public PageList<MlInteCheckItem> getPageList(Page page,
			MlInteCheckItem inteCheckItem) {
		MlInteCheckItemExample example = new MlInteCheckItemExample();
		MlInteCheckItemExample.Criteria criteria = example.createCriteria();
		String itemName = inteCheckItem.getItemName();
		String itemType = inteCheckItem.getItemType();
		if (itemName != null && !"".equals(itemName)) {
			criteria.andItemNameLessThanOrEqualTo("%" + itemName + "%");
		}
		if (itemType != null && !"".equals(itemType)) {
			criteria.andItemTypeEqualTo(itemType);
		}
		String order = SysUtil.dealOrderby(page, _ORDER_ATTRS, _ORDER_FIELDS);
		if (!order.equals("")) {
			example.setOrderByClause(order);
		}
		
		return this.integrityCheckCfgDao.findPage(SysUtil.convertPage(page), example);	
	}

	@Override
	public MlInteCheckItem queryIntegrityCheckItemById(
			MlInteCheckItem inteCheckItem) {
		return this.integrityCheckCfgDao.getById(inteCheckItem.getItemId());
	}

	@Override
	public int createIntegrityCheckItem(MlInteCheckItem inteCheckItem) {
		inteCheckItem.setItemId(KeyGenerator.getNextKey("ML_INTE_CHECK_ITEM", "ITEM_ID"));
		return this.integrityCheckCfgDao.save(inteCheckItem);
	}

	@Override
	public int updateIntegrityCheckItem(MlInteCheckItem inteCheckItem) {
		return this.integrityCheckCfgDao.update(inteCheckItem);
	}

	@Override
	public int deleteIntegrityCheckItem(String ids) {
		String[] id = ids.split(",");
		List idlist = new ArrayList();
		for (int i = 0; i < id.length; i++) {
			idlist.add(id[i]);
		}

		MlInteCheckItemExample example = new MlInteCheckItemExample();
		example.createCriteria().andItemIdIn(idlist);
		return this.integrityCheckCfgDao.deleteByExample(example);
	}
}
