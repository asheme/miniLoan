<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>loan app check list</title>
<script type="text/javascript">
<!--
	$(function() {
		$('#datagrid').datagrid({
			url : '${pageContext.request.contextPath}/recheck/app/recheckAppList.do',
			fit : true,
			fitColumns : true,
			striped : true,
			border : false,
			pagination : true,
			idField : 'appNo',
			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50 ],
			sortName : 'appNo',
			sortOrder : 'ASC',
			checkOnSelect : false,
			selectOnCheck : false,
			rownumbers : true,
			nowrap : false,
			columns : [ [ {
				field : 'appNo',
				checkbox : true
			},{
				field : 'appType',
				title : '申请类型',
				width : 10,
				sortable : true,
				formatter : function(value, row, index) {
					return getDictItem("APP_TYPE", value);
				}
			},  {
				field : 'name',
				title : '借款人(公司名)',
				width : 20,
				sortable : true
			}, {
				field : 'addr',
				title : '申请人（公司）地址',
				width : 30,
				sortable : true
			}, {
				field : 'enterTime',
				title : '进件时间',
				width : 10,
				sortable : true
			}, {
				field : 'status',
				title : '当前状态',
				sortable : true,
				width : 10,
				formatter:function(value){
					return getDictItem("APP_STATUS", value);
				}
			}] ],
			toolbar : '#toolbar'
		});
		
		initComboboxContent("appType", "APP_TYPE");
		
	});
	 
	function checkAppDetail() {
		var rows = $('#datagrid').datagrid('getChecked');
		if (rows.length > 0) {
			if (rows.length == 1) {
				window.location.href = '${pageContext.request.contextPath}/recheck/app/toCheckApp.do?appNo='
						+ rows[0].appNo + '&appType=' + rows[0].appType;
			} else {
				$.messager.alert('信息提示', "只能选择一条要审核的记录！", "info");
			}
		} else {
			$.messager.alert('信息提示', "请您选择要审核的记录！", "info");
		}

	}

	//查询
	function search() {
		$('#datagrid').datagrid('load', serializeObject($('#searchForm')));
	}
	
    //清空
	function resetSearch() {
		$('#searchForm :text').val('');
		$('#datagrid').datagrid('load', {});
	}
//-->
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit : true,border : false">
		<div data-options="region:'north',title:'查询条件',border:false"
			style="height: 133px; overflow: hidden; padding-left: 1px; padding-right: 1px; padding-bottom: 1px; padding-top: 1px;"
			align="center">
			<form id="searchForm">
				<table class="querytable" width="100%">
					<tr>
						<th width="20%">申请类型</th>
						<td width="30%"><input name="appType" id="appType" style="width: 280px;" /></td>
						<th width="20%">申请编号</th>
						<td width="30%"><input name="appNo" style="width: 280px;" /></td>
					</tr>
					<tr>
						<th width="20%">借款人(公司名)</th>
						<td width="30%"><input name="name" style="width: 280px;" /></td>
						<th width="20%">地址</th>
						<td width="30%"><input name="addr" style="width: 280px;" /></td>
					</tr>
					<tr>
						<td colspan="4" align="center"><input type="button"
							value="查询" class="btn" onclick="search();" /> <input
							type="button" value="清空" class="btn" onclick="resetSearch();" /></td>
					</tr>
				</table>
			</form>
		</div>
		<div data-options="region:'center',border:false"
			style="padding-top: 0px;">
			<table id="datagrid"></table>
			<div id="toolbar"
				style="height: auto !important; height: 28px; min-height: 28px;">
				<table cellspacing="0" cellpadding="0">
					<tr>
						<td><a href="#" class="easyui-linkbutton"
							data-options="iconCls:'icon-ui-search',plain:true"
							onClick="javascript:checkAppDetail();" style="float: left;">申请复核</a></td>
						<td>
						<td>
							<div class="datagrid-btn-separator"></div>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>