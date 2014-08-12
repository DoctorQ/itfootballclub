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
    
    <title>添加图片</title>
    <script language="javascript" type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>

  </head>
  
  <body>
  <h3>添加图片</h3>    <br/>
  
      <form action="<%=basePath%>images?method=addimages" method="post"  enctype="multipart/form-data">
       <table align="center" width="80%" border="0">
        <tr>
        <td align="right">
        图片名称：
        </td>
         <td>
        <input type="text" name="photoname" size="60%">
        </td>
        </tr>
        <tr height="10px">
        </tr>
          <tr>
        <td align="right">
        上传日期：
        </td>
         <td>
        <input class="Wdate" type="text" onClick="WdatePicker()" name="createtime" size="60%">
        </td>
        </tr>
        <tr height="20px">
        </tr>
    
    <tr>
        <td align="right">
        所属相册：
        </td>
         <td>
        <select name="photo" >
        <c:forEach items="${list}" var="photo">
        <option value="${photo.id}" >
        ${photo.name}
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
        <input type="file" name="url" size="60%">
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
