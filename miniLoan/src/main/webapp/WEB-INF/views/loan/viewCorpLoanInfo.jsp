<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>view Corp Loan info</title>
<script type="text/javascript">
<!--
//返回列表
function backList() {
	window.location.href = '${pageContext.request.contextPath}/menu/loanList.do';
}
//-->
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit : true,border : false">
		<div data-options="region:'center',border : false" style="padding: 1px;" title="客户信息">
			<table class="modifytable" width="100%">
				<tr>
					<th align="center" width="25%">客户编号</th>
					<td width="25%">${corpCustInfo.custNo}</td>
					<th align="center" width="25%">企业名称</th>
					<td width="25%">${corpCustInfo.compName}</td>
				</tr>
				<tr>
					<th align="center" width="25%">注册地址</th>
					<td width="25%">${corpCustInfo.regAddr}</td>
					<th align="center" width="25%">企业性质</th>
					<td width="25%">${corpCustInfo.compType}</td>
				</tr>
				<tr>
					<th align="center" width="25%">成立时间</th>
					<td width="25%">${corpCustInfo.establishDate}</td>
					<th align="center" width="25%">法定代表人</th>
					<td width="25%">${corpCustInfo.legalPerson}</td>
				</tr>
				<tr>
					<th align="center" width="25%">法人证件类型</th>
					<td width="25%">${corpCustInfo.lpIdType}</td>
					<th align="center" width="25%">法人证件号码</th>
					<td width="25%">${corpCustInfo.lpIdNo}</td>
				</tr>
				<tr>
					<th align="center" width="25%">法人籍贯</th>
					<td width="25%">${corpCustInfo.lpNative}</td>
					<th align="center" width="25%">法人住址</th>
					<td width="25%">${corpCustInfo.lpAddr}</td>
				</tr>
				<tr>
					<th align="center" width="25%">企业经营范围</th>
					<td width="25%">${corpCustInfo.busiScope}</td>
					<th align="center" width="25%">上年底资产总额</th>
					<td width="25%">${corpCustInfo.lastYearAssets}</td>
				</tr>
				<tr>
					<th align="center" width="25%">上年底负债总额</th>
					<td width="25%">${corpCustInfo.lastYearLiabilities}</td>
					<th align="center" width="25%">上年度销售总额</th>
					<td width="25%">${corpCustInfo.lastYearSalesAmount}</td>
				</tr>
				<tr>
					<th align="center" width="25%">上年度例如总额</th>
					<td width="25%">${corpCustInfo.lastYearProfit}</td>
					<th align="center" width="25%">上年度纳税总额</th>
					<td width="25%">${corpCustInfo.lastYearPayTax}</td>
				</tr>
				<tr>
					<th align="center" width="25%">近六个月平均银行流水</th>
					<td width="25%">${corpCustInfo.avgCashFlowInSixmth}</td>
					<th align="center" width="25%">&nbsp;</th>
					<td width="25%">&nbsp;</td>
				</tr>
			</table>
		</div>
		<div data-options="region:'south',border : false,collapsible:false"
			style="padding: 1px; height: 150px;" title="贷款信息">
			<table class="modifytable" width="100%">
				<tr>
					<th align="center" width="25%">申请编号</th>
					<td width="25%">${loanInfo.appNo}</td>
					<th align="center" width="25%">贷款合同号</th>
					<td width="25%">${loanInfo.loanContractNo}</td>
				</tr>
				<tr>
					<th align="center" width="25%">贷款金额</th>
					<td width="25%">${loanInfo.loanAmount}</td>
					<th align="center" width="25%">贷款周期</th>
					<td width="25%">${loanInfo.loanCycle}</td>
				</tr>
				<tr>
					<th align="center" width="25%">贷款利率</th>
					<td width="25%">${loanInfo.loanRate}</td>
					<th align="center" width="25%">放款方式</th>
					<td width="25%">${loanInfo.offerMethod}</td>
				</tr>
				<tr>
					<th align="center" width="25%">还款方式</th>
					<td width="25%">${loanInfo.payMethod}</td>
					<th align="center" width="25%">罚息执行利率</th>
					<td width="25%">${loanInfo.interestPenalty}</td>
				</tr>
				<tr>
					<th align="center" width="25%">滞纳金</th>
					<td width="25%">${loanInfo.overdueFine}</td>
					<th align="center" width="25%">贷款利息</th>
					<td width="25%">${loanInfo.loanInterest}</td>
				</tr>
				<tr>
					<th align="center" width="25%">已放款金额</th>
					<td width="25%">${loanInfo.offerLoan}</td>
					<th align="center" width="25%">已还款金额</th>
					<td width="25%">${loanInfo.payAmount}</td>
				</tr>
				<tr>
					<th align="center" width="25%">未还款金额</th>
					<td width="25%">${loanInfo.remainAmount}</td>
					<th align="center" width="25%">贷款开始时间</th>
					<td width="25%">${loanInfo.loanStartTime}</td>
				</tr>
				<tr>
					<th align="center" width="25%">贷款终止时间</th>
					<td width="25%">${loanInfo.loanFinishTime}</td>
					<th align="center" width="25%">逾期期数</th>
					<td width="25%">${loanInfo.currDelinquency}</td>
				</tr>
				<tr>
					<th align="center" width="25%">状态</th>
					<td width="25%">${loanInfo.status}</td>
					<th align="center" width="25%">&nbsp;</th>
					<td width="25%">&nbsp;</td>
				</tr>
			</table>
			<div align="center">
			<input type="button"
							value="返回列表" class="btn" onclick="backList();" />
			</div>
		</div>
	</div>
</body>
</html>