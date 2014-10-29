package com.wealth.miniloan.utils;


public class Constant {
	//申请类别
	public static final String APP_TYPE_NATURAL="01"; //申请类别：自然人
	public static final String APP_TYPE_CORP="02"; //申请类别：公司

	//申请件状态
	public static final String APP_STATUS_PROCESS="P"; //处理过程中
	public static final String APP_STATUS_BACK="B"; //打回
	public static final String APP_STATUS_REJECT="R"; //拒绝
	public static final String APP_STATUS_APPROVE="A"; //批准
	
	//处理步骤状态
	public static final String STEP_STATUS_PROCESS="P"; //处理过程中
	public static final String STEP_STATUS_BACK="B"; //打回
	public static final String STEP_STATUS_REJECT="R"; //拒绝
	public static final String STEP_STATUS_APPROVE="A"; //批准
	public static final String STEP_STATUS_END="E"; //批准

	//步骤信息
	public static final String STEP_LOAN_APP="LOAN_APP"; //申请录入
	public static final String STEP_MORT_ESTI="MORT_ESTI"; //押品评估
	public static final String STEP_APP_CHECK="APP_CHECK"; //申请复核
	public static final String STEP_MANU_INSP="MANU_INSP"; //人工核查
	public static final String STEP_APP_APPR="APP_APPR"; //申请审批
	
	//通用状态
	public static final String STATUS_ENABLE="1"; //启用
	public static final String STATUS_DISABLE="0"; //禁用
	
	//完整性检查项类别
	public static final String INTE_CHECK_ITEM_TYPE_NATURAL="N"; //自然人
	public static final String INTE_CHECK_ITEM_TYPE_CORP="C"; //企业
	
	//名单类型
	public static final String NAME_TYPE_WHITE = "01";//白名单
	public static final String NAME_TYPE_BLACK = "02";//黑名单
	
	
	//欺诈检查项类别
	public static final String FRAUD_CHECK_ITEM_TYPE_RELEVANCE="01"; //关联性数据检查
	public static final String FRAUD_CHECK_ITEM_TYPE_CROSS="02"; //交叉检查
	public static final String FRAUD_CHECK_ITEM_TYPE_FRAUD="03"; //欺诈检查
	public static final String FRAUD_CHECK_ITEM_TYPE_BASIC="04"; //基本项检查
	public static final String FRAUD_CHECK_ITEM_TYPE_CREDIT="05"; //征信数据检查
	
	//是否触发规则
	public static final String YES = "Y";
	public static final String NO = "N";
	
	
	//男女
	public static final String MALE = "1";
	public static final String FEMALE = "0";
	
	//婚姻状态
	public static final String MARRIAGE_STATUS_UNMARRIED = "01"; //未婚
	public static final String MARRIAGE_STATUS_MARRIED = "02"; //已婚
	public static final String MARRIAGE_STATUS_DIVORCE = "03"; //离婚
	public static final String MARRIAGE_STATUS_OTHER = "04"; //其他

	//教育程度
	public static final String EDUCATION_LVL_HIGHSCHOOL = "01"; //高中及其以下
	public static final String EDUCATION_LVL_JUNIORCOLLEGE = "02"; //大专
	public static final String EDUCATION_LVL_REGULARCOLLEGE = "03"; //本科
	public static final String EDUCATION_LVL_MASTER = "04"; //硕士
	public static final String EDUCATION_LVL_DOCTOR = "05"; //博士及以上
	public static final String EDUCATION_LVL_OTHER = "06"; //其他
	
	//审批级别
	public static final int APPRAOVAL_LEVEL_1 = 1; //一级
	public static final int APPRAOVAL_LEVEL_2 = 2; //二级
	public static final int APPRAOVAL_LEVEL_3 = 3; //三级

}
