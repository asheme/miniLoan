package com.wealth.miniloan.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.MlContributorInfo;
import com.wealth.miniloan.entity.Page;

public abstract interface ContributorInfoServiceI {
	public PageList<MlContributorInfo> getPageList(Page paramPage, MlContributorInfo obj);

	public abstract int create(MlContributorInfo obj);

	public abstract int update(MlContributorInfo obj);

	public abstract int delete(String ids);

	public abstract MlContributorInfo getByPriKey(MlContributorInfo obj);

	public abstract Object getByExample(Object obj);
}