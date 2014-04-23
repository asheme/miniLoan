<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
<!--
function backRoleList() {
	var currTab = $('#mainTabs').tabs('getSelected');
	$('#mainTabs').tabs('update', {
		tab : currTab,
		options : {
			href : '${path}menu/roleList.do' // the new content URL
		}
	});
}

function saveRoleObj(){
	$('#formRoleUpdate').form('submit', {
		url : '${path}role/modifyRole.do',
		success : function(result) {
			try {
				var r = $.parseJSON(result);
				if (r.success) {
					$.messager.alert('信息提示', r.msg, "info", backRoleList);
				}
			} catch (e) {
				$.messager.alert('信息提示', result);
			}
		}
	});
}
//-->
</script>
<div id="updatePanel" class="easyui-panel" 
	data-options="border:false,fit:true"
	style="padding-left: 2px; padding-right: 2px; padding-bottom: 1px; padding-top: 2px;">
	<form id="formRoleUpdate" method="post">
		<table id="update" class="modifytable" width="100%">
			<tr>
				<th align="center" width="35%">角色名称</th>
				<td><input class="easyui-validatebox" name="roleName" id="roleName"
					value="${role.roleName}" data-options="required:true" onchange="checkRoleName()" 
					validType="length[0, 50]" invalidMessage="描述长度不能大于50字符"
					style="width: 400px" /></td>
			</tr>
			<tr>
				<th align="center" width="35%">角色描述</th>
				<td><input class="easyui-validatebox" name="roleDesc"
					value="${role.roleDesc}" data-options="required:true"
					validType="length[0, 100]" invalidMessage="描述长度不能大于100字符"
					style="width: 400px" /></td>
			</tr>
			<tr>
				<th align="center" width="35%">角色状态</th>
				<td><select  name="status" id="statusRole"
					data-options="required:true" valueField="${role.status}" panelHeight='auto'
					editable="false" style="width: 400px">
				</select></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button" value="保存"
					class="btn" onclick="saveRoleObj();" /> <input type="button"
					value="返回" class="btn" onclick="backRoleList();" /> <input
					type="hidden" name="roleId" value="${role.roleId}"/> <input
					type="hidden" name="flag" value="${flag}"/></td>
			</tr>
		</table>
	</form>
</div>
