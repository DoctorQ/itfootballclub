<!DOCTYPE HTML><%@page language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>
<html>
<head>
<title>top</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=basePath%>css/desk/main-stylesheet1.css" />
<script src="<%=basePath%>js/jquery.min.js" type="text/javascript"></script>
<script src="<%=basePath%>js/jquery.countdown.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">
	var date = new Date();
	var sr = date.getSeconds();
	var mr = date.getMinutes();
	var hr = date.getHours();
	s = 60 - sr;
	s = s < 10 ? "0" + s : s;
	if (s != 0) {
		m = 60 - mr - 1;
	}
	m = m < 10 ? "0" + m : m;
	if (m != 0) {
		h = 24 - hr - 1;
	}
	h = h < 10 ? "0" + h : h;
	var timevalue = h + ":" + m + ":" + s;
	$(function() {
		$('#counter').countdown({
			image : '../images/desk/home/digits.png',
			startTime : timevalue
		});
	});
</script>
</head>
<body>
	<header>
		<hgroup>
			<h1>爱踢球吧</h1>	
	<div id="counter"></div>
		</hgroup>
	</header>
	<nav>
		<ul>
			<li><a href="<%=basePath%>desk/context.jsp" target="middleFrame">首页</a></li>
			<li><a href="<%=basePath%>sortServlet" target="middleFrame">俱乐部</a></li>
			<li><a href="<%=basePath%>goSporterHome" target="middleFrame">球员</a></li>
			<li><a href="<%=basePath%>goGSHome" target="middleFrame">比赛</a></li>
			<li><a href="<%=basePath%>goBoard" target="middleFrame">积分榜</a></li>
			<li><a href="<%=basePath%>goShotBoard" target="middleFrame">射手榜</a></li>
			<li><a href="<%=basePath %>desk/aboutus.html" target="middleFrame">关于我们</a></li>
		</ul>
	</nav>

</body>
</html>