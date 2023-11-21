package comp31.coursemaster.services;

import java.util.List;

import org.springframework.stereotype.Service;

import comp31.coursemaster.model.entities.Assignment;
import comp31.coursemaster.model.entities.Course;
import comp31.coursemaster.model.entities.Student;

@Service
public class InstructorService {
    public List<Course> GetAssignedCourses() {
        return null;
    }

    public List<Student> GetAssignedStudents() {
        return null;
    }

    public void CreateAssignment() {
        new Assignment();
    }
}
