<!--
* @?: *********************************************************************
* @Author: Weidows
* @Date: 2021-04-03 11:35:52
 * @LastEditors: Weidows
 * @LastEditTime: 2021-04-06 23:41:03
 * @FilePath: \Weidows\JavaWeb\JSP\src\main\webapp\index.jsp
* @Description:
* @!: *********************************************************************
-->
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>测试</title>
  </head>
  <body>
    <!-- 这是HTML的注释,会在客户端显示 -->
    <%-- 这是JSP注释,不会在客户端显示 --%>

    <!--
      JSP表达式: 用来将程序输出到客户端
      <%= "变量或者表达式"%>
    -->
    <%= new Date()%>

    <!--
      JSP脚本片段
      <%--jsp脚本片段--%>
    -->
    <%
      int sum = 0;
      for (int i = 1; i <=100 ; i++) { sum+=i; }
      out.println("<h1>Sum="+sum+"</h1>");
    %>

    <!--
      JSP声明
      会被编译到JSP生成Java的类中！其他的，就会被生成到_jspService方法中！
    -->
    <%!
      static {
        System.out.println("Loading Servlet!");
      }

      private int globalVar = 0;

      public void kuang(){
        System.out.println("进入了方法Kuang！");
      }
    %>
  </body>
</html>
