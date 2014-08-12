<%@ page language="java" import="java.util.*,com.aodci.bean.*"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	List<Club> list = (List<Club>) request.getAttribute("list");
%>

<link href="<%=basePath%>back/images/skin.css" rel="stylesheet"
	type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>back/css/goaltime.css" />
<script src="<%=basePath%>back/js/jquery-1.4.js"></script>
<script src="<%=basePath%>back/js/addGameResult.js"></script>
<script type="text/javascript"
	src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
<%-- <script src="<%=basePath%>back/js/goaltime.js"></script> --%>
<style type="text/css">
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #EEF2FB;
}

/* #clubtype,#sporttype,#goaltime {
	width: 140px;
} */

#minute,#sporttype {
	display: none;
}
#club table td,select,input{
	width: 140px;
}
</style>
<body>
	<h1 align="right"></h1>
	<div align="center" id="club">
		<form action="addGameResult" method="post">
			<table border = "1">
				<tr>
					<th>比赛结果</th>
					<th>主队</th>
					<th>客队</th>
				</tr>
				<tr>
					<td>球队:</td>
					<td><select name="pname" id="ptype">
							<option value="no" selected="selected">请选择主队</option>
							<%
								for (int i = 0; i < list.size(); i++) {
									Club club = list.get(i);
							%>
							<option value="<%=club.getcName()%>"><%=club.getcName()%></option>
							<%
								}
							%>
					</select>
					</td>
					<td><select name="cname" id="ctype">
							<option value="no" selected="selected">请选择客队</option>
							<%
								for (int i = 0; i < list.size(); i++) {
									Club club = list.get(i);
							%>
							<option value="<%=club.getcName()%>"><%=club.getcName()%></option>
							<%
								}
							%>
					</select>
					</td>
				</tr>
				<tr>
					<td>回合:</td>
					<td><select name="leg">
					<% 
						for(int i=1;i<=38;i++){
					%>
							<option value="<%=i %>">第<%=i %>轮</option>
						<%
						} 
						%>
					</select>
					</td>
				</tr>
				
				<tr>
					<td>比赛场地:</td>
					<td colspan="2"><input type="text" name="field" id="fieldtype"
						value="">
					</td>
				</tr>
				<tr>
					<td>比赛时间:</td>
					<td><input class="Wdate" type="text" name="gametime"
						onClick="WdatePicker()">
					</td>
				</tr>
								<tr>
					<td>Goal:</td>
					<td><select id ="timestage">
						<option value="FIRST-HALF">上半场</option>
						<option value="SECOND-HALF">下半场</option>
						<option value="FIRST-STOPPAGE">上半场补时</option>
						<option value="SECOND-STOPPAGE">下半场补时</option>
						<option value="OVER-TIME">加时赛</option>
	                </select></td>
					<td><select id="clubtype">
					</select>
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
					<select id="sporttype">
					</select>
					</td>  
	 				<td>
				<select id="minute"></select>
					</td>
				</tr>
				<tr>
					<td>比分：</td>
					<td><input type="text" name="pgoal" id = "pgoal" value="">
					</td>
					<td><input type="text" name="cgoal" id = "cgoal" value="">
					</td>
				</tr>
				<tr>
					<td colspan="3">
					<textarea style="width:430px;height:200px;background-color:D7F8AB" id="goaltime" name="msg"></textarea>
					</td>
				</tr>
				<tr>
					<td><input type="reset" value="重置">
					</td>
					<td><input type="submit" value="添加">
					</td>
				</tr>
			</table>
		</form>
	</div>
<!-- 	<div class="Calendar" id="timestage">
		<div id="idCalendarPre">&lt;&lt;</div>
		<div id="idCalendarNext">&gt;&gt;</div>
		<span id="idCalendarMonth"></span>
		<table cellspacing="0">
			<thead>
				<tr>
					<td>一</td>
					<td>二</td>
					<td>三</td>
					<td>四</td>
					<td>五</td>
					<td>六</td>
					<td>七</td>
					<td>八</td>
					<td>九</td>
					<td>十</td>
				</tr>
			</thead>
			<tbody id="idCalendar">
			</tbody>
		</table>
	</div> -->

</body>
