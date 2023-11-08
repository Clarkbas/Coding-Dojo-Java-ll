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
    <title></title>
    <style>
        body {
            background: #C9D6FF;
            background: -webkit-linear-gradient(to right, #E2E2E2, #C9D6FF);
            background: linear-gradient(to right, #E2E2E2, #C9D6FF);
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="tituloShow">Welcome, ${user.name}!</h1>
        <h2>TV Shows</h2>
        <table class="table table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th>Show</th>
                    <th>Network</th>
                    <th>Avg Rating</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${shows}" var="show" varStatus="loop">
                    <tr>
                        <td><a href="/shows/${show.id}"><c:out value="${show.name}" /></a></td>
                        <td><c:out value="${show.network}" /></td>
                        <td><c:out value="${promedios[loop.index]}" /></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <div class="">
            <form action="/shows/new" method="GET">
                <input type="submit" value="Add a Show" class="btn btn-primary">
            </form>
            <br>
           	<form action="/" method="GET">
                <input type="submit" value="Home" class="btn btn-success">
            </form>
       
        </div>
    </div>
</body>
</html>
