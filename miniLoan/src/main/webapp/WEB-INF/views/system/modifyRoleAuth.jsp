<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>the role auth modify page</title>
<script type="text/javascript">
<!--
	var roleId = ${role.roleId};
	
	$(function() {
		loadRoleAuth();
	});
	
	//加载模块权限信息
	function loadRoleAuth(){		
		$.messager.progress({ title:'请稍后', msg:'页面加载中...'}); 

		$.ajax({
			type : "GET",	
			url : '${pageContext.request.contextPath}/role/rescAuthList.do?roleId=' + roleId,
			dataType : "json",
			cache:false,
			success : function(result) {
				if (result && result.success) {
					$('#treeRoleAuth').tree({
						animate : true,
						lines : true,
						data:result.data
					});
					
					$.messager.progress('close');					
				} else {
					$.messager.progress('close');
					$.messager.alert('信息提示', result.msg, "error");
				}
			}
		});
	}

	//保存选中的权限
	function saveRoleAuth() {

	}
	
	//返回列表页
	function backList() {
		window.location.href = '${pageContext.request.contextPath}/menu/roleList.do';
	}
//-->
</script>
</head>
<body>
	<div id="roleRescDiv" class="easyui-layout"
		style="width: auto; height: auto; padding: 1px;" title="角色权限"
		ta-options="fit:true,border:false">
		<div data-options="region:'south',split:false"
			style="height: 42px; padding: 1px">
			<table class="modifytable" width="100%">
				<tr>
					<td align="center"><input type="button" class="btn" value="保存"
						onclick="saveRoleAuth();" /> <input type="button" value="返回"
						class="btn" onclick="backList();" /></td>
				</tr>
			</table>
		</div>
		<div data-options="region:'center',title:'角色权限操作'"
			style="padding: 1px; background: #eee;">
			<table class="modifytable" width="100%">
				<tr>
					<td>
						<ul id="treeRoleAuth" class="easyui-tree" checkbox="true"
							animate="true" data-options="parentField : 'pid',lines : true"></ul>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>