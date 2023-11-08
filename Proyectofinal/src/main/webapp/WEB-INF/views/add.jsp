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
    <style>
        /* Definimos una clase personalizada para el color de fondo naranja (orange) */
        .bg-orange {
            background-color: orange;
        }

        /* Cambiamos el color del texto a negro */
        .text-dark {
            color: black;
        }
    </style>
    <title>Add a Song</title>
</head>
<body class="bg-orange"> 
    <nav class="navbar navbar-dark bg-light pt-0 pb-0">
    </nav>
    <div class="pr-2 mt-2 mb-5 text-right">
        <a href="/dashboard">
            
            <button type="button" class="btn btn-outline ml-auto text-dark" style="color: orange; background:beige; border: solid 2px orange;">Dashboard</button>
        </a>
    </div>
    <div class="container mt-5">
        <form:form action="/songs/new" method="post" modelAttribute="music">
            <p><form:errors path="name" class="alert alert-danger"/></p>
            
            <p>
                
                <form:label cssClass="h4 text-dark" path="name">Titulo: </form:label>
                <form:input cssClass="form-control d-inline-block col-4" path="name"/>
            </p>
            
            <p><form:errors path="description" class="alert alert-danger"/></p>
            <p>
                <!-- Cambiamos el color del texto a negro -->
                <form:label cssClass="h4 text-dark" path="description">description: </form:label>
                <form:input cssClass="form-control d-inline-block col-4" path="description"/>
            </p>
            
            <p><form:errors path="startDate" class="alert alert-danger"/></p>
		      <p>
		        <form:label cssClass="h4 text-dark"  path="startDate">Fecha</form:label>
		        <form:errors path="startDate"/>
		        <input type="date" id="startDate" name="startDate">
		    </p>
            
            
            <input class="btn btn-outline-dark text-dark" style="color: orange; background:beige; border: solid 2px orange;" type="submit" value="Submit"/>
        </form:form>
    </div>


    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>
