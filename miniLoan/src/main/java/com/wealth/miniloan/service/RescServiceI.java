package com.wealth.miniloan.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.MlSysResc;
import com.wealth.miniloan.entity.Page;
import java.util.List;

public abstract interface RescServiceI
{
  public abstract PageList<MlSysResc> getRescPageList(Page paramPage);

  public abstract List<MlSysResc> getParentRescList();

  public abstract int createResc(MlSysResc paramMlSysResc);

  public abstract int updateResc(MlSysResc paramMlSysResc);

  public abstract MlSysResc getRescById(MlSysResc paramMlSysResc);

  public abstract int deleteRescByKeys(String paramString);
}