package com.wealth.miniloan.dao;

import org.springframework.stereotype.Repository;

import com.wealth.miniloan.entity.MlApproveTaskCfg;
import com.wealth.miniloan.entity.MlDict;
import com.wealth.miniloan.utils.orm.mybatis.BaseMybatisDao;

@Repository
public class AppFlowDao extends BaseMybatisDao<MlApproveTaskCfg, Long> {

	@Override
	public String getNamespace() {
		return MlApproveTaskCfgMapper.class.getCanonicalName();
	}

}
