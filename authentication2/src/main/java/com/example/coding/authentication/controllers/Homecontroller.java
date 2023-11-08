package com.example.coding.authentication.controllers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// Importaciones necesarias
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.coding.authentication.models.User;
import com.example.coding.authentication.repositories.UserRepository;
import com.example.coding.authentication.services.UserService;
import com.example.coding.authentication.validator.UserValidator;

import jakarta.servlet.http.HttpSession;

@Controller
public class Homecontroller {
	
    @Autowired

    private final UserService userService;
    private final UserValidator userValidator;
	private UserRepository userRepository;

    // Constructor: Inyecta la dependencia del UserService
    public Homecontroller(UserService userService, UserValidator userValidator, UserRepository userRepository) {
        this.userService = userService;
        this.userValidator = userValidator;
        this.userRepository = userRepository;
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
    public String registerUser(@ModelAttribute("user") User user, BindingResult result,
                               @RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName,
                               HttpSession session, Model model) {
        // Validar el formulario
        userValidator.validate(user, result);
        if (result.hasErrors()) {
            return "views/registrationPage.jsp";
        } else {
            // Setear firstname y lastname del usuario
            user.setFirstName(firstName);
            user.setLastName(lastName);
            
            // Verificar si es el primer usuario registrado
//            if (userService.countSuperAdmins() == 0 && userService.countUsers() == 0) {
//                user.setSuperAdmin(true);  // Marcar como super administrador
//            }
            
            // Guardar el usuario en la base de datos utilizando el servicio UserService
            User registeredUser = userService.registerUser(user);

            // Guardar el ID del usuario en la sesión
            session.setAttribute("id", registeredUser.getId());

            // Agregar los detalles del usuario al modelo
            
            model.addAttribute("user", registeredUser);

            // Redirigir a la página de detalles del usuario
            return "redirect:/userDetails";
        }
    }


    
    // Método que maneja la solicitud POST para procesar el formulario de inicio de sesión
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model,
                            HttpSession session) {
        if (userService.authenticateUser(email, password)) {
            User user = userService.findByEmail(email);
            session.setAttribute("id", user.getId());

            if (!user.isAdmin()) {
                // Verificar si el correo ya está registrado
                User registeredUser = userService.findByEmail(email);
                if (registeredUser != null) {
                    // Marcar al usuario como administrador y guardar en la base de datos
                    registeredUser.setAdmin(true);
                    userService.saveUser(registeredUser);
                }
            }

            if (user.isSuperAdmin()) {
                return "redirect:/superadmin"; // Redirigir a la página de superadministrador
            } else if (user.isAdmin()) {
                return "redirect:/admin"; // Redirigir a la página de administrador
            } else {
                // Verificar si es el primer usuario registrado y no hay superadministrador
                if (userService.countSuperAdmins() == 0 && userService.countUsers() == 0) {
                    user.setSuperAdmin(true);
                    userService.saveUser(user);
                }
                return "redirect:/home"; // Redirigir a la página principal
            }
        } else {
            model.addAttribute("error", "Credenciales inválidas. Inténtalo de nuevo.");
            return "views/loginPage.jsp";
        }
    }

    @RequestMapping("/superadmin")
    public String superAdmin(HttpSession session, Model model) {
        // Verificar si el usuario está autenticado
        Long userId = (Long) session.getAttribute("id");
        if (userId == null) {
            return "redirect:/login"; // Redirigir a la página de inicio de sesión si no está autenticado
        }

        // Obtener el usuario autenticado
        User authenticatedUser = userService.findUserById(userId);

        // Verificar si el usuario autenticado es un super administrador
        boolean isSuperAdmin = authenticatedUser.isSuperAdmin();

        // Si es superadministrador, cargar la lista de usuarios y enviarla a la vista
        if (isSuperAdmin) {
            Iterable<User> users = userService.findAllUsers();

            // Filtrar la lista para excluir al usuario autenticado
            List<User> filteredUsers = new ArrayList<>();
            for (User user : users) {
                if (!user.getId().equals(userId)) {
                    filteredUsers.add(user);
                }
            }

            model.addAttribute("users", filteredUsers);
            model.addAttribute("isSuperAdmin", isSuperAdmin);

            return "views/superAdmin.jsp";
        } else {
            return "redirect:/admin"; // Redirigir a la página de administrador si no es superadministrador
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
    
    @RequestMapping("/admin")
    public String adminPanel(HttpSession session, Model model) {
        // Verificar si el usuario está autenticado
        Long userId = (Long) session.getAttribute("id");
        if (userId == null) {
            return "redirect:/login"; // Redirigir a la página de inicio de sesión si no está autenticado
        }

        // Si el usuario en sesión es administrador, cargar la lista de todos los usuarios
        if (userService.isAdmin(userId)) {
            Iterable<User> users = userService.findAllUsers();

            // Filtrar los usuarios para ocultar el súper administrador en la lista
            List<User> filteredUsers = new ArrayList<>();
            for (User user : users) {
                if (!user.isSuperAdmin()) {
                    filteredUsers.add(user);
                }
            }

            // Guardar la lista de usuarios filtrados en el modelo
            model.addAttribute("users", filteredUsers);

            // Retornar la vista del Panel de Administración
            return "views/adminPanel.jsp";
        } else {
            // Si el usuario no es administrador, redirigir a la página principal
            return "redirect:/home";
        }
    }



    @RequestMapping(value = "/deleteUser/{userId}", method = RequestMethod.POST)
    public String deleteUser(@PathVariable Long userId, HttpSession session) {
        Long loggedInUserId = (Long) session.getAttribute("id");
        
        // Verificar si el usuario autenticado es el superadministrador
        User loggedInUser = userService.findUserById(loggedInUserId);
        if (loggedInUser != null && loggedInUser.isSuperAdmin()) {
            // Verificar si el usuario a eliminar no es el superadministrador
            if (!loggedInUser.getId().equals(userId)) {
                userService.deleteUser(userId);
            }
        }
        
        return "redirect:/superadmin"; // Redirigir nuevamente al panel de superadministrador
    }


    @RequestMapping(value = "/promoteUser/{userId}", method = RequestMethod.POST)
    public String promoteUser(@PathVariable("userId") Long userId) {
        User userToPromote = userService.findUserById(userId);
        if (userToPromote != null && !userToPromote.isAdmin()) {
            userToPromote.setAdmin(true);
            userService.saveUser(userToPromote);
        }
        return "redirect:/admin";
    }


}
