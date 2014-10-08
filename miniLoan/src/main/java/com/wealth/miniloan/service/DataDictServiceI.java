package com.wealth.miniloan.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.DataDictionary;
import com.wealth.miniloan.entity.MlDict;
import com.wealth.miniloan.entity.Page;

public abstract interface DataDictServiceI {
	public abstract PageList<MlDict> getDictList(Page paramPage, MlDict paramMlDict);

	public abstract int createDict(MlDict paramMlDict);

	public abstract int updateDict(MlDict paramMlDict);

	public abstract MlDict queryDictById(MlDict paramMlDict);

	public abstract int deleteDict(String paramString);

	public abstract DataDictionary getDictItemsByDictName(String paramString);
}