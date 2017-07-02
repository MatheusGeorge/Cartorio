<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<html>
<head>
    <title>Lista Cartorios</title>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand">Cartórios</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href=http://localhost:8080/cartorio>Lista</a></li>
            <li><a href=http://localhost:8080/cartorio/form>Formulário</a></li>
        </ul>
    </div>
</nav>
    <div class="container">
        <div class="row">
            <div class="page-header">
                <h1>Lista de cartórios</h1>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-12">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nome</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${cartorios}" var="cartorio">
                        <tr>
                            <td>${cartorio.id}</td>
                            <td>${cartorio.nome}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

    </div>
</body>
</html>
