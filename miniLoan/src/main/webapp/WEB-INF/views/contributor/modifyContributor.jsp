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
<title>create or modify contributor</title>
<script type="text/javascript">
$(function() {
	initComboboxContent("idType", "ID_TYPE");
	
	if ($("input[name='flag']").val() == "ADD") {
		$('#updatePanel').panel({
			title : '添加出资人信息'
		});
	} else {
		$('#updatePanel').panel({
			title : '修改出资人信息'
		});
	} 
});
	//返回列表页
	function backList() {
		window.location.href = '${pageContext.request.contextPath}/menu/contributorList.do';
	}
	
	//保存信息
	function saveObj() {
		var url='${pageContext.request.contextPath}/contributor/modifyContributor.do';
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
	<div id="updatePanel" class="easyui-panel" title="出资人信息"
		data-options="border:false,fit:true"
		style="padding-left: 2px; padding-right: 2px; padding-bottom: 1px; padding-top: 2px;">
		<form id="modifyForm" method="post">
			<table class="modifytable" width="100%">
				<tr>
					<th align="center" width="25%">证件类型</th>
					<td width="25%"><input class="easyui-validatebox"
						name="idType" value="${contributorInfo.idType}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="idType" /></td>
					<th align="center" width="25%">证件号</th>
					<td width="25%"><input class="easyui-validatebox" name="idNo"
						value="${contributorInfo.idNo}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="idNo" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">姓名</th>
					<td width="25%"><input class="easyui-validatebox" name="name"
						value="${contributorInfo.name}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="name" /></td>
					<th align="center" width="25%">手机号</th>
					<td width="25%"><input class="easyui-validatebox" name=mobile
						value="${contributorInfo.mobile}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="mobile" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">邮箱</th>
					<td width="25%"><input class="easyui-validatebox" name="email"
						value="${contributorInfo.email}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="email" /></td>
					<th align="center" width="25%">家庭电话</th>
					<td width="25%"><input class="easyui-validatebox" name="homePhone"
						value="${contributorInfo.homePhone}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="homePhone" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">地址</th>
					<td width="25%"><input class="easyui-validatebox" name="addr"
						value="${contributorInfo.addr}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="addr" /></td>
					<th align="center" width="25%">状态</th>
					<td width="25%"><input class="easyui-validatebox" name="status"
						value="${contributorInfo.status}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="status" /></td>
				</tr>

				<tr>
					<td colspan="4" align="center"><input type="button" value="保存"
						class="btn" onclick="saveObj();" /> <input type="button"
						value="返回" class="btn" onclick="javascript:backList();" /> <input
						type="hidden" name="contributorId" value="${contributorInfo.contributorId}" /> 
						 <input type="hidden" name="flag" value="${flag}"></td>
				</tr>

			</table>
		</form>
	</div>
</body>