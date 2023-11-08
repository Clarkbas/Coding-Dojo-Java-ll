package com.example.NinjaGold;

import com.example.NinjaGold.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class JuegoNinjaGoldControllers {
    private static final int MIN_GRANJA = 10;
    private static final int MAX_GRANJA = 20;
    private static final int MIN_CUEVA = 5;
    private static final int MAX_CUEVA = 10;
    private static final int MIN_CASA = 2;
    private static final int MAX_CASA = 5;
    private static final int MIN_CASINO = -50;
    private static final int MAX_CASINO = 50;
    private static final int MIN_SPA = -20;
    private static final int MAX_SPA = -5;
    private static final int MAX_DEUDA = -100;
    private static Random random;
    
    @RequestMapping("/gold")
    public String index() {
        return "index.jsp";
    }
    
    public JuegoNinjaGoldControllers(HttpSession session) {
        random = new Random();
    }

    @RequestMapping("/actividades")
    public String realizarActividad(HttpSession session, Model model, String lugar) {
    	Integer oroObj = (Integer) session.getAttribute("oro");
    	int oro = oroObj != null ? oroObj.intValue() : 0;


        LocalDateTime now = LocalDateTime.now();
        String tiempo = now.toString();

        int gananciaOro = 0;

        switch (lugar) {
            case "farm":
                gananciaOro = generarNumeroAleatorio(MIN_GRANJA, MAX_GRANJA);
                break;
            case "cave":
                gananciaOro = generarNumeroAleatorio(MIN_CUEVA, MAX_CUEVA);
                break;
            case "house":
                gananciaOro = generarNumeroAleatorio(MIN_CASA, MAX_CASA);
                break;
            case "casino":
                gananciaOro = generarNumeroAleatorio(MIN_CASINO, MAX_CASINO);
                break;
            case "spa":
                gananciaOro = generarNumeroAleatorio(MIN_SPA, MAX_SPA);
                break;
            default:
            	break;
        }

        oro += gananciaOro;

        // Verificar si el ninja se endeudó demasiado
        if (oro <= MAX_DEUDA) {
            return "redirect:/prision";
        }

        session.setAttribute("oro", oro);

        RegistroActividad registro = new RegistroActividad(lugar, gananciaOro, tiempo);
        List<RegistroActividad> registros = (List<RegistroActividad>) session.getAttribute("registros");
        if (registros == null) {
            registros = new ArrayList<>();
        }
        registros.add(registro);
        session.setAttribute("registros", registros);
        model.addAttribute("registros", registros);
//        model.addAttribute("registros", registros);

        return "redirect:/gold";
    }

    @PostMapping("/reset")
    public String reset(HttpSession session) {
        session.invalidate();
        return "redirect:/gold";
    }

    @RequestMapping("/prision")
    public String prision() {
        return "prision";
    }

    private int generarNumeroAleatorio(int min, int max) {
        
        return random.nextInt(max - min + 1) + min;
    }


}

