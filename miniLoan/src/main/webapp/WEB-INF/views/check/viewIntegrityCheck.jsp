<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>view Integrity Check</title>
<script type="text/javascript">
<!--
$(function() {
	
});
//-->
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit : true,border : false">
		<div data-options="region:'center',title:'完整性检查结果',border:false"
			style="overflow: hidden; padding-left: 1px; padding-right: 1px; padding-bottom: 1px; padding-top: 1px;"
			align="center">
			<form id="inteCheckForm">
				<table class="queryTable" width="100%">
					<c:forEach items="${integrityCheckList}" var="inteCheckExtend"
						varStatus="index">
						<tr>
							<th align="center" width="10%">${index.count}</th>
							<td width="60%">${inteCheckExtend.itemDesc}</td>
							<td width="30%">
								<c:if test="${inteCheckExtend.result eq 'Y'}">
									是
								</c:if>
								<c:if test="${inteCheckExtend.result eq 'N'}">
									否
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</table>
			</form>
		</div>
	</div>
</body>
</html>