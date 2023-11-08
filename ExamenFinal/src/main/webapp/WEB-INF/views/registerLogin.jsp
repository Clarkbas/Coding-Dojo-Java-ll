<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="style/style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<title>Login Register</title>
<title></title>
</head>
<body style="background: #C9D6FF;  /* fallback for old browsers */
			background: -webkit-linear-gradient(to right, #E2E2E2, #C9D6FF);  /* Chrome 10-25, Safari 5.1-6 */
			background: linear-gradient(to right, #E2E2E2, #C9D6FF); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
			">

	<div class=container>
		<form:errors path="index.*" element="p" cssClass="alert alert-danger"/>
		<c:out value="${success}" escapeXml="false"/>
	</div>
	<br>
	<div class="container">
		<div class="row">
			<div class="col">
				<h2 class="h2 border-bottom border-info text-center"><small>Registrate</small></h2>
				
		<form:form accept-charset="UTF-8" action="/registration" method="post" modelAttribute="user">

			<p>
				<form:label path="name" cssClass="h4 text-dark font-weight-normal">Name</form:label>
				<form:input path="name" cssClass="form-control border border-secondary col-8"/>
				<form:errors path="name" />
			</p>
			<p>
				<form:label path="email" cssClass="h4 text-dark font-weight-normal">E-Mail</form:label>
				<form:input path="email" cssClass="form-control border border-secondary col-8"/>
				<form:errors path="email" />
			</p>
			<p>
				<form:label path="password" cssClass="h4 text-dark font-weight-normal">Password</form:label>
				<form:input path="password" type="password" cssClass="form-control border border-secondary col-8"/>
				<form:errors path="password" />
			</p>
			<p>
				<form:label path="passwordConfirmation" cssClass="h4 text-dark font-weight-normal">Confirm Password</form:label>
				<form:input path="passwordConfirmation" type="password" cssClass="form-control border border-secondary col-8"/>
				<form:errors path="passwordConfirmation" />
			</p>
			
			<br>
			<button class="ui-btn">
			  <span>
			    Register! 
			  </span>
			</button>
		</form:form>
	</div>
        <div class="col-md-6">
            <div class="loginForm">
                <h2 class="h2 border-bottom border-info text-center"><small>Iniciar sesión</small></h2>
		<form method="post" action="/login">
			<p>
				<label class="h4 text-dark font-weight-normal">Email</label>
				<input class="h4 text-dark font-weight-normal form-control border border-secondary col-8" type="text" name="email">
			</p>
			<p>
				<label class="h4 text-dark font-weight-normal">Password</label>
				<input class="h4 text-dark font-weight-normal form-control border border-secondary col-8" type="password" name="password">
			</p>
			<div class="">
			</div>
			<button class="ui-btn">
			  <span>
			    Login
			  </span>
			</button>
			<c:out value="${errors}" escapeXml="false"/>
			
		</form>

	</div>
</body>
</html>