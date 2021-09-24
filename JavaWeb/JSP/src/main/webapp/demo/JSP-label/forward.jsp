<%--
  Created by IntelliJ IDEA.
  User: 29845
  Date: 2021/4/7
  Time: 18:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

<html>
<head>
  <title>转发页面</title>
</head>
<body>
<%
  pageContext.setAttribute("name", request.getParameter("name"));
  pageContext.setAttribute("age", request.getParameter("age"));

%>
<h3>姓名: ${name}</h3>
<h3>年龄: ${age}</h3>
</body>
</html>
