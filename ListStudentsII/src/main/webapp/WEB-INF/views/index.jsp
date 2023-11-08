<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Students</title>
</head>
<body>
	<h1>All Students</h1>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Age</th>
				<th>Address</th>
				<th>City</th>
				<th>State</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${contactInfo}" var="contact">
				<tr>
					<td>${contact.student.firstName}${contact.student.lastName}</td>
					<td>${contact.student.age}</td>
					<td>${contact.address}</td>
					<td>${contact.city}</td>
					<td>${contact.state}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>