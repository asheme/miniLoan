package com.wealth.miniloan.entity;

public class MlInteCheckInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_inte_check_info.APP_NO
     *
     * @mbggenerated Mon Oct 20 11:49:45 CST 2014
     */
    private String appNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_inte_check_info.ITEM_ID
     *
     * @mbggenerated Mon Oct 20 11:49:45 CST 2014
     */
    private Long itemId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_inte_check_info.ITEM_NAME
     *
     * @mbggenerated Mon Oct 20 11:49:45 CST 2014
     */
    private String itemName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_inte_check_info.RESULT
     *
     * @mbggenerated Mon Oct 20 11:49:45 CST 2014
     */
    private String result;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_inte_check_info.APP_NO
     *
     * @return the value of ml_inte_check_info.APP_NO
     *
     * @mbggenerated Mon Oct 20 11:49:45 CST 2014
     */
    public String getAppNo() {
        return appNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_inte_check_info.APP_NO
     *
     * @param appNo the value for ml_inte_check_info.APP_NO
     *
     * @mbggenerated Mon Oct 20 11:49:45 CST 2014
     */
    public void setAppNo(String appNo) {
        this.appNo = appNo == null ? null : appNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_inte_check_info.ITEM_ID
     *
     * @return the value of ml_inte_check_info.ITEM_ID
     *
     * @mbggenerated Mon Oct 20 11:49:45 CST 2014
     */
    public Long getItemId() {
        return itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_inte_check_info.ITEM_ID
     *
     * @param itemId the value for ml_inte_check_info.ITEM_ID
     *
     * @mbggenerated Mon Oct 20 11:49:45 CST 2014
     */
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_inte_check_info.ITEM_NAME
     *
     * @return the value of ml_inte_check_info.ITEM_NAME
     *
     * @mbggenerated Mon Oct 20 11:49:45 CST 2014
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_inte_check_info.ITEM_NAME
     *
     * @param itemName the value for ml_inte_check_info.ITEM_NAME
     *
     * @mbggenerated Mon Oct 20 11:49:45 CST 2014
     */
    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_inte_check_info.RESULT
     *
     * @return the value of ml_inte_check_info.RESULT
     *
     * @mbggenerated Mon Oct 20 11:49:45 CST 2014
     */
    public String getResult() {
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_inte_check_info.RESULT
     *
     * @param result the value for ml_inte_check_info.RESULT
     *
     * @mbggenerated Mon Oct 20 11:49:45 CST 2014
     */
    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }
}