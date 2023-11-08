package com.example.coding.authentication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.coding.authentication.models.User;
import com.example.coding.authentication.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserDetailsController {

    private final UserService userService;

    public UserDetailsController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/userDetails")
    public String userDetails(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("id");
        if (userId == null) {
            return "redirect:/login";
        }

        User user = userService.findUserById(userId);
        model.addAttribute("user", user);

        return "views/userDetails.jsp";
    }
}
