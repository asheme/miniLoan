package com.wealth.miniloan.entity;

import java.math.BigDecimal;
import java.util.Date;

public class CorpAppInfo extends MlCorpApp {
	private String appType;
	private Integer currApproveLvl;
	private Date enterTime;
	private String previousStep;
	private String currStep;
	private String nextStep;
	private String status;
	private Long handler;
	private Date finishTime;
	private String manualResult;
	private BigDecimal loanLimit;
	private BigDecimal loanRate;
	private String reasonCode;
	private String reasonDesc;
	private Long currUser;
	private Date operTime;

	public String getAppType() {
		return appType;
	}

	public void setAppType(String appType) {
		this.appType = appType;
	}

	public Integer getCurrApproveLvl() {
		return currApproveLvl;
	}

	public void setCurrApproveLvl(Integer currApproveLvl) {
		this.currApproveLvl = currApproveLvl;
	}

	public Date getEnterTime() {
		return enterTime;
	}

	public void setEnterTime(Date enterTime) {
		this.enterTime = enterTime;
	}

	public String getPreviousStep() {
		return previousStep;
	}

	public void setPreviousStep(String previousStep) {
		this.previousStep = previousStep;
	}

	public String getCurrStep() {
		return currStep;
	}

	public void setCurrStep(String currStep) {
		this.currStep = currStep;
	}

	public String getNextStep() {
		return nextStep;
	}

	public void setNextStep(String nextStep) {
		this.nextStep = nextStep;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getHandler() {
		return handler;
	}

	public void setHandler(Long handler) {
		this.handler = handler;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public String getManualResult() {
		return manualResult;
	}

	public void setManualResult(String manualResult) {
		this.manualResult = manualResult;
	}

	public BigDecimal getLoanLimit() {
		return loanLimit;
	}

	public void setLoanLimit(BigDecimal loanLimit) {
		this.loanLimit = loanLimit;
	}

	public BigDecimal getLoanRate() {
		return loanRate;
	}

	public void setLoanRate(BigDecimal loanRate) {
		this.loanRate = loanRate;
	}

	public String getReasonCode() {
		return reasonCode;
	}

	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	public String getReasonDesc() {
		return reasonDesc;
	}

	public void setReasonDesc(String reasonDesc) {
		this.reasonDesc = reasonDesc;
	}

	public Long getCurrUser() {
		return currUser;
	}

	public void setCurrUser(Long currUser) {
		this.currUser = currUser;
	}

	public Date getOperTime() {
		return operTime;
	}

	public void setOperTime(Date operTime) {
		this.operTime = operTime;
	}

}
