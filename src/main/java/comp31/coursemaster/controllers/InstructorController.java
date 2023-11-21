package comp31.coursemaster.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import comp31.coursemaster.model.entities.Assignment;
import comp31.coursemaster.model.entities.Instructor;
import comp31.coursemaster.services.InstructorService;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class InstructorController {
    InstructorService instructorService;

    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @GetMapping("/instructor")
    public String getInstructor(Model model) {
        model.addAttribute("instructor", new Instructor());
        return "instructor";
    }

    @GetMapping("/courses")
    public String getCourses(Model model) {
        model.addAttribute("courses", instructorService.findAll());
        return "courses";
    }

    @GetMapping("/assignments")
    public String getAssignments() {
        return "assignments";
    }

    @PostMapping("/createAssignment")
    public Assignment createAssignment(Assignment assignment) {
        return assignment;
    }
}
