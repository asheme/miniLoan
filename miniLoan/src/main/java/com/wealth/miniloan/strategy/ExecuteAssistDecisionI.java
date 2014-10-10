package com.wealth.miniloan.strategy;

import java.util.HashMap;
import java.util.List;

import com.wealth.miniloan.strategy.model.DecisionResult;

public interface ExecuteAssistDecisionI {
	public void execute(HashMap inputMap, DecisionResult decisionResult);
}
