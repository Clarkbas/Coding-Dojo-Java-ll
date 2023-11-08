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
    <title>Create a new show</title>
</head>
<body style="background: #C9D6FF;  /* fallback for old browsers */
            background: -webkit-linear-gradient(to right, #E2E2E2, #C9D6FF);  /* Chrome 10-25, Safari 5.1-6 */
            background: linear-gradient(to right, #E2E2E2, #C9D6FF); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
            ">
    <div class="container mt-5">
        <h1>Create a new show</h1>
        <form:form accept-charset="UTF-8" action="/shows/new" method="post" modelAttribute="show">
            <div class="form-group">
                <form:label path="name">Title:</form:label>
                <form:input path="name" class="form-control col-md-6" />
                <form:errors path="name" />
                <c:if test="${not empty showExistsError}">
                    <p>${showExistsError}</p>
                </c:if>
            </div>
            <div class="form-group">
                <form:label path="network">Network:</form:label>
                <form:input path="network" class="form-control col-md-6" />
                <form:errors path="network" />
            </div>
            <input type="hidden" id="user" name="user" value="${userId}" />
            <button type="submit" class="btn btn-secondary">Create</button>
        </form:form>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
