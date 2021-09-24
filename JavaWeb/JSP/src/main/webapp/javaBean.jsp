<!--
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-04-08 23:32:02
 * @LastEditors: Weidows
 * @LastEditTime: 2021-04-08 23:37:53
 * @FilePath: \Weidows\JavaWeb\JSP\src\main\webapp\javaBean.jsp
 * @Description:
 * @!: *********************************************************************
-->
<%-- Created by IntelliJ IDEA. User: 29845 Date: 2021/4/8 Time: 23:32 To change
this template use File | Settings | File Templates. --%> <%@ page
contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>javaBean测试</title>
  </head>
  <body>
    <jsp:useBean id="people" class="pojo.People" scope="page" />
    <jsp:setProperty name="people" property="id" value="1" />
    <jsp:setProperty name="people" property="name" value="狂神说" />
    <jsp:setProperty name="people" property="age" value="3" />
    <jsp:setProperty name="people" property="address" value="西安" />

    id:
    <jsp:getProperty name="people" property="id" />
    name:
    <jsp:getProperty name="people" property="name" />
    age:
    <jsp:getProperty name="people" property="age" />
    address:
    <jsp:getProperty name="people" property="address" />
  </body>
</html>
