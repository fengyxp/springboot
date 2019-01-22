<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>  
  <head>
      <%@ include file="admin.jsp" %>
  </head>
    
  <body>
    <h6>studentScores</h6>
    <table border="1">  
        <tbody>  
            <tr>
                <th>student_id</th>
                <th>score</th>
                <th>second_score</th>
                <th>total_score</th>
                <th>result</th>
                <th>threshold</th>
            </tr>  
            <c:if test="${!empty studentScores}">
                <c:forEach items="${studentScores}" var="studentScore">
                    <tr>  
                        <td>${studentScore.studentId}</td>
                        <td>${studentScore.score}</td>
                        <td>${studentScore.secondScore}</td>
                        <td>${studentScore.totalScore}</td>
                        <td>${studentScore.result}</td>
                        <td>${studentScore.threshold}</td>
                    </tr>               
                </c:forEach>  
            </c:if>  
        </tbody>  
    </table>
    <h6>StudentAnswers</h6>
    <table border="1">
        <tbody>
        <tr>
            <th>question_id</th>
            <th>student_id</th>
            <th>select_answer</th>
            <th>second_select</th>
            <th>answer</th>
            <th>analyse</th>


        </tr>
        <c:if test="${!empty studentAnswers}">
            <c:forEach items="${studentAnswers}" var="studentAnswer">
                <tr>
                    <td>${studentAnswer.questionId}</td>
                    <td>${studentAnswer.studentId}</td>
                    <td>${studentAnswer.selectAnswer}</td>
                    <td>${studentAnswer.secondSelect}</td>
                    <td>${studentAnswer.answer}</td>
                    <td>${studentAnswer.analyse}</td>
                </tr>
            </c:forEach>
        </c:if>
        </tbody>
    </table>

  </body>  
</html>