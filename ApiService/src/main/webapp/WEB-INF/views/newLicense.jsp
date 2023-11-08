<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<html>
<head>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>

<h1>New License</h1>
<form:form accept-charset="UTF-8" action="/licenses/new" method="post" modelAttribute="license">
    <p>
     Person
       <select name="person" id="person">
       <c:forEach items="${persons}" var="person">
             <option value="${person.id}">${person.firstName} ${person.lastName}</option>
        </c:forEach>
	  </select>
    </p>
    <p>
        <form:label path="state">State</form:label>
        <form:errors path="state"/>
        <form:textarea path="state"/>
    </p>
      <p>
        <form:label path="expiryDate">Expiration Date</form:label>
        <form:errors path="expiryDate"/>
        <input type="date" id="expiryDate" name="expiryDate">
    </p>

    <input type="submit" value="Create"/>
</form:form>

</body>
</html>  