<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>  
  <head>
      <%@ include file="studentTestManage.jsp" %>
  </head>
  <body>
  <%@ include file="progress_bar.jsp" %>
  <br>
  <form action="<%=basePath%>test/secondSubmit?student_id=${student_id}" method="post">
    <table border="1">  
        <tbody>  
            <tr>
                <th>number</th>
                <th>question</th>
                <th>A</th>
                <th>B</th>
                <th>C</th>
                <th>D</th>
                <th>select_answer</th>
            </tr>  
            <c:if test="${!empty secondTestQuestions }">
                <c:forEach items="${secondTestQuestions}" var="question">
                    <tr>  
                        <td>${question.questionId}</td>
                        <td>${question.question}</td>
                        <td>${question.a}</td>
                        <td>${question.b}</td>
                        <td>${question.c}</td>
                        <td>${question.d}</td>
                        <td>
                            <input type="text" name="${question.questionId}">
                        </td>
                    </tr>               
                </c:forEach>  
            </c:if>  
        </tbody>  
    </table>
      <input type="submit" value="submit">
  </body>
</html>