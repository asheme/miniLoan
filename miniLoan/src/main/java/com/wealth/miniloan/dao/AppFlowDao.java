package com.wealth.miniloan.dao;


import org.springframework.stereotype.Repository;

import com.wealth.miniloan.entity.MlApproveTaskCfg;
import com.wealth.miniloan.utils.orm.mybatis.BaseMybatisDao;

@Repository
public class AppFlowDao extends BaseMybatisDao<MlApproveTaskCfg, Long> {

	@Override
	public String getNamespace() {
		return MlApproveTaskCfgMapper.class.getCanonicalName();
	}

	/**
	 * 查询下一步骤信息
	 * @param currStep
	 * @return
	 */
	public MlApproveTaskCfg getNextStep(String currStep) {
		return getSqlSession().selectOne(
				getMybatisMapperNamesapce() + ".getNextStep", currStep);
	}
}
