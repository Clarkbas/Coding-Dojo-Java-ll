<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Dormitory</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

	<section class="py-5"></section>
	<section>
		<div class="container">
			<div class="col-lg-6 offset-lg-3">
				<h1 class="text-center">Dormitories</h1>
				<form:form accept-charset="UTF-8" action="/api/dorms/create" method="post" modelAttribute="dormitory" class="col">
					<p>
                		<form:label path="name">name: </form:label>
                		<form:errors path="name" />
                		<form:input path="name" />
		            </p>

					<div class="text-center">
						<input class="btn btn-primary text-center my-2" type="submit"
							value="Submit" />
					</div>
				</form:form>
			</div>
		</div>
	</section>
</body>
</html>