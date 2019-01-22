<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>login</title>
</head>
<body>
  <c:if test="${!empty message}">
    <script type="text/javascript">alert("${message}");</script>
  </c:if>
  <form action="<%=basePath%>login" method="post">
    <label>account：</label>
    <input type="text" name="account" placeholder="" /><br/>
    <label>password：</label>
    <input type="password"  name="password" placeholder="" /><br/>
    <input type="submit" value="submit" />
    <input type="button" value="register" onclick="javascrtpt:window.location.href='<%=basePath%>student/toAddStudent'"/>
  </form>
</body>
</html>