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
<title>create or modify natural attach</title>
<script type="text/javascript">
$(function() {
	initComboboxContent("idType", "ID_TYPE");
	
	if ($("input[name='flag']").val() == "ADD") {
		$('#updatePanel').panel({
			title : '添加名单信息'
		});
	} else {
		$('#updatePanel').panel({
			title : '修改名单信息'
		});
	} 
});
	//返回列表页
	function backList() {
		window.location.href = '${pageContext.request.contextPath}/blacknames/toGetNameList.do?nameType=02';
	}
	
	//保存信息
	function saveObj() {
		var url='${pageContext.request.contextPath}/blacknames/modifyName.do';
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
					<th align="center" width="25%">证件类型</th>
					<td width="25%"><input class="easyui-validatebox"
						name="idType" value="${name.idType}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="idType" /></td>
					<th align="center" width="25%">证件号</th>
					<td width="25%"><input class="easyui-validatebox" name="idNo"
						value="${name.idNo}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="idNo" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">姓名</th>
					<td width="25%"><input class="easyui-validatebox" name="name"
						value="${name.name}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="name" /></td>
					<th align="center" width="25%">手机号</th>
					<td width="25%"><input class="easyui-validatebox" name="phoneNumber"
						value="${name.phoneNumber}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="phoneNumber" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">邮箱</th>
					<td width="25%"><input class="easyui-validatebox" name="email"
						value="${name.email}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="email" /></td>
					<th align="center" width="25%"></th>
					<td width="25%"></td>
				</tr>

				<tr>
					<td colspan="4" align="center"><input type="button" value="保存"
						class="btn" onclick="saveObj();" /> <input type="button"
						value="返回" class="btn" onclick="javascript:backList();" /> <input
						type="hidden" name="nameId" value="${name.nameId}" /> <input
						type="hidden" name="nameType" value="02" /> <input type="hidden"
						name="flag" value="${flag}"></td>
				</tr>

			</table>
		</form>
	</div>
</body>