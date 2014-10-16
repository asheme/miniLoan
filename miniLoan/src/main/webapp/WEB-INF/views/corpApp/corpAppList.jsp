<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Company loan application</title>
<script type="text/javascript">

	$(function() {
		$('#datagrid').datagrid({
			url : '${pageContext.request.contextPath}/corp/app/corpAppList.do',
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
			},{
				field : 'appNo',
				title : '申请编号',
				width : 20,
				sortable : true
			}, {
				field : 'borrower',
				title : '借款人',
				width : 15
				
			}, {
				field : 'compName',
				title : '企业名称',
				width : 15,
				sortable : true
			}, {
				field : 'legalPerson',
				title : '法人代表',
				sortable : true,
				width : 20
			}, {
				field : 'lpIdNo',
				title : '法人证件号',
				sortable : true,
				width : 20
			}, {
				field : 'loanAmount',
				title : '借款金额',
				sortable : true,
				width : 20
			}, {
				field : 'loanPeriod',
				title : '借款期限',
				width : 20,
				sortable : true
			}, {
				field:'status',
				title:'当前状态',
				width:20,
				formatter:function(value,row,index){
					return "退回";
				}
				
			}] ],
			toolbar : '#toolbar'
		});
	});

	function addNew() {
		window.location.href = '${pageContext.request.contextPath}/corp/app/corpApp.do?flag=ADD';
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
				window.location.href = '${pageContext.request.contextPath}/corp/app/corpApp.do?flag=UPDATE&appNo='
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
						url : '${pageContext.request.contextPath}/corp/app/deleteCorpApp.do',
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
	
	function editCredit() {
		var rows = $('#datagrid').datagrid('getChecked');
		if (rows.length > 0) {
			if (rows.length == 1) {
				window.location.href = '${pageContext.request.contextPath}/corp/credit/creditDetail.do?appNo='
						+ rows[0].appNo;
			} else {
				$.messager.alert('信息提示', "只能选择一条要维护的记录！", "info");
			}
		} else {
			$.messager.alert('信息提示', "请您选择要维护的记录！", "info");
		}
	}
	function editAttach() {
		var rows = $('#datagrid').datagrid('getChecked');
		if (rows.length > 0) {
			if (rows.length == 1) {
				window.location.href = '${pageContext.request.contextPath}/corp/attach/toCorpAttachList.do?appNo='
						+ rows[0].appNo;
			} else {
				$.messager.alert('信息提示', "只能选择一条要维护的记录！", "info");
			}
		} else {
			$.messager.alert('信息提示', "请您选择要维护的记录！", "info");
		}
	}
	function editShareholder() {
		var rows = $('#datagrid').datagrid('getChecked');
		if (rows.length > 0) {
			if (rows.length == 1) {
				window.location.href = '${pageContext.request.contextPath}/corp/shareholder/toShareholderList.do?appNo='
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
				window.location.href = '${pageContext.request.contextPath}/corp/app/toShowDetail.do?appNo='
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
						<th width="20%">借款人</th>
						<td width="30%"><input name="name" style="width: 280px;" /></td>
						<th width="20%">企业名称</th>
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
							data-options="iconCls:'icon-ui-add',plain:true"
							onClick="javascript:addNew();" style="float: left;">新增</a></td>
						<td>
							<div class="datagrid-btn-separator"></div>
						</td>
						<td><a href="#" class="easyui-linkbutton"
							data-options="iconCls:'icon-ui-edit',plain:true"
							onClick="javascript:updateObj();" style="float: left;">修改</a></td>
						<td>
							<div class="datagrid-btn-separator"></div>
						</td>
						<td><a href="#" class="easyui-linkbutton"
							data-options="iconCls:'icon-ui-remove',plain:true"
							onClick="javascript:deleteObj();" style="float: left;">删除</a></td>
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