<%--
  Created by IntelliJ IDEA.
  User: hui
  Date: 2021/10/12
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/FileServlet" method="post" enctype="multipart/form-data">
    <input type="file" name="myfile">
    <input type="file" name="myfile">
    <input type="file" name="myfile">
    <input type="file" name="myfile">
    <input type="file" name="myfile">
    <input type="submit" value="上传">
</form>
</body>
</html>
