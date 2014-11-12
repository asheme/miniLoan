<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>loan info List </title>
<script type="text/javascript">
<!--
$(function() {
	$('#datagrid').datagrid({
		url : '${pageContext.request.contextPath}/loan/loanInfoList.do',
		fit : true,
		fitColumns : true,
		striped : true,
		border : false,
		pagination : true,
		idField : 'loanId',
		pageSize : 10,
		pageList : [ 10, 20, 30, 40, 50 ],
		sortName : 'name',
		sortOrder : 'ASC',
		checkOnSelect : false,
		selectOnCheck : false,
		rownumbers : true,
		nowrap : false,
		columns : [ [ {
			field : 'loanId',
			title : '貸款编号',
			width : 10,
			checkbox : true
		}, {
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
			field : 'loanStartTime',
			title : '贷款开始时间',
			width : 10,
			sortable : true
		}, {
			field : 'status',
			title : '状态',
			width : 10,
			sortable : true
		} ] ],
		toolbar : '#toolbar'
	});
});

//查看贷款信息
function viewLoanInfo() {
	var rows = $('#datagrid').datagrid('getChecked');
	if (rows.length > 0) {
		if (rows.length == 1) {
			window.location.href = '${pageContext.request.contextPath}/loan/viewLoanInfo.do?loanId='
					+ rows[0].loanId;
		} else {
			$.messager.alert('信息提示', "只能选择一条要查看的记录！", "info");
		}
	} else {
		$.messager.alert('信息提示', "请您选择要查看的记录！", "info");
	}
}

//贷款合同维护
function contractMaintain() {
	var rows = $('#datagrid').datagrid('getChecked');
	if (rows.length > 0) {
		if (rows.length == 1) {
			window.location.href = '${pageContext.request.contextPath}/loan/contractMaintain.do?loanId='
					+ rows[0].loanId;
		} else {
			$.messager.alert('信息提示', "只能选择一条要维护的贷款的记录！", "info");
		}
	} else {
		$.messager.alert('信息提示', "请您选择要维护的贷款的记录！", "info");
	}
}

//贷款借据维护
function receiptManage() {
	var rows = $('#datagrid').datagrid('getChecked');
	if (rows.length > 0) {
		if (rows.length == 1) {
			window.location.href = '${pageContext.request.contextPath}/loan/receiptList.do?loanId='
					+ rows[0].loanId;
		} else {
			$.messager.alert('信息提示', "只能选择一条要维护的贷款记录！", "info");
		}
	} else {
		$.messager.alert('信息提示', "请您选择要维护的贷款的记录！", "info");
	}
}

//贷款放款管理
function offerLoanManage() {
	var rows = $('#datagrid').datagrid('getChecked');
	if (rows.length > 0) {
		if (rows.length == 1) {
			window.location.href = '${pageContext.request.contextPath}/loan/receipt/toLoanReceiptList.do?loanId='
					+ rows[0].loanId;
		} else {
			$.messager.alert('信息提示', "只能选择一条要维护的贷款记录！", "info");
		}
	} else {
		$.messager.alert('信息提示', "请您选择要维护的贷款的记录！", "info");
	}
}

//贷款还款管理
function loanPayManage() {
	var rows = $('#datagrid').datagrid('getChecked');
	if (rows.length > 0) {
		if (rows.length == 1) {
			window.location.href = '${pageContext.request.contextPath}/pay/record/toPayRecordList.do?loanId='
					+ rows[0].loanId;
		} else {
			$.messager.alert('信息提示', "只能选择一条要维护的贷款记录！", "info");
		}
	} else {
		$.messager.alert('信息提示', "请您选择要维护的贷款的记录！", "info");
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
			style="height: 103px; overflow: hidden; padding-left: 1px; padding-right: 1px; padding-bottom: 1px; padding-top: 1px;"
			align="center">
			<form id="searchForm">
				<table class="querytable" width="100%">
					<tr>
						<th width="20%">借款人(公司名)</th>
						<td width="30%"><input name="name" style="width: 280px;" /></td>
						<th width="20%">申请编号</th>
						<td width="30%"><input name="appNo" style="width: 280px;" /></td>
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
							onClick="javascript:viewLoanInfo();" style="float: left;">贷款信息查看</a></td>
						<td>
							<div class="datagrid-btn-separator"></div>
						</td>
						<td><a href="#" class="easyui-linkbutton"
							data-options="iconCls:'icon-ui-search',plain:true"
							onClick="javascript:contractMaintain();" style="float: left;">合同维护</a></td>
						<td>
							<div class="datagrid-btn-separator"></div>
						</td>
						<!-- <td><a href="#" class="easyui-linkbutton"
							data-options="iconCls:'icon-ui-search',plain:true"
							onClick="javascript:receiptManage();" style="float: left;">借据管理</a></td>
						<td>
							<div class="datagrid-btn-separator"></div>
						</td> -->
						<td><a href="#" class="easyui-linkbutton"
							data-options="iconCls:'icon-ui-search',plain:true"
							onClick="javascript:offerLoanManage();" style="float: left;">放款管理</a></td>
						<td>
							<div class="datagrid-btn-separator"></div>
						</td>
						<td><a href="#" class="easyui-linkbutton"
							data-options="iconCls:'icon-ui-search',plain:true"
							onClick="javascript:loanPayManage();" style="float: left;">还款管理</a></td>
						<td>
							<div class="datagrid-btn-separator"></div>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>