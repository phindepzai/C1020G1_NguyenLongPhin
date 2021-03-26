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
    <c:if test="${isCreate == 0}">
        <c:if test="${isWrong == 0}">
            <form action="/customerServlet" method="post">
                <input type="hidden" value="create" name="action">
                <div class="form-group">
                    <label for="inlineforminput">Name</label>
                    <input required type="text" class="form-control" id="inlineFormInput" name="name">
                </div>
                <div class="form-group">
                    <label for="selecttype">Type Of Customer : </label>
                    <select class="custom-select" id="selecttype" name="typeId">
                        <c:forEach var="type" items="${typeList}">
                            <option value="${type.id}"><c:out
                                    value="${type.name}"></c:out></option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="inputdob">Date Of Birth</label>
                    <input required type="text" class="form-control" id="inputdob" name="dob">
                </div>
                <div class="form-group">
                    <label for="inputgender">Gender</label>
                    <input required type="text" class="form-control" id="inputgender" name="gender">
                </div>
                <div class="form-group">
                    <label for="inputidcard">ID Card</label>
                    <input required type="text" class="form-control" id="inputidcard" name="idCard">
                </div>
                <div class="form-group">
                    <label for="inputphone">Phone</label>
                    <input required type="text" class="form-control" id="inputphone" name="phone">
                </div>
                <div class="form-group">
                    <label for="inputemail4">Email</label>
                    <input required type="text" class="form-control" id="inputemail4"
                           placeholder="abc@codegym.com"
                           name="email">
                </div>
                <div class="form-group">
                    <label for="inputAddress">Address</label>
                    <input required type="text" class="form-control" id="inputAddress"
                           placeholder="Da Nang"
                           name="address">
                </div>
                <button type="submit" class="btn btn-primary">Create</button>
            </form>
        </c:if>
        <c:if test="${isWrong == 1}">
            <form action="/customerServlet" method="post">
                <input type="hidden" value="create" name="action">
                <div class="form-group">
                    <label for="inlineforminput2">Name</label>
                    <input required type="text" class="form-control" id="inlineFormInput2" name="name" value="${name}">
                </div>
                <div class="form-group">
                    <label for="selecttype2">Type Of Customer : </label>
                    <select class="custom-select" id="selecttype2" name="typeId">
                        <option value="${customerType.id}"><c:out
                                value="${customerType.name}"></c:out></option>
                        <c:forEach var="type" items="${typeList}">
                            <c:if test="${customerType.id != type.id}">
                                <option value="${type.id}"><c:out
                                        value="${type.name}"></c:out></option>
                            </c:if>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="inputdob2">Date Of Birth</label>
                    <input required type="text" class="form-control" id="inputdob2" name="dob" value="${dob}">
                </div>
                <div class="form-group">
                    <label for="inputgender2">Gender</label>
                    <input required type="text" class="form-control" id="inputgender2" name="gender" value="${gender}">
                </div>
                <div class="form-group">
                    <label for="inputidcard2">ID Card</label>
                    <input required type="text" class="form-control" id="inputidcard2" name="idCard" value="${idCard}">
                </div>
                <div class="form-group">
                    <label for="inputphone2">Phone</label>
                    <input required type="text" class="form-control" id="inputphone2" name="phone" value="${phone}">
                </div>
                <div class="form-group">
                    <label for="inputemail42">Email</label>
                    <input required type="text" class="form-control" id="inputemail42" value="${email}"
                           placeholder="abc@codegym.com"
                           name="email">
                </div>
                <div class="form-group">
                    <label for="inputAddress2">Address</label>
                    <input required type="text" class="form-control" id="inputAddress2"
                           placeholder="Da Nang" value="${address}"
                           name="address">
                </div>
                <button type="submit" class="btn btn-primary">Create</button>
            </form>
        </c:if>
    </c:if>
    <c:if test="${isCreate == 1}">
        <form action="/customerServlet" method="post">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="id" value="${customer.id}">
            <div class="form-group">
                <label for="inlineforminput1">Name</label>
                <input required type="text" class="form-control" id="inlineFormInput1" name="name" value="${customer.name}">
            </div>
            <div class="form-group">
                <label for="selecttype1">Type Of Customer : </label>
                <select class="custom-select" id="selecttype1" name="typeId">
                    <option value="${customer.customerType.id}"><c:out value="${customer.customerType.name}"/></option>
                    <c:forEach var="type" items="${typeList}">
                        <c:if test="${type.id != customer.customerType.id}">
                            <option value="${type.id}">
                                <c:out value="${type.name}"></c:out>
                            </option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="inputdob1">Date Of Birth</label>
                <input required type="text" class="form-control" id="inputdob1" name="dob" value="${customer.dateOfBirth}">
            </div>
            <div class="form-group">
                <label for="inputgender1">Gender</label>
                <input required type="text" class="form-control" id="inputgender1" name="gender" value="${customer.gender}">
            </div>
            <div class="form-group">
                <label for="inputidcard1">ID Card</label>
                <input required type="text" class="form-control" id="inputidcard1" name="idCard" value="${customer.idCard}">
            </div>
            <div class="form-group">
                <label for="inputphone1">Phone</label>
                <input required type="text" class="form-control" id="inputphone1" name="phone" value="${customer.phone}">
            </div>
            <div class="form-group">
                <label for="inputemail1">Email</label>
                <input required type="text" class="form-control" id="inputemail1" value="${customer.email}"
                       placeholder="abc@codegym.com"
                       name="email">
            </div>
            <div class="form-group">
                <label for="inputAddress1">Address</label>
                <input required type="text" class="form-control" id="inputAddress1" value="${customer.address}"
                       placeholder="Da Nang"
                       name="address">
            </div>
            <button type="submit" class="btn btn-primary">Update</button>
        </form>
    </c:if>
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
