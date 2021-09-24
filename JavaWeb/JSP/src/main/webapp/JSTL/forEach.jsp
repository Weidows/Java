<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 29845
  Date: 2021/4/8
  Time: 20:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
  <title>forEach</title>
</head>
<body>

<%
  ArrayList<String> setPeople = new ArrayList<>();
  setPeople.add(0, "张三");
  setPeople.add(1, "李四");
  setPeople.add(2, "王五");
  setPeople.add(3, "赵六");
  setPeople.add(4, "田六");
  request.setAttribute("list", setPeople);
%>

<%--
  var , 每一次遍历出来的变量
  items, 要遍历的对象
  可选:
    begin,   哪里开始
    end,     到哪里
    step,   步长
--%>
<c:forEach var="getPeople" items="${list}" begin="1" end="3" step="1">
  <c:out value="${getPeople}"/>
  <br/>
</c:forEach>
</body>
</html>
