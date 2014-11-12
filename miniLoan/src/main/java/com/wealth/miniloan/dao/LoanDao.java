package com.wealth.miniloan.dao;

import org.springframework.stereotype.Repository;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.MlLoanInfo;
import com.wealth.miniloan.entity.UnionLoanExample;
import com.wealth.miniloan.entity.UnionLoanInfo;
import com.wealth.miniloan.utils.orm.mybatis.BaseMybatisDao;
import com.wealth.miniloan.utils.orm.mybatis.MybatisPageQueryUtils;

@Repository
public class LoanDao extends BaseMybatisDao<MlLoanInfo, Long> {

	@Override
	public String getNamespace() {
		return MlLoanInfoMapper.class.getCanonicalName();
	}
	
	@SuppressWarnings("unchecked")
	public  PageList<UnionLoanInfo> getLoanPageList(PageBounds pb, UnionLoanExample unionLoanExample){
		return (PageList<UnionLoanInfo>) MybatisPageQueryUtils.pageQuery(getSqlSession(), getNamespace() + ".queryLoanPageList", getNamespace() + ".countUnionLoan", unionLoanExample, pb);

	}
}
