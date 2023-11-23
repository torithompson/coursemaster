package comp31.coursemaster.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import comp31.coursemaster.model.entities.Admin;
import comp31.coursemaster.services.AdminService;

@Controller
public class AdminController {

    AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping({"/admin", "/add-admin"})
    public String getAdmin(Model model, @RequestParam int id) {
        model.addAttribute("admin_id", id);
        model.addAttribute("admin", new Admin());
        model.addAttribute("allAdmins", adminService.findAdmins());
        return "admin";
    }

    @PostMapping("/add-admin")
    public String addNewAdmin(Model model, Admin admin) {
        adminService.addAdmin(admin);
        return "redirect:/admin";
    }

}
