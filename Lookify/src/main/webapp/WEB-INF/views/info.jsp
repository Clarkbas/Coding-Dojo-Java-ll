<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="assets/css/.css">
    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<title>Info</title>
</head>
<body class="bg-secondary">
		<nav class="navbar navbar-dark bg-light pt-0 pb-0">
                        <a class="navbar-brand" href="#">
                                <img src="/images/lookify.png" width="100" height="52" class="d-inline-block align-top " alt="">
                        </a>
                        <div class="right_align_nav">
                        </div>
       </nav>
       
       <div class="pr-2 mt-2 mb-5 text-right">
        	<a href="/dashboard"><button type="button" class="btn btn-outline ml-auto" style="color: orange; background:black; border: solid 2px orange;">Dashboard</button></a>
		</div>
		
		<div class="container">
			<h1 class="text-warning"><u>Song Info</u></h1>
			<br>
			
			<h3 style="color:purple;">Song Name: <c:out value="${song.name}"/></h3>
			<h3 style="color:purple;">Artist: <c:out value="${song.artist}"/></h3>
			<h3 style="color:purple;">Rating (1-10): <c:out value="${song.rating}"/></h3>
			<br>
			<form action="/dashboard/<c:out value="${song.id}"/>" method="post" class="d-inline-block"><input type="hidden" name="_method" value="delete"><input type="submit" class="btn btn-outline-dark" style="color: orange; background:purple; border: solid 2px orange;" value="Delete"></form >
		</div>
     

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
  </body>
</body>
</html>