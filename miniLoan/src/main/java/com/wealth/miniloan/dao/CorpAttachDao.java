package com.wealth.miniloan.dao;

import org.springframework.stereotype.Repository;
import com.wealth.miniloan.entity.MlCorpAttach;
import com.wealth.miniloan.utils.orm.mybatis.BaseMybatisDao;

@Repository
public class CorpAttachDao  extends BaseMybatisDao<MlCorpAttach, Long>{
	@Override
	public String getNamespace() {
		return MlCorpAttachMapper.class.getCanonicalName();
	}

}
