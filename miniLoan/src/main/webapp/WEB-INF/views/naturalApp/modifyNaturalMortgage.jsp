<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>create or modify natural attach</title>
<script type="text/javascript">

	$(function() {
		$("#buyDate").datebox();
		
		initComboboxContent("mortgagorIdType", "ID_TYPE");
		
		$("input[dateFormat='date']").each(function(){				
			var time=dateToStr($(this).val());
			$(this).datebox('setValue',time);
		});
		
	});
	
	//返回列表页
	function backList() {
		window.location.href = '${pageContext.request.contextPath}/natural/mortgage/toMortgageList.do?appNo=${naturalMortgage.appNo}';
	}
	
	//保存信息
	function saveObj() {
		var url='${pageContext.request.contextPath}/natural/mortgage/modifyNaturalMortgage.do';
		$('#modifyForm').form('submit', {
			url : url,
			success : function(result) {
				try {
					var r = $.parseJSON(result);
					if (r.success) {
						$.messager.alert('信息提示', r.msg, "info", backList);
					} else {
						$.messager.alert('信息提示', r.msg, "info");
					}
				} catch (e) {
					$.messager.alert('信息提示', result);
				}
			}
		});
	}

	//检查输入是否有效
	function validate() {
		return true;
	}
</script>
</head>
<body>
	<div id="updatePanel" class="easyui-panel" title="抵押物信息"
		data-options="border:false,fit:true"
		style="padding-left: 2px; padding-right: 2px; padding-bottom: 1px; padding-top: 2px;">
		<form id="modifyForm" method="post">
			<table class="modifytable" width="100%">
				<tr>
					<th align="center" width="25%">抵押人</th>
					<td width="25%"><input class="easyui-validatebox"
						name="mortgagor" value="${naturalMortgage.mortgagor}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="mortgagor" /></td>
					<th align="center" width="25%">抵押人证件类型</th>
					<td width="25%"><input class="easyui-validatebox"
						name="mortgagorIdType" value="${naturalMortgage.mortgagorIdType}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="mortgagorIdType" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">抵押人证件号码</th>
					<td width="25%"><input class="easyui-validatebox"
						name="mortgagorIdNo" value="${naturalMortgage.mortgagorIdNo}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="mortgagorIdNo" /></td>
					<th align="center" width="25%">抵押人联系电话</th>
					<td width="25%"><input class="easyui-validatebox"
						name="mortgagorPhone" value="${naturalMortgage.mortgagorPhone}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="mortgagorPhone" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">法定代表人</th>
					<td width="25%"><input class="easyui-validatebox"
						name="legalPerson" value="${naturalMortgage.legalPerson}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="legalPerson" /></td>
					<th align="center" width="25%">地址</th>
					<td width="25%"><input class="easyui-validatebox"
						name="mortgageAddr" value="${naturalMortgage.mortgageAddr}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="mortgageAddr" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">抵押物名称</th>
					<td width="25%"><input class="easyui-validatebox"
						name="mortgageName" value="${naturalMortgage.mortgageName}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="mortgageName" /></td>
					<th align="center" width="25%">产权证编号</th>
					<td width="25%"><input class="easyui-validatebox"
						name="certificationNo" value="${naturalMortgage.certificationNo}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="certificationNo" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">抵押物位置</th>
					<td width="25%"><input class="easyui-validatebox"
						name="mortgageLocation"
						value="${naturalMortgage.mortgageLocation}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="mortgageLocation" /></td>
					<th align="center" width="25%">面积、数量</th>
					<td width="25%"><input class="easyui-validatebox"
						name="mortgageArea" value="${naturalMortgage.mortgageArea}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="mortgageArea" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">购置日期</th>
					<td width="25%"><input class="easyui-validatebox"
						dateFormat="date" name="buyDate"
						value="${naturalMortgage.buyDate}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="buyDate" /></td>
					<th align="center" width="25%">原值</th>
					<td width="25%"><input class="easyui-validatebox"
						name="oldValue" value="${naturalMortgage.oldValue}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="oldValue" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">现值</th>
					<td width="25%"><input class="easyui-validatebox"
						name="currValue" value="${naturalMortgage.currValue}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="currValue" /></td>
					<th align="center" width="25%">现状</th>
					<td width="25%"><input class="easyui-validatebox"
						name="status" value="${naturalMortgage.status}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="status" /></td>
				</tr>

				<tr>
					<td colspan="4" align="center"><input type="button" value="保存"
						class="btn" onclick="saveObj();" /> <input type="button"
						value="返回" class="btn" onclick="javascript:backList();" /> <input
						type="hidden" name="appNo" value="${naturalMortgage.appNo}" /> <input
						type="hidden" name="mortgageId"
						value="${naturalMortgage.mortgageId}" /> <input type="hidden"
						name="flag" value="${flag}"></td>
				</tr>

			</table>
		</form>
	</div>
</body>