package comp31.coursemaster.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import comp31.coursemaster.model.entities.Instructor;

@Controller
public class InstructorController {
    @GetMapping("/instructor")
    public String getInstructor(Model model) {
        model.addAttribute("instructor", new Instructor());
        return "instructor";
    }

    @GetMapping("/courses")
    public String getCourses() {
        return "courses";
    }

    @GetMapping("/assignments")
    public String getAssignments() {
        return "assignments";
    }
}
