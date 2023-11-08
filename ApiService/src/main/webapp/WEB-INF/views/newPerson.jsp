
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  


<html>
<head>
<link rel="stylesheet" href="/css/style.css">
</head>

<body>
<h1>New Person</h1>
<form:form accept-charset="UTF-8" action="/persons/new" method="post" modelAttribute="person">
    <p>
        <form:label path="firstName">First Name</form:label>
        <form:errors path="firstName"/>
        <form:input path="firstName"/>
    </p>
    <p>
        <form:label path="lastName">Last Name</form:label>
        <form:errors path="lastName"/>
        <form:textarea path="lastName"/>
    </p>

    <input type="submit" value="Create"/>
</form:form> 
</body>
</html>   