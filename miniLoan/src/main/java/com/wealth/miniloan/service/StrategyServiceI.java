package com.wealth.miniloan.service;

import java.util.List;

import com.wealth.miniloan.entity.MlAppStrategyResult;
import com.wealth.miniloan.entity.MlSysDecisionExclude;

public interface StrategyServiceI {
	public abstract boolean generatorSysDecisionResult(String appNo,String appType);
	public abstract MlAppStrategyResult getStrategyResultByPrikey(String appNo);
	public abstract List<MlSysDecisionExclude> getSysDecisionExcludeList(String appNo);
}
