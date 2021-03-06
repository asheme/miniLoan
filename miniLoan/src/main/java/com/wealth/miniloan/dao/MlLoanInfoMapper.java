package com.wealth.miniloan.dao;

import com.wealth.miniloan.entity.MlLoanInfo;
import com.wealth.miniloan.entity.MlLoanInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MlLoanInfoMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_loan_info
	 * @mbggenerated  Sun Nov 02 10:40:44 CST 2014
	 */
	int countByExample(MlLoanInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_loan_info
	 * @mbggenerated  Sun Nov 02 10:40:44 CST 2014
	 */
	int deleteByExample(MlLoanInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_loan_info
	 * @mbggenerated  Sun Nov 02 10:40:44 CST 2014
	 */
	int deleteByPrimaryKey(Long loanId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_loan_info
	 * @mbggenerated  Sun Nov 02 10:40:44 CST 2014
	 */
	int insert(MlLoanInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_loan_info
	 * @mbggenerated  Sun Nov 02 10:40:44 CST 2014
	 */
	int insertSelective(MlLoanInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_loan_info
	 * @mbggenerated  Sun Nov 02 10:40:44 CST 2014
	 */
	List<MlLoanInfo> selectByExample(MlLoanInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_loan_info
	 * @mbggenerated  Sun Nov 02 10:40:44 CST 2014
	 */
	MlLoanInfo selectByPrimaryKey(Long loanId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_loan_info
	 * @mbggenerated  Sun Nov 02 10:40:44 CST 2014
	 */
	int updateByExampleSelective(@Param("record") MlLoanInfo record, @Param("example") MlLoanInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_loan_info
	 * @mbggenerated  Sun Nov 02 10:40:44 CST 2014
	 */
	int updateByExample(@Param("record") MlLoanInfo record, @Param("example") MlLoanInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_loan_info
	 * @mbggenerated  Sun Nov 02 10:40:44 CST 2014
	 */
	int updateByPrimaryKeySelective(MlLoanInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table ml_loan_info
	 * @mbggenerated  Sun Nov 02 10:40:44 CST 2014
	 */
	int updateByPrimaryKey(MlLoanInfo record);
}