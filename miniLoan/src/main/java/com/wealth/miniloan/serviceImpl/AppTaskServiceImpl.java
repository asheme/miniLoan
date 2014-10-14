package com.wealth.miniloan.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.dao.AppFlowDao;
import com.wealth.miniloan.entity.MlApproveTaskCfg;
import com.wealth.miniloan.entity.MlApproveTaskCfgExample;
import com.wealth.miniloan.entity.Page;
import com.wealth.miniloan.service.AppFlowServiceI;
import com.wealth.miniloan.utils.SysUtil;
import com.wealth.miniloan.utils.key.KeyGenerator;

@Service(value="appFlowService")
public class AppTaskServiceImpl implements AppFlowServiceI {
	private AppFlowDao appFlowDao = null;
	private final String _ORDER_ATTRS = "taskId,taskName,taskDesc,taskNo,taskType,taskSeq,status,creator,createDate,modifier,modifyDate";
	private final String _ORDER_FIELDS = "TASK_ID,TASK_NAME,TASK_DESC,TASK_NO,TASK_TYPE,TASK_SEQ,STATUS,CREATOR,CREATE_DATE,MODIFIER,MODIFY_DATE";

	@Autowired
	public void setAppFlowDao(AppFlowDao appFlowDao) {
		this.appFlowDao = appFlowDao;
	}

	@Override
	public PageList<MlApproveTaskCfg> getAppFlowList(Page page,
			MlApproveTaskCfg appTask) {
		MlApproveTaskCfgExample example = new MlApproveTaskCfgExample();
		MlApproveTaskCfgExample.Criteria criteria = example.createCriteria();
		String taskName = appTask.getTaskName();
		String taskDesc = appTask.getTaskDesc();
		if (taskName != null && !"".equals(taskName)) {
			criteria.andTaskNameLike("%" + taskName + "%");
		}
		if (taskDesc != null && !"".equals(taskDesc)) {
			criteria.andTaskDescLike("%" + taskDesc + "%");
		}
		String order = SysUtil.dealOrderby(page, _ORDER_ATTRS, _ORDER_FIELDS);
		if (!order.equals("")) {
			example.setOrderByClause(order);
		}
		return this.appFlowDao.findPage(SysUtil.convertPage(page), example);
	}

	@Override
	public MlApproveTaskCfg queryAppFlowById(MlApproveTaskCfg appTask) {
		return (MlApproveTaskCfg) this.appFlowDao.getById(appTask.getTaskId());
	}

	@Override
	public int createAppFlow(MlApproveTaskCfg appTask) {
		appTask.setTaskId(KeyGenerator.getNextKey("ML_APPROVE_TASK_CFG", "TASK_ID"));
		return this.appFlowDao.save(appTask);
	}

	@Override
	public int updateAppFlow(MlApproveTaskCfg appTask) {
		return this.appFlowDao.updateSelective(appTask);
	}

	@Override
	public int deleteAppFlow(String ids) {
		String[] id = ids.split(",");
		List idlist = new ArrayList();
		for (int i = 0; i < id.length; i++) {
			idlist.add(id[i]);
		}

		MlApproveTaskCfgExample example = new MlApproveTaskCfgExample();
		example.createCriteria().andTaskIdIn(idlist);
		return this.appFlowDao.deleteByExample(example);
	}

}
