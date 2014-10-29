package com.wealth.miniloan.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class NaturalAppExample {
	protected String orderByClause;
	protected boolean distinct;
	protected List<Criteria> oredCriteria;

	public NaturalAppExample() {
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

		protected void addCriterion(String condition, Object value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1, Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			criteria.add(new Criterion(condition, value1, value2));
		}

		protected void addCriterionForJDBCDate(String condition, Date value, String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value.getTime()), property);
		}

		protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property + " cannot be null or empty");
			}
			List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
			Iterator<Date> iter = values.iterator();
			while (iter.hasNext()) {
				dateList.add(new java.sql.Date(iter.next().getTime()));
			}
			addCriterion(condition, dateList, property);
		}

		protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property + " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

		public Criteria andIdTypeIsNull() {
			addCriterion("ID_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andIdTypeIsNotNull() {
			addCriterion("ID_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andIdTypeEqualTo(String value) {
			addCriterion("ID_TYPE =", value, "idType");
			return (Criteria) this;
		}

		public Criteria andIdTypeNotEqualTo(String value) {
			addCriterion("ID_TYPE <>", value, "idType");
			return (Criteria) this;
		}

		public Criteria andIdTypeGreaterThan(String value) {
			addCriterion("ID_TYPE >", value, "idType");
			return (Criteria) this;
		}

		public Criteria andIdTypeGreaterThanOrEqualTo(String value) {
			addCriterion("ID_TYPE >=", value, "idType");
			return (Criteria) this;
		}

		public Criteria andIdTypeLessThan(String value) {
			addCriterion("ID_TYPE <", value, "idType");
			return (Criteria) this;
		}

		public Criteria andIdTypeLessThanOrEqualTo(String value) {
			addCriterion("ID_TYPE <=", value, "idType");
			return (Criteria) this;
		}

		public Criteria andIdTypeLike(String value) {
			addCriterion("ID_TYPE like", value, "idType");
			return (Criteria) this;
		}

		public Criteria andIdTypeNotLike(String value) {
			addCriterion("ID_TYPE not like", value, "idType");
			return (Criteria) this;
		}

		public Criteria andIdTypeIn(List<String> values) {
			addCriterion("ID_TYPE in", values, "idType");
			return (Criteria) this;
		}

		public Criteria andIdTypeNotIn(List<String> values) {
			addCriterion("ID_TYPE not in", values, "idType");
			return (Criteria) this;
		}

		public Criteria andIdTypeBetween(String value1, String value2) {
			addCriterion("ID_TYPE between", value1, value2, "idType");
			return (Criteria) this;
		}

		public Criteria andIdTypeNotBetween(String value1, String value2) {
			addCriterion("ID_TYPE not between", value1, value2, "idType");
			return (Criteria) this;
		}

		public Criteria andIdNoIsNull() {
			addCriterion("ID_NO is null");
			return (Criteria) this;
		}

		public Criteria andIdNoIsNotNull() {
			addCriterion("ID_NO is not null");
			return (Criteria) this;
		}

		public Criteria andIdNoEqualTo(String value) {
			addCriterion("ID_NO =", value, "idNo");
			return (Criteria) this;
		}

		public Criteria andIdNoNotEqualTo(String value) {
			addCriterion("ID_NO <>", value, "idNo");
			return (Criteria) this;
		}

		public Criteria andIdNoGreaterThan(String value) {
			addCriterion("ID_NO >", value, "idNo");
			return (Criteria) this;
		}

		public Criteria andIdNoGreaterThanOrEqualTo(String value) {
			addCriterion("ID_NO >=", value, "idNo");
			return (Criteria) this;
		}

		public Criteria andIdNoLessThan(String value) {
			addCriterion("ID_NO <", value, "idNo");
			return (Criteria) this;
		}

		public Criteria andIdNoLessThanOrEqualTo(String value) {
			addCriterion("ID_NO <=", value, "idNo");
			return (Criteria) this;
		}

		public Criteria andIdNoLike(String value) {
			addCriterion("ID_NO like", value, "idNo");
			return (Criteria) this;
		}

		public Criteria andIdNoNotLike(String value) {
			addCriterion("ID_NO not like", value, "idNo");
			return (Criteria) this;
		}

		public Criteria andIdNoIn(List<String> values) {
			addCriterion("ID_NO in", values, "idNo");
			return (Criteria) this;
		}

		public Criteria andIdNoNotIn(List<String> values) {
			addCriterion("ID_NO not in", values, "idNo");
			return (Criteria) this;
		}

		public Criteria andIdNoBetween(String value1, String value2) {
			addCriterion("ID_NO between", value1, value2, "idNo");
			return (Criteria) this;
		}

		public Criteria andIdNoNotBetween(String value1, String value2) {
			addCriterion("ID_NO not between", value1, value2, "idNo");
			return (Criteria) this;
		}

		public Criteria andIdSignDateIsNull() {
			addCriterion("ID_SIGN_DATE is null");
			return (Criteria) this;
		}

		public Criteria andIdSignDateIsNotNull() {
			addCriterion("ID_SIGN_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andIdSignDateEqualTo(Date value) {
			addCriterionForJDBCDate("ID_SIGN_DATE =", value, "idSignDate");
			return (Criteria) this;
		}

		public Criteria andIdSignDateNotEqualTo(Date value) {
			addCriterionForJDBCDate("ID_SIGN_DATE <>", value, "idSignDate");
			return (Criteria) this;
		}

		public Criteria andIdSignDateGreaterThan(Date value) {
			addCriterionForJDBCDate("ID_SIGN_DATE >", value, "idSignDate");
			return (Criteria) this;
		}

		public Criteria andIdSignDateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("ID_SIGN_DATE >=", value, "idSignDate");
			return (Criteria) this;
		}

		public Criteria andIdSignDateLessThan(Date value) {
			addCriterionForJDBCDate("ID_SIGN_DATE <", value, "idSignDate");
			return (Criteria) this;
		}

		public Criteria andIdSignDateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("ID_SIGN_DATE <=", value, "idSignDate");
			return (Criteria) this;
		}

		public Criteria andIdSignDateIn(List<Date> values) {
			addCriterionForJDBCDate("ID_SIGN_DATE in", values, "idSignDate");
			return (Criteria) this;
		}

		public Criteria andIdSignDateNotIn(List<Date> values) {
			addCriterionForJDBCDate("ID_SIGN_DATE not in", values, "idSignDate");
			return (Criteria) this;
		}

		public Criteria andIdSignDateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("ID_SIGN_DATE between", value1, value2, "idSignDate");
			return (Criteria) this;
		}

		public Criteria andIdSignDateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("ID_SIGN_DATE not between", value1, value2, "idSignDate");
			return (Criteria) this;
		}

		public Criteria andIdExpireDateIsNull() {
			addCriterion("ID_EXPIRE_DATE is null");
			return (Criteria) this;
		}

		public Criteria andIdExpireDateIsNotNull() {
			addCriterion("ID_EXPIRE_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andIdExpireDateEqualTo(Date value) {
			addCriterionForJDBCDate("ID_EXPIRE_DATE =", value, "idExpireDate");
			return (Criteria) this;
		}

		public Criteria andIdExpireDateNotEqualTo(Date value) {
			addCriterionForJDBCDate("ID_EXPIRE_DATE <>", value, "idExpireDate");
			return (Criteria) this;
		}

		public Criteria andIdExpireDateGreaterThan(Date value) {
			addCriterionForJDBCDate("ID_EXPIRE_DATE >", value, "idExpireDate");
			return (Criteria) this;
		}

		public Criteria andIdExpireDateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("ID_EXPIRE_DATE >=", value, "idExpireDate");
			return (Criteria) this;
		}

		public Criteria andIdExpireDateLessThan(Date value) {
			addCriterionForJDBCDate("ID_EXPIRE_DATE <", value, "idExpireDate");
			return (Criteria) this;
		}

		public Criteria andIdExpireDateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("ID_EXPIRE_DATE <=", value, "idExpireDate");
			return (Criteria) this;
		}

		public Criteria andIdExpireDateIn(List<Date> values) {
			addCriterionForJDBCDate("ID_EXPIRE_DATE in", values, "idExpireDate");
			return (Criteria) this;
		}

		public Criteria andIdExpireDateNotIn(List<Date> values) {
			addCriterionForJDBCDate("ID_EXPIRE_DATE not in", values, "idExpireDate");
			return (Criteria) this;
		}

		public Criteria andIdExpireDateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("ID_EXPIRE_DATE between", value1, value2, "idExpireDate");
			return (Criteria) this;
		}

		public Criteria andIdExpireDateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("ID_EXPIRE_DATE not between", value1, value2, "idExpireDate");
			return (Criteria) this;
		}

		public Criteria andGenderIsNull() {
			addCriterion("GENDER is null");
			return (Criteria) this;
		}

		public Criteria andGenderIsNotNull() {
			addCriterion("GENDER is not null");
			return (Criteria) this;
		}

		public Criteria andGenderEqualTo(String value) {
			addCriterion("GENDER =", value, "gender");
			return (Criteria) this;
		}

		public Criteria andGenderNotEqualTo(String value) {
			addCriterion("GENDER <>", value, "gender");
			return (Criteria) this;
		}

		public Criteria andGenderGreaterThan(String value) {
			addCriterion("GENDER >", value, "gender");
			return (Criteria) this;
		}

		public Criteria andGenderGreaterThanOrEqualTo(String value) {
			addCriterion("GENDER >=", value, "gender");
			return (Criteria) this;
		}

		public Criteria andGenderLessThan(String value) {
			addCriterion("GENDER <", value, "gender");
			return (Criteria) this;
		}

		public Criteria andGenderLessThanOrEqualTo(String value) {
			addCriterion("GENDER <=", value, "gender");
			return (Criteria) this;
		}

		public Criteria andGenderLike(String value) {
			addCriterion("GENDER like", value, "gender");
			return (Criteria) this;
		}

		public Criteria andGenderNotLike(String value) {
			addCriterion("GENDER not like", value, "gender");
			return (Criteria) this;
		}

		public Criteria andGenderIn(List<String> values) {
			addCriterion("GENDER in", values, "gender");
			return (Criteria) this;
		}

		public Criteria andGenderNotIn(List<String> values) {
			addCriterion("GENDER not in", values, "gender");
			return (Criteria) this;
		}

		public Criteria andGenderBetween(String value1, String value2) {
			addCriterion("GENDER between", value1, value2, "gender");
			return (Criteria) this;
		}

		public Criteria andGenderNotBetween(String value1, String value2) {
			addCriterion("GENDER not between", value1, value2, "gender");
			return (Criteria) this;
		}

		public Criteria andBirthdayIsNull() {
			addCriterion("BIRTHDAY is null");
			return (Criteria) this;
		}

		public Criteria andBirthdayIsNotNull() {
			addCriterion("BIRTHDAY is not null");
			return (Criteria) this;
		}

		public Criteria andBirthdayEqualTo(Date value) {
			addCriterionForJDBCDate("BIRTHDAY =", value, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayNotEqualTo(Date value) {
			addCriterionForJDBCDate("BIRTHDAY <>", value, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayGreaterThan(Date value) {
			addCriterionForJDBCDate("BIRTHDAY >", value, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("BIRTHDAY >=", value, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayLessThan(Date value) {
			addCriterionForJDBCDate("BIRTHDAY <", value, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("BIRTHDAY <=", value, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayIn(List<Date> values) {
			addCriterionForJDBCDate("BIRTHDAY in", values, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayNotIn(List<Date> values) {
			addCriterionForJDBCDate("BIRTHDAY not in", values, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("BIRTHDAY between", value1, value2, "birthday");
			return (Criteria) this;
		}

		public Criteria andBirthdayNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("BIRTHDAY not between", value1, value2, "birthday");
			return (Criteria) this;
		}

		public Criteria andAgeIsNull() {
			addCriterion("AGE is null");
			return (Criteria) this;
		}

		public Criteria andAgeIsNotNull() {
			addCriterion("AGE is not null");
			return (Criteria) this;
		}

		public Criteria andAgeEqualTo(Integer value) {
			addCriterion("AGE =", value, "age");
			return (Criteria) this;
		}

		public Criteria andAgeNotEqualTo(Integer value) {
			addCriterion("AGE <>", value, "age");
			return (Criteria) this;
		}

		public Criteria andAgeGreaterThan(Integer value) {
			addCriterion("AGE >", value, "age");
			return (Criteria) this;
		}

		public Criteria andAgeGreaterThanOrEqualTo(Integer value) {
			addCriterion("AGE >=", value, "age");
			return (Criteria) this;
		}

		public Criteria andAgeLessThan(Integer value) {
			addCriterion("AGE <", value, "age");
			return (Criteria) this;
		}

		public Criteria andAgeLessThanOrEqualTo(Integer value) {
			addCriterion("AGE <=", value, "age");
			return (Criteria) this;
		}

		public Criteria andAgeIn(List<Integer> values) {
			addCriterion("AGE in", values, "age");
			return (Criteria) this;
		}

		public Criteria andAgeNotIn(List<Integer> values) {
			addCriterion("AGE not in", values, "age");
			return (Criteria) this;
		}

		public Criteria andAgeBetween(Integer value1, Integer value2) {
			addCriterion("AGE between", value1, value2, "age");
			return (Criteria) this;
		}

		public Criteria andAgeNotBetween(Integer value1, Integer value2) {
			addCriterion("AGE not between", value1, value2, "age");
			return (Criteria) this;
		}

		public Criteria andNationIsNull() {
			addCriterion("NATION is null");
			return (Criteria) this;
		}

		public Criteria andNationIsNotNull() {
			addCriterion("NATION is not null");
			return (Criteria) this;
		}

		public Criteria andNationEqualTo(String value) {
			addCriterion("NATION =", value, "nation");
			return (Criteria) this;
		}

		public Criteria andNationNotEqualTo(String value) {
			addCriterion("NATION <>", value, "nation");
			return (Criteria) this;
		}

		public Criteria andNationGreaterThan(String value) {
			addCriterion("NATION >", value, "nation");
			return (Criteria) this;
		}

		public Criteria andNationGreaterThanOrEqualTo(String value) {
			addCriterion("NATION >=", value, "nation");
			return (Criteria) this;
		}

		public Criteria andNationLessThan(String value) {
			addCriterion("NATION <", value, "nation");
			return (Criteria) this;
		}

		public Criteria andNationLessThanOrEqualTo(String value) {
			addCriterion("NATION <=", value, "nation");
			return (Criteria) this;
		}

		public Criteria andNationLike(String value) {
			addCriterion("NATION like", value, "nation");
			return (Criteria) this;
		}

		public Criteria andNationNotLike(String value) {
			addCriterion("NATION not like", value, "nation");
			return (Criteria) this;
		}

		public Criteria andNationIn(List<String> values) {
			addCriterion("NATION in", values, "nation");
			return (Criteria) this;
		}

		public Criteria andNationNotIn(List<String> values) {
			addCriterion("NATION not in", values, "nation");
			return (Criteria) this;
		}

		public Criteria andNationBetween(String value1, String value2) {
			addCriterion("NATION between", value1, value2, "nation");
			return (Criteria) this;
		}

		public Criteria andNationNotBetween(String value1, String value2) {
			addCriterion("NATION not between", value1, value2, "nation");
			return (Criteria) this;
		}

		public Criteria andEducationLvlIsNull() {
			addCriterion("EDUCATION_LVL is null");
			return (Criteria) this;
		}

		public Criteria andEducationLvlIsNotNull() {
			addCriterion("EDUCATION_LVL is not null");
			return (Criteria) this;
		}

		public Criteria andEducationLvlEqualTo(String value) {
			addCriterion("EDUCATION_LVL =", value, "educationLvl");
			return (Criteria) this;
		}

		public Criteria andEducationLvlNotEqualTo(String value) {
			addCriterion("EDUCATION_LVL <>", value, "educationLvl");
			return (Criteria) this;
		}

		public Criteria andEducationLvlGreaterThan(String value) {
			addCriterion("EDUCATION_LVL >", value, "educationLvl");
			return (Criteria) this;
		}

		public Criteria andEducationLvlGreaterThanOrEqualTo(String value) {
			addCriterion("EDUCATION_LVL >=", value, "educationLvl");
			return (Criteria) this;
		}

		public Criteria andEducationLvlLessThan(String value) {
			addCriterion("EDUCATION_LVL <", value, "educationLvl");
			return (Criteria) this;
		}

		public Criteria andEducationLvlLessThanOrEqualTo(String value) {
			addCriterion("EDUCATION_LVL <=", value, "educationLvl");
			return (Criteria) this;
		}

		public Criteria andEducationLvlLike(String value) {
			addCriterion("EDUCATION_LVL like", value, "educationLvl");
			return (Criteria) this;
		}

		public Criteria andEducationLvlNotLike(String value) {
			addCriterion("EDUCATION_LVL not like", value, "educationLvl");
			return (Criteria) this;
		}

		public Criteria andEducationLvlIn(List<String> values) {
			addCriterion("EDUCATION_LVL in", values, "educationLvl");
			return (Criteria) this;
		}

		public Criteria andEducationLvlNotIn(List<String> values) {
			addCriterion("EDUCATION_LVL not in", values, "educationLvl");
			return (Criteria) this;
		}

		public Criteria andEducationLvlBetween(String value1, String value2) {
			addCriterion("EDUCATION_LVL between", value1, value2, "educationLvl");
			return (Criteria) this;
		}

		public Criteria andEducationLvlNotBetween(String value1, String value2) {
			addCriterion("EDUCATION_LVL not between", value1, value2, "educationLvl");
			return (Criteria) this;
		}

		public Criteria andPoliticsStatusIsNull() {
			addCriterion("POLITICS_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andPoliticsStatusIsNotNull() {
			addCriterion("POLITICS_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andPoliticsStatusEqualTo(String value) {
			addCriterion("POLITICS_STATUS =", value, "politicsStatus");
			return (Criteria) this;
		}

		public Criteria andPoliticsStatusNotEqualTo(String value) {
			addCriterion("POLITICS_STATUS <>", value, "politicsStatus");
			return (Criteria) this;
		}

		public Criteria andPoliticsStatusGreaterThan(String value) {
			addCriterion("POLITICS_STATUS >", value, "politicsStatus");
			return (Criteria) this;
		}

		public Criteria andPoliticsStatusGreaterThanOrEqualTo(String value) {
			addCriterion("POLITICS_STATUS >=", value, "politicsStatus");
			return (Criteria) this;
		}

		public Criteria andPoliticsStatusLessThan(String value) {
			addCriterion("POLITICS_STATUS <", value, "politicsStatus");
			return (Criteria) this;
		}

		public Criteria andPoliticsStatusLessThanOrEqualTo(String value) {
			addCriterion("POLITICS_STATUS <=", value, "politicsStatus");
			return (Criteria) this;
		}

		public Criteria andPoliticsStatusLike(String value) {
			addCriterion("POLITICS_STATUS like", value, "politicsStatus");
			return (Criteria) this;
		}

		public Criteria andPoliticsStatusNotLike(String value) {
			addCriterion("POLITICS_STATUS not like", value, "politicsStatus");
			return (Criteria) this;
		}

		public Criteria andPoliticsStatusIn(List<String> values) {
			addCriterion("POLITICS_STATUS in", values, "politicsStatus");
			return (Criteria) this;
		}

		public Criteria andPoliticsStatusNotIn(List<String> values) {
			addCriterion("POLITICS_STATUS not in", values, "politicsStatus");
			return (Criteria) this;
		}

		public Criteria andPoliticsStatusBetween(String value1, String value2) {
			addCriterion("POLITICS_STATUS between", value1, value2, "politicsStatus");
			return (Criteria) this;
		}

		public Criteria andPoliticsStatusNotBetween(String value1, String value2) {
			addCriterion("POLITICS_STATUS not between", value1, value2, "politicsStatus");
			return (Criteria) this;
		}

		public Criteria andMarriageStatusIsNull() {
			addCriterion("MARRIAGE_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andMarriageStatusIsNotNull() {
			addCriterion("MARRIAGE_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andMarriageStatusEqualTo(String value) {
			addCriterion("MARRIAGE_STATUS =", value, "marriageStatus");
			return (Criteria) this;
		}

		public Criteria andMarriageStatusNotEqualTo(String value) {
			addCriterion("MARRIAGE_STATUS <>", value, "marriageStatus");
			return (Criteria) this;
		}

		public Criteria andMarriageStatusGreaterThan(String value) {
			addCriterion("MARRIAGE_STATUS >", value, "marriageStatus");
			return (Criteria) this;
		}

		public Criteria andMarriageStatusGreaterThanOrEqualTo(String value) {
			addCriterion("MARRIAGE_STATUS >=", value, "marriageStatus");
			return (Criteria) this;
		}

		public Criteria andMarriageStatusLessThan(String value) {
			addCriterion("MARRIAGE_STATUS <", value, "marriageStatus");
			return (Criteria) this;
		}

		public Criteria andMarriageStatusLessThanOrEqualTo(String value) {
			addCriterion("MARRIAGE_STATUS <=", value, "marriageStatus");
			return (Criteria) this;
		}

		public Criteria andMarriageStatusLike(String value) {
			addCriterion("MARRIAGE_STATUS like", value, "marriageStatus");
			return (Criteria) this;
		}

		public Criteria andMarriageStatusNotLike(String value) {
			addCriterion("MARRIAGE_STATUS not like", value, "marriageStatus");
			return (Criteria) this;
		}

		public Criteria andMarriageStatusIn(List<String> values) {
			addCriterion("MARRIAGE_STATUS in", values, "marriageStatus");
			return (Criteria) this;
		}

		public Criteria andMarriageStatusNotIn(List<String> values) {
			addCriterion("MARRIAGE_STATUS not in", values, "marriageStatus");
			return (Criteria) this;
		}

		public Criteria andMarriageStatusBetween(String value1, String value2) {
			addCriterion("MARRIAGE_STATUS between", value1, value2, "marriageStatus");
			return (Criteria) this;
		}

		public Criteria andMarriageStatusNotBetween(String value1, String value2) {
			addCriterion("MARRIAGE_STATUS not between", value1, value2, "marriageStatus");
			return (Criteria) this;
		}

		public Criteria andMobileIsNull() {
			addCriterion("MOBILE is null");
			return (Criteria) this;
		}

		public Criteria andMobileIsNotNull() {
			addCriterion("MOBILE is not null");
			return (Criteria) this;
		}

		public Criteria andMobileEqualTo(String value) {
			addCriterion("MOBILE =", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotEqualTo(String value) {
			addCriterion("MOBILE <>", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileGreaterThan(String value) {
			addCriterion("MOBILE >", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileGreaterThanOrEqualTo(String value) {
			addCriterion("MOBILE >=", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileLessThan(String value) {
			addCriterion("MOBILE <", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileLessThanOrEqualTo(String value) {
			addCriterion("MOBILE <=", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileLike(String value) {
			addCriterion("MOBILE like", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotLike(String value) {
			addCriterion("MOBILE not like", value, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileIn(List<String> values) {
			addCriterion("MOBILE in", values, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotIn(List<String> values) {
			addCriterion("MOBILE not in", values, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileBetween(String value1, String value2) {
			addCriterion("MOBILE between", value1, value2, "mobile");
			return (Criteria) this;
		}

		public Criteria andMobileNotBetween(String value1, String value2) {
			addCriterion("MOBILE not between", value1, value2, "mobile");
			return (Criteria) this;
		}

		public Criteria andHomePhoneIsNull() {
			addCriterion("HOME_PHONE is null");
			return (Criteria) this;
		}

		public Criteria andHomePhoneIsNotNull() {
			addCriterion("HOME_PHONE is not null");
			return (Criteria) this;
		}

		public Criteria andHomePhoneEqualTo(String value) {
			addCriterion("HOME_PHONE =", value, "homePhone");
			return (Criteria) this;
		}

		public Criteria andHomePhoneNotEqualTo(String value) {
			addCriterion("HOME_PHONE <>", value, "homePhone");
			return (Criteria) this;
		}

		public Criteria andHomePhoneGreaterThan(String value) {
			addCriterion("HOME_PHONE >", value, "homePhone");
			return (Criteria) this;
		}

		public Criteria andHomePhoneGreaterThanOrEqualTo(String value) {
			addCriterion("HOME_PHONE >=", value, "homePhone");
			return (Criteria) this;
		}

		public Criteria andHomePhoneLessThan(String value) {
			addCriterion("HOME_PHONE <", value, "homePhone");
			return (Criteria) this;
		}

		public Criteria andHomePhoneLessThanOrEqualTo(String value) {
			addCriterion("HOME_PHONE <=", value, "homePhone");
			return (Criteria) this;
		}

		public Criteria andHomePhoneLike(String value) {
			addCriterion("HOME_PHONE like", value, "homePhone");
			return (Criteria) this;
		}

		public Criteria andHomePhoneNotLike(String value) {
			addCriterion("HOME_PHONE not like", value, "homePhone");
			return (Criteria) this;
		}

		public Criteria andHomePhoneIn(List<String> values) {
			addCriterion("HOME_PHONE in", values, "homePhone");
			return (Criteria) this;
		}

		public Criteria andHomePhoneNotIn(List<String> values) {
			addCriterion("HOME_PHONE not in", values, "homePhone");
			return (Criteria) this;
		}

		public Criteria andHomePhoneBetween(String value1, String value2) {
			addCriterion("HOME_PHONE between", value1, value2, "homePhone");
			return (Criteria) this;
		}

		public Criteria andHomePhoneNotBetween(String value1, String value2) {
			addCriterion("HOME_PHONE not between", value1, value2, "homePhone");
			return (Criteria) this;
		}

		public Criteria andEmailIsNull() {
			addCriterion("EMAIL is null");
			return (Criteria) this;
		}

		public Criteria andEmailIsNotNull() {
			addCriterion("EMAIL is not null");
			return (Criteria) this;
		}

		public Criteria andEmailEqualTo(String value) {
			addCriterion("EMAIL =", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotEqualTo(String value) {
			addCriterion("EMAIL <>", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailGreaterThan(String value) {
			addCriterion("EMAIL >", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailGreaterThanOrEqualTo(String value) {
			addCriterion("EMAIL >=", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLessThan(String value) {
			addCriterion("EMAIL <", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLessThanOrEqualTo(String value) {
			addCriterion("EMAIL <=", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailLike(String value) {
			addCriterion("EMAIL like", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotLike(String value) {
			addCriterion("EMAIL not like", value, "email");
			return (Criteria) this;
		}

		public Criteria andEmailIn(List<String> values) {
			addCriterion("EMAIL in", values, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotIn(List<String> values) {
			addCriterion("EMAIL not in", values, "email");
			return (Criteria) this;
		}

		public Criteria andEmailBetween(String value1, String value2) {
			addCriterion("EMAIL between", value1, value2, "email");
			return (Criteria) this;
		}

		public Criteria andEmailNotBetween(String value1, String value2) {
			addCriterion("EMAIL not between", value1, value2, "email");
			return (Criteria) this;
		}

		public Criteria andIndustryTypeIsNull() {
			addCriterion("INDUSTRY_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andIndustryTypeIsNotNull() {
			addCriterion("INDUSTRY_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andIndustryTypeEqualTo(String value) {
			addCriterion("INDUSTRY_TYPE =", value, "industryType");
			return (Criteria) this;
		}

		public Criteria andIndustryTypeNotEqualTo(String value) {
			addCriterion("INDUSTRY_TYPE <>", value, "industryType");
			return (Criteria) this;
		}

		public Criteria andIndustryTypeGreaterThan(String value) {
			addCriterion("INDUSTRY_TYPE >", value, "industryType");
			return (Criteria) this;
		}

		public Criteria andIndustryTypeGreaterThanOrEqualTo(String value) {
			addCriterion("INDUSTRY_TYPE >=", value, "industryType");
			return (Criteria) this;
		}

		public Criteria andIndustryTypeLessThan(String value) {
			addCriterion("INDUSTRY_TYPE <", value, "industryType");
			return (Criteria) this;
		}

		public Criteria andIndustryTypeLessThanOrEqualTo(String value) {
			addCriterion("INDUSTRY_TYPE <=", value, "industryType");
			return (Criteria) this;
		}

		public Criteria andIndustryTypeLike(String value) {
			addCriterion("INDUSTRY_TYPE like", value, "industryType");
			return (Criteria) this;
		}

		public Criteria andIndustryTypeNotLike(String value) {
			addCriterion("INDUSTRY_TYPE not like", value, "industryType");
			return (Criteria) this;
		}

		public Criteria andIndustryTypeIn(List<String> values) {
			addCriterion("INDUSTRY_TYPE in", values, "industryType");
			return (Criteria) this;
		}

		public Criteria andIndustryTypeNotIn(List<String> values) {
			addCriterion("INDUSTRY_TYPE not in", values, "industryType");
			return (Criteria) this;
		}

		public Criteria andIndustryTypeBetween(String value1, String value2) {
			addCriterion("INDUSTRY_TYPE between", value1, value2, "industryType");
			return (Criteria) this;
		}

		public Criteria andIndustryTypeNotBetween(String value1, String value2) {
			addCriterion("INDUSTRY_TYPE not between", value1, value2, "industryType");
			return (Criteria) this;
		}

		public Criteria andCompanyIsNull() {
			addCriterion("COMPANY is null");
			return (Criteria) this;
		}

		public Criteria andCompanyIsNotNull() {
			addCriterion("COMPANY is not null");
			return (Criteria) this;
		}

		public Criteria andCompanyEqualTo(String value) {
			addCriterion("COMPANY =", value, "company");
			return (Criteria) this;
		}

		public Criteria andCompanyNotEqualTo(String value) {
			addCriterion("COMPANY <>", value, "company");
			return (Criteria) this;
		}

		public Criteria andCompanyGreaterThan(String value) {
			addCriterion("COMPANY >", value, "company");
			return (Criteria) this;
		}

		public Criteria andCompanyGreaterThanOrEqualTo(String value) {
			addCriterion("COMPANY >=", value, "company");
			return (Criteria) this;
		}

		public Criteria andCompanyLessThan(String value) {
			addCriterion("COMPANY <", value, "company");
			return (Criteria) this;
		}

		public Criteria andCompanyLessThanOrEqualTo(String value) {
			addCriterion("COMPANY <=", value, "company");
			return (Criteria) this;
		}

		public Criteria andCompanyLike(String value) {
			addCriterion("COMPANY like", value, "company");
			return (Criteria) this;
		}

		public Criteria andCompanyNotLike(String value) {
			addCriterion("COMPANY not like", value, "company");
			return (Criteria) this;
		}

		public Criteria andCompanyIn(List<String> values) {
			addCriterion("COMPANY in", values, "company");
			return (Criteria) this;
		}

		public Criteria andCompanyNotIn(List<String> values) {
			addCriterion("COMPANY not in", values, "company");
			return (Criteria) this;
		}

		public Criteria andCompanyBetween(String value1, String value2) {
			addCriterion("COMPANY between", value1, value2, "company");
			return (Criteria) this;
		}

		public Criteria andCompanyNotBetween(String value1, String value2) {
			addCriterion("COMPANY not between", value1, value2, "company");
			return (Criteria) this;
		}

		public Criteria andPositionIsNull() {
			addCriterion("POSITION is null");
			return (Criteria) this;
		}

		public Criteria andPositionIsNotNull() {
			addCriterion("POSITION is not null");
			return (Criteria) this;
		}

		public Criteria andPositionEqualTo(String value) {
			addCriterion("POSITION =", value, "position");
			return (Criteria) this;
		}

		public Criteria andPositionNotEqualTo(String value) {
			addCriterion("POSITION <>", value, "position");
			return (Criteria) this;
		}

		public Criteria andPositionGreaterThan(String value) {
			addCriterion("POSITION >", value, "position");
			return (Criteria) this;
		}

		public Criteria andPositionGreaterThanOrEqualTo(String value) {
			addCriterion("POSITION >=", value, "position");
			return (Criteria) this;
		}

		public Criteria andPositionLessThan(String value) {
			addCriterion("POSITION <", value, "position");
			return (Criteria) this;
		}

		public Criteria andPositionLessThanOrEqualTo(String value) {
			addCriterion("POSITION <=", value, "position");
			return (Criteria) this;
		}

		public Criteria andPositionLike(String value) {
			addCriterion("POSITION like", value, "position");
			return (Criteria) this;
		}

		public Criteria andPositionNotLike(String value) {
			addCriterion("POSITION not like", value, "position");
			return (Criteria) this;
		}

		public Criteria andPositionIn(List<String> values) {
			addCriterion("POSITION in", values, "position");
			return (Criteria) this;
		}

		public Criteria andPositionNotIn(List<String> values) {
			addCriterion("POSITION not in", values, "position");
			return (Criteria) this;
		}

		public Criteria andPositionBetween(String value1, String value2) {
			addCriterion("POSITION between", value1, value2, "position");
			return (Criteria) this;
		}

		public Criteria andPositionNotBetween(String value1, String value2) {
			addCriterion("POSITION not between", value1, value2, "position");
			return (Criteria) this;
		}

		public Criteria andWorkYearsIsNull() {
			addCriterion("WORK_YEARS is null");
			return (Criteria) this;
		}

		public Criteria andWorkYearsIsNotNull() {
			addCriterion("WORK_YEARS is not null");
			return (Criteria) this;
		}

		public Criteria andWorkYearsEqualTo(BigDecimal value) {
			addCriterion("WORK_YEARS =", value, "workYears");
			return (Criteria) this;
		}

		public Criteria andWorkYearsNotEqualTo(BigDecimal value) {
			addCriterion("WORK_YEARS <>", value, "workYears");
			return (Criteria) this;
		}

		public Criteria andWorkYearsGreaterThan(BigDecimal value) {
			addCriterion("WORK_YEARS >", value, "workYears");
			return (Criteria) this;
		}

		public Criteria andWorkYearsGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("WORK_YEARS >=", value, "workYears");
			return (Criteria) this;
		}

		public Criteria andWorkYearsLessThan(BigDecimal value) {
			addCriterion("WORK_YEARS <", value, "workYears");
			return (Criteria) this;
		}

		public Criteria andWorkYearsLessThanOrEqualTo(BigDecimal value) {
			addCriterion("WORK_YEARS <=", value, "workYears");
			return (Criteria) this;
		}

		public Criteria andWorkYearsIn(List<BigDecimal> values) {
			addCriterion("WORK_YEARS in", values, "workYears");
			return (Criteria) this;
		}

		public Criteria andWorkYearsNotIn(List<BigDecimal> values) {
			addCriterion("WORK_YEARS not in", values, "workYears");
			return (Criteria) this;
		}

		public Criteria andWorkYearsBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("WORK_YEARS between", value1, value2, "workYears");
			return (Criteria) this;
		}

		public Criteria andWorkYearsNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("WORK_YEARS not between", value1, value2, "workYears");
			return (Criteria) this;
		}

		public Criteria andCurrJobStDateIsNull() {
			addCriterion("CURR_JOB_ST_DATE is null");
			return (Criteria) this;
		}

		public Criteria andCurrJobStDateIsNotNull() {
			addCriterion("CURR_JOB_ST_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andCurrJobStDateEqualTo(Date value) {
			addCriterionForJDBCDate("CURR_JOB_ST_DATE =", value, "currJobStDate");
			return (Criteria) this;
		}

		public Criteria andCurrJobStDateNotEqualTo(Date value) {
			addCriterionForJDBCDate("CURR_JOB_ST_DATE <>", value, "currJobStDate");
			return (Criteria) this;
		}

		public Criteria andCurrJobStDateGreaterThan(Date value) {
			addCriterionForJDBCDate("CURR_JOB_ST_DATE >", value, "currJobStDate");
			return (Criteria) this;
		}

		public Criteria andCurrJobStDateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("CURR_JOB_ST_DATE >=", value, "currJobStDate");
			return (Criteria) this;
		}

		public Criteria andCurrJobStDateLessThan(Date value) {
			addCriterionForJDBCDate("CURR_JOB_ST_DATE <", value, "currJobStDate");
			return (Criteria) this;
		}

		public Criteria andCurrJobStDateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("CURR_JOB_ST_DATE <=", value, "currJobStDate");
			return (Criteria) this;
		}

		public Criteria andCurrJobStDateIn(List<Date> values) {
			addCriterionForJDBCDate("CURR_JOB_ST_DATE in", values, "currJobStDate");
			return (Criteria) this;
		}

		public Criteria andCurrJobStDateNotIn(List<Date> values) {
			addCriterionForJDBCDate("CURR_JOB_ST_DATE not in", values, "currJobStDate");
			return (Criteria) this;
		}

		public Criteria andCurrJobStDateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("CURR_JOB_ST_DATE between", value1, value2, "currJobStDate");
			return (Criteria) this;
		}

		public Criteria andCurrJobStDateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("CURR_JOB_ST_DATE not between", value1, value2, "currJobStDate");
			return (Criteria) this;
		}

		public Criteria andCompAddrIsNull() {
			addCriterion("COMP_ADDR is null");
			return (Criteria) this;
		}

		public Criteria andCompAddrIsNotNull() {
			addCriterion("COMP_ADDR is not null");
			return (Criteria) this;
		}

		public Criteria andCompAddrEqualTo(String value) {
			addCriterion("COMP_ADDR =", value, "compAddr");
			return (Criteria) this;
		}

		public Criteria andCompAddrNotEqualTo(String value) {
			addCriterion("COMP_ADDR <>", value, "compAddr");
			return (Criteria) this;
		}

		public Criteria andCompAddrGreaterThan(String value) {
			addCriterion("COMP_ADDR >", value, "compAddr");
			return (Criteria) this;
		}

		public Criteria andCompAddrGreaterThanOrEqualTo(String value) {
			addCriterion("COMP_ADDR >=", value, "compAddr");
			return (Criteria) this;
		}

		public Criteria andCompAddrLessThan(String value) {
			addCriterion("COMP_ADDR <", value, "compAddr");
			return (Criteria) this;
		}

		public Criteria andCompAddrLessThanOrEqualTo(String value) {
			addCriterion("COMP_ADDR <=", value, "compAddr");
			return (Criteria) this;
		}

		public Criteria andCompAddrLike(String value) {
			addCriterion("COMP_ADDR like", value, "compAddr");
			return (Criteria) this;
		}

		public Criteria andCompAddrNotLike(String value) {
			addCriterion("COMP_ADDR not like", value, "compAddr");
			return (Criteria) this;
		}

		public Criteria andCompAddrIn(List<String> values) {
			addCriterion("COMP_ADDR in", values, "compAddr");
			return (Criteria) this;
		}

		public Criteria andCompAddrNotIn(List<String> values) {
			addCriterion("COMP_ADDR not in", values, "compAddr");
			return (Criteria) this;
		}

		public Criteria andCompAddrBetween(String value1, String value2) {
			addCriterion("COMP_ADDR between", value1, value2, "compAddr");
			return (Criteria) this;
		}

		public Criteria andCompAddrNotBetween(String value1, String value2) {
			addCriterion("COMP_ADDR not between", value1, value2, "compAddr");
			return (Criteria) this;
		}

		public Criteria andCompPhoneIsNull() {
			addCriterion("COMP_PHONE is null");
			return (Criteria) this;
		}

		public Criteria andCompPhoneIsNotNull() {
			addCriterion("COMP_PHONE is not null");
			return (Criteria) this;
		}

		public Criteria andCompPhoneEqualTo(String value) {
			addCriterion("COMP_PHONE =", value, "compPhone");
			return (Criteria) this;
		}

		public Criteria andCompPhoneNotEqualTo(String value) {
			addCriterion("COMP_PHONE <>", value, "compPhone");
			return (Criteria) this;
		}

		public Criteria andCompPhoneGreaterThan(String value) {
			addCriterion("COMP_PHONE >", value, "compPhone");
			return (Criteria) this;
		}

		public Criteria andCompPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("COMP_PHONE >=", value, "compPhone");
			return (Criteria) this;
		}

		public Criteria andCompPhoneLessThan(String value) {
			addCriterion("COMP_PHONE <", value, "compPhone");
			return (Criteria) this;
		}

		public Criteria andCompPhoneLessThanOrEqualTo(String value) {
			addCriterion("COMP_PHONE <=", value, "compPhone");
			return (Criteria) this;
		}

		public Criteria andCompPhoneLike(String value) {
			addCriterion("COMP_PHONE like", value, "compPhone");
			return (Criteria) this;
		}

		public Criteria andCompPhoneNotLike(String value) {
			addCriterion("COMP_PHONE not like", value, "compPhone");
			return (Criteria) this;
		}

		public Criteria andCompPhoneIn(List<String> values) {
			addCriterion("COMP_PHONE in", values, "compPhone");
			return (Criteria) this;
		}

		public Criteria andCompPhoneNotIn(List<String> values) {
			addCriterion("COMP_PHONE not in", values, "compPhone");
			return (Criteria) this;
		}

		public Criteria andCompPhoneBetween(String value1, String value2) {
			addCriterion("COMP_PHONE between", value1, value2, "compPhone");
			return (Criteria) this;
		}

		public Criteria andCompPhoneNotBetween(String value1, String value2) {
			addCriterion("COMP_PHONE not between", value1, value2, "compPhone");
			return (Criteria) this;
		}

		public Criteria andCompZipIsNull() {
			addCriterion("COMP_ZIP is null");
			return (Criteria) this;
		}

		public Criteria andCompZipIsNotNull() {
			addCriterion("COMP_ZIP is not null");
			return (Criteria) this;
		}

		public Criteria andCompZipEqualTo(String value) {
			addCriterion("COMP_ZIP =", value, "compZip");
			return (Criteria) this;
		}

		public Criteria andCompZipNotEqualTo(String value) {
			addCriterion("COMP_ZIP <>", value, "compZip");
			return (Criteria) this;
		}

		public Criteria andCompZipGreaterThan(String value) {
			addCriterion("COMP_ZIP >", value, "compZip");
			return (Criteria) this;
		}

		public Criteria andCompZipGreaterThanOrEqualTo(String value) {
			addCriterion("COMP_ZIP >=", value, "compZip");
			return (Criteria) this;
		}

		public Criteria andCompZipLessThan(String value) {
			addCriterion("COMP_ZIP <", value, "compZip");
			return (Criteria) this;
		}

		public Criteria andCompZipLessThanOrEqualTo(String value) {
			addCriterion("COMP_ZIP <=", value, "compZip");
			return (Criteria) this;
		}

		public Criteria andCompZipLike(String value) {
			addCriterion("COMP_ZIP like", value, "compZip");
			return (Criteria) this;
		}

		public Criteria andCompZipNotLike(String value) {
			addCriterion("COMP_ZIP not like", value, "compZip");
			return (Criteria) this;
		}

		public Criteria andCompZipIn(List<String> values) {
			addCriterion("COMP_ZIP in", values, "compZip");
			return (Criteria) this;
		}

		public Criteria andCompZipNotIn(List<String> values) {
			addCriterion("COMP_ZIP not in", values, "compZip");
			return (Criteria) this;
		}

		public Criteria andCompZipBetween(String value1, String value2) {
			addCriterion("COMP_ZIP between", value1, value2, "compZip");
			return (Criteria) this;
		}

		public Criteria andCompZipNotBetween(String value1, String value2) {
			addCriterion("COMP_ZIP not between", value1, value2, "compZip");
			return (Criteria) this;
		}

		public Criteria andHomeAddrIsNull() {
			addCriterion("HOME_ADDR is null");
			return (Criteria) this;
		}

		public Criteria andHomeAddrIsNotNull() {
			addCriterion("HOME_ADDR is not null");
			return (Criteria) this;
		}

		public Criteria andHomeAddrEqualTo(String value) {
			addCriterion("HOME_ADDR =", value, "homeAddr");
			return (Criteria) this;
		}

		public Criteria andHomeAddrNotEqualTo(String value) {
			addCriterion("HOME_ADDR <>", value, "homeAddr");
			return (Criteria) this;
		}

		public Criteria andHomeAddrGreaterThan(String value) {
			addCriterion("HOME_ADDR >", value, "homeAddr");
			return (Criteria) this;
		}

		public Criteria andHomeAddrGreaterThanOrEqualTo(String value) {
			addCriterion("HOME_ADDR >=", value, "homeAddr");
			return (Criteria) this;
		}

		public Criteria andHomeAddrLessThan(String value) {
			addCriterion("HOME_ADDR <", value, "homeAddr");
			return (Criteria) this;
		}

		public Criteria andHomeAddrLessThanOrEqualTo(String value) {
			addCriterion("HOME_ADDR <=", value, "homeAddr");
			return (Criteria) this;
		}

		public Criteria andHomeAddrLike(String value) {
			addCriterion("HOME_ADDR like", value, "homeAddr");
			return (Criteria) this;
		}

		public Criteria andHomeAddrNotLike(String value) {
			addCriterion("HOME_ADDR not like", value, "homeAddr");
			return (Criteria) this;
		}

		public Criteria andHomeAddrIn(List<String> values) {
			addCriterion("HOME_ADDR in", values, "homeAddr");
			return (Criteria) this;
		}

		public Criteria andHomeAddrNotIn(List<String> values) {
			addCriterion("HOME_ADDR not in", values, "homeAddr");
			return (Criteria) this;
		}

		public Criteria andHomeAddrBetween(String value1, String value2) {
			addCriterion("HOME_ADDR between", value1, value2, "homeAddr");
			return (Criteria) this;
		}

		public Criteria andHomeAddrNotBetween(String value1, String value2) {
			addCriterion("HOME_ADDR not between", value1, value2, "homeAddr");
			return (Criteria) this;
		}

		public Criteria andHomeZipIsNull() {
			addCriterion("HOME_ZIP is null");
			return (Criteria) this;
		}

		public Criteria andHomeZipIsNotNull() {
			addCriterion("HOME_ZIP is not null");
			return (Criteria) this;
		}

		public Criteria andHomeZipEqualTo(String value) {
			addCriterion("HOME_ZIP =", value, "homeZip");
			return (Criteria) this;
		}

		public Criteria andHomeZipNotEqualTo(String value) {
			addCriterion("HOME_ZIP <>", value, "homeZip");
			return (Criteria) this;
		}

		public Criteria andHomeZipGreaterThan(String value) {
			addCriterion("HOME_ZIP >", value, "homeZip");
			return (Criteria) this;
		}

		public Criteria andHomeZipGreaterThanOrEqualTo(String value) {
			addCriterion("HOME_ZIP >=", value, "homeZip");
			return (Criteria) this;
		}

		public Criteria andHomeZipLessThan(String value) {
			addCriterion("HOME_ZIP <", value, "homeZip");
			return (Criteria) this;
		}

		public Criteria andHomeZipLessThanOrEqualTo(String value) {
			addCriterion("HOME_ZIP <=", value, "homeZip");
			return (Criteria) this;
		}

		public Criteria andHomeZipLike(String value) {
			addCriterion("HOME_ZIP like", value, "homeZip");
			return (Criteria) this;
		}

		public Criteria andHomeZipNotLike(String value) {
			addCriterion("HOME_ZIP not like", value, "homeZip");
			return (Criteria) this;
		}

		public Criteria andHomeZipIn(List<String> values) {
			addCriterion("HOME_ZIP in", values, "homeZip");
			return (Criteria) this;
		}

		public Criteria andHomeZipNotIn(List<String> values) {
			addCriterion("HOME_ZIP not in", values, "homeZip");
			return (Criteria) this;
		}

		public Criteria andHomeZipBetween(String value1, String value2) {
			addCriterion("HOME_ZIP between", value1, value2, "homeZip");
			return (Criteria) this;
		}

		public Criteria andHomeZipNotBetween(String value1, String value2) {
			addCriterion("HOME_ZIP not between", value1, value2, "homeZip");
			return (Criteria) this;
		}

		public Criteria andResidentStatusIsNull() {
			addCriterion("RESIDENT_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andResidentStatusIsNotNull() {
			addCriterion("RESIDENT_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andResidentStatusEqualTo(String value) {
			addCriterion("RESIDENT_STATUS =", value, "residentStatus");
			return (Criteria) this;
		}

		public Criteria andResidentStatusNotEqualTo(String value) {
			addCriterion("RESIDENT_STATUS <>", value, "residentStatus");
			return (Criteria) this;
		}

		public Criteria andResidentStatusGreaterThan(String value) {
			addCriterion("RESIDENT_STATUS >", value, "residentStatus");
			return (Criteria) this;
		}

		public Criteria andResidentStatusGreaterThanOrEqualTo(String value) {
			addCriterion("RESIDENT_STATUS >=", value, "residentStatus");
			return (Criteria) this;
		}

		public Criteria andResidentStatusLessThan(String value) {
			addCriterion("RESIDENT_STATUS <", value, "residentStatus");
			return (Criteria) this;
		}

		public Criteria andResidentStatusLessThanOrEqualTo(String value) {
			addCriterion("RESIDENT_STATUS <=", value, "residentStatus");
			return (Criteria) this;
		}

		public Criteria andResidentStatusLike(String value) {
			addCriterion("RESIDENT_STATUS like", value, "residentStatus");
			return (Criteria) this;
		}

		public Criteria andResidentStatusNotLike(String value) {
			addCriterion("RESIDENT_STATUS not like", value, "residentStatus");
			return (Criteria) this;
		}

		public Criteria andResidentStatusIn(List<String> values) {
			addCriterion("RESIDENT_STATUS in", values, "residentStatus");
			return (Criteria) this;
		}

		public Criteria andResidentStatusNotIn(List<String> values) {
			addCriterion("RESIDENT_STATUS not in", values, "residentStatus");
			return (Criteria) this;
		}

		public Criteria andResidentStatusBetween(String value1, String value2) {
			addCriterion("RESIDENT_STATUS between", value1, value2, "residentStatus");
			return (Criteria) this;
		}

		public Criteria andResidentStatusNotBetween(String value1, String value2) {
			addCriterion("RESIDENT_STATUS not between", value1, value2, "residentStatus");
			return (Criteria) this;
		}

		public Criteria andLiveStartTimeIsNull() {
			addCriterion("LIVE_START_TIME is null");
			return (Criteria) this;
		}

		public Criteria andLiveStartTimeIsNotNull() {
			addCriterion("LIVE_START_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andLiveStartTimeEqualTo(Date value) {
			addCriterionForJDBCDate("LIVE_START_TIME =", value, "liveStartTime");
			return (Criteria) this;
		}

		public Criteria andLiveStartTimeNotEqualTo(Date value) {
			addCriterionForJDBCDate("LIVE_START_TIME <>", value, "liveStartTime");
			return (Criteria) this;
		}

		public Criteria andLiveStartTimeGreaterThan(Date value) {
			addCriterionForJDBCDate("LIVE_START_TIME >", value, "liveStartTime");
			return (Criteria) this;
		}

		public Criteria andLiveStartTimeGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("LIVE_START_TIME >=", value, "liveStartTime");
			return (Criteria) this;
		}

		public Criteria andLiveStartTimeLessThan(Date value) {
			addCriterionForJDBCDate("LIVE_START_TIME <", value, "liveStartTime");
			return (Criteria) this;
		}

		public Criteria andLiveStartTimeLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("LIVE_START_TIME <=", value, "liveStartTime");
			return (Criteria) this;
		}

		public Criteria andLiveStartTimeIn(List<Date> values) {
			addCriterionForJDBCDate("LIVE_START_TIME in", values, "liveStartTime");
			return (Criteria) this;
		}

		public Criteria andLiveStartTimeNotIn(List<Date> values) {
			addCriterionForJDBCDate("LIVE_START_TIME not in", values, "liveStartTime");
			return (Criteria) this;
		}

		public Criteria andLiveStartTimeBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("LIVE_START_TIME between", value1, value2, "liveStartTime");
			return (Criteria) this;
		}

		public Criteria andLiveStartTimeNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("LIVE_START_TIME not between", value1, value2, "liveStartTime");
			return (Criteria) this;
		}

		public Criteria andCarBrandIsNull() {
			addCriterion("CAR_BRAND is null");
			return (Criteria) this;
		}

		public Criteria andCarBrandIsNotNull() {
			addCriterion("CAR_BRAND is not null");
			return (Criteria) this;
		}

		public Criteria andCarBrandEqualTo(String value) {
			addCriterion("CAR_BRAND =", value, "carBrand");
			return (Criteria) this;
		}

		public Criteria andCarBrandNotEqualTo(String value) {
			addCriterion("CAR_BRAND <>", value, "carBrand");
			return (Criteria) this;
		}

		public Criteria andCarBrandGreaterThan(String value) {
			addCriterion("CAR_BRAND >", value, "carBrand");
			return (Criteria) this;
		}

		public Criteria andCarBrandGreaterThanOrEqualTo(String value) {
			addCriterion("CAR_BRAND >=", value, "carBrand");
			return (Criteria) this;
		}

		public Criteria andCarBrandLessThan(String value) {
			addCriterion("CAR_BRAND <", value, "carBrand");
			return (Criteria) this;
		}

		public Criteria andCarBrandLessThanOrEqualTo(String value) {
			addCriterion("CAR_BRAND <=", value, "carBrand");
			return (Criteria) this;
		}

		public Criteria andCarBrandLike(String value) {
			addCriterion("CAR_BRAND like", value, "carBrand");
			return (Criteria) this;
		}

		public Criteria andCarBrandNotLike(String value) {
			addCriterion("CAR_BRAND not like", value, "carBrand");
			return (Criteria) this;
		}

		public Criteria andCarBrandIn(List<String> values) {
			addCriterion("CAR_BRAND in", values, "carBrand");
			return (Criteria) this;
		}

		public Criteria andCarBrandNotIn(List<String> values) {
			addCriterion("CAR_BRAND not in", values, "carBrand");
			return (Criteria) this;
		}

		public Criteria andCarBrandBetween(String value1, String value2) {
			addCriterion("CAR_BRAND between", value1, value2, "carBrand");
			return (Criteria) this;
		}

		public Criteria andCarBrandNotBetween(String value1, String value2) {
			addCriterion("CAR_BRAND not between", value1, value2, "carBrand");
			return (Criteria) this;
		}

		public Criteria andCarNoIsNull() {
			addCriterion("CAR_NO is null");
			return (Criteria) this;
		}

		public Criteria andCarNoIsNotNull() {
			addCriterion("CAR_NO is not null");
			return (Criteria) this;
		}

		public Criteria andCarNoEqualTo(String value) {
			addCriterion("CAR_NO =", value, "carNo");
			return (Criteria) this;
		}

		public Criteria andCarNoNotEqualTo(String value) {
			addCriterion("CAR_NO <>", value, "carNo");
			return (Criteria) this;
		}

		public Criteria andCarNoGreaterThan(String value) {
			addCriterion("CAR_NO >", value, "carNo");
			return (Criteria) this;
		}

		public Criteria andCarNoGreaterThanOrEqualTo(String value) {
			addCriterion("CAR_NO >=", value, "carNo");
			return (Criteria) this;
		}

		public Criteria andCarNoLessThan(String value) {
			addCriterion("CAR_NO <", value, "carNo");
			return (Criteria) this;
		}

		public Criteria andCarNoLessThanOrEqualTo(String value) {
			addCriterion("CAR_NO <=", value, "carNo");
			return (Criteria) this;
		}

		public Criteria andCarNoLike(String value) {
			addCriterion("CAR_NO like", value, "carNo");
			return (Criteria) this;
		}

		public Criteria andCarNoNotLike(String value) {
			addCriterion("CAR_NO not like", value, "carNo");
			return (Criteria) this;
		}

		public Criteria andCarNoIn(List<String> values) {
			addCriterion("CAR_NO in", values, "carNo");
			return (Criteria) this;
		}

		public Criteria andCarNoNotIn(List<String> values) {
			addCriterion("CAR_NO not in", values, "carNo");
			return (Criteria) this;
		}

		public Criteria andCarNoBetween(String value1, String value2) {
			addCriterion("CAR_NO between", value1, value2, "carNo");
			return (Criteria) this;
		}

		public Criteria andCarNoNotBetween(String value1, String value2) {
			addCriterion("CAR_NO not between", value1, value2, "carNo");
			return (Criteria) this;
		}

		public Criteria andCarStatusIsNull() {
			addCriterion("CAR_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andCarStatusIsNotNull() {
			addCriterion("CAR_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andCarStatusEqualTo(String value) {
			addCriterion("CAR_STATUS =", value, "carStatus");
			return (Criteria) this;
		}

		public Criteria andCarStatusNotEqualTo(String value) {
			addCriterion("CAR_STATUS <>", value, "carStatus");
			return (Criteria) this;
		}

		public Criteria andCarStatusGreaterThan(String value) {
			addCriterion("CAR_STATUS >", value, "carStatus");
			return (Criteria) this;
		}

		public Criteria andCarStatusGreaterThanOrEqualTo(String value) {
			addCriterion("CAR_STATUS >=", value, "carStatus");
			return (Criteria) this;
		}

		public Criteria andCarStatusLessThan(String value) {
			addCriterion("CAR_STATUS <", value, "carStatus");
			return (Criteria) this;
		}

		public Criteria andCarStatusLessThanOrEqualTo(String value) {
			addCriterion("CAR_STATUS <=", value, "carStatus");
			return (Criteria) this;
		}

		public Criteria andCarStatusLike(String value) {
			addCriterion("CAR_STATUS like", value, "carStatus");
			return (Criteria) this;
		}

		public Criteria andCarStatusNotLike(String value) {
			addCriterion("CAR_STATUS not like", value, "carStatus");
			return (Criteria) this;
		}

		public Criteria andCarStatusIn(List<String> values) {
			addCriterion("CAR_STATUS in", values, "carStatus");
			return (Criteria) this;
		}

		public Criteria andCarStatusNotIn(List<String> values) {
			addCriterion("CAR_STATUS not in", values, "carStatus");
			return (Criteria) this;
		}

		public Criteria andCarStatusBetween(String value1, String value2) {
			addCriterion("CAR_STATUS between", value1, value2, "carStatus");
			return (Criteria) this;
		}

		public Criteria andCarStatusNotBetween(String value1, String value2) {
			addCriterion("CAR_STATUS not between", value1, value2, "carStatus");
			return (Criteria) this;
		}

		public Criteria andCarBuyDateIsNull() {
			addCriterion("CAR_BUY_DATE is null");
			return (Criteria) this;
		}

		public Criteria andCarBuyDateIsNotNull() {
			addCriterion("CAR_BUY_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andCarBuyDateEqualTo(Date value) {
			addCriterionForJDBCDate("CAR_BUY_DATE =", value, "carBuyDate");
			return (Criteria) this;
		}

		public Criteria andCarBuyDateNotEqualTo(Date value) {
			addCriterionForJDBCDate("CAR_BUY_DATE <>", value, "carBuyDate");
			return (Criteria) this;
		}

		public Criteria andCarBuyDateGreaterThan(Date value) {
			addCriterionForJDBCDate("CAR_BUY_DATE >", value, "carBuyDate");
			return (Criteria) this;
		}

		public Criteria andCarBuyDateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("CAR_BUY_DATE >=", value, "carBuyDate");
			return (Criteria) this;
		}

		public Criteria andCarBuyDateLessThan(Date value) {
			addCriterionForJDBCDate("CAR_BUY_DATE <", value, "carBuyDate");
			return (Criteria) this;
		}

		public Criteria andCarBuyDateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("CAR_BUY_DATE <=", value, "carBuyDate");
			return (Criteria) this;
		}

		public Criteria andCarBuyDateIn(List<Date> values) {
			addCriterionForJDBCDate("CAR_BUY_DATE in", values, "carBuyDate");
			return (Criteria) this;
		}

		public Criteria andCarBuyDateNotIn(List<Date> values) {
			addCriterionForJDBCDate("CAR_BUY_DATE not in", values, "carBuyDate");
			return (Criteria) this;
		}

		public Criteria andCarBuyDateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("CAR_BUY_DATE between", value1, value2, "carBuyDate");
			return (Criteria) this;
		}

		public Criteria andCarBuyDateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("CAR_BUY_DATE not between", value1, value2, "carBuyDate");
			return (Criteria) this;
		}

		public Criteria andDepositIsNull() {
			addCriterion("DEPOSIT is null");
			return (Criteria) this;
		}

		public Criteria andDepositIsNotNull() {
			addCriterion("DEPOSIT is not null");
			return (Criteria) this;
		}

		public Criteria andDepositEqualTo(BigDecimal value) {
			addCriterion("DEPOSIT =", value, "deposit");
			return (Criteria) this;
		}

		public Criteria andDepositNotEqualTo(BigDecimal value) {
			addCriterion("DEPOSIT <>", value, "deposit");
			return (Criteria) this;
		}

		public Criteria andDepositGreaterThan(BigDecimal value) {
			addCriterion("DEPOSIT >", value, "deposit");
			return (Criteria) this;
		}

		public Criteria andDepositGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("DEPOSIT >=", value, "deposit");
			return (Criteria) this;
		}

		public Criteria andDepositLessThan(BigDecimal value) {
			addCriterion("DEPOSIT <", value, "deposit");
			return (Criteria) this;
		}

		public Criteria andDepositLessThanOrEqualTo(BigDecimal value) {
			addCriterion("DEPOSIT <=", value, "deposit");
			return (Criteria) this;
		}

		public Criteria andDepositIn(List<BigDecimal> values) {
			addCriterion("DEPOSIT in", values, "deposit");
			return (Criteria) this;
		}

		public Criteria andDepositNotIn(List<BigDecimal> values) {
			addCriterion("DEPOSIT not in", values, "deposit");
			return (Criteria) this;
		}

		public Criteria andDepositBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("DEPOSIT between", value1, value2, "deposit");
			return (Criteria) this;
		}

		public Criteria andDepositNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("DEPOSIT not between", value1, value2, "deposit");
			return (Criteria) this;
		}

		public Criteria andStockValueIsNull() {
			addCriterion("STOCK_VALUE is null");
			return (Criteria) this;
		}

		public Criteria andStockValueIsNotNull() {
			addCriterion("STOCK_VALUE is not null");
			return (Criteria) this;
		}

		public Criteria andStockValueEqualTo(BigDecimal value) {
			addCriterion("STOCK_VALUE =", value, "stockValue");
			return (Criteria) this;
		}

		public Criteria andStockValueNotEqualTo(BigDecimal value) {
			addCriterion("STOCK_VALUE <>", value, "stockValue");
			return (Criteria) this;
		}

		public Criteria andStockValueGreaterThan(BigDecimal value) {
			addCriterion("STOCK_VALUE >", value, "stockValue");
			return (Criteria) this;
		}

		public Criteria andStockValueGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("STOCK_VALUE >=", value, "stockValue");
			return (Criteria) this;
		}

		public Criteria andStockValueLessThan(BigDecimal value) {
			addCriterion("STOCK_VALUE <", value, "stockValue");
			return (Criteria) this;
		}

		public Criteria andStockValueLessThanOrEqualTo(BigDecimal value) {
			addCriterion("STOCK_VALUE <=", value, "stockValue");
			return (Criteria) this;
		}

		public Criteria andStockValueIn(List<BigDecimal> values) {
			addCriterion("STOCK_VALUE in", values, "stockValue");
			return (Criteria) this;
		}

		public Criteria andStockValueNotIn(List<BigDecimal> values) {
			addCriterion("STOCK_VALUE not in", values, "stockValue");
			return (Criteria) this;
		}

		public Criteria andStockValueBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("STOCK_VALUE between", value1, value2, "stockValue");
			return (Criteria) this;
		}

		public Criteria andStockValueNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("STOCK_VALUE not between", value1, value2, "stockValue");
			return (Criteria) this;
		}

		public Criteria andMonthIncomeIsNull() {
			addCriterion("MONTH_INCOME is null");
			return (Criteria) this;
		}

		public Criteria andMonthIncomeIsNotNull() {
			addCriterion("MONTH_INCOME is not null");
			return (Criteria) this;
		}

		public Criteria andMonthIncomeEqualTo(BigDecimal value) {
			addCriterion("MONTH_INCOME =", value, "monthIncome");
			return (Criteria) this;
		}

		public Criteria andMonthIncomeNotEqualTo(BigDecimal value) {
			addCriterion("MONTH_INCOME <>", value, "monthIncome");
			return (Criteria) this;
		}

		public Criteria andMonthIncomeGreaterThan(BigDecimal value) {
			addCriterion("MONTH_INCOME >", value, "monthIncome");
			return (Criteria) this;
		}

		public Criteria andMonthIncomeGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("MONTH_INCOME >=", value, "monthIncome");
			return (Criteria) this;
		}

		public Criteria andMonthIncomeLessThan(BigDecimal value) {
			addCriterion("MONTH_INCOME <", value, "monthIncome");
			return (Criteria) this;
		}

		public Criteria andMonthIncomeLessThanOrEqualTo(BigDecimal value) {
			addCriterion("MONTH_INCOME <=", value, "monthIncome");
			return (Criteria) this;
		}

		public Criteria andMonthIncomeIn(List<BigDecimal> values) {
			addCriterion("MONTH_INCOME in", values, "monthIncome");
			return (Criteria) this;
		}

		public Criteria andMonthIncomeNotIn(List<BigDecimal> values) {
			addCriterion("MONTH_INCOME not in", values, "monthIncome");
			return (Criteria) this;
		}

		public Criteria andMonthIncomeBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("MONTH_INCOME between", value1, value2, "monthIncome");
			return (Criteria) this;
		}

		public Criteria andMonthIncomeNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("MONTH_INCOME not between", value1, value2, "monthIncome");
			return (Criteria) this;
		}

		public Criteria andSpouseMonthIncomeIsNull() {
			addCriterion("SPOUSE_MONTH_INCOME is null");
			return (Criteria) this;
		}

		public Criteria andSpouseMonthIncomeIsNotNull() {
			addCriterion("SPOUSE_MONTH_INCOME is not null");
			return (Criteria) this;
		}

		public Criteria andSpouseMonthIncomeEqualTo(BigDecimal value) {
			addCriterion("SPOUSE_MONTH_INCOME =", value, "spouseMonthIncome");
			return (Criteria) this;
		}

		public Criteria andSpouseMonthIncomeNotEqualTo(BigDecimal value) {
			addCriterion("SPOUSE_MONTH_INCOME <>", value, "spouseMonthIncome");
			return (Criteria) this;
		}

		public Criteria andSpouseMonthIncomeGreaterThan(BigDecimal value) {
			addCriterion("SPOUSE_MONTH_INCOME >", value, "spouseMonthIncome");
			return (Criteria) this;
		}

		public Criteria andSpouseMonthIncomeGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("SPOUSE_MONTH_INCOME >=", value, "spouseMonthIncome");
			return (Criteria) this;
		}

		public Criteria andSpouseMonthIncomeLessThan(BigDecimal value) {
			addCriterion("SPOUSE_MONTH_INCOME <", value, "spouseMonthIncome");
			return (Criteria) this;
		}

		public Criteria andSpouseMonthIncomeLessThanOrEqualTo(BigDecimal value) {
			addCriterion("SPOUSE_MONTH_INCOME <=", value, "spouseMonthIncome");
			return (Criteria) this;
		}

		public Criteria andSpouseMonthIncomeIn(List<BigDecimal> values) {
			addCriterion("SPOUSE_MONTH_INCOME in", values, "spouseMonthIncome");
			return (Criteria) this;
		}

		public Criteria andSpouseMonthIncomeNotIn(List<BigDecimal> values) {
			addCriterion("SPOUSE_MONTH_INCOME not in", values, "spouseMonthIncome");
			return (Criteria) this;
		}

		public Criteria andSpouseMonthIncomeBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SPOUSE_MONTH_INCOME between", value1, value2, "spouseMonthIncome");
			return (Criteria) this;
		}

		public Criteria andSpouseMonthIncomeNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("SPOUSE_MONTH_INCOME not between", value1, value2, "spouseMonthIncome");
			return (Criteria) this;
		}

		public Criteria andHomeIncomeIsNull() {
			addCriterion("HOME_INCOME is null");
			return (Criteria) this;
		}

		public Criteria andHomeIncomeIsNotNull() {
			addCriterion("HOME_INCOME is not null");
			return (Criteria) this;
		}

		public Criteria andHomeIncomeEqualTo(BigDecimal value) {
			addCriterion("HOME_INCOME =", value, "homeIncome");
			return (Criteria) this;
		}

		public Criteria andHomeIncomeNotEqualTo(BigDecimal value) {
			addCriterion("HOME_INCOME <>", value, "homeIncome");
			return (Criteria) this;
		}

		public Criteria andHomeIncomeGreaterThan(BigDecimal value) {
			addCriterion("HOME_INCOME >", value, "homeIncome");
			return (Criteria) this;
		}

		public Criteria andHomeIncomeGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("HOME_INCOME >=", value, "homeIncome");
			return (Criteria) this;
		}

		public Criteria andHomeIncomeLessThan(BigDecimal value) {
			addCriterion("HOME_INCOME <", value, "homeIncome");
			return (Criteria) this;
		}

		public Criteria andHomeIncomeLessThanOrEqualTo(BigDecimal value) {
			addCriterion("HOME_INCOME <=", value, "homeIncome");
			return (Criteria) this;
		}

		public Criteria andHomeIncomeIn(List<BigDecimal> values) {
			addCriterion("HOME_INCOME in", values, "homeIncome");
			return (Criteria) this;
		}

		public Criteria andHomeIncomeNotIn(List<BigDecimal> values) {
			addCriterion("HOME_INCOME not in", values, "homeIncome");
			return (Criteria) this;
		}

		public Criteria andHomeIncomeBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("HOME_INCOME between", value1, value2, "homeIncome");
			return (Criteria) this;
		}

		public Criteria andHomeIncomeNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("HOME_INCOME not between", value1, value2, "homeIncome");
			return (Criteria) this;
		}

		public Criteria andLiabilitiesIsNull() {
			addCriterion("LIABILITIES is null");
			return (Criteria) this;
		}

		public Criteria andLiabilitiesIsNotNull() {
			addCriterion("LIABILITIES is not null");
			return (Criteria) this;
		}

		public Criteria andLiabilitiesEqualTo(BigDecimal value) {
			addCriterion("LIABILITIES =", value, "liabilities");
			return (Criteria) this;
		}

		public Criteria andLiabilitiesNotEqualTo(BigDecimal value) {
			addCriterion("LIABILITIES <>", value, "liabilities");
			return (Criteria) this;
		}

		public Criteria andLiabilitiesGreaterThan(BigDecimal value) {
			addCriterion("LIABILITIES >", value, "liabilities");
			return (Criteria) this;
		}

		public Criteria andLiabilitiesGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("LIABILITIES >=", value, "liabilities");
			return (Criteria) this;
		}

		public Criteria andLiabilitiesLessThan(BigDecimal value) {
			addCriterion("LIABILITIES <", value, "liabilities");
			return (Criteria) this;
		}

		public Criteria andLiabilitiesLessThanOrEqualTo(BigDecimal value) {
			addCriterion("LIABILITIES <=", value, "liabilities");
			return (Criteria) this;
		}

		public Criteria andLiabilitiesIn(List<BigDecimal> values) {
			addCriterion("LIABILITIES in", values, "liabilities");
			return (Criteria) this;
		}

		public Criteria andLiabilitiesNotIn(List<BigDecimal> values) {
			addCriterion("LIABILITIES not in", values, "liabilities");
			return (Criteria) this;
		}

		public Criteria andLiabilitiesBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LIABILITIES between", value1, value2, "liabilities");
			return (Criteria) this;
		}

		public Criteria andLiabilitiesNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LIABILITIES not between", value1, value2, "liabilities");
			return (Criteria) this;
		}

		public Criteria andHasDowryContractIsNull() {
			addCriterion("HAS_DOWRY_CONTRACT is null");
			return (Criteria) this;
		}

		public Criteria andHasDowryContractIsNotNull() {
			addCriterion("HAS_DOWRY_CONTRACT is not null");
			return (Criteria) this;
		}

		public Criteria andHasDowryContractEqualTo(String value) {
			addCriterion("HAS_DOWRY_CONTRACT =", value, "hasDowryContract");
			return (Criteria) this;
		}

		public Criteria andHasDowryContractNotEqualTo(String value) {
			addCriterion("HAS_DOWRY_CONTRACT <>", value, "hasDowryContract");
			return (Criteria) this;
		}

		public Criteria andHasDowryContractGreaterThan(String value) {
			addCriterion("HAS_DOWRY_CONTRACT >", value, "hasDowryContract");
			return (Criteria) this;
		}

		public Criteria andHasDowryContractGreaterThanOrEqualTo(String value) {
			addCriterion("HAS_DOWRY_CONTRACT >=", value, "hasDowryContract");
			return (Criteria) this;
		}

		public Criteria andHasDowryContractLessThan(String value) {
			addCriterion("HAS_DOWRY_CONTRACT <", value, "hasDowryContract");
			return (Criteria) this;
		}

		public Criteria andHasDowryContractLessThanOrEqualTo(String value) {
			addCriterion("HAS_DOWRY_CONTRACT <=", value, "hasDowryContract");
			return (Criteria) this;
		}

		public Criteria andHasDowryContractLike(String value) {
			addCriterion("HAS_DOWRY_CONTRACT like", value, "hasDowryContract");
			return (Criteria) this;
		}

		public Criteria andHasDowryContractNotLike(String value) {
			addCriterion("HAS_DOWRY_CONTRACT not like", value, "hasDowryContract");
			return (Criteria) this;
		}

		public Criteria andHasDowryContractIn(List<String> values) {
			addCriterion("HAS_DOWRY_CONTRACT in", values, "hasDowryContract");
			return (Criteria) this;
		}

		public Criteria andHasDowryContractNotIn(List<String> values) {
			addCriterion("HAS_DOWRY_CONTRACT not in", values, "hasDowryContract");
			return (Criteria) this;
		}

		public Criteria andHasDowryContractBetween(String value1, String value2) {
			addCriterion("HAS_DOWRY_CONTRACT between", value1, value2, "hasDowryContract");
			return (Criteria) this;
		}

		public Criteria andHasDowryContractNotBetween(String value1, String value2) {
			addCriterion("HAS_DOWRY_CONTRACT not between", value1, value2, "hasDowryContract");
			return (Criteria) this;
		}

		public Criteria andSpouseNameIsNull() {
			addCriterion("SPOUSE_NAME is null");
			return (Criteria) this;
		}

		public Criteria andSpouseNameIsNotNull() {
			addCriterion("SPOUSE_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andSpouseNameEqualTo(String value) {
			addCriterion("SPOUSE_NAME =", value, "spouseName");
			return (Criteria) this;
		}

		public Criteria andSpouseNameNotEqualTo(String value) {
			addCriterion("SPOUSE_NAME <>", value, "spouseName");
			return (Criteria) this;
		}

		public Criteria andSpouseNameGreaterThan(String value) {
			addCriterion("SPOUSE_NAME >", value, "spouseName");
			return (Criteria) this;
		}

		public Criteria andSpouseNameGreaterThanOrEqualTo(String value) {
			addCriterion("SPOUSE_NAME >=", value, "spouseName");
			return (Criteria) this;
		}

		public Criteria andSpouseNameLessThan(String value) {
			addCriterion("SPOUSE_NAME <", value, "spouseName");
			return (Criteria) this;
		}

		public Criteria andSpouseNameLessThanOrEqualTo(String value) {
			addCriterion("SPOUSE_NAME <=", value, "spouseName");
			return (Criteria) this;
		}

		public Criteria andSpouseNameLike(String value) {
			addCriterion("SPOUSE_NAME like", value, "spouseName");
			return (Criteria) this;
		}

		public Criteria andSpouseNameNotLike(String value) {
			addCriterion("SPOUSE_NAME not like", value, "spouseName");
			return (Criteria) this;
		}

		public Criteria andSpouseNameIn(List<String> values) {
			addCriterion("SPOUSE_NAME in", values, "spouseName");
			return (Criteria) this;
		}

		public Criteria andSpouseNameNotIn(List<String> values) {
			addCriterion("SPOUSE_NAME not in", values, "spouseName");
			return (Criteria) this;
		}

		public Criteria andSpouseNameBetween(String value1, String value2) {
			addCriterion("SPOUSE_NAME between", value1, value2, "spouseName");
			return (Criteria) this;
		}

		public Criteria andSpouseNameNotBetween(String value1, String value2) {
			addCriterion("SPOUSE_NAME not between", value1, value2, "spouseName");
			return (Criteria) this;
		}

		public Criteria andSpouseIdTypeIsNull() {
			addCriterion("SPOUSE_ID_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andSpouseIdTypeIsNotNull() {
			addCriterion("SPOUSE_ID_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andSpouseIdTypeEqualTo(String value) {
			addCriterion("SPOUSE_ID_TYPE =", value, "spouseIdType");
			return (Criteria) this;
		}

		public Criteria andSpouseIdTypeNotEqualTo(String value) {
			addCriterion("SPOUSE_ID_TYPE <>", value, "spouseIdType");
			return (Criteria) this;
		}

		public Criteria andSpouseIdTypeGreaterThan(String value) {
			addCriterion("SPOUSE_ID_TYPE >", value, "spouseIdType");
			return (Criteria) this;
		}

		public Criteria andSpouseIdTypeGreaterThanOrEqualTo(String value) {
			addCriterion("SPOUSE_ID_TYPE >=", value, "spouseIdType");
			return (Criteria) this;
		}

		public Criteria andSpouseIdTypeLessThan(String value) {
			addCriterion("SPOUSE_ID_TYPE <", value, "spouseIdType");
			return (Criteria) this;
		}

		public Criteria andSpouseIdTypeLessThanOrEqualTo(String value) {
			addCriterion("SPOUSE_ID_TYPE <=", value, "spouseIdType");
			return (Criteria) this;
		}

		public Criteria andSpouseIdTypeLike(String value) {
			addCriterion("SPOUSE_ID_TYPE like", value, "spouseIdType");
			return (Criteria) this;
		}

		public Criteria andSpouseIdTypeNotLike(String value) {
			addCriterion("SPOUSE_ID_TYPE not like", value, "spouseIdType");
			return (Criteria) this;
		}

		public Criteria andSpouseIdTypeIn(List<String> values) {
			addCriterion("SPOUSE_ID_TYPE in", values, "spouseIdType");
			return (Criteria) this;
		}

		public Criteria andSpouseIdTypeNotIn(List<String> values) {
			addCriterion("SPOUSE_ID_TYPE not in", values, "spouseIdType");
			return (Criteria) this;
		}

		public Criteria andSpouseIdTypeBetween(String value1, String value2) {
			addCriterion("SPOUSE_ID_TYPE between", value1, value2, "spouseIdType");
			return (Criteria) this;
		}

		public Criteria andSpouseIdTypeNotBetween(String value1, String value2) {
			addCriterion("SPOUSE_ID_TYPE not between", value1, value2, "spouseIdType");
			return (Criteria) this;
		}

		public Criteria andSpouseIdNoIsNull() {
			addCriterion("SPOUSE_ID_NO is null");
			return (Criteria) this;
		}

		public Criteria andSpouseIdNoIsNotNull() {
			addCriterion("SPOUSE_ID_NO is not null");
			return (Criteria) this;
		}

		public Criteria andSpouseIdNoEqualTo(String value) {
			addCriterion("SPOUSE_ID_NO =", value, "spouseIdNo");
			return (Criteria) this;
		}

		public Criteria andSpouseIdNoNotEqualTo(String value) {
			addCriterion("SPOUSE_ID_NO <>", value, "spouseIdNo");
			return (Criteria) this;
		}

		public Criteria andSpouseIdNoGreaterThan(String value) {
			addCriterion("SPOUSE_ID_NO >", value, "spouseIdNo");
			return (Criteria) this;
		}

		public Criteria andSpouseIdNoGreaterThanOrEqualTo(String value) {
			addCriterion("SPOUSE_ID_NO >=", value, "spouseIdNo");
			return (Criteria) this;
		}

		public Criteria andSpouseIdNoLessThan(String value) {
			addCriterion("SPOUSE_ID_NO <", value, "spouseIdNo");
			return (Criteria) this;
		}

		public Criteria andSpouseIdNoLessThanOrEqualTo(String value) {
			addCriterion("SPOUSE_ID_NO <=", value, "spouseIdNo");
			return (Criteria) this;
		}

		public Criteria andSpouseIdNoLike(String value) {
			addCriterion("SPOUSE_ID_NO like", value, "spouseIdNo");
			return (Criteria) this;
		}

		public Criteria andSpouseIdNoNotLike(String value) {
			addCriterion("SPOUSE_ID_NO not like", value, "spouseIdNo");
			return (Criteria) this;
		}

		public Criteria andSpouseIdNoIn(List<String> values) {
			addCriterion("SPOUSE_ID_NO in", values, "spouseIdNo");
			return (Criteria) this;
		}

		public Criteria andSpouseIdNoNotIn(List<String> values) {
			addCriterion("SPOUSE_ID_NO not in", values, "spouseIdNo");
			return (Criteria) this;
		}

		public Criteria andSpouseIdNoBetween(String value1, String value2) {
			addCriterion("SPOUSE_ID_NO between", value1, value2, "spouseIdNo");
			return (Criteria) this;
		}

		public Criteria andSpouseIdNoNotBetween(String value1, String value2) {
			addCriterion("SPOUSE_ID_NO not between", value1, value2, "spouseIdNo");
			return (Criteria) this;
		}

		public Criteria andSpouseIdSignDateIsNull() {
			addCriterion("SPOUSE_ID_SIGN_DATE is null");
			return (Criteria) this;
		}

		public Criteria andSpouseIdSignDateIsNotNull() {
			addCriterion("SPOUSE_ID_SIGN_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andSpouseIdSignDateEqualTo(Date value) {
			addCriterionForJDBCDate("SPOUSE_ID_SIGN_DATE =", value, "spouseIdSignDate");
			return (Criteria) this;
		}

		public Criteria andSpouseIdSignDateNotEqualTo(Date value) {
			addCriterionForJDBCDate("SPOUSE_ID_SIGN_DATE <>", value, "spouseIdSignDate");
			return (Criteria) this;
		}

		public Criteria andSpouseIdSignDateGreaterThan(Date value) {
			addCriterionForJDBCDate("SPOUSE_ID_SIGN_DATE >", value, "spouseIdSignDate");
			return (Criteria) this;
		}

		public Criteria andSpouseIdSignDateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("SPOUSE_ID_SIGN_DATE >=", value, "spouseIdSignDate");
			return (Criteria) this;
		}

		public Criteria andSpouseIdSignDateLessThan(Date value) {
			addCriterionForJDBCDate("SPOUSE_ID_SIGN_DATE <", value, "spouseIdSignDate");
			return (Criteria) this;
		}

		public Criteria andSpouseIdSignDateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("SPOUSE_ID_SIGN_DATE <=", value, "spouseIdSignDate");
			return (Criteria) this;
		}

		public Criteria andSpouseIdSignDateIn(List<Date> values) {
			addCriterionForJDBCDate("SPOUSE_ID_SIGN_DATE in", values, "spouseIdSignDate");
			return (Criteria) this;
		}

		public Criteria andSpouseIdSignDateNotIn(List<Date> values) {
			addCriterionForJDBCDate("SPOUSE_ID_SIGN_DATE not in", values, "spouseIdSignDate");
			return (Criteria) this;
		}

		public Criteria andSpouseIdSignDateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("SPOUSE_ID_SIGN_DATE between", value1, value2, "spouseIdSignDate");
			return (Criteria) this;
		}

		public Criteria andSpouseIdSignDateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("SPOUSE_ID_SIGN_DATE not between", value1, value2, "spouseIdSignDate");
			return (Criteria) this;
		}

		public Criteria andSpouseIdExpireDateIsNull() {
			addCriterion("SPOUSE_ID_EXPIRE_DATE is null");
			return (Criteria) this;
		}

		public Criteria andSpouseIdExpireDateIsNotNull() {
			addCriterion("SPOUSE_ID_EXPIRE_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andSpouseIdExpireDateEqualTo(Date value) {
			addCriterionForJDBCDate("SPOUSE_ID_EXPIRE_DATE =", value, "spouseIdExpireDate");
			return (Criteria) this;
		}

		public Criteria andSpouseIdExpireDateNotEqualTo(Date value) {
			addCriterionForJDBCDate("SPOUSE_ID_EXPIRE_DATE <>", value, "spouseIdExpireDate");
			return (Criteria) this;
		}

		public Criteria andSpouseIdExpireDateGreaterThan(Date value) {
			addCriterionForJDBCDate("SPOUSE_ID_EXPIRE_DATE >", value, "spouseIdExpireDate");
			return (Criteria) this;
		}

		public Criteria andSpouseIdExpireDateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("SPOUSE_ID_EXPIRE_DATE >=", value, "spouseIdExpireDate");
			return (Criteria) this;
		}

		public Criteria andSpouseIdExpireDateLessThan(Date value) {
			addCriterionForJDBCDate("SPOUSE_ID_EXPIRE_DATE <", value, "spouseIdExpireDate");
			return (Criteria) this;
		}

		public Criteria andSpouseIdExpireDateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("SPOUSE_ID_EXPIRE_DATE <=", value, "spouseIdExpireDate");
			return (Criteria) this;
		}

		public Criteria andSpouseIdExpireDateIn(List<Date> values) {
			addCriterionForJDBCDate("SPOUSE_ID_EXPIRE_DATE in", values, "spouseIdExpireDate");
			return (Criteria) this;
		}

		public Criteria andSpouseIdExpireDateNotIn(List<Date> values) {
			addCriterionForJDBCDate("SPOUSE_ID_EXPIRE_DATE not in", values, "spouseIdExpireDate");
			return (Criteria) this;
		}

		public Criteria andSpouseIdExpireDateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("SPOUSE_ID_EXPIRE_DATE between", value1, value2, "spouseIdExpireDate");
			return (Criteria) this;
		}

		public Criteria andSpouseIdExpireDateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("SPOUSE_ID_EXPIRE_DATE not between", value1, value2, "spouseIdExpireDate");
			return (Criteria) this;
		}

		public Criteria andSpouseIndustryTypeIsNull() {
			addCriterion("SPOUSE_INDUSTRY_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andSpouseIndustryTypeIsNotNull() {
			addCriterion("SPOUSE_INDUSTRY_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andSpouseIndustryTypeEqualTo(String value) {
			addCriterion("SPOUSE_INDUSTRY_TYPE =", value, "spouseIndustryType");
			return (Criteria) this;
		}

		public Criteria andSpouseIndustryTypeNotEqualTo(String value) {
			addCriterion("SPOUSE_INDUSTRY_TYPE <>", value, "spouseIndustryType");
			return (Criteria) this;
		}

		public Criteria andSpouseIndustryTypeGreaterThan(String value) {
			addCriterion("SPOUSE_INDUSTRY_TYPE >", value, "spouseIndustryType");
			return (Criteria) this;
		}

		public Criteria andSpouseIndustryTypeGreaterThanOrEqualTo(String value) {
			addCriterion("SPOUSE_INDUSTRY_TYPE >=", value, "spouseIndustryType");
			return (Criteria) this;
		}

		public Criteria andSpouseIndustryTypeLessThan(String value) {
			addCriterion("SPOUSE_INDUSTRY_TYPE <", value, "spouseIndustryType");
			return (Criteria) this;
		}

		public Criteria andSpouseIndustryTypeLessThanOrEqualTo(String value) {
			addCriterion("SPOUSE_INDUSTRY_TYPE <=", value, "spouseIndustryType");
			return (Criteria) this;
		}

		public Criteria andSpouseIndustryTypeLike(String value) {
			addCriterion("SPOUSE_INDUSTRY_TYPE like", value, "spouseIndustryType");
			return (Criteria) this;
		}

		public Criteria andSpouseIndustryTypeNotLike(String value) {
			addCriterion("SPOUSE_INDUSTRY_TYPE not like", value, "spouseIndustryType");
			return (Criteria) this;
		}

		public Criteria andSpouseIndustryTypeIn(List<String> values) {
			addCriterion("SPOUSE_INDUSTRY_TYPE in", values, "spouseIndustryType");
			return (Criteria) this;
		}

		public Criteria andSpouseIndustryTypeNotIn(List<String> values) {
			addCriterion("SPOUSE_INDUSTRY_TYPE not in", values, "spouseIndustryType");
			return (Criteria) this;
		}

		public Criteria andSpouseIndustryTypeBetween(String value1, String value2) {
			addCriterion("SPOUSE_INDUSTRY_TYPE between", value1, value2, "spouseIndustryType");
			return (Criteria) this;
		}

		public Criteria andSpouseIndustryTypeNotBetween(String value1, String value2) {
			addCriterion("SPOUSE_INDUSTRY_TYPE not between", value1, value2, "spouseIndustryType");
			return (Criteria) this;
		}

		public Criteria andSpouseCompanyIsNull() {
			addCriterion("SPOUSE_COMPANY is null");
			return (Criteria) this;
		}

		public Criteria andSpouseCompanyIsNotNull() {
			addCriterion("SPOUSE_COMPANY is not null");
			return (Criteria) this;
		}

		public Criteria andSpouseCompanyEqualTo(String value) {
			addCriterion("SPOUSE_COMPANY =", value, "spouseCompany");
			return (Criteria) this;
		}

		public Criteria andSpouseCompanyNotEqualTo(String value) {
			addCriterion("SPOUSE_COMPANY <>", value, "spouseCompany");
			return (Criteria) this;
		}

		public Criteria andSpouseCompanyGreaterThan(String value) {
			addCriterion("SPOUSE_COMPANY >", value, "spouseCompany");
			return (Criteria) this;
		}

		public Criteria andSpouseCompanyGreaterThanOrEqualTo(String value) {
			addCriterion("SPOUSE_COMPANY >=", value, "spouseCompany");
			return (Criteria) this;
		}

		public Criteria andSpouseCompanyLessThan(String value) {
			addCriterion("SPOUSE_COMPANY <", value, "spouseCompany");
			return (Criteria) this;
		}

		public Criteria andSpouseCompanyLessThanOrEqualTo(String value) {
			addCriterion("SPOUSE_COMPANY <=", value, "spouseCompany");
			return (Criteria) this;
		}

		public Criteria andSpouseCompanyLike(String value) {
			addCriterion("SPOUSE_COMPANY like", value, "spouseCompany");
			return (Criteria) this;
		}

		public Criteria andSpouseCompanyNotLike(String value) {
			addCriterion("SPOUSE_COMPANY not like", value, "spouseCompany");
			return (Criteria) this;
		}

		public Criteria andSpouseCompanyIn(List<String> values) {
			addCriterion("SPOUSE_COMPANY in", values, "spouseCompany");
			return (Criteria) this;
		}

		public Criteria andSpouseCompanyNotIn(List<String> values) {
			addCriterion("SPOUSE_COMPANY not in", values, "spouseCompany");
			return (Criteria) this;
		}

		public Criteria andSpouseCompanyBetween(String value1, String value2) {
			addCriterion("SPOUSE_COMPANY between", value1, value2, "spouseCompany");
			return (Criteria) this;
		}

		public Criteria andSpouseCompanyNotBetween(String value1, String value2) {
			addCriterion("SPOUSE_COMPANY not between", value1, value2, "spouseCompany");
			return (Criteria) this;
		}

		public Criteria andSpousePositionIsNull() {
			addCriterion("SPOUSE_POSITION is null");
			return (Criteria) this;
		}

		public Criteria andSpousePositionIsNotNull() {
			addCriterion("SPOUSE_POSITION is not null");
			return (Criteria) this;
		}

		public Criteria andSpousePositionEqualTo(String value) {
			addCriterion("SPOUSE_POSITION =", value, "spousePosition");
			return (Criteria) this;
		}

		public Criteria andSpousePositionNotEqualTo(String value) {
			addCriterion("SPOUSE_POSITION <>", value, "spousePosition");
			return (Criteria) this;
		}

		public Criteria andSpousePositionGreaterThan(String value) {
			addCriterion("SPOUSE_POSITION >", value, "spousePosition");
			return (Criteria) this;
		}

		public Criteria andSpousePositionGreaterThanOrEqualTo(String value) {
			addCriterion("SPOUSE_POSITION >=", value, "spousePosition");
			return (Criteria) this;
		}

		public Criteria andSpousePositionLessThan(String value) {
			addCriterion("SPOUSE_POSITION <", value, "spousePosition");
			return (Criteria) this;
		}

		public Criteria andSpousePositionLessThanOrEqualTo(String value) {
			addCriterion("SPOUSE_POSITION <=", value, "spousePosition");
			return (Criteria) this;
		}

		public Criteria andSpousePositionLike(String value) {
			addCriterion("SPOUSE_POSITION like", value, "spousePosition");
			return (Criteria) this;
		}

		public Criteria andSpousePositionNotLike(String value) {
			addCriterion("SPOUSE_POSITION not like", value, "spousePosition");
			return (Criteria) this;
		}

		public Criteria andSpousePositionIn(List<String> values) {
			addCriterion("SPOUSE_POSITION in", values, "spousePosition");
			return (Criteria) this;
		}

		public Criteria andSpousePositionNotIn(List<String> values) {
			addCriterion("SPOUSE_POSITION not in", values, "spousePosition");
			return (Criteria) this;
		}

		public Criteria andSpousePositionBetween(String value1, String value2) {
			addCriterion("SPOUSE_POSITION between", value1, value2, "spousePosition");
			return (Criteria) this;
		}

		public Criteria andSpousePositionNotBetween(String value1, String value2) {
			addCriterion("SPOUSE_POSITION not between", value1, value2, "spousePosition");
			return (Criteria) this;
		}

		public Criteria andSpouseCompAddrIsNull() {
			addCriterion("SPOUSE_COMP_ADDR is null");
			return (Criteria) this;
		}

		public Criteria andSpouseCompAddrIsNotNull() {
			addCriterion("SPOUSE_COMP_ADDR is not null");
			return (Criteria) this;
		}

		public Criteria andSpouseCompAddrEqualTo(String value) {
			addCriterion("SPOUSE_COMP_ADDR =", value, "spouseCompAddr");
			return (Criteria) this;
		}

		public Criteria andSpouseCompAddrNotEqualTo(String value) {
			addCriterion("SPOUSE_COMP_ADDR <>", value, "spouseCompAddr");
			return (Criteria) this;
		}

		public Criteria andSpouseCompAddrGreaterThan(String value) {
			addCriterion("SPOUSE_COMP_ADDR >", value, "spouseCompAddr");
			return (Criteria) this;
		}

		public Criteria andSpouseCompAddrGreaterThanOrEqualTo(String value) {
			addCriterion("SPOUSE_COMP_ADDR >=", value, "spouseCompAddr");
			return (Criteria) this;
		}

		public Criteria andSpouseCompAddrLessThan(String value) {
			addCriterion("SPOUSE_COMP_ADDR <", value, "spouseCompAddr");
			return (Criteria) this;
		}

		public Criteria andSpouseCompAddrLessThanOrEqualTo(String value) {
			addCriterion("SPOUSE_COMP_ADDR <=", value, "spouseCompAddr");
			return (Criteria) this;
		}

		public Criteria andSpouseCompAddrLike(String value) {
			addCriterion("SPOUSE_COMP_ADDR like", value, "spouseCompAddr");
			return (Criteria) this;
		}

		public Criteria andSpouseCompAddrNotLike(String value) {
			addCriterion("SPOUSE_COMP_ADDR not like", value, "spouseCompAddr");
			return (Criteria) this;
		}

		public Criteria andSpouseCompAddrIn(List<String> values) {
			addCriterion("SPOUSE_COMP_ADDR in", values, "spouseCompAddr");
			return (Criteria) this;
		}

		public Criteria andSpouseCompAddrNotIn(List<String> values) {
			addCriterion("SPOUSE_COMP_ADDR not in", values, "spouseCompAddr");
			return (Criteria) this;
		}

		public Criteria andSpouseCompAddrBetween(String value1, String value2) {
			addCriterion("SPOUSE_COMP_ADDR between", value1, value2, "spouseCompAddr");
			return (Criteria) this;
		}

		public Criteria andSpouseCompAddrNotBetween(String value1, String value2) {
			addCriterion("SPOUSE_COMP_ADDR not between", value1, value2, "spouseCompAddr");
			return (Criteria) this;
		}

		public Criteria andSpouseCompZipIsNull() {
			addCriterion("SPOUSE_COMP_ZIP is null");
			return (Criteria) this;
		}

		public Criteria andSpouseCompZipIsNotNull() {
			addCriterion("SPOUSE_COMP_ZIP is not null");
			return (Criteria) this;
		}

		public Criteria andSpouseCompZipEqualTo(String value) {
			addCriterion("SPOUSE_COMP_ZIP =", value, "spouseCompZip");
			return (Criteria) this;
		}

		public Criteria andSpouseCompZipNotEqualTo(String value) {
			addCriterion("SPOUSE_COMP_ZIP <>", value, "spouseCompZip");
			return (Criteria) this;
		}

		public Criteria andSpouseCompZipGreaterThan(String value) {
			addCriterion("SPOUSE_COMP_ZIP >", value, "spouseCompZip");
			return (Criteria) this;
		}

		public Criteria andSpouseCompZipGreaterThanOrEqualTo(String value) {
			addCriterion("SPOUSE_COMP_ZIP >=", value, "spouseCompZip");
			return (Criteria) this;
		}

		public Criteria andSpouseCompZipLessThan(String value) {
			addCriterion("SPOUSE_COMP_ZIP <", value, "spouseCompZip");
			return (Criteria) this;
		}

		public Criteria andSpouseCompZipLessThanOrEqualTo(String value) {
			addCriterion("SPOUSE_COMP_ZIP <=", value, "spouseCompZip");
			return (Criteria) this;
		}

		public Criteria andSpouseCompZipLike(String value) {
			addCriterion("SPOUSE_COMP_ZIP like", value, "spouseCompZip");
			return (Criteria) this;
		}

		public Criteria andSpouseCompZipNotLike(String value) {
			addCriterion("SPOUSE_COMP_ZIP not like", value, "spouseCompZip");
			return (Criteria) this;
		}

		public Criteria andSpouseCompZipIn(List<String> values) {
			addCriterion("SPOUSE_COMP_ZIP in", values, "spouseCompZip");
			return (Criteria) this;
		}

		public Criteria andSpouseCompZipNotIn(List<String> values) {
			addCriterion("SPOUSE_COMP_ZIP not in", values, "spouseCompZip");
			return (Criteria) this;
		}

		public Criteria andSpouseCompZipBetween(String value1, String value2) {
			addCriterion("SPOUSE_COMP_ZIP between", value1, value2, "spouseCompZip");
			return (Criteria) this;
		}

		public Criteria andSpouseCompZipNotBetween(String value1, String value2) {
			addCriterion("SPOUSE_COMP_ZIP not between", value1, value2, "spouseCompZip");
			return (Criteria) this;
		}

		public Criteria andSpouseMobileIsNull() {
			addCriterion("SPOUSE_MOBILE is null");
			return (Criteria) this;
		}

		public Criteria andSpouseMobileIsNotNull() {
			addCriterion("SPOUSE_MOBILE is not null");
			return (Criteria) this;
		}

		public Criteria andSpouseMobileEqualTo(String value) {
			addCriterion("SPOUSE_MOBILE =", value, "spouseMobile");
			return (Criteria) this;
		}

		public Criteria andSpouseMobileNotEqualTo(String value) {
			addCriterion("SPOUSE_MOBILE <>", value, "spouseMobile");
			return (Criteria) this;
		}

		public Criteria andSpouseMobileGreaterThan(String value) {
			addCriterion("SPOUSE_MOBILE >", value, "spouseMobile");
			return (Criteria) this;
		}

		public Criteria andSpouseMobileGreaterThanOrEqualTo(String value) {
			addCriterion("SPOUSE_MOBILE >=", value, "spouseMobile");
			return (Criteria) this;
		}

		public Criteria andSpouseMobileLessThan(String value) {
			addCriterion("SPOUSE_MOBILE <", value, "spouseMobile");
			return (Criteria) this;
		}

		public Criteria andSpouseMobileLessThanOrEqualTo(String value) {
			addCriterion("SPOUSE_MOBILE <=", value, "spouseMobile");
			return (Criteria) this;
		}

		public Criteria andSpouseMobileLike(String value) {
			addCriterion("SPOUSE_MOBILE like", value, "spouseMobile");
			return (Criteria) this;
		}

		public Criteria andSpouseMobileNotLike(String value) {
			addCriterion("SPOUSE_MOBILE not like", value, "spouseMobile");
			return (Criteria) this;
		}

		public Criteria andSpouseMobileIn(List<String> values) {
			addCriterion("SPOUSE_MOBILE in", values, "spouseMobile");
			return (Criteria) this;
		}

		public Criteria andSpouseMobileNotIn(List<String> values) {
			addCriterion("SPOUSE_MOBILE not in", values, "spouseMobile");
			return (Criteria) this;
		}

		public Criteria andSpouseMobileBetween(String value1, String value2) {
			addCriterion("SPOUSE_MOBILE between", value1, value2, "spouseMobile");
			return (Criteria) this;
		}

		public Criteria andSpouseMobileNotBetween(String value1, String value2) {
			addCriterion("SPOUSE_MOBILE not between", value1, value2, "spouseMobile");
			return (Criteria) this;
		}

		public Criteria andSpouseHomePhoneIsNull() {
			addCriterion("SPOUSE_HOME_PHONE is null");
			return (Criteria) this;
		}

		public Criteria andSpouseHomePhoneIsNotNull() {
			addCriterion("SPOUSE_HOME_PHONE is not null");
			return (Criteria) this;
		}

		public Criteria andSpouseHomePhoneEqualTo(String value) {
			addCriterion("SPOUSE_HOME_PHONE =", value, "spouseHomePhone");
			return (Criteria) this;
		}

		public Criteria andSpouseHomePhoneNotEqualTo(String value) {
			addCriterion("SPOUSE_HOME_PHONE <>", value, "spouseHomePhone");
			return (Criteria) this;
		}

		public Criteria andSpouseHomePhoneGreaterThan(String value) {
			addCriterion("SPOUSE_HOME_PHONE >", value, "spouseHomePhone");
			return (Criteria) this;
		}

		public Criteria andSpouseHomePhoneGreaterThanOrEqualTo(String value) {
			addCriterion("SPOUSE_HOME_PHONE >=", value, "spouseHomePhone");
			return (Criteria) this;
		}

		public Criteria andSpouseHomePhoneLessThan(String value) {
			addCriterion("SPOUSE_HOME_PHONE <", value, "spouseHomePhone");
			return (Criteria) this;
		}

		public Criteria andSpouseHomePhoneLessThanOrEqualTo(String value) {
			addCriterion("SPOUSE_HOME_PHONE <=", value, "spouseHomePhone");
			return (Criteria) this;
		}

		public Criteria andSpouseHomePhoneLike(String value) {
			addCriterion("SPOUSE_HOME_PHONE like", value, "spouseHomePhone");
			return (Criteria) this;
		}

		public Criteria andSpouseHomePhoneNotLike(String value) {
			addCriterion("SPOUSE_HOME_PHONE not like", value, "spouseHomePhone");
			return (Criteria) this;
		}

		public Criteria andSpouseHomePhoneIn(List<String> values) {
			addCriterion("SPOUSE_HOME_PHONE in", values, "spouseHomePhone");
			return (Criteria) this;
		}

		public Criteria andSpouseHomePhoneNotIn(List<String> values) {
			addCriterion("SPOUSE_HOME_PHONE not in", values, "spouseHomePhone");
			return (Criteria) this;
		}

		public Criteria andSpouseHomePhoneBetween(String value1, String value2) {
			addCriterion("SPOUSE_HOME_PHONE between", value1, value2, "spouseHomePhone");
			return (Criteria) this;
		}

		public Criteria andSpouseHomePhoneNotBetween(String value1, String value2) {
			addCriterion("SPOUSE_HOME_PHONE not between", value1, value2, "spouseHomePhone");
			return (Criteria) this;
		}

		public Criteria andSpouseEmailIsNull() {
			addCriterion("SPOUSE_EMAIL is null");
			return (Criteria) this;
		}

		public Criteria andSpouseEmailIsNotNull() {
			addCriterion("SPOUSE_EMAIL is not null");
			return (Criteria) this;
		}

		public Criteria andSpouseEmailEqualTo(String value) {
			addCriterion("SPOUSE_EMAIL =", value, "spouseEmail");
			return (Criteria) this;
		}

		public Criteria andSpouseEmailNotEqualTo(String value) {
			addCriterion("SPOUSE_EMAIL <>", value, "spouseEmail");
			return (Criteria) this;
		}

		public Criteria andSpouseEmailGreaterThan(String value) {
			addCriterion("SPOUSE_EMAIL >", value, "spouseEmail");
			return (Criteria) this;
		}

		public Criteria andSpouseEmailGreaterThanOrEqualTo(String value) {
			addCriterion("SPOUSE_EMAIL >=", value, "spouseEmail");
			return (Criteria) this;
		}

		public Criteria andSpouseEmailLessThan(String value) {
			addCriterion("SPOUSE_EMAIL <", value, "spouseEmail");
			return (Criteria) this;
		}

		public Criteria andSpouseEmailLessThanOrEqualTo(String value) {
			addCriterion("SPOUSE_EMAIL <=", value, "spouseEmail");
			return (Criteria) this;
		}

		public Criteria andSpouseEmailLike(String value) {
			addCriterion("SPOUSE_EMAIL like", value, "spouseEmail");
			return (Criteria) this;
		}

		public Criteria andSpouseEmailNotLike(String value) {
			addCriterion("SPOUSE_EMAIL not like", value, "spouseEmail");
			return (Criteria) this;
		}

		public Criteria andSpouseEmailIn(List<String> values) {
			addCriterion("SPOUSE_EMAIL in", values, "spouseEmail");
			return (Criteria) this;
		}

		public Criteria andSpouseEmailNotIn(List<String> values) {
			addCriterion("SPOUSE_EMAIL not in", values, "spouseEmail");
			return (Criteria) this;
		}

		public Criteria andSpouseEmailBetween(String value1, String value2) {
			addCriterion("SPOUSE_EMAIL between", value1, value2, "spouseEmail");
			return (Criteria) this;
		}

		public Criteria andSpouseEmailNotBetween(String value1, String value2) {
			addCriterion("SPOUSE_EMAIL not between", value1, value2, "spouseEmail");
			return (Criteria) this;
		}

		public Criteria andLinkmanNameIsNull() {
			addCriterion("LINKMAN_NAME is null");
			return (Criteria) this;
		}

		public Criteria andLinkmanNameIsNotNull() {
			addCriterion("LINKMAN_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andLinkmanNameEqualTo(String value) {
			addCriterion("LINKMAN_NAME =", value, "linkmanName");
			return (Criteria) this;
		}

		public Criteria andLinkmanNameNotEqualTo(String value) {
			addCriterion("LINKMAN_NAME <>", value, "linkmanName");
			return (Criteria) this;
		}

		public Criteria andLinkmanNameGreaterThan(String value) {
			addCriterion("LINKMAN_NAME >", value, "linkmanName");
			return (Criteria) this;
		}

		public Criteria andLinkmanNameGreaterThanOrEqualTo(String value) {
			addCriterion("LINKMAN_NAME >=", value, "linkmanName");
			return (Criteria) this;
		}

		public Criteria andLinkmanNameLessThan(String value) {
			addCriterion("LINKMAN_NAME <", value, "linkmanName");
			return (Criteria) this;
		}

		public Criteria andLinkmanNameLessThanOrEqualTo(String value) {
			addCriterion("LINKMAN_NAME <=", value, "linkmanName");
			return (Criteria) this;
		}

		public Criteria andLinkmanNameLike(String value) {
			addCriterion("LINKMAN_NAME like", value, "linkmanName");
			return (Criteria) this;
		}

		public Criteria andLinkmanNameNotLike(String value) {
			addCriterion("LINKMAN_NAME not like", value, "linkmanName");
			return (Criteria) this;
		}

		public Criteria andLinkmanNameIn(List<String> values) {
			addCriterion("LINKMAN_NAME in", values, "linkmanName");
			return (Criteria) this;
		}

		public Criteria andLinkmanNameNotIn(List<String> values) {
			addCriterion("LINKMAN_NAME not in", values, "linkmanName");
			return (Criteria) this;
		}

		public Criteria andLinkmanNameBetween(String value1, String value2) {
			addCriterion("LINKMAN_NAME between", value1, value2, "linkmanName");
			return (Criteria) this;
		}

		public Criteria andLinkmanNameNotBetween(String value1, String value2) {
			addCriterion("LINKMAN_NAME not between", value1, value2, "linkmanName");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdTypeIsNull() {
			addCriterion("LINKMAN_ID_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdTypeIsNotNull() {
			addCriterion("LINKMAN_ID_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdTypeEqualTo(String value) {
			addCriterion("LINKMAN_ID_TYPE =", value, "linkmanIdType");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdTypeNotEqualTo(String value) {
			addCriterion("LINKMAN_ID_TYPE <>", value, "linkmanIdType");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdTypeGreaterThan(String value) {
			addCriterion("LINKMAN_ID_TYPE >", value, "linkmanIdType");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdTypeGreaterThanOrEqualTo(String value) {
			addCriterion("LINKMAN_ID_TYPE >=", value, "linkmanIdType");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdTypeLessThan(String value) {
			addCriterion("LINKMAN_ID_TYPE <", value, "linkmanIdType");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdTypeLessThanOrEqualTo(String value) {
			addCriterion("LINKMAN_ID_TYPE <=", value, "linkmanIdType");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdTypeLike(String value) {
			addCriterion("LINKMAN_ID_TYPE like", value, "linkmanIdType");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdTypeNotLike(String value) {
			addCriterion("LINKMAN_ID_TYPE not like", value, "linkmanIdType");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdTypeIn(List<String> values) {
			addCriterion("LINKMAN_ID_TYPE in", values, "linkmanIdType");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdTypeNotIn(List<String> values) {
			addCriterion("LINKMAN_ID_TYPE not in", values, "linkmanIdType");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdTypeBetween(String value1, String value2) {
			addCriterion("LINKMAN_ID_TYPE between", value1, value2, "linkmanIdType");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdTypeNotBetween(String value1, String value2) {
			addCriterion("LINKMAN_ID_TYPE not between", value1, value2, "linkmanIdType");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdNoIsNull() {
			addCriterion("LINKMAN_ID_NO is null");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdNoIsNotNull() {
			addCriterion("LINKMAN_ID_NO is not null");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdNoEqualTo(String value) {
			addCriterion("LINKMAN_ID_NO =", value, "linkmanIdNo");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdNoNotEqualTo(String value) {
			addCriterion("LINKMAN_ID_NO <>", value, "linkmanIdNo");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdNoGreaterThan(String value) {
			addCriterion("LINKMAN_ID_NO >", value, "linkmanIdNo");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdNoGreaterThanOrEqualTo(String value) {
			addCriterion("LINKMAN_ID_NO >=", value, "linkmanIdNo");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdNoLessThan(String value) {
			addCriterion("LINKMAN_ID_NO <", value, "linkmanIdNo");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdNoLessThanOrEqualTo(String value) {
			addCriterion("LINKMAN_ID_NO <=", value, "linkmanIdNo");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdNoLike(String value) {
			addCriterion("LINKMAN_ID_NO like", value, "linkmanIdNo");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdNoNotLike(String value) {
			addCriterion("LINKMAN_ID_NO not like", value, "linkmanIdNo");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdNoIn(List<String> values) {
			addCriterion("LINKMAN_ID_NO in", values, "linkmanIdNo");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdNoNotIn(List<String> values) {
			addCriterion("LINKMAN_ID_NO not in", values, "linkmanIdNo");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdNoBetween(String value1, String value2) {
			addCriterion("LINKMAN_ID_NO between", value1, value2, "linkmanIdNo");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdNoNotBetween(String value1, String value2) {
			addCriterion("LINKMAN_ID_NO not between", value1, value2, "linkmanIdNo");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdSignDateIsNull() {
			addCriterion("LINKMAN_ID_SIGN_DATE is null");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdSignDateIsNotNull() {
			addCriterion("LINKMAN_ID_SIGN_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdSignDateEqualTo(Date value) {
			addCriterionForJDBCDate("LINKMAN_ID_SIGN_DATE =", value, "linkmanIdSignDate");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdSignDateNotEqualTo(Date value) {
			addCriterionForJDBCDate("LINKMAN_ID_SIGN_DATE <>", value, "linkmanIdSignDate");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdSignDateGreaterThan(Date value) {
			addCriterionForJDBCDate("LINKMAN_ID_SIGN_DATE >", value, "linkmanIdSignDate");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdSignDateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("LINKMAN_ID_SIGN_DATE >=", value, "linkmanIdSignDate");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdSignDateLessThan(Date value) {
			addCriterionForJDBCDate("LINKMAN_ID_SIGN_DATE <", value, "linkmanIdSignDate");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdSignDateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("LINKMAN_ID_SIGN_DATE <=", value, "linkmanIdSignDate");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdSignDateIn(List<Date> values) {
			addCriterionForJDBCDate("LINKMAN_ID_SIGN_DATE in", values, "linkmanIdSignDate");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdSignDateNotIn(List<Date> values) {
			addCriterionForJDBCDate("LINKMAN_ID_SIGN_DATE not in", values, "linkmanIdSignDate");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdSignDateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("LINKMAN_ID_SIGN_DATE between", value1, value2, "linkmanIdSignDate");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdSignDateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("LINKMAN_ID_SIGN_DATE not between", value1, value2, "linkmanIdSignDate");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdExpireDateIsNull() {
			addCriterion("LINKMAN_ID_EXPIRE_DATE is null");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdExpireDateIsNotNull() {
			addCriterion("LINKMAN_ID_EXPIRE_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdExpireDateEqualTo(Date value) {
			addCriterionForJDBCDate("LINKMAN_ID_EXPIRE_DATE =", value, "linkmanIdExpireDate");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdExpireDateNotEqualTo(Date value) {
			addCriterionForJDBCDate("LINKMAN_ID_EXPIRE_DATE <>", value, "linkmanIdExpireDate");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdExpireDateGreaterThan(Date value) {
			addCriterionForJDBCDate("LINKMAN_ID_EXPIRE_DATE >", value, "linkmanIdExpireDate");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdExpireDateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("LINKMAN_ID_EXPIRE_DATE >=", value, "linkmanIdExpireDate");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdExpireDateLessThan(Date value) {
			addCriterionForJDBCDate("LINKMAN_ID_EXPIRE_DATE <", value, "linkmanIdExpireDate");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdExpireDateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("LINKMAN_ID_EXPIRE_DATE <=", value, "linkmanIdExpireDate");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdExpireDateIn(List<Date> values) {
			addCriterionForJDBCDate("LINKMAN_ID_EXPIRE_DATE in", values, "linkmanIdExpireDate");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdExpireDateNotIn(List<Date> values) {
			addCriterionForJDBCDate("LINKMAN_ID_EXPIRE_DATE not in", values, "linkmanIdExpireDate");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdExpireDateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("LINKMAN_ID_EXPIRE_DATE between", value1, value2, "linkmanIdExpireDate");
			return (Criteria) this;
		}

		public Criteria andLinkmanIdExpireDateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("LINKMAN_ID_EXPIRE_DATE not between", value1, value2, "linkmanIdExpireDate");
			return (Criteria) this;
		}

		public Criteria andLinkmanIndustryTypeIsNull() {
			addCriterion("LINKMAN_INDUSTRY_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andLinkmanIndustryTypeIsNotNull() {
			addCriterion("LINKMAN_INDUSTRY_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andLinkmanIndustryTypeEqualTo(String value) {
			addCriterion("LINKMAN_INDUSTRY_TYPE =", value, "linkmanIndustryType");
			return (Criteria) this;
		}

		public Criteria andLinkmanIndustryTypeNotEqualTo(String value) {
			addCriterion("LINKMAN_INDUSTRY_TYPE <>", value, "linkmanIndustryType");
			return (Criteria) this;
		}

		public Criteria andLinkmanIndustryTypeGreaterThan(String value) {
			addCriterion("LINKMAN_INDUSTRY_TYPE >", value, "linkmanIndustryType");
			return (Criteria) this;
		}

		public Criteria andLinkmanIndustryTypeGreaterThanOrEqualTo(String value) {
			addCriterion("LINKMAN_INDUSTRY_TYPE >=", value, "linkmanIndustryType");
			return (Criteria) this;
		}

		public Criteria andLinkmanIndustryTypeLessThan(String value) {
			addCriterion("LINKMAN_INDUSTRY_TYPE <", value, "linkmanIndustryType");
			return (Criteria) this;
		}

		public Criteria andLinkmanIndustryTypeLessThanOrEqualTo(String value) {
			addCriterion("LINKMAN_INDUSTRY_TYPE <=", value, "linkmanIndustryType");
			return (Criteria) this;
		}

		public Criteria andLinkmanIndustryTypeLike(String value) {
			addCriterion("LINKMAN_INDUSTRY_TYPE like", value, "linkmanIndustryType");
			return (Criteria) this;
		}

		public Criteria andLinkmanIndustryTypeNotLike(String value) {
			addCriterion("LINKMAN_INDUSTRY_TYPE not like", value, "linkmanIndustryType");
			return (Criteria) this;
		}

		public Criteria andLinkmanIndustryTypeIn(List<String> values) {
			addCriterion("LINKMAN_INDUSTRY_TYPE in", values, "linkmanIndustryType");
			return (Criteria) this;
		}

		public Criteria andLinkmanIndustryTypeNotIn(List<String> values) {
			addCriterion("LINKMAN_INDUSTRY_TYPE not in", values, "linkmanIndustryType");
			return (Criteria) this;
		}

		public Criteria andLinkmanIndustryTypeBetween(String value1, String value2) {
			addCriterion("LINKMAN_INDUSTRY_TYPE between", value1, value2, "linkmanIndustryType");
			return (Criteria) this;
		}

		public Criteria andLinkmanIndustryTypeNotBetween(String value1, String value2) {
			addCriterion("LINKMAN_INDUSTRY_TYPE not between", value1, value2, "linkmanIndustryType");
			return (Criteria) this;
		}

		public Criteria andLinkmanCompanyIsNull() {
			addCriterion("LINKMAN_COMPANY is null");
			return (Criteria) this;
		}

		public Criteria andLinkmanCompanyIsNotNull() {
			addCriterion("LINKMAN_COMPANY is not null");
			return (Criteria) this;
		}

		public Criteria andLinkmanCompanyEqualTo(String value) {
			addCriterion("LINKMAN_COMPANY =", value, "linkmanCompany");
			return (Criteria) this;
		}

		public Criteria andLinkmanCompanyNotEqualTo(String value) {
			addCriterion("LINKMAN_COMPANY <>", value, "linkmanCompany");
			return (Criteria) this;
		}

		public Criteria andLinkmanCompanyGreaterThan(String value) {
			addCriterion("LINKMAN_COMPANY >", value, "linkmanCompany");
			return (Criteria) this;
		}

		public Criteria andLinkmanCompanyGreaterThanOrEqualTo(String value) {
			addCriterion("LINKMAN_COMPANY >=", value, "linkmanCompany");
			return (Criteria) this;
		}

		public Criteria andLinkmanCompanyLessThan(String value) {
			addCriterion("LINKMAN_COMPANY <", value, "linkmanCompany");
			return (Criteria) this;
		}

		public Criteria andLinkmanCompanyLessThanOrEqualTo(String value) {
			addCriterion("LINKMAN_COMPANY <=", value, "linkmanCompany");
			return (Criteria) this;
		}

		public Criteria andLinkmanCompanyLike(String value) {
			addCriterion("LINKMAN_COMPANY like", value, "linkmanCompany");
			return (Criteria) this;
		}

		public Criteria andLinkmanCompanyNotLike(String value) {
			addCriterion("LINKMAN_COMPANY not like", value, "linkmanCompany");
			return (Criteria) this;
		}

		public Criteria andLinkmanCompanyIn(List<String> values) {
			addCriterion("LINKMAN_COMPANY in", values, "linkmanCompany");
			return (Criteria) this;
		}

		public Criteria andLinkmanCompanyNotIn(List<String> values) {
			addCriterion("LINKMAN_COMPANY not in", values, "linkmanCompany");
			return (Criteria) this;
		}

		public Criteria andLinkmanCompanyBetween(String value1, String value2) {
			addCriterion("LINKMAN_COMPANY between", value1, value2, "linkmanCompany");
			return (Criteria) this;
		}

		public Criteria andLinkmanCompanyNotBetween(String value1, String value2) {
			addCriterion("LINKMAN_COMPANY not between", value1, value2, "linkmanCompany");
			return (Criteria) this;
		}

		public Criteria andLinkmanPositionIsNull() {
			addCriterion("LINKMAN_POSITION is null");
			return (Criteria) this;
		}

		public Criteria andLinkmanPositionIsNotNull() {
			addCriterion("LINKMAN_POSITION is not null");
			return (Criteria) this;
		}

		public Criteria andLinkmanPositionEqualTo(String value) {
			addCriterion("LINKMAN_POSITION =", value, "linkmanPosition");
			return (Criteria) this;
		}

		public Criteria andLinkmanPositionNotEqualTo(String value) {
			addCriterion("LINKMAN_POSITION <>", value, "linkmanPosition");
			return (Criteria) this;
		}

		public Criteria andLinkmanPositionGreaterThan(String value) {
			addCriterion("LINKMAN_POSITION >", value, "linkmanPosition");
			return (Criteria) this;
		}

		public Criteria andLinkmanPositionGreaterThanOrEqualTo(String value) {
			addCriterion("LINKMAN_POSITION >=", value, "linkmanPosition");
			return (Criteria) this;
		}

		public Criteria andLinkmanPositionLessThan(String value) {
			addCriterion("LINKMAN_POSITION <", value, "linkmanPosition");
			return (Criteria) this;
		}

		public Criteria andLinkmanPositionLessThanOrEqualTo(String value) {
			addCriterion("LINKMAN_POSITION <=", value, "linkmanPosition");
			return (Criteria) this;
		}

		public Criteria andLinkmanPositionLike(String value) {
			addCriterion("LINKMAN_POSITION like", value, "linkmanPosition");
			return (Criteria) this;
		}

		public Criteria andLinkmanPositionNotLike(String value) {
			addCriterion("LINKMAN_POSITION not like", value, "linkmanPosition");
			return (Criteria) this;
		}

		public Criteria andLinkmanPositionIn(List<String> values) {
			addCriterion("LINKMAN_POSITION in", values, "linkmanPosition");
			return (Criteria) this;
		}

		public Criteria andLinkmanPositionNotIn(List<String> values) {
			addCriterion("LINKMAN_POSITION not in", values, "linkmanPosition");
			return (Criteria) this;
		}

		public Criteria andLinkmanPositionBetween(String value1, String value2) {
			addCriterion("LINKMAN_POSITION between", value1, value2, "linkmanPosition");
			return (Criteria) this;
		}

		public Criteria andLinkmanPositionNotBetween(String value1, String value2) {
			addCriterion("LINKMAN_POSITION not between", value1, value2, "linkmanPosition");
			return (Criteria) this;
		}

		public Criteria andLinkmanCompAddrIsNull() {
			addCriterion("LINKMAN_COMP_ADDR is null");
			return (Criteria) this;
		}

		public Criteria andLinkmanCompAddrIsNotNull() {
			addCriterion("LINKMAN_COMP_ADDR is not null");
			return (Criteria) this;
		}

		public Criteria andLinkmanCompAddrEqualTo(String value) {
			addCriterion("LINKMAN_COMP_ADDR =", value, "linkmanCompAddr");
			return (Criteria) this;
		}

		public Criteria andLinkmanCompAddrNotEqualTo(String value) {
			addCriterion("LINKMAN_COMP_ADDR <>", value, "linkmanCompAddr");
			return (Criteria) this;
		}

		public Criteria andLinkmanCompAddrGreaterThan(String value) {
			addCriterion("LINKMAN_COMP_ADDR >", value, "linkmanCompAddr");
			return (Criteria) this;
		}

		public Criteria andLinkmanCompAddrGreaterThanOrEqualTo(String value) {
			addCriterion("LINKMAN_COMP_ADDR >=", value, "linkmanCompAddr");
			return (Criteria) this;
		}

		public Criteria andLinkmanCompAddrLessThan(String value) {
			addCriterion("LINKMAN_COMP_ADDR <", value, "linkmanCompAddr");
			return (Criteria) this;
		}

		public Criteria andLinkmanCompAddrLessThanOrEqualTo(String value) {
			addCriterion("LINKMAN_COMP_ADDR <=", value, "linkmanCompAddr");
			return (Criteria) this;
		}

		public Criteria andLinkmanCompAddrLike(String value) {
			addCriterion("LINKMAN_COMP_ADDR like", value, "linkmanCompAddr");
			return (Criteria) this;
		}

		public Criteria andLinkmanCompAddrNotLike(String value) {
			addCriterion("LINKMAN_COMP_ADDR not like", value, "linkmanCompAddr");
			return (Criteria) this;
		}

		public Criteria andLinkmanCompAddrIn(List<String> values) {
			addCriterion("LINKMAN_COMP_ADDR in", values, "linkmanCompAddr");
			return (Criteria) this;
		}

		public Criteria andLinkmanCompAddrNotIn(List<String> values) {
			addCriterion("LINKMAN_COMP_ADDR not in", values, "linkmanCompAddr");
			return (Criteria) this;
		}

		public Criteria andLinkmanCompAddrBetween(String value1, String value2) {
			addCriterion("LINKMAN_COMP_ADDR between", value1, value2, "linkmanCompAddr");
			return (Criteria) this;
		}

		public Criteria andLinkmanCompAddrNotBetween(String value1, String value2) {
			addCriterion("LINKMAN_COMP_ADDR not between", value1, value2, "linkmanCompAddr");
			return (Criteria) this;
		}

		public Criteria andLinkmanCompZipIsNull() {
			addCriterion("LINKMAN_COMP_ZIP is null");
			return (Criteria) this;
		}

		public Criteria andLinkmanCompZipIsNotNull() {
			addCriterion("LINKMAN_COMP_ZIP is not null");
			return (Criteria) this;
		}

		public Criteria andLinkmanCompZipEqualTo(String value) {
			addCriterion("LINKMAN_COMP_ZIP =", value, "linkmanCompZip");
			return (Criteria) this;
		}

		public Criteria andLinkmanCompZipNotEqualTo(String value) {
			addCriterion("LINKMAN_COMP_ZIP <>", value, "linkmanCompZip");
			return (Criteria) this;
		}

		public Criteria andLinkmanCompZipGreaterThan(String value) {
			addCriterion("LINKMAN_COMP_ZIP >", value, "linkmanCompZip");
			return (Criteria) this;
		}

		public Criteria andLinkmanCompZipGreaterThanOrEqualTo(String value) {
			addCriterion("LINKMAN_COMP_ZIP >=", value, "linkmanCompZip");
			return (Criteria) this;
		}

		public Criteria andLinkmanCompZipLessThan(String value) {
			addCriterion("LINKMAN_COMP_ZIP <", value, "linkmanCompZip");
			return (Criteria) this;
		}

		public Criteria andLinkmanCompZipLessThanOrEqualTo(String value) {
			addCriterion("LINKMAN_COMP_ZIP <=", value, "linkmanCompZip");
			return (Criteria) this;
		}

		public Criteria andLinkmanCompZipLike(String value) {
			addCriterion("LINKMAN_COMP_ZIP like", value, "linkmanCompZip");
			return (Criteria) this;
		}

		public Criteria andLinkmanCompZipNotLike(String value) {
			addCriterion("LINKMAN_COMP_ZIP not like", value, "linkmanCompZip");
			return (Criteria) this;
		}

		public Criteria andLinkmanCompZipIn(List<String> values) {
			addCriterion("LINKMAN_COMP_ZIP in", values, "linkmanCompZip");
			return (Criteria) this;
		}

		public Criteria andLinkmanCompZipNotIn(List<String> values) {
			addCriterion("LINKMAN_COMP_ZIP not in", values, "linkmanCompZip");
			return (Criteria) this;
		}

		public Criteria andLinkmanCompZipBetween(String value1, String value2) {
			addCriterion("LINKMAN_COMP_ZIP between", value1, value2, "linkmanCompZip");
			return (Criteria) this;
		}

		public Criteria andLinkmanCompZipNotBetween(String value1, String value2) {
			addCriterion("LINKMAN_COMP_ZIP not between", value1, value2, "linkmanCompZip");
			return (Criteria) this;
		}

		public Criteria andLinkmanMobileIsNull() {
			addCriterion("LINKMAN_MOBILE is null");
			return (Criteria) this;
		}

		public Criteria andLinkmanMobileIsNotNull() {
			addCriterion("LINKMAN_MOBILE is not null");
			return (Criteria) this;
		}

		public Criteria andLinkmanMobileEqualTo(String value) {
			addCriterion("LINKMAN_MOBILE =", value, "linkmanMobile");
			return (Criteria) this;
		}

		public Criteria andLinkmanMobileNotEqualTo(String value) {
			addCriterion("LINKMAN_MOBILE <>", value, "linkmanMobile");
			return (Criteria) this;
		}

		public Criteria andLinkmanMobileGreaterThan(String value) {
			addCriterion("LINKMAN_MOBILE >", value, "linkmanMobile");
			return (Criteria) this;
		}

		public Criteria andLinkmanMobileGreaterThanOrEqualTo(String value) {
			addCriterion("LINKMAN_MOBILE >=", value, "linkmanMobile");
			return (Criteria) this;
		}

		public Criteria andLinkmanMobileLessThan(String value) {
			addCriterion("LINKMAN_MOBILE <", value, "linkmanMobile");
			return (Criteria) this;
		}

		public Criteria andLinkmanMobileLessThanOrEqualTo(String value) {
			addCriterion("LINKMAN_MOBILE <=", value, "linkmanMobile");
			return (Criteria) this;
		}

		public Criteria andLinkmanMobileLike(String value) {
			addCriterion("LINKMAN_MOBILE like", value, "linkmanMobile");
			return (Criteria) this;
		}

		public Criteria andLinkmanMobileNotLike(String value) {
			addCriterion("LINKMAN_MOBILE not like", value, "linkmanMobile");
			return (Criteria) this;
		}

		public Criteria andLinkmanMobileIn(List<String> values) {
			addCriterion("LINKMAN_MOBILE in", values, "linkmanMobile");
			return (Criteria) this;
		}

		public Criteria andLinkmanMobileNotIn(List<String> values) {
			addCriterion("LINKMAN_MOBILE not in", values, "linkmanMobile");
			return (Criteria) this;
		}

		public Criteria andLinkmanMobileBetween(String value1, String value2) {
			addCriterion("LINKMAN_MOBILE between", value1, value2, "linkmanMobile");
			return (Criteria) this;
		}

		public Criteria andLinkmanMobileNotBetween(String value1, String value2) {
			addCriterion("LINKMAN_MOBILE not between", value1, value2, "linkmanMobile");
			return (Criteria) this;
		}

		public Criteria andLinkmanHomePhoneIsNull() {
			addCriterion("LINKMAN_HOME_PHONE is null");
			return (Criteria) this;
		}

		public Criteria andLinkmanHomePhoneIsNotNull() {
			addCriterion("LINKMAN_HOME_PHONE is not null");
			return (Criteria) this;
		}

		public Criteria andLinkmanHomePhoneEqualTo(String value) {
			addCriterion("LINKMAN_HOME_PHONE =", value, "linkmanHomePhone");
			return (Criteria) this;
		}

		public Criteria andLinkmanHomePhoneNotEqualTo(String value) {
			addCriterion("LINKMAN_HOME_PHONE <>", value, "linkmanHomePhone");
			return (Criteria) this;
		}

		public Criteria andLinkmanHomePhoneGreaterThan(String value) {
			addCriterion("LINKMAN_HOME_PHONE >", value, "linkmanHomePhone");
			return (Criteria) this;
		}

		public Criteria andLinkmanHomePhoneGreaterThanOrEqualTo(String value) {
			addCriterion("LINKMAN_HOME_PHONE >=", value, "linkmanHomePhone");
			return (Criteria) this;
		}

		public Criteria andLinkmanHomePhoneLessThan(String value) {
			addCriterion("LINKMAN_HOME_PHONE <", value, "linkmanHomePhone");
			return (Criteria) this;
		}

		public Criteria andLinkmanHomePhoneLessThanOrEqualTo(String value) {
			addCriterion("LINKMAN_HOME_PHONE <=", value, "linkmanHomePhone");
			return (Criteria) this;
		}

		public Criteria andLinkmanHomePhoneLike(String value) {
			addCriterion("LINKMAN_HOME_PHONE like", value, "linkmanHomePhone");
			return (Criteria) this;
		}

		public Criteria andLinkmanHomePhoneNotLike(String value) {
			addCriterion("LINKMAN_HOME_PHONE not like", value, "linkmanHomePhone");
			return (Criteria) this;
		}

		public Criteria andLinkmanHomePhoneIn(List<String> values) {
			addCriterion("LINKMAN_HOME_PHONE in", values, "linkmanHomePhone");
			return (Criteria) this;
		}

		public Criteria andLinkmanHomePhoneNotIn(List<String> values) {
			addCriterion("LINKMAN_HOME_PHONE not in", values, "linkmanHomePhone");
			return (Criteria) this;
		}

		public Criteria andLinkmanHomePhoneBetween(String value1, String value2) {
			addCriterion("LINKMAN_HOME_PHONE between", value1, value2, "linkmanHomePhone");
			return (Criteria) this;
		}

		public Criteria andLinkmanHomePhoneNotBetween(String value1, String value2) {
			addCriterion("LINKMAN_HOME_PHONE not between", value1, value2, "linkmanHomePhone");
			return (Criteria) this;
		}

		public Criteria andLinkmanEmailIsNull() {
			addCriterion("LINKMAN_EMAIL is null");
			return (Criteria) this;
		}

		public Criteria andLinkmanEmailIsNotNull() {
			addCriterion("LINKMAN_EMAIL is not null");
			return (Criteria) this;
		}

		public Criteria andLinkmanEmailEqualTo(String value) {
			addCriterion("LINKMAN_EMAIL =", value, "linkmanEmail");
			return (Criteria) this;
		}

		public Criteria andLinkmanEmailNotEqualTo(String value) {
			addCriterion("LINKMAN_EMAIL <>", value, "linkmanEmail");
			return (Criteria) this;
		}

		public Criteria andLinkmanEmailGreaterThan(String value) {
			addCriterion("LINKMAN_EMAIL >", value, "linkmanEmail");
			return (Criteria) this;
		}

		public Criteria andLinkmanEmailGreaterThanOrEqualTo(String value) {
			addCriterion("LINKMAN_EMAIL >=", value, "linkmanEmail");
			return (Criteria) this;
		}

		public Criteria andLinkmanEmailLessThan(String value) {
			addCriterion("LINKMAN_EMAIL <", value, "linkmanEmail");
			return (Criteria) this;
		}

		public Criteria andLinkmanEmailLessThanOrEqualTo(String value) {
			addCriterion("LINKMAN_EMAIL <=", value, "linkmanEmail");
			return (Criteria) this;
		}

		public Criteria andLinkmanEmailLike(String value) {
			addCriterion("LINKMAN_EMAIL like", value, "linkmanEmail");
			return (Criteria) this;
		}

		public Criteria andLinkmanEmailNotLike(String value) {
			addCriterion("LINKMAN_EMAIL not like", value, "linkmanEmail");
			return (Criteria) this;
		}

		public Criteria andLinkmanEmailIn(List<String> values) {
			addCriterion("LINKMAN_EMAIL in", values, "linkmanEmail");
			return (Criteria) this;
		}

		public Criteria andLinkmanEmailNotIn(List<String> values) {
			addCriterion("LINKMAN_EMAIL not in", values, "linkmanEmail");
			return (Criteria) this;
		}

		public Criteria andLinkmanEmailBetween(String value1, String value2) {
			addCriterion("LINKMAN_EMAIL between", value1, value2, "linkmanEmail");
			return (Criteria) this;
		}

		public Criteria andLinkmanEmailNotBetween(String value1, String value2) {
			addCriterion("LINKMAN_EMAIL not between", value1, value2, "linkmanEmail");
			return (Criteria) this;
		}

		public Criteria andGuaranteeIsNull() {
			addCriterion("GUARANTEE is null");
			return (Criteria) this;
		}

		public Criteria andGuaranteeIsNotNull() {
			addCriterion("GUARANTEE is not null");
			return (Criteria) this;
		}

		public Criteria andGuaranteeEqualTo(String value) {
			addCriterion("GUARANTEE =", value, "guarantee");
			return (Criteria) this;
		}

		public Criteria andGuaranteeNotEqualTo(String value) {
			addCriterion("GUARANTEE <>", value, "guarantee");
			return (Criteria) this;
		}

		public Criteria andGuaranteeGreaterThan(String value) {
			addCriterion("GUARANTEE >", value, "guarantee");
			return (Criteria) this;
		}

		public Criteria andGuaranteeGreaterThanOrEqualTo(String value) {
			addCriterion("GUARANTEE >=", value, "guarantee");
			return (Criteria) this;
		}

		public Criteria andGuaranteeLessThan(String value) {
			addCriterion("GUARANTEE <", value, "guarantee");
			return (Criteria) this;
		}

		public Criteria andGuaranteeLessThanOrEqualTo(String value) {
			addCriterion("GUARANTEE <=", value, "guarantee");
			return (Criteria) this;
		}

		public Criteria andGuaranteeLike(String value) {
			addCriterion("GUARANTEE like", value, "guarantee");
			return (Criteria) this;
		}

		public Criteria andGuaranteeNotLike(String value) {
			addCriterion("GUARANTEE not like", value, "guarantee");
			return (Criteria) this;
		}

		public Criteria andGuaranteeIn(List<String> values) {
			addCriterion("GUARANTEE in", values, "guarantee");
			return (Criteria) this;
		}

		public Criteria andGuaranteeNotIn(List<String> values) {
			addCriterion("GUARANTEE not in", values, "guarantee");
			return (Criteria) this;
		}

		public Criteria andGuaranteeBetween(String value1, String value2) {
			addCriterion("GUARANTEE between", value1, value2, "guarantee");
			return (Criteria) this;
		}

		public Criteria andGuaranteeNotBetween(String value1, String value2) {
			addCriterion("GUARANTEE not between", value1, value2, "guarantee");
			return (Criteria) this;
		}

		public Criteria andGuarBusiLicenseNoIsNull() {
			addCriterion("GUAR_BUSI_LICENSE_NO is null");
			return (Criteria) this;
		}

		public Criteria andGuarBusiLicenseNoIsNotNull() {
			addCriterion("GUAR_BUSI_LICENSE_NO is not null");
			return (Criteria) this;
		}

		public Criteria andGuarBusiLicenseNoEqualTo(String value) {
			addCriterion("GUAR_BUSI_LICENSE_NO =", value, "guarBusiLicenseNo");
			return (Criteria) this;
		}

		public Criteria andGuarBusiLicenseNoNotEqualTo(String value) {
			addCriterion("GUAR_BUSI_LICENSE_NO <>", value, "guarBusiLicenseNo");
			return (Criteria) this;
		}

		public Criteria andGuarBusiLicenseNoGreaterThan(String value) {
			addCriterion("GUAR_BUSI_LICENSE_NO >", value, "guarBusiLicenseNo");
			return (Criteria) this;
		}

		public Criteria andGuarBusiLicenseNoGreaterThanOrEqualTo(String value) {
			addCriterion("GUAR_BUSI_LICENSE_NO >=", value, "guarBusiLicenseNo");
			return (Criteria) this;
		}

		public Criteria andGuarBusiLicenseNoLessThan(String value) {
			addCriterion("GUAR_BUSI_LICENSE_NO <", value, "guarBusiLicenseNo");
			return (Criteria) this;
		}

		public Criteria andGuarBusiLicenseNoLessThanOrEqualTo(String value) {
			addCriterion("GUAR_BUSI_LICENSE_NO <=", value, "guarBusiLicenseNo");
			return (Criteria) this;
		}

		public Criteria andGuarBusiLicenseNoLike(String value) {
			addCriterion("GUAR_BUSI_LICENSE_NO like", value, "guarBusiLicenseNo");
			return (Criteria) this;
		}

		public Criteria andGuarBusiLicenseNoNotLike(String value) {
			addCriterion("GUAR_BUSI_LICENSE_NO not like", value, "guarBusiLicenseNo");
			return (Criteria) this;
		}

		public Criteria andGuarBusiLicenseNoIn(List<String> values) {
			addCriterion("GUAR_BUSI_LICENSE_NO in", values, "guarBusiLicenseNo");
			return (Criteria) this;
		}

		public Criteria andGuarBusiLicenseNoNotIn(List<String> values) {
			addCriterion("GUAR_BUSI_LICENSE_NO not in", values, "guarBusiLicenseNo");
			return (Criteria) this;
		}

		public Criteria andGuarBusiLicenseNoBetween(String value1, String value2) {
			addCriterion("GUAR_BUSI_LICENSE_NO between", value1, value2, "guarBusiLicenseNo");
			return (Criteria) this;
		}

		public Criteria andGuarBusiLicenseNoNotBetween(String value1, String value2) {
			addCriterion("GUAR_BUSI_LICENSE_NO not between", value1, value2, "guarBusiLicenseNo");
			return (Criteria) this;
		}

		public Criteria andGuarLegalPersonIsNull() {
			addCriterion("GUAR_LEGAL_PERSON is null");
			return (Criteria) this;
		}

		public Criteria andGuarLegalPersonIsNotNull() {
			addCriterion("GUAR_LEGAL_PERSON is not null");
			return (Criteria) this;
		}

		public Criteria andGuarLegalPersonEqualTo(String value) {
			addCriterion("GUAR_LEGAL_PERSON =", value, "guarLegalPerson");
			return (Criteria) this;
		}

		public Criteria andGuarLegalPersonNotEqualTo(String value) {
			addCriterion("GUAR_LEGAL_PERSON <>", value, "guarLegalPerson");
			return (Criteria) this;
		}

		public Criteria andGuarLegalPersonGreaterThan(String value) {
			addCriterion("GUAR_LEGAL_PERSON >", value, "guarLegalPerson");
			return (Criteria) this;
		}

		public Criteria andGuarLegalPersonGreaterThanOrEqualTo(String value) {
			addCriterion("GUAR_LEGAL_PERSON >=", value, "guarLegalPerson");
			return (Criteria) this;
		}

		public Criteria andGuarLegalPersonLessThan(String value) {
			addCriterion("GUAR_LEGAL_PERSON <", value, "guarLegalPerson");
			return (Criteria) this;
		}

		public Criteria andGuarLegalPersonLessThanOrEqualTo(String value) {
			addCriterion("GUAR_LEGAL_PERSON <=", value, "guarLegalPerson");
			return (Criteria) this;
		}

		public Criteria andGuarLegalPersonLike(String value) {
			addCriterion("GUAR_LEGAL_PERSON like", value, "guarLegalPerson");
			return (Criteria) this;
		}

		public Criteria andGuarLegalPersonNotLike(String value) {
			addCriterion("GUAR_LEGAL_PERSON not like", value, "guarLegalPerson");
			return (Criteria) this;
		}

		public Criteria andGuarLegalPersonIn(List<String> values) {
			addCriterion("GUAR_LEGAL_PERSON in", values, "guarLegalPerson");
			return (Criteria) this;
		}

		public Criteria andGuarLegalPersonNotIn(List<String> values) {
			addCriterion("GUAR_LEGAL_PERSON not in", values, "guarLegalPerson");
			return (Criteria) this;
		}

		public Criteria andGuarLegalPersonBetween(String value1, String value2) {
			addCriterion("GUAR_LEGAL_PERSON between", value1, value2, "guarLegalPerson");
			return (Criteria) this;
		}

		public Criteria andGuarLegalPersonNotBetween(String value1, String value2) {
			addCriterion("GUAR_LEGAL_PERSON not between", value1, value2, "guarLegalPerson");
			return (Criteria) this;
		}

		public Criteria andGuarCompOpenDateIsNull() {
			addCriterion("GUAR_COMP_OPEN_DATE is null");
			return (Criteria) this;
		}

		public Criteria andGuarCompOpenDateIsNotNull() {
			addCriterion("GUAR_COMP_OPEN_DATE is not null");
			return (Criteria) this;
		}

		public Criteria andGuarCompOpenDateEqualTo(Date value) {
			addCriterionForJDBCDate("GUAR_COMP_OPEN_DATE =", value, "guarCompOpenDate");
			return (Criteria) this;
		}

		public Criteria andGuarCompOpenDateNotEqualTo(Date value) {
			addCriterionForJDBCDate("GUAR_COMP_OPEN_DATE <>", value, "guarCompOpenDate");
			return (Criteria) this;
		}

		public Criteria andGuarCompOpenDateGreaterThan(Date value) {
			addCriterionForJDBCDate("GUAR_COMP_OPEN_DATE >", value, "guarCompOpenDate");
			return (Criteria) this;
		}

		public Criteria andGuarCompOpenDateGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("GUAR_COMP_OPEN_DATE >=", value, "guarCompOpenDate");
			return (Criteria) this;
		}

		public Criteria andGuarCompOpenDateLessThan(Date value) {
			addCriterionForJDBCDate("GUAR_COMP_OPEN_DATE <", value, "guarCompOpenDate");
			return (Criteria) this;
		}

		public Criteria andGuarCompOpenDateLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("GUAR_COMP_OPEN_DATE <=", value, "guarCompOpenDate");
			return (Criteria) this;
		}

		public Criteria andGuarCompOpenDateIn(List<Date> values) {
			addCriterionForJDBCDate("GUAR_COMP_OPEN_DATE in", values, "guarCompOpenDate");
			return (Criteria) this;
		}

		public Criteria andGuarCompOpenDateNotIn(List<Date> values) {
			addCriterionForJDBCDate("GUAR_COMP_OPEN_DATE not in", values, "guarCompOpenDate");
			return (Criteria) this;
		}

		public Criteria andGuarCompOpenDateBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("GUAR_COMP_OPEN_DATE between", value1, value2, "guarCompOpenDate");
			return (Criteria) this;
		}

		public Criteria andGuarCompOpenDateNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("GUAR_COMP_OPEN_DATE not between", value1, value2, "guarCompOpenDate");
			return (Criteria) this;
		}

		public Criteria andGuarCompAddrIsNull() {
			addCriterion("GUAR_COMP_ADDR is null");
			return (Criteria) this;
		}

		public Criteria andGuarCompAddrIsNotNull() {
			addCriterion("GUAR_COMP_ADDR is not null");
			return (Criteria) this;
		}

		public Criteria andGuarCompAddrEqualTo(String value) {
			addCriterion("GUAR_COMP_ADDR =", value, "guarCompAddr");
			return (Criteria) this;
		}

		public Criteria andGuarCompAddrNotEqualTo(String value) {
			addCriterion("GUAR_COMP_ADDR <>", value, "guarCompAddr");
			return (Criteria) this;
		}

		public Criteria andGuarCompAddrGreaterThan(String value) {
			addCriterion("GUAR_COMP_ADDR >", value, "guarCompAddr");
			return (Criteria) this;
		}

		public Criteria andGuarCompAddrGreaterThanOrEqualTo(String value) {
			addCriterion("GUAR_COMP_ADDR >=", value, "guarCompAddr");
			return (Criteria) this;
		}

		public Criteria andGuarCompAddrLessThan(String value) {
			addCriterion("GUAR_COMP_ADDR <", value, "guarCompAddr");
			return (Criteria) this;
		}

		public Criteria andGuarCompAddrLessThanOrEqualTo(String value) {
			addCriterion("GUAR_COMP_ADDR <=", value, "guarCompAddr");
			return (Criteria) this;
		}

		public Criteria andGuarCompAddrLike(String value) {
			addCriterion("GUAR_COMP_ADDR like", value, "guarCompAddr");
			return (Criteria) this;
		}

		public Criteria andGuarCompAddrNotLike(String value) {
			addCriterion("GUAR_COMP_ADDR not like", value, "guarCompAddr");
			return (Criteria) this;
		}

		public Criteria andGuarCompAddrIn(List<String> values) {
			addCriterion("GUAR_COMP_ADDR in", values, "guarCompAddr");
			return (Criteria) this;
		}

		public Criteria andGuarCompAddrNotIn(List<String> values) {
			addCriterion("GUAR_COMP_ADDR not in", values, "guarCompAddr");
			return (Criteria) this;
		}

		public Criteria andGuarCompAddrBetween(String value1, String value2) {
			addCriterion("GUAR_COMP_ADDR between", value1, value2, "guarCompAddr");
			return (Criteria) this;
		}

		public Criteria andGuarCompAddrNotBetween(String value1, String value2) {
			addCriterion("GUAR_COMP_ADDR not between", value1, value2, "guarCompAddr");
			return (Criteria) this;
		}

		public Criteria andGuarPhoneIsNull() {
			addCriterion("GUAR_PHONE is null");
			return (Criteria) this;
		}

		public Criteria andGuarPhoneIsNotNull() {
			addCriterion("GUAR_PHONE is not null");
			return (Criteria) this;
		}

		public Criteria andGuarPhoneEqualTo(String value) {
			addCriterion("GUAR_PHONE =", value, "guarPhone");
			return (Criteria) this;
		}

		public Criteria andGuarPhoneNotEqualTo(String value) {
			addCriterion("GUAR_PHONE <>", value, "guarPhone");
			return (Criteria) this;
		}

		public Criteria andGuarPhoneGreaterThan(String value) {
			addCriterion("GUAR_PHONE >", value, "guarPhone");
			return (Criteria) this;
		}

		public Criteria andGuarPhoneGreaterThanOrEqualTo(String value) {
			addCriterion("GUAR_PHONE >=", value, "guarPhone");
			return (Criteria) this;
		}

		public Criteria andGuarPhoneLessThan(String value) {
			addCriterion("GUAR_PHONE <", value, "guarPhone");
			return (Criteria) this;
		}

		public Criteria andGuarPhoneLessThanOrEqualTo(String value) {
			addCriterion("GUAR_PHONE <=", value, "guarPhone");
			return (Criteria) this;
		}

		public Criteria andGuarPhoneLike(String value) {
			addCriterion("GUAR_PHONE like", value, "guarPhone");
			return (Criteria) this;
		}

		public Criteria andGuarPhoneNotLike(String value) {
			addCriterion("GUAR_PHONE not like", value, "guarPhone");
			return (Criteria) this;
		}

		public Criteria andGuarPhoneIn(List<String> values) {
			addCriterion("GUAR_PHONE in", values, "guarPhone");
			return (Criteria) this;
		}

		public Criteria andGuarPhoneNotIn(List<String> values) {
			addCriterion("GUAR_PHONE not in", values, "guarPhone");
			return (Criteria) this;
		}

		public Criteria andGuarPhoneBetween(String value1, String value2) {
			addCriterion("GUAR_PHONE between", value1, value2, "guarPhone");
			return (Criteria) this;
		}

		public Criteria andGuarPhoneNotBetween(String value1, String value2) {
			addCriterion("GUAR_PHONE not between", value1, value2, "guarPhone");
			return (Criteria) this;
		}

		public Criteria andGuarCapitalIsNull() {
			addCriterion("GUAR_CAPITAL is null");
			return (Criteria) this;
		}

		public Criteria andGuarCapitalIsNotNull() {
			addCriterion("GUAR_CAPITAL is not null");
			return (Criteria) this;
		}

		public Criteria andGuarCapitalEqualTo(BigDecimal value) {
			addCriterion("GUAR_CAPITAL =", value, "guarCapital");
			return (Criteria) this;
		}

		public Criteria andGuarCapitalNotEqualTo(BigDecimal value) {
			addCriterion("GUAR_CAPITAL <>", value, "guarCapital");
			return (Criteria) this;
		}

		public Criteria andGuarCapitalGreaterThan(BigDecimal value) {
			addCriterion("GUAR_CAPITAL >", value, "guarCapital");
			return (Criteria) this;
		}

		public Criteria andGuarCapitalGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("GUAR_CAPITAL >=", value, "guarCapital");
			return (Criteria) this;
		}

		public Criteria andGuarCapitalLessThan(BigDecimal value) {
			addCriterion("GUAR_CAPITAL <", value, "guarCapital");
			return (Criteria) this;
		}

		public Criteria andGuarCapitalLessThanOrEqualTo(BigDecimal value) {
			addCriterion("GUAR_CAPITAL <=", value, "guarCapital");
			return (Criteria) this;
		}

		public Criteria andGuarCapitalIn(List<BigDecimal> values) {
			addCriterion("GUAR_CAPITAL in", values, "guarCapital");
			return (Criteria) this;
		}

		public Criteria andGuarCapitalNotIn(List<BigDecimal> values) {
			addCriterion("GUAR_CAPITAL not in", values, "guarCapital");
			return (Criteria) this;
		}

		public Criteria andGuarCapitalBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("GUAR_CAPITAL between", value1, value2, "guarCapital");
			return (Criteria) this;
		}

		public Criteria andGuarCapitalNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("GUAR_CAPITAL not between", value1, value2, "guarCapital");
			return (Criteria) this;
		}

		public Criteria andGuarCreditRateIsNull() {
			addCriterion("GUAR_CREDIT_RATE is null");
			return (Criteria) this;
		}

		public Criteria andGuarCreditRateIsNotNull() {
			addCriterion("GUAR_CREDIT_RATE is not null");
			return (Criteria) this;
		}

		public Criteria andGuarCreditRateEqualTo(String value) {
			addCriterion("GUAR_CREDIT_RATE =", value, "guarCreditRate");
			return (Criteria) this;
		}

		public Criteria andGuarCreditRateNotEqualTo(String value) {
			addCriterion("GUAR_CREDIT_RATE <>", value, "guarCreditRate");
			return (Criteria) this;
		}

		public Criteria andGuarCreditRateGreaterThan(String value) {
			addCriterion("GUAR_CREDIT_RATE >", value, "guarCreditRate");
			return (Criteria) this;
		}

		public Criteria andGuarCreditRateGreaterThanOrEqualTo(String value) {
			addCriterion("GUAR_CREDIT_RATE >=", value, "guarCreditRate");
			return (Criteria) this;
		}

		public Criteria andGuarCreditRateLessThan(String value) {
			addCriterion("GUAR_CREDIT_RATE <", value, "guarCreditRate");
			return (Criteria) this;
		}

		public Criteria andGuarCreditRateLessThanOrEqualTo(String value) {
			addCriterion("GUAR_CREDIT_RATE <=", value, "guarCreditRate");
			return (Criteria) this;
		}

		public Criteria andGuarCreditRateLike(String value) {
			addCriterion("GUAR_CREDIT_RATE like", value, "guarCreditRate");
			return (Criteria) this;
		}

		public Criteria andGuarCreditRateNotLike(String value) {
			addCriterion("GUAR_CREDIT_RATE not like", value, "guarCreditRate");
			return (Criteria) this;
		}

		public Criteria andGuarCreditRateIn(List<String> values) {
			addCriterion("GUAR_CREDIT_RATE in", values, "guarCreditRate");
			return (Criteria) this;
		}

		public Criteria andGuarCreditRateNotIn(List<String> values) {
			addCriterion("GUAR_CREDIT_RATE not in", values, "guarCreditRate");
			return (Criteria) this;
		}

		public Criteria andGuarCreditRateBetween(String value1, String value2) {
			addCriterion("GUAR_CREDIT_RATE between", value1, value2, "guarCreditRate");
			return (Criteria) this;
		}

		public Criteria andGuarCreditRateNotBetween(String value1, String value2) {
			addCriterion("GUAR_CREDIT_RATE not between", value1, value2, "guarCreditRate");
			return (Criteria) this;
		}

		public Criteria andHostageTypeIsNull() {
			addCriterion("HOSTAGE_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andHostageTypeIsNotNull() {
			addCriterion("HOSTAGE_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andHostageTypeEqualTo(String value) {
			addCriterion("HOSTAGE_TYPE =", value, "hostageType");
			return (Criteria) this;
		}

		public Criteria andHostageTypeNotEqualTo(String value) {
			addCriterion("HOSTAGE_TYPE <>", value, "hostageType");
			return (Criteria) this;
		}

		public Criteria andHostageTypeGreaterThan(String value) {
			addCriterion("HOSTAGE_TYPE >", value, "hostageType");
			return (Criteria) this;
		}

		public Criteria andHostageTypeGreaterThanOrEqualTo(String value) {
			addCriterion("HOSTAGE_TYPE >=", value, "hostageType");
			return (Criteria) this;
		}

		public Criteria andHostageTypeLessThan(String value) {
			addCriterion("HOSTAGE_TYPE <", value, "hostageType");
			return (Criteria) this;
		}

		public Criteria andHostageTypeLessThanOrEqualTo(String value) {
			addCriterion("HOSTAGE_TYPE <=", value, "hostageType");
			return (Criteria) this;
		}

		public Criteria andHostageTypeLike(String value) {
			addCriterion("HOSTAGE_TYPE like", value, "hostageType");
			return (Criteria) this;
		}

		public Criteria andHostageTypeNotLike(String value) {
			addCriterion("HOSTAGE_TYPE not like", value, "hostageType");
			return (Criteria) this;
		}

		public Criteria andHostageTypeIn(List<String> values) {
			addCriterion("HOSTAGE_TYPE in", values, "hostageType");
			return (Criteria) this;
		}

		public Criteria andHostageTypeNotIn(List<String> values) {
			addCriterion("HOSTAGE_TYPE not in", values, "hostageType");
			return (Criteria) this;
		}

		public Criteria andHostageTypeBetween(String value1, String value2) {
			addCriterion("HOSTAGE_TYPE between", value1, value2, "hostageType");
			return (Criteria) this;
		}

		public Criteria andHostageTypeNotBetween(String value1, String value2) {
			addCriterion("HOSTAGE_TYPE not between", value1, value2, "hostageType");
			return (Criteria) this;
		}

		public Criteria andHostageNoIsNull() {
			addCriterion("HOSTAGE_NO is null");
			return (Criteria) this;
		}

		public Criteria andHostageNoIsNotNull() {
			addCriterion("HOSTAGE_NO is not null");
			return (Criteria) this;
		}

		public Criteria andHostageNoEqualTo(String value) {
			addCriterion("HOSTAGE_NO =", value, "hostageNo");
			return (Criteria) this;
		}

		public Criteria andHostageNoNotEqualTo(String value) {
			addCriterion("HOSTAGE_NO <>", value, "hostageNo");
			return (Criteria) this;
		}

		public Criteria andHostageNoGreaterThan(String value) {
			addCriterion("HOSTAGE_NO >", value, "hostageNo");
			return (Criteria) this;
		}

		public Criteria andHostageNoGreaterThanOrEqualTo(String value) {
			addCriterion("HOSTAGE_NO >=", value, "hostageNo");
			return (Criteria) this;
		}

		public Criteria andHostageNoLessThan(String value) {
			addCriterion("HOSTAGE_NO <", value, "hostageNo");
			return (Criteria) this;
		}

		public Criteria andHostageNoLessThanOrEqualTo(String value) {
			addCriterion("HOSTAGE_NO <=", value, "hostageNo");
			return (Criteria) this;
		}

		public Criteria andHostageNoLike(String value) {
			addCriterion("HOSTAGE_NO like", value, "hostageNo");
			return (Criteria) this;
		}

		public Criteria andHostageNoNotLike(String value) {
			addCriterion("HOSTAGE_NO not like", value, "hostageNo");
			return (Criteria) this;
		}

		public Criteria andHostageNoIn(List<String> values) {
			addCriterion("HOSTAGE_NO in", values, "hostageNo");
			return (Criteria) this;
		}

		public Criteria andHostageNoNotIn(List<String> values) {
			addCriterion("HOSTAGE_NO not in", values, "hostageNo");
			return (Criteria) this;
		}

		public Criteria andHostageNoBetween(String value1, String value2) {
			addCriterion("HOSTAGE_NO between", value1, value2, "hostageNo");
			return (Criteria) this;
		}

		public Criteria andHostageNoNotBetween(String value1, String value2) {
			addCriterion("HOSTAGE_NO not between", value1, value2, "hostageNo");
			return (Criteria) this;
		}

		public Criteria andHostageOwnerIsNull() {
			addCriterion("HOSTAGE_OWNER is null");
			return (Criteria) this;
		}

		public Criteria andHostageOwnerIsNotNull() {
			addCriterion("HOSTAGE_OWNER is not null");
			return (Criteria) this;
		}

		public Criteria andHostageOwnerEqualTo(String value) {
			addCriterion("HOSTAGE_OWNER =", value, "hostageOwner");
			return (Criteria) this;
		}

		public Criteria andHostageOwnerNotEqualTo(String value) {
			addCriterion("HOSTAGE_OWNER <>", value, "hostageOwner");
			return (Criteria) this;
		}

		public Criteria andHostageOwnerGreaterThan(String value) {
			addCriterion("HOSTAGE_OWNER >", value, "hostageOwner");
			return (Criteria) this;
		}

		public Criteria andHostageOwnerGreaterThanOrEqualTo(String value) {
			addCriterion("HOSTAGE_OWNER >=", value, "hostageOwner");
			return (Criteria) this;
		}

		public Criteria andHostageOwnerLessThan(String value) {
			addCriterion("HOSTAGE_OWNER <", value, "hostageOwner");
			return (Criteria) this;
		}

		public Criteria andHostageOwnerLessThanOrEqualTo(String value) {
			addCriterion("HOSTAGE_OWNER <=", value, "hostageOwner");
			return (Criteria) this;
		}

		public Criteria andHostageOwnerLike(String value) {
			addCriterion("HOSTAGE_OWNER like", value, "hostageOwner");
			return (Criteria) this;
		}

		public Criteria andHostageOwnerNotLike(String value) {
			addCriterion("HOSTAGE_OWNER not like", value, "hostageOwner");
			return (Criteria) this;
		}

		public Criteria andHostageOwnerIn(List<String> values) {
			addCriterion("HOSTAGE_OWNER in", values, "hostageOwner");
			return (Criteria) this;
		}

		public Criteria andHostageOwnerNotIn(List<String> values) {
			addCriterion("HOSTAGE_OWNER not in", values, "hostageOwner");
			return (Criteria) this;
		}

		public Criteria andHostageOwnerBetween(String value1, String value2) {
			addCriterion("HOSTAGE_OWNER between", value1, value2, "hostageOwner");
			return (Criteria) this;
		}

		public Criteria andHostageOwnerNotBetween(String value1, String value2) {
			addCriterion("HOSTAGE_OWNER not between", value1, value2, "hostageOwner");
			return (Criteria) this;
		}

		public Criteria andDepositAccountIsNull() {
			addCriterion("DEPOSIT_ACCOUNT is null");
			return (Criteria) this;
		}

		public Criteria andDepositAccountIsNotNull() {
			addCriterion("DEPOSIT_ACCOUNT is not null");
			return (Criteria) this;
		}

		public Criteria andDepositAccountEqualTo(String value) {
			addCriterion("DEPOSIT_ACCOUNT =", value, "depositAccount");
			return (Criteria) this;
		}

		public Criteria andDepositAccountNotEqualTo(String value) {
			addCriterion("DEPOSIT_ACCOUNT <>", value, "depositAccount");
			return (Criteria) this;
		}

		public Criteria andDepositAccountGreaterThan(String value) {
			addCriterion("DEPOSIT_ACCOUNT >", value, "depositAccount");
			return (Criteria) this;
		}

		public Criteria andDepositAccountGreaterThanOrEqualTo(String value) {
			addCriterion("DEPOSIT_ACCOUNT >=", value, "depositAccount");
			return (Criteria) this;
		}

		public Criteria andDepositAccountLessThan(String value) {
			addCriterion("DEPOSIT_ACCOUNT <", value, "depositAccount");
			return (Criteria) this;
		}

		public Criteria andDepositAccountLessThanOrEqualTo(String value) {
			addCriterion("DEPOSIT_ACCOUNT <=", value, "depositAccount");
			return (Criteria) this;
		}

		public Criteria andDepositAccountLike(String value) {
			addCriterion("DEPOSIT_ACCOUNT like", value, "depositAccount");
			return (Criteria) this;
		}

		public Criteria andDepositAccountNotLike(String value) {
			addCriterion("DEPOSIT_ACCOUNT not like", value, "depositAccount");
			return (Criteria) this;
		}

		public Criteria andDepositAccountIn(List<String> values) {
			addCriterion("DEPOSIT_ACCOUNT in", values, "depositAccount");
			return (Criteria) this;
		}

		public Criteria andDepositAccountNotIn(List<String> values) {
			addCriterion("DEPOSIT_ACCOUNT not in", values, "depositAccount");
			return (Criteria) this;
		}

		public Criteria andDepositAccountBetween(String value1, String value2) {
			addCriterion("DEPOSIT_ACCOUNT between", value1, value2, "depositAccount");
			return (Criteria) this;
		}

		public Criteria andDepositAccountNotBetween(String value1, String value2) {
			addCriterion("DEPOSIT_ACCOUNT not between", value1, value2, "depositAccount");
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
			addCriterion("LOAN_PRODUCT not between", value1, value2, "loanProduct");
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

		public Criteria andLoanAmountBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LOAN_AMOUNT between", value1, value2, "loanAmount");
			return (Criteria) this;
		}

		public Criteria andLoanAmountNotBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("LOAN_AMOUNT not between", value1, value2, "loanAmount");
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
			addCriterion("LEND_ACCOUNT not between", value1, value2, "lendAccount");
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
			addCriterion("PAY_ACCOUNT not between", value1, value2, "payAccount");
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

		protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
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
