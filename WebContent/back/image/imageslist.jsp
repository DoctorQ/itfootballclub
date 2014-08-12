<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>图片列表显示</title>
    <style>
    #img{color:red}
    </style>

  </head>
  
  <body>
    <span id="img">
    ${image}
    </span>


<table border="1" width="90%" align="center">
   <tr>
   <th> 
    图片ID 
   </th>
    <th>
    图片名称
   </th>
    <th>
    上传日期
   </th>
    <th>
    所属相册
   </th>
    <th>
    图片路径
   </th>
    
     <th colspan="2">
    图片编辑
   </th>
   </tr>
   <c:forEach items="${pm.datas}" var="img">
   <tr>
   <td>
   ${img.id}
   </td>
    <td>
   ${img.name}
   </td>
    <td>
     ${img.upTime}
   </td>
       <td>
     ${img.photoId}
   </td>
       <td>
     ${img.imgUrl}
   </td>
    
   <td>
   <a href="<%=basePath%>images?method=updateimg&id=${img.id}">修改</a>
   <a href="<%=basePath%>images?method=deleteimg&id=${img.id}">删除</a>
   </td>
   </tr>
   </c:forEach>
   </table>
   <br/>
  <table width="90%">
  <tr>
  <td align="right">
  共${pm.pageCount}页，第${pm.pageNo}页 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

  <a href="<%=basePath%>images?method=editimage&pageNo=1">首页</a>&nbsp;&nbsp;&nbsp;
  <a href="<%=basePath%>images?method=editimage&pageNo=${pm.pageNo+1}">下一页</a>
  <a href="<%=basePath%>images?method=editimage&pageNo=${pm.pageNo-1}">上一页</a>
  <a href="<%=basePath%>images?method=editimage&pageNo=${pm.pageCount}">尾页</a>&nbsp;&nbsp;&nbsp;




  第<select onChange="if(true){location='<%=basePath%>images?method=editimage&pageNo='+this.value+''} this.disabled='disabled'">
  <c:forEach begin="1" end="${pm.pageCount}" step="1" var="va">
  <option value="${va}">
  ${va}
  </option>
   </c:forEach>
 </select>页
 </td>
 </tr>
 </table>
  </body>
</html>
