<!DOCTYPE html>
<%@page language="java" import="com.aodci.bean.Sporter,java.util.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	Sporter sporter = (Sporter) request.getAttribute("sporter");
%>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>球员详细信息</title>
<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/desk/demo.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/desk/style.css" />
<link rel="stylesheet" href="<%=basePath%>css/desk/main-stylesheet.css" />
<link rel="stylesheet" href="<%=basePath%>css/desk/stylesly.css">
<link rel="stylesheet" href="<%=basePath%>css/desk/sportermes.css">

<script src="<%=basePath%>js/jquery-1.7.2.min.js"></script>
<script src="<%=basePath%>js/jquery.sly.js"></script>
<script src="<%=basePath%>js/plugins.js"></script>
<script src="<%=basePath%>js/main.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/jquery.hoverdir.js"></script>
<script src="<%=basePath%>js/modernizr.custom.97074.js"></script>

<noscript>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/noJS.css" />
</noscript>

</head>
<body>
	<div id="sections" class="container1">
		<div id="vertical" class="clearfix">
			<div class="slyWrap example2">
				<div class="scrollbar">
					<div class="handle"></div>
				</div>

				<div class="sly" data-options='{ "startAt": 1, "scrollBy": 1}'>
					<div>
						<div class="container">
							<section>
								<header>
									<span class="clubname"><%=sporter.getName()%> <img
										src="<%=basePath + "upload/images/" + sporter.getImage()%>"
										class="clubimg" /></span> <br>
									<table>
										<tr>
											<td>出生日期</td>
											<td><%=sporter.getBorn()%></td>
										</tr>
										<tr>
											<td>国籍</td>
											<td><%=sporter.getCountry()%></td>
										</tr>
										<tr>
											<td>俱乐部</td>
											<td><%=sporter.getcName()%></td>
										</tr>
										<tr>
											<td>球衣号码</td>
											<td><%=sporter.getNumber()%></td>
										</tr>
										<tr>
											<td>位置</td>
											<td><%=sporter.getRole()%></td>
										</tr>
									</table>
								</header>
								<hr />
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