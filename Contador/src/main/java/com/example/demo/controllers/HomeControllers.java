package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/your_server")
public class HomeControllers {
	@RequestMapping("")
	public String index1(HttpSession session) {
		//session.setMaxInactiveInterval(5);
		if (session.getAttribute("count") == null) // Si no se ha seteado el atributo count
		{
			session.setAttribute("count", 0);
		}
		Integer count = (Integer) session.getAttribute("count");
		count++;
		session.setAttribute("count", count);
		
		return "index.jsp";
	}
	@RequestMapping("/counter")
	public String index2() {
	return "contador.jsp";	
	}
	@RequestMapping("/cerrarSesion")
	public String cerrarSesion(HttpSession session) {
		session.invalidate();

		return "contador.jsp";
	}
}
