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
	var appNo = "${appNo}";
	var flag = "${flag}";
	var creditflag = "${flag}";//如果只添加了基本信息没有添加征信信息，则由问题
	$(function() {
		if (flag == "UPDATE") {
			document.getElementById("appIframe").src = '${pageContext.request.contextPath}/natural/app/toUpdateNaturalApp.do?appNo='
					+ appNo;
			document.getElementById("creditIframe").src = '${pageContext.request.contextPath}/natural/credit/toUpdateNaturalCredit.do?appNo='
					+ appNo;
		} else {
			document.getElementById("appIframe").src = '${pageContext.request.contextPath}/natural/app/toAddNaturalApp.do';
			document.getElementById("creditIframe").src = '${pageContext.request.contextPath}/natural/credit/toAddNaturalCredit.do';
		}
		document.getElementById("attachIframe").src = '${pageContext.request.contextPath}/natural/attach/toNaturalAttachList.do?appNo='
				+ appNo;
		document.getElementById("mortgageIframe").src = '${pageContext.request.contextPath}/natural/mortgage/toMortgageList.do?appNo='
				+ appNo;
		$("#tabs")
				.tabs(
						{
							onSelect : function(title) {
								if ((title == "征信信息" || title == "附件信息" || title == "抵押物信息")
										&& appNo == "") {
									$.messager
											.alert('信息提示', "请先保存基本信息", "info");
									$("#tabs").tabs("select", 0);
								}
							}
						});
	});

	//保存信息
	function backList() {
		window.location.href = '${pageContext.request.contextPath}/menu/naturalAppList.do';
	}

	function submitToNext() {

		$('#submitForm')
				.form(
						'submit',
						{
							url : '${pageContext.request.contextPath}/natural/app/submitApp.do?appNo='
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
	}
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit : true,border : false">
		<div data-options="region:'center',border : false">
			<div id="tabs" class="easyui-tabs"
				data-options="fit : true,border : false">
				<div title="基本信息">
					<iframe id="appIframe" width="100%" height="100%" frameborder="no"
						border="0"></iframe>
				</div>
				<div title="征信信息">
					<iframe id="creditIframe" width="100%" height="100%"
						frameborder="no" border="0"></iframe>
				</div>
				<div title="附件信息">
					<iframe id="attachIframe" width="100%" height="100%"
						frameborder="no" border="0"></iframe>
				</div>
				<div title="抵押物信息">
					<iframe id="mortgageIframe" width="100%" height="100%"
						frameborder="no" border="0"></iframe>
				</div>
			</div>
		</div>
		<div data-options="region:'south',border : false,collapsible:false"
			style="overflow: hidden; padding: 1px; height: 36px;">
			<form id="submitForm" method="post">
				<table width="100%">
					<tr>
						<td align="center"><input type="button" value="提交审核" class="btn"
							onclick="submitToNext();" /> <input type="button" value="返回列表"
							class="btn" onclick="backList();" /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>