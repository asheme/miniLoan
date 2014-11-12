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
<title>contract view </title>
<script type="text/javascript">
$(function() {
	$("#loanStartTime").datebox();
	$("#loanFinishTime").datebox();
	$("input[dateFormat='date']").each(function(){				
		var time=dateToStr($(this).val());
		$(this).datebox('setValue',time);
	});
});


function getDate(date){
	return date;
}

</script>
</head>
<body>
<div id="updatePanel" class="easyui-panel"
	data-options="border:false,fit:true"
	style="padding-left: 2px; padding-right: 2px; padding-bottom: 1px; padding-top: 2px;">
	<form id="modifyForm" enctype="multipart/form-data" method="post">
		<table class="modifytable" width="100%">
			<tr>
					<th align="center" width="25%">申请编号</th>
					<td width="25%">${loanInfo.appNo}</td>
					<th align="center" width="25%">贷款合同号</th>
					<td width="25%">${loanInfo.loanContractNo}</td>
				</tr>
				<tr>
					<th align="center" width="25%">贷款金额</th>
					<td width="25%">loanInfo.loanAmount}</td>
					<th align="center" width="25%">贷款周期</th>
					<td width="25%">${loanInfo.loanCycle}</td>
				</tr>
				<tr>
					<th align="center" width="25%">贷款利率</th>
					<td width="25%">${loanInfo.loanRate}</td>
					<th align="center" width="25%">放款方式</th>
					<td width="25%">${loanInfo.offerMethod}</td>
				</tr>
				<tr>
					<th align="center" width="25%">还款方式</th>
					<td width="25%">${loanInfo.payMethod}</td>
					<th align="center" width="25%">罚息执行利率</th>
					<td width="25%">${loanInfo.interestPenalty}</td>
				</tr>
				<tr>
					<th align="center" width="25%">滞纳金</th>
					<td width="25%">${loanInfo.overdueFine}</td>
					<th align="center" width="25%">贷款利息</th>
					<td width="25%">${loanInfo.loanInterest}></td>
				</tr>
				<tr>
					<th align="center" width="25%">贷款开始时间</th>
					<td width="25%">${loanInfo.loanStartTime}</td>
					<th align="center" width="25%">贷款开始时间</th>
					<td width="25%">${loanInfo.loanFinishTime}</td>
				</tr>
				
				<tr>
					<th align="center" width="25%">合同附件</th>
					<td colspan="3"><a href="${pageContext.request.contextPath}/loan/download.do?contractName=${loanInfo.contractName}&contractPhysicalName=${loanInfo.contractPhysicalName}">${loanInfo.contractName}</a></td>
				</tr>
				

		</table>
	</form>
</div>
</body>
</html>