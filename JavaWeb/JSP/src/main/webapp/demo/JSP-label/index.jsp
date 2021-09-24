<%--
  Created by IntelliJ IDEA.
  User: 29845
  Date: 2021/4/7
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>JSP-label</title>
</head>
<body>
<%-- 转发request携带的参数(注意JSP标签内不能有注释,会报错500) --%>
<jsp:forward page="forward.jsp">
  <jsp:param name="name" value="kuangshen"/>
  <jsp:param name="age" value="12"/>
</jsp:forward>
</body>
</html>
