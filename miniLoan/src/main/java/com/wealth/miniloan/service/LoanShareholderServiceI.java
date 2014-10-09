package com.wealth.miniloan.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.MlShareholder;
import com.wealth.miniloan.entity.Page;

public interface LoanShareholderServiceI {
	public PageList<MlShareholder> getShareholderPageList(Page paramPage, MlShareholder ShareholderApp);

	public abstract int createShareholderApp(MlShareholder paramMlShareholder);

	public abstract int updateShareholderApp(MlShareholder paramMlShareholder);

	public abstract MlShareholder getShareholderByPriKey(MlShareholder paramMlShareholderApp);

}
