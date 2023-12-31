<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="css/dashBoardStyle.css">
	<title>Dashboard</title>
</head>
<body class="bg-secondary">
		<nav class="navbar navbar-dark bg-light pt-0 pb-0">
                        <div class="right_align_nav">
                        </div>
        </nav>
        <div class="pl-1 mt-2">
        	<a href="/songs/new"><button type="button" class="btn btn-outline" style="color: orange; background:black; border: solid 2px orange;">Crear nuevo recordatorio</button></a>
        </div>
        <div class="container">
        
        	<c:forEach items="${songs}" var="song">
			  <thead class="table" style="background: black; color:orange;">
			  	
				    <ul>
				         <li>
		                    <a>
		                        <p><c:out value="${song.name}"/></p>
		                        <p><c:out value="${song.description}"/></p>
		                        <p><c:out value="${song.startDate}"/></p>
		                        <p><form action="/dashboard/<c:out value="${song.id}"/>" method="post" class="d-inline-block"><input type="hidden" name="_method" value="delete"><input type="submit" class="btn btn-outline-dark" style="color: black; background:none; border: solid 2px purple;" value="Delete"></form ></p>
		                    </a>
                		</li>
				    </ul>
				</c:forEach>
			 </thead>

        </div>
        
        


	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>