package com.wealth.miniloan.entity;

public class MlCorpAttachKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_corp_attach.APP_NO
     *
     * @mbggenerated Sat Sep 27 17:34:13 CST 2014
     */
    private String appNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_corp_attach.FILE_NO
     *
     * @mbggenerated Sat Sep 27 17:34:13 CST 2014
     */
    private Long fileNo;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_corp_attach.APP_NO
     *
     * @return the value of ml_corp_attach.APP_NO
     *
     * @mbggenerated Sat Sep 27 17:34:13 CST 2014
     */
    public String getAppNo() {
        return appNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_corp_attach.APP_NO
     *
     * @param appNo the value for ml_corp_attach.APP_NO
     *
     * @mbggenerated Sat Sep 27 17:34:13 CST 2014
     */
    public void setAppNo(String appNo) {
        this.appNo = appNo == null ? null : appNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_corp_attach.FILE_NO
     *
     * @return the value of ml_corp_attach.FILE_NO
     *
     * @mbggenerated Sat Sep 27 17:34:13 CST 2014
     */
    public Long getFileNo() {
        return fileNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_corp_attach.FILE_NO
     *
     * @param fileNo the value for ml_corp_attach.FILE_NO
     *
     * @mbggenerated Sat Sep 27 17:34:13 CST 2014
     */
    public void setFileNo(Long fileNo) {
        this.fileNo = fileNo;
    }
}