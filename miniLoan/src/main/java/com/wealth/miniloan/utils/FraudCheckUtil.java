package com.wealth.miniloan.utils;

import java.util.HashMap;
import java.util.Map;


public class FraudCheckUtil {
	public final static Map<String, String[]> itemsMap = new HashMap<String, String[]>();
	
	public final static String ITEM_CODE_101 = "101";
	public final static String ITEM_CODE_102 = "102";
	public final static String ITEM_CODE_103 = "103";
	public final static String ITEM_CODE_104 = "104";
	public final static String ITEM_CODE_105 = "105";
	public final static String ITEM_CODE_106 = "106";
	public final static String ITEM_CODE_201 = "201";
	public final static String ITEM_CODE_202 = "202";
	public final static String ITEM_CODE_203 = "203";
	public final static String ITEM_CODE_204 = "204";
	public final static String ITEM_CODE_205 = "205";
	public final static String ITEM_CODE_206 = "206";
	public final static String ITEM_CODE_207 = "207";
	public final static String ITEM_CODE_301 = "301";
	public final static String ITEM_CODE_302 = "302";
	public final static String ITEM_CODE_303 = "303";
	public final static String ITEM_CODE_304 = "304";
	public final static String ITEM_CODE_401 = "401";
	public final static String ITEM_CODE_501 = "501";
	
