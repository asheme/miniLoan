<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cross check</title>
<script type="text/javascript">
	
</script>
</head>
<body>
	<div class="easyui-panel" data-options="border:false,fit:true"
		title="交叉检测结果"
		style="padding-left: 2px; padding-right: 2px; padding-bottom: 1px; padding-top: 2px;">
		<table class="modifytable" width="100%" height="100%">
			<tr>
				<th align="center" width="10%">检查项编码</th>
				<th align="center" width="10%">检查项类型</th>
				<th align="center" width="50%">检查项描述</th>
				<th align="center" width="10%">是否触发</th>
				<th align="center" width="20%">检查时间</th>
			</tr>
			<c:forEach var="result" items="${checkResult}">
				<c:choose>
					<c:when test="${result.checkResult=='是'}">
						<tr style="color: red">
							<td width="10%">${result.itemCode}</td>
							<td width="10%">${result.itemType}</td>
							<td width="50%">${result.itemDesc}</td>
							<td width="10%">${result.checkResult}</td>
							<td width="20%">${result.opTime}</td>
						</tr>
					</c:when>
					<c:otherwise>
						<tr>
							<td width="10%">${result.itemCode}</td>
							<td width="10%">${result.itemType}</td>
							<td width="50%">${result.itemDesc}</td>
							<td width="10%">${result.checkResult}</td>
							<td width="20%">${result.opTime}</td>
						</tr>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</table>
	</div>
</body>
</html>