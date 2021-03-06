package com.wealth.miniloan.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MlNameListExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table ml_name_list
	 * @mbggenerated  Sat Oct 25 13:37:59 CST 2014
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table ml_name_list
	 * @mbggenerated  Sat Oct 25 13:37:59 CST 2014
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table ml_name_list
	 * @mbggenerated  Sat Oct 25 13:37:59 CST 2014
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_name_list
	 * @mbggenerated  Sat Oct 25 13:37:59 CST 2014
	 */
	public MlNameListExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_name_list
	 * @mbggenerated  Sat Oct 25 13:37:59 CST 2014
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_name_list
	 * @mbggenerated  Sat Oct 25 13:37:59 CST 2014
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_name_list
	 * @mbggenerated  Sat Oct 25 13:37:59 CST 2014
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_name_list
	 * @mbggenerated  Sat Oct 25 13:37:59 CST 2014
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_name_list
	 * @mbggenerated  Sat Oct 25 13:37:59 CST 2014
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_name_list
	 * @mbggenerated  Sat Oct 25 13:37:59 CST 2014
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_name_list
	 * @mbggenerated  Sat Oct 25 13:37:59 CST 2014
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_name_list
	 * @mbggenerated  Sat Oct 25 13:37:59 CST 2014
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_name_list
	 * @mbggenerated  Sat Oct 25 13:37:59 CST 2014
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_name_list
	 * @mbggenerated  Sat Oct 25 13:37:59 CST 2014
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table ml_name_list
	 * @mbggenerated  Sat Oct 25 13:37:59 CST 2014
	 */
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

		public Criteria andNameIdIsNull() {
			addCriterion("NAME_ID is null");
			return (Criteria) this;
		}

		public Criteria andNameIdIsNotNull() {
			addCriterion("NAME_ID is not null");
			return (Criteria) this;
		}

		public Criteria andNameIdEqualTo(Long value) {
			addCriterion("NAME_ID =", value, "nameId");
			return (Criteria) this;
		}

		public Criteria andNameIdNotEqualTo(Long value) {
			addCriterion("NAME_ID <>", value, "nameId");
			return (Criteria) this;
		}

		public Criteria andNameIdGreaterThan(Long value) {
			addCriterion("NAME_ID >", value, "nameId");
			return (Criteria) this;
		}

		public Criteria andNameIdGreaterThanOrEqualTo(Long value) {
			addCriterion("NAME_ID >=", value, "nameId");
			return (Criteria) this;
		}

		public Criteria andNameIdLessThan(Long value) {
			addCriterion("NAME_ID <", value, "nameId");
			return (Criteria) this;
		}

		public Criteria andNameIdLessThanOrEqualTo(Long value) {
			addCriterion("NAME_ID <=", value, "nameId");
			return (Criteria) this;
		}

		public Criteria andNameIdIn(List<Long> values) {
			addCriterion("NAME_ID in", values, "nameId");
			return (Criteria) this;
		}

		public Criteria andNameIdNotIn(List<Long> values) {
			addCriterion("NAME_ID not in", values, "nameId");
			return (Criteria) this;
		}

		public Criteria andNameIdBetween(Long value1, Long value2) {
			addCriterion("NAME_ID between", value1, value2, "nameId");
			return (Criteria) this;
		}

		public Criteria andNameIdNotBetween(Long value1, Long value2) {
			addCriterion("NAME_ID not between", value1, value2, "nameId");
			return (Criteria) this;
		}

		public Criteria andNameTypeIsNull() {
			addCriterion("NAME_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andNameTypeIsNotNull() {
			addCriterion("NAME_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andNameTypeEqualTo(String value) {
			addCriterion("NAME_TYPE =", value, "nameType");
			return (Criteria) this;
		}

		public Criteria andNameTypeNotEqualTo(String value) {
			addCriterion("NAME_TYPE <>", value, "nameType");
			return (Criteria) this;
		}

		public Criteria andNameTypeGreaterThan(String value) {
			addCriterion("NAME_TYPE >", value, "nameType");
			return (Criteria) this;
		}

		public Criteria andNameTypeGreaterThanOrEqualTo(String value) {
			addCriterion("NAME_TYPE >=", value, "nameType");
			return (Criteria) this;
		}

		public Criteria andNameTypeLessThan(String value) {
			addCriterion("NAME_TYPE <", value, "nameType");
			return (Criteria) this;
		}

		public Criteria andNameTypeLessThanOrEqualTo(String value) {
			addCriterion("NAME_TYPE <=", value, "nameType");
			return (Criteria) this;
		}

		public Criteria andNameTypeLike(String value) {
			addCriterion("NAME_TYPE like", value, "nameType");
			return (Criteria) this;
		}

		public Criteria andNameTypeNotLike(String value) {
			addCriterion("NAME_TYPE not like", value, "nameType");
			return (Criteria) this;
		}

		public Criteria andNameTypeIn(List<String> values) {
			addCriterion("NAME_TYPE in", values, "nameType");
			return (Criteria) this;
		}

		public Criteria andNameTypeNotIn(List<String> values) {
			addCriterion("NAME_TYPE not in", values, "nameType");
			return (Criteria) this;
		}

		public Criteria andNameTypeBetween(String value1, String value2) {
			addCriterion("NAME_TYPE between", value1, value2, "nameType");
			return (Criteria) this;
		}

		public Criteria andNameTypeNotBetween(String value1, String value2) {
			addCriterion("NAME_TYPE not between", value1, value2, "nameType");
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

		public Criteria andPhoneNumberIsNull() {
			addCriterion("PHONE_NUMBER is null");
			return (Criteria) this;
		}

		public Criteria andPhoneNumberIsNotNull() {
			addCriterion("PHONE_NUMBER is not null");
			return (Criteria) this;
		}

		public Criteria andPhoneNumberEqualTo(String value) {
			addCriterion("PHONE_NUMBER =", value, "phoneNumber");
			return (Criteria) this;
		}

		public Criteria andPhoneNumberNotEqualTo(String value) {
			addCriterion("PHONE_NUMBER <>", value, "phoneNumber");
			return (Criteria) this;
		}

		public Criteria andPhoneNumberGreaterThan(String value) {
			addCriterion("PHONE_NUMBER >", value, "phoneNumber");
			return (Criteria) this;
		}

		public Criteria andPhoneNumberGreaterThanOrEqualTo(String value) {
			addCriterion("PHONE_NUMBER >=", value, "phoneNumber");
			return (Criteria) this;
		}

		public Criteria andPhoneNumberLessThan(String value) {
			addCriterion("PHONE_NUMBER <", value, "phoneNumber");
			return (Criteria) this;
		}

		public Criteria andPhoneNumberLessThanOrEqualTo(String value) {
			addCriterion("PHONE_NUMBER <=", value, "phoneNumber");
			return (Criteria) this;
		}

		public Criteria andPhoneNumberLike(String value) {
			addCriterion("PHONE_NUMBER like", value, "phoneNumber");
			return (Criteria) this;
		}

		public Criteria andPhoneNumberNotLike(String value) {
			addCriterion("PHONE_NUMBER not like", value, "phoneNumber");
			return (Criteria) this;
		}

		public Criteria andPhoneNumberIn(List<String> values) {
			addCriterion("PHONE_NUMBER in", values, "phoneNumber");
			return (Criteria) this;
		}

		public Criteria andPhoneNumberNotIn(List<String> values) {
			addCriterion("PHONE_NUMBER not in", values, "phoneNumber");
			return (Criteria) this;
		}

		public Criteria andPhoneNumberBetween(String value1, String value2) {
			addCriterion("PHONE_NUMBER between", value1, value2, "phoneNumber");
			return (Criteria) this;
		}

		public Criteria andPhoneNumberNotBetween(String value1, String value2) {
			addCriterion("PHONE_NUMBER not between", value1, value2, "phoneNumber");
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

		public Criteria andUserIdIsNull() {
			addCriterion("USER_ID is null");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNotNull() {
			addCriterion("USER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andUserIdEqualTo(Long value) {
			addCriterion("USER_ID =", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotEqualTo(Long value) {
			addCriterion("USER_ID <>", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThan(Long value) {
			addCriterion("USER_ID >", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("USER_ID >=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThan(Long value) {
			addCriterion("USER_ID <", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThanOrEqualTo(Long value) {
			addCriterion("USER_ID <=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdIn(List<Long> values) {
			addCriterion("USER_ID in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotIn(List<Long> values) {
			addCriterion("USER_ID not in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdBetween(Long value1, Long value2) {
			addCriterion("USER_ID between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotBetween(Long value1, Long value2) {
			addCriterion("USER_ID not between", value1, value2, "userId");
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
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table ml_name_list
	 * @mbggenerated  Sat Oct 25 13:37:59 CST 2014
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

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ml_name_list
     *
     * @mbggenerated do_not_delete_during_merge Sun Oct 12 16:14:01 CST 2014
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}