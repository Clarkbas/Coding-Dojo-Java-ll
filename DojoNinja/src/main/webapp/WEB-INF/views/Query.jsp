<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<table class="table">
    <thead>
        <th>Dojo Name</th>
        <th>Ninja First Name</th>
        <th>Ninja Last Name</th>
    </thead>
    <tbody>
        <c:forEach var="row" items="${table}">                
        <tr>
            <td>${row[0].name}</td>
            <td>${row[1].firstName}</td>
            <td>${row[1].lastName}</td>
        </tr>
        </c:forEach>
    </tbody>
</table>
