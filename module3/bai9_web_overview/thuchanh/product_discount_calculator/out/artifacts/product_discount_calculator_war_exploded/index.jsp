<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 1/22/2021
  Time: 2:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Product Discount Calculator</title>
  </head>
  <body>
  <h2>Product</h2>
  <form action="/calculator">
    <label>Description<br>
      <input type="text" title="description" name="description">
    </label><br>
    <label>Price<br>
      <input type="text" title="price" name="price">
    </label><br>
    <label>Discount<br>
      <input type="text" title="discount" name="discount">
    </label><br>
    <label>Discount Amount<br>
      <input type="text" title="discountAmount" value="<%=request.getAttribute("amount")%>" readonly>
    </label><br>
    <label>Price after Discount<br>
      <input type="text" title="discountPrice" value="<%=request.getAttribute("result")%>" readonly>
    </label><br>
    <input type="submit" value="calculate">
  </form>
  </body>
</html>
