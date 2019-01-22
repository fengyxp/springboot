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
    <c:if test="${result == 'pass'}">
        <script type="text/javascript">alert("score:${score},${result}");</script>
    </c:if>
    <c:if test="${result == 'notPass'}">
        <script type="text/javascript">alert("score:${score},${result}");</script>
    </c:if>

    <c:if test="${test == 'notBegin'}">
        <a href="<%=basePath%>test/toTest?student_id=${student_id}">not begin</a>
    </c:if>
    <c:if test="${test == 'beginFirst'}">
        <a href="<%=basePath%>test/firstBeginTest?student_id=${student_id}">begin test</a>
    </c:if>
    <c:if test="${test == 'beginSecond'}">
        <a href="<%=basePath%>test/seocndBeginTest?student_id=${student_id}">second test</a>
    </c:if>
    <c:if test="${test == 'ending'}">
        <a href="<%=basePath%>test/studentStatistics?student_id=${student_id}">ending</a>
    </c:if>
  </body>  
</html>  