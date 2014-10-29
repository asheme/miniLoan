package com.wealth.miniloan.serviceImpl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wealth.miniloan.dao.AppStrategyResultDao;
import com.wealth.miniloan.dao.FraudCheckResultDao;
import com.wealth.miniloan.dao.MortgageInfoDao;
import com.wealth.miniloan.dao.NaturalAppDao;
import com.wealth.miniloan.dao.NaturalCreditDao;
import com.wealth.miniloan.dao.SysDecisionExcludeDao;
import com.wealth.miniloan.entity.MlAppStrategyResult;
import com.wealth.miniloan.entity.MlAppStrategyResultExample;
import com.wealth.miniloan.entity.MlMortgageInfo;
import com.wealth.miniloan.entity.MlMortgageInfoExample;
import com.wealth.miniloan.entity.MlNaturalApp;
import com.wealth.miniloan.entity.MlNaturalCredit;
import com.wealth.miniloan.entity.MlSysDecisionExclude;
import com.wealth.miniloan.entity.MlSysDecisionExcludeExample;
import com.wealth.miniloan.entity.MlSysParam;
import com.wealth.miniloan.service.ParamServiceI;
import com.wealth.miniloan.service.StrategyServiceI;
import com.wealth.miniloan.strategy.StrategyExecute;
import com.wealth.miniloan.strategy.model.DecisionResult;
import com.wealth.miniloan.strategy.model.ExcludeInfo;
import com.wealth.miniloan.strategy.model.ScoreResult;
import com.wealth.miniloan.utils.Constant;

@Transactional(rollbackFor=Exception.class)
@Service(value = "strategyService")
public class StrategyServiceImpl implements StrategyServiceI {
	private NaturalAppDao naturalAppDao;
	private NaturalCreditDao naturalCreditDao;
	private MortgageInfoDao mortgageInfoDao;
	private AppStrategyResultDao appStrategyResultDao;
	private SysDecisionExcludeDao sysDecisionExcludeDao;
	private FraudCheckResultDao fraudCheckResultDao;
	private ParamServiceI paramService = null;
	private StrategyExecute strategyExecute = null;

	@Autowired
	public void setAppStrategyResultDao(
			AppStrategyResultDao appStrategyResultDao) {
		this.appStrategyResultDao = appStrategyResultDao;
	}

	@Autowired
	public void setSysDecisionExcludeDao(
			SysDecisionExcludeDao sysDecisionExcludeDao) {
		this.sysDecisionExcludeDao = sysDecisionExcludeDao;
	}

	@Autowired
	public void setFraudCheckResultDao(FraudCheckResultDao fraudCheckResultDao) {
		this.fraudCheckResultDao = fraudCheckResultDao;
	}

	@Autowired
	public void setNaturalAppDao(NaturalAppDao naturalAppDao) {
		this.naturalAppDao = naturalAppDao;
	}

	@Autowired
	public void setNaturalCreditDao(NaturalCreditDao naturalCreditDao) {
		this.naturalCreditDao = naturalCreditDao;
	}

	@Autowired
	public void setMortgageInfoDao(MortgageInfoDao mortgageInfoDao) {
		this.mortgageInfoDao = mortgageInfoDao;
	}

	@Autowired
	public void setParamService(ParamServiceI paramService) {
		this.paramService = paramService;
	}

	@Autowired
	public void setStrategyExecute(StrategyExecute strategyExecute) {
		this.strategyExecute = strategyExecute;
	}

