<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
<!--
function backUserList() {
	var currTab = $('#mainTabs').tabs('getSelected');
	$('#mainTabs').tabs('update', {
		tab : currTab,
		options : {
			href : '${path}menu/userList.do' // the new content URL
		}
	});
}

function saveUserObj() {
	$('#form1').form('submit', {
	   url : '${path}user/modifyUser.do',
	   success : function(result) {
		  try {
				var r = $.parseJSON(result);
				
                if (r.success) {
						$.messager.alert('信息提示', r.msg, "info", backList);
					}else{
					   $.messager.alert('信息提示', r.msg, "info");
					}
				} catch (e) {
					$.messager.alert('信息提示', result, "info");
				}
			}
		});
}
//-->
</script>
<div id="updatePanel" class="easyui-panel" title="修改用户"
	data-options="border:false,fit:true"
	style="padding-left: 2px; padding-right: 2px; padding-bottom: 1px; padding-top: 2px;">
	<form id="form1" method="post">
		<table id="update" class="modifytable" width="100%">
			<tr>
				<th align="center" width="35%">&nbsp &nbsp登录名</th>
				<td><input id ="loginId" class="easyui-validatebox" name="loginId"
					validType="length[1,10]" data-options="required:true"
					value="${users.loginId}" style="width: 400px" /><span id="loginId_id_span">${users.loginId}</span></td>
			</tr>
			<tr>
				<th align="center" width="35%">姓名</th>
				<td><input class="easyui-validatebox" name="name"
					style="width: 400px" validType="length[1,50]" data-options="required:true" value="${users.name}" /></td>
			</tr>
			<tr>
				<th align="center" width="35%">描述</th>
				<td><input class="easyui-validatebox" name="description"
					style="width: 400px"validType="length[1,100]" value="${users.description}" /></td>
			</tr>			
            <tr>
				<th align="center" width="35%">状态</th>
				<td><select  name="status" id="userStatus"
					data-options="required:true" valueField="${users.status}"
					editable="false" style="width: 400px">
				</select></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="button" value="保存" class="btn" onclick="saveUserObj();" />
			    <input type="button" value="返回" class="btn" onclick="backUserList();" />
                <input type="hidden" name="userId" value="${users.userId}" />  
				<input type="hidden" name="flag" value="${flag}"></td>
			</tr>
		</table>
	</form>
</div>