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
        <form action="/employeeServlet" method="post">
            <input type="hidden" value="create" name="action">
            <div class="form-group">
                <label for="inputuser">Username</label>
                <input required type="text" class="form-control" id="inputuser" name="username">
            </div>
            <div class="form-group">
                <label for="inputpassword">Password</label>
                <input required type="password" class="form-control" id="inputpassword" name="password">
            </div>
            <div class="form-group">
                <label for="inlineforminput">Name</label>
                <input required type="text" class="form-control" id="inlineFormInput" name="name">
            </div>
            <div class="form-group">
                <label for="inputdob">Date Of Birth</label>
                <input required type="text" class="form-control" id="inputdob" name="dob">
            </div>
            <div class="form-group">
                <label for="inputidcard">ID Card</label>
                <input required type="text" class="form-control" id="inputidcard" name="idCard">
            </div>
            <div class="form-group">
                <label for="inputsalary">Salary</label>
                <input required type="text" class="form-control" id="inputsalary" name="salary">
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
            <div class="form-group">
                <label for="selectposition">Position</label>
                <select class="custom-select" id="selectposition" name="position">
                    <c:forEach var="element" items="${positionList}">
                        <option value="${element.id}"><c:out
                                value="${element.name}"></c:out></option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="selectED">Education Degree</label>
                <select class="custom-select" id="selectED" name="eD">
                    <c:forEach var="ed" items="${edList}">
                        <option value="${ed.id}"><c:out
                                value="${ed.name}"></c:out></option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="selectdivision">Division</label>
                <select class="custom-select" id="selectdivision" name="division">
                    <c:forEach var="division" items="${divisionList}">
                        <option value="${division.id}"><c:out
                                value="${division.name}"></c:out></option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Create</button>
        </form>
    </c:if>
    <c:if test="${isWrong == 1}">
        <form action="/customerServlet" method="post">
            <input type="hidden" value="create" name="action">
            <div class="form-group">
                <label for="inputuser1">Username</label>
                <input required type="text" class="form-control" id="inputuser1" name="username" value="${username}">
            </div>
            <div class="form-group">
                <label for="inputpassword1">Password</label>
                <input required type="password" class="form-control" id="inputpassword1" name="password"
                       value="${password}">
            </div>
            <div class="form-group">
                <label for="inputname1">Name</label>
                <input required type="text" class="form-control" id="inputname1" name="name" value="${name}">
            </div>
            <div class="form-group">
                <label for="inputdob2">Date Of Birth</label>
                <input required type="text" class="form-control" id="inputdob2" name="dob" value="${dob}">
            </div>
            <div class="form-group">
                <label for="inputidcard2">ID Card</label>
                <input required type="text" class="form-control" id="inputidcard2" name="idCard" value="${idCard}">
            </div>
            <div class="form-group">
                <label for="inputsalary2">Salary</label>
                <input required type="text" class="form-control" id="inputsalary2" name="salary" value="${salary}">
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
            <div class="form-group">
                <label for="selectposition1">Position</label>
                <select class="custom-select" id="selectposition1" name="position">
                    <option value="${position.id}"><c:out
                            value="${position.name}"></c:out></option>
                    <c:forEach var="element" items="${typeList}">
                        <c:if test="${element.id != position.id}">
                            <option value="${element.id}"><c:out
                                    value="${element.name}"></c:out></option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="selectED1">Education Degree</label>
                <select class="custom-select" id="selectED1" name="eD">
                    <option value="${ed.id}"><c:out
                            value="${ed.name}"></c:out></option>
                    <c:forEach var="element" items="${edList}">
                        <c:if test="${element.id != ed.id}">
                            <option value="${element.id}"><c:out
                                    value="${element.name}"></c:out></option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="selectdivision1">Division</label>
                <select class="custom-select" id="selectdivision1" name="division">
                    <option value="${division.id}"><c:out
                            value="${division.name}"></c:out></option>
                    <c:forEach var="element" items="${divisionList}">
                        <c:if test="${element.id != division.id}">
                            <option value="${element.id}"><c:out
                                    value="${element.name}"></c:out></option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Create</button>
        </form>
    </c:if>
    <c:if test="${isCreate == 1}">
        <form action="/employeeServlet" method="post">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="id" value="${employee.id}">
            <input type="hidden" value="create" name="action">
            <div class="form-group">
                <label for="inputuser2">Username</label>
                <input readonly type="text" class="form-control" id="inputuser2" name="username"
                       value="${employee.user.userName}">
            </div>
            <div class="form-group">
                <label for="inputpassword2">Password</label>
                <input required type="password" class="form-control" id="inputpassword2" name="password"
                       value="${employee.user.passWord}">
            </div>
            <div class="form-group">
                <label for="inputname2">Name</label>
                <input required type="text" class="form-control" id="inputname2" name="name" value="${employee.name}">
            </div>
            <div class="form-group">
                <label for="inputdob1">Date Of Birth</label>
                <input required type="text" class="form-control" id="inputdob1" name="dob"
                       value="${employee.dateOfBirth}">
            </div>
            <div class="form-group">
                <label for="inputidcard1">ID Card</label>
                <input required type="text" class="form-control" id="inputidcard1" name="idCard"
                       value="${employee.idCard}">
            </div>
            <div class="form-group">
                <label for="inputsalary1">Salary</label>
                <input required type="text" class="form-control" id="inputsalary1" name="salary"
                       value="${employee.salary}">
            </div>
            <div class="form-group">
                <label for="inputphone1">Phone</label>
                <input required type="text" class="form-control" id="inputphone1" name="phone"
                       value="${employee.phone}">
            </div>
            <div class="form-group">
                <label for="inputemail">Email</label>
                <input required type="text" class="form-control" id="inputemail" value="${employee.email}"
                       placeholder="abc@codegym.com"
                       name="email">
            </div>
            <div class="form-group">
                <label for="inputAddress1">Address</label>
                <input required type="text" class="form-control" id="inputAddress1"
                       placeholder="Da Nang" value="${employee.address}"
                       name="address">
            </div>
            <div class="form-group">
                <label for="selectposition2">Position</label>
                <select class="custom-select" id="selectposition2" name="position">
                    <option value="${employee.position.id}"><c:out
                            value="${employee.position.name}"></c:out></option>
                    <c:forEach var="element" items="${positionList}">
                        <c:if test="${element.id != employee.position.id}">
                            <option value="${element.id}"><c:out
                                    value="${element.name}"></c:out></option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="selectED2">Education Degree</label>
                <select class="custom-select" id="selectED2" name="eD">
                    <option value="${employee.educationDegree.id}"><c:out
                            value="${employee.educationDegree.name}"></c:out></option>
                    <c:forEach var="element" items="${edList}">
                        <c:if test="${element.id != employee.educationDegree.id}">
                            <option value="${element.id}"><c:out
                                    value="${element.name}"></c:out></option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="selectdivision2">Division</label>
                <select class="custom-select" id="selectdivision2" name="division">
                    <option value="${employee.division.id}"><c:out
                            value="${employee.division.name}"></c:out></option>
                    <c:forEach var="element" items="${divisionList}">
                        <c:if test="${element.id != employee.division.id}">
                            <option value="${element.id}"><c:out
                                    value="${element.name}"></c:out></option>
                        </c:if>
                    </c:forEach>
                </select>
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
