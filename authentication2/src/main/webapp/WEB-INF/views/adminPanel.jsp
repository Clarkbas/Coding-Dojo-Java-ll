<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Panel</title>
    <!-- Agregar enlaces CSS de Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="CSS/style.css">
</head>
<body class="fondo">
    <div class="container mt-5">
        <h2>Panel de Administración</h2>
        <table class="table">
            <thead class="thead-dark">
                <tr>
                    <th>ID</th>
                    <th>Email</th>
                    <th>Administrador</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.email}</td>
                        <td>${user.admin}</td>
                        <td>
                            <c:if test="${not user.admin}">
                                <form action="/deleteUser/${user.id}" method="POST">
                                    <button type="submit" class="btn btn-danger">Eliminar</button>
                                </form>
                            </c:if>
                        </td>
                        <td>
                            <c:if test="${not user.admin}">
                                <form action="/promoteUser/${user.id}" method="POST">
                                    <button type="submit" class="btn btn-success">Otorgar Admin</button>
                                </form>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
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
