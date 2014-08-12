<%@ page language="java" import="java.util.*,com.aodci.bean.*"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	
%>

<link href="<%=basePath%>back/images/skin.css" rel="stylesheet"
	type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
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
#club{
	margin-top:100px;
}
</style>
<body>
	<h1 align="right">
	</h1>
	<div align="center" id = "club">
		<form action="addClub" method="post" enctype="multipart/form-data">
		<table >
			<tr>
				<td>名称</td>
				<td><input type="text" name="cname"></td>
			</tr>
			<tr>
				<td>创建时间</td>
				<td><input type="text" name="ctime" >格式:YYYY-MM-DD</td>
			</tr>
			<tr>
				<td>主场</td>
				<td><input type="text" name="homefield"></td>
			</tr>
			<tr>
				<td>教练</td>
				<td><input type="text" name="coach"></td>
			</tr>
			<tr>
				<td>所在城市</td>
				<td><input type="text" name="location"></td>
			</tr>
			<tr>
				<td>创建者</td>
				<td><input type="text" name="builder"></td>
			</tr>
			<tr>
				<td>队徽</td>
				<td><input type="file" name="file1"></td>
			</tr>
			<tr>
				<td><input type="reset" value="重置"></td>
				<td><input type="submit" value="添加"></td>
			</tr>
		</table>
		</form>
		<!-- <form action="uploadServlet" method='post' enctype='multipart/form-data' >
			用户名：<input type="text" name="username">
			
			<input type='submit' value='提交'>
		</form> -->
	</div>
</body>
