<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>create or modify natural attach</title>
<script type="text/javascript">
	//返回列表页
	function backList() {
		window.location.href = '${pageContext.request.contextPath}/corp/shareholder/toShareholderList.do?appNo=${shareholder.appNo}';
	}
	
	function getDate(date){
		
		return date;
	}

	//保存信息
	function saveObj() {
		var url='${pageContext.request.contextPath}/corp/shareholder/modifyShareholder.do';
		$('#modifyForm').form('submit', {
			url : url,
			success : function(result) {
				try {
					var r = $.parseJSON(result);
					if (r.success) {
						$.messager.alert('信息提示', r.msg, "info", backList);
					} else {
						$.messager.alert('信息提示', r.msg, "info");
					}
				} catch (e) {
					$.messager.alert('信息提示', result);
				}
			}
		});
	}

	//检查输入是否有效
	function validate() {
		return true;
	}
</script>
</head>
<body>
	<div id="updatePanel" class="easyui-panel" title="股东信息"
		data-options="border:false,fit:true"
		style="padding-left: 2px; padding-right: 2px; padding-bottom: 1px; padding-top: 2px;">
		<form id="modifyForm" method="post">
			<table class="modifytable" width="100%">
				<tr>
					<th align="center" width="25%">股东名称</th>
					<td width="25%"><input class="easyui-validatebox"
						name="shareholderName" value="${shareholder.shareholderName}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="shareholderName" /></td>
					<th align="center" width="25%">占股比例</th>
					<td width="25%"><input class="easyui-validatebox"
						name="shareRatio" value="${shareholder.shareRatio}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="shareRatio" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">关联关系说明</th>
					<td width="25%"><input class="easyui-validatebox"
						name="relationDesc" value="${shareholder.relationDesc}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="relationDesc" /></td>

				</tr>


				<tr>
					<td colspan="4" align="center"><input type="button" value="保存"
						class="btn" onclick="saveObj();" /> <input type="button"
						value="返回" class="btn" onclick="javascript:backList();" /> <input
						type="hidden" name="appNo" value="${shareholder.appNo}" /> <input
						type="hidden" name="shareholderId"
						value="${shareholder.shareholderId}" /> <input type="hidden"
						name="flag" value="${flag}"></td>
				</tr>

			</table>
		</form>
	</div>
</body>