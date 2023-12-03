package comp31.coursemaster.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import comp31.coursemaster.services.UserService;
import comp31.coursemaster.services.AssignmentService;

// Trevor Withers

@Controller
@RequestMapping
public class StudentController {
    UserService userService;
    AssignmentService assignmentService;

    public StudentController(UserService userService, AssignmentService assignmentService) {
        this.userService = userService;
        this.assignmentService = assignmentService;
    }

    @GetMapping("/student")
    public String getStudent(Model model, @RequestParam Integer id) {
        model.addAttribute("student_id", id);
        model.addAttribute("student", userService.findStudentById(id));
        model.addAttribute("courses", userService.findCourses(id));
        return "student";
    }

    @PostMapping("/uploadAssignment")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, @RequestParam Integer id) {

        if (file.isEmpty()) {
            return "redirect:/student?id=" + id + "&uploadFailedEmpty";
        } else {

            // You can now perform further processing or save the file path to a database
            assignmentService.uploadAssignment(file, id);

            return "redirect:/student?id=" + id + "&uploadSuccess"; // Redirect to a relevant page after file upload
        }
    }

    @GetMapping("/fetchAssignments")
    public String fetchAssignments(@RequestParam String courseName, Model model, @RequestParam Integer id) {
        model.addAttribute("assignments", assignmentService.findAssignments(courseName));
        return "redirect:/student?id=" + id + "&fetchSuccess";
    }

    // @GetMapping("/enrolledCourses")
    // public String getEnrolledCourses() {
    //     return "student";
    // }

    // @GetMapping("/courseInfo")
    // public String getCourseInfo() {
    //     return "student";
    // }
}
