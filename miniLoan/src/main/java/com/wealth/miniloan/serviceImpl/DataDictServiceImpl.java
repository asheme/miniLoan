package com.wealth.miniloan.serviceImpl;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.googlecode.ehcache.annotations.Cacheable;
import com.googlecode.ehcache.annotations.TriggersRemove;
import com.wealth.miniloan.dao.DictDao;
import com.wealth.miniloan.dao.DictItemDao;
import com.wealth.miniloan.entity.DataDictionary;
import com.wealth.miniloan.entity.MlDict;
import com.wealth.miniloan.entity.MlDictExample;
import com.wealth.miniloan.entity.MlDictItemExample;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.DataDictServiceI;
import com.wealth.miniloan.utils.SysUtil;
import com.wealth.miniloan.utils.key.KeyGenerator;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("dictService")
public class DataDictServiceImpl implements DataDictServiceI {
	private DictDao dictDao = null;
	private DictItemDao dictItemDao = null;
	private final String _ORDER_ATTRS = "dictTitle,dictDesc,dictType,status";
	private final String _ORDER_FIELDS = "DICT_TITLE,DICT_DESC,DICT_TYPE,STATUS";

	public DictDao getDictDao() {
		return this.dictDao;
	}

	@Autowired
	public void setDictDao(DictDao dictDao) {
		this.dictDao = dictDao;
	}

	public DictItemDao getDictItemDao() {
		return this.dictItemDao;
	}

	@Autowired
	public void setDictItemDao(DictItemDao dictItemDao) {
		this.dictItemDao = dictItemDao;
	}

	public PageList<MlDict> getDictList(Page page, MlDict dict) {
		MlDictExample example = new MlDictExample();
		MlDictExample.Criteria criteria = example.createCriteria();
		String dictTitle = dict.getDictTitle();
		String dictDesc = dict.getDictDesc();
		if (dictDesc != null && !"".equals(dictDesc)) {
			criteria.andDictDescLike("%" + dictDesc + "%");
		}
		if (dictTitle != null && !"".equals(dictTitle)) {
			criteria.andDictTitleLike("%" + dictTitle + "%");
		}
		String order = SysUtil.dealOrderby(page, _ORDER_ATTRS, _ORDER_FIELDS);
		if (!order.equals("")) {
			example.setOrderByClause(order);
		}
		return this.dictDao.findPage(SysUtil.convertPage(page), example);
	}

	@TriggersRemove(cacheName = { "dictCache" }, removeAll = true)
	public int createDict(MlDict dict) {
		dict.setDictId(KeyGenerator.getNextKey("ML_DICT", "DICT_ID"));
		return this.dictDao.save(dict);
	}

	@TriggersRemove(cacheName = { "dictCache" }, removeAll = true)
	public int updateDict(MlDict dict) {
		return this.dictDao.updateSelective(dict);
	}

	@Override
	public MlDict queryDictById(MlDict dict) {
		return (MlDict) this.dictDao.getById(dict.getDictId());
	}

	@TriggersRemove(cacheName = { "dictCache" }, removeAll = true)
	public int deleteDict(String ids) {
		String[] id = ids.split(",");
		List idlist = new ArrayList();
		for (int i = 0; i < id.length; i++) {
			idlist.add(id[i]);
		}

		MlDictExample example = new MlDictExample();
		example.createCriteria().andDictIdIn(idlist);
		return this.dictDao.deleteByExample(example);
	}

	@Cacheable(cacheName = "dictCache")
	public DataDictionary getDictItemsByDictName(String dictName) {
		MlDictExample dictExample = new MlDictExample();
		dictExample.createCriteria().andDictTitleEqualTo(dictName);
		DataDictionary dataDictionary = new DataDictionary();
		dataDictionary.setDict((MlDict) this.dictDao.findOne(dictExample));

		if (dataDictionary.getDict() != null) {
			MlDictItemExample itemExample = new MlDictItemExample();
			itemExample.createCriteria().andDictIdEqualTo(dataDictionary.getDict().getDictId());
			dataDictionary.setDictItemList(this.dictItemDao.findAll(itemExample));
		}

		return dataDictionary;
	}
}