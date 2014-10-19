package com.wealth.miniloan.dao;

import com.wealth.miniloan.entity.MlMortgageInfo;
import com.wealth.miniloan.entity.MlMortgageInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MlMortgageInfoMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_mortgage_info
	 * @mbggenerated  Sun Oct 19 18:28:13 CST 2014
	 */
	int countByExample(MlMortgageInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_mortgage_info
	 * @mbggenerated  Sun Oct 19 18:28:13 CST 2014
	 */
	int deleteByExample(MlMortgageInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_mortgage_info
	 * @mbggenerated  Sun Oct 19 18:28:13 CST 2014
	 */
	int deleteByPrimaryKey(Long mortgageId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_mortgage_info
	 * @mbggenerated  Sun Oct 19 18:28:13 CST 2014
	 */
	int insert(MlMortgageInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_mortgage_info
	 * @mbggenerated  Sun Oct 19 18:28:13 CST 2014
	 */
	int insertSelective(MlMortgageInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_mortgage_info
	 * @mbggenerated  Sun Oct 19 18:28:13 CST 2014
	 */
	List<MlMortgageInfo> selectByExample(MlMortgageInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_mortgage_info
	 * @mbggenerated  Sun Oct 19 18:28:13 CST 2014
	 */
	MlMortgageInfo selectByPrimaryKey(Long mortgageId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_mortgage_info
	 * @mbggenerated  Sun Oct 19 18:28:13 CST 2014
	 */
	int updateByExampleSelective(@Param("record") MlMortgageInfo record, @Param("example") MlMortgageInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_mortgage_info
	 * @mbggenerated  Sun Oct 19 18:28:13 CST 2014
	 */
	int updateByExample(@Param("record") MlMortgageInfo record, @Param("example") MlMortgageInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_mortgage_info
	 * @mbggenerated  Sun Oct 19 18:28:13 CST 2014
	 */
	int updateByPrimaryKeySelective(MlMortgageInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_mortgage_info
	 * @mbggenerated  Sun Oct 19 18:28:13 CST 2014
	 */
	int updateByPrimaryKey(MlMortgageInfo record);
}