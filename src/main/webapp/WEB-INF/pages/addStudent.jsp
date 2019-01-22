<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>
      <%--<%@ include file="admin.jsp" %>--%>
  </head>
    
  <body>
    <form action="<%=basePath%>student/addStudent" method="post">
        student_id：<input type="text" name="studentId">
        student_name：<input type="text" name="studentName">
        password：<input type="text" name="password">
        <input type="submit" value="add">
    </form>  
  </body>  
</html>