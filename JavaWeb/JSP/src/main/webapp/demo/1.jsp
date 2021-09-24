<!--
* @?: *********************************************************************
* @Author: Weidows
* @Date: 2021-04-07 16:29:42
 * @LastEditors: Weidows
 * @LastEditTime: 2021-04-07 17:29:11
 * @FilePath: \Weidows\JavaWeb\JSP\src\main\webapp\1.jsp
* @Description:
* @!: *********************************************************************
* servlet 2.3默认不支持EL表达式,需要开启.
-->
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>index4</title>
  </head>
  <body>
    <%--
      PageContext 存东西
      Request 存东西
      Response
      Session 存东西
      Application 【SerlvetContext】 存东西
      config 【SerlvetConfig】
      out
      page ，不用了解
      exception
    --%>
    <%
      pageContext.setAttribute("name1", "秦疆1号"); // 保存的数据只在一个页面中有效
      request.setAttribute("name2", "秦疆2号"); // 保存的数据只在一次请求中有效，请求转发会携带这个数据
      session.setAttribute("name3", "秦疆3号"); // 保存的数据只在一次会话中有效，从打开浏览器到关闭浏览器
      application.setAttribute("name4", "秦疆4号"); // 保存的数据只在服务器中有效，从打开服务器到关闭服务器

      // 作用域从小到大
      String name1 = (String) pageContext.findAttribute("name1");
      String name2 = (String) pageContext.findAttribute("name2");
      String name3 = (String) pageContext.findAttribute("name3");
      String name4 = (String) pageContext.findAttribute("name4");
      String name5 = (String) pageContext.findAttribute("name5"); // 这个不存在
    %>

    <%--
      EL表达式
      ${内容} == <%= 内容 %>
      用EL表达式的话,null值不会显示,而使用JSP表达式会显示null值
    --%>
    <h1>取出的内容:</h1>
    <h3>${name1}</h3>
    <h3>${name2}</h3>
    <h3>${name3}</h3>
    <h3>${name4}</h3>
    <HR>
    <h3>${name5}</h3>
    <h3><%=name5%></h3>
  </body>
</html>
