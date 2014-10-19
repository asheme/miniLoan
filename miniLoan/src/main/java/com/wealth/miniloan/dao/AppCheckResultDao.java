package com.wealth.miniloan.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wealth.miniloan.entity.MlAppCheckResult;
import com.wealth.miniloan.entity.MlSysResc;
import com.wealth.miniloan.utils.orm.mybatis.BaseMybatisDao;

@Repository
public class AppCheckResultDao  extends BaseMybatisDao<MlAppCheckResult, Long>{
	@Override
	public String getNamespace() {
		return MlAppCheckResultMapper.class.getCanonicalName();
	}

	/**
	 *  更新最近一条check result的状态信息
	 * 
	 * @param roleId
	 * @return
	 */
	public int updateByLastStatus(MlAppCheckResult appCheckResult) {
		return getSqlSession().update(
				getMybatisMapperNamesapce() + ".updateByLastStatus", appCheckResult);
	}
}
