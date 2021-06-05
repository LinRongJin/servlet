<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form method="post" action="selectUser">
    <input type="submit" value="alluser"/>
    <c:forEach items="${userlist}" var="userl">
        <h3>${userl.username}</h3>
    </c:forEach>
</form>
<form method="post" action="register">
   username: <input name="username" type="text"/>
   age: <input type="number" name="age" />
   sex: <input type="text" name="sex" />
    <input type="submit" value="registered">
</form>

</body>
</html>