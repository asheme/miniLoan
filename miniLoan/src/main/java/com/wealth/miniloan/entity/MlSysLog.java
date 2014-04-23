package com.wealth.miniloan.entity;

import java.util.Date;

public class MlSysLog {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_sys_log.LOG_ID
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    private Long logId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_sys_log.ORG_NO
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    private String orgNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_sys_log.MODULE
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    private String module;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_sys_log.CONTENT
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_sys_log.OPER_ID
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    private Long operId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_sys_log.OP_DATE
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    private Date opDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_sys_log.LOG_ID
     *
     * @return the value of ml_sys_log.LOG_ID
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public Long getLogId() {
        return logId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_sys_log.LOG_ID
     *
     * @param logId the value for ml_sys_log.LOG_ID
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public void setLogId(Long logId) {
        this.logId = logId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_sys_log.ORG_NO
     *
     * @return the value of ml_sys_log.ORG_NO
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public String getOrgNo() {
        return orgNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_sys_log.ORG_NO
     *
     * @param orgNo the value for ml_sys_log.ORG_NO
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public void setOrgNo(String orgNo) {
        this.orgNo = orgNo == null ? null : orgNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_sys_log.MODULE
     *
     * @return the value of ml_sys_log.MODULE
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public String getModule() {
        return module;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_sys_log.MODULE
     *
     * @param module the value for ml_sys_log.MODULE
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public void setModule(String module) {
        this.module = module == null ? null : module.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_sys_log.CONTENT
     *
     * @return the value of ml_sys_log.CONTENT
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_sys_log.CONTENT
     *
     * @param content the value for ml_sys_log.CONTENT
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_sys_log.OPER_ID
     *
     * @return the value of ml_sys_log.OPER_ID
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public Long getOperId() {
        return operId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_sys_log.OPER_ID
     *
     * @param operId the value for ml_sys_log.OPER_ID
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public void setOperId(Long operId) {
        this.operId = operId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_sys_log.OP_DATE
     *
     * @return the value of ml_sys_log.OP_DATE
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public Date getOpDate() {
        return opDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_sys_log.OP_DATE
     *
     * @param opDate the value for ml_sys_log.OP_DATE
     *
     * @mbggenerated Sat Mar 29 20:40:29 GMT+08:00 2014
     */
    public void setOpDate(Date opDate) {
        this.opDate = opDate;
    }
}