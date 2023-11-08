<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="/style/estrellas.css">
</head>

<body style="background: #C9D6FF;  /* fallback for old browsers */
            background: -webkit-linear-gradient(to right, #E2E2E2, #C9D6FF);  /* Chrome 10-25, Safari 5.1-6 */
            background: linear-gradient(to right, #E2E2E2, #C9D6FF); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
            ">

    <div class="container mt-5">
        <h1 class="tituloShow">
            <c:out value="${show.name}" />
        </h1>
        <p>
            Network:
            <c:out value="${show.network}" />
        </p>
        <h2> Users who rated this show </h2>
        <table class="table table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th>Name</th>
                    <th>Rating</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${ratings}" var="notas">
                    <tr>
                        <td><c:out value="${notas[0]}" /></td>
                        <td><c:out value="${notas[1]}" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <form action="/shows/${show.id}/edit" method="GET">
            <input type="submit" value="Edit" class="btn btn-primary">
        </form>
        <hr>
        <c:choose>
            <c:when test="${show.usersJoin.contains(user)}">
                <p>Rated</p>
            </c:when>
            <c:otherwise>
                <form action="/shows/${show.id}/rate" method="post">
                    <h2 class="d-inline-block">Leave a Rating:</h2>
                    <input type="number" step="0.1" min="1" max="5" name="rating" required class="ml-2">
                    <button type="submit" class="btn btn-primary ml-2">Rate!</button>
  
                </form>
                <br>
	           	<form action="/shows" method="GET">
	                <input type="submit" value="Back" class="btn btn-success">
	            </form>
            </c:otherwise>
        </c:choose>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
