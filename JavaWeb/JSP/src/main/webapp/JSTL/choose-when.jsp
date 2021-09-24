<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--
* @?: *********************************************************************
* @Author: Weidows
* @Date: 2021-04-08 20:38:13
 * @LastEditors: Weidows
 * @LastEditTime: 2021-04-08 20:54:01
 * @FilePath: \Weidows\JavaWeb\JSP\src\main\webapp\JSTL\choose-when.jsp
* @Description:
* @!: *********************************************************************
-->
<%-- Created by IntelliJ IDEA. User: 29845 Date: 2021/4/8 Time: 20:38 To change
this template use File | Settings | File Templates. --%> <%@ page
contentType="text/html;charset=UTF-8" language="java" %> <%@ page
isELIgnored="false" %>
<html>
  <head>
    <title>choose-when测试</title>
  </head>
  <body>
    <form action="" method="post">
      <label>
        <%--定义一个变量score--%>
        <input type="text" name="score" />
      </label>
      <input type="submit" name="提交" />
    </form>
    <c:choose>
      <c:when test="${param.score>=90}"> 你的成绩为优秀 </c:when>
      <c:when test="${param.score>=80}"> 你的成绩为一般 </c:when>
      <c:when test="${param.score>=70}"> 你的成绩为良好 </c:when>
      <c:when test="${param.score<=60}"> 你的成绩为不及格 </c:when>
    </c:choose>
  </body>
</html>
