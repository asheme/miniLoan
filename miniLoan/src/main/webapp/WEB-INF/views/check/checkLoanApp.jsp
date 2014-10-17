<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<%@ page import="com.wealth.miniloan.utils.Constant" %>
<%
	pageContext.setAttribute("naturalType", Constant.APP_TYPE_NATURAL);
	pageContext.setAttribute("corpType", Constant.APP_TYPE_CORP);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>check loan app</title>
<script type="text/javascript">
<!--
	$(function(){
		$('input[name="checkResult"]').each(function(){
			var t=$(this).val();
			if(t=='${checkResult.checkResult}'){
				$(this).attr("checked",true);
				}
		});
	});

	function backList() {
		window.location.href = '${pageContext.request.contextPath}/menu/reCheckList.do';
	}
	
	function submitToInspect() {
		$('#submitForm')
				.form(
						'submit',
						{
							url : '${pageContext.request.contextPath}/recheck/app/submitToInspect.do',
							success : function(result) {
								try {
									var r = $.parseJSON(result);
									if (r.success) {
										$.messager.alert('信息提示', r.msg, "info",
												backList);
									} else {
										$.messager.alert('信息提示', r.msg, "info");
									}
								} catch (e) {
									$.messager.alert('信息提示', result);
								}
							}
						});
	}
//-->
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit : true,border : false">
		<div data-options="region:'center',border : false">
			<div id="tabs" class="easyui-tabs"
				data-options="fit:true,border:false">				
				<c:choose>
					<c:when test="${appType eq naturalType}">
						<div title="基本信息">
							<iframe id="appIframe" width="100%" height="100%" frameborder="no"
								border="0" src="${pageContext.request.contextPath}/natural/app/viewNaturalApp.do?appNo=${appNo}"></iframe>
						</div>
						<div title="征信信息">
							<iframe id="creditIframe" width="100%" height="100%"
								frameborder="no" border="0" src="${pageContext.request.contextPath}/natural/credit/viewNaturalCredit.do?appNo=${appNo}"></iframe>
						</div>					
						<div title="押品信息">
							<iframe id="mortgageIframe" width="100%" height="100%"
								frameborder="no" border="0" src="${pageContext.request.contextPath}/mortgage/showMortgageList.do?appNo=${appNo}"></iframe>
						</div>
						<div title="附件信息">
							<iframe id="attachIframe" width="100%" height="100%"
								frameborder="no" border="0" src="${pageContext.request.contextPath}/natural/attach/viewNaturalAttach.do?appNo=${appNo}"></iframe>
						</div>
						<div title="审核记录">
							<iframe id="checkResultIframe" width="100%" height="100%"
								frameborder="no" border="0" src="${pageContext.request.contextPath}/app/checkresult/viewCheckResultList.do?appNo=${appNo}"></iframe>
						</div>
					</c:when>
					<c:when test="${appType eq corpType}">
						<div title="基本信息">
							<iframe id="appIframe" width="100%" height="100%" frameborder="no"
								border="0" src="${pageContext.request.contextPath}/corp/app/viewCorpApp.do?appNo=${appNo}"></iframe>
						</div>
						<div title="征信信息">
							<iframe id="creditIframe" width="100%" height="100%"
								frameborder="no" border="0" src="${pageContext.request.contextPath}/corp/credit/viewCorpCredit.do?appNo=${appNo}"></iframe>
						</div>					
						<div title="企业股东信息">
							<iframe id="shareHolderIframe" width="100%" height="100%"
								frameborder="no" border="0" src="${pageContext.request.contextPath}/corp/shareholder/showShareholderList.do?appNo=${appNo}"></iframe>
						</div>
						<div title="押品信息">
							<iframe id="mortgageIframe" width="100%" height="100%"
								frameborder="no" border="0" src="${pageContext.request.contextPath}/mortgage/showMortgageList.do?appNo=${appNo}"></iframe>
						</div>
						<div title="附件信息">
							<iframe id="attachIframe" width="100%" height="100%"
								frameborder="no" border="0" src="${pageContext.request.contextPath}/corp/attach/viewCorpAttach.do?appNo=${appNo}"></iframe>
						</div>
						<div title="审核记录">
							<iframe id="checkResultIframe" width="100%" height="100%"
								frameborder="no" border="0" src="${pageContext.request.contextPath}/app/checkresult/viewCheckResultList.do?appNo=${appNo}"></iframe>
						</div>
					</c:when>
				</c:choose>
			</div>
		</div>
		<div data-options="region:'south',border : false,collapsible:false"
			style="overflow: hidden; padding: 1px; height: 200px;">
			<div class="easyui-panel" data-options="border:false,fit:true"
				title="复核结果"
				style="padding-left: 2px; padding-right: 2px; padding-bottom: 1px; padding-top: 2px;">
				<form id="submitForm" method="post">
					<table class="modifytable" width="100%" height="100%">
						<tr>
							<th align="center" width="30%">核查结果</th>
							<td width="35%"><label>通过</label><input type="radio"
								name="checkResult" value="1" checked="checked"></input></td>
							<td width="35%"><label>不通过</label><input type="radio"
								name="checkResult" value="0"></input></td>
						</tr>
						<tr>
							<th align="center" width="30%">审核建议</th>
							<td colspan="2"><textarea rows="3" cols="100"
									name="checkDesc"></textarea></td>
						</tr>
						<tr>
							<td colspan="4" align="center"><input type="button"
								value="提交" class="btn" onclick="submitToInspect();" /> <input
								type="button" value="返回列表" class="btn" onclick="backList();" />
								<input type="hidden" name="appNo" value="${appNo}" /> 
								<input type="hidden" name="appType" value="${appType}" />
								<input type="hidden" name="flag" value="${flag}" />
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
</html>