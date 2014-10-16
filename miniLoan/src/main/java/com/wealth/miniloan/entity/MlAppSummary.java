package com.wealth.miniloan.entity;

import java.util.Date;

public class MlAppSummary {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_app_summary.APP_NO
     *
     * @mbggenerated Wed Oct 15 14:13:02 CST 2014
     */
    private String appNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_app_summary.APP_TYPE
     *
     * @mbggenerated Wed Oct 15 14:13:02 CST 2014
     */
    private String appType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_app_summary.ENTER_TIME
     *
     * @mbggenerated Wed Oct 15 14:13:02 CST 2014
     */
    private Date enterTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_app_summary.PREVIOUS_STEP
     *
     * @mbggenerated Wed Oct 15 14:13:02 CST 2014
     */
    private String previousStep;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_app_summary.CURR_STEP
     *
     * @mbggenerated Wed Oct 15 14:13:02 CST 2014
     */
    private String currStep;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_app_summary.NEXT_STEP
     *
     * @mbggenerated Wed Oct 15 14:13:02 CST 2014
     */
    private String nextStep;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_app_summary.STATUS
     *
     * @mbggenerated Wed Oct 15 14:13:02 CST 2014
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_app_summary.HANDLER
     *
     * @mbggenerated Wed Oct 15 14:13:02 CST 2014
     */
    private Long handler;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_app_summary.FINISH_TIME
     *
     * @mbggenerated Wed Oct 15 14:13:02 CST 2014
     */
    private Date finishTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_app_summary.DEAL_RESULT
     *
     * @mbggenerated Wed Oct 15 14:13:02 CST 2014
     */
    private String dealResult;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_app_summary.DEAL_DESC
     *
     * @mbggenerated Wed Oct 15 14:13:02 CST 2014
     */
    private String dealDesc;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_app_summary.APP_NO
     *
     * @return the value of ml_app_summary.APP_NO
     *
     * @mbggenerated Wed Oct 15 14:13:02 CST 2014
     */
    public String getAppNo() {
        return appNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_app_summary.APP_NO
     *
     * @param appNo the value for ml_app_summary.APP_NO
     *
     * @mbggenerated Wed Oct 15 14:13:02 CST 2014
     */
    public void setAppNo(String appNo) {
        this.appNo = appNo == null ? null : appNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_app_summary.APP_TYPE
     *
     * @return the value of ml_app_summary.APP_TYPE
     *
     * @mbggenerated Wed Oct 15 14:13:02 CST 2014
     */
    public String getAppType() {
        return appType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_app_summary.APP_TYPE
     *
     * @param appType the value for ml_app_summary.APP_TYPE
     *
     * @mbggenerated Wed Oct 15 14:13:02 CST 2014
     */
    public void setAppType(String appType) {
        this.appType = appType == null ? null : appType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_app_summary.ENTER_TIME
     *
     * @return the value of ml_app_summary.ENTER_TIME
     *
     * @mbggenerated Wed Oct 15 14:13:02 CST 2014
     */
    public Date getEnterTime() {
        return enterTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_app_summary.ENTER_TIME
     *
     * @param enterTime the value for ml_app_summary.ENTER_TIME
     *
     * @mbggenerated Wed Oct 15 14:13:02 CST 2014
     */
    public void setEnterTime(Date enterTime) {
        this.enterTime = enterTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_app_summary.PREVIOUS_STEP
     *
     * @return the value of ml_app_summary.PREVIOUS_STEP
     *
     * @mbggenerated Wed Oct 15 14:13:02 CST 2014
     */
    public String getPreviousStep() {
        return previousStep;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_app_summary.PREVIOUS_STEP
     *
     * @param previousStep the value for ml_app_summary.PREVIOUS_STEP
     *
     * @mbggenerated Wed Oct 15 14:13:02 CST 2014
     */
    public void setPreviousStep(String previousStep) {
        this.previousStep = previousStep == null ? null : previousStep.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_app_summary.CURR_STEP
     *
     * @return the value of ml_app_summary.CURR_STEP
     *
     * @mbggenerated Wed Oct 15 14:13:02 CST 2014
     */
    public String getCurrStep() {
        return currStep;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_app_summary.CURR_STEP
     *
     * @param currStep the value for ml_app_summary.CURR_STEP
     *
     * @mbggenerated Wed Oct 15 14:13:02 CST 2014
     */
    public void setCurrStep(String currStep) {
        this.currStep = currStep == null ? null : currStep.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_app_summary.NEXT_STEP
     *
     * @return the value of ml_app_summary.NEXT_STEP
     *
     * @mbggenerated Wed Oct 15 14:13:02 CST 2014
     */
    public String getNextStep() {
        return nextStep;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_app_summary.NEXT_STEP
     *
     * @param nextStep the value for ml_app_summary.NEXT_STEP
     *
     * @mbggenerated Wed Oct 15 14:13:02 CST 2014
     */
    public void setNextStep(String nextStep) {
        this.nextStep = nextStep == null ? null : nextStep.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_app_summary.STATUS
     *
     * @return the value of ml_app_summary.STATUS
     *
     * @mbggenerated Wed Oct 15 14:13:02 CST 2014
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_app_summary.STATUS
     *
     * @param status the value for ml_app_summary.STATUS
     *
     * @mbggenerated Wed Oct 15 14:13:02 CST 2014
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_app_summary.HANDLER
     *
     * @return the value of ml_app_summary.HANDLER
     *
     * @mbggenerated Wed Oct 15 14:13:02 CST 2014
     */
    public Long getHandler() {
        return handler;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_app_summary.HANDLER
     *
     * @param handler the value for ml_app_summary.HANDLER
     *
     * @mbggenerated Wed Oct 15 14:13:02 CST 2014
     */
    public void setHandler(Long handler) {
        this.handler = handler;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_app_summary.FINISH_TIME
     *
     * @return the value of ml_app_summary.FINISH_TIME
     *
     * @mbggenerated Wed Oct 15 14:13:02 CST 2014
     */
    public Date getFinishTime() {
        return finishTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_app_summary.FINISH_TIME
     *
     * @param finishTime the value for ml_app_summary.FINISH_TIME
     *
     * @mbggenerated Wed Oct 15 14:13:02 CST 2014
     */
    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_app_summary.DEAL_RESULT
     *
     * @return the value of ml_app_summary.DEAL_RESULT
     *
     * @mbggenerated Wed Oct 15 14:13:02 CST 2014
     */
    public String getDealResult() {
        return dealResult;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_app_summary.DEAL_RESULT
     *
     * @param dealResult the value for ml_app_summary.DEAL_RESULT
     *
     * @mbggenerated Wed Oct 15 14:13:02 CST 2014
     */
    public void setDealResult(String dealResult) {
        this.dealResult = dealResult == null ? null : dealResult.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_app_summary.DEAL_DESC
     *
     * @return the value of ml_app_summary.DEAL_DESC
     *
     * @mbggenerated Wed Oct 15 14:13:02 CST 2014
     */
    public String getDealDesc() {
        return dealDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_app_summary.DEAL_DESC
     *
     * @param dealDesc the value for ml_app_summary.DEAL_DESC
     *
     * @mbggenerated Wed Oct 15 14:13:02 CST 2014
     */
    public void setDealDesc(String dealDesc) {
        this.dealDesc = dealDesc == null ? null : dealDesc.trim();
    }
}