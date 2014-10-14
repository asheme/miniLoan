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
<title>create or modify natural attach</title>
<script type="text/javascript">

$(function() {
	$("#buyDate").datebox();
	$("input[dateFormat='date']").each(function(){				
		var time=dateToStr($(this).val());
		$(this).datebox('setValue',time);
	});
	
});

//返回列表页
function backList() {
	window.location.href = '${pageContext.request.contextPath}/natural/mortgage/revalueMortgage.do?appNo=${naturalMortgage.appNo}';
}

//保存信息
function saveObj() {
	var url='${pageContext.request.contextPath}/natural/mortgage/modifyNaturalMortgage.do';
	$('#modifyForm').form('submit', {
		url : url,
		success : function(result) {
			try {
				var r = $.parseJSON(result);
				if (r.success) {
					$.messager.alert('信息提示', r.msg, "info", backList);
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

</script>
</head>
<body>
	<div id="updatePanel" class="easyui-panel" title="数据信息"
		data-options="border:false,fit:true"
		style="padding-left: 2px; padding-right: 2px; padding-bottom: 1px; padding-top: 2px;">
		<form id="modifyForm" method="post">
			<table class="modifytable" width="100%">
				<rr>
				<th align="center" width="25%">抵押人</th>
				<td width="25%">${naturalMortgage.mortgagor}</td>
				<th align="center" width="25%">抵押人证件类型</th>
				<td width="25%">${naturalMortgage.mortgagorIdType}</td>
				</tr>
				<tr>
					<th align="center" width="25%">抵押人证件号码</th>
					<td width="25%">${naturalMortgage.mortgagorIdNo}</td>
					<th align="center" width="25%">抵押人联系电话</th>
					<td width="25%">${naturalMortgage.mortgagorPhone}</td>
				</tr>
				<tr>
					<th align="center" width="25%">法定代表人</th>
					<td width="25%">${naturalMortgage.legalPerson}</td>
					<th align="center" width="25%">地址</th>
					<td width="25%">${naturalMortgage.mortgageAddr}</td>
				</tr>
				<tr>
					<th align="center" width="25%">抵押物名称</th>
					<td width="25%">${naturalMortgage.mortgageName}</td>
					<th align="center" width="25%">产权证编号</th>
					<td width="25%">${naturalMortgage.certificationNo}</td>
				</tr>
				<tr>
					<th align="center" width="25%">抵押物位置</th>
					<td width="25%">${naturalMortgage.mortgageLocation}</td>
					<th align="center" width="25%">面积、数量</th>
					<td width="25%">${naturalMortgage.mortgageArea}</td>
				</tr>
				<tr>
					<th align="center" width="25%">购置日期</th>
					<td width="25%">${naturalMortgage.buyDate}</td>
					<th align="center" width="25%">原值</th>
					<td width="25%">${naturalMortgage.oldValue}</td>
				</tr>
				<tr>
					<th align="center" width="25%">现状</th>
					<td width="25%">${naturalMortgage.status}</td>
					<th align="center" width="25%">现值</th>
					<td width="25%"><input class="easyui-validatebox"
						name="currValue" value="${naturalMortgage.currValue}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="currValue" /></td>
				</tr>
				<tr>
					<td colspan="4" align="center"><input type="button" value="保存"
						class="btn" onclick="saveObj();" /> <input type="button"
						value="返回" class="btn" onclick="javascript:backList();" /> <input
						type="hidden" name="appNo" value="${naturalMortgage.appNo}" /> <input
						type="hidden" name="mortgageId"
						value="${naturalMortgage.mortgageId}" /> <input type="hidden"
						name="flag" value="${flag}"></td>
				</tr>
			</table>
		</form>
	</div>
</body>