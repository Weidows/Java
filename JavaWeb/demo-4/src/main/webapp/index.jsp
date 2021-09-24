<!--
* @?: *********************************************************************
* @Author: Weidows
* @Date: 2021-03-29 18:29:21
* @LastEditors: Weidows
* @LastEditTime: 2021-03-29 23:46:43
* @FilePath: \Weidows\JavaWeb\demo-4\src\main\webapp\index.jsp
* @Description:
* @!: *********************************************************************
-->
<%-- Created by IntelliJ IDEA. User: 29845 Date: 2021/3/29 Time: 18:40 To change
this template use File | Settings | File Templates. --%>
<%@ page
    contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>登录页面</title>
</head>
<body>
<h1>登录</h1>

<div style="text-align: center">
  <form action="/login" method="post">
    <label>
      用户名:
      <input type="text" name="username" placeholder="无"/><br>
    </label>
    <label>
      密码:
      <input type="password" name="password" placeholder=""/><br>
    </label>

    爱好:
    <label><input type="checkbox" name="hobbys" value="女孩"/>女孩</label>
    <label><input type="checkbox" name="hobbys" value="代码"/>代码</label>
    <label><input type="checkbox" name="hobbys" value="动漫"/>动漫</label>
    <label><input type="checkbox" name="hobbys" value="美食"/>美食</label><br>
    <input type="submit">
  </form>
</div>
</body>
</html>
