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
<title>create or modify natural credit application</title>
<script type="text/javascript">
	$(function() {
		$("#idSignDate").datebox();
		$("#idExpireDate").datebox();
		$("#birthday").datebox();
		$("#currJobStDate").datebox();
		$("#liveStartTime").datebox();
		$("#carBuyDate").datebox();
		$("#spouseIdSignDate").datebox();
		$("#spouseIdExpireDate").datebox();
		$("#linkmanIdSignDate").datebox();
		$("#linkmanIdExpireDate").datebox();
		$("#guarCompOpenDate").datebox();
		
		initComboboxContent("gender", "GENDER");
		initComboboxContent("idType", "ID_TYPE");
		initComboboxContent("spouseIdType", "ID_TYPE");
		initComboboxContent("linkmanIdType", "ID_TYPE");
		
		$("input[dateFormat='date']").each(function(){				
			var time=dateToStr($(this).val());
			$(this).datebox('setValue',time);
		});
		
		if ($("input[name='flag']").val() == "Add") {
			$('#updatePanel').panel({
				title : '添加申请信息'
			});
		} else {
			$('#updatePanel').panel({
				title : '修改申请信息'
			});
		}
	});
	
	//返回列表页
	function backList() {
		window.location.href = '${pageContext.request.contextPath}/menu/corpAppList.do';
	}
	
	function getDate(date){
		
		return date;
	}

	//保存信息
	function saveCorpCredit() {
		$('#modifyForm').form('submit', {
			url : '${pageContext.request.contextPath}/corp/credit/modifyCorpCredit.do?appNo='+window.parent.appNo+'&flag='+window.parent.creditflag,
			success : function(result) {
				try {
					var r = $.parseJSON(result);
					if (r.success) {
						window.parent.creditflag='UPDATE';
						$.messager.alert('信息提示', r.msg, "info");
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

	function clearCorpCredit() {
		$.messager.confirm('信息提示', '您确认要清空所有录入？', function(r) {
		if(r){
			$("input[type!='button']").each(function() {
			$(this).val("");
		});
		}
		});
	}
</script>
</head>
<body>
	<div id="updatePanel" class="easyui-panel"
		data-options="border:false,fit:true"
		style="padding-left: 2px; padding-right: 2px; padding-bottom: 1px; padding-top: 2px;">
		<form id="modifyForm" method="post">
			<table class="modifytable" width="100%">
				<tr>
					<th align="center" width="25%">注册资金</th>
					<td width="25%"><input class="easyui-validatebox"
						name="regCapital" value="${corpCredit.regCapital}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="regCapital" /></td>
					<th align="center" width="25%">出资人数</th>
					<td width="25%"><input class="easyui-validatebox"
						name="subscriptionNumber" value="${corpCredit.subscriptionNumber}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="subscriptionNumber" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">由资产管理公司处置的债务余额</th>
					<td width="25%"><input class="easyui-validatebox"
						name="debtByAmcAmount" value="${corpCredit.debtByAmcAmount}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="debtByAmcAmount" /></td>
					<th align="center" width="25%">由资产管理公司处置的债务欠息笔数</th>
					<td width="25%"><input class="easyui-validatebox"
						name="debtInterestCountByAmc"
						value="${corpCredit.debtInterestCountByAmc}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="debtInterestCountByAmc" /></td>
				</tr>

				<tr>
					<th align="center" width="25%">由资产管理公司处置的债务欠息余额</th>
					<td width="25%"><input class="easyui-validatebox"
						dateFormat="date" name="debtInterestAmountByAmc"
						value="${corpCredit.debtInterestAmountByAmc}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="debtInterestAmountByAmc" /></td>
					<th align="center" width="25%">由资产管理公司处置的债务垫款笔数</th>
					<td width="25%"><input class="easyui-validatebox"
						dateFormat="date" name="cashAdvCountByAmc"
						value="${corpCredit.cashAdvCountByAmc}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="cashAdvCountByAmc" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">由资产管理公司处置的债务垫款余额</th>
					<td width="25%"><input class="easyui-validatebox"
						dateFormat="date" name="cashAdvAmountByAmc"
						value="${corpCredit.cashAdvAmountByAmc}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="cashAdvAmountByAmc" /></td>
					<th align="center" width="25%">正常类贷款笔数</th>
					<td width="25%"><input class="easyui-validatebox"
						name="normalLoansCount" value="${corpCredit.normalLoansCount}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="normalLoansCount" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">正常类贷款余额</th>
					<td width="25%"><input class="easyui-validatebox"
						name="normalLoansAmount" value="${corpCredit.normalLoansAmount}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="normalLoansAmount" /></td>
					<th align="center" width="25%">关注类贷款笔数</th>
					<td width="25%"><input class="easyui-validatebox"
						name="specMentionLoansCount"
						value="${corpCredit.specMentionLoansCount}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="specMentionLoansCount" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">关注类贷款余额</th>
					<td width="25%"><input class="easyui-validatebox"
						name="specMentionLoansAmount"
						value="${corpCredit.specMentionLoansAmount}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="specMentionLoansAmount" /></td>
					<th align="center" width="25%">不良类贷款笔数</th>
					<td width="25%"><input class="easyui-validatebox"
						name="badLoansCount" value="${corpCredit.badLoansCount}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="badLoansCount" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">不良类贷款余额</th>
					<td width="25%"><input class="easyui-validatebox"
						name="badLoansAmount" value="${corpCredit.badLoansAmount}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="badLoansAmount" /></td>

				</tr>

				<td colspan="4" align="center"><input type="button" value="保存"
					class="btn" onclick="saveCorpCredit();" /> <input type="button"
					value="清空" class="btn" onclick="clearCorpCredit();" /> <%-- <input type="hidden" name="appNo" value="${corpCredit.appNo}" /> 
					<input type="hidden" name="flag" value="${flag}"></td> --%>
				</tr>

			</table>
		</form>
	</div>
</body>