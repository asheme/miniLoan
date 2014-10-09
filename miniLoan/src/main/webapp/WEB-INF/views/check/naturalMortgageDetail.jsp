<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>loan natural attach list</title>
<script type="text/javascript">
	$(function() {
		$('#datagrid').datagrid({
			url : '${pageContext.request.contextPath}/natural/mortgage/naturalMortgageList.do?appNo=${appNo}',
			fit : true,
			fitColumns : true,
			striped : true,
			border : false,
			pagination : true,
			idField : 'mortgageId',
			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50 ],
			sortName : 'mortgageId',
			sortOrder : 'ASC',
			checkOnSelect : false,
			selectOnCheck : false,
			rownumbers : true,
			nowrap : false,
			columns : [ [ {
				field : 'mortgageId',
				title : '抵押编号',
				width : 20,
				hidden : true
			},
			{
				field:'appNo',
				title:'申请编号',
				width:20
				
			},
			{
				field : 'mortgagor',
				title : '抵押人',
				width : 15,
				sortable : true
			}, {
				field : 'mortgageAddr',
				title : '地址',
				width : 15,
				sortable : true
			}, {
				field : 'buyDate',
				title : '购置日期',
				sortable : true,
				width : 20
			},
			{
				field:'detail',
				title:'详情',
				formatter : function(value, row, index)
				{
				return "<a href=${pageContext.request.contextPath}/natural/mortgage/naturalMortgageShow.do?mortgageId="+row.mortgageId+">详情</a>";
				}
			}
			] ]
			
		});
		
	});
	 
	function addNew() {
		window.location.href = '${pageContext.request.contextPath}/natural/mortgage/toAddNaturalMortgage.do?appNo=${appNo}';
		if (navigator.userAgent.indexOf("MSIE") > 0) {// IE特有回收内存方法
			try {
				CollectGarbage();
			} catch (e) {
			}
		}

	}

	function updateObj() {
		var rows = $('#datagrid').datagrid('getChecked');
		
		if (rows.length > 0) {
			if (rows.length == 1) {
				window.location.href = '${pageContext.request.contextPath}/natural/mortgage/toUpdateNaturalMortgage.do?mortgageId='
						+ rows[0].mortgageId;
			} else {
				$.messager.alert('信息提示', "只能选择一条要修改的记录！", "info");
			}
		} else {
			$.messager.alert('信息提示', "请您选择要修改的记录！", "info");
		}
	}


  
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