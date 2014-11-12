package com.wealth.miniloan.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.MlCapitalContrInfo;
import com.wealth.miniloan.entity.Page;

public abstract interface CapitalContrInfoServiceI {
	public PageList<MlCapitalContrInfo> getPageList(Page paramPage, MlCapitalContrInfo obj);

	public abstract int create(MlCapitalContrInfo obj);

	public abstract int update(MlCapitalContrInfo obj);

	public abstract int delete(String ids);

	public abstract MlCapitalContrInfo getByPriKey(MlCapitalContrInfo obj);

	public abstract Object getByExample(Object obj);
}