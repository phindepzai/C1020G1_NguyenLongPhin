<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2/22/2021
  Time: 3:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/" method="post">
    <label for="EN">English:</label>
    <input id="EN" type="text" name="en" value="${en}">
    <label for="china">chinese:</label>
    <input id="china" type="text" name="china" value="${china}">
    <p>${error}</p>
    <input type="submit" value="translate">
</form>
</body>
</html>
