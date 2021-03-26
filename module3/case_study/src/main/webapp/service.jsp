<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  customer: ASUS
  Date: 1/29/2021
  Time: 2:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

    <style>
        .row, [class*="col-"] {
            padding: 0;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-light">
    <a class="navbar-brand pl-5" href="/homeServlet"><img src="image/logo.png" alt="" width="35px" height="35px"></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse ml-5 pl-5" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto"></ul>
        <c:if test="${sessionScope.username != null}">
            <c:out value="${sessionScope.username}"/>
            <a class="nav-link" href="/homeServlet?action=logout">Log out</a>
        </c:if>
        <c:if test="${sessionScope.username == null}">
            <a class="nav-link" href="/homeServlet?action=login">Log in</a>
        </c:if>
    </div>
</nav>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand pl-5" href="/customerServlet">Binz</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent2"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse ml-5 pl-5" id="navbarSupportedContent2">
        <ul class="navbar-nav mr-auto ml-5 pl-5">
            <li class="nav-item pl-5">
                <a class="nav-link" href="/employeeServlet">Employee</a>
            </li>
            <li class="nav-item pl-5">
                <a class="nav-link" href="/customerServlet">Customer</a>
            </li>
            <li class="nav-item active pl-5">
                <a class="nav-link" href="/serviceServlet">Service</a>
            </li>
            <li class="nav-item pl-5">
                <a class="nav-link" href="/contractServlet">Contract</a>
            </li>
            <li class="nav-item pl-5">
                <a class="nav-link" href="/contractDetailServlet">Contract Detail</a>
            </li>
        </ul>
    </div>
</nav>
<c:if test="${sessionScope.username != null}">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-1">
                <nav class="nav flex-column bg-info">
                    <a class="btn" href="/serviceServlet?action=createVilla">Create new Villa</a>
                    <a class="btn" href="/serviceServlet?action=createHouse">Create new House</a>
                    <a class="btn" href="/serviceServlet?action=createRoom">Create new Room</a>
                    <a class="btn" href="/serviceServlet?action=viewVilla">View Villa</a>
                    <a class="btn" href="/serviceServlet?action=viewHouse">View House</a>
                    <a class="btn" href="/serviceServlet?action=viewRoom">View Room</a>
                </nav>
            </div>
            <div class="col-lg-11">
                <c:if test="${type == 1}">
                    <table class="table table-hover table-striped table-dark">
                        <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Name</th>
                            <th scope="col">Area</th>
                            <th scope="col">Cost</th>
                            <th scope="col">Max People</th>
                            <th scope="col">Rent Type</th>
                            <th scope="col">Service Type</th>
                            <th scope="col">Standard Room</th>
                            <th scope="col">Description</th>
                            <th scope="col">Pool Area</th>
                            <th scope="col">Number Of Floor</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="villa" items="${villas}">
                            <tr>
                                <td>${villa.id}</td>
                                <td>${villa.name}</td>
                                <td>${villa.area}</td>
                                <td>${villa.cost}</td>
                                <td>${villa.quantityMax}</td>
                                <td>${villa.rentType.name}</td>
                                <td>${villa.serviceType.name}</td>
                                <td>${villa.standardRoom}</td>
                                <td>${villa.descriptionOtherConvenience}</td>
                                <td>${villa.poolArea}</td>
                                <td>${villa.numOfFloor}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:if>
                <c:if test="${type == 2}">
                    <table class="table table-hover table-striped table-dark">
                        <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Name</th>
                            <th scope="col">Area</th>
                            <th scope="col">Cost</th>
                            <th scope="col">Max People</th>
                            <th scope="col">Rent Type</th>
                            <th scope="col">Service Type</th>
                            <th scope="col">Standard Room</th>
                            <th scope="col">Description</th>
                            <th scope="col">Number Of Floor</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="house" items="${houses}">
                            <tr>
                                <td>${house.id}</td>
                                <td>${house.name}</td>
                                <td>${house.area}</td>
                                <td>${house.cost}</td>
                                <td>${house.quantityMax}</td>
                                <td>${house.rentType.name}</td>
                                <td>${house.serviceType.name}</td>
                                <td>${house.standardRoom}</td>
                                <td>${house.descriptionOtherConvenience}</td>
                                <td>${house.numOfFloor}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:if>
                <c:if test="${type == 3}">
                    <table class="table table-hover table-striped table-dark">
                        <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Name</th>
                            <th scope="col">Area</th>
                            <th scope="col">Cost</th>
                            <th scope="col">Max People</th>
                            <th scope="col">Rent Type</th>
                            <th scope="col">Service Type</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="room" items="${rooms}">
                            <tr>
                                <td>${room.id}</td>
                                <td>${room.name}</td>
                                <td>${room.area}</td>
                                <td>${room.cost}</td>
                                <td>${room.quantityMax}</td>
                                <td>${room.rentType.name}</td>
                                <td>${room.serviceType.name}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:if>
            </div>
        </div>
    </div>
    <nav aria-label="Page navigation example">
        <ul class="pagination justify-content-center">
            <c:if test="${size > 5}">
                <c:if test="${page == 1}">
                    <li class="page-item disabled">
                        <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
                    </li>
                </c:if>
                <c:if test="${page != 1}">
                    <li class="page-item">
                        <a class="page-link" href="/serviceServlet?page=${page-1}">Previous</a>
                    </li>
                </c:if>
                <c:forEach var="i" begin="1" end="${numPage}">
                    <c:if test="${page != i}">
                        <li class="page-item"><a class="page-link" href="/serviceServlet?page=${i}">${i}</a></li>
                    </c:if>
                    <c:if test="${page == i}">
                        <li class="page-item active" aria-current="page">
                            <span class="page-link">${i}</span>
                        </li>
                    </c:if>
                </c:forEach>
                <c:if test="${page == numPage}">
                    <li class="page-item disabled">
                        <a class="page-link" href="#" tabindex="+1" aria-disabled="true">Next</a>
                    </li>
                </c:if>
                <c:if test="${page != numPage}">
                    <li class="page-item">
                        <a class="page-link" href="/serviceServlet?page=${page+1}">Next</a>
                    </li>
                </c:if>
            </c:if>
            <c:if test="${size <= 5}">
                <li class="page-item disabled">
                    <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
                </li>
                <li class="page-item"><a class="page-link" href="/serviceServlet?page=1">1</a></li>
                <li class="page-item disabled">
                    <a class="page-link" href="#" tabindex="+1" aria-disabled="true">Next</a>
                </li>
            </c:if>
        </ul>
    </nav>
</c:if>
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
