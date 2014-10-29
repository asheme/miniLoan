<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Integrity Check</title>
<script type="text/javascript">
<!--
$(function() {
	
});

function saveIntegrityCheck(){
	var serialStr=serializeForm();
	
	$.ajax({
		url : '${pageContext.request.contextPath}/integrity/saveIntegrityCheck.do',
		data : {
			inteCheckStr : serialStr,
			appNo : '${appNo}',
			appType : '${appType}'
		},
		type : "POST",
		dataType : 'json',
		success : function(result) {
			$.messager.alert('信息提示',result.msg,"info",	function() {
				window.location.href="${pageContext.request.contextPath}/integrity/toIntegrityCheck.do?appNo=${appNo}&appType=${appType}";				
			});
		}
	});
}

function serializeForm(){
	var values = $("#inteCheckForm").serializeArray();
	var serialStr="";
	
	for (var index = 0; index < values.length; ++index) { 
		if(index>0){
			serialStr += ",";
		}
		serialStr += values[index].name + " : " +values[index].value;
	}
	
	return serialStr;
}
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
							<input name="${inteCheckExtend.itemName}" value="${inteCheckExtend.result}" class="easyui-combobox" data-options="
								editable : false,
								multiple : false,
								valueField: 'value',
								textField: 'label',
								data: [{
									label: '请选择',
									value: ''
								},{
									label: '是',
									value: 'Y'
								},{
									label: '否',
									value: 'N'
								}]" style="width: 200px;"/>
							</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="3" align="center"><input type="button"
							class="btn" value="保存" onclick="saveIntegrityCheck();" />
							<input name="appNo" type="hidden" value="${appNo}" />
							<input name="appType" type="hidden" value="${appType}" />
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>