<%@ page language="java" import="java.util.*,com.aodci.bean.*"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	List<Sporter> list = (List<Sporter>) request.getAttribute("list");
	int num = (Integer) request.getAttribute("num");
	int pageNO = (Integer) request.getAttribute("page");
	int pageNum = (Integer) request.getAttribute("pageNum");
%>

<link href="<%=basePath %>back/images/skin.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
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
	<h1 align="center">所有球员信息</h1>
	<table border="1" align="center" width="760">
		<tr><a href="<%=basePath%>listSporter?page=1">首页</a>
		<a href="<%=basePath%>listSporter?page=<%=pageNO - 1%>">前一页</a>
		<a href="<%=basePath%>listSporter?page=<%=pageNO + 1%>">后一页</a>
		<a href="<%=basePath%>listSporter?page=<%=pageNum%>">最后一页</a>
		<font color="red">当前页：<%=pageNO%></font></tr>
		<tr>
			<th>大名</th>
			<th>出生日期</th>
			<th>俱乐部</th>
			<th>国籍</th>
			<th>删除</th>
			<th>修改</th>
		</tr>
		<%
			for (int i = 0; i < list.size(); i++) {
				Sporter sporter = list.get(i);
		%>
		<tr>
			<td><%=sporter.getName()%></td>
			<td><%=sporter.getBorn()%></td>
			<td><%=sporter.getcName()%></td>
			<td><%=sporter.getCountry()%></td>
			<td><form action="<%=basePath%>deleteSporter" method="post">
					<input type="submit" value="删除"> <input type="hidden"
						name="id" value="<%=sporter.getId()%>">
				</form>
			</td>
			<td><form action="<%=basePath%>goUpdateSporter" method="post">
					<input type="submit" value="修改"> <input type="hidden"
						name="id" value="<%=sporter.getId()%>">
				</form>
			</td>
		</tr>
		<%
			}
		%>
	</table>
</body>
