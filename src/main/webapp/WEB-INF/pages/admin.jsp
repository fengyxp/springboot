<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<body>
<c:if test="${!empty message}">
  <script type="text/javascript">alert("${message}");</script>
</c:if>
<a href="<%=basePath%>question/findAll">Manage questions</a>
<br>
<a href="<%=basePath%>student/findAll">Manage student</a>
<br>
<a href="<%=basePath%>test/toSetTestParameters">Set test parameters</a>
<br>
<a href="<%=basePath%>test/createTestQuestion">Create test questions</a>
<br>
<a href="<%=basePath%>test/toSetBeginTest">Set test status</a>
<br>
<a href="<%=basePath%>test/statistics">Checkout statistic result</a>
<br>

<a href="<%=basePath%>/login">logout</a>
<br>
</body>
</html>