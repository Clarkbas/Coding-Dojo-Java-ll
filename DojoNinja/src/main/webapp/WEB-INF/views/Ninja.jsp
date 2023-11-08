<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

<html>
<head>
    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
	
	<link rel="stylesheet" href="/css/ninjastyle.css">
	
</head>

<body>
<h1>New Ninjas</h1>
<form action="/ninjas" method="post" modelAttribute="ninjas" accept-charset="UTF-8">

    <div style="width: 50%; text-align: left;">
        <label for="dojo">Dojo:</label>
    </div>
    <div style="width: 50%;">
        <select name="dojo" id="dojo" style="width: 100%;">
            <c:forEach items="${dojos}" var="dojo">
                <option value="${dojo.id}">${dojo.name}</option>
            </c:forEach>
        </select>
    </div>
    
	<label for="firstName">Nombre:</label>
	<input type="text" id="firstName" name="firstName" required></br>
    <label for="lastName">Apellido:</label>
    <input type="text" id="lastName" name="lastName" required></br>
    <label for="age">Edad:</label>
    <input type="number" id="age" name="age" required></br></br>
    <button type="submit">Crear Ninja</button>
</form>

</body>
</html>
