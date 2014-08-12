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
  <script language="javascript" type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>  
    <title>图片修改页面</title>
    

  </head>
  
  <body>
  <h3>图片修改页面</h3>    <br/>
  
      <form action="<%=basePath%>images?method=update" method="post" enctype="multipart/form-data">
       <table align="center" width="50%" border="0">
       <tr>
       <td>
       <input type="hidden" name="id" value="${img.id}"/>
       </td>
       </tr>
        <tr>
        <td align="right">
        图片名称：
        </td>
         <td>
        <input type="text" name="photoname" size="60%" value="${img.name}">
        </td>
        </tr>
        <tr height="10px">
        </tr>
          <tr>
        <td align="right">
        上传日期：
        </td>
         <td>
        <input class="Wdate" type="text" onClick="WdatePicker()" name="createtime" size="60%" value="${img.upTime}">
        </td>
        </tr>
        <tr height="20px">
        </tr>
    
    <tr>
        <td align="right">
        所属相册：
        </td>
         <td>
        <select name="photo" value="${img.photoId}" >
        <c:forEach items="${list}" var="photo" >
        <option value="${photo.id}" >
        ${photo.id}
        </option>
        
        </c:forEach>
        
        </select>
        </td>
        </tr>
        <tr height="20px">
        </tr>
         <tr>
        <td align="right">
        图片路径：
        </td>
         <td>
        <input type="file" name="url" size="60%" value="${img.imgUrl}">
        </td>
        </tr> 
        <tr>
        <td colspan="2" align="center">
        <input type="submit" value="提交"/>&nbsp;&nbsp;&nbsp;
        <input type="reset" value="重置"/>
        </td>
        </tr>
       </table>
      
      
      </form>
  
  
  </body>
</html>
