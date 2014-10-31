package com.wealth.miniloan.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.wealth.miniloan.entity.MlAppSummaryExample.Criteria;

public class CorpAppExample {
	protected String orderByClause;
	protected boolean distinct;
	protected List<Criteria> oredCriteria;

	public CorpAppExample() {
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

		public Criteria andBorrowerIsNull() {
			addCriterion("BORROWER is null");
			return (Criteria) this;
		}

		public Criteria andBorrowerIsNotNull() {
			addCriterion("BORROWER is not null");
			return (Criteria) this;
		}

		public Criteria andBorrowerEqualTo(String value) {
			addCriterion("BORROWER =", value, "borrower");
			return (Criteria) this;
		}

		public Criteria andBorrowerNotEqualTo(String value) {
			addCriterion("BORROWER <>", value, "borrower");
			return (Criteria) this;
		}

		public Criteria andBorrowerGreaterThan(String value) {
			addCriterion("BORROWER >", value, "borrower");
			return (Criteria) this;
		}

		public Criteria andBorrowerGreaterThanOrEqualTo(String value) {
			addCriterion("BORROWER >=", value, "borrower");
			return (Criteria) this;
		}

		public Criteria andBorrowerLessThan(String value) {
			addCriterion("BORROWER <", value, "borrower");
			return (Criteria) this;
		}

		public Criteria andBorrowerLessThanOrEqualTo(String value) {
			addCriterion("BORROWER <=", value, "borrower");
			return (Criteria) this;
		}

		public Criteria andBorrowerLike(String value) {
			addCriterion("BORROWER like", value, "borrower");
			return (Criteria) this;
		}

		public Criteria andBorrowerNotLike(String value) {
			addCriterion("BORROWER not like", value, "borrower");
			return (Criteria) this;
		}

		public Criteria andBorrowerIn(List<String> values) {
			addCriterion("BORROWER in", values, "borrower");
			return (Criteria) this;
		}

		public Criteria andBorrowerNotIn(List<String> values) {
			addCriterion("BORROWER not in", values, "borrower");
			return (Criteria) this;
		}

		public Criteria andBorrowerBetween(String value1, String value2) {
			addCriterion("BORROWER between", value1, value2, "borrower");
			return (Criteria) this;
		}

		public Criteria andBorrowerNotBetween(String value1, String value2) {
			addCriterion("BORROWER not between", value1, value2, "borrower");
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

		public Criteria andLoanPeriodIsNull() {
			addCriterion("LOAN_PERIOD is null");
			return (Criteria) this;
		}

		public Criteria andLoanPeriodIsNotNull() {
			addCriterion("LOAN_PERIOD is not null");
			return (Criteria) this;
		}

		public Criteria andLoanPeriodEqualTo(Integer value) {
			addCriterion("LOAN_PERIOD =", value, "loanPeriod");
			return (Criteria) this;
		}

		public Criteria andLoanPeriodNotEqualTo(Integer value) {
			addCriterion("LOAN_PERIOD <>", value, "loanPeriod");
			return (Criteria) this;
		}

		public Criteria andLoanPeriodGreaterThan(Integer value) {
			addCriterion("LOAN_PERIOD >", value, "loanPeriod");
			return (Criteria) this;
		}

		public Criteria andLoanPeriodGreaterThanOrEqualTo(Integer value) {
			addCriterion("LOAN_PERIOD >=", value, "loanPeriod");
			return (Criteria) this;
		}

		public Criteria andLoanPeriodLessThan(Integer value) {
			addCriterion("LOAN_PERIOD <", value, "loanPeriod");
			return (Criteria) this;
		}

		public Criteria andLoanPeriodLessThanOrEqualTo(Integer value) {
			addCriterion("LOAN_PERIOD <=", value, "loanPeriod");
			return (Criteria) this;
		}

		public Criteria andLoanPeriodIn(List<Integer> values) {
			addCriterion("LOAN_PERIOD in", values, "loanPeriod");
			return (Criteria) this;
		}

		public Criteria andLoanPeriodNotIn(List<Integer> values) {
			addCriterion("LOAN_PERIOD not in", values, "loanPeriod");
			return (Criteria) this;
		}

		public Criteria andLoanPeriodBetween(Integer value1, Integer value2) {
			addCriterion("LOAN_PERIOD between", value1, value2, "loanPeriod");
			return (Criteria) this;
		}

		public Criteria andLoanPeriodNotBetween(Integer value1, Integer value2) {
			addCriterion("LOAN_PERIOD not between", value1, value2,
					"loanPeriod");
			return (Criteria) this;
		}

		public Criteria andCompNameIsNull() {
			addCriterion("COMP_NAME is null");
			return (Criteria) this;
		}

		public Criteria andCompNameIsNotNull() {
			addCriterion("COMP_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andCompNameEqualTo(String value) {
			addCriterion("COMP_NAME =", value, "compName");
			return (Criteria) this;
		}

		public Criteria andCompNameNotEqualTo(String value) {
			addCriterion("COMP_NAME <>", value, "compName");
			return (Criteria) this;
		}

		public Criteria andCompNameGreaterThan(String value) {
			addCriterion("COMP_NAME >", value, "compName");
			return (Criteria) this;
		}

		public Criteria andCompNameGreaterThanOrEqualTo(String value) {
			addCriterion("COMP_NAME >=", value, "compName");
			return (Criteria) this;
		}

		public Criteria andCompNameLessThan(String value) {
			addCriterion("COMP_NAME <", value, "compName");
			return (Criteria) this;
		}

		public Criteria andCompNameLessThanOrEqualTo(String value) {
			addCriterion("COMP_NAME <=", value, "compName");
			return (Criteria) this;
		}

		public Criteria andCompNameLike(String value) {
			addCriterion("COMP_NAME like", value, "compName");
			return (Criteria) this;
		}

		public Criteria andCompNameNotLike(String value) {
			addCriterion("COMP_NAME not like", value, "compName");
			return (Criteria) this;
		}

		public Criteria andCompNameIn(List<String> values) {
			addCriterion("COMP_NAME in", values, "compName");
			return (Criteria) this;
		}

		public Criteria andCompNameNotIn(List<String> values) {
			addCriterion("COMP_NAME not in", values, "compName");
			return (Criteria) this;
		}

		public Criteria andCompNameBetween(String value1, String value2) {
			addCriterion("COMP_NAME between", value1, value2, "compName");
			return (Criteria) this;
		}

		public Criteria andCompNameNotBetween(String value1, String value2) {
			addCriterion("COMP_NAME not between", value1, value2, "compName");
			return (Criteria) this;
		}

		public Criteria andRegAddrIsNull() {
			addCriterion("REG_ADDR is null");
			return (Criteria) this;
		}

		public Criteria andRegAddrIsNotNull() {
			addCriterion("REG_ADDR is not null");
			return (Criteria) this;
		}

		public Criteria andRegAddrEqualTo(String value) {
			addCriterion("REG_ADDR =", value, "regAddr");
			return (Criteria) this;
		}

		public Criteria andRegAddrNotEqualTo(String value) {
			addCriterion("REG_ADDR <>", value, "regAddr");
			return (Criteria) this;
		}

		public Criteria andRegAddrGreaterThan(String value) {
			addCriterion("REG_ADDR >", value, "regAddr");
			return (Criteria) this;
		}

		public Criteria andRegAddrGreaterThanOrEqualTo(String value) {
			addCriterion("REG_ADDR >=", value, "regAddr");
			return (Criteria) this;
		}

		public Criteria andRegAddrLessThan(String value) {
			addCriterion("REG_ADDR <", value, "regAddr");
			return (Criteria) this;
		}

		public Criteria andRegAddrLessThanOrEqualTo(String value) {
			addCriterion("REG_ADDR <=", value, "regAddr");
			return (Criteria) this;
		}

		public Criteria andRegAddrLike(String value) {
			addCriterion("REG_ADDR like", value, "regAddr");
			return (Criteria) this;
		}

		public Criteria andRegAddrNotLike(String value) {
			addCriterion("REG_ADDR not like", value, "regAddr");
			return (Criteria) this;
		}

		public Criteria andRegAddrIn(List<String> values) {
			addCriterion("REG_ADDR in", values, "regAddr");
			return (Criteria) this;
		}

		public Criteria andRegAddrNotIn(List<String> values) {
			addCriterion("REG_ADDR not in", values, "regAddr");
			return (Criteria) this;
		}

		public Criteria andRegAddrBetween(String value1, String value2) {
			addCriterion("REG_ADDR between", value1, value2, "regAddr");
			return (Criteria) this;
		}

		public Criteria andRegAddrNotBetween(String value1, String value2) {
			addCriterion("REG_ADDR not between", value1, value2, "regAddr");
			return (Criteria) this;
		}

		public Criteria andCompTypeIsNull() {
			addCriterion("COMP_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andCompTypeIsNotNull() {
			addCriterion("COMP_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andCompTypeEqualTo(String value) {
			addCriterion("COMP_TYPE =", value, "compType");
			return (Criteria) this;
		}

		public Criteria andCompTypeNotEqualTo(String value) {
			addCriterion("COMP_TYPE <>", value, "compType");
			return (Criteria) this;
		}

		public Criteria andCompTypeGreaterThan(String value) {
			addCriterion("COMP_TYPE >", value, "compType");
			return (Criteria) this;
		}

		public Criteria andCompTypeGreaterThanOrEqualTo(String value) {
			addCriterion("COMP_TYPE >=", value, "compType");
			return (Criteria) this;
		}

		public Criteria andCompTypeLessThan(String value) {
			addCriterion("COMP_TYPE <", value, "compType");
			return (Criteria) this;
		}

		public Criteria andCompTypeLessThanOrEqualTo(String value) {
			addCriterion("COMP_TYPE <=", value, "compType");
			return (Criteria) this;
		}

		public Criteria andCompTypeLike(String value) {
			addCriterion("COMP_TYPE like", value, "compType");
			return (Criteria) this;
		}

		public Criteria andCompTypeNotLike(String value) {
			addCriterion("COMP_TYPE not like", value, "compType");
			return (Criteria) this;
		}

		public Criteria andCompTypeIn(List<String> values) {
			addCriterion("COMP_TYPE in", values, "compType");
			return (Criteria) this;
		}

		public Criteria andCompTypeNotIn(List<String> values) {
			addCriterion("COMP_TYPE not in", values, "compType");
			return (Criteria) this;
		}

		public Criteria andCompTypeBetween(String value1, String value2) {
			addCriterion("COMP_TYPE between", value1, value2, "compType");
			return (Criteria) this;
		}

		public Criteria andCompTypeNotBetween(String value1, String value2) {
			addCriterion("COMP_TYPE not between", value1, value2, "compType");
			return (Criteria) this;
		}

		public Criteria andEstablishDateIsNull() {
			addCriterion("ESTABLISH_DATE is null");
			return (Criteria) this;
		}

		public Criteria andEstablishDateIsNotNull() {
			addCriterion("ESTABLISH_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andEstablishDateEqualTo(Date value) {
			addCriterion("ESTABLISH_DATE =", value, "establishDate");
			return (Criteria) this;
		}

		public Criteria andEstablishDateNotEqualTo(Date value) {
			addCriterion("ESTABLISH_DATE <>", value, "establishDate");
			return (Criteria) this;
		}

		public Criteria andEstablishDateGreaterThan(Date value) {
			addCriterion("ESTABLISH_DATE >", value, "establishDate");
			return (Criteria) this;
		}

		public Criteria andEstablishDateGreaterThanOrEqualTo(Date value) {
			addCriterion("ESTABLISH_DATE >=", value, "establishDate");
			return (Criteria) this;
		}

		public Criteria andEstablishDateLessThan(Date value) {
			addCriterion("ESTABLISH_DATE <", value, "establishDate");
			return (Criteria) this;
		}

		public Criteria andEstablishDateLessThanOrEqualTo(Date value) {
			addCriterion("ESTABLISH_DATE <=", value, "establishDate");
			return (Criteria) this;
		}

		public Criteria andEstablishDateIn(List<Date> values) {
			addCriterion("ESTABLISH_DATE in", values, "establishDate");
			return (Criteria) this;
		}

		public Criteria andEstablishDateNotIn(List<Date> values) {
			addCriterion("ESTABLISH_DATE not in", values, "establishDate");
			return (Criteria) this;
		}

		public Criteria andEstablishDateBetween(Date value1, Date value2) {
			addCriterion("ESTABLISH_DATE between", value1, value2,
					"establishDate");
			return (Criteria) this;
		}

		public Criteria andEstablishDateNotBetween(Date value1, Date value2) {
			addCriterion("ESTABLISH_DATE not between", value1, value2,
					"establishDate");
			return (Criteria) this;
		}

		public Criteria andLegalPersonIsNull() {
			addCriterion("LEGAL_PERSON is null");
			return (Criteria) this;
		}

		public Criteria andLegalPersonIsNotNull() {
			addCriterion("LEGAL_PERSON is not null");
			return (Criteria) this;
		}

		public Criteria andLegalPersonEqualTo(String value) {
			addCriterion("LEGAL_PERSON =", value, "legalPerson");
			return (Criteria) this;
		}

		public Criteria andLegalPersonNotEqualTo(String value) {
			addCriterion("LEGAL_PERSON <>", value, "legalPerson");
			return (Criteria) this;
		}

		public Criteria andLegalPersonGreaterThan(String value) {
			addCriterion("LEGAL_PERSON >", value, "legalPerson");
			return (Criteria) this;
		}

		public Criteria andLegalPersonGreaterThanOrEqualTo(String value) {
			addCriterion("LEGAL_PERSON >=", value, "legalPerson");
			return (Criteria) this;
		}

		public Criteria andLegalPersonLessThan(String value) {
			addCriterion("LEGAL_PERSON <", value, "legalPerson");
			return (Criteria) this;
		}

		public Criteria andLegalPersonLessThanOrEqualTo(String value) {
			addCriterion("LEGAL_PERSON <=", value, "legalPerson");
			return (Criteria) this;
		}

		public Criteria andLegalPersonLike(String value) {
			addCriterion("LEGAL_PERSON like", value, "legalPerson");
			return (Criteria) this;
		}

		public Criteria andLegalPersonNotLike(String value) {
			addCriterion("LEGAL_PERSON not like", value, "legalPerson");
			return (Criteria) this;
		}

		public Criteria andLegalPersonIn(List<String> values) {
			addCriterion("LEGAL_PERSON in", values, "legalPerson");
			return (Criteria) this;
		}

		public Criteria andLegalPersonNotIn(List<String> values) {
			addCriterion("LEGAL_PERSON not in", values, "legalPerson");
			return (Criteria) this;
		}

		public Criteria andLegalPersonBetween(String value1, String value2) {
			addCriterion("LEGAL_PERSON between", value1, value2, "legalPerson");
			return (Criteria) this;
		}

		public Criteria andLegalPersonNotBetween(String value1, String value2) {
			addCriterion("LEGAL_PERSON not between", value1, value2,
					"legalPerson");
			return (Criteria) this;
		}

		public Criteria andLpIdTypeIsNull() {
			addCriterion("LP_ID_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andLpIdTypeIsNotNull() {
			addCriterion("LP_ID_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andLpIdTypeEqualTo(String value) {
			addCriterion("LP_ID_TYPE =", value, "lpIdType");
			return (Criteria) this;
		}

		public Criteria andLpIdTypeNotEqualTo(String value) {
			addCriterion("LP_ID_TYPE <>", value, "lpIdType");
			return (Criteria) this;
		}

		public Criteria andLpIdTypeGreaterThan(String value) {
			addCriterion("LP_ID_TYPE >", value, "lpIdType");
			return (Criteria) this;
		}

		public Criteria andLpIdTypeGreaterThanOrEqualTo(String value) {
			addCriterion("LP_ID_TYPE >=", value, "lpIdType");
			return (Criteria) this;
		}

		public Criteria andLpIdTypeLessThan(String value) {
			addCriterion("LP_ID_TYPE <", value, "lpIdType");
			return (Criteria) this;
		}

		public Criteria andLpIdTypeLessThanOrEqualTo(String value) {
			addCriterion("LP_ID_TYPE <=", value, "lpIdType");
			return (Criteria) this;
		}

		public Criteria andLpIdTypeLike(String value) {
			addCriterion("LP_ID_TYPE like", value, "lpIdType");
			return (Criteria) this;
		}

		public Criteria andLpIdTypeNotLike(String value) {
			addCriterion("LP_ID_TYPE not like", value, "lpIdType");
			return (Criteria) this;
		}

		public Criteria andLpIdTypeIn(List<String> values) {
			addCriterion("LP_ID_TYPE in", values, "lpIdType");
			return (Criteria) this;
		}

		public Criteria andLpIdTypeNotIn(List<String> values) {
			addCriterion("LP_ID_TYPE not in", values, "lpIdType");
			return (Criteria) this;
		}

		public Criteria andLpIdTypeBetween(String value1, String value2) {
			addCriterion("LP_ID_TYPE between", value1, value2, "lpIdType");
			return (Criteria) this;
		}

		public Criteria andLpIdTypeNotBetween(String value1, String value2) {
			addCriterion("LP_ID_TYPE not between", value1, value2, "lpIdType");
			return (Criteria) this;
		}

		public Criteria andLpIdNoIsNull() {
			addCriterion("LP_ID_NO is null");
			return (Criteria) this;
		}

		public Criteria andLpIdNoIsNotNull() {
			addCriterion("LP_ID_NO is not null");
			return (Criteria) this;
		}

		public Criteria andLpIdNoEqualTo(String value) {
			addCriterion("LP_ID_NO =", value, "lpIdNo");
			return (Criteria) this;
		}

		public Criteria andLpIdNoNotEqualTo(String value) {
			addCriterion("LP_ID_NO <>", value, "lpIdNo");
			return (Criteria) this;
		}

		public Criteria andLpIdNoGreaterThan(String value) {
			addCriterion("LP_ID_NO >", value, "lpIdNo");
			return (Criteria) this;
		}

		public Criteria andLpIdNoGreaterThanOrEqualTo(String value) {
			addCriterion("LP_ID_NO >=", value, "lpIdNo");
			return (Criteria) this;
		}

		public Criteria andLpIdNoLessThan(String value) {
			addCriterion("LP_ID_NO <", value, "lpIdNo");
			return (Criteria) this;
		}

		public Criteria andLpIdNoLessThanOrEqualTo(String value) {
			addCriterion("LP_ID_NO <=", value, "lpIdNo");
			return (Criteria) this;
		}

		public Criteria andLpIdNoLike(String value) {
			addCriterion("LP_ID_NO like", value, "lpIdNo");
			return (Criteria) this;
		}

		public Criteria andLpIdNoNotLike(String value) {
			addCriterion("LP_ID_NO not like", value, "lpIdNo");
			return (Criteria) this;
		}

		public Criteria andLpIdNoIn(List<String> values) {
			addCriterion("LP_ID_NO in", values, "lpIdNo");
			return (Criteria) this;
		}

		public Criteria andLpIdNoNotIn(List<String> values) {
			addCriterion("LP_ID_NO not in", values, "lpIdNo");
			return (Criteria) this;
		}

		public Criteria andLpIdNoBetween(String value1, String value2) {
			addCriterion("LP_ID_NO between", value1, value2, "lpIdNo");
			return (Criteria) this;
		}

		public Criteria andLpIdNoNotBetween(String value1, String value2) {
			addCriterion("LP_ID_NO not between", value1, value2, "lpIdNo");
			return (Criteria) this;
		}

		public Criteria andLpNativeIsNull() {
			addCriterion("LP_NATIVE is null");
			return (Criteria) this;
		}

		public Criteria andLpNativeIsNotNull() {
			addCriterion("LP_NATIVE is not null");
			return (Criteria) this;
		}

		public Criteria andLpNativeEqualTo(String value) {
			addCriterion("LP_NATIVE =", value, "lpNative");
			return (Criteria) this;
		}

		public Criteria andLpNativeNotEqualTo(String value) {
			addCriterion("LP_NATIVE <>", value, "lpNative");
			return (Criteria) this;
		}

		public Criteria andLpNativeGreaterThan(String value) {
			addCriterion("LP_NATIVE >", value, "lpNative");
			return (Criteria) this;
		}

		public Criteria andLpNativeGreaterThanOrEqualTo(String value) {
			addCriterion("LP_NATIVE >=", value, "lpNative");
			return (Criteria) this;
		}

		public Criteria andLpNativeLessThan(String value) {
			addCriterion("LP_NATIVE <", value, "lpNative");
			return (Criteria) this;
		}

		public Criteria andLpNativeLessThanOrEqualTo(String value) {
			addCriterion("LP_NATIVE <=", value, "lpNative");
			return (Criteria) this;
		}

		public Criteria andLpNativeLike(String value) {
			addCriterion("LP_NATIVE like", value, "lpNative");
			return (Criteria) this;
		}

		public Criteria andLpNativeNotLike(String value) {
			addCriterion("LP_NATIVE not like", value, "lpNative");
			return (Criteria) this;
		}

		public Criteria andLpNativeIn(List<String> values) {
			addCriterion("LP_NATIVE in", values, "lpNative");
			return (Criteria) this;
		}

		public Criteria andLpNativeNotIn(List<String> values) {
			addCriterion("LP_NATIVE not in", values, "lpNative");
			return (Criteria) this;
		}

		public Criteria andLpNativeBetween(String value1, String value2) {
			addCriterion("LP_NATIVE between", value1, value2, "lpNative");
			return (Criteria) this;
		}

		public Criteria andLpNativeNotBetween(String value1, String value2) {
			addCriterion("LP_NATIVE not between", value1, value2, "lpNative");
			return (Criteria) this;
		}

		public Criteria andLpAddrIsNull() {
			addCriterion("LP_ADDR is null");
			return (Criteria) this;
		}

		public Criteria andLpAddrIsNotNull() {
			addCriterion("LP_ADDR is not null");
			return (Criteria) this;
		}

		public Criteria andLpAddrEqualTo(String value) {
			addCriterion("LP_ADDR =", value, "lpAddr");
			return (Criteria) this;
		}

		public Criteria andLpAddrNotEqualTo(String value) {
			addCriterion("LP_ADDR <>", value, "lpAddr");
			return (Criteria) this;
		}

		public Criteria andLpAddrGreaterThan(String value) {
			addCriterion("LP_ADDR >", value, "lpAddr");
			return (Criteria) this;
		}

		public Criteria andLpAddrGreaterThanOrEqualTo(String value) {
			addCriterion("LP_ADDR >=", value, "lpAddr");
			return (Criteria) this;
		}

		public Criteria andLpAddrLessThan(String value) {
			addCriterion("LP_ADDR <", value, "lpAddr");
			return (Criteria) this;
		}

		public Criteria andLpAddrLessThanOrEqualTo(String value) {
			addCriterion("LP_ADDR <=", value, "lpAddr");
			return (Criteria) this;
		}

		public Criteria andLpAddrLike(String value) {
			addCriterion("LP_ADDR like", value, "lpAddr");
			return (Criteria) this;
		}

		public Criteria andLpAddrNotLike(String value) {
			addCriterion("LP_ADDR not like", value, "lpAddr");
			return (Criteria) this;
		}

		public Criteria andLpAddrIn(List<String> values) {
			addCriterion("LP_ADDR in", values, "lpAddr");
			return (Criteria) this;
		}

		public Criteria andLpAddrNotIn(List<String> values) {
			addCriterion("LP_ADDR not in", values, "lpAddr");
			return (Criteria) this;
		}

		public Criteria andLpAddrBetween(String value1, String value2) {
			addCriterion("LP_ADDR between", value1, value2, "lpAddr");
			return (Criteria) this;
		}

		public Criteria andLpAddrNotBetween(String value1, String value2) {
			addCriterion("LP_ADDR not between", value1, value2, "lpAddr");
			return (Criteria) this;
		}

		public Criteria andBusiScopeIsNull() {
			addCriterion("BUSI_SCOPE is null");
			return (Criteria) this;
		}

		public Criteria andBusiScopeIsNotNull() {
			addCriterion("BUSI_SCOPE is not null");
			return (Criteria) this;
		}

		public Criteria andBusiScopeEqualTo(String value) {
			addCriterion("BUSI_SCOPE =", value, "busiScope");
			return (Criteria) this;
		}

		public Criteria andBusiScopeNotEqualTo(String value) {
			addCriterion("BUSI_SCOPE <>", value, "busiScope");
			return (Criteria) this;
		}

		public Criteria andBusiScopeGreaterThan(String value) {
			addCriterion("BUSI_SCOPE >", value, "busiScope");
			return (Criteria) this;
		}

		public Criteria andBusiScopeGreaterThanOrEqualTo(String value) {
			addCriterion("BUSI_SCOPE >=", value, "busiScope");
			return (Criteria) this;
		}

		public Criteria andBusiScopeLessThan(String value) {
			addCriterion("BUSI_SCOPE <", value, "busiScope");
			return (Criteria) this;
		}

		public Criteria andBusiScopeLessThanOrEqualTo(String value) {
			addCriterion("BUSI_SCOPE <=", value, "busiScope");
			return (Criteria) this;
		}

		public Criteria andBusiScopeLike(String value) {
			addCriterion("BUSI_SCOPE like", value, "busiScope");
			return (Criteria) this;
		}

		public Criteria andBusiScopeNotLike(String value) {
			addCriterion("BUSI_SCOPE not like", value, "busiScope");
			return (Criteria) this;
		}

		public Criteria andBusiScopeIn(List<String> values) {
			addCriterion("BUSI_SCOPE in", values, "busiScope");
			return (Criteria) this;
		}

		public Criteria andBusiScopeNotIn(List<String> values) {
			addCriterion("BUSI_SCOPE not in", values, "busiScope");
			return (Criteria) this;
		}

		public Criteria andBusiScopeBetween(String value1, String value2) {
			addCriterion("BUSI_SCOPE between", value1, value2, "busiScope");
			return (Criteria) this;
		}

		public Criteria andBusiScopeNotBetween(String value1, String value2) {
			addCriterion("BUSI_SCOPE not between", value1, value2, "busiScope");
			return (Criteria) this;
		}

		public Criteria andLastYearAssetsIsNull() {
			addCriterion("LAST_YEAR_ASSETS is null");
			return (Criteria) this;
		}

		public Criteria andLastYearAssetsIsNotNull() {
			addCriterion("LAST_YEAR_ASSETS is not null");
			return (Criteria) this;
		}

		public Criteria andLastYearAssetsEqualTo(BigDecimal value) {
			addCriterion("LAST_YEAR_ASSETS =", value, "lastYearAssets");
			return (Criteria) this;
		}

		public Criteria andLastYearAssetsNotEqualTo(BigDecimal value) {
			addCriterion("LAST_YEAR_ASSETS <>", value, "lastYearAssets");
			return (Criteria) this;
		}

		public Criteria andLastYearAssetsGreaterThan(BigDecimal value) {
			addCriterion("LAST_YEAR_ASSETS >", value, "lastYearAssets");
			return (Criteria) this;
		}

		public Criteria andLastYearAssetsGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("LAST_YEAR_ASSETS >=", value, "lastYearAssets");
			return (Criteria) this;
		}

		public Criteria andLastYearAssetsLessThan(BigDecimal value) {
			addCriterion("LAST_YEAR_ASSETS <", value, "lastYearAssets");
			return (Criteria) this;
		}

		public Criteria andLastYearAssetsLessThanOrEqualTo(BigDecimal value) {
			addCriterion("LAST_YEAR_ASSETS <=", value, "lastYearAssets");
			return (Criteria) this;
		}

		public Criteria andLastYearAssetsIn(List<BigDecimal> values) {
			addCriterion("LAST_YEAR_ASSETS in", values, "lastYearAssets");
			return (Criteria) this;
		}

		public Criteria andLastYearAssetsNotIn(List<BigDecimal> values) {
			addCriterion("LAST_YEAR_ASSETS not in", values, "lastYearAssets");
			return (Criteria) this;
		}

		public Criteria andLastYearAssetsBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("LAST_YEAR_ASSETS between", value1, value2,
					"lastYearAssets");
			return (Criteria) this;
		}

		public Criteria andLastYearAssetsNotBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("LAST_YEAR_ASSETS not between", value1, value2,
					"lastYearAssets");
			return (Criteria) this;
		}

		public Criteria andLastYearLiabilitiesIsNull() {
			addCriterion("LAST_YEAR_LIABILITIES is null");
			return (Criteria) this;
		}

		public Criteria andLastYearLiabilitiesIsNotNull() {
			addCriterion("LAST_YEAR_LIABILITIES is not null");
			return (Criteria) this;
		}

		public Criteria andLastYearLiabilitiesEqualTo(BigDecimal value) {
			addCriterion("LAST_YEAR_LIABILITIES =", value,
					"lastYearLiabilities");
			return (Criteria) this;
		}

		public Criteria andLastYearLiabilitiesNotEqualTo(BigDecimal value) {
			addCriterion("LAST_YEAR_LIABILITIES <>", value,
					"lastYearLiabilities");
			return (Criteria) this;
		}

		public Criteria andLastYearLiabilitiesGreaterThan(BigDecimal value) {
			addCriterion("LAST_YEAR_LIABILITIES >", value,
					"lastYearLiabilities");
			return (Criteria) this;
		}

		public Criteria andLastYearLiabilitiesGreaterThanOrEqualTo(
				BigDecimal value) {
			addCriterion("LAST_YEAR_LIABILITIES >=", value,
					"lastYearLiabilities");
			return (Criteria) this;
		}

		public Criteria andLastYearLiabilitiesLessThan(BigDecimal value) {
			addCriterion("LAST_YEAR_LIABILITIES <", value,
					"lastYearLiabilities");
			return (Criteria) this;
		}

		public Criteria andLastYearLiabilitiesLessThanOrEqualTo(BigDecimal value) {
			addCriterion("LAST_YEAR_LIABILITIES <=", value,
					"lastYearLiabilities");
			return (Criteria) this;
		}

		public Criteria andLastYearLiabilitiesIn(List<BigDecimal> values) {
			addCriterion("LAST_YEAR_LIABILITIES in", values,
					"lastYearLiabilities");
			return (Criteria) this;
		}

		public Criteria andLastYearLiabilitiesNotIn(List<BigDecimal> values) {
			addCriterion("LAST_YEAR_LIABILITIES not in", values,
					"lastYearLiabilities");
			return (Criteria) this;
		}

		public Criteria andLastYearLiabilitiesBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("LAST_YEAR_LIABILITIES between", value1, value2,
					"lastYearLiabilities");
			return (Criteria) this;
		}

		public Criteria andLastYearLiabilitiesNotBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("LAST_YEAR_LIABILITIES not between", value1, value2,
					"lastYearLiabilities");
			return (Criteria) this;
		}

		public Criteria andLastYearSalesAmountIsNull() {
			addCriterion("LAST_YEAR_SALES_AMOUNT is null");
			return (Criteria) this;
		}

		public Criteria andLastYearSalesAmountIsNotNull() {
			addCriterion("LAST_YEAR_SALES_AMOUNT is not null");
			return (Criteria) this;
		}

		public Criteria andLastYearSalesAmountEqualTo(BigDecimal value) {
			addCriterion("LAST_YEAR_SALES_AMOUNT =", value,
					"lastYearSalesAmount");
			return (Criteria) this;
		}

		public Criteria andLastYearSalesAmountNotEqualTo(BigDecimal value) {
			addCriterion("LAST_YEAR_SALES_AMOUNT <>", value,
					"lastYearSalesAmount");
			return (Criteria) this;
		}

		public Criteria andLastYearSalesAmountGreaterThan(BigDecimal value) {
			addCriterion("LAST_YEAR_SALES_AMOUNT >", value,
					"lastYearSalesAmount");
			return (Criteria) this;
		}

		public Criteria andLastYearSalesAmountGreaterThanOrEqualTo(
				BigDecimal value) {
			addCriterion("LAST_YEAR_SALES_AMOUNT >=", value,
					"lastYearSalesAmount");
			return (Criteria) this;
		}

		public Criteria andLastYearSalesAmountLessThan(BigDecimal value) {
			addCriterion("LAST_YEAR_SALES_AMOUNT <", value,
					"lastYearSalesAmount");
			return (Criteria) this;
		}

		public Criteria andLastYearSalesAmountLessThanOrEqualTo(BigDecimal value) {
			addCriterion("LAST_YEAR_SALES_AMOUNT <=", value,
					"lastYearSalesAmount");
			return (Criteria) this;
		}

		public Criteria andLastYearSalesAmountIn(List<BigDecimal> values) {
			addCriterion("LAST_YEAR_SALES_AMOUNT in", values,
					"lastYearSalesAmount");
			return (Criteria) this;
		}

		public Criteria andLastYearSalesAmountNotIn(List<BigDecimal> values) {
			addCriterion("LAST_YEAR_SALES_AMOUNT not in", values,
					"lastYearSalesAmount");
			return (Criteria) this;
		}

		public Criteria andLastYearSalesAmountBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("LAST_YEAR_SALES_AMOUNT between", value1, value2,
					"lastYearSalesAmount");
			return (Criteria) this;
		}

		public Criteria andLastYearSalesAmountNotBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("LAST_YEAR_SALES_AMOUNT not between", value1, value2,
					"lastYearSalesAmount");
			return (Criteria) this;
		}

		public Criteria andLastYearProfitIsNull() {
			addCriterion("LAST_YEAR_PROFIT is null");
			return (Criteria) this;
		}

		public Criteria andLastYearProfitIsNotNull() {
			addCriterion("LAST_YEAR_PROFIT is not null");
			return (Criteria) this;
		}

		public Criteria andLastYearProfitEqualTo(BigDecimal value) {
			addCriterion("LAST_YEAR_PROFIT =", value, "lastYearProfit");
			return (Criteria) this;
		}

		public Criteria andLastYearProfitNotEqualTo(BigDecimal value) {
			addCriterion("LAST_YEAR_PROFIT <>", value, "lastYearProfit");
			return (Criteria) this;
		}

		public Criteria andLastYearProfitGreaterThan(BigDecimal value) {
			addCriterion("LAST_YEAR_PROFIT >", value, "lastYearProfit");
			return (Criteria) this;
		}

		public Criteria andLastYearProfitGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("LAST_YEAR_PROFIT >=", value, "lastYearProfit");
			return (Criteria) this;
		}

