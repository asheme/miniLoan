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
<title>create or modify pay record</title>
<script type="text/javascript">
$(function() {
	$("#offerTime").datebox();
	
	$("input[dateFormat='date']").each(function(){				
		var time=dateToStr($(this).val());
		$(this).datebox('setValue',time);
	});
});
	//返回列表页
	function backList() {
		window.location.href = '${pageContext.request.contextPath}/loan/receipt/toLoanReceiptList.do?loanId=${receipt.loanId}';
	}
	
	function getDate(date){
		return date;
	}

	//保存信息
	function saveObj() {
		var url='${pageContext.request.contextPath}/loan/receipt/modifyLoanReceipt.do';
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
					<th align="center" width="25%">放款金额</th>
					<td width="25%"><input class="easyui-validatebox" name="offerAmount"
						value="${receipt.offerAmount}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="offerAmount" /></td>
					<th align="center" width="25%">放款账户</th>
					<td width="25%"><input class="easyui-validatebox"
						name="offerAcct" value="${receipt.offerAcct}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="offerAcct" /></td>
					
				</tr>
				<tr>
					<th align="center" width="25%">放款人</th>
					<td width="25%"><input class="easyui-validatebox"
						name="offerMan" value="${receipt.offerMan}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="offerMan" /></td>
					<th align="center" width="25%">放款款时间</th>
					<td width="25%"><input class="easyui-validatebox"
						dateFormat="date" name="offerTime" value="${receipt.offerTime}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="offerTime" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">借据编号</th>
					<td width="25%"><input class="easyui-validatebox"
						name="receiptNo" value="${receipt.receiptNo}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="receiptNo" /></td>
					<th align="center" width="25%">借据文件</th>
					<td width="25%"><input type="file" name="file" id="file" /></td>
				</tr>
				<tr>
					<td colspan="4" align="center"><input type="button" value="保存"
						class="btn" onclick="saveObj();" /> <input type="button"
						value="清空" class="btn" onclick="clearAll();" /> 
						<input type="hidden" name="loanId" value="${receipt.loanId}" />
						<input type="hidden" name="receiptId" value="${receipt.receiptId}" />
						<input type="hidden" name="flag" value="${flag}"></td>
				</tr>

			</table>
		</form>
	</div>
</body>