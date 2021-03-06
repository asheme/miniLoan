package com.wealth.miniloan.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wealth.miniloan.entity.UnionAppExample.Criteria;

public class UnionLoanExample {
	protected String orderByClause;
	protected boolean distinct;
	protected List<Criteria> oredCriteria;

	public UnionLoanExample() {
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

		public Criteria andLoanIdIsNull() {
			addCriterion("LOAN_ID is null");
			return (Criteria) this;
		}

		public Criteria andLoanIdIsNotNull() {
			addCriterion("LOAN_ID is not null");
			return (Criteria) this;
		}

		public Criteria andLoanIdEqualTo(Long value) {
			addCriterion("LOAN_ID =", value, "loanId");
			return (Criteria) this;
		}

		public Criteria andLoanIdNotEqualTo(Long value) {
			addCriterion("LOAN_ID <>", value, "loanId");
			return (Criteria) this;
		}

		public Criteria andLoanIdGreaterThan(Long value) {
			addCriterion("LOAN_ID >", value, "loanId");
			return (Criteria) this;
		}

		public Criteria andLoanIdGreaterThanOrEqualTo(Long value) {
			addCriterion("LOAN_ID >=", value, "loanId");
			return (Criteria) this;
		}

		public Criteria andLoanIdLessThan(Long value) {
			addCriterion("LOAN_ID <", value, "loanId");
			return (Criteria) this;
		}

		public Criteria andLoanIdLessThanOrEqualTo(Long value) {
			addCriterion("LOAN_ID <=", value, "loanId");
			return (Criteria) this;
		}

		public Criteria andLoanIdIn(List<Long> values) {
			addCriterion("LOAN_ID in", values, "loanId");
			return (Criteria) this;
		}

		public Criteria andLoanIdNotIn(List<Long> values) {
			addCriterion("LOAN_ID not in", values, "loanId");
			return (Criteria) this;
		}

		public Criteria andLoanIdBetween(Long value1, Long value2) {
			addCriterion("LOAN_ID between", value1, value2, "loanId");
			return (Criteria) this;
		}

		public Criteria andLoanIdNotBetween(Long value1, Long value2) {
			addCriterion("LOAN_ID not between", value1, value2, "loanId");
			return (Criteria) this;
		}

		public Criteria andCustNoIsNull() {
			addCriterion("CUST_NO is null");
			return (Criteria) this;
		}

		public Criteria andCustNoIsNotNull() {
			addCriterion("CUST_NO is not null");
			return (Criteria) this;
		}

		public Criteria andCustNoEqualTo(String value) {
			addCriterion("CUST_NO =", value, "custNo");
			return (Criteria) this;
		}

		public Criteria andCustNoNotEqualTo(String value) {
			addCriterion("CUST_NO <>", value, "custNo");
			return (Criteria) this;
		}

		public Criteria andCustNoGreaterThan(String value) {
			addCriterion("CUST_NO >", value, "custNo");
			return (Criteria) this;
		}

		public Criteria andCustNoGreaterThanOrEqualTo(String value) {
			addCriterion("CUST_NO >=", value, "custNo");
			return (Criteria) this;
		}

		public Criteria andCustNoLessThan(String value) {
			addCriterion("CUST_NO <", value, "custNo");
			return (Criteria) this;
		}

		public Criteria andCustNoLessThanOrEqualTo(String value) {
			addCriterion("CUST_NO <=", value, "custNo");
			return (Criteria) this;
		}

		public Criteria andCustNoLike(String value) {
			addCriterion("CUST_NO like", value, "custNo");
			return (Criteria) this;
		}

		public Criteria andCustNoNotLike(String value) {
			addCriterion("CUST_NO not like", value, "custNo");
			return (Criteria) this;
		}

		public Criteria andCustNoIn(List<String> values) {
			addCriterion("CUST_NO in", values, "custNo");
			return (Criteria) this;
		}

		public Criteria andCustNoNotIn(List<String> values) {
			addCriterion("CUST_NO not in", values, "custNo");
			return (Criteria) this;
		}

		public Criteria andCustNoBetween(String value1, String value2) {
			addCriterion("CUST_NO between", value1, value2, "custNo");
			return (Criteria) this;
		}

		public Criteria andCustNoNotBetween(String value1, String value2) {
			addCriterion("CUST_NO not between", value1, value2, "custNo");
			return (Criteria) this;
		}

		public Criteria andCustTypeIsNull() {
			addCriterion("CUST_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andCustTypeIsNotNull() {
			addCriterion("CUST_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andCustTypeEqualTo(String value) {
			addCriterion("CUST_TYPE =", value, "custType");
			return (Criteria) this;
		}

		public Criteria andCustTypeNotEqualTo(String value) {
			addCriterion("CUST_TYPE <>", value, "custType");
			return (Criteria) this;
		}

		public Criteria andCustTypeGreaterThan(String value) {
			addCriterion("CUST_TYPE >", value, "custType");
			return (Criteria) this;
		}

		public Criteria andCustTypeGreaterThanOrEqualTo(String value) {
			addCriterion("CUST_TYPE >=", value, "custType");
			return (Criteria) this;
		}

		public Criteria andCustTypeLessThan(String value) {
			addCriterion("CUST_TYPE <", value, "custType");
			return (Criteria) this;
		}

		public Criteria andCustTypeLessThanOrEqualTo(String value) {
			addCriterion("CUST_TYPE <=", value, "custType");
			return (Criteria) this;
		}

		public Criteria andCustTypeLike(String value) {
			addCriterion("CUST_TYPE like", value, "custType");
			return (Criteria) this;
		}

		public Criteria andCustTypeNotLike(String value) {
			addCriterion("CUST_TYPE not like", value, "custType");
			return (Criteria) this;
		}

		public Criteria andCustTypeIn(List<String> values) {
			addCriterion("CUST_TYPE in", values, "custType");
			return (Criteria) this;
		}

		public Criteria andCustTypeNotIn(List<String> values) {
			addCriterion("CUST_TYPE not in", values, "custType");
			return (Criteria) this;
		}

		public Criteria andCustTypeBetween(String value1, String value2) {
			addCriterion("CUST_TYPE between", value1, value2, "custType");
			return (Criteria) this;
		}

		public Criteria andCustTypeNotBetween(String value1, String value2) {
			addCriterion("CUST_TYPE not between", value1, value2, "custType");
			return (Criteria) this;
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

		public Criteria andLoanContractNoIsNull() {
			addCriterion("LOAN_CONTRACT_NO is null");
			return (Criteria) this;
		}

		public Criteria andLoanContractNoIsNotNull() {
			addCriterion("LOAN_CONTRACT_NO is not null");
			return (Criteria) this;
		}

		public Criteria andLoanContractNoEqualTo(String value) {
			addCriterion("LOAN_CONTRACT_NO =", value, "loanContractNo");
			return (Criteria) this;
		}

		public Criteria andLoanContractNoNotEqualTo(String value) {
			addCriterion("LOAN_CONTRACT_NO <>", value, "loanContractNo");
			return (Criteria) this;
		}

		public Criteria andLoanContractNoGreaterThan(String value) {
			addCriterion("LOAN_CONTRACT_NO >", value, "loanContractNo");
			return (Criteria) this;
		}

		public Criteria andLoanContractNoGreaterThanOrEqualTo(String value) {
			addCriterion("LOAN_CONTRACT_NO >=", value, "loanContractNo");
			return (Criteria) this;
		}

		public Criteria andLoanContractNoLessThan(String value) {
			addCriterion("LOAN_CONTRACT_NO <", value, "loanContractNo");
			return (Criteria) this;
		}

		public Criteria andLoanContractNoLessThanOrEqualTo(String value) {
			addCriterion("LOAN_CONTRACT_NO <=", value, "loanContractNo");
			return (Criteria) this;
		}

		public Criteria andLoanContractNoLike(String value) {
			addCriterion("LOAN_CONTRACT_NO like", value, "loanContractNo");
			return (Criteria) this;
		}

		public Criteria andLoanContractNoNotLike(String value) {
			addCriterion("LOAN_CONTRACT_NO not like", value, "loanContractNo");
			return (Criteria) this;
		}

		public Criteria andLoanContractNoIn(List<String> values) {
			addCriterion("LOAN_CONTRACT_NO in", values, "loanContractNo");
			return (Criteria) this;
		}

		public Criteria andLoanContractNoNotIn(List<String> values) {
			addCriterion("LOAN_CONTRACT_NO not in", values, "loanContractNo");
			return (Criteria) this;
		}

		public Criteria andLoanContractNoBetween(String value1, String value2) {
			addCriterion("LOAN_CONTRACT_NO between", value1, value2,
					"loanContractNo");
			return (Criteria) this;
		}

		public Criteria andLoanContractNoNotBetween(String value1, String value2) {
			addCriterion("LOAN_CONTRACT_NO not between", value1, value2,
					"loanContractNo");
			return (Criteria) this;
		}

		public Criteria andLoanAmountIsNull() {
			addCriterion("LOAN_AMOUNT is null");
			return (Criteria) this;
		}

		public Criteria andLoanAmountIsNotNull() {
			addCriterion("LOAN_AMOUNT is not null");
			return (Criteria) this;
		}

		public Criteria andLoanAmountEqualTo(BigDecimal value) {
			addCriterion("LOAN_AMOUNT =", value, "loanAmount");
			return (Criteria) this;
		}

		public Criteria andLoanAmountNotEqualTo(BigDecimal value) {
			addCriterion("LOAN_AMOUNT <>", value, "loanAmount");
			return (Criteria) this;
		}

		public Criteria andLoanAmountGreaterThan(BigDecimal value) {
			addCriterion("LOAN_AMOUNT >", value, "loanAmount");
			return (Criteria) this;
		}

		public Criteria andLoanAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("LOAN_AMOUNT >=", value, "loanAmount");
			return (Criteria) this;
		}

		public Criteria andLoanAmountLessThan(BigDecimal value) {
			addCriterion("LOAN_AMOUNT <", value, "loanAmount");
			return (Criteria) this;
		}

		public Criteria andLoanAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("LOAN_AMOUNT <=", value, "loanAmount");
			return (Criteria) this;
		}

		public Criteria andLoanAmountIn(List<BigDecimal> values) {
			addCriterion("LOAN_AMOUNT in", values, "loanAmount");
			return (Criteria) this;
		}

		public Criteria andLoanAmountNotIn(List<BigDecimal> values) {
			addCriterion("LOAN_AMOUNT not in", values, "loanAmount");
			return (Criteria) this;
		}

		public Criteria andLoanAmountBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("LOAN_AMOUNT between", value1, value2, "loanAmount");
			return (Criteria) this;
		}

		public Criteria andLoanAmountNotBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("LOAN_AMOUNT not between", value1, value2,
					"loanAmount");
			return (Criteria) this;
		}

