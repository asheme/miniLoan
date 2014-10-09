<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	$('input[name="checkResult"]').each(function(){
		var t=$(this).val();
		if(t=='${checkResult.checkResult}'){
			$(this).attr("checked",true);
			}
	});
});

//保存信息
function saveObj() {
	$('#modifyForm').form('submit', {
		url : '${pageContext.request.contextPath}//app/checkresult/saveCheckResult.do',
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

//返回列表页
function backList() {
	window.location.href = '${pageContext.request.contextPath}/menu/appSummaryList.do';
}
</script>
</head>
<body>
	<div id="updatePanel" class="easyui-panel" data-options="border:false,fit:true"
		style="padding-left: 2px; padding-right: 2px; padding-bottom: 1px; padding-top: 2px;">
		<form id="modifyForm" method="post">
			<table class="modifytable" width="100%">
				<tr>
					<th align="center" width="25%">借款人</th>
					<td width="25%">${checkApp.borrower}</td>
					<th align="center" width="25%">借款金额</th>
					<td width="25%">${checkApp.loanAmount}</td>
				</tr>
				<tr>
					<th align="center" width="25%">借款期限</th>
					<td width="25%">${checkApp.loanPeriod}</td>
					<th align="center" width="25%">企业名称</th>
					<td width="25%">${checkApp.compName}</td>
				</tr>

				<tr>
					<th align="center" width="25%">注册地址</th>
					<td width="25%">${checkApp.regAddr}</td>
					<th align="center" width="25%">企业性质</th>
					<td width="25%">${checkApp.compType}</td>
				</tr>
				<tr>
					<th align="center" width="25%">成立时间</th>
					<td width="25%">${checkApp.establishDate}</td>
					<th align="center" width="25%">法定代表人</th>
					<td width="25%">${checkApp.legalPerson}</td>
				</tr>
				<tr>
					<th align="center" width="25%">法人证件类型</th>
					<td width="25%">${checkApp.lpIdType}</td>
					<th align="center" width="25%">法人证件号码</th>
					<td width="25%">${checkApp.lpIdNo}</td>
				</tr>
				<tr>
					<th align="center" width="25%">法人籍贯</th>
					<td width="25%">${checkApp.lpNative}</td>
					<th align="center" width="25%">法人住址</th>
					<td width="25%">${checkApp.lpAddr}</td>
				</tr>
				<tr>
					<th align="center" width="25%">企业经营范围</th>
					<td width="25%">${checkApp.busiScope}</td>
					<th align="center" width="25%">上年底资产总额</th>
					<td width="25%">${checkApp.lastYearAssets}</td>
				</tr>
				<tr>
					<th align="center" width="25%">上年底负债总额</th>
					<td width="25%">${checkApp.lastYearLiabilities}</td>
					<th align="center" width="25%">上年度销售总额</th>
					<td width="25%">${checkApp.lastYearSalesAmount}</td>
				</tr>
				<tr>
					<th align="center" width="25%">上年度例如总额</th>
					<td width="25%">${checkApp.lastYearProfit}</td>
					<th align="center" width="25%">上年度纳税总额</th>
					<td width="25%">${checkApp.lastYearPayTax}</td>
				</tr>
				<tr>
					<th align="center" width="25%">近六个月平均银行流水</th>
					<td width="25%">${checkApp.avgCashFlowInSixmth}</td>
					<th align="center" width="25%">担保方式</th>
					<td width="25%">${checkApp.guaranteeType}</td>
				</tr>
				<tr>
					<th align="center" width="25%">房产类别</th>
					<td width="25%">${checkApp.houseType}</td>
					<th align="center" width="25%">土地性质</th>
					<td width="25%">${checkApp.landStatus}</td>
				</tr>
				<tr>
					<th align="center" width="25%">房产(土地)位置</th>
					<td width="25%">${checkApp.houseLocation}</td>
					<th align="center" width="25%">房产(土地)证号</th>
					<td width="25%">${checkApp.houseCertificationNo}</td>
				</tr>
				<tr>
					<th align="center" width="25%">面积</th>
					<td width="25%">${checkApp.buildingArea}</td>
					<th align="center" width="25%">是否出租</th>
					<td width="25%">${checkApp.isRent}</td>

				</tr>
				<tr>
					<th align="center" width="25%">月租金</th>
					<td width="25%">${checkApp.monthlyRent}</td>
					<th align="center" width="25%">购买价值</th>
					<td width="25%">${checkApp.purchaseValue}</td>

				</tr>
				<tr>
					<th align="center" width="25%">价值评估</th>
					<td width="25%">${checkApp.estimatedValue}</td>
					<th align="center" width="25%">存货类别</th>
					<td width="25%">${checkApp.inventoryType}</td>

				</tr>
				<tr>
					<th align="center" width="25%">现存放位置</th>
					<td width="25%">${checkApp.storagePlace}</td>
					<th align="center" width="25%">是否有购买合同、增值税发票、收据等凭证</th>
					<td width="25%">${checkApp.hasContract}</td>

				</tr>
				<tr>
					<th align="center" width="25%">计量单位</th>
					<td width="25%">${checkApp.unit}</td>
					<th align="center" width="25%">购买单价</th>
					<td width="25%">${checkApp.unitPrice}</td>

				</tr>
				<tr>
					<th align="center" width="25%">市场价格</th>
					<td width="25%">${checkApp.marketPrice}</td>
					<th align="center" width="25%">库存量</th>
					<td width="25%">${checkApp.repertory}</td>

				</tr>
				<tr>
					<th align="center" width="25%">近一年最低库存量</th>
					<td width="25%">${checkApp.lowestRepertoryLastYear}</td>
					<th align="center" width="25%">有无特殊保管要求</th>
					<td width="25%">${checkApp.hasSpecialStorageRequire}</td>

				</tr>
				<tr>
					<th align="center" width="25%">保证企业名称</th>
					<td width="25%">${checkApp.ensureCompName}</td>
					<th align="center" width="25%">保证企业注册资本</th>
					<td width="25%">${checkApp.ensureCompRegCapital}</td>

				</tr>
				<tr>
					<th align="center" width="25%">保证企业总资产</th>
					<td width="25%">${checkApp.ensureCompAssets}</td>
					<th align="center" width="25%">保证企业净资产</th>
					<td width="25%">${checkApp.ensureCompNetAssets}</td>

				</tr>
				<tr>
					<th align="center" width="25%">保证人姓名</th>
					<td width="25%">${checkApp.guarantor}</td>
					<th align="center" width="25%">保证人证件类型</th>
					<td width="25%">${checkApp.guarantorIdType}</td>

				</tr>
				<tr>
					<th align="center" width="25%">保证人证件号码</th>
					<td width="25%">${checkApp.guarantorIdNo}</td>
					<th align="center" width="25%">保证人国籍</th>
					<td width="25%">${checkApp.guarantorNation}</td>

				</tr>
				<tr>
					<th align="center" width="25%">保证人住址</th>
					<td width="25%">${checkApp.guarantorHomeAddr}</td>
					<th align="center" width="25%">贷款用途</th>
					<td width="25%">${checkApp.loanUse}</td>

				</tr>
				<tr>
					<th align="center" width="25%">贷款产品</th>
					<td width="25%">${checkApp.loanProduct}</td>
					<th align="center" width="25%">贷款申请金额</th>
					<td width="25%">${checkApp.loanAmount2}</td>

				</tr>
				<tr>
					<th align="center" width="25%">贷款周期</th>
					<td width="25%">${checkApp.loanCycle}</td>
					<th align="center" width="25%">还款方式</th>
					<td width="25%">${checkApp.payMethod}</td>

				</tr>
				<tr>
					<th align="center" width="25%">放款账户</th>
					<td width="25%">${checkApp.lendAccount}</td>
					<th align="center" width="25%">还款账户</th>
					<td width="25%">${checkApp.payAccount}</td>

				</tr>
			</table>
		</form>
	</div>
</body>
</html>