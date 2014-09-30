package com.wealth.miniloan.entity;

public class MlNaturalAttach extends MlNaturalAttachKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_natural_attach.FILE_NAME
     *
     * @mbggenerated Sat Sep 27 17:30:29 CST 2014
     */
    private String fileName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_natural_attach.FILE_DESC
     *
     * @mbggenerated Sat Sep 27 17:30:29 CST 2014
     */
    private String fileDesc;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_natural_attach.PHYSICAL_NAME
     *
     * @mbggenerated Sat Sep 27 17:30:29 CST 2014
     */
    private String physicalName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ml_natural_attach.FILE_TYPE
     *
     * @mbggenerated Sat Sep 27 17:30:29 CST 2014
     */
    private String fileType;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_natural_attach.FILE_NAME
     *
     * @return the value of ml_natural_attach.FILE_NAME
     *
     * @mbggenerated Sat Sep 27 17:30:29 CST 2014
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_natural_attach.FILE_NAME
     *
     * @param fileName the value for ml_natural_attach.FILE_NAME
     *
     * @mbggenerated Sat Sep 27 17:30:29 CST 2014
     */
    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_natural_attach.FILE_DESC
     *
     * @return the value of ml_natural_attach.FILE_DESC
     *
     * @mbggenerated Sat Sep 27 17:30:29 CST 2014
     */
    public String getFileDesc() {
        return fileDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_natural_attach.FILE_DESC
     *
     * @param fileDesc the value for ml_natural_attach.FILE_DESC
     *
     * @mbggenerated Sat Sep 27 17:30:29 CST 2014
     */
    public void setFileDesc(String fileDesc) {
        this.fileDesc = fileDesc == null ? null : fileDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_natural_attach.PHYSICAL_NAME
     *
     * @return the value of ml_natural_attach.PHYSICAL_NAME
     *
     * @mbggenerated Sat Sep 27 17:30:29 CST 2014
     */
    public String getPhysicalName() {
        return physicalName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_natural_attach.PHYSICAL_NAME
     *
     * @param physicalName the value for ml_natural_attach.PHYSICAL_NAME
     *
     * @mbggenerated Sat Sep 27 17:30:29 CST 2014
     */
    public void setPhysicalName(String physicalName) {
        this.physicalName = physicalName == null ? null : physicalName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ml_natural_attach.FILE_TYPE
     *
     * @return the value of ml_natural_attach.FILE_TYPE
     *
     * @mbggenerated Sat Sep 27 17:30:29 CST 2014
     */
    public String getFileType() {
        return fileType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ml_natural_attach.FILE_TYPE
     *
     * @param fileType the value for ml_natural_attach.FILE_TYPE
     *
     * @mbggenerated Sat Sep 27 17:30:29 CST 2014
     */
    public void setFileType(String fileType) {
        this.fileType = fileType == null ? null : fileType.trim();
    }
}