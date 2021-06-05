<%--
  Created by IntelliJ IDEA.
  User: Roger
  Date: 2021/6/1
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>alluser</title>
</head>
<body>
<form method="post" action="UserService">
    <c:forEach items="${userlist}" var="user">
        <h3>${user.toString()}</h3>
    </c:forEach>
</form>

</body>
</html>
