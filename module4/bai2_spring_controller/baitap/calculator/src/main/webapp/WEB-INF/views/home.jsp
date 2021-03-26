<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2/23/2021
  Time: 11:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form"	uri="http://www.springframework.org/tags/form"%>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/calculate">
    <label for="number1">Number 1 :<br>
      <input id="number1" type="text" name="number1" value="${number1}">
    </label><br>
    <label for="number2">Number 2 :<br>
      <input id="number2" type="text" name="number2" value="${number2}">
    </label><br>
    <label for="result">Result :<br>
      <input id="result" type="text" value="${result}">
    </label><br>
    <input type="submit" name="operate" value="cong">
    <input type="submit" name="operate" value="tru">
    <input type="submit" name="operate" value="nhan">
    <input type="submit" name="operate" value="chia">
  </form>
  </body>
</html>
