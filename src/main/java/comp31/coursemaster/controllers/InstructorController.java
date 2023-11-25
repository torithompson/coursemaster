package comp31.coursemaster.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import comp31.coursemaster.model.entities.Assignment;
import comp31.coursemaster.services.InstructorService;
import org.springframework.web.bind.annotation.PostMapping;

// Ethan Watson

@Controller
public class InstructorController {
    InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/instructor")
    public String getInstructor(Model model) {
        model.addAttribute("instructor", instructorService.getInstructor(1));
        return "instructor";
    }

    @GetMapping("/assignments")
    public String getAssignments() {
        return "assignments";
    }

    @PostMapping("/createAssignment")
    public String createAssignment(Assignment assignment) {
        return "redirect:/instructor";
    }
}
