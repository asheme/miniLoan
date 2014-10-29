package com.wealth.miniloan.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wealth.miniloan.entity.InteCheckExtend;
import com.wealth.miniloan.entity.MlInteCheckInfo;
import com.wealth.miniloan.utils.orm.mybatis.BaseMybatisDao;

@Repository
public class IntegrityCheckDao  extends BaseMybatisDao<MlInteCheckInfo, Long>{
	@Override
	public String getNamespace() {
		return MlInteCheckInfoMapper.class.getCanonicalName();
	}
	
	/**
	 * 查询完整性检查情况信息
	 * @param appNo
	 * @return
	 */
	public List<InteCheckExtend> getIntegrityCheckList(String appNo) {
		return getSqlSession().selectList(
				getMybatisMapperNamesapce() + ".getIntegrityCheckList", appNo);
	}
}
