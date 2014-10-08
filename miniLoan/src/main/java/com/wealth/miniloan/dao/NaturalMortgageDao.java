package com.wealth.miniloan.dao;

import org.springframework.stereotype.Repository;
import com.wealth.miniloan.entity.MlNaturalMortgage;
import com.wealth.miniloan.utils.orm.mybatis.BaseMybatisDao;

@Repository
public class NaturalMortgageDao  extends BaseMybatisDao<MlNaturalMortgage, Long>{
	@Override
	public String getNamespace() {
		return MlNaturalMortgageMapper.class.getCanonicalName();
	}

}