	@Override
	public boolean generatorSysDecisionResult(String appNo, String appType) {
		MlAppStrategyResult strategyResult = new MlAppStrategyResult();
		strategyResult.setAppNo(appNo);

		if (Constant.APP_TYPE_NATURAL.equals(appType)) {
			// 查询策略输入信息
			MlNaturalApp naturalApp = this.naturalAppDao.getById(appNo);
			MlNaturalCredit naturalCredit = this.naturalCreditDao
					.getById(appNo);
			MlMortgageInfoExample mortgateExample = new MlMortgageInfoExample();
			mortgateExample.createCriteria().andAppNoEqualTo(appNo);
			List<MlMortgageInfo> mortgageList = this.mortgageInfoDao
					.findAll(mortgateExample);
			HashMap<String, String> paramMap = new HashMap<String, String>();
			paramMap.put("appNo", appNo);
			paramMap.put("appType", appType);
			List<String> fraudCheckSummaryResultList = this.fraudCheckResultDao
					.getFraudCheckSummaryResult(paramMap);

			// 加工输入变量
			HashMap inputMap = makeNaturalStrategyVariable(naturalApp,
					naturalCredit, mortgageList, fraudCheckSummaryResultList,
					strategyResult);
			Iterator<String> keySetIterator = inputMap.keySet().iterator();
			while (keySetIterator.hasNext()) {
				String key = keySetIterator.next();
				String value = (String)inputMap.get(key).toString();
				System.out.println("key:"+key+"|value:"+value);
			}
			

			// 执行策略
			DecisionResult decisionResult = new DecisionResult();
			this.strategyExecute.execute(inputMap, decisionResult);

			// 保存策略结果
			// 策略入组条件
			List<ExcludeInfo> treeExcludeList=decisionResult.getTreeExcludeList();
			// 策略结果
			HashMap resultMap = (HashMap) decisionResult.getResultMap();
			strategyResult
					.setSysDecResult(resultMap.get("isPassed").toString());
			strategyResult.setLoanLimit(BigDecimal.valueOf(Float
					.parseFloat(resultMap.get("loanLimit").toString())));
			strategyResult.setLoanRate(BigDecimal.valueOf(Float
					.parseFloat(resultMap.get("loanRate").toString())));
			strategyResult
					.setReasonCode(resultMap.get("reasonCode").toString());
			strategyResult
					.setReasonDesc(resultMap.get("reasonDesc").toString());
			HashMap scoreMap=(HashMap)decisionResult.getScoreResultMap();
			ScoreResult score1= (ScoreResult)scoreMap.get("score1");
			if(score1!=null){
				strategyResult.setScore((int)score1.getScore());
			}else{
				strategyResult.setScore(0);
			}

			MlSysDecisionExcludeExample excludeExample = new MlSysDecisionExcludeExample();
			excludeExample.createCriteria().andAppNoEqualTo(appNo);
			this.sysDecisionExcludeDao.deleteByExample(excludeExample);
			MlAppStrategyResultExample stgResultExample = new MlAppStrategyResultExample();
			stgResultExample.createCriteria().andAppNoEqualTo(appNo);
			this.appStrategyResultDao.deleteByExample(stgResultExample);
			this.appStrategyResultDao.save(strategyResult);
			if(treeExcludeList!=null && treeExcludeList.size()>0){
				ExcludeInfo excludeInfo=null;
				MlSysDecisionExclude sysDecisionExclude=null;
				for(int i=0;i<treeExcludeList.size();++i){
					excludeInfo=(ExcludeInfo)treeExcludeList.get(i);
					sysDecisionExclude=new MlSysDecisionExclude();
					sysDecisionExclude.setAppNo(appNo);
					sysDecisionExclude.setExcludeId(Long.valueOf(i+1));
					sysDecisionExclude.setAttrName(excludeInfo.getVariable());
					sysDecisionExclude.setAttrValue(excludeInfo.getValue());
					sysDecisionExclude.setReasonCode(excludeInfo.getReasonCode());
					sysDecisionExclude.setReasonDesc(excludeInfo.getReason());
					this.sysDecisionExcludeDao.save(sysDecisionExclude);
				}
			}
		} else {

		}

		return false;
	}

