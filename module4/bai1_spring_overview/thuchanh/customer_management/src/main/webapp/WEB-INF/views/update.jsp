<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2/22/2021
  Time: 1:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/save">
    <input type="text" name="id" value="${customer.id}">
    <input type="text" name="name" value="${customer.name}">
    <input type="text" name="email" value="${customer.email}">
    <input type="text" name="address" value="${customer.address}">
    <input type="submit" value="update">
</form>
</body>
</html>
