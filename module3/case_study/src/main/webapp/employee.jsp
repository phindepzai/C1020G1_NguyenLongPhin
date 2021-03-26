<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  employee: ASUS
  Date: 1/29/2021
  Time: 2:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>employee</title>
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
    <a class="navbar-brand pl-5" href="/employeeServlet">Binz</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent2"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse ml-5 pl-5" id="navbarSupportedContent2">
        <ul class="navbar-nav mr-auto ml-5 pl-5">
            <li class="nav-item active pl-5">
                <a class="nav-link" href="/employeeServlet">Employee</a>
            </li>
            <li class="nav-item pl-5">
                <a class="nav-link" href="/customerServlet">Customer</a>
            </li>
            <li class="nav-item pl-5">
                <a class="nav-link" href="/serviceServlet">Service</a>
            </li>
            <li class="nav-item pl-5">
                <a class="nav-link" href="/contractServlet">Contract</a>
            </li>
            <li class="nav-item pl-5">
                <a class="nav-link" href="/contractDetailServlet">Contract Detail</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0" action="/employeeServlet">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="key"
                   value="${key}">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>
<c:if test="${sessionScope.username != null}">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-1">
                <nav class="nav flex-column bg-info">
                    <a class="btn" href="/employeeServlet?action=create">Create new employee</a>
                    <button type="button" class="btn" data-toggle="modal" data-target="#exampleModalAll">
                        Delete All
                    </button>
                    <div class="modal fade" id="exampleModalAll" tabindex="-1"
                         aria-labelledby="exampleModalLabel"
                         aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLabelAll">Thông Báo</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    Bạn có chắc muốn xóa tất cả?
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Đóng
                                    </button>
                                    <a class="btn btn-primary" role="button"
                                       href="/employeeServlet?action=deleteAll">Xóa</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </nav>
            </div>
            <div class="col-lg-11">
                <table class="table table-striped table-dark">
                    <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Name</th>
                        <th scope="col">Date Of Birth</th>
                        <th scope="col">ID Card</th>
                        <th scope="col">Salary</th>
                        <th scope="col">Phone</th>
                        <th scope="col">Email</th>
                        <th scope="col">Address</th>
                        <th scope="col">Position</th>
                        <th scope="col">Education Degree</th>
                        <th scope="col">Division</th>
                        <th scope="col">Username</th>
                        <th scope="col" colspan="2">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="employee" items="${listEmployee}">
                        <tr>
                            <td>${employee.id}</td>
                            <td>${employee.name}</td>
                            <td>${employee.dateOfBirth}</td>
                            <td>${employee.idCard}</td>
                            <td>${employee.salary}$</td>
                            <td>${employee.phone}</td>
                            <td>${employee.email}</td>
                            <td>${employee.address}</td>
                            <td>${employee.position.name}</td>
                            <td>${employee.educationDegree.name}</td>
                            <td>${employee.division.name}</td>
                            <td>${employee.user.userName}</td>
                            <td>
                                <a class="btn btn-primary" role="button"
                                   href="/employeeServlet?action=update&id=${employee.id}">Update</a>
                            </td>
                            <td class="text-dark">
                                <button type="button" class="btn btn-primary" data-toggle="modal"
                                        data-target="#exampleModal${employee.id}">
                                    Delete
                                </button>

                                <!-- Modal -->
                                <div class="modal fade" id="exampleModal${employee.id}" tabindex="-1"
                                     aria-labelledby="exampleModalLabel"
                                     aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="exampleModalLabel">Thông Báo</h5>
                                                <button type="button" class="close" data-dismiss="modal"
                                                        aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body">
                                                Bạn có chắc muốn xóa không?
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-secondary" data-dismiss="modal">
                                                    Close
                                                </button>
                                                <a class="btn btn-primary" role="button"
                                                   href="/employeeServlet?action=delete&id=${employee.id}">Delete</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
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
                        <a class="page-link" href="/employeeServlet?page=${page-1}&key=${key}">Previous</a>
                    </li>
                </c:if>
                <c:forEach var="i" begin="1" end="${numPage}">
                    <c:if test="${page != i}">
                        <li class="page-item"><a class="page-link" href="/employeeServlet?page=${i}&key=${key}">${i}</a></li>
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
                        <a class="page-link" href="/employeeServlet?page=${page+1}&key=${key}">Next</a>
                    </li>
                </c:if>
            </c:if>
            <c:if test="${size <= 5}">
                <li class="page-item disabled">
                    <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
                </li>
                <li class="page-item"><a class="page-link" href="/employeeServlet?page=1&key=${key}">1</a></li>
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