	/**
	 * 生成策略执行的变量
	 * 
	 * @param appNo
	 * @param appType
	 */
	private HashMap makeNaturalStrategyVariable(MlNaturalApp naturalApp,
			MlNaturalCredit naturalCredit, List<MlMortgageInfo> mortgageList,
			List<String> fraudCheckSummaryResultList,
			MlAppStrategyResult strategyResult) {
		HashMap inputMap = new HashMap();
		String fraudCheckResult = "N";
		String baseCheckResult = "N";
		String relevanceCheckResult = "N";
		String crossCheckResult = "N";

		if (fraudCheckSummaryResultList != null
				&& fraudCheckSummaryResultList.size() > 0) {
			String tmpFraudCheckType = null;
			for (int i = 0; i < fraudCheckSummaryResultList.size(); ++i) {
				tmpFraudCheckType = fraudCheckSummaryResultList.get(i)
						.toString();
				if (Constant.FRAUD_CHECK_ITEM_TYPE_BASIC
						.equals(tmpFraudCheckType)) {
					baseCheckResult = "Y";
				}
				if (Constant.FRAUD_CHECK_ITEM_TYPE_FRAUD
						.equals(tmpFraudCheckType)) {
					fraudCheckResult = "Y";
				}
				if (Constant.FRAUD_CHECK_ITEM_TYPE_RELEVANCE
						.equals(tmpFraudCheckType)) {
					relevanceCheckResult = "Y";
				}
				if (Constant.FRAUD_CHECK_ITEM_TYPE_CROSS
						.equals(tmpFraudCheckType)) {
					crossCheckResult = "Y";
				}
			}
		}
		inputMap.put("fraudCheckResult", fraudCheckResult);
		inputMap.put("baseCheckResult", baseCheckResult);
		inputMap.put("relevanceCheckResult", relevanceCheckResult);
		inputMap.put("crossCheckResult", crossCheckResult);
		strategyResult.setFraudCheckResult(fraudCheckResult);
		strategyResult.setBaseCheckResult(baseCheckResult);
		strategyResult.setRelevanceCheckResult(relevanceCheckResult);
		strategyResult.setCrossCheckResult(crossCheckResult);

		float loanAppAmount = naturalApp.getLoanAmount()==null?0F:naturalApp.getLoanAmount().floatValue();
		inputMap.put("loanAppAmount", loanAppAmount);
		strategyResult.setLoanAppAmount(naturalApp.getLoanAmount());

		// 基本利率
		MlSysParam param = this.paramService.getParamByCode("BASE_LOAN_RATIO");
		inputMap.put("baseLoanRate", Float.parseFloat(param.getParamVal()));
		strategyResult.setBaseLoanRate(BigDecimal.valueOf(Float
				.parseFloat(param.getParamVal())));

		// 是否有征信信息，需调整数据库字段
		if ("Y".equals(naturalCredit.getHasCreditInfo())) {
			inputMap.put("hasCreditInfo", "Y");
			strategyResult.setHasCreditInfo("Y");
			inputMap.put("pastDueTimes", naturalCredit.getPastDueTimes()==null?0:naturalCredit.getPastDueTimes());
			inputMap.put("highestDelinquencyCycle",
					naturalCredit.getHighestDelinquencyCycle()==null?0:naturalCredit.getHighestDelinquencyCycle());
			inputMap.put("amountOfDelinquency",
					naturalCredit.getAmountOfDelinquency()==null?0:naturalCredit.getAmountOfDelinquency());
			strategyResult
					.setPastDueTimes(naturalCredit.getPastDueTimes()==null?0:naturalCredit.getPastDueTimes());
			strategyResult.setHighestDelinquencyCycle(naturalCredit.getHighestDelinquencyCycle()==null?0:naturalCredit.getHighestDelinquencyCycle());
			strategyResult.setAmountOfDelinquency(naturalCredit.getAmountOfDelinquency()==null?BigDecimal.valueOf(0):naturalCredit.getAmountOfDelinquency());
		} else {
			inputMap.put("hasCreditInfo", "N");
			inputMap.put("pastDueTimes", 0F);
			inputMap.put("highestDelinquencyCycle", 0F);
			inputMap.put("amountOfDelinquency", 0F);
			strategyResult.setHasCreditInfo("N");
			strategyResult.setPastDueTimes(0);
			strategyResult.setHighestDelinquencyCycle(0);
			strategyResult.setAmountOfDelinquency(BigDecimal.valueOf(0));
		}

		inputMap.put("age", naturalApp.getAge()==null?0:naturalApp.getAge());
		inputMap.put("marriageStatus", naturalApp.getMarriageStatus()==null?"":naturalApp.getMarriageStatus());
		inputMap.put("eduLvl", naturalApp.getEducationLvl()==null?"":naturalApp.getEducationLvl());
		inputMap.put("workYears", naturalApp.getWorkYears()==null?0:naturalApp.getWorkYears());
		float monthlyIncome = naturalApp.getMonthIncome()==null?0F:naturalApp.getMonthIncome().floatValue();
		inputMap.put("annualIncome", monthlyIncome * 12);
		strategyResult.setAge(BigDecimal.valueOf(naturalApp.getAge()==null?0:naturalApp.getAge()));
		strategyResult.setMarriageStatus(naturalApp.getMarriageStatus()==null?"":naturalApp.getMarriageStatus());
		strategyResult.setEduLvl(naturalApp.getEducationLvl()==null?"":naturalApp.getEducationLvl());
		strategyResult.setWorkYears(naturalApp.getWorkYears()==null?BigDecimal.valueOf(0):naturalApp.getWorkYears());
		strategyResult.setAnnualIncome(BigDecimal.valueOf(monthlyIncome * 12));

		float mortgageValue = 0F;
		float mortRatioOfLoan = 0F;
		if (mortgageList != null && mortgageList.size() > 0) {
			MlMortgageInfo mortgageInfo = null;
			for (int i = 0; i < mortgageList.size(); ++i) {
				mortgageInfo = (MlMortgageInfo) mortgageList.get(i);
				mortgageValue += (mortgageInfo.getCurrValue()==null?0F:mortgageInfo.getCurrValue().floatValue());
			}
		}
		if (mortgageValue == 0F || loanAppAmount == 0F) {
			mortRatioOfLoan = 0F;
		} else {
			if (loanAppAmount == 0F) {
				mortRatioOfLoan = 0F;
			} else {
				mortRatioOfLoan = mortgageValue / loanAppAmount;
			}
		}
		inputMap.put("mortRatioOfLoan", mortRatioOfLoan);
		strategyResult.setMortRatioOfLoan(BigDecimal.valueOf(mortRatioOfLoan));

		return inputMap;
	}

	@Override
	public MlAppStrategyResult getStrategyResultByPrikey(String appNo) {
		MlAppStrategyResultExample example = new MlAppStrategyResultExample();
		example.createCriteria().andAppNoEqualTo(appNo);
		return this.appStrategyResultDao.findOne(example);
	}

	@Override
	public List<MlSysDecisionExclude> getSysDecisionExcludeList(String appNo) {
		MlSysDecisionExcludeExample example = new MlSysDecisionExcludeExample();
		example.createCriteria().andAppNoEqualTo(appNo);
		return this.sysDecisionExcludeDao.findAll(example);
	}

}
