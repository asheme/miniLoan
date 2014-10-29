<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>view Strategy Result</title>
<script type="text/javascript">
<!--
	$(function() {

	});
//-->
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit : true,border : false">
		<div data-options="region:'center',title:'完整性检查结果',border:false"
			style="overflow: hidden; padding-left: 1px; padding-right: 1px; padding-bottom: 1px; padding-top: 1px;"
			align="center">
			<table class="queryTable" width="100%">
				<tr>
					<th colspan="3" align="left" width="10%"><B>系统决策排除原因</B></th>
				</tr>
				<c:if test="${fn:length(sysDecisionExcludeList) eq 0}">
				<tr>
					<td colspan="3" align="center" width="10%">系统决策正常执行，未被排除。</th>
				</tr>
				</c:if>
				<c:forEach items="${sysDecisionExcludeList}" var="sysDecisionExclude"
					varStatus="index">
					<tr>
						<th align="center" width="10%">${index.count}</th>
						<td width="15%">${sysDecisionExclude.reasonCode}</td>
						<td width="75%">${sysDecisionExclude.reasonDesc}</td>
					</tr>
				</c:forEach>
			</table>
			<table class="queryTable" width="100%" style="margin-top:2px">
				<tr>
					<th colspan="4" align="left" width="10%"><B>系统决策执行结果</B></th>
				</tr>
					<tr>
						<th align="center" width="25%">授信结果</th>
						<td width="25%">${appStrategyResult.sysDecResult}</td>
						<th align="center" width="25%">授信额度</th>
						<td width="25%">${appStrategyResult.loanLimit}</td>
					</tr>
										<tr>
						<th align="center" width="25%">贷款利率</th>
						<td width="25%">${appStrategyResult.loanRate}</td>
						<th align="center" width="25%">決策评分</th>
						<td width="25%">${appStrategyResult.score}</td>
					</tr>
					<tr>
						<th align="center" width="25%">决策结果代码</th>
						<td width="25%">${appStrategyResult.reasonCode}</td>
						<th align="center" width="25%">决策时间</th>
						<td width="25%">${appStrategyResult.decisionTime}</td>
					</tr>
					<tr>
						<th align="center" width="25%">決策結果描述</th>
						<td colspan="3" width="75%">${appStrategyResult.reasonDesc}</td>
					</tr>					
			</table>
		</div>
	</div>
</body>
</html>