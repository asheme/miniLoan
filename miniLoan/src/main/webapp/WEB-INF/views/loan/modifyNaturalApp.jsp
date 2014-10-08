<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>create or modify natural loan application</title>
<script type="text/javascript">
<!--
	$(function() {
		//初始化combobox
		//initComboboxContent("isLeaf", "YES_OR_NO");
	});

	//返回列表页
	function backList() {
		window.location.href = '${pageContext.request.contextPath}/menu/loanNaturalAppList.do';
	}

	//保存信息
	function saveObj() {
		if (!validate()) {
			return;
		}

		$('#modifyForm').form('submit', {
			url : '${pageContext.request.contextPath}/resc/modifyResc.do',
			success : function(result) {
				try {
					var r = $.parseJSON(result);
					if (r.success) {
						$.messager.alert('信息提示', r.msg, "info", backList);
					}
				} catch (e) {
					$.messager.alert('信息提示', result);
				}
			}
		});
	}

	//检查输入是否有效
	function validate() {
		return true;
	}

	function initRescParentId() {
		$("#parentId").combobox({
			url : '${pageContext.request.contextPath}/resc/getParentResc.do',
			valueField : 'value',
			textField : 'title',
			editable : false,
			multiple : false,
			panelHeight : 200
		});
	}
//-->
</script>
</head>
<body>
	<div id="updatePanel" class="easyui-panel" title="数据信息"
		data-options="border:false,fit:true"
		style="padding-left: 2px; padding-right: 2px; padding-bottom: 1px; padding-top: 2px;">
		<form id="modifyForm" method="post">
			<table class="modifytable" width="100%">
				<tr>
					<th align="center" width="25%">姓名</th>
					<td width="25%"><input class="easyui-validatebox" name="name"
						value="${naturalApp.name}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="name" /></td>
					<th align="center" width="25%">性别</th>
					<td width="25%"><input class="easyui-validatebox" name="gender"
						value="${naturalApp.gender}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="gender" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">证件类型</th>
					<td width="25%"><input class="easyui-validatebox" name="idType"
						value="${naturalApp.idType}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="idType" /></td>
					<th align="center" width="25%">证件号码</th>
					<td width="25%"><input class="easyui-validatebox" name="idNo"
						value="${naturalApp.idNo}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="idNo" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">证件签发日期</th>
					<td width="25%"><input class="easyui-validatebox" name="idSignDate"
						value="${naturalApp.idSignDate}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="idSignDate" /></td>
					<th align="center" width="25%">证件到期日期</th>
					<td width="25%"><input class="easyui-validatebox" name="idExpireDate"
						value="${naturalApp.idExpireDate}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="idExpireDate" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">出生日期</th>
					<td width="25%"><input class="easyui-validatebox" name="birthday"
						value="${naturalApp.birthday}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="birthday" /></td>
					<th align="center" width="25%">年龄</th>
					<td width="25%"><input class="easyui-validatebox" name="age"
						value="${naturalApp.age}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="age" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">国籍</th>
					<td width="25%"><input class="easyui-validatebox" name="nation"
						value="${naturalApp.nation}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="nation" /></td>
					<th align="center" width="25%">教育程度</th>
					<td width="25%"><input class="easyui-validatebox" name="educationLvl"
						value="${naturalApp.educationLvl}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="educationLvl" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">政治面貌</th>
					<td width="25%"><input class="easyui-validatebox" name="politicsStatus"
						value="${naturalApp.politicsStatus}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="politicsStatus" /></td>
					<th align="center" width="25%">手机号码</th>
					<td width="25%"><input class="easyui-validatebox" name="mobile"
						value="${naturalApp.mobile}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="mobile" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">固定电话</th>
					<td width="25%"><input class="easyui-validatebox" name="homePhone"
						value="${naturalApp.homePhone}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="homePhone" /></td>
					<th align="center" width="25%">电子邮箱</th>
					<td width="25%"><input class="easyui-validatebox" name="email"
						value="${naturalApp.email}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="email" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">所属行业类型</th>
					<td width="25%"><input class="easyui-validatebox" name="industryType"
						value="${naturalApp.industryType}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="industryType" /></td>
					<th align="center" width="25%">单位名称</th>
					<td width="25%"><input class="easyui-validatebox" name="company"
						value="${naturalApp.company}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="company" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">职务</th>
					<td width="25%"><input class="easyui-validatebox" name="position"
						value="${naturalApp.position}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="position" /></td>
					<th align="center" width="25%">工作年限</th>
					<td width="25%"><input class="easyui-validatebox" name="workYears"
						value="${naturalApp.workYears}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="workYears" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">现单位工作开始时间</th>
					<td width="25%"><input class="easyui-validatebox" name="currJobStDate"
						value="${naturalApp.currJobStDate}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="currJobStDate" /></td>
					<th align="center" width="25%">单位地址</th>
					<td width="25%"><input class="easyui-validatebox" name="compAddr"
						value="${naturalApp.compAddr}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="compAddr" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">单位地址邮编</th>
					<td width="25%"><input class="easyui-validatebox" name="compZip"
						value="${naturalApp.compZip}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="compZip" /></td>
					<th align="center" width="25%">家庭地址</th>
					<td width="25%"><input class="easyui-validatebox" name="homeAddr"
						value="${naturalApp.homeAddr}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="homeAddr" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">家庭地址邮编</th>
					<td width="25%"><input class="easyui-validatebox" name="homeZip"
						value="${naturalApp.homeZip}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="homeZip" /></td>
					<th align="center" width="25%">住宅情况</th>
					<td width="25%"><input class="easyui-validatebox" name="residentStatus"
						value="${naturalApp.residentStatus}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="residentStatus" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">居住开始时间</th>
					<td width="25%"><input class="easyui-validatebox" name="liveStartTime"
						value="${naturalApp.liveStartTime}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="liveStartTime" /></td>
					<th align="center" width="25%">拥有车辆品牌</th>
					<td width="25%"><input class="easyui-validatebox" name="carBrand"
						value="${naturalApp.carBrand}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="carBrand" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">车牌号码</th>
					<td width="25%"><input class="easyui-validatebox" name="carNo"
						value="${naturalApp.carNo}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="carNo" /></td>
					<th align="center" width="25%">车辆情况</th>
					<td width="25%"><input class="easyui-validatebox" name="carStatus"
						value="${naturalApp.carStatus}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="carStatus" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">车辆购买日期</th>
					<td width="25%"><input class="easyui-validatebox" name="carBuyDate"
						value="${naturalApp.carBuyDate}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="carBuyDate" /></td>
					<th align="center" width="25%">配偶姓名</th>
					<td width="25%"><input class="easyui-validatebox" name="spouseName"
						value="${naturalApp.spouseName}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="spouseName" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">配偶证件类型</th>
					<td width="25%"><input class="easyui-validatebox" name="spouseIdType"
						value="${naturalApp.spouseIdType}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="spouseIdType" /></td>
					<th align="center" width="25%">配偶证件号码</th>
					<td width="25%"><input class="easyui-validatebox" name="spouseIdNo"
						value="${naturalApp.spouseIdNo}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="spouseIdNo" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">配偶证件签发日期</th>
					<td width="25%"><input class="easyui-validatebox" name="spouseIdSignDate"
						value="${naturalApp.spouseIdSignDate}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="spouseIdSignDate" /></td>
					<th align="center" width="25%">配偶证件到期日期</th>
					<td width="25%"><input class="easyui-validatebox" name="spouseIdExpireDate"
						value="${naturalApp.spouseIdExpireDate}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="spouseIdExpireDate" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">配偶行业类型</th>
					<td width="25%"><input class="easyui-validatebox" name="spouseIndustryType"
						value="${naturalApp.spouseIndustryType}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="spouseIndustryType" /></td>
					<th align="center" width="25%">配偶单位名称</th>
					<td width="25%"><input class="easyui-validatebox" name="spouseCompany"
						value="${naturalApp.spouseCompany}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="spouseCompany" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">配偶职务</th>
					<td width="25%"><input class="easyui-validatebox" name="spousePosition"
						value="${naturalApp.spousePosition}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="spousePosition" /></td>
					<th align="center" width="25%">配偶单位地址</th>
					<td width="25%"><input class="easyui-validatebox" name="spouseCompAddr"
						value="${naturalApp.spouseCompAddr}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="spouseCompAddr" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">配偶单位地址邮编</th>
					<td width="25%"><input class="easyui-validatebox" name="spouseCompZip"
						value="${naturalApp.spouseCompZip}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="spouseCompZip" /></td>
					<th align="center" width="25%">配偶手机号码</th>
					<td width="25%"><input class="easyui-validatebox" name="spouseMobile"
						value="${naturalApp.spouseMobile}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="spouseMobile" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">配偶固定电话</th>
					<td width="25%"><input class="easyui-validatebox" name="spouseHomePhone"
						value="${naturalApp.spouseHomePhone}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="spouseHomePhone" /></td>
					<th align="center" width="25%">配偶电子邮箱</th>
					<td width="25%"><input class="easyui-validatebox" name="spouseEmail"
						value="${naturalApp.spouseEmail}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="spouseEmail" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">联系人姓名</th>
					<td width="25%"><input class="easyui-validatebox" name="linkmanName"
						value="${naturalApp.linkmanName}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="linkmanName" /></td>
					<th align="center" width="25%">联系人证件类型</th>
					<td width="25%"><input class="easyui-validatebox" name="linkmanIdType"
						value="${naturalApp.linkmanIdType}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="linkmanIdType" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">联系人证件号码</th>
					<td width="25%"><input class="easyui-validatebox" name="linkmanIdNo"
						value="${naturalApp.linkmanIdNo}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="linkmanIdNo" /></td>
					<th align="center" width="25%">联系人证件签发日期</th>
					<td width="25%"><input class="easyui-validatebox" name="linkmanIdSignDate"
						value="${naturalApp.linkmanIdSignDate}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="linkmanIdSignDate" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">联系人证件到期日期</th>
					<td width="25%"><input class="easyui-validatebox" name="linkmanIdExpireDate"
						value="${naturalApp.linkmanIdExpireDate}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="linkmanIdExpireDate" /></td>
					<th align="center" width="25%">联系人行业类型</th>
					<td width="25%"><input class="easyui-validatebox" name="linkmanIndustryType"
						value="${naturalApp.linkmanIndustryType}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="linkmanIndustryType" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">联系人单位名称</th>
					<td width="25%"><input class="easyui-validatebox" name="linkmanCompany"
						value="${naturalApp.linkmanCompany}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="linkmanCompany" /></td>
					<th align="center" width="25%">联系人职务</th>
					<td width="25%"><input class="easyui-validatebox" name="linkmanPosition"
						value="${naturalApp.linkmanPosition}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="linkmanPosition" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">联系人单位地址</th>
					<td width="25%"><input class="easyui-validatebox" name="linkmanCompAddr"
						value="${naturalApp.linkmanCompAddr}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="linkmanCompAddr" /></td>
					<th align="center" width="25%">联系人单位地址邮编</th>
					<td width="25%"><input class="easyui-validatebox" name="linkmanCompZip"
						value="${naturalApp.linkmanCompZip}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="linkmanCompZip" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">联系人手机号码</th>
					<td width="25%"><input class="easyui-validatebox" name="linkmanMobile"
						value="${naturalApp.linkmanMobile}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="linkmanMobile" /></td>
					<th align="center" width="25%">联系人固定电话</th>
					<td width="25%"><input class="easyui-validatebox" name="linkmanHomePhone"
						value="${naturalApp.linkmanHomePhone}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="linkmanHomePhone" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">联系人电子邮箱</th>
					<td width="25%"><input class="easyui-validatebox" name="linkmanEmail"
						value="${naturalApp.linkmanEmail}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="linkmanEmail" /></td>
					<th align="center" width="25%"></th>
					<td width="25%"></td>
				</tr>
				<tr>
					<th align="center" width="25%">贷款产品</th>
					<td width="25%"><input class="easyui-validatebox" name="loanProduct"
						value="${naturalApp.loanProduct}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="loanProduct" /></td>
					<th align="center" width="25%">贷款申请金额</th>
					<td width="25%"><input class="easyui-validatebox" name="loanAmount"
						value="${naturalApp.loanAmount}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="loanAmount" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">还款周期</th>
					<td width="25%"><input class="easyui-validatebox" name="loanCycle"
						value="${naturalApp.loanCycle}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="loanCycle" /></td>
					<th align="center" width="25%">计息方式</th>
					<td width="25%"><input class="easyui-validatebox" name="interestType"
						value="${naturalApp.interestType}"
						data-options="required:true,validType:'length[0,30]'"
						style="width: 250px;" id="interestType" /></td>
				</tr>
				<tr>
					<td colspan="4" align="center"><input type="button" value="保存"
						class="btn" onclick="javascript:saveObj();" /> <input
						type="button" value="返回" class="btn"
						onclick="javascript:backList();" /> <input type="hidden"
						name="rescId" value="${resc.rescId}" /> <input type="hidden"
						name="flag" value="${flag}"></td>
				</tr>
			</table>
		</form>
	</div>
</body>