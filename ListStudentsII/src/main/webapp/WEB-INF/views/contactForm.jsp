<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">

<head>
    <title>Contact Form</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

</head>

<body>
    <header>
        <h1>New Contact</h1>
    </header>
    <main>
        <form:form accept-charset="UTF-8" action="/api/contacts/create" method="post" modelAttribute="contact">
        	<p>
        		<label for="student">ID de la Persona:</label>
        		<select name="student" id="student">
            		<c:forEach items="${persons}" var="person">
                		<option value="${person.id}">${person.firstName} ${person.lastName}</option>
        		    </c:forEach>
		        </select><br>
        	</p>
            <p>
                <form:label path="address">Address: </form:label>
                <form:errors path="address" />
                <form:input path="address" />
            </p>
            <p>
                <form:label path="city">City; </form:label>
                <form:errors path="city" />
                <form:input path="city" />
            </p>
            <p>
            	<form:label path="state">State: </form:label>
                <form:errors path="state" />
                <form:input path="state" />
            </p>

            <input type="submit" value="Create" />
        </form:form>
    </main>
    <footer>
        <!-- place footer here -->
    </footer>
    <!-- Bootstrap JavaScript Libraries -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous">
        </script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
        integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz" crossorigin="anonymous">
        </script>
</body>

</html>