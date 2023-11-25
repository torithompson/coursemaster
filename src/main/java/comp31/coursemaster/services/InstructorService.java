package comp31.coursemaster.services;

import java.util.List;

import org.springframework.stereotype.Service;

import comp31.coursemaster.model.entities.Assignment;
import comp31.coursemaster.model.entities.Course;
import comp31.coursemaster.model.entities.Instructor;
import comp31.coursemaster.model.entities.Student;
import comp31.coursemaster.model.repos.CourseRepo;
import comp31.coursemaster.model.repos.InstructorRepo;

// Ethan Watson

@Service
public class InstructorService {
    InstructorRepo instructorRepo;
    CourseRepo courseRepo;

    public InstructorService(InstructorRepo instructorRepo, CourseRepo courseRepo) {
        this.instructorRepo = instructorRepo;
        this.courseRepo = courseRepo;
    }

    public List<Course> GetAssignedCourses() {
        return null;
    }

    public List<Student> GetAssignedStudents() {
        return null;
    }

    public void CreateAssignment() {
        new Assignment();
    }

    public Instructor getInstructor(int id) {
        return instructorRepo.findById(id);
    }

    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }
}
