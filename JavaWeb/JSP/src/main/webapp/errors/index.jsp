<%--
  Created by IntelliJ IDEA.
  User: 29845
  Date: 2021/4/7
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--此处定制错误页面指向--%>
<%@ page errorPage="500.jsp" %>

<html>
<head>
  <title>错误页面</title>
</head>
<body>
<%
  int a = 1 / 0;
%>
</body>
</html>
