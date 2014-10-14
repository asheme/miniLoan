<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="/WEB-INF/views/common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>corp application check</title>
<script type="text/javascript">
</script>
</head>
<body>
	<div class="easyui-layout" data-options="fit : true,border : false">
		<div data-options="region:'north',border : false,collapsible:false"
			style="overflow: hidden; padding: 1px; height: 100%;">
			<div class="easyui-panel" data-options="border:false,fit:true"
				title="策略结果"
				style="padding-left: 2px; padding-right: 2px; padding-bottom: 1px; padding-top: 2px;">
				<table class="modifytable" width="100%">
					<tr>
						<th align="center" width="25%">决策结果</th>
						<td width="25%">通过</td>
						<th align="center" width="25%">决策原因</th>
						<td width="25%">综合评分高</td>
					</tr>
					<tr>
						<th align="center" width="25%">决策额度</th>
						<td width="25%">100000</td>
						<th align="center" width="25%">决策产品</th>
						<td width="25%">产品1</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>