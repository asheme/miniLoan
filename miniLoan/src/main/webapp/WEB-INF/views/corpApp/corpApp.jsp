<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>modify corp app info</title>
<script type="text/javascript">
<!--
 	$(function() {
		if($("input[name='flag']").val() == "UPDATE"){
			document.getElementById("creditIframe").src = '${pageContext.request.contextPath}/corp/credit/toModifyCorpCredit.do?appNo=${appNo}';
			document.getElementById("attachIframe").src = '${pageContext.request.contextPath}/corp/attach/toCorpAttachList.do?appNo=${appNo}';
			document.getElementById("shareHolderIframe").src = '${pageContext.request.contextPath}/corp/shareholder/toShareholderList.do?appNo=${appNo}';
			document.getElementById("mortgageIframe").src = '${pageContext.request.contextPath}/mortgage/toMortgageList.do?appNo=${appNo}';
			document.getElementById("checkResultIframe").src = '${pageContext.request.contextPath}/app/checkresult/viewCheckResultList.do?appNo=${appNo}';
		}
		
		$("#tabs").tabs(
						{
							onSelect : function(title,index) {
								if ($("input[name='flag']").val() == "ADD" && index!=0) {
									$.messager
											.alert('信息提示', "请先保存基本信息", "info");
									$("#tabs").tabs("select", 0);
								}
							}
						});
	});

	//保存信息
	function backList() {
		window.location.href = '${pageContext.request.contextPath}/menu/corpAppList.do';
	}

	function submitToNext() {
		$.messager.confirm("信息提示","您确定要提交吗?",function(data){
			if(data){
		$('#submitForm')
				.form(
						'submit',
						{
							url : '${pageContext.request.contextPath}/corp/app/submitApp.do',
							success : function(result) {
								try {
									var r = $.parseJSON(result);
									if (r.success) {
										$.messager.alert('信息提示', r.msg, "info",
												backList);
									}
								} catch (e) {
									$.messager.alert('信息提示', result);
								}
							}
						});
			}});
	}
	
	function submitToFinal() {
		$.messager.confirm("信息提示","您确定要提交吗?",function(data){
			if(data){
		$('#submitForm')
				.form(
						'submit',
						{
							url : '${pageContext.request.contextPath}/corp/app/submitToFinal.do?appNo='
									+ appNo,
							success : function(result) {
								try {
									var r = $.parseJSON(result);
									if (r.success) {
										$.messager.alert('信息提示', r.msg, "info",
												backList);
									}
								} catch (e) {
									$.messager.alert('信息提示', result);
								}
							}
						});
			}});
	}
//-->
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit : true,border : false">
		<div data-options="region:'center',border : false">
			<div id="tabs" class="easyui-tabs"
				data-options="fit : true,border : false">
				<div title="基本信息">
					<iframe id="appIframe" width="100%" height="100%" frameborder="no"
						border="0" src="${pageContext.request.contextPath}/corp/app/toModifyCorpApp.do?flag=${flag}&appNo=${appNo}"></iframe>
				</div>
				<div title="征信信息">
					<iframe id="creditIframe" width="100%" height="100%"
						frameborder="no" border="0"></iframe>
				</div>				
				<div title="企业股东信息">
					<iframe id="shareHolderIframe" width="100%" height="100%"
						frameborder="no" border="0"></iframe>
				</div>
				<div title="押品信息">
					<iframe id="mortgageIframe" width="100%" height="100%"
						frameborder="no" border="0"></iframe>
				</div>
				<div title="附件信息">
					<iframe id="attachIframe" width="100%" height="100%"
						frameborder="no" border="0"></iframe>
				</div>				
				<div title="审核记录">
					<iframe id="checkResultIframe" width="100%" height="100%"
						frameborder="no" border="0"></iframe>
				</div>
			</div>
		</div>
		<div data-options="region:'south',border : false,collapsible:false"
			style="overflow: hidden; padding: 1px; height: 40px;">
			<form id="submitForm" method="post">
				<table class="modifytable" width="100%" height="100%">
					<tr>
						<td colspan="2" align="center"><input type="button" value="直接终审"
							class="btn" onclick="submitToFinal();" /> <input type="button" value="提交"
							class="btn" onclick="submitToNext();" /> <input type="button"
							value="返回列表" class="btn" onclick="backList();" />
							<input name="flag" type="hidden"
							value="${flag}" /> <input name="appNo" type="hidden"
							value="${appNo}" />
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>