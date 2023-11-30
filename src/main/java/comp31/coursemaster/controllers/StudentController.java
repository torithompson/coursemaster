package comp31.coursemaster.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import comp31.coursemaster.services.UserService;

@Controller
@RequestMapping
public class StudentController {
    UserService userService;

    public StudentController(UserService userService) {
        this.userService = userService;
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
            // Handle empty file
            
            return "redirect:/student?id=" + id + "&uploadFailedEmpty";
        }

        try {
            // Get the file name and normalize it
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());

            // Specify the directory where you want to save the file
            Path uploadDir = Paths.get("src").resolve("main").resolve("java").resolve("comp31").resolve("coursemaster").resolve("uploads");
            Path filePath = uploadDir.resolve(fileName);
            // Copy the file to the upload directory
            Files.copy(file.getInputStream(), filePath);


            // You can now perform further processing or save the file path to a database

        } catch (IOException e) {

            // Handle file I/O exception
            return "redirect:/student?id=" + id + "&uploadFailedCatch";
        }

        return "redirect:/student?id=" + id + "&uploadSuccess"; // Redirect to a relevant page after file upload
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
