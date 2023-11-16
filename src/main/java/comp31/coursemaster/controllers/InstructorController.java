package comp31.coursemaster.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class InstructorController {
    @GetMapping("/instructor")
    public String getInstructor() {
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
