<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>create or modify natural loan application</title>
<script type="text/javascript">

	$(function() {
		$("#idSignDate").datebox();
		$("#idExpireDate").datebox();
		$("#birthday").datebox();
		$("#currJobStDate").datebox();
		$("#liveStartTime").datebox();
		$("#carBuyDate").datebox();
		$("#spouseIdSignDate").datebox();
		$("#spouseIdExpireDate").datebox();
		$("#linkmanIdSignDate").datebox();
		$("#linkmanIdExpireDate").datebox();
		$("#guarCompOpenDate").datebox();
		
		initComboboxContent("gender", "GENDER");
		initComboboxContent("idType", "ID_TYPE");
		initComboboxContent("spouseIdType", "ID_TYPE");
		initComboboxContent("linkmanIdType", "ID_TYPE");
		
		$("input[dateFormat='date']").each(function(){				
			var time=dateToStr($(this).val());
			$(this).datebox('setValue',time);
		});
		
		/* if ($("input[name='flag']").val() == "ADD") {
			$('#updatePanel').panel({
				title : '添加申请信息'
			});
		} else {
			$('#updatePanel').panel({
				title : '修改申请信息'
			});
		} */
	});
	
	//返回列表页
	/* function backList() {
		window.location.href = '${pageContext.request.contextPath}/menu/naturalAppList.do';
	} */
	
	function getDate(date){
		
		return date;
	}
	function saveObjApp() {
		$('#modifyForm').form('submit', {
			url : '${pageContext.request.contextPath}/natural/app/modifyNaturalApp.do?flag='+window.parent.flag+'&appNo='+window.parent.appNo,
			success : function(result)  {
				try {
					var r = $.parseJSON(result);
					if (r.success) {
						window.parent.appNo=r.appNo;
						window.parent.flag="UPDATE";
						parent.document.getElementById("attachIframe").src='${pageContext.request.contextPath}/natural/attach/toNaturalAttachList.do?appNo='+window.parent.appNo;
						document.frames('attachIframe').location.reload();
						parent.document.getElementById("mortgageIframe").src='${pageContext.request.contextPath}/natural/mortgage/toMortgageList.do?appNo='+window.parent.appNo;
						document.frames('mortgageIframe').location.reload();
						$.messager.alert('信息提示', r.msg, "info");
					} else {
						$.messager.alert('信息提示', r.msg, "info");
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

	function clearNaturalApp() {
		$.messager.confirm('信息提示', '您确认要清空所有录入？', function(r) {
		if(r){
			$("input[type!='button']").each(function() {
			$(this).val("");
		});
		}
		});
	}
</script>
</head>
<body>
	<div id="updatePanel" class="easyui-panel"
		data-options="border:false,fit:true"
		style="padding-left: 2px; padding-right: 2px; padding-bottom: 1px; padding-top: 2px;">
		<form id="modifyForm" method="post">
			<table class="modifytable" width="100%">
				<tr>
					<th align="center" width="25%">姓名</th>
					<td width="25%"><input class="easyui-validatebox" name="name"
						value="${naturalApp.name}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="name" /></td>
					<th align="center" width="25%">性别</th>
					<td width="25%"><input class="easyui-validatebox"
						name="gender" value="${naturalApp.gender}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="gender" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">证件类型</th>
					<td width="25%"><input class="easyui-validatebox"
						name="idType" value="${naturalApp.idType}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="idType" /></td>
					<th align="center" width="25%">证件号码</th>
					<td width="25%"><input class="easyui-validatebox" name="idNo"
						value="${naturalApp.idNo}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="idNo" /></td>
				</tr>

				<tr>
					<th align="center" width="25%">证件签发日期</th>
					<td width="25%"><input class="easyui-validatebox"
						dateFormat="date" name="idSignDate"
						value="${naturalApp.idSignDate}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="idSignDate" /></td>
					<th align="center" width="25%">证件到期日期</th>
					<td width="25%"><input class="easyui-validatebox"
						dateFormat="date" name="idExpireDate"
						value="${naturalApp.idExpireDate}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="idExpireDate" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">出生日期</th>
					<td width="25%"><input class="easyui-validatebox"
						dateFormat="date" name="birthday" value="${naturalApp.birthday}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="birthday" /></td>
					<th align="center" width="25%">年龄</th>
					<td width="25%"><input class="easyui-validatebox" name="age"
						value="${naturalApp.age}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="age" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">国籍</th>
					<td width="25%"><input class="easyui-validatebox"
						name="nation" value="${naturalApp.nation}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="nation" /></td>
					<th align="center" width="25%">教育程度</th>
					<td width="25%"><input class="easyui-validatebox"
						name="educationLvl" value="${naturalApp.educationLvl}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="educationLvl" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">政治面貌</th>
					<td width="25%"><input class="easyui-validatebox"
						name="politicsStatus" value="${naturalApp.politicsStatus}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="politicsStatus" /></td>
					<th align="center" width="25%">手机号码</th>
					<td width="25%"><input class="easyui-validatebox"
						name="mobile" value="${naturalApp.mobile}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="mobile" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">固定电话</th>
					<td width="25%"><input class="easyui-validatebox"
						name="homePhone" value="${naturalApp.homePhone}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="homePhone" /></td>
					<th align="center" width="25%">电子邮箱</th>
					<td width="25%"><input class="easyui-validatebox" name="email"
						value="${naturalApp.email}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="email" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">所属行业类型</th>
					<td width="25%"><input class="easyui-validatebox"
						name="industryType" value="${naturalApp.industryType}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="industryType" /></td>
					<th align="center" width="25%">单位名称</th>
					<td width="25%"><input class="easyui-validatebox"
						name="company" value="${naturalApp.company}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="company" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">职务</th>
					<td width="25%"><input class="easyui-validatebox"
						name="position" value="${naturalApp.position}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="position" /></td>
					<th align="center" width="25%">工作年限</th>
					<td width="25%"><input class="easyui-validatebox"
						name="workYears" value="${naturalApp.workYears}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="workYears" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">现单位工作开始时间</th>
					<td width="25%"><input class="easyui-validatebox"
						dateFormat="date" name="currJobStDate"
						value="${naturalApp.currJobStDate}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="currJobStDate" /></td>
					<th align="center" width="25%">单位地址</th>
					<td width="25%"><input class="easyui-validatebox"
						name="compAddr" value="${naturalApp.compAddr}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="compAddr" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">单位地址邮编</th>
					<td width="25%"><input class="easyui-validatebox"
						name="compZip" value="${naturalApp.compZip}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="compZip" /></td>
					<th align="center" width="25%">家庭地址</th>
					<td width="25%"><input class="easyui-validatebox"
						name="homeAddr" value="${naturalApp.homeAddr}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="homeAddr" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">家庭地址邮编</th>
					<td width="25%"><input class="easyui-validatebox"
						name="homeZip" value="${naturalApp.homeZip}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="homeZip" /></td>
					<th align="center" width="25%">住宅情况</th>
					<td width="25%"><input class="easyui-validatebox"
						name="residentStatus" value="${naturalApp.residentStatus}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="residentStatus" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">居住开始时间</th>
					<td width="25%"><input class="easyui-validatebox"
						dateFormat="date" name="liveStartTime"
						value="${naturalApp.liveStartTime}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="liveStartTime" /></td>
					<th align="center" width="25%">拥有车辆品牌</th>
					<td width="25%"><input class="easyui-validatebox"
						name="carBrand" value="${naturalApp.carBrand}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="carBrand" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">车牌号码</th>
					<td width="25%"><input class="easyui-validatebox" name="carNo"
						value="${naturalApp.carNo}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="carNo" /></td>
					<th align="center" width="25%">车辆情况</th>
					<td width="25%"><input class="easyui-validatebox"
						name="carStatus" value="${naturalApp.carStatus}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="carStatus" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">车辆购买日期</th>
					<td width="25%"><input class="easyui-validatebox"
						dateFormat="date" name="carBuyDate"
						value="${naturalApp.carBuyDate}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="carBuyDate" /></td>

					<th align="center" width="25%">配偶姓名</th>
					<td width="25%"><input class="easyui-validatebox"
						name="spouseName" value="${naturalApp.spouseName}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="spouseName" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">存款</th>
					<td width="25%"><input class="easyui-validatebox"
						name="deposit" value="${naturalApp.deposit}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="deposit" /></td>

					<th align="center" width="25%">股票、基金、债券市值</th>
					<td width="25%"><input class="easyui-validatebox"
						name="stockValue" value="${naturalApp.stockValue}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="stockValue" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">申请人月税后收入</th>
					<td width="25%"><input class="easyui-validatebox"
						name="monthIncome" value="${naturalApp.monthIncome}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="monthIncome" /></td>

					<th align="center" width="25%">配偶月税后收入</th>
					<td width="25%"><input class="easyui-validatebox"
						name="spouseMonthIncome" value="${naturalApp.spouseMonthIncome}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="spouseMonthIncome" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">家庭合计月收入</th>
					<td width="25%"><input class="easyui-validatebox"
						name="homeIncome" value="${naturalApp.homeIncome}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="homeIncome" /></td>

					<th align="center" width="25%">对外担保及负债情况</th>
					<td width="25%"><input class="easyui-validatebox"
						name="liabilities" value="${naturalApp.liabilities}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="liabilities" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">是否对婚前、婚后财产归属有公证约定</th>
					<td width="25%"><input class="easyui-validatebox"
						name="hasDowryContract" value="${naturalApp.hasDowryContract}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="hasDowryContract" /></td>

					<th align="center" width="25%">对外担保及负债情况</th>
					<td width="25%"><input class="easyui-validatebox"
						name="liabilities" value="${naturalApp.liabilities}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="liabilities" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">配偶证件类型</th>
					<td width="25%"><input class="easyui-validatebox"
						name="spouseIdType" value="${naturalApp.spouseIdType}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="spouseIdType" /></td>
					<th align="center" width="25%">配偶证件号码</th>
					<td width="25%"><input class="easyui-validatebox"
						name="spouseIdNo" value="${naturalApp.spouseIdNo}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="spouseIdNo" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">配偶证件签发日期</th>
					<td width="25%"><input class="easyui-validatebox"
						dateFormat="date" name="spouseIdSignDate"
						value="${naturalApp.spouseIdSignDate}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="spouseIdSignDate" /></td>
					<th align="center" width="25%">配偶证件到期日期</th>
					<td width="25%"><input class="easyui-validatebox"
						dateFormat="date" name="spouseIdExpireDate"
						value="${naturalApp.spouseIdExpireDate}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="spouseIdExpireDate" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">配偶行业类型</th>
					<td width="25%"><input class="easyui-validatebox"
						name="spouseIndustryType" value="${naturalApp.spouseIndustryType}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="spouseIndustryType" /></td>
					<th align="center" width="25%">配偶单位名称</th>
					<td width="25%"><input class="easyui-validatebox"
						name="spouseCompany" value="${naturalApp.spouseCompany}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="spouseCompany" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">配偶职务</th>
					<td width="25%"><input class="easyui-validatebox"
						name="spousePosition" value="${naturalApp.spousePosition}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="spousePosition" /></td>
					<th align="center" width="25%">配偶单位地址</th>
					<td width="25%"><input class="easyui-validatebox"
						name="spouseCompAddr" value="${naturalApp.spouseCompAddr}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="spouseCompAddr" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">配偶单位地址邮编</th>
					<td width="25%"><input class="easyui-validatebox"
						name="spouseCompZip" value="${naturalApp.spouseCompZip}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="spouseCompZip" /></td>
					<th align="center" width="25%">配偶手机号码</th>
					<td width="25%"><input class="easyui-validatebox"
						name="spouseMobile" value="${naturalApp.spouseMobile}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="spouseMobile" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">配偶固定电话</th>
					<td width="25%"><input class="easyui-validatebox"
						name="spouseHomePhone" value="${naturalApp.spouseHomePhone}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="spouseHomePhone" /></td>
					<th align="center" width="25%">配偶电子邮箱</th>
					<td width="25%"><input class="easyui-validatebox"
						name="spouseEmail" value="${naturalApp.spouseEmail}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="spouseEmail" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">联系人姓名</th>
					<td width="25%"><input class="easyui-validatebox"
						name="linkmanName" value="${naturalApp.linkmanName}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="linkmanName" /></td>
					<th align="center" width="25%">联系人证件类型</th>
					<td width="25%"><input class="easyui-validatebox"
						name="linkmanIdType" value="${naturalApp.linkmanIdType}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="linkmanIdType" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">联系人证件号码</th>
					<td width="25%"><input class="easyui-validatebox"
						name="linkmanIdNo" value="${naturalApp.linkmanIdNo}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="linkmanIdNo" /></td>
					<th align="center" width="25%">联系人证件签发日期</th>
					<td width="25%"><input class="easyui-validatebox"
						dateFormat="date" name="linkmanIdSignDate"
						value="${naturalApp.linkmanIdSignDate}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="linkmanIdSignDate" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">联系人证件到期日期</th>
					<td width="25%"><input class="easyui-validatebox"
						dateFormat="date" name="linkmanIdExpireDate"
						value="${naturalApp.linkmanIdExpireDate}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="linkmanIdExpireDate" /></td>
					<th align="center" width="25%">联系人行业类型</th>
					<td width="25%"><input class="easyui-validatebox"
						name="linkmanIndustryType"
						value="${naturalApp.linkmanIndustryType}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="linkmanIndustryType" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">联系人单位名称</th>
					<td width="25%"><input class="easyui-validatebox"
						name="linkmanCompany" value="${naturalApp.linkmanCompany}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="linkmanCompany" /></td>
					<th align="center" width="25%">联系人职务</th>
					<td width="25%"><input class="easyui-validatebox"
						name="linkmanPosition" value="${naturalApp.linkmanPosition}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="linkmanPosition" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">联系人单位地址</th>
					<td width="25%"><input class="easyui-validatebox"
						name="linkmanCompAddr" value="${naturalApp.linkmanCompAddr}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="linkmanCompAddr" /></td>
					<th align="center" width="25%">联系人单位地址邮编</th>
					<td width="25%"><input class="easyui-validatebox"
						name="linkmanCompZip" value="${naturalApp.linkmanCompZip}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="linkmanCompZip" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">联系人手机号码</th>
					<td width="25%"><input class="easyui-validatebox"
						name="linkmanMobile" value="${naturalApp.linkmanMobile}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="linkmanMobile" /></td>
					<th align="center" width="25%">联系人固定电话</th>
					<td width="25%"><input class="easyui-validatebox"
						name="linkmanHomePhone" value="${naturalApp.linkmanHomePhone}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="linkmanHomePhone" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">联系人电子邮箱</th>
					<td width="25%"><input class="easyui-validatebox"
						name="linkmanEmail" value="${naturalApp.linkmanEmail}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="linkmanEmail" /></td>
					<th align="center" width="25%">保证人名称</th>
					<td width="25%"><input class="easyui-validatebox"
						name="guarantee" value="${naturalApp.guarantee}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="guarantee" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">法定代表人</th>
					<td width="25%"><input class="easyui-validatebox"
						name="guarLegalPerson" value="${naturalApp.guarLegalPerson}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="guarLegalPerson" /></td>
					<th align="center" width="25%">营业执照号码</th>
					<td width="25%"><input class="easyui-validatebox"
						name="guarBusiLicenseNo" value="${naturalApp.guarBusiLicenseNo}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="guarBusiLicenseNo" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">公司地址</th>
					<td width="25%"><input class="easyui-validatebox"
						name="guarCompAddr" value="${naturalApp.guarCompAddr}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="guarCompAddr" /></td>
					<th align="center" width="25%">公司设立日期</th>
					<td width="25%"><input class="easyui-validatebox"
						dateFormat="date" name="guarCompOpenDate"
						value="${naturalApp.guarCompOpenDate}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="guarCompOpenDate" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">注册资本</th>
					<td width="25%"><input class="easyui-validatebox"
						name="guarCapital" value="${naturalApp.guarCapital}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="guarCapital" /></td>
					<th align="center" width="25%">联系电话</th>
					<td width="25%"><input class="easyui-validatebox"
						name="guarPhone" value="${naturalApp.guarPhone}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="guarPhone" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">物质种类</th>
					<td width="25%"><input class="easyui-validatebox"
						name="hostageType" value="${naturalApp.hostageType}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="hostageType" /></td>
					<th align="center" width="25%">信用等级</th>
					<td width="25%"><input class="easyui-validatebox"
						name="guarCreditRate" value="${naturalApp.guarCreditRate}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="guarCreditRate" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">物质所有人</th>
					<td width="25%"><input class="easyui-validatebox"
						name="hostageOwner" value="${naturalApp.hostageOwner}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="hostageOwner" /></td>
					<th align="center" width="25%">物质号码</th>
					<td width="25%"><input class="easyui-validatebox"
						name="hostageNo" value="${naturalApp.hostageNo}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="hostageNo" /></td>
				</tr>
				<tr>

					<th align="center" width="25%">保证金账户</th>
					<td width="25%"><input class="easyui-validatebox"
						name="depositAccount" value="${naturalApp.depositAccount}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="depositAccount" /></td>
					<th align="center" width="25%">贷款产品</th>
					<td width="25%"><input class="easyui-validatebox"
						name="loanProduct" value="${naturalApp.loanProduct}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="loanProduct" /></td>
				</tr>

				<tr>

					<th align="center" width="25%">贷款申请金额</th>
					<td width="25%"><input class="easyui-validatebox"
						name="loanAmount" value="${naturalApp.loanAmount}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="loanAmount" /></td>
					<th align="center" width="25%">贷款用途</th>
					<td width="25%"><input class="easyui-validatebox"
						name="loanUse" value="${naturalApp.loanUse}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="loanUse" /></td>
				</tr>
				<tr>

					<th align="center" width="25%">贷款周期</th>
					<td width="25%"><input class="easyui-validatebox"
						name="loanCycle" value="${naturalApp.loanCycle}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="loanCycle" /></td>
					<th align="center" width="25%">放款账户</th>
					<td width="25%"><input class="easyui-validatebox"
						name="lendAccount" value="${naturalApp.lendAccount}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="lendAccount" /></td>
				</tr>
				<tr>

					<th align="center" width="25%">还款方式</th>
					<td width="25%"><input class="easyui-validatebox"
						name="payMethod" value="${naturalApp.payMethod}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="payMethod" /></td>
					<th align="center" width="25%">还款账户</th>
					<td width="25%"><input class="easyui-validatebox"
						name="payAccount" value="${naturalApp.payAccount}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="payAccount" /></td>
				</tr>
				<tr>
					<td colspan="4" align="center"><input type="button" value="保存"
						class="btn" onclick="saveObjApp();" /> <input type="button"
						value="清空" class="btn" onclick="clearNaturalApp();" /> <%-- <input type="hidden" name="appNo" value="${naturalApp.appNo}" />  --%>
						<%-- 		<input type="hidden" name="flag" value="${flag}"></td> --%>
				</tr>

			</table>
		</form>
	</div>
</body>