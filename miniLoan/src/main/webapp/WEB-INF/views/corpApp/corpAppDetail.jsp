<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>view corp app info</title>
<script type="text/javascript">
<!--
$(function(){
});
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
					<th align="center" width="25%">借款人</th>
					<td width="25%">${corpApp.borrower}</td>
					<th align="center" width="25%">借款金额</th>
					<td width="25%">${corpApp.loanAmount}</td>
				</tr>
				<tr>
					<th align="center" width="25%">借款期限</th>
					<td width="25%">${corpApp.loanPeriod}</td>
					<th align="center" width="25%">企业名称</th>
					<td width="25%">${corpApp.compName}</td>
				</tr>

				<tr>
					<th align="center" width="25%">注册地址</th>
					<td width="25%">${corpApp.regAddr}</td>
					<th align="center" width="25%">企业性质</th>
					<td width="25%">${corpApp.compType}</td>
				</tr>
				<tr>
					<th align="center" width="25%">成立时间</th>
					<td width="25%">${corpApp.establishDate}</td>
					<th align="center" width="25%">法定代表人</th>
					<td width="25%">${corpApp.legalPerson}</td>
				</tr>
				<tr>
					<th align="center" width="25%">法人证件类型</th>
					<td width="25%">${corpApp.lpIdType}</td>
					<th align="center" width="25%">法人证件号码</th>
					<td width="25%">${corpApp.lpIdNo}</td>
				</tr>
				<tr>
					<th align="center" width="25%">法人籍贯</th>
					<td width="25%">${corpApp.lpNative}</td>
					<th align="center" width="25%">法人住址</th>
					<td width="25%">${corpApp.lpAddr}</td>
				</tr>
				<tr>
					<th align="center" width="25%">企业经营范围</th>
					<td width="25%">${corpApp.busiScope}</td>
					<th align="center" width="25%">上年底资产总额</th>
					<td width="25%">${corpApp.lastYearAssets}</td>
				</tr>
				<tr>
					<th align="center" width="25%">上年底负债总额</th>
					<td width="25%">${corpApp.lastYearLiabilities}</td>
					<th align="center" width="25%">上年度销售总额</th>
					<td width="25%">${corpApp.lastYearSalesAmount}</td>
				</tr>
				<tr>
					<th align="center" width="25%">上年度例如总额</th>
					<td width="25%">${corpApp.lastYearProfit}</td>
					<th align="center" width="25%">上年度纳税总额</th>
					<td width="25%">${corpApp.lastYearPayTax}</td>
				</tr>
				<tr>
					<th align="center" width="25%">近六个月平均银行流水</th>
					<td width="25%">${corpApp.avgCashFlowInSixmth}</td>
					<th align="center" width="25%">担保方式</th>
					<td width="25%">${corpApp.guaranteeType}</td>
				</tr>
				<tr>
					<th align="center" width="25%">房产类别</th>
					<td width="25%">${corpApp.houseType}</td>
					<th align="center" width="25%">土地性质</th>
					<td width="25%">${corpApp.landStatus}</td>
				</tr>
				<tr>
					<th align="center" width="25%">房产(土地)位置</th>
					<td width="25%">${corpApp.houseLocation}</td>
					<th align="center" width="25%">房产(土地)证号</th>
					<td width="25%">${corpApp.houseCertificationNo}</td>
				</tr>
				<tr>
					<th align="center" width="25%">面积</th>
					<td width="25%">${corpApp.buildingArea}</td>
					<th align="center" width="25%">是否出租</th>
					<td width="25%">${corpApp.isRent}</td>

				</tr>
				<tr>
					<th align="center" width="25%">月租金</th>
					<td width="25%">${corpApp.monthlyRent}</td>
					<th align="center" width="25%">购买价值</th>
					<td width="25%">${corpApp.purchaseValue}</td>

				</tr>
				<tr>
					<th align="center" width="25%">价值评估</th>
					<td width="25%">${corpApp.estimatedValue}</td>
					<th align="center" width="25%">存货类别</th>
					<td width="25%">${corpApp.inventoryType}</td>

				</tr>
				<tr>
					<th align="center" width="25%">现存放位置</th>
					<td width="25%">${corpApp.storagePlace}</td>
					<th align="center" width="25%">是否有购买合同、增值税发票、收据等凭证</th>
					<td width="25%">${corpApp.hasContract}</td>

				</tr>
				<tr>
					<th align="center" width="25%">计量单位</th>
					<td width="25%">${corpApp.unit}</td>
					<th align="center" width="25%">购买单价</th>
					<td width="25%">${corpApp.unitPrice}</td>

				</tr>
				<tr>
					<th align="center" width="25%">市场价格</th>
					<td width="25%">${corpApp.marketPrice}</td>
					<th align="center" width="25%">库存量</th>
					<td width="25%">${corpApp.repertory}</td>

				</tr>
				<tr>
					<th align="center" width="25%">近一年最低库存量</th>
					<td width="25%">${corpApp.lowestRepertoryLastYear}</td>
					<th align="center" width="25%">有无特殊保管要求</th>
					<td width="25%">${corpApp.hasSpecialStorageRequire}</td>

				</tr>
				<tr>
					<th align="center" width="25%">保证企业名称</th>
					<td width="25%">${corpApp.ensureCompName}</td>
					<th align="center" width="25%">保证企业注册资本</th>
					<td width="25%">${corpApp.ensureCompRegCapital}</td>

				</tr>
				<tr>
					<th align="center" width="25%">保证企业总资产</th>
					<td width="25%">${corpApp.ensureCompAssets}</td>
					<th align="center" width="25%">保证企业净资产</th>
					<td width="25%">${corpApp.ensureCompNetAssets}</td>

				</tr>
				<tr>
					<th align="center" width="25%">保证人姓名</th>
					<td width="25%">${corpApp.guarantor}</td>
					<th align="center" width="25%">保证人证件类型</th>
					<td width="25%">${corpApp.guarantorIdType}</td>

				</tr>
				<tr>
					<th align="center" width="25%">保证人证件号码</th>
					<td width="25%">${corpApp.guarantorIdNo}</td>
					<th align="center" width="25%">保证人国籍</th>
					<td width="25%">${corpApp.guarantorNation}</td>

				</tr>
				<tr>
					<th align="center" width="25%">保证人住址</th>
					<td width="25%">${corpApp.guarantorHomeAddr}</td>
					<th align="center" width="25%">贷款用途</th>
					<td width="25%">${corpApp.loanUse}</td>

				</tr>
				<tr>
					<th align="center" width="25%">贷款产品</th>
					<td width="25%">${corpApp.loanProduct}</td>
					<th align="center" width="25%">贷款申请金额</th>
					<td width="25%">${corpApp.loanAmount2}</td>

				</tr>
				<tr>
					<th align="center" width="25%">贷款周期</th>
					<td width="25%">${corpApp.loanCycle}</td>
					<th align="center" width="25%">还款方式</th>
					<td width="25%">${corpApp.payMethod}</td>

				</tr>
				<tr>
					<th align="center" width="25%">放款账户</th>
					<td width="25%">${corpApp.lendAccount}</td>
					<th align="center" width="25%">还款账户</th>
					<td width="25%">${corpApp.payAccount}</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>