package com.wealth.miniloan.dao;

import org.springframework.stereotype.Repository;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.AppSummaryExtend;
import com.wealth.miniloan.entity.MlAppSummary;
import com.wealth.miniloan.entity.MlAppSummaryExample;
import com.wealth.miniloan.utils.orm.mybatis.BaseMybatisDao;
import com.wealth.miniloan.utils.orm.mybatis.MybatisPageQueryUtils;

@Repository
public class AppSummaryDao  extends BaseMybatisDao<MlAppSummary, String>{
	@Override
	public String getNamespace() {
		return MlAppSummaryMapper.class.getCanonicalName();
	}
	
	@SuppressWarnings("unchecked")
	public  PageList<AppSummaryExtend> getPageList(PageBounds pb, MlAppSummaryExample example){
		return (PageList<AppSummaryExtend>) MybatisPageQueryUtils.pageQuery(getSqlSession(), getNamespace() + ".selectByExampleExtend", getNamespace() + ".countByExampleExtend", example, pb);

	}

}