	public final static String[] ITEM_CODE_DESC_101 = {Constant.FRAUD_CHECK_ITEM_TYPE_RELEVANCE,"重复申请检查-证件类型+证件号", "在所有的申请信息表根据证件类型及证件号码检查以往的申请（证件类型+证件号码）"};
	public final static String[] ITEM_CODE_DESC_102 = {Constant.FRAUD_CHECK_ITEM_TYPE_RELEVANCE,"关联性检查-手机", "在所有申请信息表中检查同一手机的申请"};
	public final static String[] ITEM_CODE_DESC_103 = {Constant.FRAUD_CHECK_ITEM_TYPE_RELEVANCE,"关联性检查-固定电话", "在所有申请信息表中检查同一固定电话的申请"};
	public final static String[] ITEM_CODE_DESC_104 = {Constant.FRAUD_CHECK_ITEM_TYPE_RELEVANCE,"关联性检查-电子邮箱", "在所有申请信息表中检查同一电子邮箱的申请"};
	public final static String[] ITEM_CODE_DESC_105 = {Constant.FRAUD_CHECK_ITEM_TYPE_RELEVANCE,"关联性检查-单位地址", "在所有申请信息表中检查同一单位地址（精确匹配）的申请"};
	public final static String[] ITEM_CODE_DESC_106 = {Constant.FRAUD_CHECK_ITEM_TYPE_RELEVANCE,"关联性检查-家庭地址", "在所有申请信息表中检查同一家庭地址（精确匹配）的申请"};
	public final static String[] ITEM_CODE_DESC_201 = {Constant.FRAUD_CHECK_ITEM_TYPE_CROSS,"出生日期与身份证件号不符", "客户申请的生日与身份证件上生日进行匹配"};
	public final static String[] ITEM_CODE_DESC_202 = {Constant.FRAUD_CHECK_ITEM_TYPE_CROSS,"性别与身份证件号不符", "客户申请的性别与身份证上的性别信息进行匹配"};
	public final static String[] ITEM_CODE_DESC_203 = {Constant.FRAUD_CHECK_ITEM_TYPE_CROSS,"家庭电话号码与单位电话号码完全相同", "在申请信息家庭电话号码与单位电话号码完全相同"};
	public final static String[] ITEM_CODE_DESC_204 = {Constant.FRAUD_CHECK_ITEM_TYPE_CROSS,"年龄与居住年限不符", "由申请表中的年龄与居住年限相匹配：若年龄<居住年限，则显示警示信息。"};
	public final static String[] ITEM_CODE_DESC_205 = {Constant.FRAUD_CHECK_ITEM_TYPE_CROSS,"年龄与教育程度不符", "由客户申请信息中的教育程度与年龄相匹配：教育程度=博士，且年龄<22；教育程度=硕士，且年龄<19；教育程度=本科，且年龄<18，满足上述任一条件则输出警示信息。"};
	public final static String[] ITEM_CODE_DESC_206 = {Constant.FRAUD_CHECK_ITEM_TYPE_CROSS,"年龄与工作年限不符", "由客户申请表年龄与工作年限匹配：若年龄与工作年限的差值小于16，则输出警示信息。"};
	public final static String[] ITEM_CODE_DESC_207 = {Constant.FRAUD_CHECK_ITEM_TYPE_CROSS,"年收入与现职年限不符", "由客户申请信息中年收入与现职年限相匹配：	现职年限<=2，且年收入>100000；现职年限<=5，且年收入>200000；现职年限<=10，且年收入>500000；现职年限<=20，且年收入>750000；年收入>1000000；满足上述任一条件输出警示信息。"};
	public final static String[] ITEM_CODE_DESC_301 = {Constant.FRAUD_CHECK_ITEM_TYPE_FRAUD,"身份证位校验有误", "身份证校验位验证有误"};
	public final static String[] ITEM_CODE_DESC_302 = {Constant.FRAUD_CHECK_ITEM_TYPE_FRAUD,"欺诈电话核查", "申请中所有电话都要到欺诈电话库中精确匹配检查"};
	public final static String[] ITEM_CODE_DESC_303 = {Constant.FRAUD_CHECK_ITEM_TYPE_FRAUD,"欺诈邮寄地址核查", "申请中的邮寄地址都要到欺诈邮寄地址库中精确匹配检查"};
	public final static String[] ITEM_CODE_DESC_304 = {Constant.FRAUD_CHECK_ITEM_TYPE_FRAUD,"系统黑名单", "在系统内部黑名单中检查（姓名+证件类型+证件号码）"};
	public final static String[] ITEM_CODE_DESC_401 = {Constant.FRAUD_CHECK_ITEM_TYPE_BASIC,"年龄不满足", "年龄是否满足在18周岁~65周岁，如果不满足则拒绝"};
	public final static String[] ITEM_CODE_DESC_501 = {Constant.FRAUD_CHECK_ITEM_TYPE_CREDIT,"是否逾期三次", "征信报告是否逾期三次，如果不满足则拒绝"};
	static {
		itemsMap.put(ITEM_CODE_101, ITEM_CODE_DESC_101);
		itemsMap.put(ITEM_CODE_102, ITEM_CODE_DESC_102);
		itemsMap.put(ITEM_CODE_103, ITEM_CODE_DESC_103);
		itemsMap.put(ITEM_CODE_104, ITEM_CODE_DESC_104);
		itemsMap.put(ITEM_CODE_105, ITEM_CODE_DESC_105);
		itemsMap.put(ITEM_CODE_106, ITEM_CODE_DESC_106);
		itemsMap.put(ITEM_CODE_201, ITEM_CODE_DESC_201);
		itemsMap.put(ITEM_CODE_202, ITEM_CODE_DESC_202);
		itemsMap.put(ITEM_CODE_203, ITEM_CODE_DESC_203);
		itemsMap.put(ITEM_CODE_204, ITEM_CODE_DESC_204);
		itemsMap.put(ITEM_CODE_205, ITEM_CODE_DESC_205);
		itemsMap.put(ITEM_CODE_206, ITEM_CODE_DESC_206);
		itemsMap.put(ITEM_CODE_207, ITEM_CODE_DESC_207);
		itemsMap.put(ITEM_CODE_301, ITEM_CODE_DESC_301);
		itemsMap.put(ITEM_CODE_302, ITEM_CODE_DESC_302);
		itemsMap.put(ITEM_CODE_303, ITEM_CODE_DESC_303);
		itemsMap.put(ITEM_CODE_304, ITEM_CODE_DESC_304);
		itemsMap.put(ITEM_CODE_401, ITEM_CODE_DESC_401);
		itemsMap.put(ITEM_CODE_501, ITEM_CODE_DESC_501);
	}
	
}
