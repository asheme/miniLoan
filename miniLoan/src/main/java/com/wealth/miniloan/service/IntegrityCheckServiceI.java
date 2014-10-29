package com.wealth.miniloan.service;

import java.util.List;

import com.wealth.miniloan.entity.InteCheckExtend;

public interface IntegrityCheckServiceI {
	public abstract List<InteCheckExtend> getIntegrityCheckList(String appNo,String appType);
	public abstract boolean saveIntegrityCheck(String appNo,String appType,String inteCheckStr);
}
