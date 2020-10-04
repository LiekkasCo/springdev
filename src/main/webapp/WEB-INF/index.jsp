<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>My Test Jsp</title>
</head>
<body>
    <h1>Hello Jsp!</h1>
    <h1>User Info : ${userInfo}</h1>
    <table border="1">
        <tr><th>id</th>
            <th>name</th>
            <th>age</th>
            <th>gender</th>
        </tr>
            <c:forEach items="${userInfo}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.gender}</td>
        </tr>
    </c:forEach>
    </table>
</body>
</html>