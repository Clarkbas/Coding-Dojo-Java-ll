<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Página de Inicio de Sesión</title>
    <!-- Agregar enlaces CSS de Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="CSS/style.css">
</head>
<body class="fondo">
    <div class="container mt-5">
        <h1 class="mb-4">Iniciar Sesión</h1>
        <p class="text-danger"><c:out value="${error}" /></p>
        <form method="post" action="/login">
            <div class="Relleno">
                <label for="email">Email</label>
                <input type="text" class="form-control" id="email" name="email"/>
            </div>
            <div class="Relleno">
                <label for="password">Password</label>
                <input type="password" class="form-control" id="password" name="password"/>
            </div>
            <button type="submit" class="btn btn-primary" style="margin: 10px;">Iniciar Sesión</button>
        </form>
    </div>
    <!-- Agregar enlaces de scripts de Bootstrap al final del body -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
