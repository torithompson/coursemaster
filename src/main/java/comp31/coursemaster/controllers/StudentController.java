package comp31.coursemaster.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import comp31.coursemaster.services.UserService;
import comp31.coursemaster.model.entities.Assignment;
import comp31.coursemaster.services.AssignmentService;
import comp31.coursemaster.services.InstructorService;

// Trevor Withers

@Controller
@RequestMapping
public class StudentController {
    UserService userService;
    AssignmentService assignmentService;
    InstructorService instructorService;

    public StudentController(UserService userService, AssignmentService assignmentService, InstructorService instructorService) {
        this.userService = userService;
        this.assignmentService = assignmentService;
        this.instructorService = instructorService;
    }

    @GetMapping("/student")
    public String getStudent(
        Model model,
        @RequestParam Integer id,
        @RequestParam(required = false) Integer courseId,
        @RequestParam(name = "course", required = false) String selectedCourse,
        @RequestParam(required = false) String uploadFailed,
        @RequestParam(required = false) String uploadFailedEmpty,
        @RequestParam(required = false) String uploadSuccess) {

        model.addAttribute("student_id", id);
        model.addAttribute("student", userService.findStudentById(id));
        model.addAttribute("courses", userService.findCourses(id));
        model.addAttribute("selectedCourse", selectedCourse);
        List<Assignment> assignments = assignmentService.findAssignments(courseId);
        model.addAttribute("assignments", assignments);

        // Add attributes related to file upload status
        model.addAttribute("uploadFailed", uploadFailed);
        model.addAttribute("uploadFailedEmpty", uploadFailedEmpty);
        model.addAttribute("uploadSuccess", uploadSuccess);

        return "student";
    }


    @PostMapping("/student")
    public String handleFileUpload(
        @RequestParam MultipartFile file,
        @RequestParam Integer id,
        @RequestParam Integer assignId,
        RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addAttribute("id", id);
            return "redirect:/student?id=" + id + "&uploadFailedEmpty";
        } else {
            String uploadVerified = assignmentService.uploadAssignment(file, assignId);
            if (uploadVerified.equals("uploadFailed")) {
                redirectAttributes.addAttribute("id", id);
                return "redirect:/student?id=" + id + "&uploadFailed";
            } else {
                redirectAttributes.addAttribute("id", id);
                return "redirect:/student?id=" + id+ "&uploadSuccess";
            }
        }
    }


    @GetMapping("/fetchAssignments")
    public String fetchAssignments(@RequestParam String course, Model model, @RequestParam Integer id) {
        Integer courseId = instructorService.findCourseByName(course).getId();
        return "redirect:/student?id=" + id + "&course=" + course + "&courseId=" + courseId;
    }
}