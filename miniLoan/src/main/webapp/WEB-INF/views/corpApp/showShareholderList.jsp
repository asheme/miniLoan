<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>view shareholder list</title>
<script type="text/javascript">
<!--
	$(function() {
		$('#datagrid').datagrid({
			url : '${pageContext.request.contextPath}/corp/shareholder/shareholderList.do?appNo=${appNo}',
			fit : true,
			fitColumns : true,
			striped : true,
			border : false,
			pagination : true,
			idField : 'shareholderId',
			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50 ],
			sortName : 'shareholderId',
			sortOrder : 'ASC',
			checkOnSelect : false,
			selectOnCheck : false,
			rownumbers : true,
			nowrap : false,
			columns : [ [ {
				field : 'shareholderId',
				title : '股东编号',
				width : 20,
				checkbox : true
			}, {
				field : 'shareholderName',
				title : '股东名称',
				width : 15,
				sortable : true
			}, {
				field : 'shareRatio',
				title : '占股比例',
				width : 15,
				sortable : true
			}, {
				field : 'relationDesc',
				title : '关联关系说明',
				sortable : true,
				width : 20
			}] ],
			toolbar : '#toolbar'
		});
		
	});
	 
	function viewObj() {
		var rows = $('#datagrid').datagrid('getChecked');
		
		if (rows.length > 0) {
			if (rows.length == 1) {
				window.location.href = '${pageContext.request.contextPath}/corp/shareholder/shareholderShow.do?shareholderId='
						+ rows[0].shareholderId;
			} else {
				$.messager.alert('信息提示', "只能选择一条要修改的记录！", "info");
			}
		} else {
			$.messager.alert('信息提示', "请您选择要修改的记录！", "info");
		}
	}
//-->
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit : true,border : false">
		<div data-options="region:'center',border:false"
			style="padding-top: 0px;">
			<table id="datagrid"></table>
			<div id="toolbar"
				style="height: auto !important; height: 28px; min-height: 28px;">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td><a href="#" class="easyui-linkbutton"
							data-options="iconCls:'icon-ui-edit',plain:true"
							onClick="javascript:viewObj();" style="float: left;">查看</a></td>
						<td>
							<div class="datagrid-btn-separator"></div>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>