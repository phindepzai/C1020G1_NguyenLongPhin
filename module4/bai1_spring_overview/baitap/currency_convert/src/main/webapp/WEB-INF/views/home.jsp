<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2/22/2021
  Time: 2:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="" method="post">
    <label for="usd">USD:</label>
    <input id="usd" type="text" name="usd" value="${usd}">
    <label for="vnd">VND:</label>
    <input id="vnd" type="text" name="vnd" value="${vnd}" readonly>
    <input type="submit" value="convert">
</form>
</body>
</html>
