package com.example.coding.student.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.coding.student.models.Contact;
import com.example.coding.student.models.Dormitory;
import com.example.coding.student.models.Student;
import com.example.coding.student.services.ContactService;
import com.example.coding.student.services.DormitoryService;
import com.example.coding.student.services.StudentService;

@Controller
@RequestMapping("/")
public class HomeController {

    private final StudentService studentServiceImpl;
    private final ContactService contactService;
    private final DormitoryService dormitoryService;

    public HomeController(StudentService studentService, ContactService contactService, DormitoryService dormitoryService) {
        this.studentServiceImpl = studentService;
        this.contactService = contactService;
        this.dormitoryService = dormitoryService;
    }

	@RequestMapping(value = "/students", method = { RequestMethod.GET, RequestMethod.POST })
	public String handleDojoForm(@RequestParam(required = false) String name) {
		if (name != null && !name.isEmpty()) {
			Student newStudent = new Student();
			newStudent.setFirstName(name);
			studentServiceImpl.saveStudent(newStudent);
		}
		return "/views/Dojo.jsp"; // Redirige a la página principal o donde desees después de crear el dojo
	}

	@RequestMapping(value = "/contacts", method = { RequestMethod.POST })
	public String createContact(@ModelAttribute("contacts") Contact contact) {
		studentServiceImpl.saveContact(contact);
	    return "redirect:/contacts/show";
	}

	@RequestMapping("/contacts/show")
	public String showNinja(Model model, @ModelAttribute("contacts") Contact contact) {

		List<Student> student = studentServiceImpl.obtenerTodosLosStudents();
		model.addAttribute("students", student);

		return "/views/Ninja.jsp"; // Redirige a la página principal o donde desees después de crear el ninja
	}

//	@RequestMapping("/dojos/{id}")
//	public String viewDojoNinjas(@PathVariable("id") Long dojoId, Model model) {
//		Dojo dojo = dojoService.findDojoById(dojoId);
//		if (dojo != null) {
//			List<Ninja> ninjas = dojo.getNinjas();
//			model.addAttribute("dojo", dojo);
//			model.addAttribute("ninjas", ninjas);
//			return "/views/TablaRegistro.jsp"; // Devuelve la vista TablaRegistro.jsp
//		}
//		return "/views/TablaRegistro.jsp"; // Redirige a la página principal o maneja el error si el dojo no existe
//	}

	@PostMapping("/students/{id}")
	public String crearStudent(@RequestParam String firstName,
	                           @RequestParam String lastName,
	                           @RequestParam int age) {
	    Student newStudent = new Student();
	    newStudent.setFirstName(firstName);
	    newStudent.setLastName(lastName);
	    newStudent.setAge(age);
	    
	    Contact contact = new Contact();
	    contact.setAddress("Dirección"); // Establece la dirección adecuada
	    contact.setCity("Ciudad"); // Establece la ciudad adecuada
	    contact.setState(123); // Establece el estado adecuado
	    
	    // Establecer la relación bidireccional entre estudiante y contacto
	    newStudent.setContact(contact);
	    contact.setStudent(newStudent);
	    
	    // Guardar ambos en la base de datos
	    studentServiceImpl.saveStudent(newStudent);
	    
	    return "redirect:/contacts/show";
	}

	
	// Mostrar todos los students con sus contacts
    @GetMapping("/")
    public String mostrarDojosNinjas(Model model) {
        List<Student> students = studentServiceImpl.obtenerStudentConSusContact();
        model.addAttribute("students", students); // Puedes usar "students" en tu vista para mostrar los datos.
        return "/views/Query.jsp"; // Asegúrate de que el nombre de la vista sea el correcto.
    }

	public ContactService getContactService() {
		return contactService;
	}

	public void setContactService(ContactService contactService) {
		contactService = contactService;
	}
	
	@GetMapping("/dorms/create")
	public String createDorms(@RequestParam String name) {
	    // Lógica para crear 4 dormitorios con el nombre dado "name"
	    // Implementa el código necesario para crear los dormitorios y guardarlos en la base de datos
	    
	    // Ejemplo de cómo crear 4 dormitorios:
	    for (int i = 0; i < 4; i++) {
	        Dormitory newDorm = new Dormitory();
	        newDorm.setName(name);
	        // Guardar el dormitorio en la base de datos utilizando el servicio adecuado
	    }
	    
	    return "redirect:/"; // Redirige a la página principal o donde desees después de crear los dormitorios
	}
	
	@PostMapping("/dorms/{dormId}/add")
	public String addStudentToDorm(@PathVariable Long dormId, @RequestParam Long student) {
	    // Lógica para agregar el estudiante con ID "student" al dormitorio con ID "dormId"
	    // Implementa el código necesario para buscar el dormitorio y el estudiante en la base de datos y agregar la relación
	    
	    // Ejemplo de cómo agregar un estudiante a un dormitorio:
	    Dormitory dormitory = dormitoryService.findDormitoryById(dormId);
	    Student studentToAdd = StudentService.findStudentById(student);
	    if (dormitory != null && studentToAdd != null) {
	        dormitory.addStudent(studentToAdd);
	        // Guardar el dormitorio actualizado en la base de datos utilizando el servicio adecuado
	    }
	    
	    return "redirect:/"; // Redirige a la página principal o donde desees después de agregar el estudiante
	}
	@PostMapping("/dorms/{dormId}/remove")
	public String removeStudentFromDorm(@PathVariable Long dormId, @RequestParam Long student) {
	    // Lógica para remover el estudiante con ID "student" del dormitorio con ID "dormId"
	    // Implementa el código necesario para buscar el dormitorio y el estudiante en la base de datos y remover la relación
	    
	    // Ejemplo de cómo remover un estudiante de un dormitorio:
	    Dormitory dormitory = dormitoryService.findDormitoryById(dormId);
	    Student studentToRemove = StudentService.findStudentById(student);
	    if (dormitory != null && studentToRemove != null) {
	        dormitory.removeStudent(studentToRemove);
	        // Guardar el dormitorio actualizado en la base de datos utilizando el servicio adecuado
	    }
	    
	    return "redirect:/"; // Redirige a la página principal o donde desees después de remover el estudiante
	}
	@GetMapping("/dorms/{dormId}")
	public String showStudentsInDorm(@PathVariable Long dormId, Model model) {
	    // Lógica para obtener todos los estudiantes que pertenecen al dormitorio con ID "dormId"
	    // Implementa el código necesario para buscar el dormitorio en la base de datos y obtener la lista de estudiantes
	    
	    // Ejemplo de cómo mostrar los estudiantes de un dormitorio:
	    Dormitory dormitory = dormitoryService.findDormitoryById(dormId);
	    if (dormitory != null) {
	        List<Student> studentsInDorm = dormitory.getStudents();
	        model.addAttribute("studentsInDorm", studentsInDorm);
	    }
	    
	    return "/views/StudentsInDorm.jsp"; // Nombre de la vista donde mostrar los estudiantes del dormitorio
	}


}