<%--
  Created by IntelliJ IDEA.
  User: hui
  Date: 2021/10/12
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
<c:forEach items="${sessionScope.f}" var="f">
        <li><a href="/File2Servlet?filename=${f}">${f}</a></li>
</c:forEach>
</ul>
</body>
</html>
