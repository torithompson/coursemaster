//Author: Emma Lavigne

package comp31.coursemaster.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import comp31.coursemaster.model.entities.User;
import comp31.coursemaster.services.AdminService;

@Controller
@RequestMapping
public class AdminController {

    AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping({ "/admin", "/add-user" })
    public String getAdmin(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("allUsers", adminService.findUsers());
        return "admin";
    }

    @PostMapping("/add-user")
    public String addNewAdmin(Model model, User user,
            @RequestParam(required = true) String permissions) {
        user.setPermissions(permissions);
        if (permissions.equals("admin")) {
            adminService.addAdmin(user);
        } else if (permissions.equals("instructor")) {
            adminService.addInstructor(user);
        } else {
            adminService.addStudent(user);
        }
        return "redirect:/admin";
    }

}
