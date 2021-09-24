<!--
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-04-07 20:01:51
 * @LastEditors: Weidows
 * @LastEditTime: 2021-04-08 20:37:09
 * @Description:
 * @!: *********************************************************************
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%@ taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%@ page
isELIgnored="false" %>
<html>
  <head>
    <title>if测试</title>
  </head>
  <body>
    <%--action是代码提交位置--%>
    <form action="if.jsp" method="post">
      <label>
        用户名:
        <input type="text" name="username" />
      </label>
      <input type="submit" value="登录" />
    </form>

    <hr />

    <%--
      EL表达式获取表单中的数据 ${param.参数名}
      判断如果提交的用户名是admin，则登录成功,并把isAdmin置为true
      --%>
    <c:if test="${param.username=='admin'}" var="isAdmin">
      <c:out value="管理员欢迎您！" />
    </c:if>
  </body>
</html>
