package comp31.coursemaster.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import comp31.coursemaster.model.entities.Assignment;
import comp31.coursemaster.model.entities.Course;
import comp31.coursemaster.services.AssignmentService;
import comp31.coursemaster.services.InstructorService;
import comp31.coursemaster.services.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

// Ethan Watson

@Controller
@RequestMapping
public class InstructorController {
    InstructorService instructorService;
    AssignmentService assignmentService;
    UserService userService;

    // controller constructor
    public InstructorController(InstructorService instructorService, AssignmentService assignmentService,
            UserService userService) {
        this.instructorService = instructorService;
        this.assignmentService = assignmentService;
        this.userService = userService;
    }

    // Handling the GET request to /instructor
    @GetMapping("/instructor")
    public String getInstructor(Model model, @RequestParam int id) {
        model.addAttribute("assignment", new Assignment());
        model.addAttribute("instructor_id", id);
        model.addAttribute("courses", userService.findCourseByInstructorId(id));
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
    public String getAssignments(Model model) {
        model.addAttribute("assignments", assignmentService.findAll());
        return "assignments";
    }

    @GetMapping("/selectCourse")
    public String selectCourse(Model model, Course course, @RequestParam int id) {
        model.addAttribute("course", course);
        return "redirect:/instructor?id=" + id;
    }

    // Handling the POST request to /createAssignment
    @PostMapping("/createAssignment")
    public String createAssignment(@RequestParam Integer instructor_id, @RequestParam String name, @RequestParam String description,
            @RequestParam String dueDate, @RequestParam String courseName) {
        Assignment assignment = new Assignment();
        assignment.setName(name);
        assignment.setDescription(description);
        assignment.setDueDate(dueDate);
        assignment.setCourse(instructorService.findCourseByName(courseName));
        assignmentService.createAssignment(assignment);

        return "redirect:/instructor?id=" + instructor_id + "&uploadSuccess";
    }

}

