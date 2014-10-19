<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>loan corp attach list</title>
<script type="text/javascript">
	$(function() {
		$('#datagridcheck').datagrid({
			url : '${pageContext.request.contextPath}/app/checkresult/checkResultList.do?appNo=${appNo}',
			fit : true,
			fitColumns : true,
			striped : true,
			border : false,
			pagination : true,
			idField : 'checkId',
			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50 ],
			sortName : 'checkId',
			sortOrder : 'ASC',
			checkOnSelect : false,
			selectOnCheck : false,
			rownumbers : true,
			nowrap : false,
			columns : [ [ {
				field : 'checkId',
				title : '编号',
				width : 10,
				sortable : true
			}, {
				field : 'appNo',
				title : '申请编号',
				width : 20,
				sortable : true
			}, {
				field : 'previousStep',
				title : '上一步骤',
				width : 20,
				sortable : true,
				formatter:function(value){
					return getStepDesc(value);
					}
			}, {
				field : 'currStep',
				title : '当前步骤',
				width : 20,
				sortable : true,
				formatter:function(value){
					return getStepDesc(value);
					} 
			}, {
				field : 'finishTime',
				title : '提交时间',
				width : 20,
				sortable : true
			}, {
				field : 'status',
				title : '状态',
				width : 20,
				sortable : true,
				formatter:function(value){
					return getDictItem("STEP_STATUS", value);
					}
			}, {
				field : 'handler',
				title : '操作员',
				width : 20,
				sortable : true
			}, {
				field : 'checkDesc',
				title : '情况说明',
				width : 20,
				sortable : true
			}
			]]
		});
	});
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit : true,border : false">
		<div data-options="region:'center',border:false"
			style="padding-top: 0px;">
			<table id="datagridcheck"></table>
		</div>
	</div>
</body>