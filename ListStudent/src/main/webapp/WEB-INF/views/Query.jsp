<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<!DOCTYPE html>
<html>
<head>
    <title>Student and Contact Data</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-4">
    <h1>all students</h1>
    <table class="table table-striped">
        <thead>
            <tr>
                <th>Name</th>
                <th>age</th>
                <th>address</th>
                <th>city</th>
                <th>state</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="row" items="${students}">                
                <tr>
                    <td>${row[0].name}</td>
                    <td>${row[1].firstName}</td>
                    <td>${row[1].lastName}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>

