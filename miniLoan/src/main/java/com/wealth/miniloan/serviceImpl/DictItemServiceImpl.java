package com.wealth.miniloan.serviceImpl;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.googlecode.ehcache.annotations.TriggersRemove;
import com.wealth.miniloan.dao.DictItemDao;
import com.wealth.miniloan.entity.MlDictItem;
import com.wealth.miniloan.entity.MlDictItemExample;
import com.wealth.miniloan.entity.MlDictItemExample.Criteria;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.DictItemServiceI;
import com.wealth.miniloan.utils.SysUtil;
import com.wealth.miniloan.utils.key.KeyGenerator;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("dictItemService")
public class DictItemServiceImpl implements DictItemServiceI {
	private DictItemDao dictItemDao = null;
	private final String _ORDER_ATTRS = "itemCode,itemTitle,itemDesc,itemVal,status";
	private final String _ORDER_FIELDS = "ITEM_CODE,ITEM_TITLE,ITEM_DESC,ITEM_VAL,STATUS";

	public DictItemDao getDictItemDao() {
		return this.dictItemDao;
	}

	@Autowired
	public void setDictItemDao(DictItemDao dictItemDao) {
		this.dictItemDao = dictItemDao;
	}

	public PageList<MlDictItem> getDictItemList(Page page, MlDictItem item) {
		MlDictItemExample example = new MlDictItemExample();
		MlDictItemExample.Criteria criteria = example.createCriteria();
		if (item.getDictId() != null) {
			criteria.andDictIdEqualTo(item.getDictId());
		}
		if ((item.getItemCode() != null) && (!"".equals(item.getItemCode()))) {
			criteria.andItemCodeLike("%" + item.getItemCode() + "%");
		}
		if ((item.getItemTitle() != null) && (!"".equals(item.getItemTitle()))) {
			criteria.andItemTitleLike("%" + item.getItemTitle() + "%");
		}
		String order = SysUtil.dealOrderby(page, _ORDER_ATTRS, _ORDER_FIELDS);
		if (!order.equals("")) {
			example.setOrderByClause(order);
		}
		return this.dictItemDao.findPage(SysUtil.convertPage(page), example);
	}

	@TriggersRemove(cacheName = { "dictCache" }, removeAll = true)
	public int creatDictItem(MlDictItem item) {
		item.setItemId(KeyGenerator.getNextKey("ML_DICT_ITEM", "ITEM_ID"));
		return this.dictItemDao.save(item);
	}

	@TriggersRemove(cacheName = { "dictCache" }, removeAll = true)
	public int deleteItem(String ids) {
		String[] id = ids.split(",");
		List idList = new ArrayList();
		for (int i = 0; i < id.length; i++) {
			idList.add(id[i]);
		}
		for (int i = 0; i < idList.size(); i++)
			;
		MlDictItemExample example = new MlDictItemExample();
		example.createCriteria().andItemIdIn(idList);
		return this.dictItemDao.deleteByExample(example);
	}

	@TriggersRemove(cacheName = { "dictCache" }, removeAll = true)
	public int updateItem(MlDictItem item) {
		return this.dictItemDao.update(item);
	}

	public MlDictItem getDictItemById(MlDictItem item) {
		return (MlDictItem) this.dictItemDao.getById(item.getItemId());
	}
}