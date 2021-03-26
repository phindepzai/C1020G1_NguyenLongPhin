<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2/2/2021
  Time: 8:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
<div class="container-fluid">
    <form action="/serviceServlet" method="post">
        <input type="hidden" value="${types}" name="types">
        <div class="form-group">
            <label for="inlineforminput">Name</label>
            <input required type="text" class="form-control" id="inlineFormInput" name="name">
        </div>
        <div class="form-group">
            <label for="inputArea">Area</label>
            <input required type="text" class="form-control" id="inputArea" name="area" >
        </div>
        <div class="form-group">
            <label for="inputCost">Cost</label>
            <input required type="text" class="form-control" id="inputCost" name="cost">
        </div>
        <div class="form-group">
            <label for="inputMax">Max People</label>
            <input required type="text" class="form-control" id="inputMax" name="maxPeople">
        </div>
        <div class="form-group">
            <label for="selectRentType">Rent Type</label>
            <select class="custom-select" id="selectRentType" name="rentType">
                <c:forEach var="type" items="${rentTypeList}">
                    <option value="${type.id}"><c:out
                            value="${type.name}"></c:out></option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="selectServiceType">Service Type</label>
            <select class="custom-select" id="selectServiceType" name="serviceType">
                <option value="${types}">${typeName}</option>
            </select>
        </div>
        <c:if test="${types != 3}">
            <div class="form-group">
                <label for="inputStandardRoom">Standard Room</label>
                <input required type="text" class="form-control" id="inputStandardRoom" name="standardRoom">
            </div>
            <div class="form-group">
                <label for="inputDescription">Description</label>
                <input required type="text" class="form-control" id="inputDescription"
                       name="description">
            </div>
            <c:if test="${types == 1}">
                <div class="form-group">
                    <label for="inputPoolArea">Pool Area</label>
                    <input required type="text" class="form-control" id="inputPoolArea"
                           name="poolArea">
                </div>
            </c:if>
            <div class="form-group">
                <label for="inputNumberOfFloor">Number Of Floor</label>
                <input required type="text" class="form-control" id="inputNumberOfFloor"
                       name="numOfFloor">
            </div>
        </c:if>
        <button type="submit" class="btn btn-primary">Create</button>
    </form>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
        integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"
        integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF"
        crossorigin="anonymous"></script>
</body>
</html>
