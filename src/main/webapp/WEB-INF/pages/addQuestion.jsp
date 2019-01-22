<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>
      <%@ include file="admin.jsp" %>
  </head>
    
  <body>
    <form action="<%=basePath%>question/addQuestion" method="post">
        question_id：<input type="text" name="question_id">
        question：<input type="text" name="question">
        A：<input type="text" name="A">
        B：<input type="text" name="B">
        C：<input type="text" name="C">
        D：<input type="text" name="D">
        answer：<input type="text" name="answer">
        analyse：<input type="text" name="analyse">
        <input type="submit" value="add">
    </form>  
  </body>  
</html>  