<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>natural application check</title>
<script type="text/javascript">
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit : true,border : false">
		<div data-options="region:'north',border : false,collapsible:false"
			style="overflow: hidden; padding: 1px; height: 100%;">
			<div class="easyui-panel" data-options="border:false,fit:true"
				title="交叉检测结果"
				style="padding-left: 2px; padding-right: 2px; padding-bottom: 1px; padding-top: 2px;">
				<table class="modifytable" width="100%" height="100%">
					<tr>
						<th align="center" width="10%">1</th>
						<td width="90%">身份证出生日期与申请信息填写生日不符！</td>
					</tr>
					<tr>
						<th align="center" width="10%">2</th>
						<td width="90%">身份证性别与申请信息填写性别不符！</td>
					</tr>
					<tr>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>