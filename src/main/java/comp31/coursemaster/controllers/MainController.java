package comp31.coursemaster.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import comp31.coursemaster.model.entities.User;
import comp31.coursemaster.services.LoginService;

@Controller
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
    public String getRoot(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }

    // Handling the POST request to /login
    @PostMapping("/login")
    public String getLogin(@RequestParam String userId, User user, Model model) {
        String validatedLogin = loginService.login(userId, user, model);
        return validatedLogin;
    }
}
