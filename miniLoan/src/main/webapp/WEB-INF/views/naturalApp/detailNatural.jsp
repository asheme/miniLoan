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
</head>
<body>
	<div id="updatePanel" class="easyui-panel" title="数据信息"
		data-options="border:false,fit:true"
		style="padding-left: 2px; padding-right: 2px; padding-bottom: 1px; padding-top: 2px;">
		<form id="modifyForm" method="post">
			<table class="modifytable" width="100%">
				<tr>
					<th colspan="4" align="left" height="20px"><strong>申请人信息</strong></th>
				</tr>
				<tr>
					<th align="center" width="25%">姓名</th>
					<td width="25%">${naturalApp.name}</td>
					<th align="center" width="25%">性别</th>
					<td width="25%">${naturalApp.gender}</td>
				</tr>
				<tr>
					<th align="center" width="25%">证件类型</th>
					<td width="25%">${naturalApp.idType}</td>
					<th align="center" width="25%">证件号码</th>
					<td width="25%">${naturalApp.idNo}</td>
				</tr>

				<tr>
					<th align="center" width="25%">证件签发日期</th>
					<td width="25%">${naturalApp.idSignDate}</td>
					<th align="center" width="25%">证件到期日期</th>
					<td width="25%">${naturalApp.idExpireDate}</td>
				</tr>
				<tr>
					<th align="center" width="25%">出生日期</th>
					<td width="25%">${naturalApp.birthday}</td>
					<th align="center" width="25%">年龄</th>
					<td width="25%">${naturalApp.age}</td>
				</tr>
				<tr>
					<th align="center" width="25%">国籍</th>
					<td width="25%">${naturalApp.nation}</td>
					<th align="center" width="25%">教育程度</th>
					<td width="25%">${naturalApp.educationLvl}</td>
				</tr>
				<tr>
					<th align="center" width="25%">婚姻状态</th>
					<td width="25%">${naturalApp.marriageStatus}</td>
					<th align="center" width="25%">政治面貌</th>
					<td width="25%">${naturalApp.politicsStatus}</td>
				</tr>
				<tr>
					<th align="center" width="25%">手机号码</th>
					<td width="25%">${naturalApp.mobile}</td>
					<th align="center" width="25%">固定电话</th>
					<td width="25%">${naturalApp.homePhone}</td>
				</tr>
				<tr>
					<th align="center" width="25%">电子邮箱</th>
					<td width="25%">${naturalApp.email}</td>
					<th align="center" width="25%">所属行业类型</th>
					<td width="25%">${naturalApp.industryType}</td>
				</tr>
				<tr>
					<th align="center" width="25%">单位名称</th>
					<td width="25%">${naturalApp.company}</td>
					<th align="center" width="25%">单位电话</th>
					<td width="25%">${naturalApp.compPhone}</td>
				</tr>
				<tr>
					<th align="center" width="25%">职务</th>
					<td width="25%">${naturalApp.position}</td>
					<th align="center" width="25%">工作年限</th>
					<td width="25%">${naturalApp.workYears}</td>
				</tr>
				<tr>
					<th align="center" width="25%">现单位工作开始时间</th>
					<td width="25%">${naturalApp.currJobStDate}</td>
					<th align="center" width="25%">单位地址</th>
					<td width="25%">${naturalApp.compAddr}</td>
				</tr>
				<tr>
					<th align="center" width="25%">单位地址邮编</th>
					<td width="25%">${naturalApp.compZip}</td>
					<th align="center" width="25%">家庭地址</th>
					<td width="25%">${naturalApp.homeAddr}</td>
				</tr>
				<tr>
					<th align="center" width="25%">家庭地址邮编</th>
					<td width="25%">${naturalApp.homeZip}</td>
					<th align="center" width="25%">住宅情况</th>
					<td width="25%">${naturalApp.residentStatus}</td>
				</tr>
				<tr>
					<th align="center" width="25%">居住开始时间</th>
					<td width="25%">${naturalApp.liveStartTime}</td>
					<th align="center" width="25%">拥有车辆品牌</th>
					<td width="25%">${naturalApp.carBrand}</td>
				</tr>
				<tr>
					<th align="center" width="25%">车牌号码</th>
					<td width="25%">${naturalApp.carNo}</td>
					<th align="center" width="25%">车辆情况</th>
					<td width="25%">${naturalApp.carStatus}</td>
				</tr>
				<tr>
					<th align="center" width="25%">车辆购买日期</th>
					<td width="25%">${naturalApp.carBuyDate}</td>
					<th align="center" width="25%">配偶姓名</th>
					<td width="25%">${naturalApp.spouseName}</td>
				</tr>
				<tr>
					<th align="center" width="25%">配偶证件类型</th>
					<td width="25%">${naturalApp.spouseIdType}</td>
					<th align="center" width="25%">配偶证件号码</th>
					<td width="25%">${naturalApp.spouseIdNo}</td>
				</tr>
				<tr>
					<th align="center" width="25%">配偶证件签发日期</th>
					<td width="25%">${naturalApp.spouseIdSignDate}</td>
					<th align="center" width="25%">配偶证件到期日期</th>
					<td width="25%">${naturalApp.spouseIdExpireDate}</td>
				</tr>
				<tr>
					<th align="center" width="25%">配偶行业类型</th>
					<td width="25%">${naturalApp.spouseIndustryType}</td>
					<th align="center" width="25%">配偶单位名称</th>
					<td width="25%">${naturalApp.spouseCompany}</td>
				</tr>
				<tr>
					<th align="center" width="25%">配偶职务</th>
					<td width="25%">${naturalApp.spousePosition}</td>
					<th align="center" width="25%">配偶单位地址</th>
					<td width="25%">${naturalApp.spouseCompAddr}</td>
				</tr>
				<tr>
					<th align="center" width="25%">配偶单位地址邮编</th>
					<td width="25%">${naturalApp.spouseCompZip}</td>
					<th align="center" width="25%">配偶手机号码</th>
					<td width="25%">${naturalApp.spouseMobile}</td>
				</tr>
				<tr>
					<th align="center" width="25%">配偶固定电话</th>
					<td width="25%">${naturalApp.spouseHomePhone}</td>
					<th align="center" width="25%">配偶电子邮箱</th>
					<td width="25%">${naturalApp.spouseEmail}</td>
				</tr>
				<tr>
					<th align="center" width="25%">联系人姓名</th>
					<td width="25%">${naturalApp.linkmanName}</td>
					<th align="center" width="25%">联系人证件类型</th>
					<td width="25%">${naturalApp.linkmanIdType}</td>
				</tr>
				<tr>
					<th align="center" width="25%">联系人证件号码</th>
					<td width="25%">${naturalApp.linkmanIdNo}</td>
					<th align="center" width="25%">联系人证件签发日期</th>
					<td width="25%">${naturalApp.linkmanIdSignDate}</td>
				</tr>
				<tr>
					<th align="center" width="25%">联系人证件到期日期</th>
					<td width="25%">${naturalApp.linkmanIdExpireDate}</td>
					<th align="center" width="25%">联系人行业类型</th>
					<td width="25%">${naturalApp.linkmanIndustryType}</td>
				</tr>
				<tr>
					<th align="center" width="25%">联系人单位名称</th>
					<td width="25%">${naturalApp.linkmanCompany}</td>
					<th align="center" width="25%">联系人职务</th>
					<td width="25%">${naturalApp.linkmanPosition}</td>
				</tr>
				<tr>
					<th align="center" width="25%">联系人单位地址</th>
					<td width="25%">${naturalApp.linkmanCompAddr}</td>
					<th align="center" width="25%">联系人单位地址邮编</th>
					<td width="25%">${naturalApp.linkmanCompZip}</td>
				</tr>
				<tr>
					<th align="center" width="25%">联系人手机号码</th>
					<td width="25%">${naturalApp.linkmanMobile}</td>
					<th align="center" width="25%">联系人固定电话</th>
					<td width="25%"><${naturalApp.linkmanHomePhone}</td>
				</tr>
				<tr>
					<th align="center" width="25%">联系人电子邮箱</th>
					<td width="25%">${naturalApp.linkmanEmail}</td>
					<th align="center" width="25%"></th>
					<td width="25%"></td>
				</tr>
				<tr>
					<th align="center" width="25%">贷款产品</th>
					<td width="25%">${naturalApp.loanProduct}</td>
					<th align="center" width="25%">贷款申请金额</th>
					<td width="25%">${naturalApp.loanAmount}</td>
				</tr>
				<tr>
					<th align="center" width="25%">还款周期</th>
					<td width="25%">${naturalApp.loanCycle}</td>
					<th align="center" width="25%">计息方式</th>
					<td width="25%">${naturalApp.interestType}</td>
				</tr>

				<tr>
					<td colspan="4" align="center"><input type="button" value="编辑"
						class="btn" onclick="javascript:saveObj();" /> <input
						type="button" value="返回" class="btn"
						onclick="javascript:backList();" /> <input type="hidden"
						name="rescId" value="${resc.rescId}" /> <input type="hidden"
						name="flag" value="${flag}"></td>
				</tr>

			</table>
		</form>
	</div>
</body>
</html>