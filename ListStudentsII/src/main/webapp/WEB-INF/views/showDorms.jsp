<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<section class="py-5"></section>
	<section>
		<div class="container">
			<div class="col-lg-6 offset-lg-3">
				<h1 class="text-center">
					<c:out value="${dorm.name}" />
					Dormitory
				</h1>
				<form method="post" action="/api/dorms/${dorm.id}/add">
					<div class="form-group my-2">
						<select name="studentId">
							<c:forEach var="student" items="${studentwithout}">
								<option value="${student.id}">${student.firstName}
									${student.lastName}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group my-2">
						<input type="submit" value="Add">
					</div>
				</form>

				<table class="table table-hover table-striped text-center">
					<thead class="table-dark">
						<tr>
							<td>Name</td>
							<td>Action</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${dorm.students}" var="student">
							<tr>
								<td><c:out value="${student.firstName} ${student.lastName}" /></td>
								<td>
									<form action="/api/dorms/${dorm.id}/remove" method="POST">
										<input type="hidden" name="studentId" value="${student.id}" />
										<button type="submit">Eliminar</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</section>
</body>
</html>