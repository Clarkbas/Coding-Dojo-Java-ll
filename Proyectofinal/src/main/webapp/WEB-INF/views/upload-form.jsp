<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tareas</title>
    <!-- Agregar el enlace a Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/boton-celda-check.css">
    <script type="text/javascript" src="https://cdn.jsdelivr.net/jquery/latest/jquery.min.js"></script>
	<script type="text/javascript" src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
	<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.min.js"></script>
	<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/daterangepicker/daterangepicker.css" />
</head>
<body>
    <h1>Entrega de Tareas</h1>
    <h2 id="subject-name"></h2>

    <form id="sendForm" action="/upload" method="POST" enctype="multipart/form-data">
        <table border="1px" height="150px" style="border-collapse:collapse; text-align:center;">
            <thead>
                <tr>
                    <th>Profesor</th>
                    <th>Asignatura</th>
                    <th>Nombre de la Tarea</th>
                    <th>Fecha de Entrega</th>
                    <th>Descargar Tarea</th>
                    <th>Enviar Tarea</th>
                    <th>Recibido y Revisado</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td >
                        <input type="text" id="professor" name="professor" disabled>
                    </td>
                    <td>
                        <select name="subject" id="subject" onchange="updateProfessorName(this.value)">
                            <option value="Artes Visuales" data-professor="Manuel Jeldes">Artes Visuales</option>
                            <option value="Ciencias Naturales" data-professor="Molly">Ciencias Naturales</option>
                            <option value="Filosofía" data-professor="Mariana Contreras">Filosofía</option>
                            <option value="Historia y Geografía" data-professor="Felipe Zamorano">Historia y Geografía</option>
                            <option value="Inglés" data-professor="Catalina Diaz">Inglés</option>
                            <option value="Lenguaje y Comunicación" data-professor="Nestor Llancapan">Lenguaje y Comunicación</option>
                            <option value="Matemáticas" data-professor="Carlos Prieto">Matemáticas</option>
                        </select>
                    </td>
                    <td>
                        <select name="task" id="task">
                            <option value="Tarea 1">Tarea 1</option>
                            <option value="Tarea 2">Tarea 2</option>
                            <option value="Tarea 3">Tarea 3</option>
                            <option value="Tarea 4">Tarea 4</option>
                        </select>
                    </td>
                    <td>
                        <input type="text" name="birthday" value="10/24/2023" />
                    </td>
                    <td>
						<a href="#" class="btn btn-primary btn-sm">Descargar ¡AQUI!</a>
                    </td>
                    <td>
                        <input type="file" name="file" id="file" onchange="this.form.submit()">
                        <button type="submit" class="btn btn-primary">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-send" viewBox="0 0 16 16">
                                <path d="M15.854.146a.5.5 0 0 1 .11.54l-5.819 14.547a.75.75 0 0 1-1.329.124l-3.178-4.995L.643 7.184a.75.75 0 0 1 .124-1.33L15.314.037a.5.5 0 0 1 .54.11ZM6.636 10.07l2.761 4.338L14.13 2.576 6.636 10.07Zm6.787-8.201L1.591 6.602l4.339 2.76 7.494-7.493Z"/>
                            </svg> Enviar Tarea
                        </button>
                        <c:if test="${not empty tareaEnviadaExitosamente}">
                            <p>${tareaEnviadaExitosamente ? 'La tarea ya fue entregada' : 'La tarea no ha sido entregada'}</p>
                        </c:if>
                    </td>
                    <td>
                        <label class="checkbox-wrapper">
                            <input checked="" type="checkbox" id="check" hidden="">
                            <label for="check" class="checkmark"></label>
                        </label>
                    </td>
                </tr>
            </tbody>
        </table>
    </form>

    <script>
        document.getElementById('subject').addEventListener('change', function () {
            var subjectName = this.value;
            var subjectDiv = document.getElementById('subject-name');
            subjectDiv.innerHTML = "<h2>" + subjectName + "</h2>";
        });
        
        function updateProfessorName() {
            var subjectSelect = document.getElementById('subject');
            var professorInput = document.getElementById('professor');
            
            var selectedOption = subjectSelect.options[subjectSelect.selectedIndex];
            var professorName = selectedOption.getAttribute('data-professor');

            professorInput.value = professorName;
        }
        
        <!-- 	SCRIPT DE LA FECHA  -->
        
        $(function() {
        	  $('input[name="birthday"]').daterangepicker({
        	    singleDatePicker: true,
        	    showDropdowns: true,
        	    minYear: 1901,
        	    maxYear: parseInt(moment().format('YYYY'),10)
        	  }, function(start, end, label) {
        	    var years = moment().diff(start, 'years');
        	    alert("You are " + years + " years old!");
        	  });
        	});
    </script>

    <!-- Agregar el enlace a Bootstrap JS y jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
