<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>
      <%@ include file="admin.jsp" %>
  </head>
    
  <body>
    <p>questionCount:${questionCount}</p>
    <p>limitTime:${limitTime}</p>
    <%--<p>threshold:${threshold}</p>--%>
    <c:if test="${beginTest == 'true'}">
        <script type="text/javascript">alert("test is running,can't set");</script>
    </c:if>
    <c:if test="${beginTest == 'false'}">
        <form action="<%=basePath%>test/setTestParameters" method="post">
            question count：<input type="text" name="questionCount" value="${questionCount}"> maxCount: ${maxCount}
            limitTime：<input type="text" name="limitTime" value="${limitTime}"> minutes
            <%--threshold：<input type="text" name="threshold" value="${threshold}"> score--%>
            <input type="submit" value="set">
        </form>
    </c:if>
  </body>  
</html>  