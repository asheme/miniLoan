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
<!--
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
		
	});
	
	//保存信息
	function saveObjCredit() {
		$('#modifyForm').form('submit', {
			url : '${pageContext.request.contextPath}/natural/credit/modifyNaturalCredit.do',
			success : function(result) {
				try {
					var r = $.parseJSON(result);
					if (r.success) {
						$.messager.alert('信息提示', r.msg, "info",reloadPage);
					} else {
						$.messager.alert('信息提示', r.msg, "info");
					}
				} catch (e) {
					$.messager.alert('信息提示', result);
				}
			}
		});
	}

	function reloadPage(){
		var appNo=$("input[name='appNo']").val();	
		window.location.href="${pageContext.request.contextPath}/natural/credit/toModifyNaturalCredit.do?appNo="+appNo;
	}
	
	//检查输入是否有效
	function validate() {
		return true;
	}
	
	function clearNaturalCredit() {
		$.messager.confirm('信息提示', '您确认要清空所有录入？', function(r) {
			if(r){
				$("input[type!='button']").each(function() {
					$(this).val("");
				});
			}
		});
	}
//-->
</script>
</head>
<body>
	<div id="updatePanel" class="easyui-panel"
		data-options="border:false,fit:true"
		style="padding-left: 2px; padding-right: 2px; padding-bottom: 1px; padding-top: 2px;">
		<form id="modifyForm" method="post">
			<table class="modifytable" width="100%">
				<tr>
					<th align="center" width="25%">贷记卡帐户总数</th>
					<td width="25%"><input class="easyui-validatebox"
						name="ccCount" value="${naturalCredit.ccCount}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="ccCount" /></td>
					<th align="center" width="25%">最近3个月内新开信用卡账户数</th>
					<td width="25%"><input class="easyui-validatebox"
						name="newCcIn3mth" value="${naturalCredit.newCcIn3mth}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="newCcIn3mth" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">最近一期活跃信用卡账户数</th>
					<td width="25%"><input class="easyui-validatebox"
						name="lastActiveCcCount"
						value="${naturalCredit.lastActiveCcCount}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="lastActiveCcCount" /></td>
					<th align="center" width="25%">贷记卡最近24个月最大拖欠记录</th>
					<td width="25%"><input class="easyui-validatebox"
						name="maxPastDueIn24mth"
						value="${naturalCredit.maxPastDueIn24mth}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="maxPastDueIn24mth" /></td>
				</tr>

				<tr>
					<th align="center" width="25%">贷记卡12个月内未还最低还款额次数</th>
					<td width="25%"><input class="easyui-validatebox"
						dateFormat="date" name="notMiniPayCountIn12mth"
						value="${naturalCredit.notMiniPayCountIn12mth}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="notMiniPayCountIn12mth" /></td>
					<th align="center" width="25%">贷记卡最近3个月最大拖欠记录</th>
					<td width="25%"><input class="easyui-validatebox"
						dateFormat="date" name="maxMIn3mth"
						value="${naturalCredit.maxMIn3mth}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="maxMIn3mth" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">贷记卡当前逾期次数</th>
					<td width="25%"><input class="easyui-validatebox"
						dateFormat="date" name="currPastDueCount"
						value="${naturalCredit.currPastDueCount}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="currPastDueCount" /></td>
					<th align="center" width="25%">贷款最近24个月最大拖欠记录</th>
					<td width="25%"><input class="easyui-validatebox"
						name="loanMaxDeliqIn24mth"
						value="${naturalCredit.loanMaxDeliqIn24mth}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="loanMaxDeliqIn24mth" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">贷款当前逾期次数</th>
					<td width="25%"><input class="easyui-validatebox"
						name="loanCurrDeliq" value="${naturalCredit.loanCurrDeliq}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="loanCurrDeliq" /></td>
					<th align="center" width="25%">贷款当前月还款总额</th>
					<td width="25%"><input class="easyui-validatebox"
						name="loanCurrAmount" value="${naturalCredit.loanCurrAmount}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="loanCurrAmount" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">贷记卡近3个月M0的次数</th>
					<td width="25%"><input class="easyui-validatebox"
						name="ccM0In3mth" value="${naturalCredit.ccM0In3mth}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="ccM0In3mth" /></td>
					<th align="center" width="25%">贷记卡近3个月M1的次数</th>
					<td width="25%"><input class="easyui-validatebox"
						name="ccM1In3mth" value="${naturalCredit.ccM1In3mth}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="ccM1In3mth" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">贷记卡近3个月M2和M2+的次数</th>
					<td width="25%"><input class="easyui-validatebox"
						name="ccM2mIn3mth" value="${naturalCredit.ccM2mIn3mth}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="ccM2mIn3mth" /></td>
					<th align="center" width="25%">贷款近3个月M0的次数</th>
					<td width="25%"><input class="easyui-validatebox"
						name="loanMoIn3mth" value="${naturalCredit.loanMoIn3mth}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="loanMoIn3mth" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">贷款近3个月M1的次数</th>
					<td width="25%"><input class="easyui-validatebox"
						name="loanM1In3mth" value="${naturalCredit.loanM1In3mth}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="loanM1In3mth" /></td>
					<th align="center" width="25%">贷款近3个月M2和M2+的次数</th>
					<td width="25%"><input class="easyui-validatebox"
						name="loanM2mIn3mth" value="${naturalCredit.loanM2mIn3mth}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="loanM2mIn3mth" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">近6个月同时发生贷记卡和消费信贷逾期的次数</th>
					<td width="25%"><input class="easyui-validatebox"
						name="ctransOrLoanIn6mth"
						value="${naturalCredit.ctransOrLoanIn6mth}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="ctransOrLoanIn6mth" /></td>
					<th align="center" width="25%">&nbsp;</th>
					<td width="25%">&nbsp;</td>
				<tr>
					<td colspan="4" align="center"><input type="button" value="保存"
						class="btn" onclick="saveObjCredit();" /> <input type="button"
						value="清空" class="btn" onclick="clearNaturalCredit();" /> <input type="hidden" name="appNo" value="${naturalCredit.appNo}" />  
						<input type="hidden" name="flag" value="${flag}"></td>
				</tr>

			</table>
		</form>
	</div>
</body>