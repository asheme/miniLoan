package com.wealth.miniloan.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.MlAppCheckResult;
import com.wealth.miniloan.entity.Page;

public interface CheckResultServiceI {
	public PageList<MlAppCheckResult> getPageList(Page paramPage, MlAppCheckResult obj);
	public int create(MlAppCheckResult obj);
	public int update(MlAppCheckResult obj);
	public MlAppCheckResult getByPriKey(MlAppCheckResult obj);
	public Object getByExample(Object obj);
	public int delete(String ids);
	public int updateByLastStatus(MlAppCheckResult appCheckResult);
}
