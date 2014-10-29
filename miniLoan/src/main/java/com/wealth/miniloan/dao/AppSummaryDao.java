package com.wealth.miniloan.dao;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.AppSummaryExtend;
import com.wealth.miniloan.entity.CorpAppExample;
import com.wealth.miniloan.entity.CorpAppInfo;
import com.wealth.miniloan.entity.MlAppSummary;
import com.wealth.miniloan.entity.MlAppSummaryExample;
import com.wealth.miniloan.entity.NaturalAppExample;
import com.wealth.miniloan.entity.NaturalAppInfo;
import com.wealth.miniloan.entity.UnionAppExample;
import com.wealth.miniloan.entity.UnionLoanApp;
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
	
	@SuppressWarnings("unchecked")
	public  PageList<AppSummaryExtend> getNaturalAppPageList(PageBounds pb, HashMap<String, String> map){
		return (PageList<AppSummaryExtend>) MybatisPageQueryUtils.pageQuery(getSqlSession(), getNamespace() + ".selectNaturalAppByMapExtend", getNamespace() + ".countNaturalAppByMapExtend", map, pb);

	}
	
	@SuppressWarnings("unchecked")
	public  PageList<AppSummaryExtend> getCorpAppPageList(PageBounds pb, HashMap<String, String> map){
		return (PageList<AppSummaryExtend>) MybatisPageQueryUtils.pageQuery(getSqlSession(), getNamespace() + ".selectCorpAppByMapExtend", getNamespace() + ".countCorpAppByMapExtend", map, pb);

	}
	
	@SuppressWarnings("unchecked")
	public  PageList<AppSummaryExtend> getPageList(PageBounds pb, HashMap<String, String> map){
		return (PageList<AppSummaryExtend>) MybatisPageQueryUtils.pageQuery(getSqlSession(), getNamespace() + ".selectByMapExtend", getNamespace() + ".countByMapExtend", map, pb);

	}
	
	@SuppressWarnings("unchecked")
	public  PageList<UnionLoanApp> queryLoanAppPageList(PageBounds pb, UnionAppExample unionAppExample){
		return (PageList<UnionLoanApp>) MybatisPageQueryUtils.pageQuery(getSqlSession(), getNamespace() + ".queryLoanAppPageList", getNamespace() + ".countUnionLoanApp", unionAppExample, pb);

	}
	
	@SuppressWarnings("unchecked")
	public  PageList<NaturalAppInfo> queryNatrualAppPageList(PageBounds pb, NaturalAppExample naturalAppExample){
		return (PageList<NaturalAppInfo>) MybatisPageQueryUtils.pageQuery(getSqlSession(), getNamespace() + ".queryNatrualAppPageList", getNamespace() + ".countNatrualApp", naturalAppExample, pb);

	}
	
	@SuppressWarnings("unchecked")
	public  PageList<CorpAppInfo> queryCorpAppPageList(PageBounds pb, CorpAppExample corpAppExample){
		return (PageList<CorpAppInfo>) MybatisPageQueryUtils.pageQuery(getSqlSession(), getNamespace() + ".queryCorpAppPageList", getNamespace() + ".countCorpApp", corpAppExample, pb);

	}
}
