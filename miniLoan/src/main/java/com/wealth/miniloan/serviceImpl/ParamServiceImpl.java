package com.wealth.miniloan.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.googlecode.ehcache.annotations.Cacheable;
import com.googlecode.ehcache.annotations.TriggersRemove;
import com.wealth.miniloan.dao.ParamDao;
import com.wealth.miniloan.entity.DataDictionary;
import com.wealth.miniloan.entity.MlDict;
import com.wealth.miniloan.entity.MlDictExample;
import com.wealth.miniloan.entity.MlDictItemExample;
import com.wealth.miniloan.entity.MlSysParam;
import com.wealth.miniloan.entity.MlSysParamExample;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.ParamServiceI;
import com.wealth.miniloan.utils.SysUtil;

@Service("paramService")
public class ParamServiceImpl implements ParamServiceI {
	private ParamDao paramDao = null;
	private final String _ORDER_ATTRS = "paramTitle,paramCode,paramVal,module,operId,opTime";
	private final String _ORDER_FIELDS = "PARAM_TITLE,PARAM_CODE,PARAM_VAL,MODULE,OPER_ID,OP_TIME";

	public ParamDao getParamDao() {
		return paramDao;
	}

	@Autowired
	public void setParamDao(ParamDao paramDao) {
		this.paramDao = paramDao;
	}

	@Override
	public PageList<MlSysParam> getParamList(Page page, MlSysParam param) {
		MlSysParamExample example = new MlSysParamExample();
		MlSysParamExample.Criteria criteria = example.createCriteria();
		if (param.getParamCode() != null && !"".equals(param.getParamCode())) {
			criteria.andParamCodeLike("%" + param.getParamCode() + "%");
		}
		if (param.getParamTitle() != null && !"".equals(param.getParamTitle())) {
			criteria.andParamTitleLike("%" + param.getParamTitle() + "%");
		}
		String order = SysUtil.dealOrderby(page, _ORDER_ATTRS, _ORDER_FIELDS);
		if (!"".equals(order)) {
			example.setOrderByClause(order);
		}

		return this.paramDao.findPage(SysUtil.convertPage(page), example);
	}

	@Override
	public MlSysParam queryParamById(MlSysParam param) {
		return this.paramDao.getById(param.getParamId());
	}

	@Override
	@TriggersRemove(cacheName = { "paramCache" }, removeAll = true)
	public int updateParam(MlSysParam param) {
		return this.paramDao.updateSelective(param);
	}
	
	@Override
	@Cacheable(cacheName = "paramCache")
	public MlSysParam getParamByCode(String paramCode) {
		MlSysParamExample paramExample = new MlSysParamExample();
		paramExample.createCriteria().andParamCodeEqualTo(paramCode);
		MlSysParam param=this.paramDao.findOne(paramExample);

		return param;
	}
}
