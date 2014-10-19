package com.wealth.miniloan.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.MlApproveTaskCfg;
import com.wealth.miniloan.entity.MlApproveTaskCfgExample;
import com.wealth.miniloan.entity.Page;

public interface AppFlowServiceI {
	public abstract PageList<MlApproveTaskCfg> getAppFlowList(Page paramPage, MlApproveTaskCfg appTask);
	public abstract MlApproveTaskCfg queryAppFlowById(MlApproveTaskCfg appTask);
	public abstract int createAppFlow(MlApproveTaskCfg appTask);
	public abstract int updateAppFlow(MlApproveTaskCfg appTask);
	public abstract int deleteAppFlow(String ids);
	public abstract String getFirstStep();
	public abstract String getNextStep(String currStep);
	public abstract String getEndStep();
	public abstract MlApproveTaskCfg getByExample(MlApproveTaskCfgExample example);
}
