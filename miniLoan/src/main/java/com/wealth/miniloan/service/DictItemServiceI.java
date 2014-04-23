package com.wealth.miniloan.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.wealth.miniloan.entity.MlDictItem;
import com.wealth.miniloan.entity.Page;

public abstract interface DictItemServiceI
{
  public abstract PageList<MlDictItem> getDictItemList(Page paramPage, MlDictItem paramMlDictItem);

  public abstract int creatDictItem(MlDictItem paramMlDictItem);

  public abstract int deleteItem(String paramString);

  public abstract int updateItem(MlDictItem paramMlDictItem);

  public abstract MlDictItem getDictItemById(MlDictItem paramMlDictItem);
}