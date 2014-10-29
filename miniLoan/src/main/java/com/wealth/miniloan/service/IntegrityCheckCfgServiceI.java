package com.wealth.miniloan.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.MlInteCheckItem;
import com.wealth.miniloan.entity.Page;

public interface IntegrityCheckCfgServiceI {
	public abstract PageList<MlInteCheckItem> getPageList(Page paramPage, MlInteCheckItem inteCheckItem);
	public abstract MlInteCheckItem queryIntegrityCheckItemById(MlInteCheckItem inteCheckItem);
	public abstract int createIntegrityCheckItem(MlInteCheckItem inteCheckItem);
	public abstract int updateIntegrityCheckItem(MlInteCheckItem inteCheckItem);
	public abstract int deleteIntegrityCheckItem(String ids);
}
