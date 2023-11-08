<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Superadmin Panel</title>
    <!-- Enlace al CSS de Bootstrap -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="CSS/style.css">
</head>
<body class="fondo1">
    <div class="container mt-5">
        <h2>Panel de Superadministrador</h2>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Email</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.email}</td>
                        <td>
                            <c:if test="${!user.superAdmin}">
                                <form action="/deleteUser/${user.id}" method="POST">
                                    <button type="submit" class="btn btn-danger">Eliminar</button>
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

    <!-- Enlace al archivo JavaScript de Bootstrap (opcional) -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
