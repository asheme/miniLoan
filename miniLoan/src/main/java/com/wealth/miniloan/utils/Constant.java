package com.wealth.miniloan.utils;

import org.springframework.stereotype.Component;

public class Constant {
	//申请类别
	public static final String APP_TYPE_NATURAL="01"; //申请类别：自然人
	public static final String APP_TYPE_CORP="02"; //申请类别：公司

	//申请件状态
	public static final String APP_STATUS_PROCESS="P"; //处理过程中
	public static final String APP_STATUS_BACK="B"; //打回
	public static final String APP_STATUS_END="E"; //处理结束
	
	//处理步骤状态
	public static final String STEP_STATUS_PROCESS="P"; //处理过程中
	public static final String STEP_STATUS_BACK="B"; //打回
	public static final String STEP_STATUS_END="E"; //处理结束
	
	//步骤信息
	public static final String STEP_LOAN_APP="LOAN_APP"; //申请录入
	public static final String STEP_MORT_ESTI="MORT_ESTI"; //押品评估
	public static final String STEP_APP_CHECK="APP_CHECK"; //申请复核
	public static final String STEP_MANU_INSP="MANU_INSP"; //人工核查
	public static final String STEP_APP_APPR="APP_APPR"; //申请审批
}
