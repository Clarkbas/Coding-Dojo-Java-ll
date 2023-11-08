package com.dojo.coding.proyect.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dojo.coding.proyect.models.Reminder;
import com.dojo.coding.proyect.models.User;
import com.dojo.coding.proyect.repositories.UserRepository;
import com.dojo.coding.proyect.services.PublicationService;
import com.dojo.coding.proyect.services.ReminderService;
import com.dojo.coding.proyect.services.UserService;
import com.dojo.coding.proyect.validations.UserValidation;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
    private final UserValidation userValidation;
    private final PublicationService publicationService;
    private final UserService userService;
    private final UserRepository userRepository;
    private final ReminderService reminderService; /*ACA IGUAL SE AÑADIO*/

    @Autowired
    public HomeController(UserValidation userValidation, PublicationService publicationService, UserService userService, UserRepository userRepository, ReminderService reminderService) {
        this.userValidation = userValidation;
        this.publicationService = publicationService;
        this.userService = userService;
		this.userRepository = userRepository;
		this.reminderService = reminderService;/*ACA IGUAL SE AÑADIO*/
    }


    @Autowired
    private UserService userServices;
	private Object parsedDate;
	private Object tareaEnviadaExitosamente;

    @GetMapping("/")
    public String loginRegister(@ModelAttribute("index") User register, HttpSession session) {
        if (session.isNew()) {
            session.setAttribute("login", false);
        }
        return "views/index.jsp";
    }

    @PostMapping("/register")
    public String registerProcess(@Valid @ModelAttribute("login") User userRegister, BindingResult result, RedirectAttributes redirectAttributte) {
        userValidation.validate(userRegister, result);
        if (result.hasErrors()) {
            return "views/index.jsp";
        } else {
            publicationService.registerUser(userRegister);
            redirectAttributte.addFlashAttribute("success", "<p class=\"alert alert-success\" role=\"alert\"> Registration Successful! You may now Log in. </p>");
            return "redirect:/";
        }
    }

    @PostMapping("/Login")
    public String loginProcess(@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session, RedirectAttributes redirectAttributes) {
        if (publicationService.checkLogin(email, password) == false) {
            redirectAttributes.addFlashAttribute("error", "<p class=\"alert alert-danger text-center\" role=\"alert\"> Invalid Credentials </p>");
            return "redirect:/";
        } else {
            session.setAttribute("login", true);
            // Agregar la siguiente línea para almacenar el ID del usuario en la sesión
            session.setAttribute("user", publicationService.findByEmail(email).getIdUser());
            return "redirect:/home";
        }
    }

    @GetMapping("/post")
    public String post() {
        return "views/muro.jsp";
    }

    @GetMapping("/index")
    public String index() {
        return "views/vista.jsp";
    }

    @GetMapping("/post-comunity")
    public String post_comunity() {
        return "views/muro_comunidad.jsp";
    }
    
    /* metodos del creador de recordatorios */
	
	@RequestMapping("/dashboard")//metodo dashboard
	public String dashboard(@ModelAttribute("songName") Reminder song, Model model){
		List<Reminder> songs = reminderService.allSongs();
		model.addAttribute("songs",songs);
		return "views/dashboard.jsp";
	}
	
	@PostMapping("songs/new")
	public String add(@Valid @ModelAttribute("music") Reminder song, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return"views/add.jsp";
		}
		else {
			reminderService.addSong(song);
			return"redirect:/dashboard";
		}
	}
	
	@GetMapping("songs/new")
	public String add(@ModelAttribute("music") Reminder song) {
		return"views/add.jsp";
	}
	
	@DeleteMapping("/dashboard/{songId}")//metodo destroy
	public String destroy(@PathVariable("songId") Long id) {
		reminderService.deleteSong(id);
		return"redirect:/dashboard";
	}
	
	@RequestMapping("/songs/{songId}")// metodo info
	public String info(@PathVariable("songId") Long id, Model model) {
		Reminder song = reminderService.findSong(id);
		model.addAttribute("song",song);
		return "views/info.jsp";
	}
	
	/*HASTA ACÁ*/
	
	
	/* TABLA QUE SOLICITARON */
	
    @GetMapping("/tabla")
    public String showForm(Model model) {
        // Aquí puedes agregar lógica para inicializar el modelo si es necesario
        return "views/upload-form.jsp"; 
    }

    @PostMapping("/upload")
    public String handleUpload(@RequestParam("file") MultipartFile file,
                               @RequestParam("subject") String subject,
                               @RequestParam("task") String task,
                               Model model) {
        // Lógica para manejar la carga del archivo y procesar los datos
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDate = now.format(formatter);
        
        // Agregar la fecha formateada y otros datos al modelo
        model.addAttribute("formattedDate", formattedDate);
        model.addAttribute("subjectName", subject);
        model.addAttribute("profesorName", getProfessorNameForSubject(subject));
        model.addAttribute("tareaName", task);
        model.addAttribute("fechaEntrega", formattedDate); // Reemplaza por la fecha de entrega real
        
        // Simular el mensaje de tarea enviada exitosamente
        model.addAttribute("tareaEnviadaExitosamente", true);

        return "views/result.jsp";
    }
    
    
    
    // Método para obtener el nombre del profesor según la asignatura
    private String getProfessorNameForSubject(String subject) {
        // retornamos una cadena fija.
        if ("Artes Visuales".equals(subject)) {
            return "Manuel Jeldes";
        } else if ("Ciencias Naturales".equals(subject)) {
            return "Molly";
        } else if ("Filosofía".equals(subject)) {
            return "Mariana Contreras";
        }

        return "Profesor Desconocido"; // Valor por defecto si no se encuentra la asignatura
    }


	

}
