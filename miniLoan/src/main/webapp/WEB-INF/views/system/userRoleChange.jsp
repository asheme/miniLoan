<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>change login user current role</title>
<script type="text/javascript">
<!-- 
function changeRole(roleId){
	$.messager.confirm('信息提示','确定要切换到此角色吗？',function(r){
		if(r){
			window.top.location.href="${pageContext.request.contextPath}/changeRole.do?changedRoleId="+roleId;
		}
	});
}
//-->
</script>
</head>
<body>
<div class="easyui-panel" title="当前角色:${user.currRole.roleName }"    
        style="padding:1px;"  data-options="fit:true,border:false">  
	<table id="update" class="modifytable" width="100%">
	  <tr height="30">
		<th width="25%" align="center">角色名称</th>
 		<th width="25%" align="center">角色描述</th>
 		<th width="25%" align="center">操作</th>
	  </tr>
	  <c:forEach items="${roleList}" var="role" varStatus="times">
		 <tr height="30">
			<td align="center">${role.roleName}</td>
			<td id="t3dealResult" align="center">${role.roleDesc}</td>
			<td align="center"><a href="#" onclick="javascript:changeRole(${role.roleId })">[切换]</a></td>
		 </tr>
	  </c:forEach>
	</table>
</div>
</body>
</html>