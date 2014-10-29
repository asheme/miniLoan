<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>the integrity check cfg modify page</title>
<script type="text/javascript">
<!--
	$(function() {
		//初始化combobox
		initComboboxContent("itemType", "INTEGRITY_ITEM_TYPE");
		initComboboxContent("status", "STATUS");
		
		if ($("input[name='flag']").val() == "ADD") {
			$('#updatePanel').panel({
				title : '添加检查项配置'
			});
		} else {
			$('#updatePanel').panel({
				title : '修改检查项配置'
			});
		}
	});

	/*返回列表页*/
	function backList() {
		window.location.href = '${pageContext.request.contextPath}/menu/inteCheckCfgList.do';
	}

	/*保存信息*/
	function saveObj() {
		$('#modifyForm').form(
				'submit',
				{
					url : '${pageContext.request.contextPath}/integrity/cfg/modifyIntegrityCheckItem.do',
					success : function(result) {
						try {
							var r = $.parseJSON(result);
							if (r.success) {
								$.messager.alert('信息提示', r.msg, "info",
										backList);
							}
						} catch (e) {
							$.messager.alert('信息提示', result, "info");
						}
					}
				});
	}
//-->
</script>
</head>
<body>
	<div id="updatePanel" class="easyui-panel"
		data-options="border:false,fit:true"
		style="padding-left: 2px; padding-right: 2px; padding-bottom: 1px; padding-top: 2px;">
		<form id="modifyForm" method="post">
			<table id="update" class="modifytable" width="100%">
				<tr>
					<th align="center" width="35%">检查项名称</th>
					<td><input class="easyui-validatebox" name="itemName"
						data-options="required:true" value="${inteCheckItem.itemName}"
						style="width: 400px" validType="length[1,50]" /></td>
				</tr>

				<tr>
					<th align="center" width="35%">检查项描述</th>
					<td><input class="easyui-validatebox" name="itemDesc"
						data-options="required:true" value="${inteCheckItem.itemDesc}"
						style="width: 400px" validType="length[1,50]" /></td>
				</tr>

				<tr>
					<th align="center" width="35%">检查项类型</th>
					<td><input name="itemType" value="${inteCheckItem.itemType}"
						id="itemType" style="width: 150px"
						data-options="required:true,validType:'emptyString[\'#itemType\']'" /></td>
				</tr>

				<tr>
					<th align="center" width="35%">字典状态</th>
					<td><input name="status" value="${inteCheckItem.status}" id="status"
						style="width: 100px"
						data-options="required:true,validType:'emptyString[\'#status\']'" /></td>
				</tr>

				<tr>
					<td colspan="2" align="center"><input type="button" value="保存"
						class="btn" onclick="saveObj();" /> <input type="button"
						value="返回" class="btn" onclick="backList();" /> <input
						type="hidden" name="itemId" value="${inteCheckItem.itemId}" /> <input
						type="hidden" name="flag" value="${flag}" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>