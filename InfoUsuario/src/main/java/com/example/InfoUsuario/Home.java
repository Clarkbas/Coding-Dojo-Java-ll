package com.example.InfoUsuario;

import java.io.IOException;




import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class Home extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtener el parámetro enviado por el usuario
        String parameter = request.getParameter("param");

        // Establecer el valor predeterminado si el parámetro no se proporciona
        if (parameter == null || parameter.isEmpty()) {
            parameter = "Unknown";
        }

        // Enviar la respuesta al usuario
        response.setContentType("text/html");
        response.getWriter().println("<h1>Parameter: " + parameter + "</h1>");
    }
}
