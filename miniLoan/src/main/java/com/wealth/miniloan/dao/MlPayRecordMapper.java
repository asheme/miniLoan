package com.wealth.miniloan.dao;

import com.wealth.miniloan.entity.MlPayRecord;
import com.wealth.miniloan.entity.MlPayRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MlPayRecordMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_pay_record
     *
     * @mbggenerated Wed Oct 29 21:10:43 GMT+08:00 2014
     */
    int countByExample(MlPayRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_pay_record
     *
     * @mbggenerated Wed Oct 29 21:10:43 GMT+08:00 2014
     */
    int deleteByExample(MlPayRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_pay_record
     *
     * @mbggenerated Wed Oct 29 21:10:43 GMT+08:00 2014
     */
    int insert(MlPayRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_pay_record
     *
     * @mbggenerated Wed Oct 29 21:10:43 GMT+08:00 2014
     */
    int insertSelective(MlPayRecord record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_pay_record
     *
     * @mbggenerated Wed Oct 29 21:10:43 GMT+08:00 2014
     */
    List<MlPayRecord> selectByExample(MlPayRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_pay_record
     *
     * @mbggenerated Wed Oct 29 21:10:43 GMT+08:00 2014
     */
    int updateByExampleSelective(@Param("record") MlPayRecord record, @Param("example") MlPayRecordExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_pay_record
     *
     * @mbggenerated Wed Oct 29 21:10:43 GMT+08:00 2014
     */
    int updateByExample(@Param("record") MlPayRecord record, @Param("example") MlPayRecordExample example);
}