<!DOCTYPE html>
<%@page language="java" import="com.aodci.bean.Club,java.util.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
	Club club = (Club)request.getAttribute("club");
%>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>俱乐部详细信息</title>
<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>desk/css/demo.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>desk/css/style.css" />
<link rel="stylesheet" href="<%=basePath%>desk/css/main-stylesheet.css" />
<link rel="stylesheet" href="<%=basePath%>desk/css/stylesly.css">
<link rel="stylesheet" href="<%=basePath %>desk/css/clubmes.css">
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
					data-options='{"startAt": 1, "scrollBy": 1}'>
					<div>
						<div class="container">
							<section>
								<header>
								<span class="clubname"><%=club.getcName() %>
								<img src="<%=basePath+club.getImgurl() %>" class="clubimg"/></span>
								<table><tr>
								<td>创建时间</td><td><%=club.getcTime() %></td></tr>
								<tr><td>球队主场</td><td><%=club.getHomeField() %></td></tr>
								<tr><td>主教练</td><td><%=club.getCoach() %></td></tr>
								<tr><td>创建者</td><td><%=club.getBuilder() %></td></tr>
								<tr><td>城市</td><td><%=club.getLocation() %></td></tr>
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