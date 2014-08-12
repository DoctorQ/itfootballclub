<%@ page language="java" import="java.util.*,com.aodci.bean.*"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	List<Club> list = (List<Club>) request.getAttribute("list");
%>

<link href="<%=basePath%>back/images/skin.css" rel="stylesheet"
	type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<%-- <link type="text/css" rel="stylesheet"
	href="<%=basePath%>back/css/editTable.css" /> --%>
<script type="text/javascript" src="<%=basePath%>back/js/jquery-1.4.js"></script>
<script type="text/javascript" src="<%=basePath%>back/js/editTable.js"></script>
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
	<table align = "center">
		<thead>
			<tr>
				<th colspan="6">所有俱乐部的信息</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>俱乐部名称</th>
				<th>成立时间</th>
				<th>主场</th>
				<th>主教练</th>
				<th>创建者</th>
				<th>所在城市</th>
				<th>删除</th>
				<th>更新</th>
			</tr>
			<%
				for (int i = 0; i < list.size(); i++) {
					Club club = list.get(i);
			%>
			<tr>
				<td><%=club.getcName()%></td>
				<td><%=club.getcTime()%></td>
				<td><%=club.getHomeField()%></td>
				<td><%=club.getCoach() %></td>
				<td><%=club.getBuilder() %></td>
				<td><%=club.getLocation() %></td>
				<td><form action="deleteClub" method="post">
					<input type="hidden" name="cname" value="<%=club.getcName() %>">
					<input type="submit" value="删除">
				</form></td>
				<td><form action="goUpdateClub" method="post">
					<input type="hidden" name="id" value="<%=club.getId() %>">
					<input type="submit" value="修改">
				</form></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</body>
