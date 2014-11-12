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
<title>create or modify capital info</title>
<script type="text/javascript">
$(function() {
	initComboboxContent("idType", "ID_TYPE");
	$("#capitalDate").datebox();
	$("input[dateFormat='date']").each(function(){				
			var time=dateToStr($(this).val());
			$(this).datebox('setValue',time);
		});
	
	if ($("input[name='flag']").val() == "ADD") {
		$('#updatePanel').panel({
			title : '添加出资信息'
		});
	} else {
		$('#updatePanel').panel({
			title : '修改出资信息'
		});
	} 
});
	//返回列表页
	function backList() {
		window.location.href = '${pageContext.request.contextPath}/capital/toCapitalContrInfoList.do?contributorId=${contributorId}';
	}
	
	//保存信息
	function saveObj() {
		var url='${pageContext.request.contextPath}/capital/modifyCapitalContrInfo.do';
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
	<div id="updatePanel" class="easyui-panel" title="名单信息"
		data-options="border:false,fit:true"
		style="padding-left: 2px; padding-right: 2px; padding-bottom: 1px; padding-top: 2px;">
		<form id="modifyForm" method="post">
			<table class="modifytable" width="100%">
				<tr>
					<th align="center" width="25%">出资金额</th>
					<td width="25%"><input class="easyui-validatebox"
						name="capitalAmount" value="${capitalContrInfo.capitalAmount}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="capitalAmount" /></td>
					<th align="center" width="25%">收益率</th>
					<td width="25%"><input class="easyui-validatebox" name="returnRate"
						value="${capitalContrInfo.returnRate}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="returnRate" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">出资时间</th>
					<td width="25%"><input class="easyui-validatebox" name="capitalDate"
						dateFormat="date" value="${capitalContrInfo.capitalDate}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="capitalDate" /></td>
					<th align="center" width="25%">状态</th>
					<td width="25%"><input class="easyui-validatebox" name="status"
						value="${capitalContrInfo.status}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="status" /></td>
				</tr>
				<tr>
					<td colspan="4" align="center"><input type="button" value="保存"
						class="btn" onclick="saveObj();" /> <input type="button"
						value="返回" class="btn" onclick="javascript:backList();" /> <input
						type="hidden" name="capitalId" value="${capitalContrInfo.capitalId}" /> <input
						type="hidden" name="contributorId" value="${contributorId}" /> <input type="hidden"
						name="flag" value="${flag}"></td>
				</tr>

			</table>
		</form>
	</div>
</body>