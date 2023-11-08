package com.example.coding.authentication.controllers;


// Importaciones necesarias
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.coding.authentication.models.User;
import com.example.coding.authentication.services.UserService;
import com.example.coding.authentication.validator.UserValidator;

import jakarta.servlet.http.HttpSession;

@Controller
public class Homecontroller {
    private final UserService userService;
    private final UserValidator userValidator;

    // Constructor: Inyecta la dependencia del UserService
    public Homecontroller(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

    // Método que maneja la solicitud GET para mostrar el formulario de registro
    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "views/registrationPage.jsp";
    }

    // Metodo que maneja la solicitud GET para mostrar el formulario de inicio de sesión
    @RequestMapping("/login")
    public String login() {
        return "views/loginPage.jsp";
    }

    // Método que maneja la solicitud POST para procesar el formulario de registro
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        // Si el resultado tiene errores de validación, muestra el formulario de registro nuevamente con los mensajes de error
    	userValidator.validate(user, result);
    	if (result.hasErrors()) {
            return "views/registrationPage.jsp";
	       } else {
            // Guardar el usuario en la base de datos utilizando el servicio UserService
        	User user2 = userService.registerUser(user);

            // Guardar el ID del usuario en la sesión
            session.setAttribute("id", user2.getId()); // acá el spring me relleno con HttpSession

            // Redirigir a la página principal
            return "redirect:/home";
        }
    }

    // Método que maneja la solicitud POST para procesar el formulario de inicio de sesión
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model,
            HttpSession session) {
        // Buscar el usuario por su dirección de correo electrónico utilizando el servicio UserService

        // Si el usuario se encuentra, guardar su ID en la sesión y redirigir a la página principal
        if (userService.authenticateUser(email,password)) { // se determina si se encontró un usuario con el correo electrónico
        	session.setAttribute("id", userService.findByEmail(email).getId()); // 
            return "redirect:/home";
        } else {
            // Si las credenciales son inválidas, agregar un mensaje de error y redirigir nuevamente a la página de inicio de sesión
            model.addAttribute("error", "Credenciales inválidas. Inténtalo de nuevo.");
            return "views/loginPage.jsp";
        }
    }

    // Método que maneja la solicitud GET para mostrar la página principal del usuario autenticado
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        // Obtener el ID del usuario desde la sesión
        Long userId = (Long) session.getAttribute("id");

        // Si se encuentra un ID de usuario en la sesión, buscar el usuario utilizando el servicio UserService
        if (userId != null) {  //verifica si hay un usuario autenticado en la sesión actual y carga sus datos
            User user = userService.findUserById(userId);

            // Guardar el usuario en el modelo para que pueda ser mostrado en la vista
            model.addAttribute("user", user);

            // Retornar la vista de la página principal del usuario
            return "views/homePage.jsp";
        } else {
            // Si no hay un usuario en sesión, redirigir a la página de inicio de sesión
            return "redirect:/login";
        }
    }

    // Método que maneja la solicitud GET para cerrar la sesión actual del usuario
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // Invalidar la sesión actual
        session.invalidate();

        // Redireccionar a la página de inicio de sesión
        return "redirect:/login";
    }
}
