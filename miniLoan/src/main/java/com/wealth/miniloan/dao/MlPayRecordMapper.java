package com.wealth.miniloan.dao;

import com.wealth.miniloan.entity.MlPayRecord;
import com.wealth.miniloan.entity.MlPayRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MlPayRecordMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_pay_record
	 * @mbggenerated  Sat Nov 01 17:05:46 CST 2014
	 */
	int countByExample(MlPayRecordExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_pay_record
	 * @mbggenerated  Sat Nov 01 17:05:46 CST 2014
	 */
	int deleteByExample(MlPayRecordExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_pay_record
	 * @mbggenerated  Sat Nov 01 17:05:46 CST 2014
	 */
	int deleteByPrimaryKey(Long recordId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_pay_record
	 * @mbggenerated  Sat Nov 01 17:05:46 CST 2014
	 */
	int insert(MlPayRecord record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_pay_record
	 * @mbggenerated  Sat Nov 01 17:05:46 CST 2014
	 */
	int insertSelective(MlPayRecord record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_pay_record
	 * @mbggenerated  Sat Nov 01 17:05:46 CST 2014
	 */
	List<MlPayRecord> selectByExample(MlPayRecordExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_pay_record
	 * @mbggenerated  Sat Nov 01 17:05:46 CST 2014
	 */
	MlPayRecord selectByPrimaryKey(Long recordId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_pay_record
	 * @mbggenerated  Sat Nov 01 17:05:46 CST 2014
	 */
	int updateByExampleSelective(@Param("record") MlPayRecord record, @Param("example") MlPayRecordExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_pay_record
	 * @mbggenerated  Sat Nov 01 17:05:46 CST 2014
	 */
	int updateByExample(@Param("record") MlPayRecord record, @Param("example") MlPayRecordExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_pay_record
	 * @mbggenerated  Sat Nov 01 17:05:46 CST 2014
	 */
	int updateByPrimaryKeySelective(MlPayRecord record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_pay_record
	 * @mbggenerated  Sat Nov 01 17:05:46 CST 2014
	 */
	int updateByPrimaryKey(MlPayRecord record);
}