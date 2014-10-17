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
<title>view corp credit info</title>
<script type="text/javascript">
<!--
	$(function() {
		
	});
//-->	
</script>
</head>
<body>
	<div id="updatePanel" class="easyui-panel"
		data-options="border:false,fit:true"
		style="padding-left: 2px; padding-right: 2px; padding-bottom: 1px; padding-top: 2px;">
		<form id="modifyForm" method="post">
			<table class="modifytable" width="100%">
				<tr>
					<th align="center" width="25%">注册资金</th>
					<td width="25%">${corpCredit.regCapital}</td>
					<th align="center" width="25%">出资人数</th>
					<td width="25%">${corpCredit.subscriptionNumber}</td>
				</tr>
				<tr>
					<th align="center" width="25%">由资产管理公司处置的债务余额</th>
					<td width="25%">${corpCredit.debtByAmcAmount}</td>
					<th align="center" width="25%">由资产管理公司处置的债务欠息笔数</th>
					<td width="25%">${corpCredit.debtInterestCountByAmc}</td>
				</tr>

				<tr>
					<th align="center" width="25%">由资产管理公司处置的债务欠息余额</th>
					<td width="25%">${corpCredit.debtInterestAmountByAmc}</td>
					<th align="center" width="25%">由资产管理公司处置的债务垫款笔数</th>
					<td width="25%">${corpCredit.cashAdvCountByAmc}</td>
				</tr>
				<tr>
					<th align="center" width="25%">由资产管理公司处置的债务垫款余额</th>
					<td width="25%">${corpCredit.cashAdvAmountByAmc}</td>
					<th align="center" width="25%">正常类贷款笔数</th>
					<td width="25%">${corpCredit.normalLoansCount}</td>
				</tr>
				<tr>
					<th align="center" width="25%">正常类贷款余额</th>
					<td width="25%">${corpCredit.normalLoansAmount}</td>
					<th align="center" width="25%">关注类贷款笔数</th>
					<td width="25%">${corpCredit.specMentionLoansCount}</td>
				</tr>
				<tr>
					<th align="center" width="25%">关注类贷款余额</th>
					<td width="25%">${corpCredit.specMentionLoansAmount}</td>
					<th align="center" width="25%">不良类贷款笔数</th>
					<td width="25%">${corpCredit.badLoansCount}</td>
				</tr>
				<tr>
					<th align="center" width="25%">不良类贷款余额</th>
					<td width="25%">${corpCredit.badLoansAmount}</td>
					<th align="center" width="25%">&nbsp;</th>
					<td width="25%">&nbsp;</td>
				</tr>

			</table>
		</form>
	</div>
</body>