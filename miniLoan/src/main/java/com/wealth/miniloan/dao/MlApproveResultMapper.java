package com.wealth.miniloan.dao;

import com.wealth.miniloan.entity.MlApproveResult;
import com.wealth.miniloan.entity.MlApproveResultExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MlApproveResultMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_approve_result
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    int countByExample(MlApproveResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_approve_result
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    int deleteByExample(MlApproveResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_approve_result
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    int deleteByPrimaryKey(String appNo);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_approve_result
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    int insert(MlApproveResult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_approve_result
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    int insertSelective(MlApproveResult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_approve_result
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    List<MlApproveResult> selectByExampleWithBLOBs(MlApproveResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_approve_result
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    List<MlApproveResult> selectByExample(MlApproveResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_approve_result
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    MlApproveResult selectByPrimaryKey(String appNo);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_approve_result
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    int updateByExampleSelective(@Param("record") MlApproveResult record, @Param("example") MlApproveResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_approve_result
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    int updateByExampleWithBLOBs(@Param("record") MlApproveResult record, @Param("example") MlApproveResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_approve_result
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    int updateByExample(@Param("record") MlApproveResult record, @Param("example") MlApproveResultExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_approve_result
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    int updateByPrimaryKeySelective(MlApproveResult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_approve_result
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    int updateByPrimaryKeyWithBLOBs(MlApproveResult record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_approve_result
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    int updateByPrimaryKey(MlApproveResult record);
}