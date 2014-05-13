package com.wealth.miniloan.strategy;

import org.springframework.stereotype.Repository;

import com.wealth.miniloan.entity.Strategy;

/**
 * 解析策略信息
 * 
 * @author 春国
 *
 */
@Repository
public class ParseStrategy {
	private Strategy strategy = null;

	public Strategy getStrategy() {
		return strategy;
	}

	/**
	 * 加载策略信息
	 */
	public void loadStrategy() {
		this.strategy = new Strategy();
		String contentStr = "System.out.println(\"the first test of dynamic execute.\");";
		contentStr+="return true;";
		strategy.setContent(contentStr);
	}

}
