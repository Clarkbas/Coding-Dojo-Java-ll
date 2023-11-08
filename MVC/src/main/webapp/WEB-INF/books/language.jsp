<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Language Details</title>
</head>
<body>
    <h1>Language Details</h1>
    <p>${language.name}</p>

    <a href="/languages/${language.id}/edit">Edit</a> |
    <a href="/languages/${language.id}" onclick="return confirm('Are you sure you want to delete this language?')">Delete</a>

    <a href="/languages">Back to List</a>
</body>
</html>
