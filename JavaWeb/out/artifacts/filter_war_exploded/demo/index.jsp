<%--
  Created by IntelliJ IDEA.
  User: 29845
  Date: 2021/4/10
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>主页</title>
</head>
<body>
<h1>登录</h1>
<form action="${pageContext.request.contextPath}/demo/login" method="post">
  <label>
    用户名:
    <input type="text" name="username"/>
  </label>
  <input type="submit" value="登录">
</form>
</body>
</html>
