<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 1/25/2021
  Time: 2:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/calculator">
    <label>Number 1 :<br>
        <input type="text" name="number1" placeholder="number 1" required>
    </label><br>
    <label>Number 2 :<br>
        <input type="text" name="number2" placeholder="number 2" required>
    </label><br>
    <select name="calculation">
        <option value="addition">Addition</option>
        <option value="subtraction">Subtraction</option>
        <option value="multiplication">Multiplication</option>
        <option value="division">Division</option>
    </select><br>
    <label>Result :<br>
        <input type="text" value="<%=request.getAttribute("result")%>" readonly>
    </label><br>
    <input type="submit" value="Calculate">
</form>
</body>
</html>
