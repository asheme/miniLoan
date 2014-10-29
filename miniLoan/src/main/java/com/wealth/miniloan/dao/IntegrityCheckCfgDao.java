package com.wealth.miniloan.dao;

import org.springframework.stereotype.Repository;

import com.wealth.miniloan.entity.MlInteCheckItem;
import com.wealth.miniloan.utils.orm.mybatis.BaseMybatisDao;

@Repository
public class IntegrityCheckCfgDao  extends BaseMybatisDao<MlInteCheckItem, Long>{

	@Override
	public String getNamespace() {
		return MlInteCheckItemMapper.class.getCanonicalName();
	}

}
