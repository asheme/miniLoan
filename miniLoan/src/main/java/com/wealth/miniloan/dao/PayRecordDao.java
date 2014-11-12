package com.wealth.miniloan.dao;


import org.springframework.stereotype.Repository;

import com.wealth.miniloan.entity.MlPayRecord;
import com.wealth.miniloan.utils.orm.mybatis.BaseMybatisDao;

@Repository
public class PayRecordDao extends BaseMybatisDao<MlPayRecord, Long> {

	@Override
	public String getNamespace() {
		return MlPayRecordMapper.class.getCanonicalName();
	}

}