		public Criteria andLoanCycleIsNull() {
			addCriterion("LOAN_CYCLE is null");
			return (Criteria) this;
		}

		public Criteria andLoanCycleIsNotNull() {
			addCriterion("LOAN_CYCLE is not null");
			return (Criteria) this;
		}

		public Criteria andLoanCycleEqualTo(Integer value) {
			addCriterion("LOAN_CYCLE =", value, "loanCycle");
			return (Criteria) this;
		}

		public Criteria andLoanCycleNotEqualTo(Integer value) {
			addCriterion("LOAN_CYCLE <>", value, "loanCycle");
			return (Criteria) this;
		}

		public Criteria andLoanCycleGreaterThan(Integer value) {
			addCriterion("LOAN_CYCLE >", value, "loanCycle");
			return (Criteria) this;
		}

		public Criteria andLoanCycleGreaterThanOrEqualTo(Integer value) {
			addCriterion("LOAN_CYCLE >=", value, "loanCycle");
			return (Criteria) this;
		}

		public Criteria andLoanCycleLessThan(Integer value) {
			addCriterion("LOAN_CYCLE <", value, "loanCycle");
			return (Criteria) this;
		}

		public Criteria andLoanCycleLessThanOrEqualTo(Integer value) {
			addCriterion("LOAN_CYCLE <=", value, "loanCycle");
			return (Criteria) this;
		}

