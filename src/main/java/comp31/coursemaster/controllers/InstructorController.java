package comp31.coursemaster.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import comp31.coursemaster.services.InstructorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// Ethan Watson

@Controller
@RequestMapping
public class InstructorController {
    InstructorService instructorService;

    // controller constructor
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    // Handling the GET request to /instructor
    @GetMapping("/instructor")
    public String getInstructor(Model model, @RequestParam int id) {
        model.addAttribute("instructor_id", id);
        model.addAttribute("instructor", instructorService.findById(id));
        return "instructor";
    }

    // Handling the GET request to /courses
    @GetMapping("/courses")
    public String getCourses(Model model) {
        model.addAttribute("courses", instructorService.getAllCourses());
        return "courses";
    }

    // Handling the GET request to /assignments
    @GetMapping("/assignments")
    public String getAssignments() {
        return "assignments";
    }

    // Handling the POST request to /createAssignment
    @PostMapping("/createAssignment")
    public String createAssignment(@RequestParam int id) {
        return "redirect:/instructor?id=" + id + "&uploadSuccess";
    }
}
