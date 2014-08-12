<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@page errorPage="error.jsp" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title> rl_news_category.jsp page</title>
    
	<style type="text/css">
	#remain{color:red}
	</style>

  </head>
  
  <body>
  
    <a href="<%=basePath%>back/rl_news_category/newadd.jsp">添加新闻类别</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="new?method=find">查询新闻类别</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="new?method=find">修改新闻类别</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="new?method=find">删除新闻类别</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <span id="remain">${info}</span> 
  
  
  </body>
</html>
