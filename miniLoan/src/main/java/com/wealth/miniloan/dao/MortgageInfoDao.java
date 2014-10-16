package com.wealth.miniloan.dao;

import org.springframework.stereotype.Repository;

import com.wealth.miniloan.entity.MlMortgageInfo;
import com.wealth.miniloan.utils.orm.mybatis.BaseMybatisDao;

@Repository
public class MortgageInfoDao  extends BaseMybatisDao<MlMortgageInfo, Long>{
	@Override
	public String getNamespace() {
		return MlMortgageInfoMapper.class.getCanonicalName();
	}

}
