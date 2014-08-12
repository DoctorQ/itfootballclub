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
	<h1 align="right">
		已添加球员<%=num%>人
	</h1>
	<div align="center">
		<form action="addSporter" method="post" enctype="multipart/form-data">
			姓名：<input type="text" name="sportername" /> <br> 所属俱乐部:<select
				name="clubname">
				<%
					for (int i = 0; i < list.size(); i++) {
						Club club = list.get(i);
				%>
				<option value="<%=club.getcName()%>"><%=club.getcName()%></option>
				<%
					}
				%>
			</select><br> 年龄：<input type="text" name="sporterage" /><br> 国籍：<input
				type="text" name="sportercountry"><br> 年薪：<input
				type="text" name="sportersalary">万英镑<br> 转会费:<input
				type="text" name="sporterprice">万英镑<br> 梯队:<select
				name="sporterband">
				<option value="A">一线队</option>
				<option value="B">预备队</option>
			</select> <br>租借至：<select name="sportersendclub">
				<option value="no">我不会被租借的</option>
				<%
					for (int i = 0; i < list.size(); i++) {
						Club club = list.get(i);
				%>
				<option value="<%=club.getcName()%>"><%=club.getcName()%></option>
				<%
					}
				%>
			</select><br>
			选择图片：<input type="file" name="upfile"><br><input
				type="submit" value="添加"> <input type="reset" value="重置">
		</form>
		<!-- <form action="uploadServlet" method='post' enctype='multipart/form-data' >
			用户名：<input type="text" name="username">
			
			<input type='submit' value='提交'>
		</form> -->
	</div>
</body>
