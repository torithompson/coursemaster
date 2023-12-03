package comp31.coursemaster.services;

import java.util.List;

import org.springframework.stereotype.Service;

import comp31.coursemaster.model.entities.Assignment;
import comp31.coursemaster.model.entities.Course;
import comp31.coursemaster.model.entities.Instructor;
import comp31.coursemaster.model.repos.CourseRepo;
import comp31.coursemaster.model.repos.InstructorRepo;

// Ethan Watson

@Service
public class InstructorService {
    InstructorRepo instructorRepo;
    CourseRepo courseRepo;

    // construct instructor service
    public InstructorService(InstructorRepo instructorRepo, CourseRepo courseRepo) {
        this.instructorRepo = instructorRepo;
        this.courseRepo = courseRepo;
    }

    // find an instructor by their id
    public Instructor findById(int id) {
        return instructorRepo.findById(id);
    }

    // create an assignment
    public void CreateAssignment() {
        new Assignment();
    }

    // get all courses
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    public Course findCourseByName(String name) {
        return courseRepo.findCourseByName(name);
    }
}
