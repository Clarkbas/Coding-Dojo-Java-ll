<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detalles del Usuario</title>
    <!-- Agregar enlaces CSS de Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="CSS/style.css">
</head>
<body class="bg-light">
    <div class="container mt-5">
        <h2>Detalles del Usuario</h2>
        <p><strong>Correo electrónico:</strong> ${user.email}</p>
        <p><strong>Nombre:</strong> ${user.firstName}</p>
        <p><strong>Apellido:</strong> ${user.lastName}</p>
        <p><strong>Fecha de registro:</strong> ${user.createdAt}</p>
        <p><strong>Último inicio de sesión:</strong> ${user.lastSignIn}</p>
    </div>
    <div class="container mt-4">
    	<a href="/login" class="btn btn-primary">Ir a la página de inicio de sesión</a>
	</div>
    
    <!-- Agregar enlaces de scripts de Bootstrap al final del body -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
