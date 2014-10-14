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
	 

	function backList() {
		window.location.href = '${pageContext.request.contextPath}/menu/mortgageCheckList.do';
	}

	function submitToNext() {
		$('#submitForm')
				.form(
						'submit',
						{
							url : '${pageContext.request.contextPath}/mortgage/check/goToNext.do?appNo=${appNo}',
							success : function(result) {
								try {
									var r = $.parseJSON(result);
									if (r.success) {
										$.messager.alert('信息提示', r.msg, "info",
												backList);
									} else {
										$.messager.alert('信息提示', r.msg, "info");
									}
								} catch (e) {
									$.messager.alert('信息提示', result);
								}
							}
						});
	}
	
	
	$(function(){
		$('input[name="checkResult"]').each(function(){
			var t=$(this).val();
			if(t=='${checkResult.checkResult}'){
				$(this).attr("checked",true);
				}
		});
	});
</script>
</head>
<body>
	<div style="height: 65%">
		<div class="easyui-layout" data-options="fit : true,border : false">
			<div data-options="region:'center',border:false"
				style="padding-top: 0px;">
				<table id="datagrid"></table>

			</div>
		</div>
	</div>
	<div data-options="region:'south',border : false,collapsible:false"
		style="overflow: hidden; padding: 1px; height: 150px;">
		<div class="easyui-panel" data-options="border:false,fit:true"
			title="复核结果"
			style="padding-left: 2px; padding-right: 2px; padding-bottom: 1px; padding-top: 2px;">
			<form id="submitForm" method="post">
				<table class="modifytable" width="100%" height="100%">
					<tr>
						<th align="center" width="30%">审核结果</th>
						<td width="35%"><label>通过</label><input type="radio"
							name="checkResult" value="1" checked="checked"></input></td>
						<td width="35%"><label>不通过</label><input type="radio"
							name="checkResult" value="0"></input></td>
					</tr>
					<tr>
						<th align="center" width="30%">审核建议</th>
						<td colspan="2"><textarea rows="3" cols="100"
								name="checkDesc"></textarea></td>
					</tr>
					<tr>
						<td colspan="4" align="center"><input type="button"
							value="提交" class="btn" onclick="submitToNext();" /> <input
							type="button" value="返回列表" class="btn" onclick="backList();" />
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>