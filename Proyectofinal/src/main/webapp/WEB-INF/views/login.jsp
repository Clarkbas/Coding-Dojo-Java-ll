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
<body style="background: #000046;  /* fallback for old browsers */
                background: -webkit-linear-gradient(to right, #1CB5E0, #000046);  /* Chrome 10-25, Safari 5.1-6 */
                background: linear-gradient(to right, #1CB5E0, #000046); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
                ">
	<div class="container text-center border-bottom border-dark">
		<h1 class="h1"><small>Welcome to Event Manager!</small></h1>
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
				<h2 class="h2 border-bottom border-info text-center"><small>Register</small></h2>
				
				<form:form action="/register" method="POST" modelAttribute="index">
				
					<p>
						<form:label path="firstName" cssClass="h4 text-dark font-weight-normal">First Name</form:label>
						<form:input path="firstName" cssClass="form-control border border-secondary col-8"/>
					</p>
					<p>
						<form:label path="lastName" cssClass="h4 text-dark font-weight-normal">Last Name</form:label>
						<form:input path="lastName" cssClass="form-control border border-secondary col-8"/>
					</p>
					<p>
						<form:label path="email" cssClass="h4 text-dark font-weight-normal">E-Mail</form:label>
						<form:input path="email" cssClass="form-control border border-secondary col-8"/>
					</p>
					<p>
						<form:label path="city" cssClass="h4 text-dark font-weight-normal">City</form:label>
						<form:input path="city" cssClass="form-control border border-secondary col-8"/>
					</p>
					<p>
						<form:label path="state" cssClass="h4 text-dark font-weight-normal d-block">State</form:label>
						<form:select cssClass="custom-select col-6 border border-secondary" path="state">
							<form:option value="AL">Alabama (AL)</form:option>
							<form:option value="AK">Alaska (AK)</form:option>
							<form:option value="AZ">Arizona (AZ)</form:option>
							<form:option value="AR">Arkansas (AR)</form:option>
							<form:option value="CA">California (CA)</form:option>
							<form:option value="CO">Colorado (CO)</form:option>
							<form:option value="CT">Connecticut (CT)</form:option>
							<form:option value="DE">Delaware (DE)</form:option>
							<form:option value="DC">District Of Columbia (DC)</form:option>
							<form:option value="FL">Florida (FL)</form:option>
							<form:option value="GA">Georgia (GA)</form:option>
							<form:option value="HI">Hawaii (HI)</form:option>
							<form:option value="ID">Idaho (ID)</form:option>
							<form:option value="IL">Illinois (IL)</form:option>
							<form:option value="IN">Indiana (IN)</form:option>
							<form:option value="IA">Iowa (IA)</form:option>
							<form:option value="KS">Kansas (KS)</form:option>
							<form:option value="KY">Kentucky (KY)</form:option>
							<form:option value="LA">Louisiana (LA)</form:option>
							<form:option value="ME">Maine (ME)</form:option>
							<form:option value="MD">Maryland (MD)</form:option>
							<form:option value="MA">Massachusetts (MA)</form:option>
							<form:option value="MI">Michigan (MI)</form:option>
							<form:option value="MN">Minnesota (MN)</form:option>
							<form:option value="MS">Mississippi (MS)</form:option>
							<form:option value="MO">Missouri (MO)</form:option>
							<form:option value="MT">Montana (MT)</form:option>
							<form:option value="NE">Nebraska (NE)</form:option>
							<form:option value="NV">Nevada (NV)</form:option>
							<form:option value="NH">New Hampshire (NH)</form:option>
							<form:option value="NJ">New Jersey (NJ)</form:option>
							<form:option value="NM">New Mexico (NM)</form:option>
							<form:option value="NY">New York (NY)</form:option>
							<form:option value="NC">North Carolina (NC)</form:option>
							<form:option value="ND">North Dakota (ND)</form:option>
							<form:option value="OH">Ohio (OH)</form:option>
							<form:option value="OK">Oklahoma (OK)</form:option>
							<form:option value="OR">Oregon (OR)</form:option>
							<form:option value="PA">Pennsylvania (PA)</form:option>
							<form:option value="RI">Rhode Island (RI)</form:option>
							<form:option value="SC">South Carolina (SC)</form:option>
							<form:option value="SD">South Dakota (SD)</form:option>
							<form:option value="TN">Tennessee (TN)</form:option>
							<form:option value="TX">Texas (TX)</form:option>
							<form:option value="UT">Utah (UT)</form:option>
							<form:option value="VT">Vermont(VT)</form:option>
							<form:option value="VA">Virginia(VA)</form:option>
							<form:option value="WA">Washington(WA)</form:option>
							<form:option value="WV">West Virginia(WV)</form:option>
							<form:option value="WI">Wisconsin(WI)</form:option>
							<form:option value="WY">Wyoming(WY)</form:option>
						</form:select>
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
					<div class="text-right">
						<Button type="submit" class="btn btn-info">Register</Button>
					</div>
					
					
					
				</form:form>
			</div>
			<div class="col">
				<h2 class="h2 border-bottom border-info text-center"><small>Login</small></h2>
				<form method="POST" action="/Login">
					<p>
						<label class="h4 text-dark font-weight-normal">Email</label>
						<input class="h4 text-dark font-weight-normal form-control border border-secondary col-8" type="text" name="email">
					</p>
					<p>
						<label class="h4 text-dark font-weight-normal">Password</label>
						<input class="h4 text-dark font-weight-normal form-control border border-secondary col-8" type="password" name="password">
					</p>
					<div class="text-right">
						<Button type="submit" class="btn btn-info">Login</Button>
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


<!-- 
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>

<body>
    <div class="form-container">
        <h3>Iniciar sesión</h3>
        <form method="post" action="/login">
            <p>
                <label for="email">Email</label>
                <input type="text" id="email" name="email" />
            </p>
            <p>
                <label for="password">Contraseña</label>
                <input type="password" id="password" name="password" />
            </p>
            <input type="submit" value="Iniciar sesión" />
        </form>
        <p class="error-message">
            <c:out value="${error}" />
        </p>
    </div>

</body>

</html>
-->