<!DOCTYPE html>
<%@page language="java" import="com.aodci.bean.*,java.util.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
	List<ScoreBoard> sbs = (List<ScoreBoard>)request.getAttribute("sbs");
	List<ShotBoard> shotBoards = (List<ShotBoard>)request.getAttribute("shotBoards");
%>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>积分榜</title>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/desk/demo.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>css/desk/style.css" />
<link rel="stylesheet" href="<%=basePath%>css/desk/main-stylesheet.css" />
<link rel="stylesheet" href="<%=basePath%>css/desk/stylesly.css">
<link rel="stylesheet" href="<%=basePath%>css/desk/sportermes.css">

<script type="text/javascript" src="<%=basePath%>js/jquery.hoverdir.js"></script>
<script src="<%=basePath%>js/modernizr.custom.97074.js"></script>
<script src="<%=basePath%>js/jquery.heatcolor.0.0.1.js"
	type="text/javascript"></script>
<script src="<%=basePath%>js/jquery.tablesorter.pack.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		$("#ex1").tablesorter();
		function sortwithcolor(column) {
			$("#ex1 > tbody > tr").heatcolor(function() {
				return $("td:nth-child(" + column + ")", this).text();
			});
		}
		;
		$("#ex1 > thead > tr > th").click(
				function() {
					$(this).siblings().css("background-color", "#cccccc").end()
							.css("background-color", "#dd0000");
					sortwithcolor($(this).parent().children().index(this) + 1);
				});
		sortwithcolor(8);
	});
</script>
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
						<div>
							<h2>积分榜2</h2>
							<table width="770" cellspacing="1" cellpadding="2" border="0"
								align="center" id="ex1">
								<thead>
									<tr>
										<th bgcolor="#cccccc" align="center" class="textSm primary">
											俱乐部</th>
										<th width="24" nowrap="nowrap" bgcolor="#cccccc"
											align="center" class="textSm primary"><b> 完赛</b></th>
										<th width="24" nowrap="nowrap" bgcolor="#cccccc"
											align="center" class="textSm primary"><b>胜</b></th>
										<th width="24" nowrap="nowrap" bgcolor="#cccccc"
											align="center" class="textSm primary"><b> 平</b></th>
										<th width="24" nowrap="nowrap" bgcolor="#cccccc"
											align="center" class="textSm primary"><b> 负</b></th>
										<th width="24" nowrap="nowrap" bgcolor="#cccccc"
											align="center" class="textSm primary"><b> 进球</b></th>
										<th width="24" nowrap="nowrap" bgcolor="#cccccc"
											align="center" class="textSm primary"><b> 失球</b></th>
										<th width="24" nowrap="nowrap" bgcolor="#cccccc"
											align="center" class="textSm primary"><b> 净胜球</b></th>
										<th width="24" align="center" nowrap="nowrap"
											bgcolor="#cccccc" class="textSm primary">积分</th>
										<th width="24" nowrap="nowrap" bgcolor="#cccccc"
											align="center" class="textSm primary"><b> 排名</b></th>
									</tr>
								</thead>
								<tbody>
									<%
										for(int i=0;i<sbs.size();i++){
																ScoreBoard sb = sbs.get(i);
									%>
									<tr>
										<td>
											<table cellspacing="0" cellpadding="0" border="0">
												<tbody>
													<tr>
														<td nowrap="" align="left"><%=sb.getName()%></td>
													</tr>
												</tbody>
											</table>
										</td>
										<td align="center"><%=sb.getWin()+sb.getTie()+sb.getLose()%></td>
										<td align="center"><%=sb.getWin()%></td>
										<td align="center"><%=sb.getTie()%></td>
										<td align="center"><%=sb.getFaith()%></td>
										<td align="center"><%=sb.getGain()%></td>
										<td align="center"><%=sb.getLose()%></td>
										<td align="center"><%=sb.getGain()-sb.getLose()%></td>
										<td align="center"><%=sb.getScore()%></td>
										<td align="center"><%=i+1%></td>
									</tr>
									<%
										}
									%>
								</tbody>
							</table>
							<div></div>

						</div>
					</div>
				</div>
				<!--end:#vertical-->
			</div>
			<script>
				window.jQuery
						|| document
								.write('<script src="../js/jquery-1.7.2.min.js"><\/script>')
			</script>
			<script src="<%=basePath%>js/jquery.sly.js"></script>
			<script src="<%=basePath%>js/plugins.js"></script>
			<script src="<%=basePath%>js/main.js"></script>
			<script type="text/javascript">
				$(function() {
					$(' #da-thumbs > li ').each(function() {
						$(this).hoverdir();
					});

				});
			</script>
</body>
</html>