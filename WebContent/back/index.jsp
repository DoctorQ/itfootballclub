<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>管理界面</title>

</head>
<frameset rows="64,*" frameborder="NO" border="0" framespacing="0">
	<frame src="<%=basePath%>back/admin_top.jsp" noresize="noresize"
		frameborder="NO" name="topFrame" scrolling="no" marginwidth="0"
		marginheight="0" target="main" />

	<frameset cols="200,*" rows="740,*" id="frame">
		<frame src="<%=basePath%>back/left.jsp" name="leftFrame"
			noresize="noresize" marginwidth="0" marginheight="0" frameborder="0"
			scrolling="no" target="main" />
		<frame src="<%=basePath%>back/right.jsp" name="main" marginwidth="0"
			marginheight="0" frameborder="0" scrolling="auto" target="_self" />
	</frameset>
	</frameset>
	
</html>
