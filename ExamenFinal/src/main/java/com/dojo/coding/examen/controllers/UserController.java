package com.dojo.coding.examen.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dojo.coding.examen.Services.RatingService;
import com.dojo.coding.examen.Services.ShowService;
import com.dojo.coding.examen.Services.UserService;
import com.dojo.coding.examen.models.Rating;
import com.dojo.coding.examen.models.Show;
import com.dojo.coding.examen.models.User;
import com.dojo.coding.examen.validator.UserValidator;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {


	@Autowired
	private UserService userService;
	@Autowired
	private ShowService showService;
	@Autowired
	private UserValidator userValidator;
	@Autowired
	private RatingService ratingService;

	// Se muestra la página de registro e inicio de sesión
	@GetMapping("/")
	public String registerLogin(@ModelAttribute("user") User user, HttpSession session, Model model) {
		if (session.getAttribute("errorMessage") != null) {
			model.addAttribute("errorMessage", session.getAttribute("errorMessage"));
			return "views/registerLogin.jsp";
		} else
			return "views/registerLogin.jsp";
	}

	 // Registrar un nuevo usuario
	@PostMapping("/registration")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result,
	                           HttpSession session, RedirectAttributes redirectAttributes) {
	    userValidator.validate(user, result);
	    if (result.hasErrors()) {
	        return "views/registerLogin.jsp";
	    } else {
	        // Comprobar si el correo electrónico ya existe
	        User emailExiste = userService.findByEmail(user.getEmail());
	        if (emailExiste != null) {
	            result.rejectValue("email", "error.user", "This email is already registered.");
	            return "views/registerLogin.jsp";
	        }
	        
	        User u = userService.registerUser(user);
	        session.setAttribute("userId", u.getId());
	        redirectAttributes.addFlashAttribute("success", "<p class=\"alert alert-success\" role=\"alert\"> Registration Successful! You may now Log in. </p>");
	    }
	    return "redirect:/";
	}



	// Iniciar sesión del usuario
	@PostMapping("/login")
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password,
	                        Model model, HttpSession session, RedirectAttributes redirectAttributes) {
	    boolean isAutenticado = userService.authenticateUser(email, password);
	    if (isAutenticado) {
	        User u = userService.findByEmail(email);
	        session.setAttribute("userId", u.getId());
	        return "redirect:/shows";
	    } else {
	        redirectAttributes.addFlashAttribute("errors", "Invalid Credentials");
	        return "redirect:/";
	    }
	}

	
	// Cerrar sesión del usuario
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	// Muestra la página principal de shows
	@GetMapping("/shows")
	public String home(HttpSession session, Model model) {
		Long uID = (Long) session.getAttribute("userId");
		User user = userService.findUserById(uID);
		List<Show> shows = showService.allShow();
	    List<Double> promedios = new ArrayList<>();
	    for (Show show : shows) {
	        List<Double> ratings = ratingService.promedioPorRating(show.getId());
	        if (!ratings.isEmpty()) {
	            Double promedio = ratings.get(0);
	            promedios.add(promedio);
	        } else {
	            promedios.add(0.0);
	        }
	    }
		model.addAttribute("promedios",promedios);
		model.addAttribute("shows", shows);
		model.addAttribute("user", user);
		return "views/shows.jsp";
	}
	
	
	
	// Muestra  el formulario para crear un nuevo show
	@GetMapping("/shows/new")
	public String createForm(Model model, @ModelAttribute("show") Show show, HttpSession session) {
		Long uID = (Long) session.getAttribute("userId");
		User user = userService.findUserById(uID);
		return "views/newShow.jsp";

	}
	// Crear un nuevo show
	@PostMapping("/shows/new")
	public String create(@Valid @ModelAttribute("show") Show show, BindingResult result, HttpSession session, Model model) {
	    if (result.hasErrors()) {
	        return "views/newShow.jsp";
	    }

	    if (showService.showExists(show.getName())) {
	        model.addAttribute("showExistsError", "El show ya existe.");
	        return "views/newShow.jsp";
	    }

	    Long uID = (Long) session.getAttribute("userId");
	    String userName = userService.findUserById(uID).getName();
	    showService.createShow(show);
	    return "redirect:/shows";
	}
	
	// Muestra los detalles de un show
	@GetMapping(value = "/shows/{id}")
	public String show(@PathVariable("id") Long id, Model model, HttpSession session, @ModelAttribute("rating") Rating rating) {
	    // Obtiene el show correspondiente al ID proporcionado
	    Show show = showService.findShow(id);
	    
	    // Obtiene el ID del usuario actual de la sesión
	    Long uID = (Long) session.getAttribute("userId");
	    
	    // Obtiene el usuario correspondiente al ID obtenido
	    User user = userService.findUserById(uID);
	    
	    // Obtiene una lista de calificaciones (ratings) para el show actual
	    List<Object[]> ratings = ratingService.obtenerCalificacionesPorIdDeShow(id);
	    
	    // Agrega el usuario, el show y las calificaciones al modelo para mostrar en la vista
	    model.addAttribute("user", user);
	    model.addAttribute("show", show);
	    model.addAttribute("ratings", ratings);

	    return "views/mostrar.jsp";
	}

	
	// Muestra el formulario para editar un show
	@GetMapping(value = "/shows/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Show show = showService.findShow(id);
		model.addAttribute("show", show);
		return "views/editShow.jsp";
	}
	
	// Actualiza un show
	@PostMapping("/shows/{id}/edit")
	public String update(@Valid @ModelAttribute("show") Show show, BindingResult result, HttpSession session,
			@PathVariable("id") Long id) {
		if (result.hasErrors()) {
			return "views/editShow.jsp";
		} else {
			Show show1 = showService.findShow(id);
			Long uID = (Long) session.getAttribute("userId");
			String userName = userService.findUserById(uID).getName();
			show1.setName(show.getName());
			show1.setNetwork(show.getNetwork());
			showService.updateShow(show1);
			return "redirect:/shows/" + show1.getId();
		}
	}
	
	// 
	@PostMapping("/shows/{id}/rate")
	public String rateShow(@Valid @PathVariable("id") Long showId, @RequestParam("rating") Double rating, HttpSession session) {
	    // Obtiene el ID del usuario actual de la sesión
	    Long userId = (Long) session.getAttribute("userId");
	    // Busca y obtiene el objeto User correspondiente al ID del usuario
	    User user = userService.findUserById(userId);
	    // Busca y obtiene el objeto Show correspondiente al ID del show a calificar
	    Show show = showService.findShow(showId);

	    // Crea una nueva instancia de Rating para almacenar la calificación
	    Rating newRating = new Rating();
	    newRating.setRating(rating);  
	    newRating.setShow(show);      
	    newRating.setUser(user);      

	    // Llama al servicio para guardar la nueva calificación en la base de datos
	    ratingService.createRating(newRating);

	    return "redirect:/shows/" + showId;
	}

	

	@RequestMapping(value = "/shows/{id}/delete", method = RequestMethod.POST)
	public String destroy(@PathVariable("id") Long id) {
	    // Llama al servicio para eliminar el show correspondiente al ID proporcionado
	    showService.deleteShow(id);

	    return "redirect:/shows";
	}

}
