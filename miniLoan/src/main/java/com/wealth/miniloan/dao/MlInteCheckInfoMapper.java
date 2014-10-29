package com.wealth.miniloan.dao;

import com.wealth.miniloan.entity.MlInteCheckInfo;
import com.wealth.miniloan.entity.MlInteCheckInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MlInteCheckInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_inte_check_info
     *
     * @mbggenerated Mon Oct 20 11:49:45 CST 2014
     */
    int countByExample(MlInteCheckInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_inte_check_info
     *
     * @mbggenerated Mon Oct 20 11:49:45 CST 2014
     */
    int deleteByExample(MlInteCheckInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_inte_check_info
     *
     * @mbggenerated Mon Oct 20 11:49:45 CST 2014
     */
    int deleteByPrimaryKey(String appNo);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_inte_check_info
     *
     * @mbggenerated Mon Oct 20 11:49:45 CST 2014
     */
    int insert(MlInteCheckInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_inte_check_info
     *
     * @mbggenerated Mon Oct 20 11:49:45 CST 2014
     */
    int insertSelective(MlInteCheckInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_inte_check_info
     *
     * @mbggenerated Mon Oct 20 11:49:45 CST 2014
     */
    List<MlInteCheckInfo> selectByExample(MlInteCheckInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_inte_check_info
     *
     * @mbggenerated Mon Oct 20 11:49:45 CST 2014
     */
    MlInteCheckInfo selectByPrimaryKey(String appNo);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_inte_check_info
     *
     * @mbggenerated Mon Oct 20 11:49:45 CST 2014
     */
    int updateByExampleSelective(@Param("record") MlInteCheckInfo record, @Param("example") MlInteCheckInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_inte_check_info
     *
     * @mbggenerated Mon Oct 20 11:49:45 CST 2014
     */
    int updateByExample(@Param("record") MlInteCheckInfo record, @Param("example") MlInteCheckInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_inte_check_info
     *
     * @mbggenerated Mon Oct 20 11:49:45 CST 2014
     */
    int updateByPrimaryKeySelective(MlInteCheckInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_inte_check_info
     *
     * @mbggenerated Mon Oct 20 11:49:45 CST 2014
     */
    int updateByPrimaryKey(MlInteCheckInfo record);
}