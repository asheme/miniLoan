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
	$("#payTime").datebox();
	
	$("input[dateFormat='date']").each(function(){				
		var time=dateToStr($(this).val());
		$(this).datebox('setValue',time);
	});
});
	//返回列表页
	function backList() {
		window.location.href = '${pageContext.request.contextPath}/pay/record/toPayRecordList.do?loanId=${record.loanId}';
	}
	
	function getDate(date){
		return date;
	}

	//保存信息
	function saveObj() {
		var url='${pageContext.request.contextPath}/pay/record/modifyPayRecord.do';
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
		<form id="modifyForm" method="post">
			<table class="modifytable" width="100%">
				<%-- <tr>
					<th align="center" width="25%">本次还款本金</th>
					<td width="25%"><input class="easyui-validatebox" name="payPrincipal"
						value="${record.payPrincipal}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="payPrincipal" /></td>
					<th align="center" width="25%">本次还款利息</th>
					<td width="25%"><input class="easyui-validatebox"
						name="payInterest" value="${record.payInterest}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="payInterest" /></td>
				</tr> --%>
				<tr>
					<%-- <th align="center" width="25%">本次还款罚息</th>
					<td width="25%"><input class="easyui-validatebox"
						name="payPunitiveInterest" value="${record.payPunitiveInterest}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="payPunitiveInterest" /></td> --%>
					<th align="center" width="25%">本次还款总额</th>
					<td width="25%"><input class="easyui-validatebox" name="payAmount"
						value="${record.payAmount}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="payAmount" /></td>
						<th align="center" width="25%">还款账户</th>
					<td width="25%"><input class="easyui-validatebox"
						name="payAcct" value="${record.payAcct}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="payAcct" /></td>
				</tr>

				<tr>
					
					<th align="center" width="25%">还款人</th>
					<td width="25%"><input class="easyui-validatebox"
						name="payMan" value="${record.payMan}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="payMan" /></td>
						<th align="center" width="25%">还款时间</th>
					<td width="25%"><input class="easyui-validatebox"
						dateFormat="date" name="payTime" value="${record.payTime}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="payTime" /></td>
				</tr>
				<tr>
					<td colspan="4" align="center"><input type="button" value="保存"
						class="btn" onclick="saveObj();" /> <input type="button"
						value="清空" class="btn" onclick="clearAll();" /> 
						<input type="hidden" name="loanId" value="${record.loanId}" />
						<input type="hidden" name="recordId" value="${record.recordId}" />
						<input type="hidden" name="flag" value="${flag}"></td>
				</tr>

			</table>
		</form>
	</div>
</body>