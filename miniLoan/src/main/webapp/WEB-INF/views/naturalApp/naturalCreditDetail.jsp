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
<title>view natural credit</title>
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
					<th align="center" width="25%">是否有证信信息</th>
					<td width="25%">${naturalCredit.hasCreditInfo}</td>
					<th align="center" width="25%">贷记卡帐户总数</th>
					<td width="25%">${naturalCredit.ccCount}</td>
				</tr>
				<tr>
					<th align="center" width="25%">最近3个月内新开信用卡账户数</th>
					<td width="25%">${naturalCredit.newCcIn3mth}</td>
					<th align="center" width="25%">最近一期活跃信用卡账户数</th>
					<td width="25%">${naturalCredit.lastActiveCcCount}</td>
				</tr>
				<tr>
					<th align="center" width="25%">贷记卡最近24个月最大拖欠记录</th>
					<td width="25%">${naturalCredit.maxPastDueIn24mth}</td>
					<th align="center" width="25%">贷记卡12个月内未还最低还款额次数</th>
					<td width="25%">${naturalCredit.notMiniPayCountIn12mth}</td>
				</tr>

				<tr>
					<th align="center" width="25%">贷记卡最近3个月最大拖欠记录</th>
					<td width="25%">${naturalCredit.maxMIn3mth}</td>
					<th align="center" width="25%">贷记卡当前逾期次数</th>
					<td width="25%">${naturalCredit.currPastDueCount}</td>
				</tr>
				<tr>
					<th align="center" width="25%">贷款最近24个月最大拖欠记录</th>
					<td width="25%">${naturalCredit.loanMaxDeliqIn24mth}</td>
					<th align="center" width="25%">贷款当前逾期次数</th>
					<td width="25%">${naturalCredit.loanCurrDeliq}</td>
				</tr>
				<tr>
					<th align="center" width="25%">贷款当前月还款总额</th>
					<td width="25%">${naturalCredit.loanCurrAmount}</td>
					<th align="center" width="25%">贷记卡近3个月M0的次数</th>
					<td width="25%">${naturalCredit.ccM0In3mth}</td>
				</tr>
				<tr>
					<th align="center" width="25%">贷记卡近3个月M1的次数</th>
					<td width="25%">${naturalCredit.ccM1In3mth}</td>
					<th align="center" width="25%">贷记卡近3个月M2和M2+的次数</th>
					<td width="25%">${naturalCredit.ccM2mIn3mth}</td>
				</tr>
				<tr>
					<th align="center" width="25%">贷款近3个月M0的次数</th>
					<td width="25%">${naturalCredit.loanMoIn3mth}</td>
					<th align="center" width="25%">贷款近3个月M1的次数</th>
					<td width="25%">${naturalCredit.loanM1In3mth}</td>
				</tr>
				<tr>
					<th align="center" width="25%">贷款近3个月M2和M2+的次数</th>
					<td width="25%">${naturalCredit.loanM2mIn3mth}</td>
					<th align="center" width="25%">近6个月同时发生贷记卡和消费信贷逾期的次数</th>
					<td width="25%">${naturalCredit.ctransOrLoanIn6mth}</td>
				</tr>
				<tr>
					<th align="center" width="25%">累计逾期次数</th>
					<td width="25%">${naturalCredit.pastDueTimes}</td>
					<th align="center" width="25%">最高逾期数</th>
					<td width="25%">${naturalCredit.highestDelinquencyCycle}</td>
				</tr>
				<tr>
					<th align="center" width="25%">逾期信用余额</th>
					<td width="25%">${naturalCredit.amountOfDelinquency}</td>
					<th align="center" width="25%">&nbsp;</th>
					<td width="25%">&nbsp;</td>
				</tr>
			</table>
		</form>
	</div>
</body>