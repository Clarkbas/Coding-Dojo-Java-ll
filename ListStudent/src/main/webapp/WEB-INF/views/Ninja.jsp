<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

    <link rel="stylesheet" href="/css/ninjastyle.css">

    <title>New Ninjas</title>
</head>

<body class="container py-5">
    <h1 class="mb-4">New Ninjas</h1>
    <form action="/contacts/show" method="post" modelAttribute="contacts" accept-charset="UTF-8">
        <div class="row mb-3">
            <label for="student" class="col-sm-2 col-form-label">Student:</label>
            <div class="col-sm-10">
				<c:forEach items="${students}" var="student">
				    <p>First Name: ${student.firstName}</p>
				    <p>Last Name: ${student.lastName}</p>
				    <p>Age: ${student.age}</p>
				    <hr>
				</c:forEach>
                </select>
            </div>
        </div>

        <div class="mb-3">
            <label for="address" class="form-label">Address:</label>
            <input type="text" id="address" name="address" required class="form-control">
        </div>
        <div class="mb-3">
            <label for="City" class="form-label">City:</label>
            <input type="text" id="City" name="City" required class="form-control">
        </div>
        <div class="mb-3">
            <label for="State" class="form-label">State:</label>
            <input type="text" id="State" name="State" required class="form-control">
        </div>
        <button type="submit" class="btn btn-primary">Create</button>
    </form>

    <!-- Bootstrap JS and Popper.js (required for Bootstrap features) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-Fw2Ts8a9fkcV7g1h/6n5nkzL3A2Qp9zM/TxNvhpvzMpaD0Fc2YZ9OQn5ku1zRftw"
        crossorigin="anonymous"></script>
</body>

</html>
