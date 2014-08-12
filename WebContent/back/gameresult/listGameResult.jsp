<%@ page language="java" import="java.util.*,com.aodci.bean.*"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	List<GameResult> list = (List<GameResult>)request.getAttribute("list");
%>

<link href="<%=basePath%>back/images/skin.css" rel="stylesheet"
	type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<%-- <link type="text/css" rel="stylesheet"
	href="<%=basePath%>back/css/editTable.css" /> --%>
<script type="text/javascript" src="<%=basePath%>back/js/jquery-1.4.js"></script>
<script type="text/javascript" src="<%=basePath%>back/js/listgameresult.js"></script>
<script type="text/javascript" src="<%=basePath%>back/js/editTable.js"></script>
<style type="text/css">

body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #EEF2FB;
}
tbody tr td{
	width:140px;
}
thead tr th,select{
	width:140px;
}

</style>
<body>
	<table align = "center">
		<thead>
			<tr>
				<th colspan="5" id="title">所有比赛信息</th><th><select id="leg">
                    <% 
						for(int i=1;i<=38;i++){
					%>
							<option value="<%=i %>">第<%=i %>轮</option>
						<%
						} 
						%>
				</select></th>
			</tr>
		</thead>
		<tbody>
			<% 
				for(int i =0;i<list.size();i++){
				GameResult gameResult = list.get(i);
			%>
			<tr>
				<td><%=gameResult.getpName() %></td>
				<td><%=gameResult.getpGoal() %></td>
				<td><%=gameResult.getcGoal() %></td>
				<td><%=gameResult.getcName() %></td>
				<td><%=gameResult.getGameTime() %></td>
				<td><%=gameResult.getField() %></td>
			</tr>
			<%
			} 
			%>
		</tbody>
	</table>
</body>
