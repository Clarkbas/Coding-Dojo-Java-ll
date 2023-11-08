<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<html>
<head>
    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    
    <link rel="stylesheet" href="/css/dojostyle.css">
    
</head>

<body>

<h1>New Dojo</h1>

<form action="/dojos" method="post" accept-charset="UTF-8">
    <label for="name">Nombre del Dojo:</label>
    <input type="text" id="name" name="name" required></br></br>
    <button type="submit">Crear Dojo</button>
</form>


</body>
</html>  