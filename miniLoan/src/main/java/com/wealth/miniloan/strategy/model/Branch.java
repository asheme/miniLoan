package com.wealth.miniloan.strategy.model;

import java.util.List;

public class Branch {
	private String id;
	private String var;
	private String scope;
	private String loper;
	private String roper;
	private String type;
	private String isLeaf;
	private String parentId;
	private List<Result> resultList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getLoper() {
		return loper;
	}

	public void setLoper(String loper) {
		this.loper = loper;
	}

	public String getRoper() {
		return roper;
	}

	public void setRoper(String roper) {
		this.roper = roper;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIsLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(String isLeaf) {
		this.isLeaf = isLeaf;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public List<Result> getResultList() {
		return resultList;
	}

	public void setResultList(List<Result> resultList) {
		this.resultList = resultList;
	}

}
