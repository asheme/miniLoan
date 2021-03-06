<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>the mini loan management system</title>
<script type="text/javascript">
<!--  
	function logout(){
		$.messager.confirm('系统提示', '您确定要退出本系统吗?', function(r) {
			if (r) {
				window.location.href='${pageContext.request.contextPath}/exit.do';
			}
		});
	}
	
	function toChangeRole(){
		addTab({
			title : '角色切换',
			iconCls : 'icon-ui-tree-leaf',
			url : '${pageContext.request.contextPath}/role/toChangeRole.do'
		});	
	}
//-->
</script>
</head>
<body class="easyui-layout" oncontextmenu="window.event.returnValue= false;">
	<div id="topLayout" data-options="region:'north'"
		style="overflow: hidden; border: 0; height: 40px;">
		<div class="topbar">
			<div class="content">
				<div class="top_left">
					<a href="#" class="title"><i class="icon-fire"></i> 融益小额信贷管理系统</a>
					<a class='' href='#' tartet='_self'><i class='icon-desktop'></i>快捷栏目</a>
					<a class='this' href='#' tartet='_self'><i class='icon-tasks'></i>快捷栏目</a>
					<a class='' href='#' tartet='_self'><i class='icon-edit'></i>快捷栏目</a>
					<a href='#' target="_blank"><i class='icon-inbox'></i>快捷栏目</a>
				</div>
				<div class="top_right">
					<div>
						<span class="topbar_text">欢迎您&nbsp;&nbsp;<i class='icon-user'></i>${user.name}</span>&nbsp;&nbsp;
					</div>
					<div>
						<span class="topbar_text"><i
							class="icon-flag"></i>${user.currRole.roleName}</span>&nbsp;&nbsp;<span class="topbar_text" style="cursor:pointer" onclick="javascript:logout();">注销用户</span>&nbsp;&nbsp;<span class="topbar_text" style="cursor:pointer" onclick="javascript:toChangeRole();">切换角色</span>&nbsp;&nbsp;
					</div>
					<div>
						<span class="topbar_text">系统日期：${user.lastLoginDateStr}</span>
					</div>
				</div>
				<div style="clear: both"></div>
			</div>
		</div>
	</div>
	<div id="naviLayout"
		data-options="region:'west',title:'功能导航',collapsible:true,split:true,href:'${path}toMenu.do'"
		style="width: 210px; overflow: hidden;"></div>
	<div id="mainLayout"
		data-options="region:'center',title:'欢迎使用融益小额信贷管理系统',href:'${path}toContent.do'"
		style="overflow: auto;"></div>
	<div data-options="region:'south'"
		style="height: 30px; line-height: 30px; text-align: center; vertical-align: middle; overflow: hidden; border: 0; background: #EAEEF5;">
		Copyright ©wealth 2014-2015 www.wealth.cn</div>
</body>
</html>