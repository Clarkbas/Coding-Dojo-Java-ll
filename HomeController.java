package com.nttdata.persona.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
//@RequestMapping("/wiki")
public class HomeController {

	Integer contador = 0;

	@RequestMapping("/")
	public String index() {
		System.out.println("pase x aca");
		return "index.jsp";
	}

	@RequestMapping("/model")
	public String index(Model model) {
		contador++;
		model.addAttribute("contador", contador);
		return "index.jsp";
	}

	@RequestMapping("/model2")
	public String index2(Model model) {
		contador++;
		model.addAttribute("contador", contador);
		return "index2.jsp";
	}

	@RequestMapping("/cerrarSesion")
	public String cerrarSesion(HttpSession session) {
		session.invalidate();

		return "cerrarSesion.jsp";
	}

	@RequestMapping("/sesion")
	public String usarSesiones(HttpSession session) {
		//session.setMaxInactiveInterval(5);
		if (session.getAttribute("count") == null) // Si no se ha seteado el atributo count
		{
			session.setAttribute("count", 0);
		}
		Integer count = (Integer) session.getAttribute("count");
		count++;
		session.setAttribute("count", count);
		
		return "index2.jsp";
	}

	@RequestMapping("/URL")
	public String hello() {
		return "Hola Mundo!";
	}

	@RequestMapping("/saludo")
	public String world() {
		return "<b>texto world!</b>";
	}

	@RequestMapping(value = "/greeting/hello", method = RequestMethod.GET)
	public String hello_2() {
		return "Hello world! ¿Que ruta utilizaste para acceder aqui?";
	}

	@RequestMapping("/X")
	public String index(@RequestParam(value = "consulta") String valor_consulta) {
		return "hola:  " + valor_consulta;
	}

	@RequestMapping("/{variable1}/{x}/{var3}/{var4}/{var5}")
	public String showLesson(@PathVariable("variable1") String var1, @PathVariable("x") String var2,
			@PathVariable("var3") String var3, @PathVariable("var4") String var4, @PathVariable("var5") String var5) {
		return "var1: " + var1 + ", var2: " + var2 + ", var3: " + var3 + ", var4: " + var4 + ", var5: " + var5;
	}
}
