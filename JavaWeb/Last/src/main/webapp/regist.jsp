<%--
  Created by IntelliJ IDEA.
  User: 29845
  Date: 2021/5/2
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Hello World!</h2>
<form action="/RegisterServlet.do" method="post">
  <label>
    用户名：
    <input type="text" name="username">
  </label>
  <label>
    密码：
    <input type="text" name="pwd">
  </label>
  <label>
    邮箱：
    <input type="text" name="email">
  </label>
  <input type="submit" value="注册">

</form>
</body>
</html>
