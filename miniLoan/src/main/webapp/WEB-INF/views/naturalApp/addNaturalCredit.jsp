<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function AddObj(){
	window.location.href='${pageContext.request.contextPath}/natural/credit/toAddNaturalCredit.do?appNo=${appNo}';
}
</script>
</head>
<body>
	<strong>该人目前无征信记录</strong>
	<input type="button" value="新增" class="btn" onclick="AddObj();" />
	<input type="hidden" name="flag" value="${flag}">
	</td>
</body>
</html>