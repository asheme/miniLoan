package com.wealth.miniloan.dao;

import com.wealth.miniloan.entity.MlNaturalCustInfo;
import com.wealth.miniloan.entity.MlNaturalCustInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MlNaturalCustInfoMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_natural_cust_info
	 * @mbggenerated  Fri Oct 31 20:20:09 GMT+08:00 2014
	 */
	int countByExample(MlNaturalCustInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_natural_cust_info
	 * @mbggenerated  Fri Oct 31 20:20:09 GMT+08:00 2014
	 */
	int deleteByExample(MlNaturalCustInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_natural_cust_info
	 * @mbggenerated  Fri Oct 31 20:20:09 GMT+08:00 2014
	 */
	int deleteByPrimaryKey(String custNo);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_natural_cust_info
	 * @mbggenerated  Fri Oct 31 20:20:09 GMT+08:00 2014
	 */
	int insert(MlNaturalCustInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_natural_cust_info
	 * @mbggenerated  Fri Oct 31 20:20:09 GMT+08:00 2014
	 */
	int insertSelective(MlNaturalCustInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_natural_cust_info
	 * @mbggenerated  Fri Oct 31 20:20:09 GMT+08:00 2014
	 */
	List<MlNaturalCustInfo> selectByExample(MlNaturalCustInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_natural_cust_info
	 * @mbggenerated  Fri Oct 31 20:20:09 GMT+08:00 2014
	 */
	MlNaturalCustInfo selectByPrimaryKey(String custNo);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_natural_cust_info
	 * @mbggenerated  Fri Oct 31 20:20:09 GMT+08:00 2014
	 */
	int updateByExampleSelective(@Param("record") MlNaturalCustInfo record,
			@Param("example") MlNaturalCustInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_natural_cust_info
	 * @mbggenerated  Fri Oct 31 20:20:09 GMT+08:00 2014
	 */
	int updateByExample(@Param("record") MlNaturalCustInfo record,
			@Param("example") MlNaturalCustInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_natural_cust_info
	 * @mbggenerated  Fri Oct 31 20:20:09 GMT+08:00 2014
	 */
	int updateByPrimaryKeySelective(MlNaturalCustInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_natural_cust_info
	 * @mbggenerated  Fri Oct 31 20:20:09 GMT+08:00 2014
	 */
	int updateByPrimaryKey(MlNaturalCustInfo record);
}