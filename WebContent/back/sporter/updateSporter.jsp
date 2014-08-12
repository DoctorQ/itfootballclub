<%@ page language="java" import="java.util.*,com.aodci.bean.*"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	List<Club> list = (List<Club>) request.getAttribute("list");
	Sporter sporter = (Sporter)request.getAttribute("sporter");
%>

<link href="<%=basePath%>back/images/skin.css" rel="stylesheet"
	type="text/css" />
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
	<h1 align="left">
		更新球员信息:<%=sporter.getName()%>
	</h1>
	<div align="center">
		<form action="updateSporter" method="post">
			<table>
			<tr><td><input type="hidden" name="sporterid" 
				value="<%=sporter.getId()%>" /> </td></tr><tr> <td>所属俱乐部:</td><td><select
				name="clubname">
				<%
					for (int i = 0; i < list.size(); i++) {
								Club club = list.get(i);
								if(sporter.getcName().equals(club.getcName())){
				%>
				<option value="<%=club.getcName()%>" selected="selected"><%=club.getcName()%></option>
				<%
					}
						         else {
				%>
				<option value="<%=club.getcName()%>"><%=club.getcName()%></option>
				<%
					}
						     }
				%>
			</select></td></tr> 
			<tr><td>球衣号码：</td><td><input type="text" name="sporternumber" value="<%=sporter.getNumber() %>"></td></tr>
			<tr><td>队中角色：</td><td><select name="sporterrole">
				<% 
					if(sporter.getRole().equals("forward")){					
				%>
				<option value="forward" selected="selected">前锋</option>
				<option value="back">后卫</option>
				<option value="midfielder">中锋</option>
				<%
				} else if(sporter.getRole().equals("back")){
				%>
				<option value="forward">前锋</option>
				<option value="back"  selected="selected">后卫</option>
				<option value="midfielder">中锋</option>
				<%
					}else{
				 %>
				 <option value="forward">前锋</option>
				<option value="back" >后卫</option>
				<option value="midfielder" selected="selected">中锋</option>
				<%
				}
				 %>
			</select></td></tr>
			<tr><td>出生日期：</td><td><input class="Wdate" type="text" name="sporterborn" value="<%=sporter.getBorn() %>"
						onClick="WdatePicker()"></td></tr>
			<tr><td> 国籍：</td><td><input type="text"
				name="sportercountry" value="<%=sporter.getCountry()%>"></td></tr>
			<tr><td>梯队:</td><td><select name="sporterband">
				<%
					if(sporter.getBand().equals("A")){
				%>
				<option value="A" selected="selected">一线队</option>
				<option value="B">预备队</option>
				<%
					} else{
				%>
				<option value="A">一线队</option>
				<option value="B" selected="selected">预备队</option>
				<%
					}
				%>
			</select> </td></tr><tr><td>租借至：</td><td><select name="sportersendclub">
				<%
					if(sporter.getSendClub().equals("no")){
				%>
				<option value="no">我不会被租借的</option>
				<%
				    }else{
				 %>
				 <option value="no">我不会被租借的</option>
				<%
				}
				
					     for (int i = 0; i < list.size(); i++) {
								Club club = list.get(i);
							if(sporter.getBand().equals(club.getcName())){
				%>
				<option value="<%=club.getcName()%>" selected="selected"><%=club.getcName()%></option>
				<%
					         } else {
				%>
				<option value="<%=club.getcName()%>"><%=club.getcName()%></option>
				<%
					          }
					       }
				
				%>
			</select></td></tr><tr> <td><input type="submit" value="修改"> </td><td><input
				type="reset" value="重置"></td></tr>
				</table>
		</form>
		<!-- <form action="uploadServlet" method='post' enctype='multipart/form-data' >
			用户名：<input type="text" name="username">
			
			<input type='submit' value='提交'>
		</form> -->
	</div>
</body>
