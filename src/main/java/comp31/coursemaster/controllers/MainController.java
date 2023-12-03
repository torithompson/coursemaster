package comp31.coursemaster.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import comp31.coursemaster.model.entities.User;
import comp31.coursemaster.services.LoginService;

/*
 * This controller handles the GET request to the root page (/) and the GET request to /login
 * Author: Tori Thompson
 */
@Controller
@RequestMapping
public class MainController {
    LoginService loginService;

    public MainController(LoginService loginService) {
        this.loginService = loginService;
    }

    // Handling the GET request to root
    @GetMapping("/")
    public String getRoot() {
        return "index";
    }

    // Handling the GET request to /login
    @GetMapping("/login")
    public String getLogin(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }

    // Handling the POST request to /login
    @PostMapping("/login")
    public String getLogin(@RequestParam String username, User user, Model model) {
        String validatedLogin = loginService.login(username, user, model);
        return validatedLogin;
    }

    // Handling the GET request to /logout
    @GetMapping("/logout")
    public String logout() {
        return "redirect:/"; // Redirect to the root page
    }
}
