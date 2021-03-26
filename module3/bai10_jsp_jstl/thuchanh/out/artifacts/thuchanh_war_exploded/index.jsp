<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 1/22/2021
  Time: 3:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="currency.jsp">
    <h2>Bài 1: Chuyển đổi tiền tệ : </h2>
    <input type="submit" value="xem">
</form>
<c:set scope="request" var="greeting" value="<p>alert('Yo')</p>" />
<p>The person's name is <c:out value="${greeting}" /></p>
<form action="dictionary.jsp">
    <h2>Bài 2: Từ điển : </h2>
    <input type="submit" value="xem">
</form>
</body>
</html>
