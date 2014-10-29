<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<%@ page import="com.wealth.miniloan.utils.Constant"%>
<%
	pageContext.setAttribute("naturalType", Constant.APP_TYPE_NATURAL);
	pageContext.setAttribute("corpType", Constant.APP_TYPE_CORP);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>view loan app</title>
<script type="text/javascript">
<!--
	$(function() {
	});

	function backList() {
		window.location.href = '${pageContext.request.contextPath}/menu/queryAppList.do';
	}
//-->
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit : true,border : false">
		<div data-options="region:'center',border : false"
			style="overflow: hidden; padding: 1px;">
			<div id="tabs" class="easyui-tabs"
				data-options="fit:true,border:false">
				<c:choose>
					<c:when test="${appType eq naturalType}">
						<div title="基本信息">
							<iframe id="appIframe" width="100%" height="100%"
								frameborder="no" border="0"
								src="${pageContext.request.contextPath}/natural/app/viewNaturalApp.do?appNo=${appNo}"></iframe>
						</div>
						<div title="征信信息">
							<iframe id="creditIframe" width="100%" height="100%"
								frameborder="no" border="0"
								src="${pageContext.request.contextPath}/natural/credit/viewNaturalCredit.do?appNo=${appNo}"></iframe>
						</div>
						<div title="押品信息">
							<iframe id="mortgageIframe" width="100%" height="100%"
								frameborder="no" border="0"
								src="${pageContext.request.contextPath}/mortgage/showMortgageList.do?appNo=${appNo}"></iframe>
						</div>
						<div title="附件信息">
							<iframe id="attachIframe" width="100%" height="100%"
								frameborder="no" border="0"
								src="${pageContext.request.contextPath}/natural/attach/viewNaturalAttach.do?appNo=${appNo}"></iframe>
						</div>
						<div title="完整性检查信息">
							<iframe id="integrityCheckIframe" width="100%" height="100%"
								frameborder="no" border="0" src="${pageContext.request.contextPath}/integrity/viewIntegrityCheck.do?appNo=${appNo}&appType=${appType}"></iframe>
						</div>
						<div title="交叉检查结果">
							<iframe id="attachIframe" width="100%" height="100%"
								frameborder="no" border="0"
								src="${pageContext.request.contextPath}/manualcheck/app/toCrossCheckResult.do?appNo=${appNo}"></iframe>
						</div>
						<div title="策略结果">
							<iframe id="strategyCheckIframe" width="100%" height="100%"
								frameborder="no" border="0"
								src="${pageContext.request.contextPath}/strategy/viewSysDecisionResult.do?appNo=${appNo}"></iframe>
						</div>
						<div title="审核记录">
							<iframe id="checkResultIframe" width="100%" height="100%"
								frameborder="no" border="0"
								src="${pageContext.request.contextPath}/app/checkresult/viewCheckResultList.do?appNo=${appNo}"></iframe>
						</div>
					</c:when>
					<c:when test="${appType eq corpType}">
						<div title="基本信息">
							<iframe id="appIframe" width="100%" height="100%"
								frameborder="no" border="0"
								src="${pageContext.request.contextPath}/corp/app/viewCorpApp.do?appNo=${appNo}"></iframe>
						</div>
						<div title="征信信息">
							<iframe id="creditIframe" width="100%" height="100%"
								frameborder="no" border="0"
								src="${pageContext.request.contextPath}/corp/credit/viewCorpCredit.do?appNo=${appNo}"></iframe>
						</div>
						<div title="企业股东信息">
							<iframe id="shareHolderIframe" width="100%" height="100%"
								frameborder="no" border="0"
								src="${pageContext.request.contextPath}/corp/shareholder/showShareholderList.do?appNo=${appNo}"></iframe>
						</div>
						<div title="押品信息">
							<iframe id="mortgageIframe" width="100%" height="100%"
								frameborder="no" border="0"
								src="${pageContext.request.contextPath}/mortgage/showMortgageList.do?appNo=${appNo}"></iframe>
						</div>
						<div title="附件信息">
							<iframe id="attachIframe" width="100%" height="100%"
								frameborder="no" border="0"
								src="${pageContext.request.contextPath}/corp/attach/viewCorpAttach.do?appNo=${appNo}"></iframe>
						</div>
						<div title="完整性检查信息">
							<iframe id="integrityCheckIframe" width="100%" height="100%"
								frameborder="no" border="0" src="${pageContext.request.contextPath}/integrity/viewIntegrityCheck.do?appNo=${appNo}&appType=${appType}"></iframe>
						</div>
						<%-- <div title="交叉检查结果">
							<iframe id="attachIframe" width="100%" height="100%"
								frameborder="no" border="0"
								src="${pageContext.request.contextPath}/manualcheck/app/toCrossCheckResult.do?appNo=${appNo}"></iframe>
						</div> --%>
						<div title="策略结果">
							<iframe id="strategyCheckIframe" width="100%" height="100%"
								frameborder="no" border="0"
								src="${pageContext.request.contextPath}/strategy/viewSysDecisionResult.do?appNo=${appNo}"></iframe>
						</div>
						<div title="审核记录">
							<iframe id="checkResultIframe" width="100%" height="100%"
								frameborder="no" border="0"
								src="${pageContext.request.contextPath}/app/checkresult/viewCheckResultList.do?appNo=${appNo}"></iframe>
						</div>
					</c:when>
				</c:choose>
			</div>
		</div>
		<div data-options="region:'south',border : false,collapsible:false"
			style="overflow: hidden; padding: 1px; height: 40px;">
			<form id="submitForm" method="post">
				<table class="modifytable" width="100%" height="100%">
						<tr>
						<td colspan="2" align="center"><input type="button"
							value="返回列表" class="btn" onclick="backList();" />
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>