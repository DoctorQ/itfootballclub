<%@ page language="java" import="java.util.*,com.aodci.bean.*"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
	int num = 0;
	int pageNO = 0;
	int pageNum = 0;
	List<Club> clubs = (List<Club>) request.getAttribute("clubs");
	
%>

<link href="<%=basePath%>back/images/skin.css" rel="stylesheet"
	type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<link type="text/css" rel="stylesheet"
	href="<%=basePath%>css/desk/chainselect.css" />
<script type="text/javascript" src="<%=basePath%>js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/chainselect.js"></script>
<style type="text/css">

</style>
<body>
	<div class="loading">
		<p>
			<img src="<%=basePath%>back/images/data-loading.gif" alt="数据装载中" />
		</p>
		<p>数据装载中......</p>
	</div>
	<div class="car">
		<span class="carname"> 俱乐部: <select>
				<option value="" selected="selected">请选择俱乐部</option>
				<%
					for (int i = 0; i < clubs.size(); i++) {
						Club club = clubs.get(i);
				%>
				<option value="<%=club.getcName()%>"><%=club.getcName()%></option>
				<%
					}
				%>
		</select> <img src="<%=basePath%>back/images/pfeil.gif" alt="有数据" /> </span> <span
			class="cartype"> 梯队: <select></select> <img
			src="<%=basePath%>back/images/pfeil.gif" alt="有数据" /> </span> <span
			class="wheeltype"> 球员： <select></select> </span>
	</div>
	<div class="carimage">
		<p>
			<img src="<%=basePath%>back/images/img-loading.gif" alt="图片装载中"
				class="carloading" />
		</p>
		<p>
			<a href = "" class = "sporterid"><img src="" alt="球员图片" class="carimg" /></a>
		</p>
	</div>

</body>
