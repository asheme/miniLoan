<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>loan pay record list</title>
<script type="text/javascript">
<!--
	$(function() {
		$('#datagrid').datagrid({
			url : '${pageContext.request.contextPath}/loan/receipt/loanReceiptList.do?loanId=${loanId}',
			fit : true,
			fitColumns : true,
			striped : true,
			border : false,
			pagination : true,
			idField : 'receiptId',
			pageSize : 10,
			pageList : [ 10, 20, 30, 40, 50 ],
			sortName : 'receiptId',
			sortOrder : 'ASC',
			checkOnSelect : false,
			selectOnCheck : false,
			rownumbers : true,
			nowrap : false,
			columns : [ [ {
				field : 'receiptId',
				title : '还款编号',
				checkbox : true
			},{
				field : 'id',
				title : '编号',
				width : 10,
				formatter : function(value,row){
					return row.receiptId;
				}
			}, {
				field : 'offerAmount',
				title : '放款金额',
				width : 15,
				sortable : true
			}, {
				field : 'offerAmountSum',
				title : '累计放款',
				width : 15,
				sortable : true
			}, {
				field : 'offerAmountRemain',
				title : '剩余放款',
				width : 15,
				sortable : true
			}, {
				field : 'offerAcct',
				title : '放款账户',
				width : 15,
				sortable : true
			}, {
				field : 'offerMan',
				title : '放款人',
				width : 15,
				sortable : true
			}, {
				field : 'offerTime',
				title : '放款时间',
				width : 15,
				sortable : true
			}, {
				field : 'receiptName',
				title : '借据',
				width : 15,
				sortable : true,
				formatter : function(value,row,index){
					return '<a href="${pageContext.request.contextPath}/loan/receipt/download.do?receiptName='+row.receiptName+'&receiptPhysicalName='+row.receiptPhysicalName+'">'+ value+'</a>';
				}
			}, {
				field : 'oper',
				title : '录入人',
				width : 15,
				sortable : true
			}, {
				field : 'operTime',
				title : '录入时间',
				width : 15,
				sortable : true
			} ] ],
			toolbar : '#toolbar'
		});
	});

	function addNew() {
		window.location.href = '${pageContext.request.contextPath}/loan/receipt/toAddLoanReceipt.do?loanId=${loanId}';
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
				window.location.href = '${pageContext.request.contextPath}/loan/receipt/toUpdateLoanReceipt.do?receiptId='
					+ rows[0].receiptId;
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
						ids.push(rows[i].receiptId);
					}
					$.ajax({
						url : '${pageContext.request.contextPath}/loan/receipt/deleteLoanReceipt.do',
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
						<!-- <td><a href="#" class="easyui-linkbutton"
							data-options="iconCls:'icon-ui-edit',plain:true"
							onClick="javascript:updateObj();" style="float: left;">修改</a></td>
						<td>
							<div class="datagrid-btn-separator"></div>
						</td>
						<td><a href="#" class="easyui-linkbutton"
							data-options="iconCls:'icon-ui-remove',plain:true"
							onClick="javascript:deleteObj();" style="float: left;">删除</a></td> -->
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>