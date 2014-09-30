package com.wealth.miniloan.dao;

import com.wealth.miniloan.entity.MlNaturalMortgage;
import com.wealth.miniloan.entity.MlNaturalMortgageExample;
import com.wealth.miniloan.entity.MlNaturalMortgageKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MlNaturalMortgageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_mortgage_info
     *
     * @mbggenerated Sat Sep 27 17:32:09 CST 2014
     */
    int countByExample(MlNaturalMortgageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_mortgage_info
     *
     * @mbggenerated Sat Sep 27 17:32:09 CST 2014
     */
    int deleteByExample(MlNaturalMortgageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_mortgage_info
     *
     * @mbggenerated Sat Sep 27 17:32:09 CST 2014
     */
    int deleteByPrimaryKey(MlNaturalMortgageKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_mortgage_info
     *
     * @mbggenerated Sat Sep 27 17:32:09 CST 2014
     */
    int insert(MlNaturalMortgage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_mortgage_info
     *
     * @mbggenerated Sat Sep 27 17:32:09 CST 2014
     */
    int insertSelective(MlNaturalMortgage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_mortgage_info
     *
     * @mbggenerated Sat Sep 27 17:32:09 CST 2014
     */
    List<MlNaturalMortgage> selectByExample(MlNaturalMortgageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_mortgage_info
     *
     * @mbggenerated Sat Sep 27 17:32:09 CST 2014
     */
    MlNaturalMortgage selectByPrimaryKey(MlNaturalMortgageKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_mortgage_info
     *
     * @mbggenerated Sat Sep 27 17:32:09 CST 2014
     */
    int updateByExampleSelective(@Param("record") MlNaturalMortgage record, @Param("example") MlNaturalMortgageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_mortgage_info
     *
     * @mbggenerated Sat Sep 27 17:32:09 CST 2014
     */
    int updateByExample(@Param("record") MlNaturalMortgage record, @Param("example") MlNaturalMortgageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_mortgage_info
     *
     * @mbggenerated Sat Sep 27 17:32:09 CST 2014
     */
    int updateByPrimaryKeySelective(MlNaturalMortgage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_mortgage_info
     *
     * @mbggenerated Sat Sep 27 17:32:09 CST 2014
     */
    int updateByPrimaryKey(MlNaturalMortgage record);
}