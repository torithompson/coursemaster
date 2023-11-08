package comp31.coursemaster.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
    // getEnrolledCourses - get
    // getCourseInfo - get

    @GetMapping("/student")
    public String getStudent() {
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
