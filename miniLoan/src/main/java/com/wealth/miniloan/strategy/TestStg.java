package com.wealth.miniloan.strategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wealth.miniloan.strategy.model.DecisionResult;
import com.wealth.miniloan.strategy.model.ExcludeInfo;
import com.wealth.miniloan.strategy.model.ScoreResult;

public class TestStg implements ExecuteAssistDecisionI {

	@Override
	public void execute(HashMap inputMap, DecisionResult decisionResult) {
		float age = Float.parseFloat(inputMap.get("age").toString());
		float annIncome = (float) inputMap.get("annIncome");
		String eduLvl = (String) inputMap.get("eduLvl");
		String isHighPosition = (String) inputMap.get("isHighPosition");
		float mortageValue = (float) inputMap.get("mortageValue");
		String isPassed = "N";
		float loanLimit = 0F;
		float loanRate = 0F;
		String reasonCode = null;
		String reason = null;
		List scoreExcludes = null;
		List treeExcludes = null;
		Map scoreMap = null;
		Map resultMap = null;
		ExcludeInfo exclude = null;
		ScoreResult scoreResult = null;
		scoreMap = new HashMap();
		float score1 = 0F;
		scoreExcludes = new ArrayList();
		if (age < 18) {
			exclude = new ExcludeInfo();
			exclude.setVariable("age");
			exclude.setValue(String.valueOf(age));
			exclude.setReasonCode("s0001");
			exclude.setReason("年龄不满足18岁");
			scoreExcludes.add(exclude);
		}
		if (annIncome <= 50000) {
			score1 += 1 * 10;
		} else if (annIncome > 50000 && annIncome <= 100000) {
			score1 += 1 * 40;
		} else if (annIncome > 100000) {
			score1 += 1 * 60;
		}
		if (annIncome <= 50000) {
			score1 += 1 * 10;
		} else if (annIncome > 50000 && annIncome <= 100000) {
			score1 += 1 * 40;
		} else if (annIncome > 100000) {
			score1 += 1 * 60;
		}
		if (isHighPosition.equals("Y")) {
			score1 += 1 * 30;
		} else {
			score1 += 1 * 10;
		}
		if (score1 < 10)
			score1 = 10;
		if (score1 > 100)
			score1 = 100;
		scoreResult = new ScoreResult();
		scoreResult.setName("score1");
		scoreResult.setScore(score1);
		scoreResult.setExcludes(scoreExcludes);
		scoreMap.put("score1", scoreResult);
		decisionResult.setScoreResultMap(scoreMap);
		treeExcludes = new ArrayList();
		if (age < 18) {
			exclude = new ExcludeInfo();
			exclude.setVariable("age");
			exclude.setValue(String.valueOf(age));
			exclude.setReasonCode("t0001");
			exclude.setReason("年龄不满足18岁");
			treeExcludes.add(exclude);
		}
		if (annIncome < 30000) {
			exclude = new ExcludeInfo();
			exclude.setVariable("annIncome");
			exclude.setValue(String.valueOf(annIncome));
			exclude.setReasonCode("t0002");
			exclude.setReason("年收入过低");
			treeExcludes.add(exclude);
		}
		decisionResult.setTreeExcludeList(treeExcludes);
		if (age > 18 && age <= 35) {
			if (annIncome > 100000) {
				if (isHighPosition.equals("Y")) {
					isPassed = "Y";
					loanLimit = annIncome * (0.4F);
					loanRate = 0.1F;
					reasonCode = "R0001";
					reason = "年轻，收入较高，职称较高，通过审批";
				} else {
					isPassed = "Y";
					loanLimit = annIncome * (0.2F);
					loanRate = 0.1F;
					reasonCode = "R0002";
					reason = "年轻，收入较高，职称较低，通过审批";
				}
			} else {
				if (isHighPosition.equals("Y")) {
					isPassed = "Y";
					loanLimit = annIncome * (0.3F);
					loanRate = 0.15F;
					reasonCode = "R0003";
					reason = "年轻，收入较低，职称较高，通过审批";
				} else {
					isPassed = "N";
					loanLimit = 0F;
					loanRate = 0F;
					reasonCode = "R0004";
					reason = "年轻，收入较低，职称较低，拒绝";
				}
			}
		} else if (age > 35 && age <= 45) {
			if (annIncome > 100000) {
				if (isHighPosition.equals("Y")) {
					isPassed = "Y";
					loanLimit = annIncome * (0.4F);
					loanRate = 0.1F;
					reasonCode = "R0005";
					reason = "中年，收入较高，职称较高，通过审批";
				} else {
					isPassed = "Y";
					loanLimit = annIncome * (0.3F);
					loanRate = 0.15F;
					reasonCode = "R0006";
					reason = "中年，收入较高，职称较低，通过审批";
				}
			} else {
				if (isHighPosition.equals("Y")) {
					isPassed = "Y";
					loanLimit = annIncome * (0.4F);
					loanRate = 0.15F;
					reasonCode = "R0007";
					reason = "中年，收入较低，职称较高，通过审批";
				} else {
					isPassed = "N";
					loanLimit = 0F;
					loanRate = 0F;
					reasonCode = "R0008";
					reason = "中年，收入较低，职称较低，拒绝";
				}
			}
		} else if (age > 45) {
			if (annIncome > 100000) {
				if (isHighPosition.equals("Y")) {
					isPassed = "Y";
					loanLimit = annIncome * (0.3F);
					loanRate = 0.1F;
					reasonCode = "R0009";
					reason = "老年，收入较高，职称较高，通过审批";
				} else {
					isPassed = "Y";
					loanLimit = annIncome * (0.2F);
					loanRate = 0.2F;
					reasonCode = "R0010";
					reason = "老年，收入较高，职称较低，通过审批";
				}
			} else {
				if (isHighPosition.equals("Y")) {
					isPassed = "Y";
					loanLimit = annIncome * (0.2F);
					loanRate = 0.2F;
					reasonCode = "R00011";
					reason = "老年，收入较低，职称较高，通过审批";
				} else {
					isPassed = "N";
					loanLimit = 0F;
					loanRate = 0F;
					reasonCode = "R0012";
					reason = "老年，收入较低，职称较低，拒绝";
				}
			}
		}
		resultMap = new HashMap();
		resultMap.put("isPassed", isPassed);
		resultMap.put("loanLimit", Float.valueOf(loanLimit));
		resultMap.put("loanRate", Float.valueOf(loanRate));
		resultMap.put("reasonCode", reasonCode);
		resultMap.put("reason", reason);
		decisionResult.setResultMap(resultMap);
	}

}
