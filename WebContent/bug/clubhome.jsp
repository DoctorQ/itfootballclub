<!DOCTYPE HTML>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page language="java" import="com.aodci.bean.ScoreBoard,java.util.*"%>
<html>
<head>
<title>home</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/home1.css" />
<!-- <script type="text/javascript" src="js/home.js"></script> -->
<script type="text/javascript" src="../js/jquery-1.2.6.js"></script>

</head>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>
<%
	List<ScoreBoard> list = (List<ScoreBoard>) session
	.getAttribute("list");
	int size = list.size();
	int a= size%5;
	int hang = 0;
	if(a==0){
		hang = size/5;
	}
	if(a!=0){
		hang = size/5+1;
	}
%>
<body>
	
	<select id="change">
		<option selected='selected'>图片</option>
		<option>列表</option>
		<option>admin</option>
	</select>
	<div id="leaguediv">
		<img src="../images/league.png"></img> <label id="titile">2013-2014英格兰足球超级联赛</label>
		<input type="text" id="search" />
		<hr id="tophr" />
	</div>
	<article>
	<div id="teamdiv">
		<%
			if(size != 0){
			int limit = 0;
			for(int h = 1;h <= hang;h++){
			if(h == hang && size%5!=0){
				limit = (h-1)*5+size%5;
				}else {
				limit = h*5;
				}
		%>
		<div>
			<%
				for (int i = (h-1)*5; i < limit; i++) {
							ScoreBoard sb = list.get(i);
			%>
			<a href="<%=basePath%>getClubMes?id=<%=sb.getId()%>">
			<img src="<%=basePath+"upload/images/"+sb.getImageUrl()%>"></img>
			</a>
			<%
				}
			%>
		</div>
		<%
			}}
		%>
	</div>
	<div id="tablescore"></div>
	</article>
	<div><hr/></div>
	<script>
		$("#change").change(function() {
			var valueselect = $(this).val();
			if ("admin" == valueselect) {
				window.open('<%=basePath%>back/index.jsp',
												'window',
												'height=800, width=1600, top=0, left=0, toolbar=no, menubar=no,scrollbars=no,resizable=no,location=no, status=no,fullscreen=yes');
							}
						});
	</script>
	<footer>
		<p>&copy; 2013 itfootballclub. All rights reserved.</p>
	</footer>
</body>
</html>