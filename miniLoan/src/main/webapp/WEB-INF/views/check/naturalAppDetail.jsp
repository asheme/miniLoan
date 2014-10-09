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
	$("td.date").each(function(){	
		var time=dateToStr($(this).text());
		$(this).text(time);
	});
	
});
//保存信息
function saveObj() {
	$('#modifyForm').form('submit', {
		url : '${pageContext.request.contextPath}/app/checkresult/saveCheckResult.do',
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
	<div id="updatePanel" class="easyui-panel"
		data-options="border:false,fit:true"
		style="padding-left: 2px; padding-right: 2px; padding-bottom: 1px; padding-top: 2px;">
		<form id="modifyForm" method="post">
			<table class="modifytable" width="100%">
				<tr>
					<th align="center" width="25%">姓名</th>
					<td width="25%">${checkApp.name}</td>
					<th align="center" width="25%">性别</th>
					<td width="25%">${checkApp.gender}</td>
				</tr>
				<tr>
					<th align="center" width="25%">证件类型</th>
					<td width="25%">${checkApp.idType}</td>
					<th align="center" width="25%">证件号码</th>
					<td width="25%">${checkApp.idNo}</td>
				</tr>

				<tr>
					<th align="center" width="25%">证件签发日期</th>
					<td width="25%" class='date'>${checkApp.idSignDate}</td>
					<th align="center" width="25%">证件到期日期</th>
					<td width="25%" class='date'>${checkApp.idExpireDate}</td>
				</tr>
				<tr>
					<th align="center" width="25%">出生日期</th>
					<td width="25%" class='date'>${checkApp.birthday}</td>
					<th align="center" width="25%">年龄</th>
					<td width="25%">${checkApp.age}</td>
				</tr>
				<tr>
					<th align="center" width="25%">国籍</th>
					<td width="25%">${checkApp.nation}</td>
					<th align="center" width="25%">教育程度</th>
					<td width="25%">${checkApp.educationLvl}</td>
				</tr>
				<tr>
					<th align="center" width="25%">政治面貌</th>
					<td width="25%">${checkApp.politicsStatus}</td>
					<th align="center" width="25%">手机号码</th>
					<td width="25%">${checkApp.mobile}</td>
				</tr>
				<tr>
					<th align="center" width="25%">固定电话</th>
					<td width="25%">${checkApp.homePhone}</td>
					<th align="center" width="25%">电子邮箱</th>
					<td width="25%">${checkApp.email}</td>
				</tr>
				<tr>
					<th align="center" width="25%">所属行业类型</th>
					<td width="25%">${checkApp.industryType}</td>
					<th align="center" width="25%">单位名称</th>
					<td width="25%">${checkApp.company}</td>
				</tr>
				<tr>
					<th align="center" width="25%">职务</th>
					<td width="25%">${checkApp.position}</td>
					<th align="center" width="25%">工作年限</th>
					<td width="25%">${checkApp.workYears}</td>
				</tr>
				<tr>
					<th align="center" width="25%">现单位工作开始时间</th>
					<td width="25%" class='date'>${checkApp.currJobStDate}</td>
					<th align="center" width="25%">单位地址</th>
					<td width="25%">${checkApp.compAddr}</td>
				</tr>
				<tr>
					<th align="center" width="25%">单位地址邮编</th>
					<td width="25%">${checkApp.compZip}</td>
					<th align="center" width="25%">家庭地址</th>
					<td width="25%">${checkApp.homeAddr}</td>
				</tr>
				<tr>
					<th align="center" width="25%">家庭地址邮编</th>
					<td width="25%">${checkApp.homeZip}</td>
					<th align="center" width="25%">住宅情况</th>
					<td width="25%">${checkApp.residentStatus}</td>
				</tr>
				<tr>
					<th align="center" width="25%">居住开始时间</th>
					<td width="25%" class='date'>${checkApp.liveStartTime}</td>
					<th align="center" width="25%">拥有车辆品牌</th>
					<td width="25%">${checkApp.carBrand}</td>
				</tr>
				<tr>
					<th align="center" width="25%">车牌号码</th>
					<td width="25%">${checkApp.carNo}</td>
					<th align="center" width="25%">车辆情况</th>
					<td width="25%">${checkApp.carStatus}</td>
				</tr>
				<tr>
					<th align="center" width="25%">车辆购买日期</th>
					<td width="25%" class='date'>${checkApp.carBuyDate}</td>
					<th align="center" width="25%">配偶姓名</th>
					<td width="25%">${checkApp.spouseName}</td>
				</tr>
				<tr>
					<th align="center" width="25%">配偶证件类型</th>
					<td width="25%">${checkApp.spouseIdType}</td>
					<th align="center" width="25%">配偶证件号码</th>
					<td width="25%">${checkApp.spouseIdNo}</td>
				</tr>
				<tr>
					<th align="center" width="25%">配偶证件签发日期</th>
					<td width="25%" class='date'>${checkApp.spouseIdSignDate}</td>
					<th align="center" width="25%">配偶证件到期日期</th>
					<td width="25%" class='date'>${checkApp.spouseIdExpireDate}</td>
				</tr>
				<tr>
					<th align="center" width="25%">配偶行业类型</th>
					<td width="25%">${checkApp.spouseIndustryType}</td>
					<th align="center" width="25%">配偶单位名称</th>
					<td width="25%">${checkApp.spouseCompany}</td>
				</tr>
				<tr>
					<th align="center" width="25%">配偶职务</th>
					<td width="25%">${checkApp.spousePosition}</td>
					<th align="center" width="25%">配偶单位地址</th>
					<td width="25%">${checkApp.spouseCompAddr}</td>
				</tr>
				<tr>
					<th align="center" width="25%">配偶单位地址邮编</th>
					<td width="25%">${checkApp.spouseCompZip}</td>
					<th align="center" width="25%">配偶手机号码</th>
					<td width="25%">${checkApp.spouseMobile}</td>
				</tr>
				<tr>
					<th align="center" width="25%">配偶固定电话</th>
					<td width="25%">${checkApp.spouseHomePhone}</td>
					<th align="center" width="25%">配偶电子邮箱</th>
					<td width="25%">${checkApp.spouseEmail}</td>
				</tr>
				<tr>
					<th align="center" width="25%">联系人姓名</th>
					<td width="25%">${checkApp.linkmanName}</td>
					<th align="center" width="25%">联系人证件类型</th>
					<td width="25%">${checkApp.linkmanIdType}</td>
				</tr>
				<tr>
					<th align="center" width="25%">联系人证件号码</th>
					<td width="25%">${checkApp.linkmanIdNo}</td>
					<th align="center" width="25%">联系人证件签发日期</th>
					<td width="25%" class='date'>${checkApp.linkmanIdSignDate}</td>
				</tr>
				<tr>
					<th align="center" width="25%">联系人证件到期日期</th>
					<td width="25%" class='date'>${checkApp.linkmanIdExpireDate}</td>
					<th align="center" width="25%">联系人行业类型</th>
					<td width="25%">${checkApp.linkmanIndustryType}</td>
				</tr>
				<tr>
					<th align="center" width="25%">联系人单位名称</th>
					<td width="25%">${checkApp.linkmanCompany}</td>
					<th align="center" width="25%">联系人职务</th>
					<td width="25%">${checkApp.linkmanPosition}</td>
				</tr>
				<tr>
					<th align="center" width="25%">联系人单位地址</th>
					<td width="25%">${checkApp.linkmanCompAddr}</td>
					<th align="center" width="25%">联系人单位地址邮编</th>
					<td width="25%">${checkApp.linkmanCompZip}</td>
				</tr>
				<tr>
					<th align="center" width="25%">联系人手机号码</th>
					<td width="25%">${checkApp.linkmanMobile}</td>
					<th align="center" width="25%">联系人固定电话</th>
					<td width="25%">${checkApp.linkmanHomePhone}</td>
				</tr>
				<tr>
					<th align="center" width="25%">联系人电子邮箱</th>
					<td width="25%">${checkApp.linkmanEmail}</td>
					<th align="center" width="25%"></th>
					<td width="25%"></td>
				</tr>
				<tr>
					<th align="center" width="25%">贷款产品</th>
					<td width="25%">${checkApp.loanProduct}</td>
					<th align="center" width="25%">贷款申请金额</th>
					<td width="25%">${checkApp.loanAmount}</td>
				</tr>
				<tr>
					<th align="center" width="25%">贷款周期</th>
					<td width="25%">${checkApp.loanCycle}</td>
					<th align="center" width="25%">放款账户</th>
					<td width="25%">${checkApp.lendAccount}</td>
				</tr>
				<tr>

					<th align="center" width="25%">还款方式</th>
					<td width="25%">${checkApp.payMethod}</td>
					<th align="center" width="25%">还款账户</th>
					<td width="25%">${checkApp.payAccount}</td>
				</tr>

			</table>
		</form>
	</div>
</body>
</html>