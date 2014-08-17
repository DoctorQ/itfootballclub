<%@ page language="java" import="java.util.*,com.aodci.bean.*"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	List<Club> list = (List<Club>) request.getAttribute("list");
	int num = (Integer) request.getAttribute("snum");
%>

<link href="<%=basePath%>back/images/skin.css" rel="stylesheet"
	type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<script type="text/javascript"
	src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
<style type="text/css">

body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #EEF2FB;
}
</style>
<body>
	<h1 align="right">
		已添加球员<%=num%>人
	</h1>
	<div align="center">
		<form action="addSporter" method="post" enctype="multipart/form-data">
		<table>
			<tr>
			<td>姓名：</td>
			<td><input type="text" name="sportername" /></td> 
			<tr>
			 <td>所属俱乐部:</td><td><select
				name="clubname">
				<%
					for (int i = 0; i < list.size(); i++) {
						Club club = list.get(i);
				%>
				<option value="<%=club.getcName()%>"><%=club.getcName()%></option>
				<%
					}
				%>
			</select></td></tr>
			<tr><td>球衣号码：</td><td><input type="text" name="sporternumber"></td></tr>
			<tr><td>队中角色：</td><td><select name="sporterrole">
				<option value="forward">前锋</option>
				<option value="midfielder">中场</option>
				<option value="back">后卫</option>
			</select></td></tr>
			<tr><td>出生日期：</td><td><input class="Wdate" type="text" name="sporterborn"
						onClick="WdatePicker()"></td></tr>
			<tr> <td>国籍：</td><td><input
				type="text" name="sportercountry"></td></tr><tr><td>梯队:</td><td><select
				name="sporterband">
				<option value="A">一线队</option>
				<option value="B">预备队</option>
			</select> </td></tr><tr><td>租借至：</td><td><select name="sportersendclub">
				<option value="no">我不会被租借的</option>
				<%
					for (int i = 0; i < list.size(); i++) {
						Club club = list.get(i);
				%>
				<option value="<%=club.getcName()%>"><%=club.getcName()%></option>
				<%
					}
				%>
			</select></td></tr>
			<tr><td>选择图片：</td><td><input type="file" name="upfile"></td></tr><tr>
			<td><input type="reset" value="重置"></td>
			<td><input type="submit" value="添加"></td> </tr>
			</table>
		</form>
	</div>
</body>
