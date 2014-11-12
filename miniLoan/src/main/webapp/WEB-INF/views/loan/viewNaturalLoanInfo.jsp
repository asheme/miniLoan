<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>view Natural Loan info</title>
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
					<td width="25%">${naturalCustInfo.custNo}</td>
					<th align="center" width="25%">姓名</th>
					<td width="25%">${naturalCustInfo.name}</td>
				</tr>
				<tr>
					<th align="center" width="25%">证件类型</th>
					<td width="25%">${naturalCustInfo.idType}</td>
					<th align="center" width="25%">证件号码</th>
					<td width="25%">${naturalCustInfo.idNo}</td>
				</tr>

				<tr>
					<th align="center" width="25%">性别</th>
					<td width="25%" class='date'>${naturalCustInfo.gender}</td>
					<th align="center" width="25%">出生日期</th>
					<td width="25%" class='date'>${naturalCustInfo.birthday}</td>
				</tr>
				<tr>
					<th align="center" width="25%">年龄</th>
					<td width="25%">${naturalCustInfo.age}</td>
					<th align="center" width="25%">国籍</th>
					<td width="25%">${naturalCustInfo.nation}</td>
				</tr>
				<tr>
					<th align="center" width="25%">教育程度</th>
					<td width="25%">${naturalCustInfo.educationLvl}</td>
					<th align="center" width="25%">政治面貌</th>
					<td width="25%">${naturalCustInfo.politicsStatus}</td>
				</tr>
				<tr>
					<th align="center" width="25%">手机号码</th>
					<td width="25%">${naturalCustInfo.mobile}</td>
					<th align="center" width="25%">固定电话</th>
					<td width="25%">${naturalCustInfo.homePhone}</td>
				</tr>
				<tr>
					<th align="center" width="25%">固定电话</th>
					<td width="25%">${naturalCustInfo.homePhone}</td>
					<th align="center" width="25%">所属行业类型</th>
					<td width="25%">${naturalCustInfo.industryType}</td>
				</tr>
				<tr>
					<th align="center" width="25%">单位名称</th>
					<td width="25%">${naturalCustInfo.company}</td>
					<th align="center" width="25%">职务</th>
					<td width="25%">${naturalCustInfo.position}</td>
				</tr>
				<tr>
					<th align="center" width="25%">工作年限</th>
					<td width="25%">${naturalCustInfo.workYears}</td>
					<th align="center" width="25%">现单位工作开始时间</th>
					<td width="25%" class='date'>${naturalCustInfo.currJobStDate}</td>
				</tr>
				<tr>
					<th align="center" width="25%">单位地址</th>
					<td width="25%">${naturalCustInfo.compAddr}</td>
					<th align="center" width="25%">单位地址邮编</th>
					<td width="25%">${naturalCustInfo.compZip}</td>
				</tr>
				<tr>
					<th align="center" width="25%">单位地址邮编</th>
					<td width="25%">${naturalCustInfo.compZip}</td>
					<th align="center" width="25%">家庭地址邮编</th>
					<td width="25%">${naturalCustInfo.homeZip}</td>
				</tr>
				<tr>
					<th align="center" width="25%">住宅情况</th>
					<td width="25%">${naturalCustInfo.residentStatus}</td>
					<th align="center" width="25%">居住开始时间</th>
					<td width="25%" class='date'>${naturalCustInfo.liveStartTime}</td>
				</tr>
				<tr>
					<th align="center" width="25%">拥有车辆品牌</th>
					<td width="25%">${naturalCustInfo.carBrand}</td>
					<th align="center" width="25%">车牌号码</th>
					<td width="25%">${naturalCustInfo.carNo}</td>
				</tr>
				<tr>
					<th align="center" width="25%">车辆情况</th>
					<td width="25%">${naturalCustInfo.carStatus}</td>
					<th align="center" width="25%">车辆购买日期</th>
					<td width="25%" class='date'>${naturalCustInfo.carBuyDate}</td>
				</tr>
				<tr>
					<th align="center" width="25%">总资产</th>
					<td width="25%">${naturalCustInfo.deposit}</td>
					<th align="center" width="25%">股票、有价证券价值</th>
					<td width="25%">${naturalCustInfo.stockValue}</td>
				</tr>
				<tr>
					<th align="center" width="25%">月收入</th>
					<td width="25%">${naturalCustInfo.monthIncome}</td>
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