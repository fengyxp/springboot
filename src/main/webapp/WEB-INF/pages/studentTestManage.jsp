<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>


<body>
<a href="<%=basePath%>test/toSetThreshold?student_id=${student_id}">Set threshold</a>
<br>
<a href="<%=basePath%>test/toTest?student_id=${student_id}">Get into test</a>
<br>
<a href="<%=basePath%>test/studentStatistics?student_id=${student_id}">checkout result</a>
<br>
<label>student_id: ${student_id}</label>
<br>
<a href="<%=basePath%>/login">logout</a>
<br>
</body>
</html>