package com.example.coding.emyge.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.coding.emyge.models.Empleado;
import com.example.coding.emyge.repositories.EmpleadoRepository;

@Controller
public class HomeController {
	private final EmpleadoRepository empleadoRepository;
	public HomeController(EmpleadoRepository empleadoRepository) {
		super();
		this.empleadoRepository = empleadoRepository;
	}

	@GetMapping("/friends")
	public void friends() {
	    Optional<Empleado> empleado = empleadoRepository.findById(2L);
	    System.out.println("1 "+empleado.get().getManager().getFirstName());
//	    
	    //Esto imprimirá el nombre del usuario 2 y 3. Todos los usuarios que son amigos de este usuario.  
	    for(Empleado u : empleado.get().getEmpleados()) {
	        System.out.println("2 "+u.getFirstName());
	    }
	   
	}

}
