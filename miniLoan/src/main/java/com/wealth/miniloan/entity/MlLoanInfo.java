package com.wealth.miniloan.entity;

import java.math.BigDecimal;
import java.util.Date;

public class MlLoanInfo {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ml_loan_info.LOAN_ID
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	private Long loanId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ml_loan_info.CUST_NO
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	private String custNo;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ml_loan_info.APP_NO
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	private String appNo;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ml_loan_info.LOAN_CONTRACT_NO
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	private String loanContractNo;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ml_loan_info.LOAN_AMOUNT
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	private BigDecimal loanAmount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ml_loan_info.LOAN_CYCLE
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	private Integer loanCycle;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ml_loan_info.LOAN_RATE
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	private BigDecimal loanRate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ml_loan_info.OFFER_METHOD
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	private String offerMethod;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ml_loan_info.PAY_METHOD
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	private String payMethod;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ml_loan_info.INTEREST_PENALTY
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	private BigDecimal interestPenalty;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ml_loan_info.OVERDUE_FINE
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	private BigDecimal overdueFine;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ml_loan_info.LOAN_INTEREST
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	private BigDecimal loanInterest;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ml_loan_info.OFFER_LOAN
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	private BigDecimal offerLoan;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ml_loan_info.PAY_AMOUNT
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	private BigDecimal payAmount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ml_loan_info.REMAIN_AMOUNT
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	private BigDecimal remainAmount;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ml_loan_info.LOAN_START_TIME
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	private Date loanStartTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ml_loan_info.LOAN_FINISH_TIME
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	private Date loanFinishTime;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ml_loan_info.CONTRACT_FILE
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	private String contractFile;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ml_loan_info.CURR_DELINQUENCY
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	private Integer currDelinquency;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ml_loan_info.STATUS
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	private String status;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ml_loan_info.OPER
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	private Long oper;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column ml_loan_info.OPER_TIME
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	private Date operTime;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ml_loan_info.LOAN_ID
	 * @return  the value of ml_loan_info.LOAN_ID
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public Long getLoanId() {
		return loanId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ml_loan_info.LOAN_ID
	 * @param loanId  the value for ml_loan_info.LOAN_ID
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ml_loan_info.CUST_NO
	 * @return  the value of ml_loan_info.CUST_NO
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public String getCustNo() {
		return custNo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ml_loan_info.CUST_NO
	 * @param custNo  the value for ml_loan_info.CUST_NO
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public void setCustNo(String custNo) {
		this.custNo = custNo == null ? null : custNo.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ml_loan_info.APP_NO
	 * @return  the value of ml_loan_info.APP_NO
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public String getAppNo() {
		return appNo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ml_loan_info.APP_NO
	 * @param appNo  the value for ml_loan_info.APP_NO
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public void setAppNo(String appNo) {
		this.appNo = appNo == null ? null : appNo.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ml_loan_info.LOAN_CONTRACT_NO
	 * @return  the value of ml_loan_info.LOAN_CONTRACT_NO
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public String getLoanContractNo() {
		return loanContractNo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ml_loan_info.LOAN_CONTRACT_NO
	 * @param loanContractNo  the value for ml_loan_info.LOAN_CONTRACT_NO
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public void setLoanContractNo(String loanContractNo) {
		this.loanContractNo = loanContractNo == null ? null : loanContractNo
				.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ml_loan_info.LOAN_AMOUNT
	 * @return  the value of ml_loan_info.LOAN_AMOUNT
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public BigDecimal getLoanAmount() {
		return loanAmount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ml_loan_info.LOAN_AMOUNT
	 * @param loanAmount  the value for ml_loan_info.LOAN_AMOUNT
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ml_loan_info.LOAN_CYCLE
	 * @return  the value of ml_loan_info.LOAN_CYCLE
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public Integer getLoanCycle() {
		return loanCycle;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ml_loan_info.LOAN_CYCLE
	 * @param loanCycle  the value for ml_loan_info.LOAN_CYCLE
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public void setLoanCycle(Integer loanCycle) {
		this.loanCycle = loanCycle;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ml_loan_info.LOAN_RATE
	 * @return  the value of ml_loan_info.LOAN_RATE
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public BigDecimal getLoanRate() {
		return loanRate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ml_loan_info.LOAN_RATE
	 * @param loanRate  the value for ml_loan_info.LOAN_RATE
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public void setLoanRate(BigDecimal loanRate) {
		this.loanRate = loanRate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ml_loan_info.OFFER_METHOD
	 * @return  the value of ml_loan_info.OFFER_METHOD
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public String getOfferMethod() {
		return offerMethod;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ml_loan_info.OFFER_METHOD
	 * @param offerMethod  the value for ml_loan_info.OFFER_METHOD
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public void setOfferMethod(String offerMethod) {
		this.offerMethod = offerMethod == null ? null : offerMethod.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ml_loan_info.PAY_METHOD
	 * @return  the value of ml_loan_info.PAY_METHOD
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public String getPayMethod() {
		return payMethod;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ml_loan_info.PAY_METHOD
	 * @param payMethod  the value for ml_loan_info.PAY_METHOD
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod == null ? null : payMethod.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ml_loan_info.INTEREST_PENALTY
	 * @return  the value of ml_loan_info.INTEREST_PENALTY
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public BigDecimal getInterestPenalty() {
		return interestPenalty;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ml_loan_info.INTEREST_PENALTY
	 * @param interestPenalty  the value for ml_loan_info.INTEREST_PENALTY
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public void setInterestPenalty(BigDecimal interestPenalty) {
		this.interestPenalty = interestPenalty;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ml_loan_info.OVERDUE_FINE
	 * @return  the value of ml_loan_info.OVERDUE_FINE
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public BigDecimal getOverdueFine() {
		return overdueFine;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ml_loan_info.OVERDUE_FINE
	 * @param overdueFine  the value for ml_loan_info.OVERDUE_FINE
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public void setOverdueFine(BigDecimal overdueFine) {
		this.overdueFine = overdueFine;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ml_loan_info.LOAN_INTEREST
	 * @return  the value of ml_loan_info.LOAN_INTEREST
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public BigDecimal getLoanInterest() {
		return loanInterest;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ml_loan_info.LOAN_INTEREST
	 * @param loanInterest  the value for ml_loan_info.LOAN_INTEREST
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public void setLoanInterest(BigDecimal loanInterest) {
		this.loanInterest = loanInterest;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ml_loan_info.OFFER_LOAN
	 * @return  the value of ml_loan_info.OFFER_LOAN
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public BigDecimal getOfferLoan() {
		return offerLoan;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ml_loan_info.OFFER_LOAN
	 * @param offerLoan  the value for ml_loan_info.OFFER_LOAN
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public void setOfferLoan(BigDecimal offerLoan) {
		this.offerLoan = offerLoan;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ml_loan_info.PAY_AMOUNT
	 * @return  the value of ml_loan_info.PAY_AMOUNT
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public BigDecimal getPayAmount() {
		return payAmount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ml_loan_info.PAY_AMOUNT
	 * @param payAmount  the value for ml_loan_info.PAY_AMOUNT
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ml_loan_info.REMAIN_AMOUNT
	 * @return  the value of ml_loan_info.REMAIN_AMOUNT
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public BigDecimal getRemainAmount() {
		return remainAmount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ml_loan_info.REMAIN_AMOUNT
	 * @param remainAmount  the value for ml_loan_info.REMAIN_AMOUNT
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public void setRemainAmount(BigDecimal remainAmount) {
		this.remainAmount = remainAmount;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ml_loan_info.LOAN_START_TIME
	 * @return  the value of ml_loan_info.LOAN_START_TIME
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public Date getLoanStartTime() {
		return loanStartTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ml_loan_info.LOAN_START_TIME
	 * @param loanStartTime  the value for ml_loan_info.LOAN_START_TIME
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public void setLoanStartTime(Date loanStartTime) {
		this.loanStartTime = loanStartTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ml_loan_info.LOAN_FINISH_TIME
	 * @return  the value of ml_loan_info.LOAN_FINISH_TIME
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public Date getLoanFinishTime() {
		return loanFinishTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ml_loan_info.LOAN_FINISH_TIME
	 * @param loanFinishTime  the value for ml_loan_info.LOAN_FINISH_TIME
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public void setLoanFinishTime(Date loanFinishTime) {
		this.loanFinishTime = loanFinishTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ml_loan_info.CONTRACT_FILE
	 * @return  the value of ml_loan_info.CONTRACT_FILE
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public String getContractFile() {
		return contractFile;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ml_loan_info.CONTRACT_FILE
	 * @param contractFile  the value for ml_loan_info.CONTRACT_FILE
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public void setContractFile(String contractFile) {
		this.contractFile = contractFile == null ? null : contractFile.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ml_loan_info.CURR_DELINQUENCY
	 * @return  the value of ml_loan_info.CURR_DELINQUENCY
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public Integer getCurrDelinquency() {
		return currDelinquency;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ml_loan_info.CURR_DELINQUENCY
	 * @param currDelinquency  the value for ml_loan_info.CURR_DELINQUENCY
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public void setCurrDelinquency(Integer currDelinquency) {
		this.currDelinquency = currDelinquency;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ml_loan_info.STATUS
	 * @return  the value of ml_loan_info.STATUS
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ml_loan_info.STATUS
	 * @param status  the value for ml_loan_info.STATUS
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public void setStatus(String status) {
		this.status = status == null ? null : status.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ml_loan_info.OPER
	 * @return  the value of ml_loan_info.OPER
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public Long getOper() {
		return oper;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ml_loan_info.OPER
	 * @param oper  the value for ml_loan_info.OPER
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public void setOper(Long oper) {
		this.oper = oper;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column ml_loan_info.OPER_TIME
	 * @return  the value of ml_loan_info.OPER_TIME
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public Date getOperTime() {
		return operTime;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column ml_loan_info.OPER_TIME
	 * @param operTime  the value for ml_loan_info.OPER_TIME
	 * @mbggenerated  Thu Oct 30 21:06:25 GMT+08:00 2014
	 */
	public void setOperTime(Date operTime) {
		this.operTime = operTime;
	}
}