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
<title>show shareholder info</title>
<script type="text/javascript">
<!--
	//返回列表页
	function backList() {
		window.location.href = '${pageContext.request.contextPath}/corp/shareholder/showShareholderList.do?appNo=${shareholder.appNo}';
	}
//-->
</script>
</head>
<body>
	<div id="updatePanel" class="easyui-panel" title="股东信息"
		data-options="border:false,fit:true"
		style="padding-left: 2px; padding-right: 2px; padding-bottom: 1px; padding-top: 2px;">
		<form id="modifyForm" method="post">
			<table class="modifytable" width="100%">
				<tr>
					<th align="center" width="25%">股东名称</th>
					<td width="25%">${shareholder.shareholderName}</td>
					<th align="center" width="25%">占股比例</th>
					<td width="25%">${shareholder.shareRatio}</td>
				</tr>
				<tr>
					<th align="center" width="25%">关联关系说明</th>
					<td width="25%">${shareholder.relationDesc}</td>
				</tr>
				<tr>
					<td colspan="4" align="center"><input type="button"
						value="返回" class="btn" onclick="javascript:backList();" /> <input
						type="hidden" name="appNo" value="${shareholder.appNo}" /> <input
						type="hidden" name="shareholderId"
						value="${shareholder.shareholderId}" /></td>
				</tr>

			</table>
		</form>
	</div>
</body>