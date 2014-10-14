<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>modify app flow task</title>
<script type="text/javascript">
<!--
	$(function() {
		//初始化combobox
		initComboboxContent("taskType", "TASK_TYPE");
		initComboboxContent("status", "STATUS");
		
		if ($("input[name='flag']").val() == "ADD") {
			$('#updatePanel').panel({
				title : '添加流程'
			});
		} else {
			$('#updatePanel').panel({
				title : '修改流程'
			});
		}
	});

	/*返回列表页*/
	function backList() {
		window.location.href = '${pageContext.request.contextPath}/menu/appFlowList.do';
	}

	/*保存信息*/
	function saveObj() {
		$('#modifyForm').form(
				'submit',
				{
					url : '${pageContext.request.contextPath}/appFlow/modifyAppFlow.do',
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
					<th align="center" width="35%">任务名称</th>
					<td><input class="easyui-validatebox" name="taskName"
						data-options="required:true" value="${appTask.taskName}"
						style="width: 400px" validType="length[1,50]" /></td>
				</tr>
				<tr>
					<th align="center" width="35%">任务描述</th>
					<td><input class="easyui-validatebox" name="taskDesc"
						data-options="required:true" value="${appTask.taskDesc}"
						style="width: 400px" validType="length[1,100]" /></td>
				</tr>
				<tr>
					<th align="center" width="35%">任务编码</th>
					<td><input name="taskNo" value="${appTask.taskNo}"
						id="taskNo" style="width: 150px" validType="length[1,10]" /></td>
				</tr>
				<tr>
					<th align="center" width="35%">任务类型</th>
					<td><input name="taskType" value="${appTask.taskType}" id="taskType"
						style="width: 100px"
						data-options="required:true,validType:'emptyString[\'#taskType\']'" /></td>
				</tr>
				<tr>
					<th align="center" width="35%">任务顺序号</th>
					<td><input name="taskSeq" value="${appTask.taskSeq}" id="taskSeq"
						style="width: 100px" /></td>
				</tr>
				<tr>
					<th align="center" width="35%">状态</th>
					<td><input name="status" value="${appTask.status}" id="status"
						style="width: 100px"
						data-options="required:true,validType:'emptyString[\'#status\']'" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="button" value="保存"
						class="btn" onclick="saveObj();" /> <input type="button"
						value="返回" class="btn" onclick="backList();" /> <input
						type="hidden" name="dictId" value="${appTask.taskId}" /> <input
						type="hidden" name="flag" value="${flag}" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>