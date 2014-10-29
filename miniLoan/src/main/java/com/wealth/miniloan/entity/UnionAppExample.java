package com.wealth.miniloan.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wealth.miniloan.entity.MlAppSummaryExample.Criteria;

public class UnionAppExample {
	protected String orderByClause;
	protected boolean distinct;
	protected List<Criteria> oredCriteria;
	
	public UnionAppExample() {
		oredCriteria = new ArrayList<Criteria>();
	}
	
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}
	
	public String getOrderByClause() {
		return orderByClause;
	}
	
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}
	
	public boolean isDistinct() {
		return distinct;
	}
	
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}
	
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}
	
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}
	
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}
	
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}
	
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}
	
	protected abstract static class GeneratedCriteria {
		protected List<Criterion> criteria;

		protected GeneratedCriteria() {
			super();
			criteria = new ArrayList<Criterion>();
		}

		public boolean isValid() {
			return criteria.size() > 0;
		}

		public List<Criterion> getAllCriteria() {
			return criteria;
		}

		public List<Criterion> getCriteria() {
			return criteria;
		}

		protected void addCriterion(String condition) {
			if (condition == null) {
				throw new RuntimeException("Value for condition cannot be null");
			}
			criteria.add(new Criterion(condition));
		}

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		public Criteria andAppNoIsNull() {
			addCriterion("APP_NO is null");
			return (Criteria) this;
		}

		public Criteria andAppNoIsNotNull() {
			addCriterion("APP_NO is not null");
			return (Criteria) this;
		}

		public Criteria andAppNoEqualTo(String value) {
			addCriterion("APP_NO =", value, "appNo");
			return (Criteria) this;
		}

		public Criteria andAppNoNotEqualTo(String value) {
			addCriterion("APP_NO <>", value, "appNo");
			return (Criteria) this;
		}

		public Criteria andAppNoGreaterThan(String value) {
			addCriterion("APP_NO >", value, "appNo");
			return (Criteria) this;
		}

		public Criteria andAppNoGreaterThanOrEqualTo(String value) {
			addCriterion("APP_NO >=", value, "appNo");
			return (Criteria) this;
		}

		public Criteria andAppNoLessThan(String value) {
			addCriterion("APP_NO <", value, "appNo");
			return (Criteria) this;
		}

		public Criteria andAppNoLessThanOrEqualTo(String value) {
			addCriterion("APP_NO <=", value, "appNo");
			return (Criteria) this;
		}

		public Criteria andAppNoLike(String value) {
			addCriterion("APP_NO like", value, "appNo");
			return (Criteria) this;
		}

		public Criteria andAppNoNotLike(String value) {
			addCriterion("APP_NO not like", value, "appNo");
			return (Criteria) this;
		}

		public Criteria andAppNoIn(List<String> values) {
			addCriterion("APP_NO in", values, "appNo");
			return (Criteria) this;
		}

		public Criteria andAppNoNotIn(List<String> values) {
			addCriterion("APP_NO not in", values, "appNo");
			return (Criteria) this;
		}

		public Criteria andAppNoBetween(String value1, String value2) {
			addCriterion("APP_NO between", value1, value2, "appNo");
			return (Criteria) this;
		}

		public Criteria andAppNoNotBetween(String value1, String value2) {
			addCriterion("APP_NO not between", value1, value2, "appNo");
			return (Criteria) this;
		}

		public Criteria andAppTypeIsNull() {
			addCriterion("APP_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andAppTypeIsNotNull() {
			addCriterion("APP_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andAppTypeEqualTo(String value) {
			addCriterion("APP_TYPE =", value, "appType");
			return (Criteria) this;
		}

		public Criteria andAppTypeNotEqualTo(String value) {
			addCriterion("APP_TYPE <>", value, "appType");
			return (Criteria) this;
		}

		public Criteria andAppTypeGreaterThan(String value) {
			addCriterion("APP_TYPE >", value, "appType");
			return (Criteria) this;
		}

		public Criteria andAppTypeGreaterThanOrEqualTo(String value) {
			addCriterion("APP_TYPE >=", value, "appType");
			return (Criteria) this;
		}

		public Criteria andAppTypeLessThan(String value) {
			addCriterion("APP_TYPE <", value, "appType");
			return (Criteria) this;
		}

		public Criteria andAppTypeLessThanOrEqualTo(String value) {
			addCriterion("APP_TYPE <=", value, "appType");
			return (Criteria) this;
		}

		public Criteria andAppTypeLike(String value) {
			addCriterion("APP_TYPE like", value, "appType");
			return (Criteria) this;
		}

		public Criteria andAppTypeNotLike(String value) {
			addCriterion("APP_TYPE not like", value, "appType");
			return (Criteria) this;
		}

		public Criteria andAppTypeIn(List<String> values) {
			addCriterion("APP_TYPE in", values, "appType");
			return (Criteria) this;
		}

		public Criteria andAppTypeNotIn(List<String> values) {
			addCriterion("APP_TYPE not in", values, "appType");
			return (Criteria) this;
		}

		public Criteria andAppTypeBetween(String value1, String value2) {
			addCriterion("APP_TYPE between", value1, value2, "appType");
			return (Criteria) this;
		}

		public Criteria andAppTypeNotBetween(String value1, String value2) {
			addCriterion("APP_TYPE not between", value1, value2, "appType");
			return (Criteria) this;
		}
		
		public Criteria andNameIsNull() {
			addCriterion("NAME is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("NAME is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("NAME =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("NAME <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("NAME >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("NAME >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("NAME <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("NAME <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("NAME like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("NAME not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("NAME in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("NAME not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("NAME between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("NAME not between", value1, value2, "name");
			return (Criteria) this;
		}
		
		public Criteria andAddrIsNull() {
			addCriterion("ADDR is null");
			return (Criteria) this;
		}

		public Criteria andAddrIsNotNull() {
			addCriterion("ADDR is not null");
			return (Criteria) this;
		}

		public Criteria andAddrEqualTo(String value) {
			addCriterion("ADDR =", value, "addr");
			return (Criteria) this;
		}

		public Criteria andAddrNotEqualTo(String value) {
			addCriterion("ADDR <>", value, "addr");
			return (Criteria) this;
		}

		public Criteria andAddrGreaterThan(String value) {
			addCriterion("ADDR >", value, "addr");
			return (Criteria) this;
		}

		public Criteria andAddrGreaterThanOrEqualTo(String value) {
			addCriterion("ADDR >=", value, "addr");
			return (Criteria) this;
		}

		public Criteria andAddrLessThan(String value) {
			addCriterion("ADDR <", value, "addr");
			return (Criteria) this;
		}

		public Criteria andAddrLessThanOrEqualTo(String value) {
			addCriterion("ADDR <=", value, "addr");
			return (Criteria) this;
		}

		public Criteria andAddrLike(String value) {
			addCriterion("ADDR like", value, "addr");
			return (Criteria) this;
		}

		public Criteria andAddrNotLike(String value) {
			addCriterion("ADDR not like", value, "addr");
			return (Criteria) this;
		}

		public Criteria andAddrIn(List<String> values) {
			addCriterion("ADDR in", values, "addr");
			return (Criteria) this;
		}

		public Criteria andAddrNotIn(List<String> values) {
			addCriterion("ADDR not in", values, "addr");
			return (Criteria) this;
		}

		public Criteria andAddrBetween(String value1, String value2) {
			addCriterion("ADDR between", value1, value2, "addr");
			return (Criteria) this;
		}

		public Criteria andAddrNotBetween(String value1, String value2) {
			addCriterion("ADDR not between", value1, value2, "addr");
			return (Criteria) this;
		}
		
		public Criteria andLoanAppAmountIsNull() {
			addCriterion("LOAN_APP_AMOUNT is null");
			return (Criteria) this;
		}

		public Criteria andLoanAppAmountIsNotNull() {
			addCriterion("LOAN_APP_AMOUNT is not null");
			return (Criteria) this;
		}

		public Criteria andLoanAppAmountEqualTo(BigDecimal value) {
			addCriterion("LOAN_APP_AMOUNT =", value, "loanAppAmount");
			return (Criteria) this;
		}

		public Criteria andLoanAppAmountNotEqualTo(BigDecimal value) {
			addCriterion("LOAN_APP_AMOUNT <>", value, "loanAppAmount");
			return (Criteria) this;
		}

		public Criteria andLoanAppAmountGreaterThan(BigDecimal value) {
			addCriterion("LOAN_APP_AMOUNT >", value, "loanAppAmount");
			return (Criteria) this;
		}

		public Criteria andLoanAppAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("LOAN_APP_AMOUNT >=", value, "loanAppAmount");
			return (Criteria) this;
		}

		public Criteria andLoanAppAmountLessThan(BigDecimal value) {
			addCriterion("LOAN_APP_AMOUNT <", value, "loanAppAmount");
			return (Criteria) this;
		}

		public Criteria andLoanAppAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("LOAN_APP_AMOUNT <=", value, "loanAppAmount");
			return (Criteria) this;
		}

		public Criteria andLoanAppAmountIn(List<BigDecimal> values) {
			addCriterion("LOAN_APP_AMOUNT in", values, "loanAppAmount");
			return (Criteria) this;
		}

		public Criteria andLoanAppAmountNotIn(List<BigDecimal> values) {
			addCriterion("LOAN_APP_AMOUNT not in", values, "loanAppAmount");
			return (Criteria) this;
		}

		public Criteria andLoanAppAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LOAN_APP_AMOUNT between", value1, value2, "loanAppAmount");
			return (Criteria) this;
		}

		public Criteria andLoanAppAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LOAN_APP_AMOUNT not between", value1, value2, "loanAppAmount");
			return (Criteria) this;
		}
		
		public Criteria andStatusIsNull() {
			addCriterion("STATUS is null");
			return (Criteria) this;
		}

		public Criteria andStatusIsNotNull() {
			addCriterion("STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andStatusEqualTo(String value) {
			addCriterion("STATUS =", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotEqualTo(String value) {
			addCriterion("STATUS <>", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThan(String value) {
			addCriterion("STATUS >", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusGreaterThanOrEqualTo(String value) {
			addCriterion("STATUS >=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThan(String value) {
			addCriterion("STATUS <", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLessThanOrEqualTo(String value) {
			addCriterion("STATUS <=", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusLike(String value) {
			addCriterion("STATUS like", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotLike(String value) {
			addCriterion("STATUS not like", value, "status");
			return (Criteria) this;
		}

		public Criteria andStatusIn(List<String> values) {
			addCriterion("STATUS in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotIn(List<String> values) {
			addCriterion("STATUS not in", values, "status");
			return (Criteria) this;
		}

		public Criteria andStatusBetween(String value1, String value2) {
			addCriterion("STATUS between", value1, value2, "status");
			return (Criteria) this;
		}

		public Criteria andStatusNotBetween(String value1, String value2) {
			addCriterion("STATUS not between", value1, value2, "status");
			return (Criteria) this;
		}
		
		public Criteria andCurrApproveLvlIsNull() {
			addCriterion("CURR_APPROVE_LVL is null");
			return (Criteria) this;
		}

		public Criteria andCurrApproveLvlIsNotNull() {
			addCriterion("CURR_APPROVE_LVL is not null");
			return (Criteria) this;
		}

		public Criteria andCurrApproveLvlEqualTo(Integer value) {
			addCriterion("CURR_APPROVE_LVL =", value, "currApproveLvl");
			return (Criteria) this;
		}

		public Criteria andCurrApproveLvlNotEqualTo(Integer value) {
			addCriterion("CURR_APPROVE_LVL <>", value, "currApproveLvl");
			return (Criteria) this;
		}

		public Criteria andCurrApproveLvlGreaterThan(Integer value) {
			addCriterion("CURR_APPROVE_LVL >", value, "currApproveLvl");
			return (Criteria) this;
		}

		public Criteria andCurrApproveLvlGreaterThanOrEqualTo(Integer value) {
			addCriterion("CURR_APPROVE_LVL >=", value, "currApproveLvl");
			return (Criteria) this;
		}

		public Criteria andCurrApproveLvlLessThan(Integer value) {
			addCriterion("CURR_APPROVE_LVL <", value, "currApproveLvl");
			return (Criteria) this;
		}

		public Criteria andCurrApproveLvlLessThanOrEqualTo(Integer value) {
			addCriterion("CURR_APPROVE_LVL <=", value, "currApproveLvl");
			return (Criteria) this;
		}

		public Criteria andCurrApproveLvlIn(List<Integer> values) {
			addCriterion("CURR_APPROVE_LVL in", values, "currApproveLvl");
			return (Criteria) this;
		}

		public Criteria andCurrApproveLvlNotIn(List<Integer> values) {
			addCriterion("CURR_APPROVE_LVL not in", values, "currApproveLvl");
			return (Criteria) this;
		}

		public Criteria andCurrApproveLvlBetween(Integer value1, Integer value2) {
			addCriterion("CURR_APPROVE_LVL between", value1, value2,
					"currApproveLvl");
			return (Criteria) this;
		}

		public Criteria andCurrApproveLvlNotBetween(Integer value1,
				Integer value2) {
			addCriterion("CURR_APPROVE_LVL not between", value1, value2,
					"currApproveLvl");
			return (Criteria) this;
		}
		
		public Criteria andAppTimeIsNull() {
			addCriterion("APP_TIME is null");
			return (Criteria) this;
		}

		public Criteria andAppTimeIsNotNull() {
			addCriterion("APP_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andAppTimeEqualTo(Date value) {
			addCriterion("APP_TIME =", value, "appTime");
			return (Criteria) this;
		}

		public Criteria andAppTimeNotEqualTo(Date value) {
			addCriterion("APP_TIME <>", value, "appTime");
			return (Criteria) this;
		}

		public Criteria andAppTimeGreaterThan(Date value) {
			addCriterion("APP_TIME >", value, "appTime");
			return (Criteria) this;
		}

		public Criteria andAppTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("APP_TIME >=", value, "appTime");
			return (Criteria) this;
		}

		public Criteria andAppTimeLessThan(Date value) {
			addCriterion("APP_TIME <", value, "appTime");
			return (Criteria) this;
		}

		public Criteria andAppTimeLessThanOrEqualTo(Date value) {
			addCriterion("APP_TIME <=", value, "appTime");
			return (Criteria) this;
		}

		public Criteria andAppTimeIn(List<Date> values) {
			addCriterion("APP_TIME in", values, "appTime");
			return (Criteria) this;
		}

		public Criteria andAppTimeNotIn(List<Date> values) {
			addCriterion("APP_TIME not in", values, "appTime");
			return (Criteria) this;
		}

		public Criteria andAppTimeBetween(Date value1, Date value2) {
			addCriterion("APP_TIME between", value1, value2, "opTime");
			return (Criteria) this;
		}

		public Criteria andAppTimeNotBetween(Date value1, Date value2) {
			addCriterion("APP_TIME not between", value1, value2, "appTime");
			return (Criteria) this;
		}
		
		public Criteria andEnterTimeIsNull() {
			addCriterion("ENTER_TIME is null");
			return (Criteria) this;
		}

		public Criteria andEnterTimeIsNotNull() {
			addCriterion("ENTER_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andEnterTimeEqualTo(Date value) {
			addCriterion("ENTER_TIME =", value, "enterTime");
			return (Criteria) this;
		}

		public Criteria andEnterTimeNotEqualTo(Date value) {
			addCriterion("ENTER_TIME <>", value, "enterTime");
			return (Criteria) this;
		}

		public Criteria andEnterTimeGreaterThan(Date value) {
			addCriterion("ENTER_TIME >", value, "enterTime");
			return (Criteria) this;
		}

		public Criteria andEnterTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("ENTER_TIME >=", value, "enterTime");
			return (Criteria) this;
		}

		public Criteria andEnterTimeLessThan(Date value) {
			addCriterion("ENTER_TIME <", value, "enterTime");
			return (Criteria) this;
		}

		public Criteria andEnterTimeLessThanOrEqualTo(Date value) {
			addCriterion("ENTER_TIME <=", value, "enterTime");
			return (Criteria) this;
		}

		public Criteria andEnterTimeIn(List<Date> values) {
			addCriterion("ENTER_TIME in", values, "enterTime");
			return (Criteria) this;
		}

		public Criteria andEnterTimeNotIn(List<Date> values) {
			addCriterion("ENTER_TIME not in", values, "enterTime");
			return (Criteria) this;
		}

		public Criteria andEnterTimeBetween(Date value1, Date value2) {
			addCriterion("ENTER_TIME between", value1, value2, "enterTime");
			return (Criteria) this;
		}

		public Criteria andEnterTimeNotBetween(Date value1, Date value2) {
			addCriterion("ENTER_TIME not between", value1, value2, "enterTime");
			return (Criteria) this;
		}

		public Criteria andPreviousStepIsNull() {
			addCriterion("PREVIOUS_STEP is null");
			return (Criteria) this;
		}

		public Criteria andPreviousStepIsNotNull() {
			addCriterion("PREVIOUS_STEP is not null");
			return (Criteria) this;
		}

		public Criteria andPreviousStepEqualTo(String value) {
			addCriterion("PREVIOUS_STEP =", value, "previousStep");
			return (Criteria) this;
		}

		public Criteria andPreviousStepNotEqualTo(String value) {
			addCriterion("PREVIOUS_STEP <>", value, "previousStep");
			return (Criteria) this;
		}

		public Criteria andPreviousStepGreaterThan(String value) {
			addCriterion("PREVIOUS_STEP >", value, "previousStep");
			return (Criteria) this;
		}

		public Criteria andPreviousStepGreaterThanOrEqualTo(String value) {
			addCriterion("PREVIOUS_STEP >=", value, "previousStep");
			return (Criteria) this;
		}

		public Criteria andPreviousStepLessThan(String value) {
			addCriterion("PREVIOUS_STEP <", value, "previousStep");
			return (Criteria) this;
		}

		public Criteria andPreviousStepLessThanOrEqualTo(String value) {
			addCriterion("PREVIOUS_STEP <=", value, "previousStep");
			return (Criteria) this;
		}

		public Criteria andPreviousStepLike(String value) {
			addCriterion("PREVIOUS_STEP like", value, "previousStep");
			return (Criteria) this;
		}

		public Criteria andPreviousStepNotLike(String value) {
			addCriterion("PREVIOUS_STEP not like", value, "previousStep");
			return (Criteria) this;
		}

		public Criteria andPreviousStepIn(List<String> values) {
			addCriterion("PREVIOUS_STEP in", values, "previousStep");
			return (Criteria) this;
		}

		public Criteria andPreviousStepNotIn(List<String> values) {
			addCriterion("PREVIOUS_STEP not in", values, "previousStep");
			return (Criteria) this;
		}

		public Criteria andPreviousStepBetween(String value1, String value2) {
			addCriterion("PREVIOUS_STEP between", value1, value2,
					"previousStep");
			return (Criteria) this;
		}

		public Criteria andPreviousStepNotBetween(String value1, String value2) {
			addCriterion("PREVIOUS_STEP not between", value1, value2,
					"previousStep");
			return (Criteria) this;
		}

		public Criteria andCurrStepIsNull() {
			addCriterion("CURR_STEP is null");
			return (Criteria) this;
		}

		public Criteria andCurrStepIsNotNull() {
			addCriterion("CURR_STEP is not null");
			return (Criteria) this;
		}

		public Criteria andCurrStepEqualTo(String value) {
			addCriterion("CURR_STEP =", value, "currStep");
			return (Criteria) this;
		}

		public Criteria andCurrStepNotEqualTo(String value) {
			addCriterion("CURR_STEP <>", value, "currStep");
			return (Criteria) this;
		}

		public Criteria andCurrStepGreaterThan(String value) {
			addCriterion("CURR_STEP >", value, "currStep");
			return (Criteria) this;
		}

		public Criteria andCurrStepGreaterThanOrEqualTo(String value) {
			addCriterion("CURR_STEP >=", value, "currStep");
			return (Criteria) this;
		}

		public Criteria andCurrStepLessThan(String value) {
			addCriterion("CURR_STEP <", value, "currStep");
			return (Criteria) this;
		}

		public Criteria andCurrStepLessThanOrEqualTo(String value) {
			addCriterion("CURR_STEP <=", value, "currStep");
			return (Criteria) this;
		}

		public Criteria andCurrStepLike(String value) {
			addCriterion("CURR_STEP like", value, "currStep");
			return (Criteria) this;
		}

		public Criteria andCurrStepNotLike(String value) {
			addCriterion("CURR_STEP not like", value, "currStep");
			return (Criteria) this;
		}

		public Criteria andCurrStepIn(List<String> values) {
			addCriterion("CURR_STEP in", values, "currStep");
			return (Criteria) this;
		}

		public Criteria andCurrStepNotIn(List<String> values) {
			addCriterion("CURR_STEP not in", values, "currStep");
			return (Criteria) this;
		}

		public Criteria andCurrStepBetween(String value1, String value2) {
			addCriterion("CURR_STEP between", value1, value2, "currStep");
			return (Criteria) this;
		}

		public Criteria andCurrStepNotBetween(String value1, String value2) {
			addCriterion("CURR_STEP not between", value1, value2, "currStep");
			return (Criteria) this;
		}

		public Criteria andNextStepIsNull() {
			addCriterion("NEXT_STEP is null");
			return (Criteria) this;
		}

		public Criteria andNextStepIsNotNull() {
			addCriterion("NEXT_STEP is not null");
			return (Criteria) this;
		}

		public Criteria andNextStepEqualTo(String value) {
			addCriterion("NEXT_STEP =", value, "nextStep");
			return (Criteria) this;
		}

		public Criteria andNextStepNotEqualTo(String value) {
			addCriterion("NEXT_STEP <>", value, "nextStep");
			return (Criteria) this;
		}

		public Criteria andNextStepGreaterThan(String value) {
			addCriterion("NEXT_STEP >", value, "nextStep");
			return (Criteria) this;
		}

		public Criteria andNextStepGreaterThanOrEqualTo(String value) {
			addCriterion("NEXT_STEP >=", value, "nextStep");
			return (Criteria) this;
		}

		public Criteria andNextStepLessThan(String value) {
			addCriterion("NEXT_STEP <", value, "nextStep");
			return (Criteria) this;
		}

		public Criteria andNextStepLessThanOrEqualTo(String value) {
			addCriterion("NEXT_STEP <=", value, "nextStep");
			return (Criteria) this;
		}

		public Criteria andNextStepLike(String value) {
			addCriterion("NEXT_STEP like", value, "nextStep");
			return (Criteria) this;
		}

		public Criteria andNextStepNotLike(String value) {
			addCriterion("NEXT_STEP not like", value, "nextStep");
			return (Criteria) this;
		}

		public Criteria andNextStepIn(List<String> values) {
			addCriterion("NEXT_STEP in", values, "nextStep");
			return (Criteria) this;
		}

		public Criteria andNextStepNotIn(List<String> values) {
			addCriterion("NEXT_STEP not in", values, "nextStep");
			return (Criteria) this;
		}

		public Criteria andNextStepBetween(String value1, String value2) {
			addCriterion("NEXT_STEP between", value1, value2, "nextStep");
			return (Criteria) this;
		}

		public Criteria andNextStepNotBetween(String value1, String value2) {
			addCriterion("NEXT_STEP not between", value1, value2, "nextStep");
			return (Criteria) this;
		}
		
		public Criteria andHandlerIsNull() {
			addCriterion("HANDLER is null");
			return (Criteria) this;
		}

		public Criteria andHandlerIsNotNull() {
			addCriterion("HANDLER is not null");
			return (Criteria) this;
		}

		public Criteria andHandlerEqualTo(Long value) {
			addCriterion("HANDLER =", value, "handler");
			return (Criteria) this;
		}

		public Criteria andHandlerNotEqualTo(Long value) {
			addCriterion("HANDLER <>", value, "handler");
			return (Criteria) this;
		}

		public Criteria andHandlerGreaterThan(Long value) {
			addCriterion("HANDLER >", value, "handler");
			return (Criteria) this;
		}

		public Criteria andHandlerGreaterThanOrEqualTo(Long value) {
			addCriterion("HANDLER >=", value, "handler");
			return (Criteria) this;
		}

		public Criteria andHandlerLessThan(Long value) {
			addCriterion("HANDLER <", value, "handler");
			return (Criteria) this;
		}

		public Criteria andHandlerLessThanOrEqualTo(Long value) {
			addCriterion("HANDLER <=", value, "handler");
			return (Criteria) this;
		}

		public Criteria andHandlerIn(List<Long> values) {
			addCriterion("HANDLER in", values, "handler");
			return (Criteria) this;
		}

		public Criteria andHandlerNotIn(List<Long> values) {
			addCriterion("HANDLER not in", values, "handler");
			return (Criteria) this;
		}

		public Criteria andHandlerBetween(Long value1, Long value2) {
			addCriterion("HANDLER between", value1, value2, "handler");
			return (Criteria) this;
		}

		public Criteria andHandlerNotBetween(Long value1, Long value2) {
			addCriterion("HANDLER not between", value1, value2, "handler");
			return (Criteria) this;
		}

		public Criteria andFinishTimeIsNull() {
			addCriterion("FINISH_TIME is null");
			return (Criteria) this;
		}

		public Criteria andFinishTimeIsNotNull() {
			addCriterion("FINISH_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andFinishTimeEqualTo(Date value) {
			addCriterion("FINISH_TIME =", value, "finishTime");
			return (Criteria) this;
		}

		public Criteria andFinishTimeNotEqualTo(Date value) {
			addCriterion("FINISH_TIME <>", value, "finishTime");
			return (Criteria) this;
		}

		public Criteria andFinishTimeGreaterThan(Date value) {
			addCriterion("FINISH_TIME >", value, "finishTime");
			return (Criteria) this;
		}

		public Criteria andFinishTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("FINISH_TIME >=", value, "finishTime");
			return (Criteria) this;
		}

		public Criteria andFinishTimeLessThan(Date value) {
			addCriterion("FINISH_TIME <", value, "finishTime");
			return (Criteria) this;
		}

		public Criteria andFinishTimeLessThanOrEqualTo(Date value) {
			addCriterion("FINISH_TIME <=", value, "finishTime");
			return (Criteria) this;
		}

		public Criteria andFinishTimeIn(List<Date> values) {
			addCriterion("FINISH_TIME in", values, "finishTime");
			return (Criteria) this;
		}

		public Criteria andFinishTimeNotIn(List<Date> values) {
			addCriterion("FINISH_TIME not in", values, "finishTime");
			return (Criteria) this;
		}

		public Criteria andFinishTimeBetween(Date value1, Date value2) {
			addCriterion("FINISH_TIME between", value1, value2, "finishTime");
			return (Criteria) this;
		}

		public Criteria andFinishTimeNotBetween(Date value1, Date value2) {
			addCriterion("FINISH_TIME not between", value1, value2,
					"finishTime");
			return (Criteria) this;
		}

		public Criteria andManualResultIsNull() {
			addCriterion("MANUAL_RESULT is null");
			return (Criteria) this;
		}

		public Criteria andManualResultIsNotNull() {
			addCriterion("MANUAL_RESULT is not null");
			return (Criteria) this;
		}

		public Criteria andManualResultEqualTo(String value) {
			addCriterion("MANUAL_RESULT =", value, "manualResult");
			return (Criteria) this;
		}

		public Criteria andManualResultNotEqualTo(String value) {
			addCriterion("MANUAL_RESULT <>", value, "manualResult");
			return (Criteria) this;
		}

		public Criteria andManualResultGreaterThan(String value) {
			addCriterion("MANUAL_RESULT >", value, "manualResult");
			return (Criteria) this;
		}

		public Criteria andManualResultGreaterThanOrEqualTo(String value) {
			addCriterion("MANUAL_RESULT >=", value, "manualResult");
			return (Criteria) this;
		}

		public Criteria andManualResultLessThan(String value) {
			addCriterion("MANUAL_RESULT <", value, "manualResult");
			return (Criteria) this;
		}

		public Criteria andManualResultLessThanOrEqualTo(String value) {
			addCriterion("MANUAL_RESULT <=", value, "manualResult");
			return (Criteria) this;
		}

		public Criteria andManualResultLike(String value) {
			addCriterion("MANUAL_RESULT like", value, "manualResult");
			return (Criteria) this;
		}

		public Criteria andManualResultNotLike(String value) {
			addCriterion("MANUAL_RESULT not like", value, "manualResult");
			return (Criteria) this;
		}

		public Criteria andManualResultIn(List<String> values) {
			addCriterion("MANUAL_RESULT in", values, "manualResult");
			return (Criteria) this;
		}

		public Criteria andManualResultNotIn(List<String> values) {
			addCriterion("MANUAL_RESULT not in", values, "manualResult");
			return (Criteria) this;
		}

		public Criteria andManualResultBetween(String value1, String value2) {
			addCriterion("MANUAL_RESULT between", value1, value2,
					"manualResult");
			return (Criteria) this;
		}

		public Criteria andManualResultNotBetween(String value1, String value2) {
			addCriterion("MANUAL_RESULT not between", value1, value2,
					"manualResult");
			return (Criteria) this;
		}

		public Criteria andLoanLimitIsNull() {
			addCriterion("LOAN_LIMIT is null");
			return (Criteria) this;
		}

		public Criteria andLoanLimitIsNotNull() {
			addCriterion("LOAN_LIMIT is not null");
			return (Criteria) this;
		}

		public Criteria andLoanLimitEqualTo(BigDecimal value) {
			addCriterion("LOAN_LIMIT =", value, "loanLimit");
			return (Criteria) this;
		}

		public Criteria andLoanLimitNotEqualTo(BigDecimal value) {
			addCriterion("LOAN_LIMIT <>", value, "loanLimit");
			return (Criteria) this;
		}

		public Criteria andLoanLimitGreaterThan(BigDecimal value) {
			addCriterion("LOAN_LIMIT >", value, "loanLimit");
			return (Criteria) this;
		}

		public Criteria andLoanLimitGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("LOAN_LIMIT >=", value, "loanLimit");
			return (Criteria) this;
		}

		public Criteria andLoanLimitLessThan(BigDecimal value) {
			addCriterion("LOAN_LIMIT <", value, "loanLimit");
			return (Criteria) this;
		}

		public Criteria andLoanLimitLessThanOrEqualTo(BigDecimal value) {
			addCriterion("LOAN_LIMIT <=", value, "loanLimit");
			return (Criteria) this;
		}

		public Criteria andLoanLimitIn(List<BigDecimal> values) {
			addCriterion("LOAN_LIMIT in", values, "loanLimit");
			return (Criteria) this;
		}

		public Criteria andLoanLimitNotIn(List<BigDecimal> values) {
			addCriterion("LOAN_LIMIT not in", values, "loanLimit");
			return (Criteria) this;
		}

		public Criteria andLoanLimitBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LOAN_LIMIT between", value1, value2, "loanLimit");
			return (Criteria) this;
		}

		public Criteria andLoanLimitNotBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("LOAN_LIMIT not between", value1, value2, "loanLimit");
			return (Criteria) this;
		}

		public Criteria andLoanRateIsNull() {
			addCriterion("LOAN_RATE is null");
			return (Criteria) this;
		}

		public Criteria andLoanRateIsNotNull() {
			addCriterion("LOAN_RATE is not null");
			return (Criteria) this;
		}

		public Criteria andLoanRateEqualTo(BigDecimal value) {
			addCriterion("LOAN_RATE =", value, "loanRate");
			return (Criteria) this;
		}

		public Criteria andLoanRateNotEqualTo(BigDecimal value) {
			addCriterion("LOAN_RATE <>", value, "loanRate");
			return (Criteria) this;
		}

		public Criteria andLoanRateGreaterThan(BigDecimal value) {
			addCriterion("LOAN_RATE >", value, "loanRate");
			return (Criteria) this;
		}

		public Criteria andLoanRateGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("LOAN_RATE >=", value, "loanRate");
			return (Criteria) this;
		}

		public Criteria andLoanRateLessThan(BigDecimal value) {
			addCriterion("LOAN_RATE <", value, "loanRate");
			return (Criteria) this;
		}

		public Criteria andLoanRateLessThanOrEqualTo(BigDecimal value) {
			addCriterion("LOAN_RATE <=", value, "loanRate");
			return (Criteria) this;
		}

		public Criteria andLoanRateIn(List<BigDecimal> values) {
			addCriterion("LOAN_RATE in", values, "loanRate");
			return (Criteria) this;
		}

		public Criteria andLoanRateNotIn(List<BigDecimal> values) {
			addCriterion("LOAN_RATE not in", values, "loanRate");
			return (Criteria) this;
		}

		public Criteria andLoanRateBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LOAN_RATE between", value1, value2, "loanRate");
			return (Criteria) this;
		}

		public Criteria andLoanRateNotBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("LOAN_RATE not between", value1, value2, "loanRate");
			return (Criteria) this;
		}

		public Criteria andReasonCodeIsNull() {
			addCriterion("REASON_CODE is null");
			return (Criteria) this;
		}

		public Criteria andReasonCodeIsNotNull() {
			addCriterion("REASON_CODE is not null");
			return (Criteria) this;
		}

		public Criteria andReasonCodeEqualTo(String value) {
			addCriterion("REASON_CODE =", value, "reasonCode");
			return (Criteria) this;
		}

		public Criteria andReasonCodeNotEqualTo(String value) {
			addCriterion("REASON_CODE <>", value, "reasonCode");
			return (Criteria) this;
		}

		public Criteria andReasonCodeGreaterThan(String value) {
			addCriterion("REASON_CODE >", value, "reasonCode");
			return (Criteria) this;
		}

		public Criteria andReasonCodeGreaterThanOrEqualTo(String value) {
			addCriterion("REASON_CODE >=", value, "reasonCode");
			return (Criteria) this;
		}

		public Criteria andReasonCodeLessThan(String value) {
			addCriterion("REASON_CODE <", value, "reasonCode");
			return (Criteria) this;
		}

		public Criteria andReasonCodeLessThanOrEqualTo(String value) {
			addCriterion("REASON_CODE <=", value, "reasonCode");
			return (Criteria) this;
		}

		public Criteria andReasonCodeLike(String value) {
			addCriterion("REASON_CODE like", value, "reasonCode");
			return (Criteria) this;
		}

		public Criteria andReasonCodeNotLike(String value) {
			addCriterion("REASON_CODE not like", value, "reasonCode");
			return (Criteria) this;
		}

		public Criteria andReasonCodeIn(List<String> values) {
			addCriterion("REASON_CODE in", values, "reasonCode");
			return (Criteria) this;
		}

		public Criteria andReasonCodeNotIn(List<String> values) {
			addCriterion("REASON_CODE not in", values, "reasonCode");
			return (Criteria) this;
		}

		public Criteria andReasonCodeBetween(String value1, String value2) {
			addCriterion("REASON_CODE between", value1, value2, "reasonCode");
			return (Criteria) this;
		}

		public Criteria andReasonCodeNotBetween(String value1, String value2) {
			addCriterion("REASON_CODE not between", value1, value2,
					"reasonCode");
			return (Criteria) this;
		}

		public Criteria andReasonDescIsNull() {
			addCriterion("REASON_DESC is null");
			return (Criteria) this;
		}

		public Criteria andReasonDescIsNotNull() {
			addCriterion("REASON_DESC is not null");
			return (Criteria) this;
		}

		public Criteria andReasonDescEqualTo(String value) {
			addCriterion("REASON_DESC =", value, "reasonDesc");
			return (Criteria) this;
		}

		public Criteria andReasonDescNotEqualTo(String value) {
			addCriterion("REASON_DESC <>", value, "reasonDesc");
			return (Criteria) this;
		}

		public Criteria andReasonDescGreaterThan(String value) {
			addCriterion("REASON_DESC >", value, "reasonDesc");
			return (Criteria) this;
		}

		public Criteria andReasonDescGreaterThanOrEqualTo(String value) {
			addCriterion("REASON_DESC >=", value, "reasonDesc");
			return (Criteria) this;
		}

		public Criteria andReasonDescLessThan(String value) {
			addCriterion("REASON_DESC <", value, "reasonDesc");
			return (Criteria) this;
		}

		public Criteria andReasonDescLessThanOrEqualTo(String value) {
			addCriterion("REASON_DESC <=", value, "reasonDesc");
			return (Criteria) this;
		}

		public Criteria andReasonDescLike(String value) {
			addCriterion("REASON_DESC like", value, "reasonDesc");
			return (Criteria) this;
		}

		public Criteria andReasonDescNotLike(String value) {
			addCriterion("REASON_DESC not like", value, "reasonDesc");
			return (Criteria) this;
		}

		public Criteria andReasonDescIn(List<String> values) {
			addCriterion("REASON_DESC in", values, "reasonDesc");
			return (Criteria) this;
		}

		public Criteria andReasonDescNotIn(List<String> values) {
			addCriterion("REASON_DESC not in", values, "reasonDesc");
			return (Criteria) this;
		}

		public Criteria andReasonDescBetween(String value1, String value2) {
			addCriterion("REASON_DESC between", value1, value2, "reasonDesc");
			return (Criteria) this;
		}

		public Criteria andReasonDescNotBetween(String value1, String value2) {
			addCriterion("REASON_DESC not between", value1, value2,
					"reasonDesc");
			return (Criteria) this;
		}

		public Criteria andCurrUserIsNull() {
			addCriterion("CURR_USER is null");
			return (Criteria) this;
		}

		public Criteria andCurrUserIsNotNull() {
			addCriterion("CURR_USER is not null");
			return (Criteria) this;
		}

		public Criteria andCurrUserEqualTo(Long value) {
			addCriterion("CURR_USER =", value, "currUser");
			return (Criteria) this;
		}

		public Criteria andCurrUserNotEqualTo(Long value) {
			addCriterion("CURR_USER <>", value, "currUser");
			return (Criteria) this;
		}

		public Criteria andCurrUserGreaterThan(Long value) {
			addCriterion("CURR_USER >", value, "currUser");
			return (Criteria) this;
		}

		public Criteria andCurrUserGreaterThanOrEqualTo(Long value) {
			addCriterion("CURR_USER >=", value, "currUser");
			return (Criteria) this;
		}

		public Criteria andCurrUserLessThan(Long value) {
			addCriterion("CURR_USER <", value, "currUser");
			return (Criteria) this;
		}

		public Criteria andCurrUserLessThanOrEqualTo(Long value) {
			addCriterion("CURR_USER <=", value, "currUser");
			return (Criteria) this;
		}

		public Criteria andCurrUserIn(List<Long> values) {
			addCriterion("CURR_USER in", values, "currUser");
			return (Criteria) this;
		}

		public Criteria andCurrUserNotIn(List<Long> values) {
			addCriterion("CURR_USER not in", values, "currUser");
			return (Criteria) this;
		}

		public Criteria andCurrUserBetween(Long value1, Long value2) {
			addCriterion("CURR_USER between", value1, value2, "currUser");
			return (Criteria) this;
		}

		public Criteria andCurrUserNotBetween(Long value1, Long value2) {
			addCriterion("CURR_USER not between", value1, value2, "currUser");
			return (Criteria) this;
		}

		public Criteria andOperTimeIsNull() {
			addCriterion("OPER_TIME is null");
			return (Criteria) this;
		}

		public Criteria andOperTimeIsNotNull() {
			addCriterion("OPER_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andOperTimeEqualTo(Date value) {
			addCriterion("OPER_TIME =", value, "operTime");
			return (Criteria) this;
		}

		public Criteria andOperTimeNotEqualTo(Date value) {
			addCriterion("OPER_TIME <>", value, "operTime");
			return (Criteria) this;
		}

		public Criteria andOperTimeGreaterThan(Date value) {
			addCriterion("OPER_TIME >", value, "operTime");
			return (Criteria) this;
		}

		public Criteria andOperTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("OPER_TIME >=", value, "operTime");
			return (Criteria) this;
		}

		public Criteria andOperTimeLessThan(Date value) {
			addCriterion("OPER_TIME <", value, "operTime");
			return (Criteria) this;
		}

		public Criteria andOperTimeLessThanOrEqualTo(Date value) {
			addCriterion("OPER_TIME <=", value, "operTime");
			return (Criteria) this;
		}

		public Criteria andOperTimeIn(List<Date> values) {
			addCriterion("OPER_TIME in", values, "operTime");
			return (Criteria) this;
		}

		public Criteria andOperTimeNotIn(List<Date> values) {
			addCriterion("OPER_TIME not in", values, "operTime");
			return (Criteria) this;
		}

		public Criteria andOperTimeBetween(Date value1, Date value2) {
			addCriterion("OPER_TIME between", value1, value2, "operTime");
			return (Criteria) this;
		}

		public Criteria andOperTimeNotBetween(Date value1, Date value2) {
			addCriterion("OPER_TIME not between", value1, value2, "operTime");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table ml_app_strategy_result
	 * @mbggenerated  Sat Oct 25 21:44:07 GMT+08:00 2014
	 */
	public static class Criterion {
		private String condition;
		private Object value;
		private Object secondValue;
		private boolean noValue;
		private boolean singleValue;
		private boolean betweenValue;
		private boolean listValue;
		private String typeHandler;

		public String getCondition() {
			return condition;
		}

		public Object getValue() {
			return value;
		}

		public Object getSecondValue() {
			return secondValue;
		}

		public boolean isNoValue() {
			return noValue;
		}

		public boolean isSingleValue() {
			return singleValue;
		}

		public boolean isBetweenValue() {
			return betweenValue;
		}

		public boolean isListValue() {
			return listValue;
		}

		public String getTypeHandler() {
			return typeHandler;
		}

		protected Criterion(String condition) {
			super();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion(String condition, Object value, String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List<?>) {
				this.listValue = true;
			} else {
				this.singleValue = true;
			}
		}

		protected Criterion(String condition, Object value) {
			this(condition, value, null);
		}

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
			super();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion(String condition, Object value, Object secondValue) {
			this(condition, value, secondValue, null);
		}
	}
	
	public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}