		public Criteria andLastYearProfitLessThan(BigDecimal value) {
			addCriterion("LAST_YEAR_PROFIT <", value, "lastYearProfit");
			return (Criteria) this;
		}

		public Criteria andLastYearProfitLessThanOrEqualTo(BigDecimal value) {
			addCriterion("LAST_YEAR_PROFIT <=", value, "lastYearProfit");
			return (Criteria) this;
		}

		public Criteria andLastYearProfitIn(List<BigDecimal> values) {
			addCriterion("LAST_YEAR_PROFIT in", values, "lastYearProfit");
			return (Criteria) this;
		}

		public Criteria andLastYearProfitNotIn(List<BigDecimal> values) {
			addCriterion("LAST_YEAR_PROFIT not in", values, "lastYearProfit");
			return (Criteria) this;
		}

		public Criteria andLastYearProfitBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("LAST_YEAR_PROFIT between", value1, value2,
					"lastYearProfit");
			return (Criteria) this;
		}

		public Criteria andLastYearProfitNotBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("LAST_YEAR_PROFIT not between", value1, value2,
					"lastYearProfit");
			return (Criteria) this;
		}

		public Criteria andLastYearPayTaxIsNull() {
			addCriterion("LAST_YEAR_PAY_TAX is null");
			return (Criteria) this;
		}

		public Criteria andLastYearPayTaxIsNotNull() {
			addCriterion("LAST_YEAR_PAY_TAX is not null");
			return (Criteria) this;
		}

		public Criteria andLastYearPayTaxEqualTo(BigDecimal value) {
			addCriterion("LAST_YEAR_PAY_TAX =", value, "lastYearPayTax");
			return (Criteria) this;
		}

		public Criteria andLastYearPayTaxNotEqualTo(BigDecimal value) {
			addCriterion("LAST_YEAR_PAY_TAX <>", value, "lastYearPayTax");
			return (Criteria) this;
		}

		public Criteria andLastYearPayTaxGreaterThan(BigDecimal value) {
			addCriterion("LAST_YEAR_PAY_TAX >", value, "lastYearPayTax");
			return (Criteria) this;
		}

		public Criteria andLastYearPayTaxGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("LAST_YEAR_PAY_TAX >=", value, "lastYearPayTax");
			return (Criteria) this;
		}

		public Criteria andLastYearPayTaxLessThan(BigDecimal value) {
			addCriterion("LAST_YEAR_PAY_TAX <", value, "lastYearPayTax");
			return (Criteria) this;
		}

		public Criteria andLastYearPayTaxLessThanOrEqualTo(BigDecimal value) {
			addCriterion("LAST_YEAR_PAY_TAX <=", value, "lastYearPayTax");
			return (Criteria) this;
		}

		public Criteria andLastYearPayTaxIn(List<BigDecimal> values) {
			addCriterion("LAST_YEAR_PAY_TAX in", values, "lastYearPayTax");
			return (Criteria) this;
		}

		public Criteria andLastYearPayTaxNotIn(List<BigDecimal> values) {
			addCriterion("LAST_YEAR_PAY_TAX not in", values, "lastYearPayTax");
			return (Criteria) this;
		}

		public Criteria andLastYearPayTaxBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("LAST_YEAR_PAY_TAX between", value1, value2,
					"lastYearPayTax");
			return (Criteria) this;
		}

		public Criteria andLastYearPayTaxNotBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("LAST_YEAR_PAY_TAX not between", value1, value2,
					"lastYearPayTax");
			return (Criteria) this;
		}

		public Criteria andAvgCashFlowInSixmthIsNull() {
			addCriterion("AVG_CASH_FLOW_IN_SIXMTH is null");
			return (Criteria) this;
		}

		public Criteria andAvgCashFlowInSixmthIsNotNull() {
			addCriterion("AVG_CASH_FLOW_IN_SIXMTH is not null");
			return (Criteria) this;
		}

		public Criteria andAvgCashFlowInSixmthEqualTo(BigDecimal value) {
			addCriterion("AVG_CASH_FLOW_IN_SIXMTH =", value,
					"avgCashFlowInSixmth");
			return (Criteria) this;
		}

		public Criteria andAvgCashFlowInSixmthNotEqualTo(BigDecimal value) {
			addCriterion("AVG_CASH_FLOW_IN_SIXMTH <>", value,
					"avgCashFlowInSixmth");
			return (Criteria) this;
		}

		public Criteria andAvgCashFlowInSixmthGreaterThan(BigDecimal value) {
			addCriterion("AVG_CASH_FLOW_IN_SIXMTH >", value,
					"avgCashFlowInSixmth");
			return (Criteria) this;
		}

		public Criteria andAvgCashFlowInSixmthGreaterThanOrEqualTo(
				BigDecimal value) {
			addCriterion("AVG_CASH_FLOW_IN_SIXMTH >=", value,
					"avgCashFlowInSixmth");
			return (Criteria) this;
		}

		public Criteria andAvgCashFlowInSixmthLessThan(BigDecimal value) {
			addCriterion("AVG_CASH_FLOW_IN_SIXMTH <", value,
					"avgCashFlowInSixmth");
			return (Criteria) this;
		}

		public Criteria andAvgCashFlowInSixmthLessThanOrEqualTo(BigDecimal value) {
			addCriterion("AVG_CASH_FLOW_IN_SIXMTH <=", value,
					"avgCashFlowInSixmth");
			return (Criteria) this;
		}

		public Criteria andAvgCashFlowInSixmthIn(List<BigDecimal> values) {
			addCriterion("AVG_CASH_FLOW_IN_SIXMTH in", values,
					"avgCashFlowInSixmth");
			return (Criteria) this;
		}

		public Criteria andAvgCashFlowInSixmthNotIn(List<BigDecimal> values) {
			addCriterion("AVG_CASH_FLOW_IN_SIXMTH not in", values,
					"avgCashFlowInSixmth");
			return (Criteria) this;
		}

		public Criteria andAvgCashFlowInSixmthBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("AVG_CASH_FLOW_IN_SIXMTH between", value1, value2,
					"avgCashFlowInSixmth");
			return (Criteria) this;
		}

		public Criteria andAvgCashFlowInSixmthNotBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("AVG_CASH_FLOW_IN_SIXMTH not between", value1, value2,
					"avgCashFlowInSixmth");
			return (Criteria) this;
		}

		public Criteria andGuaranteeTypeIsNull() {
			addCriterion("GUARANTEE_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andGuaranteeTypeIsNotNull() {
			addCriterion("GUARANTEE_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andGuaranteeTypeEqualTo(String value) {
			addCriterion("GUARANTEE_TYPE =", value, "guaranteeType");
			return (Criteria) this;
		}

		public Criteria andGuaranteeTypeNotEqualTo(String value) {
			addCriterion("GUARANTEE_TYPE <>", value, "guaranteeType");
			return (Criteria) this;
		}

		public Criteria andGuaranteeTypeGreaterThan(String value) {
			addCriterion("GUARANTEE_TYPE >", value, "guaranteeType");
			return (Criteria) this;
		}

		public Criteria andGuaranteeTypeGreaterThanOrEqualTo(String value) {
			addCriterion("GUARANTEE_TYPE >=", value, "guaranteeType");
			return (Criteria) this;
		}

		public Criteria andGuaranteeTypeLessThan(String value) {
			addCriterion("GUARANTEE_TYPE <", value, "guaranteeType");
			return (Criteria) this;
		}

		public Criteria andGuaranteeTypeLessThanOrEqualTo(String value) {
			addCriterion("GUARANTEE_TYPE <=", value, "guaranteeType");
			return (Criteria) this;
		}

		public Criteria andGuaranteeTypeLike(String value) {
			addCriterion("GUARANTEE_TYPE like", value, "guaranteeType");
			return (Criteria) this;
		}

		public Criteria andGuaranteeTypeNotLike(String value) {
			addCriterion("GUARANTEE_TYPE not like", value, "guaranteeType");
			return (Criteria) this;
		}

		public Criteria andGuaranteeTypeIn(List<String> values) {
			addCriterion("GUARANTEE_TYPE in", values, "guaranteeType");
			return (Criteria) this;
		}

		public Criteria andGuaranteeTypeNotIn(List<String> values) {
			addCriterion("GUARANTEE_TYPE not in", values, "guaranteeType");
			return (Criteria) this;
		}

		public Criteria andGuaranteeTypeBetween(String value1, String value2) {
			addCriterion("GUARANTEE_TYPE between", value1, value2,
					"guaranteeType");
			return (Criteria) this;
		}

		public Criteria andGuaranteeTypeNotBetween(String value1, String value2) {
			addCriterion("GUARANTEE_TYPE not between", value1, value2,
					"guaranteeType");
			return (Criteria) this;
		}

		public Criteria andHouseTypeIsNull() {
			addCriterion("HOUSE_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andHouseTypeIsNotNull() {
			addCriterion("HOUSE_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andHouseTypeEqualTo(String value) {
			addCriterion("HOUSE_TYPE =", value, "houseType");
			return (Criteria) this;
		}

		public Criteria andHouseTypeNotEqualTo(String value) {
			addCriterion("HOUSE_TYPE <>", value, "houseType");
			return (Criteria) this;
		}

		public Criteria andHouseTypeGreaterThan(String value) {
			addCriterion("HOUSE_TYPE >", value, "houseType");
			return (Criteria) this;
		}

		public Criteria andHouseTypeGreaterThanOrEqualTo(String value) {
			addCriterion("HOUSE_TYPE >=", value, "houseType");
			return (Criteria) this;
		}

		public Criteria andHouseTypeLessThan(String value) {
			addCriterion("HOUSE_TYPE <", value, "houseType");
			return (Criteria) this;
		}

		public Criteria andHouseTypeLessThanOrEqualTo(String value) {
			addCriterion("HOUSE_TYPE <=", value, "houseType");
			return (Criteria) this;
		}

		public Criteria andHouseTypeLike(String value) {
			addCriterion("HOUSE_TYPE like", value, "houseType");
			return (Criteria) this;
		}

		public Criteria andHouseTypeNotLike(String value) {
			addCriterion("HOUSE_TYPE not like", value, "houseType");
			return (Criteria) this;
		}

		public Criteria andHouseTypeIn(List<String> values) {
			addCriterion("HOUSE_TYPE in", values, "houseType");
			return (Criteria) this;
		}

		public Criteria andHouseTypeNotIn(List<String> values) {
			addCriterion("HOUSE_TYPE not in", values, "houseType");
			return (Criteria) this;
		}

		public Criteria andHouseTypeBetween(String value1, String value2) {
			addCriterion("HOUSE_TYPE between", value1, value2, "houseType");
			return (Criteria) this;
		}

		public Criteria andHouseTypeNotBetween(String value1, String value2) {
			addCriterion("HOUSE_TYPE not between", value1, value2, "houseType");
			return (Criteria) this;
		}

		public Criteria andLandStatusIsNull() {
			addCriterion("LAND_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andLandStatusIsNotNull() {
			addCriterion("LAND_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andLandStatusEqualTo(String value) {
			addCriterion("LAND_STATUS =", value, "landStatus");
			return (Criteria) this;
		}

		public Criteria andLandStatusNotEqualTo(String value) {
			addCriterion("LAND_STATUS <>", value, "landStatus");
			return (Criteria) this;
		}

		public Criteria andLandStatusGreaterThan(String value) {
			addCriterion("LAND_STATUS >", value, "landStatus");
			return (Criteria) this;
		}

		public Criteria andLandStatusGreaterThanOrEqualTo(String value) {
			addCriterion("LAND_STATUS >=", value, "landStatus");
			return (Criteria) this;
		}

		public Criteria andLandStatusLessThan(String value) {
			addCriterion("LAND_STATUS <", value, "landStatus");
			return (Criteria) this;
		}

		public Criteria andLandStatusLessThanOrEqualTo(String value) {
			addCriterion("LAND_STATUS <=", value, "landStatus");
			return (Criteria) this;
		}

		public Criteria andLandStatusLike(String value) {
			addCriterion("LAND_STATUS like", value, "landStatus");
			return (Criteria) this;
		}

		public Criteria andLandStatusNotLike(String value) {
			addCriterion("LAND_STATUS not like", value, "landStatus");
			return (Criteria) this;
		}

		public Criteria andLandStatusIn(List<String> values) {
			addCriterion("LAND_STATUS in", values, "landStatus");
			return (Criteria) this;
		}

		public Criteria andLandStatusNotIn(List<String> values) {
			addCriterion("LAND_STATUS not in", values, "landStatus");
			return (Criteria) this;
		}

		public Criteria andLandStatusBetween(String value1, String value2) {
			addCriterion("LAND_STATUS between", value1, value2, "landStatus");
			return (Criteria) this;
		}

		public Criteria andLandStatusNotBetween(String value1, String value2) {
			addCriterion("LAND_STATUS not between", value1, value2,
					"landStatus");
			return (Criteria) this;
		}

		public Criteria andHouseLocationIsNull() {
			addCriterion("HOUSE_LOCATION is null");
			return (Criteria) this;
		}

		public Criteria andHouseLocationIsNotNull() {
			addCriterion("HOUSE_LOCATION is not null");
			return (Criteria) this;
		}

		public Criteria andHouseLocationEqualTo(String value) {
			addCriterion("HOUSE_LOCATION =", value, "houseLocation");
			return (Criteria) this;
		}

		public Criteria andHouseLocationNotEqualTo(String value) {
			addCriterion("HOUSE_LOCATION <>", value, "houseLocation");
			return (Criteria) this;
		}

		public Criteria andHouseLocationGreaterThan(String value) {
			addCriterion("HOUSE_LOCATION >", value, "houseLocation");
			return (Criteria) this;
		}

		public Criteria andHouseLocationGreaterThanOrEqualTo(String value) {
			addCriterion("HOUSE_LOCATION >=", value, "houseLocation");
			return (Criteria) this;
		}

		public Criteria andHouseLocationLessThan(String value) {
			addCriterion("HOUSE_LOCATION <", value, "houseLocation");
			return (Criteria) this;
		}

		public Criteria andHouseLocationLessThanOrEqualTo(String value) {
			addCriterion("HOUSE_LOCATION <=", value, "houseLocation");
			return (Criteria) this;
		}

		public Criteria andHouseLocationLike(String value) {
			addCriterion("HOUSE_LOCATION like", value, "houseLocation");
			return (Criteria) this;
		}

		public Criteria andHouseLocationNotLike(String value) {
			addCriterion("HOUSE_LOCATION not like", value, "houseLocation");
			return (Criteria) this;
		}

		public Criteria andHouseLocationIn(List<String> values) {
			addCriterion("HOUSE_LOCATION in", values, "houseLocation");
			return (Criteria) this;
		}

		public Criteria andHouseLocationNotIn(List<String> values) {
			addCriterion("HOUSE_LOCATION not in", values, "houseLocation");
			return (Criteria) this;
		}

		public Criteria andHouseLocationBetween(String value1, String value2) {
			addCriterion("HOUSE_LOCATION between", value1, value2,
					"houseLocation");
			return (Criteria) this;
		}

		public Criteria andHouseLocationNotBetween(String value1, String value2) {
			addCriterion("HOUSE_LOCATION not between", value1, value2,
					"houseLocation");
			return (Criteria) this;
		}

		public Criteria andHouseCertificationNoIsNull() {
			addCriterion("HOUSE_CERTIFICATION_NO is null");
			return (Criteria) this;
		}

		public Criteria andHouseCertificationNoIsNotNull() {
			addCriterion("HOUSE_CERTIFICATION_NO is not null");
			return (Criteria) this;
		}

		public Criteria andHouseCertificationNoEqualTo(String value) {
			addCriterion("HOUSE_CERTIFICATION_NO =", value,
					"houseCertificationNo");
			return (Criteria) this;
		}

		public Criteria andHouseCertificationNoNotEqualTo(String value) {
			addCriterion("HOUSE_CERTIFICATION_NO <>", value,
					"houseCertificationNo");
			return (Criteria) this;
		}

		public Criteria andHouseCertificationNoGreaterThan(String value) {
			addCriterion("HOUSE_CERTIFICATION_NO >", value,
					"houseCertificationNo");
			return (Criteria) this;
		}

		public Criteria andHouseCertificationNoGreaterThanOrEqualTo(String value) {
			addCriterion("HOUSE_CERTIFICATION_NO >=", value,
					"houseCertificationNo");
			return (Criteria) this;
		}

		public Criteria andHouseCertificationNoLessThan(String value) {
			addCriterion("HOUSE_CERTIFICATION_NO <", value,
					"houseCertificationNo");
			return (Criteria) this;
		}

		public Criteria andHouseCertificationNoLessThanOrEqualTo(String value) {
			addCriterion("HOUSE_CERTIFICATION_NO <=", value,
					"houseCertificationNo");
			return (Criteria) this;
		}

		public Criteria andHouseCertificationNoLike(String value) {
			addCriterion("HOUSE_CERTIFICATION_NO like", value,
					"houseCertificationNo");
			return (Criteria) this;
		}

		public Criteria andHouseCertificationNoNotLike(String value) {
			addCriterion("HOUSE_CERTIFICATION_NO not like", value,
					"houseCertificationNo");
			return (Criteria) this;
		}

		public Criteria andHouseCertificationNoIn(List<String> values) {
			addCriterion("HOUSE_CERTIFICATION_NO in", values,
					"houseCertificationNo");
			return (Criteria) this;
		}

		public Criteria andHouseCertificationNoNotIn(List<String> values) {
			addCriterion("HOUSE_CERTIFICATION_NO not in", values,
					"houseCertificationNo");
			return (Criteria) this;
		}

		public Criteria andHouseCertificationNoBetween(String value1,
				String value2) {
			addCriterion("HOUSE_CERTIFICATION_NO between", value1, value2,
					"houseCertificationNo");
			return (Criteria) this;
		}

		public Criteria andHouseCertificationNoNotBetween(String value1,
				String value2) {
			addCriterion("HOUSE_CERTIFICATION_NO not between", value1, value2,
					"houseCertificationNo");
			return (Criteria) this;
		}

		public Criteria andBuildingAreaIsNull() {
			addCriterion("BUILDING_AREA is null");
			return (Criteria) this;
		}

		public Criteria andBuildingAreaIsNotNull() {
			addCriterion("BUILDING_AREA is not null");
			return (Criteria) this;
		}

		public Criteria andBuildingAreaEqualTo(BigDecimal value) {
			addCriterion("BUILDING_AREA =", value, "buildingArea");
			return (Criteria) this;
		}

		public Criteria andBuildingAreaNotEqualTo(BigDecimal value) {
			addCriterion("BUILDING_AREA <>", value, "buildingArea");
			return (Criteria) this;
		}

		public Criteria andBuildingAreaGreaterThan(BigDecimal value) {
			addCriterion("BUILDING_AREA >", value, "buildingArea");
			return (Criteria) this;
		}

		public Criteria andBuildingAreaGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("BUILDING_AREA >=", value, "buildingArea");
			return (Criteria) this;
		}

		public Criteria andBuildingAreaLessThan(BigDecimal value) {
			addCriterion("BUILDING_AREA <", value, "buildingArea");
			return (Criteria) this;
		}

		public Criteria andBuildingAreaLessThanOrEqualTo(BigDecimal value) {
			addCriterion("BUILDING_AREA <=", value, "buildingArea");
			return (Criteria) this;
		}

		public Criteria andBuildingAreaIn(List<BigDecimal> values) {
			addCriterion("BUILDING_AREA in", values, "buildingArea");
			return (Criteria) this;
		}

		public Criteria andBuildingAreaNotIn(List<BigDecimal> values) {
			addCriterion("BUILDING_AREA not in", values, "buildingArea");
			return (Criteria) this;
		}

		public Criteria andBuildingAreaBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("BUILDING_AREA between", value1, value2,
					"buildingArea");
			return (Criteria) this;
		}

		public Criteria andBuildingAreaNotBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("BUILDING_AREA not between", value1, value2,
					"buildingArea");
			return (Criteria) this;
		}

		public Criteria andIsRentIsNull() {
			addCriterion("IS_RENT is null");
			return (Criteria) this;
		}

		public Criteria andIsRentIsNotNull() {
			addCriterion("IS_RENT is not null");
			return (Criteria) this;
		}

		public Criteria andIsRentEqualTo(String value) {
			addCriterion("IS_RENT =", value, "isRent");
			return (Criteria) this;
		}

		public Criteria andIsRentNotEqualTo(String value) {
			addCriterion("IS_RENT <>", value, "isRent");
			return (Criteria) this;
		}

		public Criteria andIsRentGreaterThan(String value) {
			addCriterion("IS_RENT >", value, "isRent");
			return (Criteria) this;
		}

		public Criteria andIsRentGreaterThanOrEqualTo(String value) {
			addCriterion("IS_RENT >=", value, "isRent");
			return (Criteria) this;
		}

		public Criteria andIsRentLessThan(String value) {
			addCriterion("IS_RENT <", value, "isRent");
			return (Criteria) this;
		}

		public Criteria andIsRentLessThanOrEqualTo(String value) {
			addCriterion("IS_RENT <=", value, "isRent");
			return (Criteria) this;
		}

		public Criteria andIsRentLike(String value) {
			addCriterion("IS_RENT like", value, "isRent");
			return (Criteria) this;
		}

		public Criteria andIsRentNotLike(String value) {
			addCriterion("IS_RENT not like", value, "isRent");
			return (Criteria) this;
		}

		public Criteria andIsRentIn(List<String> values) {
			addCriterion("IS_RENT in", values, "isRent");
			return (Criteria) this;
		}

		public Criteria andIsRentNotIn(List<String> values) {
			addCriterion("IS_RENT not in", values, "isRent");
			return (Criteria) this;
		}

		public Criteria andIsRentBetween(String value1, String value2) {
			addCriterion("IS_RENT between", value1, value2, "isRent");
			return (Criteria) this;
		}

		public Criteria andIsRentNotBetween(String value1, String value2) {
			addCriterion("IS_RENT not between", value1, value2, "isRent");
			return (Criteria) this;
		}

		public Criteria andMonthlyRentIsNull() {
			addCriterion("MONTHLY_RENT is null");
			return (Criteria) this;
		}

		public Criteria andMonthlyRentIsNotNull() {
			addCriterion("MONTHLY_RENT is not null");
			return (Criteria) this;
		}

		public Criteria andMonthlyRentEqualTo(BigDecimal value) {
			addCriterion("MONTHLY_RENT =", value, "monthlyRent");
			return (Criteria) this;
		}

		public Criteria andMonthlyRentNotEqualTo(BigDecimal value) {
			addCriterion("MONTHLY_RENT <>", value, "monthlyRent");
			return (Criteria) this;
		}

		public Criteria andMonthlyRentGreaterThan(BigDecimal value) {
			addCriterion("MONTHLY_RENT >", value, "monthlyRent");
			return (Criteria) this;
		}

		public Criteria andMonthlyRentGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("MONTHLY_RENT >=", value, "monthlyRent");
			return (Criteria) this;
		}

		public Criteria andMonthlyRentLessThan(BigDecimal value) {
			addCriterion("MONTHLY_RENT <", value, "monthlyRent");
			return (Criteria) this;
		}

		public Criteria andMonthlyRentLessThanOrEqualTo(BigDecimal value) {
			addCriterion("MONTHLY_RENT <=", value, "monthlyRent");
			return (Criteria) this;
		}

		public Criteria andMonthlyRentIn(List<BigDecimal> values) {
			addCriterion("MONTHLY_RENT in", values, "monthlyRent");
			return (Criteria) this;
		}

		public Criteria andMonthlyRentNotIn(List<BigDecimal> values) {
			addCriterion("MONTHLY_RENT not in", values, "monthlyRent");
			return (Criteria) this;
		}

		public Criteria andMonthlyRentBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("MONTHLY_RENT between", value1, value2, "monthlyRent");
			return (Criteria) this;
		}

		public Criteria andMonthlyRentNotBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("MONTHLY_RENT not between", value1, value2,
					"monthlyRent");
			return (Criteria) this;
		}

		public Criteria andPurchaseValueIsNull() {
			addCriterion("PURCHASE_VALUE is null");
			return (Criteria) this;
		}

		public Criteria andPurchaseValueIsNotNull() {
			addCriterion("PURCHASE_VALUE is not null");
			return (Criteria) this;
		}

		public Criteria andPurchaseValueEqualTo(BigDecimal value) {
			addCriterion("PURCHASE_VALUE =", value, "purchaseValue");
			return (Criteria) this;
		}

		public Criteria andPurchaseValueNotEqualTo(BigDecimal value) {
			addCriterion("PURCHASE_VALUE <>", value, "purchaseValue");
			return (Criteria) this;
		}

		public Criteria andPurchaseValueGreaterThan(BigDecimal value) {
			addCriterion("PURCHASE_VALUE >", value, "purchaseValue");
			return (Criteria) this;
		}

		public Criteria andPurchaseValueGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("PURCHASE_VALUE >=", value, "purchaseValue");
			return (Criteria) this;
		}

		public Criteria andPurchaseValueLessThan(BigDecimal value) {
			addCriterion("PURCHASE_VALUE <", value, "purchaseValue");
			return (Criteria) this;
		}

		public Criteria andPurchaseValueLessThanOrEqualTo(BigDecimal value) {
			addCriterion("PURCHASE_VALUE <=", value, "purchaseValue");
			return (Criteria) this;
		}

		public Criteria andPurchaseValueIn(List<BigDecimal> values) {
			addCriterion("PURCHASE_VALUE in", values, "purchaseValue");
			return (Criteria) this;
		}

		public Criteria andPurchaseValueNotIn(List<BigDecimal> values) {
			addCriterion("PURCHASE_VALUE not in", values, "purchaseValue");
			return (Criteria) this;
		}

		public Criteria andPurchaseValueBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("PURCHASE_VALUE between", value1, value2,
					"purchaseValue");
			return (Criteria) this;
		}

		public Criteria andPurchaseValueNotBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("PURCHASE_VALUE not between", value1, value2,
					"purchaseValue");
			return (Criteria) this;
		}

		public Criteria andEstimatedValueIsNull() {
			addCriterion("ESTIMATED_VALUE is null");
			return (Criteria) this;
		}

		public Criteria andEstimatedValueIsNotNull() {
			addCriterion("ESTIMATED_VALUE is not null");
			return (Criteria) this;
		}

		public Criteria andEstimatedValueEqualTo(BigDecimal value) {
			addCriterion("ESTIMATED_VALUE =", value, "estimatedValue");
			return (Criteria) this;
		}

		public Criteria andEstimatedValueNotEqualTo(BigDecimal value) {
			addCriterion("ESTIMATED_VALUE <>", value, "estimatedValue");
			return (Criteria) this;
		}

		public Criteria andEstimatedValueGreaterThan(BigDecimal value) {
			addCriterion("ESTIMATED_VALUE >", value, "estimatedValue");
			return (Criteria) this;
		}

		public Criteria andEstimatedValueGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("ESTIMATED_VALUE >=", value, "estimatedValue");
			return (Criteria) this;
		}

		public Criteria andEstimatedValueLessThan(BigDecimal value) {
			addCriterion("ESTIMATED_VALUE <", value, "estimatedValue");
			return (Criteria) this;
		}

		public Criteria andEstimatedValueLessThanOrEqualTo(BigDecimal value) {
			addCriterion("ESTIMATED_VALUE <=", value, "estimatedValue");
			return (Criteria) this;
		}

		public Criteria andEstimatedValueIn(List<BigDecimal> values) {
			addCriterion("ESTIMATED_VALUE in", values, "estimatedValue");
			return (Criteria) this;
		}

		public Criteria andEstimatedValueNotIn(List<BigDecimal> values) {
			addCriterion("ESTIMATED_VALUE not in", values, "estimatedValue");
			return (Criteria) this;
		}

		public Criteria andEstimatedValueBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("ESTIMATED_VALUE between", value1, value2,
					"estimatedValue");
			return (Criteria) this;
		}

		public Criteria andEstimatedValueNotBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("ESTIMATED_VALUE not between", value1, value2,
					"estimatedValue");
			return (Criteria) this;
		}

		public Criteria andInventoryTypeIsNull() {
			addCriterion("INVENTORY_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andInventoryTypeIsNotNull() {
			addCriterion("INVENTORY_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andInventoryTypeEqualTo(String value) {
			addCriterion("INVENTORY_TYPE =", value, "inventoryType");
			return (Criteria) this;
		}

		public Criteria andInventoryTypeNotEqualTo(String value) {
			addCriterion("INVENTORY_TYPE <>", value, "inventoryType");
			return (Criteria) this;
		}

		public Criteria andInventoryTypeGreaterThan(String value) {
			addCriterion("INVENTORY_TYPE >", value, "inventoryType");
			return (Criteria) this;
		}

		public Criteria andInventoryTypeGreaterThanOrEqualTo(String value) {
			addCriterion("INVENTORY_TYPE >=", value, "inventoryType");
			return (Criteria) this;
		}

		public Criteria andInventoryTypeLessThan(String value) {
			addCriterion("INVENTORY_TYPE <", value, "inventoryType");
			return (Criteria) this;
		}

		public Criteria andInventoryTypeLessThanOrEqualTo(String value) {
			addCriterion("INVENTORY_TYPE <=", value, "inventoryType");
			return (Criteria) this;
		}

		public Criteria andInventoryTypeLike(String value) {
			addCriterion("INVENTORY_TYPE like", value, "inventoryType");
			return (Criteria) this;
		}

		public Criteria andInventoryTypeNotLike(String value) {
			addCriterion("INVENTORY_TYPE not like", value, "inventoryType");
			return (Criteria) this;
		}

		public Criteria andInventoryTypeIn(List<String> values) {
			addCriterion("INVENTORY_TYPE in", values, "inventoryType");
			return (Criteria) this;
		}

		public Criteria andInventoryTypeNotIn(List<String> values) {
			addCriterion("INVENTORY_TYPE not in", values, "inventoryType");
			return (Criteria) this;
		}

		public Criteria andInventoryTypeBetween(String value1, String value2) {
			addCriterion("INVENTORY_TYPE between", value1, value2,
					"inventoryType");
			return (Criteria) this;
		}

		public Criteria andInventoryTypeNotBetween(String value1, String value2) {
			addCriterion("INVENTORY_TYPE not between", value1, value2,
					"inventoryType");
			return (Criteria) this;
		}

		public Criteria andStoragePlaceIsNull() {
			addCriterion("STORAGE_PLACE is null");
			return (Criteria) this;
		}

		public Criteria andStoragePlaceIsNotNull() {
			addCriterion("STORAGE_PLACE is not null");
			return (Criteria) this;
		}

		public Criteria andStoragePlaceEqualTo(String value) {
			addCriterion("STORAGE_PLACE =", value, "storagePlace");
			return (Criteria) this;
		}

		public Criteria andStoragePlaceNotEqualTo(String value) {
			addCriterion("STORAGE_PLACE <>", value, "storagePlace");
			return (Criteria) this;
		}

		public Criteria andStoragePlaceGreaterThan(String value) {
			addCriterion("STORAGE_PLACE >", value, "storagePlace");
			return (Criteria) this;
		}

		public Criteria andStoragePlaceGreaterThanOrEqualTo(String value) {
			addCriterion("STORAGE_PLACE >=", value, "storagePlace");
			return (Criteria) this;
		}

		public Criteria andStoragePlaceLessThan(String value) {
			addCriterion("STORAGE_PLACE <", value, "storagePlace");
			return (Criteria) this;
		}

		public Criteria andStoragePlaceLessThanOrEqualTo(String value) {
			addCriterion("STORAGE_PLACE <=", value, "storagePlace");
			return (Criteria) this;
		}

		public Criteria andStoragePlaceLike(String value) {
			addCriterion("STORAGE_PLACE like", value, "storagePlace");
			return (Criteria) this;
		}

		public Criteria andStoragePlaceNotLike(String value) {
			addCriterion("STORAGE_PLACE not like", value, "storagePlace");
			return (Criteria) this;
		}

		public Criteria andStoragePlaceIn(List<String> values) {
			addCriterion("STORAGE_PLACE in", values, "storagePlace");
			return (Criteria) this;
		}

		public Criteria andStoragePlaceNotIn(List<String> values) {
			addCriterion("STORAGE_PLACE not in", values, "storagePlace");
			return (Criteria) this;
		}

		public Criteria andStoragePlaceBetween(String value1, String value2) {
			addCriterion("STORAGE_PLACE between", value1, value2,
					"storagePlace");
			return (Criteria) this;
		}

		public Criteria andStoragePlaceNotBetween(String value1, String value2) {
			addCriterion("STORAGE_PLACE not between", value1, value2,
					"storagePlace");
			return (Criteria) this;
		}

		public Criteria andHasContractIsNull() {
			addCriterion("HAS_CONTRACT is null");
			return (Criteria) this;
		}

		public Criteria andHasContractIsNotNull() {
			addCriterion("HAS_CONTRACT is not null");
			return (Criteria) this;
		}

		public Criteria andHasContractEqualTo(String value) {
			addCriterion("HAS_CONTRACT =", value, "hasContract");
			return (Criteria) this;
		}

		public Criteria andHasContractNotEqualTo(String value) {
			addCriterion("HAS_CONTRACT <>", value, "hasContract");
			return (Criteria) this;
		}

		public Criteria andHasContractGreaterThan(String value) {
			addCriterion("HAS_CONTRACT >", value, "hasContract");
			return (Criteria) this;
		}

		public Criteria andHasContractGreaterThanOrEqualTo(String value) {
			addCriterion("HAS_CONTRACT >=", value, "hasContract");
			return (Criteria) this;
		}

		public Criteria andHasContractLessThan(String value) {
			addCriterion("HAS_CONTRACT <", value, "hasContract");
			return (Criteria) this;
		}

		public Criteria andHasContractLessThanOrEqualTo(String value) {
			addCriterion("HAS_CONTRACT <=", value, "hasContract");
			return (Criteria) this;
		}

		public Criteria andHasContractLike(String value) {
			addCriterion("HAS_CONTRACT like", value, "hasContract");
			return (Criteria) this;
		}

		public Criteria andHasContractNotLike(String value) {
			addCriterion("HAS_CONTRACT not like", value, "hasContract");
			return (Criteria) this;
		}

		public Criteria andHasContractIn(List<String> values) {
			addCriterion("HAS_CONTRACT in", values, "hasContract");
			return (Criteria) this;
		}

		public Criteria andHasContractNotIn(List<String> values) {
			addCriterion("HAS_CONTRACT not in", values, "hasContract");
			return (Criteria) this;
		}

		public Criteria andHasContractBetween(String value1, String value2) {
			addCriterion("HAS_CONTRACT between", value1, value2, "hasContract");
			return (Criteria) this;
		}

		public Criteria andHasContractNotBetween(String value1, String value2) {
			addCriterion("HAS_CONTRACT not between", value1, value2,
					"hasContract");
			return (Criteria) this;
		}

		public Criteria andUnitIsNull() {
			addCriterion("UNIT is null");
			return (Criteria) this;
		}

		public Criteria andUnitIsNotNull() {
			addCriterion("UNIT is not null");
			return (Criteria) this;
		}

		public Criteria andUnitEqualTo(String value) {
			addCriterion("UNIT =", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitNotEqualTo(String value) {
			addCriterion("UNIT <>", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitGreaterThan(String value) {
			addCriterion("UNIT >", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitGreaterThanOrEqualTo(String value) {
			addCriterion("UNIT >=", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitLessThan(String value) {
			addCriterion("UNIT <", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitLessThanOrEqualTo(String value) {
			addCriterion("UNIT <=", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitLike(String value) {
			addCriterion("UNIT like", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitNotLike(String value) {
			addCriterion("UNIT not like", value, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitIn(List<String> values) {
			addCriterion("UNIT in", values, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitNotIn(List<String> values) {
			addCriterion("UNIT not in", values, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitBetween(String value1, String value2) {
			addCriterion("UNIT between", value1, value2, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitNotBetween(String value1, String value2) {
			addCriterion("UNIT not between", value1, value2, "unit");
			return (Criteria) this;
		}

		public Criteria andUnitPriceIsNull() {
			addCriterion("UNIT_PRICE is null");
			return (Criteria) this;
		}

		public Criteria andUnitPriceIsNotNull() {
			addCriterion("UNIT_PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andUnitPriceEqualTo(BigDecimal value) {
			addCriterion("UNIT_PRICE =", value, "unitPrice");
			return (Criteria) this;
		}

		public Criteria andUnitPriceNotEqualTo(BigDecimal value) {
			addCriterion("UNIT_PRICE <>", value, "unitPrice");
			return (Criteria) this;
		}

		public Criteria andUnitPriceGreaterThan(BigDecimal value) {
			addCriterion("UNIT_PRICE >", value, "unitPrice");
			return (Criteria) this;
		}

		public Criteria andUnitPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("UNIT_PRICE >=", value, "unitPrice");
			return (Criteria) this;
		}

		public Criteria andUnitPriceLessThan(BigDecimal value) {
			addCriterion("UNIT_PRICE <", value, "unitPrice");
			return (Criteria) this;
		}

		public Criteria andUnitPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("UNIT_PRICE <=", value, "unitPrice");
			return (Criteria) this;
		}

		public Criteria andUnitPriceIn(List<BigDecimal> values) {
			addCriterion("UNIT_PRICE in", values, "unitPrice");
			return (Criteria) this;
		}

		public Criteria andUnitPriceNotIn(List<BigDecimal> values) {
			addCriterion("UNIT_PRICE not in", values, "unitPrice");
			return (Criteria) this;
		}

		public Criteria andUnitPriceBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("UNIT_PRICE between", value1, value2, "unitPrice");
			return (Criteria) this;
		}

		public Criteria andUnitPriceNotBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("UNIT_PRICE not between", value1, value2, "unitPrice");
			return (Criteria) this;
		}

		public Criteria andMarketPriceIsNull() {
			addCriterion("MARKET_PRICE is null");
			return (Criteria) this;
		}

		public Criteria andMarketPriceIsNotNull() {
			addCriterion("MARKET_PRICE is not null");
			return (Criteria) this;
		}

		public Criteria andMarketPriceEqualTo(BigDecimal value) {
			addCriterion("MARKET_PRICE =", value, "marketPrice");
			return (Criteria) this;
		}

		public Criteria andMarketPriceNotEqualTo(BigDecimal value) {
			addCriterion("MARKET_PRICE <>", value, "marketPrice");
			return (Criteria) this;
		}

		public Criteria andMarketPriceGreaterThan(BigDecimal value) {
			addCriterion("MARKET_PRICE >", value, "marketPrice");
			return (Criteria) this;
		}

		public Criteria andMarketPriceGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("MARKET_PRICE >=", value, "marketPrice");
			return (Criteria) this;
		}

		public Criteria andMarketPriceLessThan(BigDecimal value) {
			addCriterion("MARKET_PRICE <", value, "marketPrice");
			return (Criteria) this;
		}

		public Criteria andMarketPriceLessThanOrEqualTo(BigDecimal value) {
			addCriterion("MARKET_PRICE <=", value, "marketPrice");
			return (Criteria) this;
		}

		public Criteria andMarketPriceIn(List<BigDecimal> values) {
			addCriterion("MARKET_PRICE in", values, "marketPrice");
			return (Criteria) this;
		}

		public Criteria andMarketPriceNotIn(List<BigDecimal> values) {
			addCriterion("MARKET_PRICE not in", values, "marketPrice");
			return (Criteria) this;
		}

		public Criteria andMarketPriceBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("MARKET_PRICE between", value1, value2, "marketPrice");
			return (Criteria) this;
		}

		public Criteria andMarketPriceNotBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("MARKET_PRICE not between", value1, value2,
					"marketPrice");
			return (Criteria) this;
		}

		public Criteria andRepertoryIsNull() {
			addCriterion("REPERTORY is null");
			return (Criteria) this;
		}

		public Criteria andRepertoryIsNotNull() {
			addCriterion("REPERTORY is not null");
			return (Criteria) this;
		}

		public Criteria andRepertoryEqualTo(Integer value) {
			addCriterion("REPERTORY =", value, "repertory");
			return (Criteria) this;
		}

		public Criteria andRepertoryNotEqualTo(Integer value) {
			addCriterion("REPERTORY <>", value, "repertory");
			return (Criteria) this;
		}

		public Criteria andRepertoryGreaterThan(Integer value) {
			addCriterion("REPERTORY >", value, "repertory");
			return (Criteria) this;
		}

		public Criteria andRepertoryGreaterThanOrEqualTo(Integer value) {
			addCriterion("REPERTORY >=", value, "repertory");
			return (Criteria) this;
		}

		public Criteria andRepertoryLessThan(Integer value) {
			addCriterion("REPERTORY <", value, "repertory");
			return (Criteria) this;
		}

		public Criteria andRepertoryLessThanOrEqualTo(Integer value) {
			addCriterion("REPERTORY <=", value, "repertory");
			return (Criteria) this;
		}

		public Criteria andRepertoryIn(List<Integer> values) {
			addCriterion("REPERTORY in", values, "repertory");
			return (Criteria) this;
		}

		public Criteria andRepertoryNotIn(List<Integer> values) {
			addCriterion("REPERTORY not in", values, "repertory");
			return (Criteria) this;
		}

		public Criteria andRepertoryBetween(Integer value1, Integer value2) {
			addCriterion("REPERTORY between", value1, value2, "repertory");
			return (Criteria) this;
		}

		public Criteria andRepertoryNotBetween(Integer value1, Integer value2) {
			addCriterion("REPERTORY not between", value1, value2, "repertory");
			return (Criteria) this;
		}

		public Criteria andLowestRepertoryLastYearIsNull() {
			addCriterion("LOWEST_REPERTORY_LAST_YEAR is null");
			return (Criteria) this;
		}

		public Criteria andLowestRepertoryLastYearIsNotNull() {
			addCriterion("LOWEST_REPERTORY_LAST_YEAR is not null");
			return (Criteria) this;
		}

		public Criteria andLowestRepertoryLastYearEqualTo(Integer value) {
			addCriterion("LOWEST_REPERTORY_LAST_YEAR =", value,
					"lowestRepertoryLastYear");
			return (Criteria) this;
		}

		public Criteria andLowestRepertoryLastYearNotEqualTo(Integer value) {
			addCriterion("LOWEST_REPERTORY_LAST_YEAR <>", value,
					"lowestRepertoryLastYear");
			return (Criteria) this;
		}

		public Criteria andLowestRepertoryLastYearGreaterThan(Integer value) {
			addCriterion("LOWEST_REPERTORY_LAST_YEAR >", value,
					"lowestRepertoryLastYear");
			return (Criteria) this;
		}

		public Criteria andLowestRepertoryLastYearGreaterThanOrEqualTo(
				Integer value) {
			addCriterion("LOWEST_REPERTORY_LAST_YEAR >=", value,
					"lowestRepertoryLastYear");
			return (Criteria) this;
		}

		public Criteria andLowestRepertoryLastYearLessThan(Integer value) {
			addCriterion("LOWEST_REPERTORY_LAST_YEAR <", value,
					"lowestRepertoryLastYear");
			return (Criteria) this;
		}

		public Criteria andLowestRepertoryLastYearLessThanOrEqualTo(
				Integer value) {
			addCriterion("LOWEST_REPERTORY_LAST_YEAR <=", value,
					"lowestRepertoryLastYear");
			return (Criteria) this;
		}

		public Criteria andLowestRepertoryLastYearIn(List<Integer> values) {
			addCriterion("LOWEST_REPERTORY_LAST_YEAR in", values,
					"lowestRepertoryLastYear");
			return (Criteria) this;
		}

		public Criteria andLowestRepertoryLastYearNotIn(List<Integer> values) {
			addCriterion("LOWEST_REPERTORY_LAST_YEAR not in", values,
					"lowestRepertoryLastYear");
			return (Criteria) this;
		}

		public Criteria andLowestRepertoryLastYearBetween(Integer value1,
				Integer value2) {
			addCriterion("LOWEST_REPERTORY_LAST_YEAR between", value1, value2,
					"lowestRepertoryLastYear");
			return (Criteria) this;
		}

		public Criteria andLowestRepertoryLastYearNotBetween(Integer value1,
				Integer value2) {
			addCriterion("LOWEST_REPERTORY_LAST_YEAR not between", value1,
					value2, "lowestRepertoryLastYear");
			return (Criteria) this;
		}

		public Criteria andHasSpecialStorageRequireIsNull() {
			addCriterion("HAS_SPECIAL_STORAGE_REQUIRE is null");
			return (Criteria) this;
		}

		public Criteria andHasSpecialStorageRequireIsNotNull() {
			addCriterion("HAS_SPECIAL_STORAGE_REQUIRE is not null");
			return (Criteria) this;
		}

		public Criteria andHasSpecialStorageRequireEqualTo(String value) {
			addCriterion("HAS_SPECIAL_STORAGE_REQUIRE =", value,
					"hasSpecialStorageRequire");
			return (Criteria) this;
		}

		public Criteria andHasSpecialStorageRequireNotEqualTo(String value) {
			addCriterion("HAS_SPECIAL_STORAGE_REQUIRE <>", value,
					"hasSpecialStorageRequire");
			return (Criteria) this;
		}

		public Criteria andHasSpecialStorageRequireGreaterThan(String value) {
			addCriterion("HAS_SPECIAL_STORAGE_REQUIRE >", value,
					"hasSpecialStorageRequire");
			return (Criteria) this;
		}

		public Criteria andHasSpecialStorageRequireGreaterThanOrEqualTo(
				String value) {
			addCriterion("HAS_SPECIAL_STORAGE_REQUIRE >=", value,
					"hasSpecialStorageRequire");
			return (Criteria) this;
		}

		public Criteria andHasSpecialStorageRequireLessThan(String value) {
			addCriterion("HAS_SPECIAL_STORAGE_REQUIRE <", value,
					"hasSpecialStorageRequire");
			return (Criteria) this;
		}

		public Criteria andHasSpecialStorageRequireLessThanOrEqualTo(
				String value) {
			addCriterion("HAS_SPECIAL_STORAGE_REQUIRE <=", value,
					"hasSpecialStorageRequire");
			return (Criteria) this;
		}

		public Criteria andHasSpecialStorageRequireLike(String value) {
			addCriterion("HAS_SPECIAL_STORAGE_REQUIRE like", value,
					"hasSpecialStorageRequire");
			return (Criteria) this;
		}

		public Criteria andHasSpecialStorageRequireNotLike(String value) {
			addCriterion("HAS_SPECIAL_STORAGE_REQUIRE not like", value,
					"hasSpecialStorageRequire");
			return (Criteria) this;
		}

		public Criteria andHasSpecialStorageRequireIn(List<String> values) {
			addCriterion("HAS_SPECIAL_STORAGE_REQUIRE in", values,
					"hasSpecialStorageRequire");
			return (Criteria) this;
		}

		public Criteria andHasSpecialStorageRequireNotIn(List<String> values) {
			addCriterion("HAS_SPECIAL_STORAGE_REQUIRE not in", values,
					"hasSpecialStorageRequire");
			return (Criteria) this;
		}

		public Criteria andHasSpecialStorageRequireBetween(String value1,
				String value2) {
			addCriterion("HAS_SPECIAL_STORAGE_REQUIRE between", value1, value2,
					"hasSpecialStorageRequire");
			return (Criteria) this;
		}

		public Criteria andHasSpecialStorageRequireNotBetween(String value1,
				String value2) {
			addCriterion("HAS_SPECIAL_STORAGE_REQUIRE not between", value1,
					value2, "hasSpecialStorageRequire");
			return (Criteria) this;
		}

		public Criteria andEnsureCompNameIsNull() {
			addCriterion("ENSURE_COMP_NAME is null");
			return (Criteria) this;
		}

		public Criteria andEnsureCompNameIsNotNull() {
			addCriterion("ENSURE_COMP_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andEnsureCompNameEqualTo(String value) {
			addCriterion("ENSURE_COMP_NAME =", value, "ensureCompName");
			return (Criteria) this;
		}

		public Criteria andEnsureCompNameNotEqualTo(String value) {
			addCriterion("ENSURE_COMP_NAME <>", value, "ensureCompName");
			return (Criteria) this;
		}

		public Criteria andEnsureCompNameGreaterThan(String value) {
			addCriterion("ENSURE_COMP_NAME >", value, "ensureCompName");
			return (Criteria) this;
		}

		public Criteria andEnsureCompNameGreaterThanOrEqualTo(String value) {
			addCriterion("ENSURE_COMP_NAME >=", value, "ensureCompName");
			return (Criteria) this;
		}

		public Criteria andEnsureCompNameLessThan(String value) {
			addCriterion("ENSURE_COMP_NAME <", value, "ensureCompName");
			return (Criteria) this;
		}

		public Criteria andEnsureCompNameLessThanOrEqualTo(String value) {
			addCriterion("ENSURE_COMP_NAME <=", value, "ensureCompName");
			return (Criteria) this;
		}

		public Criteria andEnsureCompNameLike(String value) {
			addCriterion("ENSURE_COMP_NAME like", value, "ensureCompName");
			return (Criteria) this;
		}

		public Criteria andEnsureCompNameNotLike(String value) {
			addCriterion("ENSURE_COMP_NAME not like", value, "ensureCompName");
			return (Criteria) this;
		}

		public Criteria andEnsureCompNameIn(List<String> values) {
			addCriterion("ENSURE_COMP_NAME in", values, "ensureCompName");
			return (Criteria) this;
		}

		public Criteria andEnsureCompNameNotIn(List<String> values) {
			addCriterion("ENSURE_COMP_NAME not in", values, "ensureCompName");
			return (Criteria) this;
		}

		public Criteria andEnsureCompNameBetween(String value1, String value2) {
			addCriterion("ENSURE_COMP_NAME between", value1, value2,
					"ensureCompName");
			return (Criteria) this;
		}

		public Criteria andEnsureCompNameNotBetween(String value1, String value2) {
			addCriterion("ENSURE_COMP_NAME not between", value1, value2,
					"ensureCompName");
			return (Criteria) this;
		}

		public Criteria andEnsureCompRegCapitalIsNull() {
			addCriterion("ENSURE_COMP_REG_CAPITAL is null");
			return (Criteria) this;
		}

		public Criteria andEnsureCompRegCapitalIsNotNull() {
			addCriterion("ENSURE_COMP_REG_CAPITAL is not null");
			return (Criteria) this;
		}

		public Criteria andEnsureCompRegCapitalEqualTo(BigDecimal value) {
			addCriterion("ENSURE_COMP_REG_CAPITAL =", value,
					"ensureCompRegCapital");
			return (Criteria) this;
		}

		public Criteria andEnsureCompRegCapitalNotEqualTo(BigDecimal value) {
			addCriterion("ENSURE_COMP_REG_CAPITAL <>", value,
					"ensureCompRegCapital");
			return (Criteria) this;
		}

		public Criteria andEnsureCompRegCapitalGreaterThan(BigDecimal value) {
			addCriterion("ENSURE_COMP_REG_CAPITAL >", value,
					"ensureCompRegCapital");
			return (Criteria) this;
		}

		public Criteria andEnsureCompRegCapitalGreaterThanOrEqualTo(
				BigDecimal value) {
			addCriterion("ENSURE_COMP_REG_CAPITAL >=", value,
					"ensureCompRegCapital");
			return (Criteria) this;
		}

		public Criteria andEnsureCompRegCapitalLessThan(BigDecimal value) {
			addCriterion("ENSURE_COMP_REG_CAPITAL <", value,
					"ensureCompRegCapital");
			return (Criteria) this;
		}

		public Criteria andEnsureCompRegCapitalLessThanOrEqualTo(
				BigDecimal value) {
			addCriterion("ENSURE_COMP_REG_CAPITAL <=", value,
					"ensureCompRegCapital");
			return (Criteria) this;
		}

		public Criteria andEnsureCompRegCapitalIn(List<BigDecimal> values) {
			addCriterion("ENSURE_COMP_REG_CAPITAL in", values,
					"ensureCompRegCapital");
			return (Criteria) this;
		}

		public Criteria andEnsureCompRegCapitalNotIn(List<BigDecimal> values) {
			addCriterion("ENSURE_COMP_REG_CAPITAL not in", values,
					"ensureCompRegCapital");
			return (Criteria) this;
		}

		public Criteria andEnsureCompRegCapitalBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("ENSURE_COMP_REG_CAPITAL between", value1, value2,
					"ensureCompRegCapital");
			return (Criteria) this;
		}

		public Criteria andEnsureCompRegCapitalNotBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("ENSURE_COMP_REG_CAPITAL not between", value1, value2,
					"ensureCompRegCapital");
			return (Criteria) this;
		}

		public Criteria andEnsureCompAssetsIsNull() {
			addCriterion("ENSURE_COMP_ASSETS is null");
			return (Criteria) this;
		}

		public Criteria andEnsureCompAssetsIsNotNull() {
			addCriterion("ENSURE_COMP_ASSETS is not null");
			return (Criteria) this;
		}

		public Criteria andEnsureCompAssetsEqualTo(BigDecimal value) {
			addCriterion("ENSURE_COMP_ASSETS =", value, "ensureCompAssets");
			return (Criteria) this;
		}

		public Criteria andEnsureCompAssetsNotEqualTo(BigDecimal value) {
			addCriterion("ENSURE_COMP_ASSETS <>", value, "ensureCompAssets");
			return (Criteria) this;
		}

		public Criteria andEnsureCompAssetsGreaterThan(BigDecimal value) {
			addCriterion("ENSURE_COMP_ASSETS >", value, "ensureCompAssets");
			return (Criteria) this;
		}

		public Criteria andEnsureCompAssetsGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("ENSURE_COMP_ASSETS >=", value, "ensureCompAssets");
			return (Criteria) this;
		}

		public Criteria andEnsureCompAssetsLessThan(BigDecimal value) {
			addCriterion("ENSURE_COMP_ASSETS <", value, "ensureCompAssets");
			return (Criteria) this;
		}

		public Criteria andEnsureCompAssetsLessThanOrEqualTo(BigDecimal value) {
			addCriterion("ENSURE_COMP_ASSETS <=", value, "ensureCompAssets");
			return (Criteria) this;
		}

		public Criteria andEnsureCompAssetsIn(List<BigDecimal> values) {
			addCriterion("ENSURE_COMP_ASSETS in", values, "ensureCompAssets");
			return (Criteria) this;
		}

		public Criteria andEnsureCompAssetsNotIn(List<BigDecimal> values) {
			addCriterion("ENSURE_COMP_ASSETS not in", values,
					"ensureCompAssets");
			return (Criteria) this;
		}

		public Criteria andEnsureCompAssetsBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("ENSURE_COMP_ASSETS between", value1, value2,
					"ensureCompAssets");
			return (Criteria) this;
		}

		public Criteria andEnsureCompAssetsNotBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("ENSURE_COMP_ASSETS not between", value1, value2,
					"ensureCompAssets");
			return (Criteria) this;
		}

		public Criteria andEnsureCompNetAssetsIsNull() {
			addCriterion("ENSURE_COMP_NET_ASSETS is null");
			return (Criteria) this;
		}

		public Criteria andEnsureCompNetAssetsIsNotNull() {
			addCriterion("ENSURE_COMP_NET_ASSETS is not null");
			return (Criteria) this;
		}

		public Criteria andEnsureCompNetAssetsEqualTo(BigDecimal value) {
			addCriterion("ENSURE_COMP_NET_ASSETS =", value,
					"ensureCompNetAssets");
			return (Criteria) this;
		}

		public Criteria andEnsureCompNetAssetsNotEqualTo(BigDecimal value) {
			addCriterion("ENSURE_COMP_NET_ASSETS <>", value,
					"ensureCompNetAssets");
			return (Criteria) this;
		}

		public Criteria andEnsureCompNetAssetsGreaterThan(BigDecimal value) {
			addCriterion("ENSURE_COMP_NET_ASSETS >", value,
					"ensureCompNetAssets");
			return (Criteria) this;
		}

		public Criteria andEnsureCompNetAssetsGreaterThanOrEqualTo(
				BigDecimal value) {
			addCriterion("ENSURE_COMP_NET_ASSETS >=", value,
					"ensureCompNetAssets");
			return (Criteria) this;
		}

		public Criteria andEnsureCompNetAssetsLessThan(BigDecimal value) {
			addCriterion("ENSURE_COMP_NET_ASSETS <", value,
					"ensureCompNetAssets");
			return (Criteria) this;
		}

		public Criteria andEnsureCompNetAssetsLessThanOrEqualTo(BigDecimal value) {
			addCriterion("ENSURE_COMP_NET_ASSETS <=", value,
					"ensureCompNetAssets");
			return (Criteria) this;
		}

		public Criteria andEnsureCompNetAssetsIn(List<BigDecimal> values) {
			addCriterion("ENSURE_COMP_NET_ASSETS in", values,
					"ensureCompNetAssets");
			return (Criteria) this;
		}

		public Criteria andEnsureCompNetAssetsNotIn(List<BigDecimal> values) {
			addCriterion("ENSURE_COMP_NET_ASSETS not in", values,
					"ensureCompNetAssets");
			return (Criteria) this;
		}

		public Criteria andEnsureCompNetAssetsBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("ENSURE_COMP_NET_ASSETS between", value1, value2,
					"ensureCompNetAssets");
			return (Criteria) this;
		}

		public Criteria andEnsureCompNetAssetsNotBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("ENSURE_COMP_NET_ASSETS not between", value1, value2,
					"ensureCompNetAssets");
			return (Criteria) this;
		}

		public Criteria andGuarantorIsNull() {
			addCriterion("GUARANTOR is null");
			return (Criteria) this;
		}

		public Criteria andGuarantorIsNotNull() {
			addCriterion("GUARANTOR is not null");
			return (Criteria) this;
		}

		public Criteria andGuarantorEqualTo(String value) {
			addCriterion("GUARANTOR =", value, "guarantor");
			return (Criteria) this;
		}

		public Criteria andGuarantorNotEqualTo(String value) {
			addCriterion("GUARANTOR <>", value, "guarantor");
			return (Criteria) this;
		}

		public Criteria andGuarantorGreaterThan(String value) {
			addCriterion("GUARANTOR >", value, "guarantor");
			return (Criteria) this;
		}

		public Criteria andGuarantorGreaterThanOrEqualTo(String value) {
			addCriterion("GUARANTOR >=", value, "guarantor");
			return (Criteria) this;
		}

		public Criteria andGuarantorLessThan(String value) {
			addCriterion("GUARANTOR <", value, "guarantor");
			return (Criteria) this;
		}

		public Criteria andGuarantorLessThanOrEqualTo(String value) {
			addCriterion("GUARANTOR <=", value, "guarantor");
			return (Criteria) this;
		}

		public Criteria andGuarantorLike(String value) {
			addCriterion("GUARANTOR like", value, "guarantor");
			return (Criteria) this;
		}

		public Criteria andGuarantorNotLike(String value) {
			addCriterion("GUARANTOR not like", value, "guarantor");
			return (Criteria) this;
		}

		public Criteria andGuarantorIn(List<String> values) {
			addCriterion("GUARANTOR in", values, "guarantor");
			return (Criteria) this;
		}

		public Criteria andGuarantorNotIn(List<String> values) {
			addCriterion("GUARANTOR not in", values, "guarantor");
			return (Criteria) this;
		}

		public Criteria andGuarantorBetween(String value1, String value2) {
			addCriterion("GUARANTOR between", value1, value2, "guarantor");
			return (Criteria) this;
		}

		public Criteria andGuarantorNotBetween(String value1, String value2) {
			addCriterion("GUARANTOR not between", value1, value2, "guarantor");
			return (Criteria) this;
		}

		public Criteria andGuarantorIdTypeIsNull() {
			addCriterion("GUARANTOR_ID_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andGuarantorIdTypeIsNotNull() {
			addCriterion("GUARANTOR_ID_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andGuarantorIdTypeEqualTo(String value) {
			addCriterion("GUARANTOR_ID_TYPE =", value, "guarantorIdType");
			return (Criteria) this;
		}

		public Criteria andGuarantorIdTypeNotEqualTo(String value) {
			addCriterion("GUARANTOR_ID_TYPE <>", value, "guarantorIdType");
			return (Criteria) this;
		}

		public Criteria andGuarantorIdTypeGreaterThan(String value) {
			addCriterion("GUARANTOR_ID_TYPE >", value, "guarantorIdType");
			return (Criteria) this;
		}

		public Criteria andGuarantorIdTypeGreaterThanOrEqualTo(String value) {
			addCriterion("GUARANTOR_ID_TYPE >=", value, "guarantorIdType");
			return (Criteria) this;
		}

		public Criteria andGuarantorIdTypeLessThan(String value) {
			addCriterion("GUARANTOR_ID_TYPE <", value, "guarantorIdType");
			return (Criteria) this;
		}

		public Criteria andGuarantorIdTypeLessThanOrEqualTo(String value) {
			addCriterion("GUARANTOR_ID_TYPE <=", value, "guarantorIdType");
			return (Criteria) this;
		}

		public Criteria andGuarantorIdTypeLike(String value) {
			addCriterion("GUARANTOR_ID_TYPE like", value, "guarantorIdType");
			return (Criteria) this;
		}

		public Criteria andGuarantorIdTypeNotLike(String value) {
			addCriterion("GUARANTOR_ID_TYPE not like", value, "guarantorIdType");
			return (Criteria) this;
		}

		public Criteria andGuarantorIdTypeIn(List<String> values) {
			addCriterion("GUARANTOR_ID_TYPE in", values, "guarantorIdType");
			return (Criteria) this;
		}

		public Criteria andGuarantorIdTypeNotIn(List<String> values) {
			addCriterion("GUARANTOR_ID_TYPE not in", values, "guarantorIdType");
			return (Criteria) this;
		}

		public Criteria andGuarantorIdTypeBetween(String value1, String value2) {
			addCriterion("GUARANTOR_ID_TYPE between", value1, value2,
					"guarantorIdType");
			return (Criteria) this;
		}

		public Criteria andGuarantorIdTypeNotBetween(String value1,
				String value2) {
			addCriterion("GUARANTOR_ID_TYPE not between", value1, value2,
					"guarantorIdType");
			return (Criteria) this;
		}

		public Criteria andGuarantorIdNoIsNull() {
			addCriterion("GUARANTOR_ID_NO is null");
			return (Criteria) this;
		}

		public Criteria andGuarantorIdNoIsNotNull() {
			addCriterion("GUARANTOR_ID_NO is not null");
			return (Criteria) this;
		}

		public Criteria andGuarantorIdNoEqualTo(String value) {
			addCriterion("GUARANTOR_ID_NO =", value, "guarantorIdNo");
			return (Criteria) this;
		}

		public Criteria andGuarantorIdNoNotEqualTo(String value) {
			addCriterion("GUARANTOR_ID_NO <>", value, "guarantorIdNo");
			return (Criteria) this;
		}

		public Criteria andGuarantorIdNoGreaterThan(String value) {
			addCriterion("GUARANTOR_ID_NO >", value, "guarantorIdNo");
			return (Criteria) this;
		}

		public Criteria andGuarantorIdNoGreaterThanOrEqualTo(String value) {
			addCriterion("GUARANTOR_ID_NO >=", value, "guarantorIdNo");
			return (Criteria) this;
		}

		public Criteria andGuarantorIdNoLessThan(String value) {
			addCriterion("GUARANTOR_ID_NO <", value, "guarantorIdNo");
			return (Criteria) this;
		}

		public Criteria andGuarantorIdNoLessThanOrEqualTo(String value) {
			addCriterion("GUARANTOR_ID_NO <=", value, "guarantorIdNo");
			return (Criteria) this;
		}

		public Criteria andGuarantorIdNoLike(String value) {
			addCriterion("GUARANTOR_ID_NO like", value, "guarantorIdNo");
			return (Criteria) this;
		}

		public Criteria andGuarantorIdNoNotLike(String value) {
			addCriterion("GUARANTOR_ID_NO not like", value, "guarantorIdNo");
			return (Criteria) this;
		}

		public Criteria andGuarantorIdNoIn(List<String> values) {
			addCriterion("GUARANTOR_ID_NO in", values, "guarantorIdNo");
			return (Criteria) this;
		}

		public Criteria andGuarantorIdNoNotIn(List<String> values) {
			addCriterion("GUARANTOR_ID_NO not in", values, "guarantorIdNo");
			return (Criteria) this;
		}

		public Criteria andGuarantorIdNoBetween(String value1, String value2) {
			addCriterion("GUARANTOR_ID_NO between", value1, value2,
					"guarantorIdNo");
			return (Criteria) this;
		}

		public Criteria andGuarantorIdNoNotBetween(String value1, String value2) {
			addCriterion("GUARANTOR_ID_NO not between", value1, value2,
					"guarantorIdNo");
			return (Criteria) this;
		}

		public Criteria andGuarantorNationIsNull() {
			addCriterion("GUARANTOR_NATION is null");
			return (Criteria) this;
		}

		public Criteria andGuarantorNationIsNotNull() {
			addCriterion("GUARANTOR_NATION is not null");
			return (Criteria) this;
		}

		public Criteria andGuarantorNationEqualTo(String value) {
			addCriterion("GUARANTOR_NATION =", value, "guarantorNation");
			return (Criteria) this;
		}

		public Criteria andGuarantorNationNotEqualTo(String value) {
			addCriterion("GUARANTOR_NATION <>", value, "guarantorNation");
			return (Criteria) this;
		}

		public Criteria andGuarantorNationGreaterThan(String value) {
			addCriterion("GUARANTOR_NATION >", value, "guarantorNation");
			return (Criteria) this;
		}

		public Criteria andGuarantorNationGreaterThanOrEqualTo(String value) {
			addCriterion("GUARANTOR_NATION >=", value, "guarantorNation");
			return (Criteria) this;
		}

		public Criteria andGuarantorNationLessThan(String value) {
			addCriterion("GUARANTOR_NATION <", value, "guarantorNation");
			return (Criteria) this;
		}

		public Criteria andGuarantorNationLessThanOrEqualTo(String value) {
			addCriterion("GUARANTOR_NATION <=", value, "guarantorNation");
			return (Criteria) this;
		}

		public Criteria andGuarantorNationLike(String value) {
			addCriterion("GUARANTOR_NATION like", value, "guarantorNation");
			return (Criteria) this;
		}

		public Criteria andGuarantorNationNotLike(String value) {
			addCriterion("GUARANTOR_NATION not like", value, "guarantorNation");
			return (Criteria) this;
		}

		public Criteria andGuarantorNationIn(List<String> values) {
			addCriterion("GUARANTOR_NATION in", values, "guarantorNation");
			return (Criteria) this;
		}

		public Criteria andGuarantorNationNotIn(List<String> values) {
			addCriterion("GUARANTOR_NATION not in", values, "guarantorNation");
			return (Criteria) this;
		}

		public Criteria andGuarantorNationBetween(String value1, String value2) {
			addCriterion("GUARANTOR_NATION between", value1, value2,
					"guarantorNation");
			return (Criteria) this;
		}

		public Criteria andGuarantorNationNotBetween(String value1,
				String value2) {
			addCriterion("GUARANTOR_NATION not between", value1, value2,
					"guarantorNation");
			return (Criteria) this;
		}

		public Criteria andGuarantorHomeAddrIsNull() {
			addCriterion("GUARANTOR_HOME_ADDR is null");
			return (Criteria) this;
		}

		public Criteria andGuarantorHomeAddrIsNotNull() {
			addCriterion("GUARANTOR_HOME_ADDR is not null");
			return (Criteria) this;
		}

		public Criteria andGuarantorHomeAddrEqualTo(String value) {
			addCriterion("GUARANTOR_HOME_ADDR =", value, "guarantorHomeAddr");
			return (Criteria) this;
		}

		public Criteria andGuarantorHomeAddrNotEqualTo(String value) {
			addCriterion("GUARANTOR_HOME_ADDR <>", value, "guarantorHomeAddr");
			return (Criteria) this;
		}

		public Criteria andGuarantorHomeAddrGreaterThan(String value) {
			addCriterion("GUARANTOR_HOME_ADDR >", value, "guarantorHomeAddr");
			return (Criteria) this;
		}

		public Criteria andGuarantorHomeAddrGreaterThanOrEqualTo(String value) {
			addCriterion("GUARANTOR_HOME_ADDR >=", value, "guarantorHomeAddr");
			return (Criteria) this;
		}

		public Criteria andGuarantorHomeAddrLessThan(String value) {
			addCriterion("GUARANTOR_HOME_ADDR <", value, "guarantorHomeAddr");
			return (Criteria) this;
		}

		public Criteria andGuarantorHomeAddrLessThanOrEqualTo(String value) {
			addCriterion("GUARANTOR_HOME_ADDR <=", value, "guarantorHomeAddr");
			return (Criteria) this;
		}

		public Criteria andGuarantorHomeAddrLike(String value) {
			addCriterion("GUARANTOR_HOME_ADDR like", value, "guarantorHomeAddr");
			return (Criteria) this;
		}

		public Criteria andGuarantorHomeAddrNotLike(String value) {
			addCriterion("GUARANTOR_HOME_ADDR not like", value,
					"guarantorHomeAddr");
			return (Criteria) this;
		}

		public Criteria andGuarantorHomeAddrIn(List<String> values) {
			addCriterion("GUARANTOR_HOME_ADDR in", values, "guarantorHomeAddr");
			return (Criteria) this;
		}

		public Criteria andGuarantorHomeAddrNotIn(List<String> values) {
			addCriterion("GUARANTOR_HOME_ADDR not in", values,
					"guarantorHomeAddr");
			return (Criteria) this;
		}

		public Criteria andGuarantorHomeAddrBetween(String value1, String value2) {
			addCriterion("GUARANTOR_HOME_ADDR between", value1, value2,
					"guarantorHomeAddr");
			return (Criteria) this;
		}

		public Criteria andGuarantorHomeAddrNotBetween(String value1,
				String value2) {
			addCriterion("GUARANTOR_HOME_ADDR not between", value1, value2,
					"guarantorHomeAddr");
			return (Criteria) this;
		}

		public Criteria andLoanUseIsNull() {
			addCriterion("LOAN_USE is null");
			return (Criteria) this;
		}

		public Criteria andLoanUseIsNotNull() {
			addCriterion("LOAN_USE is not null");
			return (Criteria) this;
		}

		public Criteria andLoanUseEqualTo(String value) {
			addCriterion("LOAN_USE =", value, "loanUse");
			return (Criteria) this;
		}

		public Criteria andLoanUseNotEqualTo(String value) {
			addCriterion("LOAN_USE <>", value, "loanUse");
			return (Criteria) this;
		}

		public Criteria andLoanUseGreaterThan(String value) {
			addCriterion("LOAN_USE >", value, "loanUse");
			return (Criteria) this;
		}

		public Criteria andLoanUseGreaterThanOrEqualTo(String value) {
			addCriterion("LOAN_USE >=", value, "loanUse");
			return (Criteria) this;
		}

		public Criteria andLoanUseLessThan(String value) {
			addCriterion("LOAN_USE <", value, "loanUse");
			return (Criteria) this;
		}

		public Criteria andLoanUseLessThanOrEqualTo(String value) {
			addCriterion("LOAN_USE <=", value, "loanUse");
			return (Criteria) this;
		}

		public Criteria andLoanUseLike(String value) {
			addCriterion("LOAN_USE like", value, "loanUse");
			return (Criteria) this;
		}

		public Criteria andLoanUseNotLike(String value) {
			addCriterion("LOAN_USE not like", value, "loanUse");
			return (Criteria) this;
		}

		public Criteria andLoanUseIn(List<String> values) {
			addCriterion("LOAN_USE in", values, "loanUse");
			return (Criteria) this;
		}

		public Criteria andLoanUseNotIn(List<String> values) {
			addCriterion("LOAN_USE not in", values, "loanUse");
			return (Criteria) this;
		}

		public Criteria andLoanUseBetween(String value1, String value2) {
			addCriterion("LOAN_USE between", value1, value2, "loanUse");
			return (Criteria) this;
		}

		public Criteria andLoanUseNotBetween(String value1, String value2) {
			addCriterion("LOAN_USE not between", value1, value2, "loanUse");
			return (Criteria) this;
		}

		public Criteria andLoanProductIsNull() {
			addCriterion("LOAN_PRODUCT is null");
			return (Criteria) this;
		}

		public Criteria andLoanProductIsNotNull() {
			addCriterion("LOAN_PRODUCT is not null");
			return (Criteria) this;
		}

		public Criteria andLoanProductEqualTo(String value) {
			addCriterion("LOAN_PRODUCT =", value, "loanProduct");
			return (Criteria) this;
		}

		public Criteria andLoanProductNotEqualTo(String value) {
			addCriterion("LOAN_PRODUCT <>", value, "loanProduct");
			return (Criteria) this;
		}

		public Criteria andLoanProductGreaterThan(String value) {
			addCriterion("LOAN_PRODUCT >", value, "loanProduct");
			return (Criteria) this;
		}

		public Criteria andLoanProductGreaterThanOrEqualTo(String value) {
			addCriterion("LOAN_PRODUCT >=", value, "loanProduct");
			return (Criteria) this;
		}

		public Criteria andLoanProductLessThan(String value) {
			addCriterion("LOAN_PRODUCT <", value, "loanProduct");
			return (Criteria) this;
		}

		public Criteria andLoanProductLessThanOrEqualTo(String value) {
			addCriterion("LOAN_PRODUCT <=", value, "loanProduct");
			return (Criteria) this;
		}

		public Criteria andLoanProductLike(String value) {
			addCriterion("LOAN_PRODUCT like", value, "loanProduct");
			return (Criteria) this;
		}

		public Criteria andLoanProductNotLike(String value) {
			addCriterion("LOAN_PRODUCT not like", value, "loanProduct");
			return (Criteria) this;
		}

		public Criteria andLoanProductIn(List<String> values) {
			addCriterion("LOAN_PRODUCT in", values, "loanProduct");
			return (Criteria) this;
		}

		public Criteria andLoanProductNotIn(List<String> values) {
			addCriterion("LOAN_PRODUCT not in", values, "loanProduct");
			return (Criteria) this;
		}

		public Criteria andLoanProductBetween(String value1, String value2) {
			addCriterion("LOAN_PRODUCT between", value1, value2, "loanProduct");
			return (Criteria) this;
		}

		public Criteria andLoanProductNotBetween(String value1, String value2) {
			addCriterion("LOAN_PRODUCT not between", value1, value2,
					"loanProduct");
			return (Criteria) this;
		}

		public Criteria andLoanAmount2IsNull() {
			addCriterion("LOAN_AMOUNT2 is null");
			return (Criteria) this;
		}

		public Criteria andLoanAmount2IsNotNull() {
			addCriterion("LOAN_AMOUNT2 is not null");
			return (Criteria) this;
		}

		public Criteria andLoanAmount2EqualTo(BigDecimal value) {
			addCriterion("LOAN_AMOUNT2 =", value, "loanAmount2");
			return (Criteria) this;
		}

		public Criteria andLoanAmount2NotEqualTo(BigDecimal value) {
			addCriterion("LOAN_AMOUNT2 <>", value, "loanAmount2");
			return (Criteria) this;
		}

		public Criteria andLoanAmount2GreaterThan(BigDecimal value) {
			addCriterion("LOAN_AMOUNT2 >", value, "loanAmount2");
			return (Criteria) this;
		}

		public Criteria andLoanAmount2GreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("LOAN_AMOUNT2 >=", value, "loanAmount2");
			return (Criteria) this;
		}

		public Criteria andLoanAmount2LessThan(BigDecimal value) {
			addCriterion("LOAN_AMOUNT2 <", value, "loanAmount2");
			return (Criteria) this;
		}

		public Criteria andLoanAmount2LessThanOrEqualTo(BigDecimal value) {
			addCriterion("LOAN_AMOUNT2 <=", value, "loanAmount2");
			return (Criteria) this;
		}

		public Criteria andLoanAmount2In(List<BigDecimal> values) {
			addCriterion("LOAN_AMOUNT2 in", values, "loanAmount2");
			return (Criteria) this;
		}

		public Criteria andLoanAmount2NotIn(List<BigDecimal> values) {
			addCriterion("LOAN_AMOUNT2 not in", values, "loanAmount2");
			return (Criteria) this;
		}

		public Criteria andLoanAmount2Between(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("LOAN_AMOUNT2 between", value1, value2, "loanAmount2");
			return (Criteria) this;
		}

		public Criteria andLoanAmount2NotBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("LOAN_AMOUNT2 not between", value1, value2,
					"loanAmount2");
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

		public Criteria andLendAccountIsNull() {
			addCriterion("LEND_ACCOUNT is null");
			return (Criteria) this;
		}

		public Criteria andLendAccountIsNotNull() {
			addCriterion("LEND_ACCOUNT is not null");
			return (Criteria) this;
		}

		public Criteria andLendAccountEqualTo(String value) {
			addCriterion("LEND_ACCOUNT =", value, "lendAccount");
			return (Criteria) this;
		}

		public Criteria andLendAccountNotEqualTo(String value) {
			addCriterion("LEND_ACCOUNT <>", value, "lendAccount");
			return (Criteria) this;
		}

		public Criteria andLendAccountGreaterThan(String value) {
			addCriterion("LEND_ACCOUNT >", value, "lendAccount");
			return (Criteria) this;
		}

		public Criteria andLendAccountGreaterThanOrEqualTo(String value) {
			addCriterion("LEND_ACCOUNT >=", value, "lendAccount");
			return (Criteria) this;
		}

		public Criteria andLendAccountLessThan(String value) {
			addCriterion("LEND_ACCOUNT <", value, "lendAccount");
			return (Criteria) this;
		}

		public Criteria andLendAccountLessThanOrEqualTo(String value) {
			addCriterion("LEND_ACCOUNT <=", value, "lendAccount");
			return (Criteria) this;
		}

		public Criteria andLendAccountLike(String value) {
			addCriterion("LEND_ACCOUNT like", value, "lendAccount");
			return (Criteria) this;
		}

		public Criteria andLendAccountNotLike(String value) {
			addCriterion("LEND_ACCOUNT not like", value, "lendAccount");
			return (Criteria) this;
		}

		public Criteria andLendAccountIn(List<String> values) {
			addCriterion("LEND_ACCOUNT in", values, "lendAccount");
			return (Criteria) this;
		}

		public Criteria andLendAccountNotIn(List<String> values) {
			addCriterion("LEND_ACCOUNT not in", values, "lendAccount");
			return (Criteria) this;
		}

		public Criteria andLendAccountBetween(String value1, String value2) {
			addCriterion("LEND_ACCOUNT between", value1, value2, "lendAccount");
			return (Criteria) this;
		}

		public Criteria andLendAccountNotBetween(String value1, String value2) {
			addCriterion("LEND_ACCOUNT not between", value1, value2,
					"lendAccount");
			return (Criteria) this;
		}

		public Criteria andPayAccountIsNull() {
			addCriterion("PAY_ACCOUNT is null");
			return (Criteria) this;
		}

		public Criteria andPayAccountIsNotNull() {
			addCriterion("PAY_ACCOUNT is not null");
			return (Criteria) this;
		}

		public Criteria andPayAccountEqualTo(String value) {
			addCriterion("PAY_ACCOUNT =", value, "payAccount");
			return (Criteria) this;
		}

		public Criteria andPayAccountNotEqualTo(String value) {
			addCriterion("PAY_ACCOUNT <>", value, "payAccount");
			return (Criteria) this;
		}

		public Criteria andPayAccountGreaterThan(String value) {
			addCriterion("PAY_ACCOUNT >", value, "payAccount");
			return (Criteria) this;
		}

		public Criteria andPayAccountGreaterThanOrEqualTo(String value) {
			addCriterion("PAY_ACCOUNT >=", value, "payAccount");
			return (Criteria) this;
		}

		public Criteria andPayAccountLessThan(String value) {
			addCriterion("PAY_ACCOUNT <", value, "payAccount");
			return (Criteria) this;
		}

		public Criteria andPayAccountLessThanOrEqualTo(String value) {
			addCriterion("PAY_ACCOUNT <=", value, "payAccount");
			return (Criteria) this;
		}

		public Criteria andPayAccountLike(String value) {
			addCriterion("PAY_ACCOUNT like", value, "payAccount");
			return (Criteria) this;
		}

		public Criteria andPayAccountNotLike(String value) {
			addCriterion("PAY_ACCOUNT not like", value, "payAccount");
			return (Criteria) this;
		}

		public Criteria andPayAccountIn(List<String> values) {
			addCriterion("PAY_ACCOUNT in", values, "payAccount");
			return (Criteria) this;
		}

		public Criteria andPayAccountNotIn(List<String> values) {
			addCriterion("PAY_ACCOUNT not in", values, "payAccount");
			return (Criteria) this;
		}

		public Criteria andPayAccountBetween(String value1, String value2) {
			addCriterion("PAY_ACCOUNT between", value1, value2, "payAccount");
			return (Criteria) this;
		}

		public Criteria andPayAccountNotBetween(String value1, String value2) {
			addCriterion("PAY_ACCOUNT not between", value1, value2,
					"payAccount");
			return (Criteria) this;
		}

		public Criteria andOperatorIsNull() {
			addCriterion("OPERATOR is null");
			return (Criteria) this;
		}

		public Criteria andOperatorIsNotNull() {
			addCriterion("OPERATOR is not null");
			return (Criteria) this;
		}

		public Criteria andOperatorEqualTo(Long value) {
			addCriterion("OPERATOR =", value, "operator");
			return (Criteria) this;
		}

		public Criteria andOperatorNotEqualTo(Long value) {
			addCriterion("OPERATOR <>", value, "operator");
			return (Criteria) this;
		}

		public Criteria andOperatorGreaterThan(Long value) {
			addCriterion("OPERATOR >", value, "operator");
			return (Criteria) this;
		}

		public Criteria andOperatorGreaterThanOrEqualTo(Long value) {
			addCriterion("OPERATOR >=", value, "operator");
			return (Criteria) this;
		}

		public Criteria andOperatorLessThan(Long value) {
			addCriterion("OPERATOR <", value, "operator");
			return (Criteria) this;
		}

		public Criteria andOperatorLessThanOrEqualTo(Long value) {
			addCriterion("OPERATOR <=", value, "operator");
			return (Criteria) this;
		}

		public Criteria andOperatorIn(List<Long> values) {
			addCriterion("OPERATOR in", values, "operator");
			return (Criteria) this;
		}

		public Criteria andOperatorNotIn(List<Long> values) {
			addCriterion("OPERATOR not in", values, "operator");
			return (Criteria) this;
		}

		public Criteria andOperatorBetween(Long value1, Long value2) {
			addCriterion("OPERATOR between", value1, value2, "operator");
			return (Criteria) this;
		}

		public Criteria andOperatorNotBetween(Long value1, Long value2) {
			addCriterion("OPERATOR not between", value1, value2, "operator");
			return (Criteria) this;
		}

		public Criteria andOpTimeIsNull() {
			addCriterion("OP_TIME is null");
			return (Criteria) this;
		}

		public Criteria andOpTimeIsNotNull() {
			addCriterion("OP_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andOpTimeEqualTo(Date value) {
			addCriterion("OP_TIME =", value, "opTime");
			return (Criteria) this;
		}

		public Criteria andOpTimeNotEqualTo(Date value) {
			addCriterion("OP_TIME <>", value, "opTime");
			return (Criteria) this;
		}

		public Criteria andOpTimeGreaterThan(Date value) {
			addCriterion("OP_TIME >", value, "opTime");
			return (Criteria) this;
		}

		public Criteria andOpTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("OP_TIME >=", value, "opTime");
			return (Criteria) this;
		}

		public Criteria andOpTimeLessThan(Date value) {
			addCriterion("OP_TIME <", value, "opTime");
			return (Criteria) this;
		}

		public Criteria andOpTimeLessThanOrEqualTo(Date value) {
			addCriterion("OP_TIME <=", value, "opTime");
			return (Criteria) this;
		}

		public Criteria andOpTimeIn(List<Date> values) {
			addCriterion("OP_TIME in", values, "opTime");
			return (Criteria) this;
		}

		public Criteria andOpTimeNotIn(List<Date> values) {
			addCriterion("OP_TIME not in", values, "opTime");
			return (Criteria) this;
		}

		public Criteria andOpTimeBetween(Date value1, Date value2) {
			addCriterion("OP_TIME between", value1, value2, "opTime");
			return (Criteria) this;
		}

		public Criteria andOpTimeNotBetween(Date value1, Date value2) {
			addCriterion("OP_TIME not between", value1, value2, "opTime");
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