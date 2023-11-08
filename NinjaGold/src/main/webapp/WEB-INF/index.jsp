<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="en">

<head>
    <title>Ninja Gold Game</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="css/style.css">
    
    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
        <link href="https://fonts.googleapis.com/css2?family=Balsamiq+Sans&display=swap" rel="stylesheet">
    <style>
        footer {
        	font-family: 'Balsamiq Sans', cursive;
            display: flex;
            justify-content: center;
            flex-direction: column;
            flex-wrap: nowrap;
            align-items: center;
        }

        .scrollable-list {
            max-height: 300px;
            overflow-y: auto;
        }

        .scrollable-list li {
            margin-bottom: 10px;
        }
    </style>
</head>

<body>
    <header>
        <div class="row">
            <div class="col-2">
                <h2 class= "Titulo">Your Gold: </h2>
            </div>
            <div class="col-1">
                <h2 class="gold">
                <c:choose>
                    <c:when test="${empty oro}">0</c:when>
                    <c:otherwise>${oro}</c:otherwise>
                </c:choose>
            </h2>
            </div>
        </div>
    </header>
    <main>
        <div class="row">
            <form action="/actividades" method="POST">
                <div class="card-group">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">Farm</h4>
                            <p class="card-text">(earns 10-20 gold)</p>
                            <button type="submit" name="lugar" value="farm" class="btn btn-primary">Find Gold!</button>
                        </div>
                    </div>
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">Cave</h4>
                            <p class="card-text">(earns 5-10 gold)</p>
                            <button type="submit" name="lugar" value="cave" class="btn btn-primary">Find Gold!</button>
                        </div>
                    </div>
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">House</h4>
                            <p class="card-text">(earns 2-5 gold)</p>
                            <button type="submit" name="lugar" value="house" class="btn btn-primary">Find Gold!</button>
                        </div>
                    </div>
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">Casino!</h4>
                            <p class="card-text">(earns 0-50 gold)</p>
                            <button type="submit" name="lugar" value="casino" class="btn btn-primary">Find
                                Gold!</button>
                        </div>
                    </div>
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">Spa</h4>
                            <p class="card-text">(lose 20-5 gold)</p>
                            <button type="submit" name="lugar" value="spa" class="btn btn-primary">Find
                                Gold!</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </main>
    <footer>
        <div class="row">
            <h3>Registro de Actividades</h3>
        </div>
        <div class="row">
            <div class="scrollable-list">
                <ul>
                    <c:forEach var="registro" items="${registros}">
                        <li>
                            <c:choose>
                                <c:when test="${registro.oro > 0}">
                                    <span style="color: green">You entered a ${registro.lugar} and earned ${registro.oro} gold. (${registro.getTiempoFormatted()})</span>
                                </c:when>
                                <c:otherwise>
                                    <span style="color: red">You entered a ${registro.lugar} and earned ${registro.oro} gold. (${registro.getTiempoFormatted()})</span>
                                </c:otherwise>
                            </c:choose>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>   
        <div class="row">
            <form action="/reset" method="post">
                <button type="submit">Reset</button>
            </form>
        </div>

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