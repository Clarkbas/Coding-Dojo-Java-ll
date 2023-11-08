<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Página de Registro</title>
    <!-- Agregar enlaces CSS de Bootstrap y tu archivo style.css -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="CSS/style.css">
</head>
<body class="fondo" >
    <div class="container mt-5">
        <h1 class="mb-4">¡Regístrate!</h1>
        
        <form:errors path="user.*" />
        
        <form:form method="POST" action="/registration" modelAttribute="user">
			<div class="Relleno">
			    <form:label path="email">Email:</form:label>
			    <form:input type="email" path="email" class="form-control" />
			</div>
            <div class="Relleno">
                <form:label path="firstName">Nombre:</form:label>
                <form:input path="firstName" class="form-control" />
            </div>
            <div class="Relleno">
                <form:label path="lastName">Apellido:</form:label>
                <form:input path="lastName" class="form-control" />
            </div>
            <div class="Relleno">
                <form:label path="password">Contraseña:</form:label>
                <form:password path="password" class="form-control" />
            </div>
            <div class="Relleno">
                <form:label path="passwordConfirmation">Confirmación de Contraseña:</form:label>
                <form:password path="passwordConfirmation" class="form-control" />
            </div>
            
			<button type="submit" class="btn btn-primary" style="margin: 10px;">¡Registrarse!</button>
        </form:form>
    </div>
    <!-- Agregar enlaces de scripts de Bootstrap al final del body -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
