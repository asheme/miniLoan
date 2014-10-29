package com.wealth.miniloan.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.MlFraudCheckResult;
import com.wealth.miniloan.entity.Page;

public interface FraudCheckResultServiceI {
	public PageList<MlFraudCheckResult> getPageList(Page paramPage, MlFraudCheckResult obj);
	public int create(MlFraudCheckResult obj);
	public int update(MlFraudCheckResult obj);
	public MlFraudCheckResult getByPriKey(MlFraudCheckResult obj);
	public Object getByExample(Object obj);
	public int delete(String ids);
	public void dealFraudCheck(String appNo);
	public void deleteFraudCheck(String appNo);
}
