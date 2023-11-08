<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Person Details</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
    <h2>Person Details</h2>
    <p>First Name: ${person.firstName}</p>
    <p>Last Name: ${person.lastName}</p>
    <p>License State: ${license.state}</p>
    <p>Expiration Date: ${license.expiryDate}</p>
    <p>License Number: ${license.number}</p>
</body>
</html>
