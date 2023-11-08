package com.example.coding.ListStudentsII.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.coding.ListStudentsII.models.Contact;
import com.example.coding.ListStudentsII.models.Dormitory;
import com.example.coding.ListStudentsII.models.Student;
import com.example.coding.ListStudentsII.services.ContactService;
import com.example.coding.ListStudentsII.services.DormitoryService;
import com.example.coding.ListStudentsII.services.StudentService;

@Controller
@RequestMapping("/api")
public class ApiController {
	@Autowired
	private final StudentService studentService;
	@Autowired
	private final ContactService contactService;
	@Autowired
	private final DormitoryService dormitoryService;
	
	public ApiController(StudentService studentService, ContactService contactService, DormitoryService dormitoryService) {
		this.studentService = studentService;
		this.contactService = contactService;
		this.dormitoryService = dormitoryService;
	}	
	
	//METODOS API
	/**
	 * GET AREA
	 * */ 
	@GetMapping("/students/create")
	public String createStudentGet(@ModelAttribute("student") Student student) {
		return "studentForm.jsp";
	}
	@GetMapping("/contacts/create")
	public String createContact(Model model,@ModelAttribute("contact") Contact contact) {
		List<Student> persons = studentService.nullStudent();
		model.addAttribute("persons", persons);
		return "contactForm.jsp";
	}
	@GetMapping("/dorms/{id}")
    public String getDorm(@PathVariable Long id, Model model) {
        Dormitory dorm = dormitoryService.findDormitory(id);
        List<Student> students = dorm.getStudents(); // Obtener los estudiantes del dormitorio
        List<Student> studentWithoutDorm = studentService.findStudentsWithoutDormitory();
        model.addAttribute("studentwithout", studentWithoutDorm);
        model.addAttribute("students", students);
        model.addAttribute("dorm", dorm);
        return "showDorms.jsp";
    }
	
	@GetMapping("/dorms/new")
	public String createDorm(Model model, @ModelAttribute("dormitory") Dormitory dormitory) {
		return "dormIndex.jsp";
	}

    @PostMapping("/dorms/{id}/add")
    public String addStudentToDorm(@PathVariable Long id, @RequestParam Long studentId) {
        Dormitory dorm = dormitoryService.findDormitory(id);
//        System.out.println(dorm.getName());
        Student student = studentService.findStudent(studentId);
//        System.out.println(student.getFirstName()+" "+student.getLastName());
        List<Student> updatedList = dorm.getStudents();
        updatedList.add(student);
        dorm.setStudents(updatedList);
//        System.out.println(dorm.getStudents());
        //actualizar estudiante
        student.setDormitory(dorm);
        studentService.createStudent(student);
        dorm.getStudents().add(student); // Agregar el estudiante al dormitorio
        dormitoryService.createDormitory(dorm); // Guardar los cambios en la base de datos
        return "redirect:/api/dorms/" + id;
    }

    @PostMapping("/dorms/{id}/remove")
    public String removeStudentFromDorm(@PathVariable Long id, @RequestParam Long studentId) {
        Dormitory dorm = dormitoryService.findDormitory(id);
        System.out.println(id);
        Student student = studentService.findStudent(studentId);
        
        System.out.println(studentId);
        if (dorm != null && student != null) {
            dorm.getStudents().remove(student); // Remover el estudiante del dormitorio
            student.setDormitory(null); // Remover la relación entre el estudiante y el dormitorio
            dormitoryService.createDormitory(dorm); // Guardar los cambios en la base de datos
            studentService.createStudent(student); // Guardar los cambios en la base de datos del estudiante
        }

        return "redirect:/api/dorms/" + id;
    }
	/**
	 * POST AREA
	 * */
	@PostMapping("/students/create")
	public String createStudentsPost( @ModelAttribute("student") Student student, BindingResult result) {
		if(result.hasErrors()) {
			return result.toString();
		}else {
			if("John".equals(student.getFirstName()) && "Doe".equals(student.getLastName())&& student.getAge()==35) {
				studentService.create3Student(student);
			}else {
				studentService.createStudent(student);				
			}
			return "redirect:/api/students/create";			
		}		
	}
	@PostMapping("/contacts/create")
	public String createContactsPost( @ModelAttribute("contactinfo") Contact contact, BindingResult result) {
		if(result.hasErrors()) {
			return result.toString();
		}else {
			contactService.createContact(contact);
			return "redirect:/api/contacts/create";			
		}		
	}	
	@PostMapping("/dorms/create")
    public String createDormitory( @ModelAttribute("dormitory") Dormitory dormitory, BindingResult result, @RequestParam(value="name") String name) {
        if (result.hasErrors()) {
            return "dormIndex.jsp";
        } else {
            dormitory.setName(name);
            dormitoryService.createDormitory(dormitory);
            Long id = dormitory.getId();
            return "redirect:/api/dorms/" + id;
        }
    }
}