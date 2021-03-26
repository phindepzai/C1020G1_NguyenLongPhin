<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 1/27/2021
  Time: 10:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Index</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="/userServlet">Binz</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <button type="button" class="btn btn-dark" data-toggle="modal" data-target="#exampleModal"
                        data-whatever="@mdo">Create new User
                </button>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/userServlet?action=sort">Sorting By Name</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0" action="/userServlet">
            <input type="hidden" name="action" value="search">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="country"
                   value="${country}">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>

<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel1" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="/userServlet" method="POST">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel1">New message</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="form-group">
                        <label for="inlineforminput">Name</label>
                        <input type="text" class="form-control" id="inlineFormInput" name="name">
                    </div>
                    <div class="form-group">
                        <label for="inputemail4">Email</label>
                        <input type="text" class="form-control" id="inputemail4" placeholder="abc@codegym.com"
                               name="email">
                    </div>
                    <div class="form-group">
                        <label for="inputAddress">Address</label>
                        <input type="text" class="form-control" id="inputAddress" placeholder="Việt Nam"
                               name="country">
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Create</button>
                </div>
            </form>
        </div>
    </div>
</div>
<div class="container-fluid">
    <div class="row">
        <div class="col-lg-12">
            <table class="table table-striped table-dark">
                <thead>
                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Country</th>
                    <th scope="col" colspan="2">Action</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${list}">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.email}</td>
                        <td>${user.country}</td>
                        <td>
                            <a class="btn btn-primary" role="button"
                               href="${pageContext.request.contextPath}/userServlet?action=update&id=${user.id}">update</a>
                        </td>
                        <td class="text-dark">
                            <button type="button" class="btn btn-primary" data-toggle="modal"
                                    data-target="#exampleModal${user.id}">
                                Delete
                            </button>

                            <!-- Modal -->
                            <div class="modal fade" id="exampleModal${user.id}" tabindex="-1"
                                 aria-labelledby="exampleModalLabel"
                                 aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Thông Báo</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            Are you sure about that?
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close
                                            </button>
                                            <a class="btn btn-primary" role="button"
                                               href="/userServlet?action=delete&id=${user.id}">Delete</a>
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
        <li class="page-item">
            <a class="page-link" href="/userServlet?page=${page-1}">Previous</a>
        </li>
        <c:if test="${size > 5}">
            <c:forEach var="i" begin="1" end="${((size - 1)/5)+1}">
                <li class="page-item"><a class="page-link" href="/userServlet?page=${i}">${i}</a></li>
            </c:forEach>
        </c:if>
        <c:if test="${size <= 5}">
            <li class="page-item"><a class="page-link" href="/userServlet?page=1}">1</a></li>
        </c:if>
        <li class="page-item">
            <a class="page-link" href="/userServlet?page=${page+1}">Next</a>
        </li>
    </ul>
</nav>
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
