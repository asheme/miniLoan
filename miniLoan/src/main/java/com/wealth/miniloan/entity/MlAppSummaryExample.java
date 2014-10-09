package com.wealth.miniloan.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MlAppSummaryExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ml_app_summary
     *
     * @mbggenerated Wed Oct 01 16:13:31 CST 2014
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ml_app_summary
     *
     * @mbggenerated Wed Oct 01 16:13:31 CST 2014
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ml_app_summary
     *
     * @mbggenerated Wed Oct 01 16:13:31 CST 2014
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_app_summary
     *
     * @mbggenerated Wed Oct 01 16:13:31 CST 2014
     */
    public MlAppSummaryExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_app_summary
     *
     * @mbggenerated Wed Oct 01 16:13:31 CST 2014
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_app_summary
     *
     * @mbggenerated Wed Oct 01 16:13:31 CST 2014
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_app_summary
     *
     * @mbggenerated Wed Oct 01 16:13:31 CST 2014
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_app_summary
     *
     * @mbggenerated Wed Oct 01 16:13:31 CST 2014
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_app_summary
     *
     * @mbggenerated Wed Oct 01 16:13:31 CST 2014
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_app_summary
     *
     * @mbggenerated Wed Oct 01 16:13:31 CST 2014
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_app_summary
     *
     * @mbggenerated Wed Oct 01 16:13:31 CST 2014
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_app_summary
     *
     * @mbggenerated Wed Oct 01 16:13:31 CST 2014
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_app_summary
     *
     * @mbggenerated Wed Oct 01 16:13:31 CST 2014
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_app_summary
     *
     * @mbggenerated Wed Oct 01 16:13:31 CST 2014
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ml_app_summary
     *
     * @mbggenerated Wed Oct 01 16:13:31 CST 2014
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
            addCriterion("FINISH_TIME not between", value1, value2, "finishTime");
            return (Criteria) this;
        }

        public Criteria andDealResultIsNull() {
            addCriterion("DEAL_RESULT is null");
            return (Criteria) this;
        }

        public Criteria andDealResultIsNotNull() {
            addCriterion("DEAL_RESULT is not null");
            return (Criteria) this;
        }

        public Criteria andDealResultEqualTo(String value) {
            addCriterion("DEAL_RESULT =", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultNotEqualTo(String value) {
            addCriterion("DEAL_RESULT <>", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultGreaterThan(String value) {
            addCriterion("DEAL_RESULT >", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultGreaterThanOrEqualTo(String value) {
            addCriterion("DEAL_RESULT >=", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultLessThan(String value) {
            addCriterion("DEAL_RESULT <", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultLessThanOrEqualTo(String value) {
            addCriterion("DEAL_RESULT <=", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultLike(String value) {
            addCriterion("DEAL_RESULT like", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultNotLike(String value) {
            addCriterion("DEAL_RESULT not like", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultIn(List<String> values) {
            addCriterion("DEAL_RESULT in", values, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultNotIn(List<String> values) {
            addCriterion("DEAL_RESULT not in", values, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultBetween(String value1, String value2) {
            addCriterion("DEAL_RESULT between", value1, value2, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultNotBetween(String value1, String value2) {
            addCriterion("DEAL_RESULT not between", value1, value2, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealDescIsNull() {
            addCriterion("DEAL_DESC is null");
            return (Criteria) this;
        }

        public Criteria andDealDescIsNotNull() {
            addCriterion("DEAL_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andDealDescEqualTo(String value) {
            addCriterion("DEAL_DESC =", value, "dealDesc");
            return (Criteria) this;
        }

        public Criteria andDealDescNotEqualTo(String value) {
            addCriterion("DEAL_DESC <>", value, "dealDesc");
            return (Criteria) this;
        }

        public Criteria andDealDescGreaterThan(String value) {
            addCriterion("DEAL_DESC >", value, "dealDesc");
            return (Criteria) this;
        }

        public Criteria andDealDescGreaterThanOrEqualTo(String value) {
            addCriterion("DEAL_DESC >=", value, "dealDesc");
            return (Criteria) this;
        }

        public Criteria andDealDescLessThan(String value) {
            addCriterion("DEAL_DESC <", value, "dealDesc");
            return (Criteria) this;
        }

        public Criteria andDealDescLessThanOrEqualTo(String value) {
            addCriterion("DEAL_DESC <=", value, "dealDesc");
            return (Criteria) this;
        }

        public Criteria andDealDescLike(String value) {
            addCriterion("DEAL_DESC like", value, "dealDesc");
            return (Criteria) this;
        }

        public Criteria andDealDescNotLike(String value) {
            addCriterion("DEAL_DESC not like", value, "dealDesc");
            return (Criteria) this;
        }

        public Criteria andDealDescIn(List<String> values) {
            addCriterion("DEAL_DESC in", values, "dealDesc");
            return (Criteria) this;
        }

        public Criteria andDealDescNotIn(List<String> values) {
            addCriterion("DEAL_DESC not in", values, "dealDesc");
            return (Criteria) this;
        }

        public Criteria andDealDescBetween(String value1, String value2) {
            addCriterion("DEAL_DESC between", value1, value2, "dealDesc");
            return (Criteria) this;
        }

        public Criteria andDealDescNotBetween(String value1, String value2) {
            addCriterion("DEAL_DESC not between", value1, value2, "dealDesc");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ml_app_summary
     *
     * @mbggenerated do_not_delete_during_merge Wed Oct 01 16:13:31 CST 2014
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ml_app_summary
     *
     * @mbggenerated Wed Oct 01 16:13:31 CST 2014
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
}