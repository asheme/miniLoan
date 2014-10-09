<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>create or modify company loan application</title>
<script type="text/javascript">
	$(function() {
		$("#birthday").datebox();
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
		
		//初始化combobox
		//initComboboxContent("isLeaf", "YES_OR_NO");
	});

	//返回列表页
	function backList() {
		window.location.href = '${pageContext.request.contextPath}/menu/corpAppList.do';
	}

	//保存信息
	function saveObjCorp() {
		/* if (!validate()) {
			return;
		} */

		$('#modifyForm').form('submit', {
			url : '${pageContext.request.contextPath}/corp/app/modifyCorpApp.do?flag='+window.parent.flag+'&appNo='+window.parent.appNo,
			success : function(result) {
				try {
					var r = $.parseJSON(result);
					if (r.success) {
						window.parent.appNo=r.appNo;
						window.parent.flag="UPDATE";
						parent.document.getElementById("attachIframe").src='${pageContext.request.contextPath}/natural/attach/toNaturalAttachList.do?appNo='+window.parent.appNo;
						document.frames('attachIframe').location.reload();	
						parent.document.getElementById("mortgageIframe").src='${pageContext.request.contextPath}/natural/mortgage/toMortgageList.do?appNo='+window.parent.appNo;
						document.frames('mortgageIframe').location.reload();
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

	function clearCorpApp() {
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
					<th align="center" width="25%">借款人</th>
					<td width="25%"><input class="easyui-validatebox"
						name="borrower" value="${corpApp.borrower}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="borrower" /></td>
					<th align="center" width="25%">借款金额</th>
					<td width="25%"><input class="easyui-validatebox"
						name="loanAmount" value="${corpApp.loanAmount}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="loanAmount" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">借款期限</th>
					<td width="25%"><input class="easyui-validatebox"
						name="loanPeriod" value="${corpApp.loanPeriod}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="loanPeriod" /></td>
					<th align="center" width="25%">企业名称</th>
					<td width="25%"><input class="easyui-validatebox"
						name="compName" value="${corpApp.compName}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="compName" /></td>
				</tr>

				<tr>
					<th align="center" width="25%">注册地址</th>
					<td width="25%"><input class="easyui-validatebox"
						name="regAddr" value="${corpApp.regAddr}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="regAddr" /></td>
					<th align="center" width="25%">企业性质</th>
					<td width="25%"><input class="easyui-validatebox"
						name="compType" value="${corpApp.compType}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="compType" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">成立时间</th>
					<td width="25%"><input class="easyui-validatebox"
						dateFormat="date" name="establishDate"
						value="${corpApp.establishDate}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="establishDate" /></td>
					<th align="center" width="25%">法定代表人</th>
					<td width="25%"><input class="easyui-validatebox"
						name="legalPerson" value="${corpApp.legalPerson}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="legalPerson" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">法人证件类型</th>
					<td width="25%"><input class="easyui-validatebox"
						name="lpIdType" value="${corpApp.lpIdType}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="lpIdType" /></td>
					<th align="center" width="25%">法人证件号码</th>
					<td width="25%"><input class="easyui-validatebox"
						name="lpIdNo" value="${corpApp.lpIdNo}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="lpIdNo" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">法人籍贯</th>
					<td width="25%"><input class="easyui-validatebox"
						name="lpNative" value="${corpApp.lpNative}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="lpNative" /></td>
					<th align="center" width="25%">法人住址</th>
					<td width="25%"><input class="easyui-validatebox"
						name="lpAddr" value="${corpApp.lpAddr}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="lpAddr" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">企业经营范围</th>
					<td width="25%"><input class="easyui-validatebox"
						name="busiScope" value="${corpApp.busiScope}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="busiScope" /></td>
					<th align="center" width="25%">上年底资产总额</th>
					<td width="25%"><input class="easyui-validatebox"
						name="lastYearAssets" value="${corpApp.lastYearAssets}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="lastYearAssets" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">上年底负债总额</th>
					<td width="25%"><input class="easyui-validatebox"
						name="lastYearLiabilities" value="${corpApp.lastYearLiabilities}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="lastYearLiabilities" /></td>
					<th align="center" width="25%">上年度销售总额</th>
					<td width="25%"><input class="easyui-validatebox"
						name="lastYearSalesAmount" value="${corpApp.lastYearSalesAmount}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="lastYearSalesAmount" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">上年度例如总额</th>
					<td width="25%"><input class="easyui-validatebox"
						name="lastYearProfit" value="${corpApp.lastYearProfit}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="lastYearProfit" /></td>
					<th align="center" width="25%">上年度纳税总额</th>
					<td width="25%"><input class="easyui-validatebox"
						name="lastYearPayTax" value="${corpApp.lastYearPayTax}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="lastYearPayTax" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">近六个月平均银行流水</th>
					<td width="25%"><input class="easyui-validatebox"
						name="avgCashFlowInSixmth" value="${corpApp.avgCashFlowInSixmth}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="avgCashFlowInSixmth" /></td>
					<th align="center" width="25%">担保方式</th>
					<td width="25%"><input class="easyui-validatebox"
						name="guaranteeType" value="${corpApp.guaranteeType}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="guaranteeType" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">房产类别</th>
					<td width="25%"><input class="easyui-validatebox"
						name="houseType" value="${corpApp.houseType}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="houseType" /></td>
					<th align="center" width="25%">土地性质</th>
					<td width="25%"><input class="easyui-validatebox"
						name="landStatus" value="${corpApp.landStatus}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="landStatus" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">房产(土地)位置</th>
					<td width="25%"><input class="easyui-validatebox"
						name="houseLocation" value="${corpApp.houseLocation}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="houseLocation" /></td>
					<th align="center" width="25%">房产(土地)证号</th>
					<td width="25%"><input class="easyui-validatebox"
						name="houseCertificationNo"
						value="${corpApp.houseCertificationNo}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="houseCertificationNo" /></td>
				</tr>
				<tr>
					<th align="center" width="25%">面积</th>
					<td width="25%"><input class="easyui-validatebox"
						name="buildingArea" value="${corpApp.buildingArea}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="buildingArea" /></td>
					<th align="center" width="25%">是否出租</th>
					<td width="25%"><input class="easyui-validatebox"
						name="isRent" value="${corpApp.isRent}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="isRent" /></td>

				</tr>
				<tr>
					<th align="center" width="25%">月租金</th>
					<td width="25%"><input class="easyui-validatebox"
						name="monthlyRent" value="${corpApp.monthlyRent}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="monthlyRent" /></td>
					<th align="center" width="25%">购买价值</th>
					<td width="25%"><input class="easyui-validatebox"
						name="purchaseValue" value="${corpApp.purchaseValue}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="purchaseValue" /></td>

				</tr>
				<tr>
					<th align="center" width="25%">价值评估</th>
					<td width="25%"><input class="easyui-validatebox"
						name="estimatedValue" value="${corpApp.estimatedValue}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="estimatedValue" /></td>
					<th align="center" width="25%">存货类别</th>
					<td width="25%"><input class="easyui-validatebox"
						name="inventoryType" value="${corpApp.inventoryType}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="inventoryType" /></td>

				</tr>
				<tr>
					<th align="center" width="25%">现存放位置</th>
					<td width="25%"><input class="easyui-validatebox"
						name="storagePlace" value="${corpApp.storagePlace}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="storagePlace" /></td>
					<th align="center" width="25%">是否有购买合同、增值税发票、收据等凭证</th>
					<td width="25%"><input class="easyui-validatebox"
						name="hasContract" value="${corpApp.hasContract}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="hasContract" /></td>

				</tr>
				<tr>
					<th align="center" width="25%">计量单位</th>
					<td width="25%"><input class="easyui-validatebox" name="unit"
						value="${corpApp.unit}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="unit" /></td>
					<th align="center" width="25%">购买单价</th>
					<td width="25%"><input class="easyui-validatebox"
						name="unitPrice" value="${corpApp.unitPrice}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="unitPrice" /></td>

				</tr>
				<tr>
					<th align="center" width="25%">市场价格</th>
					<td width="25%"><input class="easyui-validatebox"
						name="marketPrice" value="${corpApp.marketPrice}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="marketPrice" /></td>
					<th align="center" width="25%">库存量</th>
					<td width="25%"><input class="easyui-validatebox"
						name="repertory" value="${corpApp.repertory}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="repertory" /></td>

				</tr>
				<tr>
					<th align="center" width="25%">近一年最低库存量</th>
					<td width="25%"><input class="easyui-validatebox"
						name="lowestRepertoryLastYear"
						value="${corpApp.lowestRepertoryLastYear}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="lowestRepertoryLastYear" /></td>
					<th align="center" width="25%">有无特殊保管要求</th>
					<td width="25%"><input class="easyui-validatebox"
						name="hasSpecialStorageRequire"
						value="${corpApp.hasSpecialStorageRequire}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="hasSpecialStorageRequire" /></td>

				</tr>
				<tr>
					<th align="center" width="25%">保证企业名称</th>
					<td width="25%"><input class="easyui-validatebox"
						name="ensureCompName" value="${corpApp.ensureCompName}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="ensureCompName" /></td>
					<th align="center" width="25%">保证企业注册资本</th>
					<td width="25%"><input class="easyui-validatebox"
						name="ensureCompRegCapital"
						value="${corpApp.ensureCompRegCapital}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="ensureCompRegCapital" /></td>

				</tr>
				<tr>
					<th align="center" width="25%">保证企业总资产</th>
					<td width="25%"><input class="easyui-validatebox"
						name="ensureCompAssets" value="${corpApp.ensureCompAssets}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="ensureCompAssets" /></td>
					<th align="center" width="25%">保证企业净资产</th>
					<td width="25%"><input class="easyui-validatebox"
						name="ensureCompNetAssets" value="${corpApp.ensureCompNetAssets}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="ensureCompNetAssets" /></td>

				</tr>
				<tr>
					<th align="center" width="25%">保证人姓名</th>
					<td width="25%"><input class="easyui-validatebox"
						name="guarantor" value="${corpApp.guarantor}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="guarantor" /></td>
					<th align="center" width="25%">保证人证件类型</th>
					<td width="25%"><input class="easyui-validatebox"
						name="guarantorIdType" value="${corpApp.guarantorIdType}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="guarantorIdType" /></td>

				</tr>
				<tr>
					<th align="center" width="25%">保证人证件号码</th>
					<td width="25%"><input class="easyui-validatebox"
						name="guarantorIdNo" value="${corpApp.guarantorIdNo}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="guarantorIdNo" /></td>
					<th align="center" width="25%">保证人国籍</th>
					<td width="25%"><input class="easyui-validatebox"
						name="guarantorNation" value="${corpApp.guarantorNation}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="guarantorNation" /></td>

				</tr>
				<tr>
					<th align="center" width="25%">保证人住址</th>
					<td width="25%"><input class="easyui-validatebox"
						name="guarantorHomeAddr" value="${corpApp.guarantorHomeAddr}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="guarantorHomeAddr" /></td>
					<th align="center" width="25%">贷款用途</th>
					<td width="25%"><input class="easyui-validatebox"
						name="loanUse" value="${corpApp.loanUse}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="loanUse" /></td>

				</tr>
				<tr>
					<th align="center" width="25%">贷款产品</th>
					<td width="25%"><input class="easyui-validatebox"
						name="loanProduct" value="${corpApp.loanProduct}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="loanProduct" /></td>
					<th align="center" width="25%">贷款申请金额</th>
					<td width="25%"><input class="easyui-validatebox"
						name="loanAmount2" value="${corpApp.loanAmount2}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="loanAmount2" /></td>

				</tr>
				<tr>
					<th align="center" width="25%">贷款周期</th>
					<td width="25%"><input class="easyui-validatebox"
						name="loanCycle" value="${corpApp.loanCycle}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="loanCycle" /></td>
					<th align="center" width="25%">还款方式</th>
					<td width="25%"><input class="easyui-validatebox"
						name="payMethod" value="${corpApp.payMethod}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="payMethod" /></td>

				</tr>
				<tr>
					<th align="center" width="25%">放款账户</th>
					<td width="25%"><input class="easyui-validatebox"
						name="lendAccount" value="${corpApp.lendAccount}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="lendAccount" /></td>
					<th align="center" width="25%">还款账户</th>
					<td width="25%"><input class="easyui-validatebox"
						name="payAccount" value="${corpApp.payAccount}"
						data-options="required:false,validType:'length[0,30]'"
						style="width: 250px;" id="payAccount" /></td>

				</tr>


				<tr>
					<td colspan="4" align="center"><input type="button" value="保存"
						class="btn" onclick="saveObjCorp();" /> <input type="button"
						value="清空" class="btn" onclick="clearCorpApp();" /> <%-- <input type="hidden"
						name="appNo" value="${corpApp.appNo}" /> <input type="hidden"
						name="flag" value="${flag}"></td> --%>
				</tr>

			</table>
		</form>
	</div>
</body>