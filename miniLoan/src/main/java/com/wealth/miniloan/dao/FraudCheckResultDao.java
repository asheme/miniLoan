package com.wealth.miniloan.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.wealth.miniloan.entity.MlFraudCheckResult;
import com.wealth.miniloan.utils.orm.mybatis.BaseMybatisDao;

@Repository
public class FraudCheckResultDao  extends BaseMybatisDao<MlFraudCheckResult, Long>{
	@Override
	public String getNamespace() {
		return MlFraudCheckResultMapper.class.getCanonicalName();
	}

	public List<String> getFraudCheckSummaryResult(HashMap<String,String> paramMap){
		return getSqlSession().selectList(
				getMybatisMapperNamesapce() + ".getFraudCheckSummaryResult", paramMap);
	}
}
