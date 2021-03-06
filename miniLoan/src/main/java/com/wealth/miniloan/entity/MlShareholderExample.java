package com.wealth.miniloan.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MlShareholderExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table ml_shareholder_info
	 * @mbggenerated  Tue Sep 30 20:51:37 CST 2014
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table ml_shareholder_info
	 * @mbggenerated  Tue Sep 30 20:51:37 CST 2014
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table ml_shareholder_info
	 * @mbggenerated  Tue Sep 30 20:51:37 CST 2014
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_shareholder_info
	 * @mbggenerated  Tue Sep 30 20:51:37 CST 2014
	 */
	public MlShareholderExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_shareholder_info
	 * @mbggenerated  Tue Sep 30 20:51:37 CST 2014
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_shareholder_info
	 * @mbggenerated  Tue Sep 30 20:51:37 CST 2014
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_shareholder_info
	 * @mbggenerated  Tue Sep 30 20:51:37 CST 2014
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_shareholder_info
	 * @mbggenerated  Tue Sep 30 20:51:37 CST 2014
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_shareholder_info
	 * @mbggenerated  Tue Sep 30 20:51:37 CST 2014
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_shareholder_info
	 * @mbggenerated  Tue Sep 30 20:51:37 CST 2014
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_shareholder_info
	 * @mbggenerated  Tue Sep 30 20:51:37 CST 2014
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_shareholder_info
	 * @mbggenerated  Tue Sep 30 20:51:37 CST 2014
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_shareholder_info
	 * @mbggenerated  Tue Sep 30 20:51:37 CST 2014
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_shareholder_info
	 * @mbggenerated  Tue Sep 30 20:51:37 CST 2014
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table ml_shareholder_info
	 * @mbggenerated  Tue Sep 30 20:51:37 CST 2014
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

		public Criteria andShareholderIdIsNull() {
			addCriterion("SHAREHOLDER_ID is null");
			return (Criteria) this;
		}

		public Criteria andShareholderIdIsNotNull() {
			addCriterion("SHAREHOLDER_ID is not null");
			return (Criteria) this;
		}

		public Criteria andShareholderIdEqualTo(Long value) {
			addCriterion("SHAREHOLDER_ID =", value, "shareholderId");
			return (Criteria) this;
		}

		public Criteria andShareholderIdNotEqualTo(Long value) {
			addCriterion("SHAREHOLDER_ID <>", value, "shareholderId");
			return (Criteria) this;
		}

		public Criteria andShareholderIdGreaterThan(Long value) {
			addCriterion("SHAREHOLDER_ID >", value, "shareholderId");
			return (Criteria) this;
		}

		public Criteria andShareholderIdGreaterThanOrEqualTo(Long value) {
			addCriterion("SHAREHOLDER_ID >=", value, "shareholderId");
			return (Criteria) this;
		}

		public Criteria andShareholderIdLessThan(Long value) {
			addCriterion("SHAREHOLDER_ID <", value, "shareholderId");
			return (Criteria) this;
		}

		public Criteria andShareholderIdLessThanOrEqualTo(Long value) {
			addCriterion("SHAREHOLDER_ID <=", value, "shareholderId");
			return (Criteria) this;
		}

		public Criteria andShareholderIdIn(List<Long> values) {
			addCriterion("SHAREHOLDER_ID in", values, "shareholderId");
			return (Criteria) this;
		}

		public Criteria andShareholderIdNotIn(List<Long> values) {
			addCriterion("SHAREHOLDER_ID not in", values, "shareholderId");
			return (Criteria) this;
		}

		public Criteria andShareholderIdBetween(Long value1, Long value2) {
			addCriterion("SHAREHOLDER_ID between", value1, value2,
					"shareholderId");
			return (Criteria) this;
		}

		public Criteria andShareholderIdNotBetween(Long value1, Long value2) {
			addCriterion("SHAREHOLDER_ID not between", value1, value2,
					"shareholderId");
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

		public Criteria andShareholderNameIsNull() {
			addCriterion("SHAREHOLDER_NAME is null");
			return (Criteria) this;
		}

		public Criteria andShareholderNameIsNotNull() {
			addCriterion("SHAREHOLDER_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andShareholderNameEqualTo(String value) {
			addCriterion("SHAREHOLDER_NAME =", value, "shareholderName");
			return (Criteria) this;
		}

		public Criteria andShareholderNameNotEqualTo(String value) {
			addCriterion("SHAREHOLDER_NAME <>", value, "shareholderName");
			return (Criteria) this;
		}

		public Criteria andShareholderNameGreaterThan(String value) {
			addCriterion("SHAREHOLDER_NAME >", value, "shareholderName");
			return (Criteria) this;
		}

		public Criteria andShareholderNameGreaterThanOrEqualTo(String value) {
			addCriterion("SHAREHOLDER_NAME >=", value, "shareholderName");
			return (Criteria) this;
		}

		public Criteria andShareholderNameLessThan(String value) {
			addCriterion("SHAREHOLDER_NAME <", value, "shareholderName");
			return (Criteria) this;
		}

		public Criteria andShareholderNameLessThanOrEqualTo(String value) {
			addCriterion("SHAREHOLDER_NAME <=", value, "shareholderName");
			return (Criteria) this;
		}

		public Criteria andShareholderNameLike(String value) {
			addCriterion("SHAREHOLDER_NAME like", value, "shareholderName");
			return (Criteria) this;
		}

		public Criteria andShareholderNameNotLike(String value) {
			addCriterion("SHAREHOLDER_NAME not like", value, "shareholderName");
			return (Criteria) this;
		}

		public Criteria andShareholderNameIn(List<String> values) {
			addCriterion("SHAREHOLDER_NAME in", values, "shareholderName");
			return (Criteria) this;
		}

		public Criteria andShareholderNameNotIn(List<String> values) {
			addCriterion("SHAREHOLDER_NAME not in", values, "shareholderName");
			return (Criteria) this;
		}

		public Criteria andShareholderNameBetween(String value1, String value2) {
			addCriterion("SHAREHOLDER_NAME between", value1, value2,
					"shareholderName");
			return (Criteria) this;
		}

		public Criteria andShareholderNameNotBetween(String value1,
				String value2) {
			addCriterion("SHAREHOLDER_NAME not between", value1, value2,
					"shareholderName");
			return (Criteria) this;
		}

		public Criteria andShareRatioIsNull() {
			addCriterion("SHARE_RATIO is null");
			return (Criteria) this;
		}

		public Criteria andShareRatioIsNotNull() {
			addCriterion("SHARE_RATIO is not null");
			return (Criteria) this;
		}

		public Criteria andShareRatioEqualTo(BigDecimal value) {
			addCriterion("SHARE_RATIO =", value, "shareRatio");
			return (Criteria) this;
		}

		public Criteria andShareRatioNotEqualTo(BigDecimal value) {
			addCriterion("SHARE_RATIO <>", value, "shareRatio");
			return (Criteria) this;
		}

		public Criteria andShareRatioGreaterThan(BigDecimal value) {
			addCriterion("SHARE_RATIO >", value, "shareRatio");
			return (Criteria) this;
		}

		public Criteria andShareRatioGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("SHARE_RATIO >=", value, "shareRatio");
			return (Criteria) this;
		}

		public Criteria andShareRatioLessThan(BigDecimal value) {
			addCriterion("SHARE_RATIO <", value, "shareRatio");
			return (Criteria) this;
		}

		public Criteria andShareRatioLessThanOrEqualTo(BigDecimal value) {
			addCriterion("SHARE_RATIO <=", value, "shareRatio");
			return (Criteria) this;
		}

		public Criteria andShareRatioIn(List<BigDecimal> values) {
			addCriterion("SHARE_RATIO in", values, "shareRatio");
			return (Criteria) this;
		}

		public Criteria andShareRatioNotIn(List<BigDecimal> values) {
			addCriterion("SHARE_RATIO not in", values, "shareRatio");
			return (Criteria) this;
		}

		public Criteria andShareRatioBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("SHARE_RATIO between", value1, value2, "shareRatio");
			return (Criteria) this;
		}

		public Criteria andShareRatioNotBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("SHARE_RATIO not between", value1, value2,
					"shareRatio");
			return (Criteria) this;
		}

		public Criteria andRelationDescIsNull() {
			addCriterion("RELATION_DESC is null");
			return (Criteria) this;
		}

		public Criteria andRelationDescIsNotNull() {
			addCriterion("RELATION_DESC is not null");
			return (Criteria) this;
		}

		public Criteria andRelationDescEqualTo(String value) {
			addCriterion("RELATION_DESC =", value, "relationDesc");
			return (Criteria) this;
		}

		public Criteria andRelationDescNotEqualTo(String value) {
			addCriterion("RELATION_DESC <>", value, "relationDesc");
			return (Criteria) this;
		}

		public Criteria andRelationDescGreaterThan(String value) {
			addCriterion("RELATION_DESC >", value, "relationDesc");
			return (Criteria) this;
		}

		public Criteria andRelationDescGreaterThanOrEqualTo(String value) {
			addCriterion("RELATION_DESC >=", value, "relationDesc");
			return (Criteria) this;
		}

		public Criteria andRelationDescLessThan(String value) {
			addCriterion("RELATION_DESC <", value, "relationDesc");
			return (Criteria) this;
		}

		public Criteria andRelationDescLessThanOrEqualTo(String value) {
			addCriterion("RELATION_DESC <=", value, "relationDesc");
			return (Criteria) this;
		}

		public Criteria andRelationDescLike(String value) {
			addCriterion("RELATION_DESC like", value, "relationDesc");
			return (Criteria) this;
		}

		public Criteria andRelationDescNotLike(String value) {
			addCriterion("RELATION_DESC not like", value, "relationDesc");
			return (Criteria) this;
		}

		public Criteria andRelationDescIn(List<String> values) {
			addCriterion("RELATION_DESC in", values, "relationDesc");
			return (Criteria) this;
		}

		public Criteria andRelationDescNotIn(List<String> values) {
			addCriterion("RELATION_DESC not in", values, "relationDesc");
			return (Criteria) this;
		}

		public Criteria andRelationDescBetween(String value1, String value2) {
			addCriterion("RELATION_DESC between", value1, value2,
					"relationDesc");
			return (Criteria) this;
		}

		public Criteria andRelationDescNotBetween(String value1, String value2) {
			addCriterion("RELATION_DESC not between", value1, value2,
					"relationDesc");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table ml_shareholder_info
	 * @mbggenerated  Tue Sep 30 20:51:37 CST 2014
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

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ml_shareholder_info
     *
     * @mbggenerated do_not_delete_during_merge Tue Sep 30 20:48:00 CST 2014
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}