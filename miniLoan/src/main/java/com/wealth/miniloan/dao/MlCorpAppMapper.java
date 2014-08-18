package com.wealth.miniloan.dao;

import com.wealth.miniloan.entity.MlCorpApp;
import com.wealth.miniloan.entity.MlCorpAppExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MlCorpAppMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_corp_app
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    int countByExample(MlCorpAppExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_corp_app
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    int deleteByExample(MlCorpAppExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_corp_app
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    int deleteByPrimaryKey(String appNo);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_corp_app
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    int insert(MlCorpApp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_corp_app
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    int insertSelective(MlCorpApp record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_corp_app
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    List<MlCorpApp> selectByExample(MlCorpAppExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_corp_app
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    int updateByExampleSelective(@Param("record") MlCorpApp record, @Param("example") MlCorpAppExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_corp_app
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    int updateByExample(@Param("record") MlCorpApp record, @Param("example") MlCorpAppExample example);
}