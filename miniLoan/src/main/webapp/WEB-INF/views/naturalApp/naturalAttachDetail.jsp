<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>view natural attach list</title>
<script type="text/javascript">

	$(function() {
		$('#datagrid').datagrid({
			url : '${pageContext.request.contextPath}/natural/attach/naturalAttachList.do?appNo=${appNo}',
			fit : true,
			fitColumns : true,
			striped : true,
			border : false,
			pagination : true,
			idField : 'fileNo',
			height:100,
			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50 ],
			sortName : 'fileNo',
			sortOrder : 'ASC',
			checkOnSelect : false,
			selectOnCheck : false,
			rownumbers : true,
			nowrap : false,
			columns : [ [ {
				field : 'appNo',
				title : '申请编号',
				width : 20,
				sortable : true
			},{
				field : 'fileName',
				title : '文件名称',
				width : 20,
				sortable : true,
				formatter : function(value,row,index){
					return '<a href="${pageContext.request.contextPath}/corp/attach/download.do?fileName='+row.fileName+'&physicalName='+row.physicalName+'">'+ value+'</a>';
				}
			}, {
				field : 'fileDesc',
				title : '文件描述',
				width : 20,
				sortable : true
			}] ]
		});
		
	});
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit : true,border : false">
		<div data-options="region:'center',border:false"
			style="padding-top: 0px;">
			<table id="datagrid"></table>
		</div>
	</div>
</body>