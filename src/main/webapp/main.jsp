<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
  <head>
    <title>My JSP 'index.jsp' starting page</title>
  </head>

  <body>
  <a href="<%=basePath%>/login">login</a>
  </body>
</html>
