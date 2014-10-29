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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>strategy check page</title>
<script type="text/javascript">
<!--
	$(function() {
		initComboboxContent("status", "FINAL_CHECK_STATUS");
	});

	function backList() {
		window.location.href = '${pageContext.request.contextPath}/menu/strategyCheckList.do';
	}

	function appApprove() {
		$.messager
				.confirm(
						"信息提示",
						"您确定要提交吗?",
						function(data) {
							if (data) {
								$('#submitForm')
										.form(
												'submit',
												{
													url : '${pageContext.request.contextPath}/strategycheck/app/appApprove.do',
													success : function(result) {
														try {
															var r = $
																	.parseJSON(result);
															if (r.success) {
																$.messager
																		.alert(
																				'信息提示',
																				r.msg,
																				"info",
																				backList);
															} else {
																$.messager
																		.alert(
																				'信息提示',
																				r.msg,
																				"info");
															}
														} catch (e) {
															$.messager.alert(
																	'信息提示',
																	result);
														}
													}
												});
							}
						});
	}
//-->
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit : true,border : false">
		<div data-options="region:'center',border : false"
			style="overflow: hidden; padding: 1px; height: 700px;">
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
						<div title="交叉检查结果">
							<iframe id="attachIframe" width="100%" height="100%"
								frameborder="no" border="0"
								src="${pageContext.request.contextPath}/manualcheck/app/toCrossCheckResult.do?appNo=${appNo}"></iframe>
						</div>
						<div title="策略结果">
							<iframe id="strategyCheckIframe" width="100%" height="100%"
								frameborder="no" border="0"
								src="${pageContext.request.contextPath}/strategycheck/app/toStrategyCheckResult.do?appNo=${appNo}"></iframe>
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
						<%-- <div title="交叉检查结果">
							<iframe id="attachIframe" width="100%" height="100%"
								frameborder="no" border="0"
								src="${pageContext.request.contextPath}/manualcheck/app/toCrossCheckResult.do?appNo=${appNo}"></iframe>
						</div> --%>
						<div title="策略结果">
							<iframe id="strategyCheckIframe" width="100%" height="100%"
								frameborder="no" border="0"
								src="${pageContext.request.contextPath}/strategycheck/app/toStrategyCheckResult.do?appNo=${appNo}"></iframe>
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
	</div>
</body>
</html>