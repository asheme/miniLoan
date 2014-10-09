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
			url : '${pageContext.request.contextPath}/natural/attach/naturalAttachList.do?appNo=${appNo}',
			fit : true,
			fitColumns : true,
			striped : true,
			border : false,
			pagination : true,
			idField : 'fileNo',
			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50 ],
			sortName : 'fileNo',
			sortOrder : 'ASC',
			checkOnSelect : false,
			selectOnCheck : false,
			rownumbers : true,
			nowrap : false,
			columns : [ [ {
				field : 'fileNo',
				title : '文件编号',
				width : 20,
				checkbox : true
			}, {
				field : 'appNo',
				title : '申请编号',
				width : 20,
				sortable : true
			},{
				field : 'fileName',
				title : '文件名称',
				width : 20,
				sortable : true
			}, {
				field : 'fileDesc',
				title : '文件描述',
				width : 20,
				sortable : true
			}] ],
			toolbar : '#toolbar'
		});
		
	});
	 
	function addNew() {
		window.location.href = '${pageContext.request.contextPath}/natural/attach/toAddNaturalAttach.do?appNo=${appNo}';
		if (navigator.userAgent.indexOf("MSIE") > 0) {// IE特有回收内存方法
			try {
				CollectGarbage();
			} catch (e) {
			}
		}

	}

	function deleteObj() {
		var rows = $('#datagrid').datagrid('getChecked');
		var ids = [];
		if (rows.length > 0) {
			$.messager.confirm('信息提示', '您确认要删除当前选中的记录？', function(r) {
				if (r) {
					for (var i = 0; i < rows.length; i++) {
						ids.push(rows[i].fileNo);
					}
					$.ajax({
						url : '${pageContext.request.contextPath}/natural/attach/deleteNaturalAttach.do',
						data : {
							ids : ids.join(',')
						},
						type : "POST",
						dataType : 'json',
						success : function(result) {
							$.messager.alert('信息提示', result.msg, "info",
									function() {
										if (result.success) {
											$('#datagrid').datagrid('load');
											$('#datagrid').datagrid(
													'uncheckAll').datagrid(
													'unselectAll').datagrid(
													'clearSelections');
										}
									});
						}
					});
				}
			});
		} else {
			$.messager.alert('信息提示', '请勾选要删除的记录！', "info");
		}
	}
	
	function viewObj() {
		var rows = $('#datagrid').datagrid('getChecked');
		if (rows.length > 0) {
			if (rows.length == 1) {
				window.location.href = '${pageContext.request.contextPath}/natural/attach/downloadAttach.do?fileName='
						+ rows[0].fileName;
			} else {
				$.messager.alert('信息提示', "只能选择一条要查看的记录！", "info");
			}
		} else {
			$.messager.alert('信息提示', "请您选择要查看的记录！", "info");
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
							data-options="iconCls:'icon-ui-add',plain:true"
							onClick="javascript:addNew();" style="float: left;">新增</a></td>
						<td>
							<div class="datagrid-btn-separator"></div>
						</td>
						<td><a href="#" class="easyui-linkbutton"
							data-options="iconCls:'icon-ui-remove',plain:true"
							onClick="javascript:deleteObj();" style="float: left;">删除</a></td>
						<td>
							<div class="datagrid-btn-separator"></div>
						</td>
						<td><a href="#" class="easyui-linkbutton"
							data-options="iconCls:'icon-ui-search',plain:true"
							onClick="javascript:viewObj();" style="float: left;">查看附件</a></td>
						<td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>