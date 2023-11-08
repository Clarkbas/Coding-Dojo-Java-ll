<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <p>You have visited a<a href=""> http://your_server</a></p>
    <p><c:out value="${count}"/> times</p>
    <a href="http://localhost:8080/your_server">Test another visit</a>
</body>
</html>