package comp31.coursemaster.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import comp31.coursemaster.services.LoginService;

@Controller
public class MainController {
    LoginService loginService;

    public MainController(LoginService loginService) {
        this.loginService = loginService;
    }

    // @PostMapping("/login")
    // public String getLogin() {
    //     String validatedLogin = loginService.login("admin", "password");
    //     return "login";
    // }
}
