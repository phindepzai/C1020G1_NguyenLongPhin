<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2/24/2021
  Time: 8:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form:form method="get" modelAttribute="setting" action="/update">
    <h1>Setting</h1>
    <table>
        <tr>
            <td>
                <form:label path="languages">Languages
                </form:label>
            </td>
            <td>
                <form:select path="languages">
                    <form:options items="${languages}"/>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><form:label path="pageSize">Page Size
            </form:label></td>
            <td><form:select path="pageSize">
                <form:options items="${pageSizes}"/>
            </form:select></td>
        </tr>
        <tr>
            <td><form:label path="spamsFilter">Spams Filter
            </form:label></td>
            <td><form:checkbox path="spamsFilter"/></td>
        </tr>
        <tr>
            <td><form:label path="signature">Signature
            </form:label>
            </td>
            <td><form:textarea path="signature"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="update"></td>
            <td>
                <button><a href="/home">cancel</a></button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
