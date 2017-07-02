<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<html>
<head>
    <title>Formulário</title>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand">Cartórios</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href=http://localhost:8080/cartorio>Lista</a></li>
            <li class="active"><a href=http://localhost:8080/cartorio/form>Formulário</a></li>
        </ul>
    </div>
</nav>
<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <form:form  class="form-horizontal" action="${s:mvcUrl('CC#gravar').build()}" method="POST" modelAttribute="cartorio">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="nome">Nome:</label>
                        <div class="col-sm-4">
                            <input type="text" name="nome" class="form-control" id="nome" placeholder="Digite o nome">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10 btn-group">
                            <button type="submit" class="btn btn-success">Cadastrar</button>
                            <button type="button" class="btn btn-danger">Excluir</button>
                            <button type="button" class="btn btn-warning">Alterar</button>
                            <button type="button" class="btn btn-info">Visualizar</button>
                        </div>
                    </div>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>