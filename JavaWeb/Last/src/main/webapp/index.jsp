<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<%--
  GET：上传文件大小有限制
  POST：上传文件大小没有限制
   ${pageContext.request.contextPath}
 --%>
<form action="upload.do" enctype="multipart/form-data" method="post">
  <label>
    上传用户：
    <input type="text" name="username">
  </label><br/>
  <P><input type="file" name="file1"></P>
  <P><input type="file" name="file2"></P>
  <P><input type="submit" value="提交"> | <input type="reset" value="重置"></P>
</form>
</body>
</html>
