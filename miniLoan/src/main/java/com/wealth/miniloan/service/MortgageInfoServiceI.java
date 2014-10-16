package com.wealth.miniloan.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.MlMortgageInfo;
import com.wealth.miniloan.entity.Page;

public interface MortgageInfoServiceI {
	public PageList<MlMortgageInfo> getNaturalMortgagePageList(Page paramPage, MlMortgageInfo mortgageInfo);

	public abstract int createNaturalMortgageApp(MlMortgageInfo mortgageInfo);

	public abstract int updateNaturalMortgageApp(MlMortgageInfo mortgageInfo);

	public abstract MlMortgageInfo getNaturalMortgageByPriKey(MlMortgageInfo mortgageInfo);

}
