<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>
      <%@ include file="studentTestManage.jsp" %>
  </head>
    
  <body>

  <c:if test="${!empty message}">
      <script type="text/javascript">alert("${message}");</script>
  </c:if>
    <p>threshold:${threshold}</p>
  <c:if test="${set != 'false'}">
      <form action="<%=basePath%>test/setThreshold?student_id=${student_id}" method="post">
          threshold：<input type="text" name="threshold" value="${threshold}"> score
          <input type="submit" value="set"></form>
  </c:if>
  </body>
</html>  