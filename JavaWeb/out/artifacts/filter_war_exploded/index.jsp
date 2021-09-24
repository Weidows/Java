<%--
  Created by IntelliJ IDEA.
  User: 29845
  Date: 2021/4/9
  Time: 22:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>在线人数测试</title>
</head>
<body>
<h1>当前有 <span
    style="color: turquoise;"><%=this.getServletConfig().getServletContext().getAttribute("OnlineCount")%></span> 人在线
</h1>
</body>
</html>
