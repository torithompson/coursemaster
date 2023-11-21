package comp31.coursemaster.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import comp31.coursemaster.services.UserService;

@Controller
public class StudentController {
    UserService userService;

    public StudentController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/student")
    public String getStudent(Model model) {
        model.addAttribute("students", userService.findStudents());
        return "student";
    }

    @GetMapping("/enrolledCourses")
    public String getEnrolledCourses() {
        return "student";
    }

    @GetMapping("/courseInfo")
    public String getCourseInfo() {
        return "student";
    }
}
