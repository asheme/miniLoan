package com.wealth.miniloan.entity;

import java.util.ArrayList;
import java.util.List;

public class MlCorpAttachExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ml_corp_attach
     *
     * @mbggenerated Tue Sep 30 20:50:59 CST 2014
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ml_corp_attach
     *
     * @mbggenerated Tue Sep 30 20:50:59 CST 2014
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ml_corp_attach
     *
     * @mbggenerated Tue Sep 30 20:50:59 CST 2014
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_corp_attach
     *
     * @mbggenerated Tue Sep 30 20:50:59 CST 2014
     */
    public MlCorpAttachExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_corp_attach
     *
     * @mbggenerated Tue Sep 30 20:50:59 CST 2014
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_corp_attach
     *
     * @mbggenerated Tue Sep 30 20:50:59 CST 2014
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_corp_attach
     *
     * @mbggenerated Tue Sep 30 20:50:59 CST 2014
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_corp_attach
     *
     * @mbggenerated Tue Sep 30 20:50:59 CST 2014
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_corp_attach
     *
     * @mbggenerated Tue Sep 30 20:50:59 CST 2014
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_corp_attach
     *
     * @mbggenerated Tue Sep 30 20:50:59 CST 2014
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_corp_attach
     *
     * @mbggenerated Tue Sep 30 20:50:59 CST 2014
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_corp_attach
     *
     * @mbggenerated Tue Sep 30 20:50:59 CST 2014
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
     * This method corresponds to the database table ml_corp_attach
     *
     * @mbggenerated Tue Sep 30 20:50:59 CST 2014
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_corp_attach
     *
     * @mbggenerated Tue Sep 30 20:50:59 CST 2014
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ml_corp_attach
     *
     * @mbggenerated Tue Sep 30 20:50:59 CST 2014
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

        public Criteria andFileNoIsNull() {
            addCriterion("FILE_NO is null");
            return (Criteria) this;
        }

        public Criteria andFileNoIsNotNull() {
            addCriterion("FILE_NO is not null");
            return (Criteria) this;
        }

        public Criteria andFileNoEqualTo(Long value) {
            addCriterion("FILE_NO =", value, "fileNo");
            return (Criteria) this;
        }

        public Criteria andFileNoNotEqualTo(Long value) {
            addCriterion("FILE_NO <>", value, "fileNo");
            return (Criteria) this;
        }

        public Criteria andFileNoGreaterThan(Long value) {
            addCriterion("FILE_NO >", value, "fileNo");
            return (Criteria) this;
        }

        public Criteria andFileNoGreaterThanOrEqualTo(Long value) {
            addCriterion("FILE_NO >=", value, "fileNo");
            return (Criteria) this;
        }

        public Criteria andFileNoLessThan(Long value) {
            addCriterion("FILE_NO <", value, "fileNo");
            return (Criteria) this;
        }

        public Criteria andFileNoLessThanOrEqualTo(Long value) {
            addCriterion("FILE_NO <=", value, "fileNo");
            return (Criteria) this;
        }

        public Criteria andFileNoIn(List<Long> values) {
            addCriterion("FILE_NO in", values, "fileNo");
            return (Criteria) this;
        }

        public Criteria andFileNoNotIn(List<Long> values) {
            addCriterion("FILE_NO not in", values, "fileNo");
            return (Criteria) this;
        }

        public Criteria andFileNoBetween(Long value1, Long value2) {
            addCriterion("FILE_NO between", value1, value2, "fileNo");
            return (Criteria) this;
        }

        public Criteria andFileNoNotBetween(Long value1, Long value2) {
            addCriterion("FILE_NO not between", value1, value2, "fileNo");
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

        public Criteria andFileNameIsNull() {
            addCriterion("FILE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andFileNameIsNotNull() {
            addCriterion("FILE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andFileNameEqualTo(String value) {
            addCriterion("FILE_NAME =", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotEqualTo(String value) {
            addCriterion("FILE_NAME <>", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThan(String value) {
            addCriterion("FILE_NAME >", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("FILE_NAME >=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThan(String value) {
            addCriterion("FILE_NAME <", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLessThanOrEqualTo(String value) {
            addCriterion("FILE_NAME <=", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameLike(String value) {
            addCriterion("FILE_NAME like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotLike(String value) {
            addCriterion("FILE_NAME not like", value, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameIn(List<String> values) {
            addCriterion("FILE_NAME in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotIn(List<String> values) {
            addCriterion("FILE_NAME not in", values, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameBetween(String value1, String value2) {
            addCriterion("FILE_NAME between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileNameNotBetween(String value1, String value2) {
            addCriterion("FILE_NAME not between", value1, value2, "fileName");
            return (Criteria) this;
        }

        public Criteria andFileDescIsNull() {
            addCriterion("FILE_DESC is null");
            return (Criteria) this;
        }

        public Criteria andFileDescIsNotNull() {
            addCriterion("FILE_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andFileDescEqualTo(String value) {
            addCriterion("FILE_DESC =", value, "fileDesc");
            return (Criteria) this;
        }

        public Criteria andFileDescNotEqualTo(String value) {
            addCriterion("FILE_DESC <>", value, "fileDesc");
            return (Criteria) this;
        }

        public Criteria andFileDescGreaterThan(String value) {
            addCriterion("FILE_DESC >", value, "fileDesc");
            return (Criteria) this;
        }

        public Criteria andFileDescGreaterThanOrEqualTo(String value) {
            addCriterion("FILE_DESC >=", value, "fileDesc");
            return (Criteria) this;
        }

        public Criteria andFileDescLessThan(String value) {
            addCriterion("FILE_DESC <", value, "fileDesc");
            return (Criteria) this;
        }

        public Criteria andFileDescLessThanOrEqualTo(String value) {
            addCriterion("FILE_DESC <=", value, "fileDesc");
            return (Criteria) this;
        }

        public Criteria andFileDescLike(String value) {
            addCriterion("FILE_DESC like", value, "fileDesc");
            return (Criteria) this;
        }

        public Criteria andFileDescNotLike(String value) {
            addCriterion("FILE_DESC not like", value, "fileDesc");
            return (Criteria) this;
        }

        public Criteria andFileDescIn(List<String> values) {
            addCriterion("FILE_DESC in", values, "fileDesc");
            return (Criteria) this;
        }

        public Criteria andFileDescNotIn(List<String> values) {
            addCriterion("FILE_DESC not in", values, "fileDesc");
            return (Criteria) this;
        }

        public Criteria andFileDescBetween(String value1, String value2) {
            addCriterion("FILE_DESC between", value1, value2, "fileDesc");
            return (Criteria) this;
        }

        public Criteria andFileDescNotBetween(String value1, String value2) {
            addCriterion("FILE_DESC not between", value1, value2, "fileDesc");
            return (Criteria) this;
        }

        public Criteria andPhysicalNameIsNull() {
            addCriterion("PHYSICAL_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPhysicalNameIsNotNull() {
            addCriterion("PHYSICAL_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPhysicalNameEqualTo(String value) {
            addCriterion("PHYSICAL_NAME =", value, "physicalName");
            return (Criteria) this;
        }

        public Criteria andPhysicalNameNotEqualTo(String value) {
            addCriterion("PHYSICAL_NAME <>", value, "physicalName");
            return (Criteria) this;
        }

        public Criteria andPhysicalNameGreaterThan(String value) {
            addCriterion("PHYSICAL_NAME >", value, "physicalName");
            return (Criteria) this;
        }

        public Criteria andPhysicalNameGreaterThanOrEqualTo(String value) {
            addCriterion("PHYSICAL_NAME >=", value, "physicalName");
            return (Criteria) this;
        }

        public Criteria andPhysicalNameLessThan(String value) {
            addCriterion("PHYSICAL_NAME <", value, "physicalName");
            return (Criteria) this;
        }

        public Criteria andPhysicalNameLessThanOrEqualTo(String value) {
            addCriterion("PHYSICAL_NAME <=", value, "physicalName");
            return (Criteria) this;
        }

        public Criteria andPhysicalNameLike(String value) {
            addCriterion("PHYSICAL_NAME like", value, "physicalName");
            return (Criteria) this;
        }

        public Criteria andPhysicalNameNotLike(String value) {
            addCriterion("PHYSICAL_NAME not like", value, "physicalName");
            return (Criteria) this;
        }

        public Criteria andPhysicalNameIn(List<String> values) {
            addCriterion("PHYSICAL_NAME in", values, "physicalName");
            return (Criteria) this;
        }

        public Criteria andPhysicalNameNotIn(List<String> values) {
            addCriterion("PHYSICAL_NAME not in", values, "physicalName");
            return (Criteria) this;
        }

        public Criteria andPhysicalNameBetween(String value1, String value2) {
            addCriterion("PHYSICAL_NAME between", value1, value2, "physicalName");
            return (Criteria) this;
        }

        public Criteria andPhysicalNameNotBetween(String value1, String value2) {
            addCriterion("PHYSICAL_NAME not between", value1, value2, "physicalName");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNull() {
            addCriterion("FILE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNotNull() {
            addCriterion("FILE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andFileTypeEqualTo(String value) {
            addCriterion("FILE_TYPE =", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotEqualTo(String value) {
            addCriterion("FILE_TYPE <>", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThan(String value) {
            addCriterion("FILE_TYPE >", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThanOrEqualTo(String value) {
            addCriterion("FILE_TYPE >=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThan(String value) {
            addCriterion("FILE_TYPE <", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThanOrEqualTo(String value) {
            addCriterion("FILE_TYPE <=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLike(String value) {
            addCriterion("FILE_TYPE like", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotLike(String value) {
            addCriterion("FILE_TYPE not like", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeIn(List<String> values) {
            addCriterion("FILE_TYPE in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotIn(List<String> values) {
            addCriterion("FILE_TYPE not in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeBetween(String value1, String value2) {
            addCriterion("FILE_TYPE between", value1, value2, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotBetween(String value1, String value2) {
            addCriterion("FILE_TYPE not between", value1, value2, "fileType");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ml_corp_attach
     *
     * @mbggenerated do_not_delete_during_merge Tue Sep 30 20:50:59 CST 2014
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ml_corp_attach
     *
     * @mbggenerated Tue Sep 30 20:50:59 CST 2014
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