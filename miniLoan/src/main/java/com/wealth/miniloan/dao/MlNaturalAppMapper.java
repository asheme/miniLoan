package com.wealth.miniloan.dao;

import com.wealth.miniloan.entity.MlNaturalApp;
import com.wealth.miniloan.entity.MlNaturalAppExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MlNaturalAppMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_natural_app
	 * @mbggenerated  Fri Oct 31 20:20:09 GMT+08:00 2014
	 */
	int countByExample(MlNaturalAppExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_natural_app
	 * @mbggenerated  Fri Oct 31 20:20:09 GMT+08:00 2014
	 */
	int deleteByExample(MlNaturalAppExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_natural_app
	 * @mbggenerated  Fri Oct 31 20:20:09 GMT+08:00 2014
	 */
	int deleteByPrimaryKey(String appNo);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_natural_app
	 * @mbggenerated  Fri Oct 31 20:20:09 GMT+08:00 2014
	 */
	int insert(MlNaturalApp record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_natural_app
	 * @mbggenerated  Fri Oct 31 20:20:09 GMT+08:00 2014
	 */
	int insertSelective(MlNaturalApp record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_natural_app
	 * @mbggenerated  Fri Oct 31 20:20:09 GMT+08:00 2014
	 */
	List<MlNaturalApp> selectByExample(MlNaturalAppExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_natural_app
	 * @mbggenerated  Fri Oct 31 20:20:09 GMT+08:00 2014
	 */
	MlNaturalApp selectByPrimaryKey(String appNo);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_natural_app
	 * @mbggenerated  Fri Oct 31 20:20:09 GMT+08:00 2014
	 */
	int updateByExampleSelective(@Param("record") MlNaturalApp record,
			@Param("example") MlNaturalAppExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_natural_app
	 * @mbggenerated  Fri Oct 31 20:20:09 GMT+08:00 2014
	 */
	int updateByExample(@Param("record") MlNaturalApp record,
			@Param("example") MlNaturalAppExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_natural_app
	 * @mbggenerated  Fri Oct 31 20:20:09 GMT+08:00 2014
	 */
	int updateByPrimaryKeySelective(MlNaturalApp record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_natural_app
	 * @mbggenerated  Fri Oct 31 20:20:09 GMT+08:00 2014
	 */
	int updateByPrimaryKey(MlNaturalApp record);
}