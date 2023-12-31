<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="assets/css/.css">
    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<title>Add Category</title>
</head>
<body class="pl-4">
	<h3 class="display-3"><small><u>New Category</u></small></h3>
	<br>
	<form:form action="/categories/new" method="POST" modelAttribute="category">
	
		<p><form:errors path="name" cssClass="alert alert-danger"/></p>
		<p><form:label cssClass="h4 font-weight-normal" path="name">Name</form:label></p>
		<p> <form:input cssClass="form-control col-4" path="name" /> </p>
		
		<!-- Se agrega el código para mostrar el mensaje de error -->
        <c:if test="${not empty categoryAlreadyExistsError}">
            <p style="color: red;">${categoryAlreadyExistsError}</p>
        </c:if>
		<br>
		<button type="submit" class="btn btn-info">Add Category</button>
		
	</form:form>
	

		<!--  enlace a bibliotecas de JavaScript necesarias para que la página funcione correctamente.  -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</body>
</html>