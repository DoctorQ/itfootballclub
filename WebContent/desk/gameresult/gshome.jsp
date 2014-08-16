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
<title>比赛结果</title>
<link rel="shortcut icon" href="../favicon.ico">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/desk/demo.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/desk/style.css" />
<link rel="stylesheet" href="<%=basePath%>css/desk/main-stylesheet.css" />

<link rel="stylesheet" href="<%=basePath%>css/desk/stylesly.css">

	<script>
		window.jQuery
				|| document
						.write('<script src="js/jquery-1.7.2.min.js"><\/script>')
	</script>
	<script src="js/jquery.sly.js"></script>
	<script src="js/plugins.js"></script>
	<script src="js/main.js"></script>
<script type="text/javascript"
	src="<%=basePath%>js/jquery.hoverdir.js"></script>
<script src="<%=basePath%>js/modernizr.custom.97074.js"></script>


</head>
<body>
	<div id="sections" class="container1">
		<div id="vertical" class="clearfix">
			<div class="slyWrap example2">

				<div class="scrollbar">
					<div class="handle"></div>
				</div>

				<div class="sly"
					data-options='{"startAt": 1, "scrollBy": 30}'>
					<div>
						<div class="container">
							<section>
								<h1>比赛结果列表o</h1>
								
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

			$(' #da-thumbs > li ').each(function() {
				$(this).hoverdir();
			});

		});
	</script>
	<!-- end scripts -->
	<%-- 	<div class="container">
		<header class="clearfix"> </header>
		<section>
			<ul id="da-thumbs" class="da-thumbs">
				<%
					for(int i = 0;i<list.size();i++){
								ScoreBoard sb = list.get(i);
				%>
				<li><a href="<%=basePath+"getClubMes?id="+sb.getId()%>"><img
						src="<%=basePath+"upload/images/"+sb.getImageUrl()%>" />
						<div>
							<span><table>
									<tr>
										<td class="clubname"><%=sb.getName()%></td>
										<td>|</td>
										<td><%=sb.getWin() %></td>
										<td>|</td>
										<td><%=sb.getTie() %></td>
										<td>|</td>
										<td><%=sb.getFaith() %></td>
										<td>|</td>
										<td><%=sb.getGain() %></td>
										<td>|</td>
										<td><%=sb.getLose() %></td>
										<td>|</td>
										<td><%=sb.getGain()-sb.getLose() %></td>
										<td>|</td>
										<td><%=sb.getScore() %></td>
										<td>|</td>
										<td><%=i +1%></td>
									</tr>
								</table>
							</span>
						</div> </a></li>
				<%
					}
				%>
			</ul>
		</section>
	</div>
	<footer>
		<p>&copy; 2013 itfootballclub. All rights reserved.</p>
	</footer>
	<script type="text/javascript">
		$(function() {

			$(' #da-thumbs > li ').each(function() {
				$(this).hoverdir();
			});

		});
	</script>
 --%>

</body>
</html>