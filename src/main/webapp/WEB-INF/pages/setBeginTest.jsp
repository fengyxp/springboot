<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>  
  <head>
      <%@ include file="admin.jsp" %>
  </head>
    
  <body>
  <br>
  <br>
  <br>
    <c:if test="${beginTest == 'false'}">
        <a href="<%=basePath%>test/setBeginTest?beginTest=true">begin test</a>
    </c:if>
    <c:if test="${beginTest == 'true'}">
        <a href="<%=basePath%>test/setBeginTest?beginTest=false">end test</a>
    </c:if>
  </body>  
</html>  