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
<title>revalue mortgage</title>
<script type="text/javascript">
<!--
//返回列表页
function backList() {
	window.location.href = '${pageContext.request.contextPath}/mortgage/toRevalueMortgageList.do?appNo=${mortgageInfo.appNo}';
}

//保存信息
function saveObj() {
	var url='${pageContext.request.contextPath}/mortgage/revalueMortgage.do';
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
//-->
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
				<td width="25%">${mortgageInfo.mortgagor}</td>
				<th align="center" width="25%">抵押人证件类型</th>
				<td width="25%">${mortgageInfo.mortgagorIdType}</td>
				</tr>
				<tr>
					<th align="center" width="25%">抵押人证件号码</th>
					<td width="25%">${mortgageInfo.mortgagorIdNo}</td>
					<th align="center" width="25%">抵押人联系电话</th>
					<td width="25%">${mortgageInfo.mortgagorPhone}</td>
				</tr>
				<tr>
					<th align="center" width="25%">法定代表人</th>
					<td width="25%">${mortgageInfo.legalPerson}</td>
					<th align="center" width="25%">地址</th>
					<td width="25%">${mortgageInfo.mortgageAddr}</td>
				</tr>
				<tr>
					<th align="center" width="25%">抵押物名称</th>
					<td width="25%">${mortgageInfo.mortgageName}</td>
					<th align="center" width="25%">产权证编号</th>
					<td width="25%">${mortgageInfo.certificationNo}</td>
				</tr>
				<tr>
					<th align="center" width="25%">抵押物位置</th>
					<td width="25%">${mortgageInfo.mortgageLocation}</td>
					<th align="center" width="25%">面积、数量</th>
					<td width="25%">${mortgageInfo.mortgageArea}</td>
				</tr>
				<tr>
					<th align="center" width="25%">购置日期</th>
					<td width="25%">${mortgageInfo.buyDate}</td>
					<th align="center" width="25%">原值</th>
					<td width="25%">${mortgageInfo.oldValue}</td>
				</tr>
				<tr>
					<th align="center" width="25%">现状</th>
					<td width="25%">${mortgageInfo.status}</td>
					<th align="center" width="25%">现值</th>
					<td width="25%"><input class="easyui-validatebox"
						name="currValue" value="${mortgageInfo.currValue}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="currValue" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">评估建议</th>
					<td colspan="3"><textarea rows="3" cols="60" name="estDesc" id="estDesc">${mortgageInfo.estDesc}</textarea></td>
				</tr>
				<tr>
					<td colspan="4" align="center"><input type="button" value="保存"
						class="btn" onclick="saveObj();" /> <input type="button"
						value="返回" class="btn" onclick="javascript:backList();" /> <input
						type="hidden" name="appNo" value="${mortgageInfo.appNo}" /> <input
						type="hidden" name="mortgageId"
						value="${mortgageInfo.mortgageId}" /> <input type="hidden"
						name="flag" value="${flag}"></td>
				</tr>
			</table>
		</form>
	</div>
</body>