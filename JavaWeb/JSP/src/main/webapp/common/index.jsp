<!--
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-04-07 11:07:34
 * @LastEditors: Weidows
 * @LastEditTime: 2021-04-07 11:23:07
 * @FilePath: \Weidows\JavaWeb\JSP\src\main\webapp\index3.jsp
 * @Description:
 * @!: *********************************************************************
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>测试common</title>
  </head>
  <body>
    <!--
      这种会把include的页面内容合并进本页面,最后是展示一个页面
     -->
    <%@ include file="header.jsp" %>
    <h1>网页主体</h1>
    <%@ include file="footer.jsp" %>

    <HR />

    <!--
      jsp:include标签,本质是导入其他文件内容,最后是多个文件合为一个页面展示
      (更灵活,建议用这个)
        上面方法的因为是合并,所以很有可能出现变量重名,干扰的问题
        这个方法不同文件之间互不干扰
     -->
    <jsp:include page="/common/header.jsp" />
    <h1>网页主体</h1>
    <jsp:include page="/common/footer.jsp" />
  </body>
</html>
