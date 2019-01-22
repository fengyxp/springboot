<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>  
  <head>
      <%@ include file="admin.jsp" %>
  </head>
    
  <body>
    <h6>First Test Question</h6>
    <table border="1">  
        <tbody>  
            <tr>
                <th>question_id</th>
                <th>question</th>
                <th>A</th>
                <th>B</th>
                <th>C</th>
                <th>D</th>
                <th>answer</th>

            </tr>  
            <c:if test="${!empty testQ }">
                <c:forEach items="${testQ}" var="question">
                    <tr>  
                        <td>${question.questionId}</td>
                        <td>${question.question}</td>
                        <td>${question.a}</td>
                        <td>${question.b}</td>
                        <td>${question.c}</td>
                        <td>${question.d}</td>
                        <td>${question.answer}</td>
                    </tr>               
                </c:forEach>  
            </c:if>  
        </tbody>  
    </table>
    <h6>Second Test Question</h6>
    <table border="1">
        <tbody>
        <tr>
            <th>question_id</th>
            <th>question</th>
            <th>A</th>
            <th>B</th>
            <th>C</th>
            <th>D</th>
            <th>answer</th>

        </tr>
        <c:if test="${!empty secondTestQ }">
            <c:forEach items="${secondTestQ}" var="question">
                <tr>
                    <td>${question.questionId}</td>
                    <td>${question.question}</td>
                    <td>${question.a}</td>
                    <td>${question.b}</td>
                    <td>${question.c}</td>
                    <td>${question.d}</td>
                    <td>${question.answer}</td>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>

  </body>  
</html>