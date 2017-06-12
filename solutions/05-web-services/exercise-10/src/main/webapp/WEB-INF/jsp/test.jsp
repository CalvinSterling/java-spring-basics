<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: svalstar
  Date: 10/25/16
  Time: 3:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Books:
<ul>
    <c:forEach var="listItem" items="${list}">
        <li>${listItem}</li>
    </c:forEach>
</ul>
</body>
</html>
