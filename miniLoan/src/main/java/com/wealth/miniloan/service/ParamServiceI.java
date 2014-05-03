package com.wealth.miniloan.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.MlSysParam;
import com.wealth.miniloan.entity.Page;

public interface ParamServiceI {
	public PageList<MlSysParam> getParamList(Page page, MlSysParam param);
	
	public MlSysParam queryParamById(MlSysParam param);
	
	public int updateParam(MlSysParam param);
}
