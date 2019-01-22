<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>  
  <head>
      <%@ include file="admin.jsp" %>
  </head>  
    
  <body>  
    <%--<h6><a href="<%=basePath%>student/toAddStudent">addStudent</a></h6>--%>
    <table border="1">  
        <tbody>  
            <tr>
                <th>student_id</th>
                <th>student_name</th>
                <th>password</th>
            </tr>  
            <c:if test="${!empty studentList }">
                <c:forEach items="${studentList}" var="student">
                    <tr>  
                        <td>${student.studentId}</td>
                        <td>${student.studentName}</td>
                        <td>${student.password}</td>
                        <td>
                            <a href="<%=basePath%>student/delStudent?studentId=${student.studentId}">delete</a>
                        </td>  
                    </tr>               
                </c:forEach>  
            </c:if>  
        </tbody>  
    </table>  
  </body>  
</html>