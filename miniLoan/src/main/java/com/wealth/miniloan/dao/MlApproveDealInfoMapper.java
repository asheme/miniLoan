package com.wealth.miniloan.dao;

import com.wealth.miniloan.entity.MlApproveDealInfo;
import com.wealth.miniloan.entity.MlApproveDealInfoExample;
import com.wealth.miniloan.entity.MlApproveDealInfoKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MlApproveDealInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_approve_deal_info
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    int countByExample(MlApproveDealInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_approve_deal_info
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    int deleteByExample(MlApproveDealInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_approve_deal_info
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    int deleteByPrimaryKey(MlApproveDealInfoKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_approve_deal_info
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    int insert(MlApproveDealInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_approve_deal_info
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    int insertSelective(MlApproveDealInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_approve_deal_info
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    List<MlApproveDealInfo> selectByExampleWithBLOBs(MlApproveDealInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_approve_deal_info
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    List<MlApproveDealInfo> selectByExample(MlApproveDealInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_approve_deal_info
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    MlApproveDealInfo selectByPrimaryKey(MlApproveDealInfoKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_approve_deal_info
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    int updateByExampleSelective(@Param("record") MlApproveDealInfo record, @Param("example") MlApproveDealInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_approve_deal_info
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    int updateByExampleWithBLOBs(@Param("record") MlApproveDealInfo record, @Param("example") MlApproveDealInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_approve_deal_info
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    int updateByExample(@Param("record") MlApproveDealInfo record, @Param("example") MlApproveDealInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_approve_deal_info
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    int updateByPrimaryKeySelective(MlApproveDealInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_approve_deal_info
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    int updateByPrimaryKeyWithBLOBs(MlApproveDealInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ml_approve_deal_info
     *
     * @mbggenerated Fri Aug 08 21:13:38 GMT+08:00 2014
     */
    int updateByPrimaryKey(MlApproveDealInfo record);
}