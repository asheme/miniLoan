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
<title>contract maintain </title>
<script type="text/javascript">
$(function() {
	$("#loanStartTime").datebox();
	$("#loanFinishTime").datebox();
	$("input[dateFormat='date']").each(function(){				
		var time=dateToStr($(this).val());
		$(this).datebox('setValue',time);
	});
});

//返回列表
function backList() {
	window.location.href = '${pageContext.request.contextPath}/menu/loanList.do';
}

function getDate(date){
	return date;
}

//保存信息
function saveObj() {
	var url='${pageContext.request.contextPath}/loan/modifyContract.do';
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

function clearAll() {
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
	<form id="modifyForm" enctype="multipart/form-data" method="post">
		<table class="modifytable" width="100%">
			<tr>
					<th align="center" width="25%">申请编号</th>
					<td width="25%">${loanInfo.appNo}</td>
					<th align="center" width="25%">贷款合同号</th>
					<td width="25%"><input class="easyui-validatebox" name="loanContractNo"
						value="${loanInfo.loanContractNo}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="loanContractNo" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">贷款金额</th>
					<td width="25%"><input class="easyui-validatebox" name="loanAmount"
						value="${loanInfo.loanAmount}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="loanAmount" /></td>
					<th align="center" width="25%">贷款周期</th>
					<td width="25%"><input class="easyui-validatebox" name="loanCycle"
						value="${loanInfo.loanCycle}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="loanCycle" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">贷款利率</th>
					<td width="25%"><input class="easyui-validatebox" name="loanRate"
						value="${loanInfo.loanRate}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="loanRate" /></td>
					<th align="center" width="25%">放款方式</th>
					<td width="25%"><input class="easyui-validatebox" name="offerMethod"
						value="${loanInfo.offerMethod}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="offerMethod" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">还款方式</th>
					<td width="25%"><input class="easyui-validatebox" name="payMethod"
						value="${loanInfo.payMethod}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="payMethod" /></td>
					<th align="center" width="25%">罚息执行利率</th>
					<td width="25%"><input class="easyui-validatebox" name="interestPenalty"
						value="${loanInfo.interestPenalty}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="interestPenalty" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">滞纳金</th>
					<td width="25%"><input class="easyui-validatebox" name="overdueFine"
						value="${loanInfo.overdueFine}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="overdueFine" /></td>
					<th align="center" width="25%">贷款利息</th>
					<td width="25%"><input class="easyui-validatebox" name="loanInterest"
						value="${loanInfo.loanInterest}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="loanInterest" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">贷款开始时间</th>
					<td width="25%"><input class="easyui-validatebox"
						dateFormat="date" name="loanStartTime" value="${loanInfo.loanStartTime}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="loanStartTime" /></td>
					<th align="center" width="25%">贷款开始时间</th>
					<td width="25%"><input class="easyui-validatebox"
						dateFormat="date" name="loanFinishTime" value="${loanInfo.loanFinishTime}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="loanFinishTime" /></td>
				</tr>
				
				<tr>
					<th align="center" width="25%">原合同附件</th>
					<td colspan="3"><a href="${pageContext.request.contextPath}/loan/download.do?contractName=${loanInfo.contractName}&contractPhysicalName=${loanInfo.contractPhysicalName}">${loanInfo.contractName}</a></td>
				</tr>
				<tr>
					<th align="center" width="25%">新合同附件</th>
					<td colspan="3"><input type="file" name="file" id="file" /></td>
				</tr>
			<tr>
				<td colspan="4" align="center"><input type="button" value="保存"
					class="btn" onclick="saveObj();" /> <input type="button"
					value="返回列表" class="btn" onclick="backList();" /> 
					<input type="hidden" name="loanId" value="${loanInfo.loanId}" /></td>
			</tr>

		</table>
	</form>
</div>
</body>
</html>