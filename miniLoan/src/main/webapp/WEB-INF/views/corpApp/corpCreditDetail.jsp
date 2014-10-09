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
<title>create or modify corp credit application</title>
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
		
		if ($("input[name='flag']").val() == "Add") {
			$('#updatePanel').panel({
				title : '添加申请信息'
			});
		} else {
			$('#updatePanel').panel({
				title : '修改申请信息'
			});
		}
	});
	
	//返回列表页
	function backList() {
		window.location.href = '${pageContext.request.contextPath}/menu/corpAppList.do';
	}
	
	function getDate(date){
		
		return date;
	}
function EditObj()
{
	window.location.href='${pageContext.request.contextPath}/corp/credit/toUpdateCorpCredit.do?appNo=${corpCredit.appNo}';
}


</script>
</head>
<body>
	<div id="updatePanel" class="easyui-panel" title="数据信息"
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

				</tr>

				<td colspan="4" align="center"><input type="button" value="编辑"
					class="btn" onclick="EditObj();" /> <input type="button"
					value="返回" class="btn" onclick="javascript:backList();" /> <input
					type="hidden" name="appNo" value="${corpCredit.appNo}" /> <input
					type="hidden" name="flag" value="${flag}"></td>
				</tr>

			</table>
		</form>
	</div>
</body>