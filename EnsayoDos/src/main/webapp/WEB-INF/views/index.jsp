<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="assets/css/style.css">
    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<title>Login Register</title>
</head>
<body style="background: #C9D6FF;  /* fallback for old browsers */
background: -webkit-linear-gradient(to right, #E2E2E2, #C9D6FF);  /* Chrome 10-25, Safari 5.1-6 */
background: linear-gradient(to right, #E2E2E2, #C9D6FF); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
">
	<div class="container text-center border-bottom border-dark">
		<h1 class="h1"><small>Bienvenido a TVDB!</small></h1>
	</div>
	<br>
	<div class=container>
		<form:errors path="index.*" element="p" cssClass="alert alert-danger"/>
		<c:out value="${success}" escapeXml="false"/>
		<c:out value="${error}" escapeXml="false"/>
	</div>
	<br>
	<div class="container">
		<div class="row">
			<div class="col">
				<h2 class="h2 border-bottom border-info text-center"><small>Registrate</small></h2>
				
				<form:form action="/register" method="POST" modelAttribute="index">
				
					<p>
						<form:label path="Nombre" cssClass="h4 text-dark font-weight-normal">Nombre</form:label>
						<form:input path="Nombre" cssClass="form-control border border-secondary col-8"/>
					</p>
					<p>
						<form:label path="email" cssClass="h4 text-dark font-weight-normal">E-Mail</form:label>
						<form:input path="email" cssClass="form-control border border-secondary col-8"/>
					</p>
					<p>
						<form:label path="password" cssClass="h4 text-dark font-weight-normal">Password</form:label>
						<form:input path="password" type="password" cssClass="form-control border border-secondary col-8"/>
					</p>
					<p>
						<form:label path="passwordConfirmation" cssClass="h4 text-dark font-weight-normal">Confirm Password</form:label>
						<form:input path="passwordConfirmation" type="password" cssClass="form-control border border-secondary col-8"/>
					</p>
					<br>
					<div class="">
						<Button type="submit" class="btn btn-info">Registrate</Button>
					</div>
					
					
					
				</form:form>
			</div>
			<div class="col">
				<h2 class="h2 border-bottom border-info text-center"><small>Iniciar sesion</small></h2>
				<form method="POST" action="/Login">
					<p>
						<label class="h4 text-dark font-weight-normal">Email</label>
						<input class="h4 text-dark font-weight-normal form-control border border-secondary col-8" type="text" name="email">
					</p>
					<p>
						<label class="h4 text-dark font-weight-normal">Password</label>
						<input class="h4 text-dark font-weight-normal form-control border border-secondary col-8" type="password" name="password">
					</p>
					<div class="">
						<Button type="submit" class="btn btn-info">Iniciar sesion</Button>
					</div>
				</form>
			</div>
			
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</body>
</html>