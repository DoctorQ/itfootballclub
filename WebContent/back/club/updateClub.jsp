<%@ page language="java" import="java.util.*,com.aodci.bean.*"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	Club club = (Club)request.getAttribute("club");
%>

<link href="<%=basePath%>back/images/skin.css" rel="stylesheet"
	type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #EEF2FB;
}
-->
</style>
<body>
	<h1 align="center">
		修改俱乐部信息：<%=club.getcName() %>
	</h1>
	<div align="center" id = "club">
		<form action="updateClub" method="post">
		
		<table >
			<tr>
				<td><input type="hidden" name="id" value="<%=club.getId() %>"></td>
			</tr>
			<tr>
				<td>创建时间</td>
				<td><input type="text" name="ctime" value="<%=club.getcTime() %>" >格式:YYYY-MM-DD</td>
			</tr>
			<tr>
				<td>主场</td>
				<td><input type="text" name="homefield" value="<%=club.getHomeField() %>"></td>
			</tr>
			<tr>
				<td>教练</td>
				<td><input type="text" name="coach" value="<%=club.getCoach() %>"></td>
			</tr>
			<tr>
				<td>所在城市</td>
				<td><input type="text" name="location" value="<%=club.getLocation() %>"></td>
			</tr>
			<tr>
				<td>创建者</td>
				<td><input type="text" name="builder" value="<%=club.getBuilder()%>"></td>
			</tr>
			<tr>
				<td><input type="reset" value="重置"></td>
				<td><input type="submit" value="修改"></td>
			</tr>
		</table>
		</form>
	</div>
</body>
