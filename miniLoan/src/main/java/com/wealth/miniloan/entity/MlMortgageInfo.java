package com.wealth.miniloan.entity;

import java.math.BigDecimal;
import java.util.Date;

public class MlMortgageInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_mortgage_info.MORTGAGE_ID
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    private Long mortgageId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_mortgage_info.APP_NO
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    private String appNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_mortgage_info.MORTGAGOR
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    private String mortgagor;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_mortgage_info.MORTGAGOR_ID_TYPE
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    private String mortgagorIdType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_mortgage_info.MORTGAGOR_ID_NO
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    private String mortgagorIdNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_mortgage_info.MORTGAGOR_PHONE
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    private String mortgagorPhone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_mortgage_info.LEGAL_PERSON
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    private String legalPerson;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_mortgage_info.MORTGAGE_ADDR
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    private String mortgageAddr;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_mortgage_info.MORTGAGE_NAME
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    private String mortgageName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_mortgage_info.CERTIFICATION_NO
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    private String certificationNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_mortgage_info.MORTGAGE_LOCATION
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    private String mortgageLocation;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_mortgage_info.MORTGAGE_AREA
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    private BigDecimal mortgageArea;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_mortgage_info.BUY_DATE
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    private Date buyDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_mortgage_info.OLD_VALUE
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    private BigDecimal oldValue;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_mortgage_info.CURR_VALUE
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    private BigDecimal currValue;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_mortgage_info.STATUS
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    private String status;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_mortgage_info.MORTGAGE_ID
     *
     * @return the value of ml_mortgage_info.MORTGAGE_ID
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    public Long getMortgageId() {
        return mortgageId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_mortgage_info.MORTGAGE_ID
     *
     * @param mortgageId the value for ml_mortgage_info.MORTGAGE_ID
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    public void setMortgageId(Long mortgageId) {
        this.mortgageId = mortgageId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_mortgage_info.APP_NO
     *
     * @return the value of ml_mortgage_info.APP_NO
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    public String getAppNo() {
        return appNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_mortgage_info.APP_NO
     *
     * @param appNo the value for ml_mortgage_info.APP_NO
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    public void setAppNo(String appNo) {
        this.appNo = appNo == null ? null : appNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_mortgage_info.MORTGAGOR
     *
     * @return the value of ml_mortgage_info.MORTGAGOR
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    public String getMortgagor() {
        return mortgagor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_mortgage_info.MORTGAGOR
     *
     * @param mortgagor the value for ml_mortgage_info.MORTGAGOR
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    public void setMortgagor(String mortgagor) {
        this.mortgagor = mortgagor == null ? null : mortgagor.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_mortgage_info.MORTGAGOR_ID_TYPE
     *
     * @return the value of ml_mortgage_info.MORTGAGOR_ID_TYPE
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    public String getMortgagorIdType() {
        return mortgagorIdType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_mortgage_info.MORTGAGOR_ID_TYPE
     *
     * @param mortgagorIdType the value for ml_mortgage_info.MORTGAGOR_ID_TYPE
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    public void setMortgagorIdType(String mortgagorIdType) {
        this.mortgagorIdType = mortgagorIdType == null ? null : mortgagorIdType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_mortgage_info.MORTGAGOR_ID_NO
     *
     * @return the value of ml_mortgage_info.MORTGAGOR_ID_NO
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    public String getMortgagorIdNo() {
        return mortgagorIdNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_mortgage_info.MORTGAGOR_ID_NO
     *
     * @param mortgagorIdNo the value for ml_mortgage_info.MORTGAGOR_ID_NO
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    public void setMortgagorIdNo(String mortgagorIdNo) {
        this.mortgagorIdNo = mortgagorIdNo == null ? null : mortgagorIdNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_mortgage_info.MORTGAGOR_PHONE
     *
     * @return the value of ml_mortgage_info.MORTGAGOR_PHONE
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    public String getMortgagorPhone() {
        return mortgagorPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_mortgage_info.MORTGAGOR_PHONE
     *
     * @param mortgagorPhone the value for ml_mortgage_info.MORTGAGOR_PHONE
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    public void setMortgagorPhone(String mortgagorPhone) {
        this.mortgagorPhone = mortgagorPhone == null ? null : mortgagorPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_mortgage_info.LEGAL_PERSON
     *
     * @return the value of ml_mortgage_info.LEGAL_PERSON
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    public String getLegalPerson() {
        return legalPerson;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_mortgage_info.LEGAL_PERSON
     *
     * @param legalPerson the value for ml_mortgage_info.LEGAL_PERSON
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson == null ? null : legalPerson.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_mortgage_info.MORTGAGE_ADDR
     *
     * @return the value of ml_mortgage_info.MORTGAGE_ADDR
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    public String getMortgageAddr() {
        return mortgageAddr;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_mortgage_info.MORTGAGE_ADDR
     *
     * @param mortgageAddr the value for ml_mortgage_info.MORTGAGE_ADDR
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    public void setMortgageAddr(String mortgageAddr) {
        this.mortgageAddr = mortgageAddr == null ? null : mortgageAddr.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_mortgage_info.MORTGAGE_NAME
     *
     * @return the value of ml_mortgage_info.MORTGAGE_NAME
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    public String getMortgageName() {
        return mortgageName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_mortgage_info.MORTGAGE_NAME
     *
     * @param mortgageName the value for ml_mortgage_info.MORTGAGE_NAME
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    public void setMortgageName(String mortgageName) {
        this.mortgageName = mortgageName == null ? null : mortgageName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_mortgage_info.CERTIFICATION_NO
     *
     * @return the value of ml_mortgage_info.CERTIFICATION_NO
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    public String getCertificationNo() {
        return certificationNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_mortgage_info.CERTIFICATION_NO
     *
     * @param certificationNo the value for ml_mortgage_info.CERTIFICATION_NO
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    public void setCertificationNo(String certificationNo) {
        this.certificationNo = certificationNo == null ? null : certificationNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_mortgage_info.MORTGAGE_LOCATION
     *
     * @return the value of ml_mortgage_info.MORTGAGE_LOCATION
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    public String getMortgageLocation() {
        return mortgageLocation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_mortgage_info.MORTGAGE_LOCATION
     *
     * @param mortgageLocation the value for ml_mortgage_info.MORTGAGE_LOCATION
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    public void setMortgageLocation(String mortgageLocation) {
        this.mortgageLocation = mortgageLocation == null ? null : mortgageLocation.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_mortgage_info.MORTGAGE_AREA
     *
     * @return the value of ml_mortgage_info.MORTGAGE_AREA
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    public BigDecimal getMortgageArea() {
        return mortgageArea;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_mortgage_info.MORTGAGE_AREA
     *
     * @param mortgageArea the value for ml_mortgage_info.MORTGAGE_AREA
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    public void setMortgageArea(BigDecimal mortgageArea) {
        this.mortgageArea = mortgageArea;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_mortgage_info.BUY_DATE
     *
     * @return the value of ml_mortgage_info.BUY_DATE
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    public Date getBuyDate() {
        return buyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_mortgage_info.BUY_DATE
     *
     * @param buyDate the value for ml_mortgage_info.BUY_DATE
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_mortgage_info.OLD_VALUE
     *
     * @return the value of ml_mortgage_info.OLD_VALUE
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    public BigDecimal getOldValue() {
        return oldValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_mortgage_info.OLD_VALUE
     *
     * @param oldValue the value for ml_mortgage_info.OLD_VALUE
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    public void setOldValue(BigDecimal oldValue) {
        this.oldValue = oldValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_mortgage_info.CURR_VALUE
     *
     * @return the value of ml_mortgage_info.CURR_VALUE
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    public BigDecimal getCurrValue() {
        return currValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_mortgage_info.CURR_VALUE
     *
     * @param currValue the value for ml_mortgage_info.CURR_VALUE
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    public void setCurrValue(BigDecimal currValue) {
        this.currValue = currValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_mortgage_info.STATUS
     *
     * @return the value of ml_mortgage_info.STATUS
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_mortgage_info.STATUS
     *
     * @param status the value for ml_mortgage_info.STATUS
     *
     * @mbggenerated Wed Oct 15 20:04:28 GMT+08:00 2014
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}