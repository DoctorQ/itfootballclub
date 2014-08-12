<!DOCTYPE html>
<%@page language="java" import="com.aodci.bean.Sporter,java.util.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
	Sporter sporter = (Sporter)request.getAttribute("sporter");
%>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>球员详细信息</title>
<link rel="shortcut icon" href="../favicon.ico">
<link
	href='http://fonts.googleapis.com/css?family=Alegreya+SC:700,400italic'
	rel='stylesheet' type='text/css' />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>desk/css/demo.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>desk/css/style.css" />
<link rel="stylesheet" href="<%=basePath%>desk/css/main-stylesheet.css" />
<link href='http://fonts.googleapis.com/css?family=Exo:700'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="<%=basePath%>desk/css/stylesly.css">
<link rel="stylesheet" href="<%=basePath %>desk/css/sportermes.css">
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="js/jquery-1.7.2.min.js"><\/script>')
	</script>
	<script src="js/jquery.sly.js"></script>
	<script src="js/plugins.js"></script>
	<script src="js/main.js"></script>
<script type="text/javascript"
	src="<%=basePath%>desk/js/jquery.hoverdir.js"></script>
<script src="<%=basePath%>desk/js/modernizr.custom.97074.js"></script>

<noscript>
	<link rel="stylesheet" type="text/css"
		href="<%=basePath%>css/noJS.css" />
</noscript>

</head>
<body>
	<div id="sections" class="container1">
		<div id="vertical" class="clearfix">
			<div class="slyWrap example2">
				<div class="scrollbar">
					<div class="handle"></div>
				</div>

				<div class="sly"
					data-options='{ "itemNav": "smart", "dragContent": 1, "startAt": 10, "scrollBy": 1, "elasticBounds": 1}'>
					<div>
						<div class="container">
							<section>
								<header>
								<span class="clubname"><%=sporter.getName()%>
								<img src="<%=basePath+"upload/images/"+sporter.getImage()%>" class="clubimg"/></span>
								<br>
								<table><tr>
								<td>出生日期</td><td><%=sporter.getBorn() %></td></tr>
								<tr><td>国籍</td><td><%=sporter.getCountry() %></td></tr>
								<tr><td>俱乐部</td><td><%=sporter.getcName() %></td></tr>
								<tr><td>球衣号码</td><td><%=sporter.getNumber() %></td></tr>
								<tr><td>位置</td><td><%=sporter.getRole() %></td></tr>
								</table>
								</header>
								<hr/>
							</section>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--end:#vertical-->
	</div>
	<script type="text/javascript">
		$(function() {
			$("table tr:even").css("background-color", "#ECE9D8");
			$(' #da-thumbs > li ').each(function() {
				$(this).hoverdir();
			});

		});
	</script>
</body>
</html>