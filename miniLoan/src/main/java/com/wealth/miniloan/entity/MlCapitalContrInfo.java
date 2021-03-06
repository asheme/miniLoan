package com.wealth.miniloan.entity;

import java.math.BigDecimal;
import java.util.Date;

public class MlCapitalContrInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_capital_contr_info.CAPITAL_ID
     *
     * @mbggenerated Sun Nov 02 18:35:50 CST 2014
     */
    private Long capitalId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_capital_contr_info.CONTRIBUTOR_ID
     *
     * @mbggenerated Sun Nov 02 18:35:50 CST 2014
     */
    private Long contributorId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_capital_contr_info.CAPITAL_AMOUNT
     *
     * @mbggenerated Sun Nov 02 18:35:50 CST 2014
     */
    private BigDecimal capitalAmount;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_capital_contr_info.CAPITAL_DATE
     *
     * @mbggenerated Sun Nov 02 18:35:50 CST 2014
     */
    private Date capitalDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_capital_contr_info.RETURN_RATE
     *
     * @mbggenerated Sun Nov 02 18:35:50 CST 2014
     */
    private BigDecimal returnRate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_capital_contr_info.STATUS
     *
     * @mbggenerated Sun Nov 02 18:35:50 CST 2014
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_capital_contr_info.OPER
     *
     * @mbggenerated Sun Nov 02 18:35:50 CST 2014
     */
    private Long oper;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_capital_contr_info.OPER_TIME
     *
     * @mbggenerated Sun Nov 02 18:35:50 CST 2014
     */
    private Date operTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_capital_contr_info.CAPITAL_ID
     *
     * @return the value of ml_capital_contr_info.CAPITAL_ID
     *
     * @mbggenerated Sun Nov 02 18:35:50 CST 2014
     */
    public Long getCapitalId() {
        return capitalId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_capital_contr_info.CAPITAL_ID
     *
     * @param capitalId the value for ml_capital_contr_info.CAPITAL_ID
     *
     * @mbggenerated Sun Nov 02 18:35:50 CST 2014
     */
    public void setCapitalId(Long capitalId) {
        this.capitalId = capitalId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_capital_contr_info.CONTRIBUTOR_ID
     *
     * @return the value of ml_capital_contr_info.CONTRIBUTOR_ID
     *
     * @mbggenerated Sun Nov 02 18:35:50 CST 2014
     */
    public Long getContributorId() {
        return contributorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_capital_contr_info.CONTRIBUTOR_ID
     *
     * @param contributorId the value for ml_capital_contr_info.CONTRIBUTOR_ID
     *
     * @mbggenerated Sun Nov 02 18:35:50 CST 2014
     */
    public void setContributorId(Long contributorId) {
        this.contributorId = contributorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_capital_contr_info.CAPITAL_AMOUNT
     *
     * @return the value of ml_capital_contr_info.CAPITAL_AMOUNT
     *
     * @mbggenerated Sun Nov 02 18:35:50 CST 2014
     */
    public BigDecimal getCapitalAmount() {
        return capitalAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_capital_contr_info.CAPITAL_AMOUNT
     *
     * @param capitalAmount the value for ml_capital_contr_info.CAPITAL_AMOUNT
     *
     * @mbggenerated Sun Nov 02 18:35:50 CST 2014
     */
    public void setCapitalAmount(BigDecimal capitalAmount) {
        this.capitalAmount = capitalAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_capital_contr_info.CAPITAL_DATE
     *
     * @return the value of ml_capital_contr_info.CAPITAL_DATE
     *
     * @mbggenerated Sun Nov 02 18:35:50 CST 2014
     */
    public Date getCapitalDate() {
        return capitalDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_capital_contr_info.CAPITAL_DATE
     *
     * @param capitalDate the value for ml_capital_contr_info.CAPITAL_DATE
     *
     * @mbggenerated Sun Nov 02 18:35:50 CST 2014
     */
    public void setCapitalDate(Date capitalDate) {
        this.capitalDate = capitalDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_capital_contr_info.RETURN_RATE
     *
     * @return the value of ml_capital_contr_info.RETURN_RATE
     *
     * @mbggenerated Sun Nov 02 18:35:50 CST 2014
     */
    public BigDecimal getReturnRate() {
        return returnRate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_capital_contr_info.RETURN_RATE
     *
     * @param returnRate the value for ml_capital_contr_info.RETURN_RATE
     *
     * @mbggenerated Sun Nov 02 18:35:50 CST 2014
     */
    public void setReturnRate(BigDecimal returnRate) {
        this.returnRate = returnRate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_capital_contr_info.STATUS
     *
     * @return the value of ml_capital_contr_info.STATUS
     *
     * @mbggenerated Sun Nov 02 18:35:50 CST 2014
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_capital_contr_info.STATUS
     *
     * @param status the value for ml_capital_contr_info.STATUS
     *
     * @mbggenerated Sun Nov 02 18:35:50 CST 2014
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_capital_contr_info.OPER
     *
     * @return the value of ml_capital_contr_info.OPER
     *
     * @mbggenerated Sun Nov 02 18:35:50 CST 2014
     */
    public Long getOper() {
        return oper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_capital_contr_info.OPER
     *
     * @param oper the value for ml_capital_contr_info.OPER
     *
     * @mbggenerated Sun Nov 02 18:35:50 CST 2014
     */
    public void setOper(Long oper) {
        this.oper = oper;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_capital_contr_info.OPER_TIME
     *
     * @return the value of ml_capital_contr_info.OPER_TIME
     *
     * @mbggenerated Sun Nov 02 18:35:50 CST 2014
     */
    public Date getOperTime() {
        return operTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_capital_contr_info.OPER_TIME
     *
     * @param operTime the value for ml_capital_contr_info.OPER_TIME
     *
     * @mbggenerated Sun Nov 02 18:35:50 CST 2014
     */
    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }
}