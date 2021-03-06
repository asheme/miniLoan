<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>loan app check list</title>
<script type="text/javascript">
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
				field : 'id',
				checkbox : true
			}, {
				field : 'appNo',
				title : '申请编号',
				width : 20,
				sortable : true
			},{
				field : 'appType',
				title : '申请类型',
				width : 10,
				sortable : true,
				formatter : function(value, row, index) {
					return getDictItem("APP_TYPE", value);
				}
			}, {
				field : 'enterTime',
				title : '进件时间',
				width : 10,
				sortable : true
			}, {
				field : 'currStep',
				title : '当前步骤',
				sortable : true,
				width : 10,
				formatter : function(value, row, index) {
					return getDictItem("PROCESS_STEP", value);
				}
			}] ],
			toolbar : '#toolbar'
		});
		
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

	function updateObj() {
		var rows = $('#datagrid').datagrid('getChecked');
		
		if (rows.length > 0) {
			if (rows.length == 1) {
				window.location.href = '${pageContext.request.contextPath}/natural/app/toUpdateNaturalApp.do?appNo='
						+ rows[0].appNo;
			} else {
				$.messager.alert('信息提示', "只能选择一条要修改的记录！", "info");
			}
		} else {
			$.messager.alert('信息提示', "请您选择要修改的记录！", "info");
		}
	}

	function deleteObj() {
		var rows = $('#datagrid').datagrid('getChecked');
		var ids = [];
		if (rows.length > 0) {
			$.messager.confirm('信息提示', '您确认要删除当前选中的记录？', function(r) {
				if (r) {
					for (var i = 0; i < rows.length; i++) {
						ids.push(rows[i].appNo);
					}
					$.ajax({
						url : '${pageContext.request.contextPath}/natural/app/deleteNaturalApp.do',
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
	
	function checkCredit() {
		var rows = $('#datagrid').datagrid('getChecked');
		if (rows.length > 0) {
			if (rows.length == 1) {
				$.ajax({
					url:'${pageContext.request.contextPath}/natural/credit/getCredit.do?appNo='
						+ rows[0].appNo,
					success:function(data){
						if(data==1)
							{
						window.location.href = '${pageContext.request.contextPath}/natural/credit/naturalCreditCheck.do?appNo='
							+ rows[0].appNo;
							}
						else{
							alert("该贷款人无征信记录");
						}
					}	
				});
			
			} else {
				$.messager.alert('信息提示', "只能选择一条要维护的记录！", "info");
			}
		} else {
			$.messager.alert('信息提示', "请您选择要维护的记录！", "info");
		}
	}
	function checkAttach() {
		var rows = $('#datagrid').datagrid('getChecked');
		if (rows.length > 0) {
			if (rows.length == 1) {
				window.location.href = '${pageContext.request.contextPath}/natural/attach/naturalCheckAttach.do?appNo='
						+ rows[0].appNo;
			} else {
				$.messager.alert('信息提示', "只能选择一条要维护的记录！", "info");
			}
		} else {
			$.messager.alert('信息提示', "请您选择要维护的记录！", "info");
		}
	}
	function checkMortgage() {
		var rows = $('#datagrid').datagrid('getChecked');
		if (rows.length > 0) {
			if (rows.length == 1) {
				window.location.href = '${pageContext.request.contextPath}/natural/mortgage/naturalCheckMortgage.do?appNo='
						+ rows[0].appNo;
			} else {
				$.messager.alert('信息提示', "只能选择一条要维护的记录！", "info");
			}
		} else {
			$.messager.alert('信息提示', "请您选择要维护的记录！", "info");
		}
	}
	function checkCorpShareholder()
	{
		var rows = $('#datagrid').datagrid('getChecked');
	
		if (rows.length > 0) {
			if (rows.length == 1) {
				window.location.href = '${pageContext.request.contextPath}/corp/shareholder/corpCheckShareholder.do?appNo='
						+ rows[0].appNo;
			} else {
				$.messager.alert('信息提示', "只能选择一条要维护的记录！", "info");
			}
		} else {
			$.messager.alert('信息提示', "请您选择要维护的记录！", "info");
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
     //查看详情
    function Detail (){
    	var rows = $('#datagrid').datagrid('getChecked');
		if (rows.length > 0) {
			if (rows.length == 1) {
				window.location.href = '${pageContext.request.contextPath}/natural/app/toShowDetail.do?appNo='
						+ rows[0].appNo;
			} else {
				$.messager.alert('信息提示', "只能选择一条要维护的记录！", "info");
			}
		} else {
			$.messager.alert('信息提示', "请您选择要维护的记录！", "info");
		}
    }
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit : true,border : false">
		<div data-options="region:'north',title:'查询条件',border:false"
			style="height: 103px; overflow: hidden; padding-left: 1px; padding-right: 1px; padding-bottom: 1px; padding-top: 1px;"
			align="center">
			<form id="searchForm">
				<table class="querytable" width="100%">
					<tr>
						<th width="20%">申请编号</th>
						<td width="30%"><input name="name" style="width: 280px;" /></td>
						<th width="20%">申请类型</th>
						<td width="30%"><input name="name" style="width: 280px;" /></td>
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
							onClick="javascript:checkAppDetail();" style="float: left;">申请信息复核</a></td>
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