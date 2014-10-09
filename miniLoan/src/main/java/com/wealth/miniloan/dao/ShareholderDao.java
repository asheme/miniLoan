package com.wealth.miniloan.dao;

import org.springframework.stereotype.Repository;
import com.wealth.miniloan.entity.MlShareholder;
import com.wealth.miniloan.utils.orm.mybatis.BaseMybatisDao;

@Repository
public class ShareholderDao  extends BaseMybatisDao<MlShareholder, Long>{
	@Override
	public String getNamespace() {
		return MlShareholderMapper.class.getCanonicalName();
	}

}