		public Criteria andLoanCycleIn(List<Integer> values) {
			addCriterion("LOAN_CYCLE in", values, "loanCycle");
			return (Criteria) this;
		}

		public Criteria andLoanCycleNotIn(List<Integer> values) {
			addCriterion("LOAN_CYCLE not in", values, "loanCycle");
			return (Criteria) this;
		}

		public Criteria andLoanCycleBetween(Integer value1, Integer value2) {
			addCriterion("LOAN_CYCLE between", value1, value2, "loanCycle");
			return (Criteria) this;
		}

		public Criteria andLoanCycleNotBetween(Integer value1, Integer value2) {
			addCriterion("LOAN_CYCLE not between", value1, value2, "loanCycle");
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

		public Criteria andOfferMethodIsNull() {
			addCriterion("OFFER_METHOD is null");
			return (Criteria) this;
		}

		public Criteria andOfferMethodIsNotNull() {
			addCriterion("OFFER_METHOD is not null");
			return (Criteria) this;
		}

		public Criteria andOfferMethodEqualTo(String value) {
			addCriterion("OFFER_METHOD =", value, "offerMethod");
			return (Criteria) this;
		}

		public Criteria andOfferMethodNotEqualTo(String value) {
			addCriterion("OFFER_METHOD <>", value, "offerMethod");
			return (Criteria) this;
		}

		public Criteria andOfferMethodGreaterThan(String value) {
			addCriterion("OFFER_METHOD >", value, "offerMethod");
			return (Criteria) this;
		}

		public Criteria andOfferMethodGreaterThanOrEqualTo(String value) {
			addCriterion("OFFER_METHOD >=", value, "offerMethod");
			return (Criteria) this;
		}

		public Criteria andOfferMethodLessThan(String value) {
			addCriterion("OFFER_METHOD <", value, "offerMethod");
			return (Criteria) this;
		}

		public Criteria andOfferMethodLessThanOrEqualTo(String value) {
			addCriterion("OFFER_METHOD <=", value, "offerMethod");
			return (Criteria) this;
		}

		public Criteria andOfferMethodLike(String value) {
			addCriterion("OFFER_METHOD like", value, "offerMethod");
			return (Criteria) this;
		}

		public Criteria andOfferMethodNotLike(String value) {
			addCriterion("OFFER_METHOD not like", value, "offerMethod");
			return (Criteria) this;
		}

		public Criteria andOfferMethodIn(List<String> values) {
			addCriterion("OFFER_METHOD in", values, "offerMethod");
			return (Criteria) this;
		}

		public Criteria andOfferMethodNotIn(List<String> values) {
			addCriterion("OFFER_METHOD not in", values, "offerMethod");
			return (Criteria) this;
		}

		public Criteria andOfferMethodBetween(String value1, String value2) {
			addCriterion("OFFER_METHOD between", value1, value2, "offerMethod");
			return (Criteria) this;
		}

		public Criteria andOfferMethodNotBetween(String value1, String value2) {
			addCriterion("OFFER_METHOD not between", value1, value2,
					"offerMethod");
			return (Criteria) this;
		}

		public Criteria andPayMethodIsNull() {
			addCriterion("PAY_METHOD is null");
			return (Criteria) this;
		}

		public Criteria andPayMethodIsNotNull() {
			addCriterion("PAY_METHOD is not null");
			return (Criteria) this;
		}

		public Criteria andPayMethodEqualTo(String value) {
			addCriterion("PAY_METHOD =", value, "payMethod");
			return (Criteria) this;
		}

		public Criteria andPayMethodNotEqualTo(String value) {
			addCriterion("PAY_METHOD <>", value, "payMethod");
			return (Criteria) this;
		}

		public Criteria andPayMethodGreaterThan(String value) {
			addCriterion("PAY_METHOD >", value, "payMethod");
			return (Criteria) this;
		}

		public Criteria andPayMethodGreaterThanOrEqualTo(String value) {
			addCriterion("PAY_METHOD >=", value, "payMethod");
			return (Criteria) this;
		}

		public Criteria andPayMethodLessThan(String value) {
			addCriterion("PAY_METHOD <", value, "payMethod");
			return (Criteria) this;
		}

		public Criteria andPayMethodLessThanOrEqualTo(String value) {
			addCriterion("PAY_METHOD <=", value, "payMethod");
			return (Criteria) this;
		}

		public Criteria andPayMethodLike(String value) {
			addCriterion("PAY_METHOD like", value, "payMethod");
			return (Criteria) this;
		}

		public Criteria andPayMethodNotLike(String value) {
			addCriterion("PAY_METHOD not like", value, "payMethod");
			return (Criteria) this;
		}

		public Criteria andPayMethodIn(List<String> values) {
			addCriterion("PAY_METHOD in", values, "payMethod");
			return (Criteria) this;
		}

		public Criteria andPayMethodNotIn(List<String> values) {
			addCriterion("PAY_METHOD not in", values, "payMethod");
			return (Criteria) this;
		}

		public Criteria andPayMethodBetween(String value1, String value2) {
			addCriterion("PAY_METHOD between", value1, value2, "payMethod");
			return (Criteria) this;
		}

		public Criteria andPayMethodNotBetween(String value1, String value2) {
			addCriterion("PAY_METHOD not between", value1, value2, "payMethod");
			return (Criteria) this;
		}

		public Criteria andInterestPenaltyIsNull() {
			addCriterion("INTEREST_PENALTY is null");
			return (Criteria) this;
		}

		public Criteria andInterestPenaltyIsNotNull() {
			addCriterion("INTEREST_PENALTY is not null");
			return (Criteria) this;
		}

		public Criteria andInterestPenaltyEqualTo(BigDecimal value) {
			addCriterion("INTEREST_PENALTY =", value, "interestPenalty");
			return (Criteria) this;
		}

		public Criteria andInterestPenaltyNotEqualTo(BigDecimal value) {
			addCriterion("INTEREST_PENALTY <>", value, "interestPenalty");
			return (Criteria) this;
		}

		public Criteria andInterestPenaltyGreaterThan(BigDecimal value) {
			addCriterion("INTEREST_PENALTY >", value, "interestPenalty");
			return (Criteria) this;
		}

		public Criteria andInterestPenaltyGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("INTEREST_PENALTY >=", value, "interestPenalty");
			return (Criteria) this;
		}

