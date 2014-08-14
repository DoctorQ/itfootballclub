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
<script type="text/javascript" src="<%=basePath%>desk/js/listgameresult.js"></script>
<script type="text/javascript" src="<%=basePath%>desk/js/editTable.js"></script>
<style type="text/css">

body {
	font-family:"微软雅黑";
	font-size:20px;
	width:800px;
	margin:0em auto;
}
.styled-select {
    width: 140px;
    height: 34px;
    margin-top:-40px;
    float:right;
    overflow: hidden;
    background: url("http://images.cnblogs.com/cnblogs_com/shishm/201203/201203021104112011.jpg") no-repeat right #ddd;
}

.styled-select select {   
    background: transparent;   
    width: 140px;   
    padding: 5px;   
    font-size: 16px;   
    border: 1px solid #ccc;   
    height: 34px;   
    -webkit-appearance: none;
     
}

table{
    width:800px;
    border:1px;
    font-size:14px;
}
tbody tr td {
	text-align:center;
	width:100px;
}
tbody tr td a{
	font-size:20px;
}

</style>
<body>
	<h3>2014/2015英格兰超级联赛</h3>
	<div class="styled-select">
	<select id="leg">	
			 <% 
						for(int i=1;i<=38;i++){
					%>
							<option value="<%=i %>">第<%=i %>轮</option>
						<%
						} 
						%>
		</select></div>
	<table align = "center">
		<thead>
			<tr>
				<th>主队</th>
				<th>主队进球</th>
				<th>客队进球</th>
				<th>客队</th>
				<th>比赛日</th>
				<th>比赛地点</th>
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
