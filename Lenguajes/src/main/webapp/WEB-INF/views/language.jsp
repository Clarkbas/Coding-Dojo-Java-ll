<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html lang="en">

<head>
    <title>Books</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
    <style>
        table button{
            background: none;
            border: 0px;
            color: var(--bs-link-color);
            text-decoration: underline;
        }
    </style>
</head>

<body>
    <header>
        <!-- place navbar here -->
    </header>
    <main>
        <h1>All Books</h1>
        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Creator</th>
                    <th>Version</th>
                    <th colspan="2">Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${languages}" var="language">
                    <tr>
                        <td>
                            <a href="languages/${language.id}"><c:out value="${language.name}"/></a>
                        </td>
                        <td>
                            <c:out value="${language.creator}" />
                        </td>
                        <td>
                            <c:out value="${language.currentVersion}" />
                        </td>
                        <td>
                            <form:form accept-charset="UTF-8" action="/languages/${language.id}/delete" method="post" modelAttribute="languages">
                                <input type="hidden" name="_method" value="delete">
                                <a href=""><button type="submit" style="background: none;">Delete</button></a>
                            </form:form>
                        </td>   
                        <td>
                            <a href="/languages/${language.id}/edit">Edit</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
<form:form accept-charset="UTF-8" action="/languages" method="post" modelAttribute="language">
    <p>
        <form:label path="name">Name</form:label>
        <form:errors path="name" />
        <form:input path="name" />
    </p>
    <p>
        <form:label path="creator">Creator</form:label>
        <form:errors path="creator" />
        <form:input path="creator" />
    </p>
    <p>
        <form:label path="currentVersion">Current Version</form:label>
        <form:errors path="currentVersion" />
        <form:input type="number" path="currentVersion" />
    </p>
    <button type="submit" value="Submit" >Enviar!</button>
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