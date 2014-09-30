package com.wealth.miniloan.dao;

import org.springframework.stereotype.Repository;

import com.wealth.miniloan.entity.MlNaturalApp;
import com.wealth.miniloan.entity.MlNaturalAttach;
import com.wealth.miniloan.entity.MlNaturalCredit;
import com.wealth.miniloan.utils.orm.mybatis.BaseMybatisDao;

@Repository
public class NaturalAttachDao  extends BaseMybatisDao<MlNaturalAttach, String>{
	@Override
	public String getNamespace() {
		return MlNaturalAttachMapper.class.getCanonicalName();
	}

}