		public Criteria andInterestPenaltyLessThan(BigDecimal value) {
			addCriterion("INTEREST_PENALTY <", value, "interestPenalty");
			return (Criteria) this;
		}

		public Criteria andInterestPenaltyLessThanOrEqualTo(BigDecimal value) {
			addCriterion("INTEREST_PENALTY <=", value, "interestPenalty");
			return (Criteria) this;
		}

		public Criteria andInterestPenaltyIn(List<BigDecimal> values) {
			addCriterion("INTEREST_PENALTY in", values, "interestPenalty");
			return (Criteria) this;
		}

		public Criteria andInterestPenaltyNotIn(List<BigDecimal> values) {
			addCriterion("INTEREST_PENALTY not in", values, "interestPenalty");
			return (Criteria) this;
		}

		public Criteria andInterestPenaltyBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("INTEREST_PENALTY between", value1, value2,
					"interestPenalty");
			return (Criteria) this;
		}

		public Criteria andInterestPenaltyNotBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("INTEREST_PENALTY not between", value1, value2,
					"interestPenalty");
			return (Criteria) this;
		}

		public Criteria andOverdueFineIsNull() {
			addCriterion("OVERDUE_FINE is null");
			return (Criteria) this;
		}

		public Criteria andOverdueFineIsNotNull() {
			addCriterion("OVERDUE_FINE is not null");
			return (Criteria) this;
		}

		public Criteria andOverdueFineEqualTo(BigDecimal value) {
			addCriterion("OVERDUE_FINE =", value, "overdueFine");
			return (Criteria) this;
		}

		public Criteria andOverdueFineNotEqualTo(BigDecimal value) {
			addCriterion("OVERDUE_FINE <>", value, "overdueFine");
			return (Criteria) this;
		}

		public Criteria andOverdueFineGreaterThan(BigDecimal value) {
			addCriterion("OVERDUE_FINE >", value, "overdueFine");
			return (Criteria) this;
		}

		public Criteria andOverdueFineGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("OVERDUE_FINE >=", value, "overdueFine");
			return (Criteria) this;
		}

		public Criteria andOverdueFineLessThan(BigDecimal value) {
			addCriterion("OVERDUE_FINE <", value, "overdueFine");
			return (Criteria) this;
		}

		public Criteria andOverdueFineLessThanOrEqualTo(BigDecimal value) {
			addCriterion("OVERDUE_FINE <=", value, "overdueFine");
			return (Criteria) this;
		}

		public Criteria andOverdueFineIn(List<BigDecimal> values) {
			addCriterion("OVERDUE_FINE in", values, "overdueFine");
			return (Criteria) this;
		}

		public Criteria andOverdueFineNotIn(List<BigDecimal> values) {
			addCriterion("OVERDUE_FINE not in", values, "overdueFine");
			return (Criteria) this;
		}

		public Criteria andOverdueFineBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("OVERDUE_FINE between", value1, value2, "overdueFine");
			return (Criteria) this;
		}

		public Criteria andOverdueFineNotBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("OVERDUE_FINE not between", value1, value2,
					"overdueFine");
			return (Criteria) this;
		}

		public Criteria andLoanInterestIsNull() {
			addCriterion("LOAN_INTEREST is null");
			return (Criteria) this;
		}

		public Criteria andLoanInterestIsNotNull() {
			addCriterion("LOAN_INTEREST is not null");
			return (Criteria) this;
		}

		public Criteria andLoanInterestEqualTo(BigDecimal value) {
			addCriterion("LOAN_INTEREST =", value, "loanInterest");
			return (Criteria) this;
		}

		public Criteria andLoanInterestNotEqualTo(BigDecimal value) {
			addCriterion("LOAN_INTEREST <>", value, "loanInterest");
			return (Criteria) this;
		}

		public Criteria andLoanInterestGreaterThan(BigDecimal value) {
			addCriterion("LOAN_INTEREST >", value, "loanInterest");
			return (Criteria) this;
		}

		public Criteria andLoanInterestGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("LOAN_INTEREST >=", value, "loanInterest");
			return (Criteria) this;
		}

		public Criteria andLoanInterestLessThan(BigDecimal value) {
			addCriterion("LOAN_INTEREST <", value, "loanInterest");
			return (Criteria) this;
		}

		public Criteria andLoanInterestLessThanOrEqualTo(BigDecimal value) {
			addCriterion("LOAN_INTEREST <=", value, "loanInterest");
			return (Criteria) this;
		}

		public Criteria andLoanInterestIn(List<BigDecimal> values) {
			addCriterion("LOAN_INTEREST in", values, "loanInterest");
			return (Criteria) this;
		}

		public Criteria andLoanInterestNotIn(List<BigDecimal> values) {
			addCriterion("LOAN_INTEREST not in", values, "loanInterest");
			return (Criteria) this;
		}

		public Criteria andLoanInterestBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("LOAN_INTEREST between", value1, value2,
					"loanInterest");
			return (Criteria) this;
		}

		public Criteria andLoanInterestNotBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("LOAN_INTEREST not between", value1, value2,
					"loanInterest");
			return (Criteria) this;
		}

		public Criteria andOfferLoanIsNull() {
			addCriterion("OFFER_LOAN is null");
			return (Criteria) this;
		}

		public Criteria andOfferLoanIsNotNull() {
			addCriterion("OFFER_LOAN is not null");
			return (Criteria) this;
		}

		public Criteria andOfferLoanEqualTo(BigDecimal value) {
			addCriterion("OFFER_LOAN =", value, "offerLoan");
			return (Criteria) this;
		}

		public Criteria andOfferLoanNotEqualTo(BigDecimal value) {
			addCriterion("OFFER_LOAN <>", value, "offerLoan");
			return (Criteria) this;
		}

		public Criteria andOfferLoanGreaterThan(BigDecimal value) {
			addCriterion("OFFER_LOAN >", value, "offerLoan");
			return (Criteria) this;
		}

		public Criteria andOfferLoanGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("OFFER_LOAN >=", value, "offerLoan");
			return (Criteria) this;
		}

		public Criteria andOfferLoanLessThan(BigDecimal value) {
			addCriterion("OFFER_LOAN <", value, "offerLoan");
			return (Criteria) this;
		}

		public Criteria andOfferLoanLessThanOrEqualTo(BigDecimal value) {
			addCriterion("OFFER_LOAN <=", value, "offerLoan");
			return (Criteria) this;
		}

		public Criteria andOfferLoanIn(List<BigDecimal> values) {
			addCriterion("OFFER_LOAN in", values, "offerLoan");
			return (Criteria) this;
		}

		public Criteria andOfferLoanNotIn(List<BigDecimal> values) {
			addCriterion("OFFER_LOAN not in", values, "offerLoan");
			return (Criteria) this;
		}

		public Criteria andOfferLoanBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("OFFER_LOAN between", value1, value2, "offerLoan");
			return (Criteria) this;
		}

		public Criteria andOfferLoanNotBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("OFFER_LOAN not between", value1, value2, "offerLoan");
			return (Criteria) this;
		}

		public Criteria andPayAmountIsNull() {
			addCriterion("PAY_AMOUNT is null");
			return (Criteria) this;
		}

		public Criteria andPayAmountIsNotNull() {
			addCriterion("PAY_AMOUNT is not null");
			return (Criteria) this;
		}

		public Criteria andPayAmountEqualTo(BigDecimal value) {
			addCriterion("PAY_AMOUNT =", value, "payAmount");
			return (Criteria) this;
		}

		public Criteria andPayAmountNotEqualTo(BigDecimal value) {
			addCriterion("PAY_AMOUNT <>", value, "payAmount");
			return (Criteria) this;
		}

		public Criteria andPayAmountGreaterThan(BigDecimal value) {
			addCriterion("PAY_AMOUNT >", value, "payAmount");
			return (Criteria) this;
		}

		public Criteria andPayAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("PAY_AMOUNT >=", value, "payAmount");
			return (Criteria) this;
		}

		public Criteria andPayAmountLessThan(BigDecimal value) {
			addCriterion("PAY_AMOUNT <", value, "payAmount");
			return (Criteria) this;
		}

		public Criteria andPayAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("PAY_AMOUNT <=", value, "payAmount");
			return (Criteria) this;
		}

		public Criteria andPayAmountIn(List<BigDecimal> values) {
			addCriterion("PAY_AMOUNT in", values, "payAmount");
			return (Criteria) this;
		}

		public Criteria andPayAmountNotIn(List<BigDecimal> values) {
			addCriterion("PAY_AMOUNT not in", values, "payAmount");
			return (Criteria) this;
		}

		public Criteria andPayAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("PAY_AMOUNT between", value1, value2, "payAmount");
			return (Criteria) this;
		}

		public Criteria andPayAmountNotBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("PAY_AMOUNT not between", value1, value2, "payAmount");
			return (Criteria) this;
		}

		public Criteria andRemainAmountIsNull() {
			addCriterion("REMAIN_AMOUNT is null");
			return (Criteria) this;
		}

		public Criteria andRemainAmountIsNotNull() {
			addCriterion("REMAIN_AMOUNT is not null");
			return (Criteria) this;
		}

		public Criteria andRemainAmountEqualTo(BigDecimal value) {
			addCriterion("REMAIN_AMOUNT =", value, "remainAmount");
			return (Criteria) this;
		}

		public Criteria andRemainAmountNotEqualTo(BigDecimal value) {
			addCriterion("REMAIN_AMOUNT <>", value, "remainAmount");
			return (Criteria) this;
		}

		public Criteria andRemainAmountGreaterThan(BigDecimal value) {
			addCriterion("REMAIN_AMOUNT >", value, "remainAmount");
			return (Criteria) this;
		}

		public Criteria andRemainAmountGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("REMAIN_AMOUNT >=", value, "remainAmount");
			return (Criteria) this;
		}

		public Criteria andRemainAmountLessThan(BigDecimal value) {
			addCriterion("REMAIN_AMOUNT <", value, "remainAmount");
			return (Criteria) this;
		}

		public Criteria andRemainAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("REMAIN_AMOUNT <=", value, "remainAmount");
			return (Criteria) this;
		}

		public Criteria andRemainAmountIn(List<BigDecimal> values) {
			addCriterion("REMAIN_AMOUNT in", values, "remainAmount");
			return (Criteria) this;
		}

		public Criteria andRemainAmountNotIn(List<BigDecimal> values) {
			addCriterion("REMAIN_AMOUNT not in", values, "remainAmount");
			return (Criteria) this;
		}

		public Criteria andRemainAmountBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("REMAIN_AMOUNT between", value1, value2,
					"remainAmount");
			return (Criteria) this;
		}

		public Criteria andRemainAmountNotBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("REMAIN_AMOUNT not between", value1, value2,
					"remainAmount");
			return (Criteria) this;
		}

		public Criteria andLoanStartTimeIsNull() {
			addCriterion("LOAN_START_TIME is null");
			return (Criteria) this;
		}

		public Criteria andLoanStartTimeIsNotNull() {
			addCriterion("LOAN_START_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andLoanStartTimeEqualTo(Date value) {
			addCriterion("LOAN_START_TIME =", value, "loanStartTime");
			return (Criteria) this;
		}

		public Criteria andLoanStartTimeNotEqualTo(Date value) {
			addCriterion("LOAN_START_TIME <>", value, "loanStartTime");
			return (Criteria) this;
		}

		public Criteria andLoanStartTimeGreaterThan(Date value) {
			addCriterion("LOAN_START_TIME >", value, "loanStartTime");
			return (Criteria) this;
		}

		public Criteria andLoanStartTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("LOAN_START_TIME >=", value, "loanStartTime");
			return (Criteria) this;
		}

		public Criteria andLoanStartTimeLessThan(Date value) {
			addCriterion("LOAN_START_TIME <", value, "loanStartTime");
			return (Criteria) this;
		}

		public Criteria andLoanStartTimeLessThanOrEqualTo(Date value) {
			addCriterion("LOAN_START_TIME <=", value, "loanStartTime");
			return (Criteria) this;
		}

		public Criteria andLoanStartTimeIn(List<Date> values) {
			addCriterion("LOAN_START_TIME in", values, "loanStartTime");
			return (Criteria) this;
		}

		public Criteria andLoanStartTimeNotIn(List<Date> values) {
			addCriterion("LOAN_START_TIME not in", values, "loanStartTime");
			return (Criteria) this;
		}

		public Criteria andLoanStartTimeBetween(Date value1, Date value2) {
			addCriterion("LOAN_START_TIME between", value1, value2,
					"loanStartTime");
			return (Criteria) this;
		}

		public Criteria andLoanStartTimeNotBetween(Date value1, Date value2) {
			addCriterion("LOAN_START_TIME not between", value1, value2,
					"loanStartTime");
			return (Criteria) this;
		}

		public Criteria andLoanFinishTimeIsNull() {
			addCriterion("LOAN_FINISH_TIME is null");
			return (Criteria) this;
		}

		public Criteria andLoanFinishTimeIsNotNull() {
			addCriterion("LOAN_FINISH_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andLoanFinishTimeEqualTo(Date value) {
			addCriterion("LOAN_FINISH_TIME =", value, "loanFinishTime");
			return (Criteria) this;
		}

		public Criteria andLoanFinishTimeNotEqualTo(Date value) {
			addCriterion("LOAN_FINISH_TIME <>", value, "loanFinishTime");
			return (Criteria) this;
		}

		public Criteria andLoanFinishTimeGreaterThan(Date value) {
			addCriterion("LOAN_FINISH_TIME >", value, "loanFinishTime");
			return (Criteria) this;
		}

		public Criteria andLoanFinishTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("LOAN_FINISH_TIME >=", value, "loanFinishTime");
			return (Criteria) this;
		}

		public Criteria andLoanFinishTimeLessThan(Date value) {
			addCriterion("LOAN_FINISH_TIME <", value, "loanFinishTime");
			return (Criteria) this;
		}

		public Criteria andLoanFinishTimeLessThanOrEqualTo(Date value) {
			addCriterion("LOAN_FINISH_TIME <=", value, "loanFinishTime");
			return (Criteria) this;
		}

		public Criteria andLoanFinishTimeIn(List<Date> values) {
			addCriterion("LOAN_FINISH_TIME in", values, "loanFinishTime");
			return (Criteria) this;
		}

		public Criteria andLoanFinishTimeNotIn(List<Date> values) {
			addCriterion("LOAN_FINISH_TIME not in", values, "loanFinishTime");
			return (Criteria) this;
		}

		public Criteria andLoanFinishTimeBetween(Date value1, Date value2) {
			addCriterion("LOAN_FINISH_TIME between", value1, value2,
					"loanFinishTime");
			return (Criteria) this;
		}

		public Criteria andLoanFinishTimeNotBetween(Date value1, Date value2) {
			addCriterion("LOAN_FINISH_TIME not between", value1, value2,
					"loanFinishTime");
			return (Criteria) this;
		}

		public Criteria andContractFileIsNull() {
			addCriterion("CONTRACT_FILE is null");
			return (Criteria) this;
		}

		public Criteria andContractFileIsNotNull() {
			addCriterion("CONTRACT_FILE is not null");
			return (Criteria) this;
		}

		public Criteria andContractFileEqualTo(String value) {
			addCriterion("CONTRACT_FILE =", value, "contractFile");
			return (Criteria) this;
		}

		public Criteria andContractFileNotEqualTo(String value) {
			addCriterion("CONTRACT_FILE <>", value, "contractFile");
			return (Criteria) this;
		}

		public Criteria andContractFileGreaterThan(String value) {
			addCriterion("CONTRACT_FILE >", value, "contractFile");
			return (Criteria) this;
		}

		public Criteria andContractFileGreaterThanOrEqualTo(String value) {
			addCriterion("CONTRACT_FILE >=", value, "contractFile");
			return (Criteria) this;
		}

		public Criteria andContractFileLessThan(String value) {
			addCriterion("CONTRACT_FILE <", value, "contractFile");
			return (Criteria) this;
		}

		public Criteria andContractFileLessThanOrEqualTo(String value) {
			addCriterion("CONTRACT_FILE <=", value, "contractFile");
			return (Criteria) this;
		}

		public Criteria andContractFileLike(String value) {
			addCriterion("CONTRACT_FILE like", value, "contractFile");
			return (Criteria) this;
		}

		public Criteria andContractFileNotLike(String value) {
			addCriterion("CONTRACT_FILE not like", value, "contractFile");
			return (Criteria) this;
		}

		public Criteria andContractFileIn(List<String> values) {
			addCriterion("CONTRACT_FILE in", values, "contractFile");
			return (Criteria) this;
		}

		public Criteria andContractFileNotIn(List<String> values) {
			addCriterion("CONTRACT_FILE not in", values, "contractFile");
			return (Criteria) this;
		}

		public Criteria andContractFileBetween(String value1, String value2) {
			addCriterion("CONTRACT_FILE between", value1, value2,
					"contractFile");
			return (Criteria) this;
		}

		public Criteria andContractFileNotBetween(String value1, String value2) {
			addCriterion("CONTRACT_FILE not between", value1, value2,
					"contractFile");
			return (Criteria) this;
		}

		public Criteria andCurrDelinquencyIsNull() {
			addCriterion("CURR_DELINQUENCY is null");
			return (Criteria) this;
		}

		public Criteria andCurrDelinquencyIsNotNull() {
			addCriterion("CURR_DELINQUENCY is not null");
			return (Criteria) this;
		}

		public Criteria andCurrDelinquencyEqualTo(Integer value) {
			addCriterion("CURR_DELINQUENCY =", value, "currDelinquency");
			return (Criteria) this;
		}

		public Criteria andCurrDelinquencyNotEqualTo(Integer value) {
			addCriterion("CURR_DELINQUENCY <>", value, "currDelinquency");
			return (Criteria) this;
		}

		public Criteria andCurrDelinquencyGreaterThan(Integer value) {
			addCriterion("CURR_DELINQUENCY >", value, "currDelinquency");
			return (Criteria) this;
		}

		public Criteria andCurrDelinquencyGreaterThanOrEqualTo(Integer value) {
			addCriterion("CURR_DELINQUENCY >=", value, "currDelinquency");
			return (Criteria) this;
		}

		public Criteria andCurrDelinquencyLessThan(Integer value) {
			addCriterion("CURR_DELINQUENCY <", value, "currDelinquency");
			return (Criteria) this;
		}

		public Criteria andCurrDelinquencyLessThanOrEqualTo(Integer value) {
			addCriterion("CURR_DELINQUENCY <=", value, "currDelinquency");
			return (Criteria) this;
		}

		public Criteria andCurrDelinquencyIn(List<Integer> values) {
			addCriterion("CURR_DELINQUENCY in", values, "currDelinquency");
			return (Criteria) this;
		}

		public Criteria andCurrDelinquencyNotIn(List<Integer> values) {
			addCriterion("CURR_DELINQUENCY not in", values, "currDelinquency");
			return (Criteria) this;
		}

		public Criteria andCurrDelinquencyBetween(Integer value1, Integer value2) {
			addCriterion("CURR_DELINQUENCY between", value1, value2,
					"currDelinquency");
			return (Criteria) this;
		}

		public Criteria andCurrDelinquencyNotBetween(Integer value1,
				Integer value2) {
			addCriterion("CURR_DELINQUENCY not between", value1, value2,
					"currDelinquency");
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

		public Criteria andOperIsNull() {
			addCriterion("OPER is null");
			return (Criteria) this;
		}

		public Criteria andOperIsNotNull() {
			addCriterion("OPER is not null");
			return (Criteria) this;
		}

		public Criteria andOperEqualTo(Long value) {
			addCriterion("OPER =", value, "oper");
			return (Criteria) this;
		}

		public Criteria andOperNotEqualTo(Long value) {
			addCriterion("OPER <>", value, "oper");
			return (Criteria) this;
		}

		public Criteria andOperGreaterThan(Long value) {
			addCriterion("OPER >", value, "oper");
			return (Criteria) this;
		}

		public Criteria andOperGreaterThanOrEqualTo(Long value) {
			addCriterion("OPER >=", value, "oper");
			return (Criteria) this;
		}

		public Criteria andOperLessThan(Long value) {
			addCriterion("OPER <", value, "oper");
			return (Criteria) this;
		}

		public Criteria andOperLessThanOrEqualTo(Long value) {
			addCriterion("OPER <=", value, "oper");
			return (Criteria) this;
		}

		public Criteria andOperIn(List<Long> values) {
			addCriterion("OPER in", values, "oper");
			return (Criteria) this;
		}

		public Criteria andOperNotIn(List<Long> values) {
			addCriterion("OPER not in", values, "oper");
			return (Criteria) this;
		}

		public Criteria andOperBetween(Long value1, Long value2) {
			addCriterion("OPER between", value1, value2, "oper");
			return (Criteria) this;
		}

		public Criteria andOperNotBetween(Long value1, Long value2) {
			addCriterion("OPER not between", value1, value2, "oper");
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
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to
	 * the database table ml_loan_info
	 * 
	 * @mbggenerated Fri Oct 31 20:20:09 GMT+08:00 2014
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
