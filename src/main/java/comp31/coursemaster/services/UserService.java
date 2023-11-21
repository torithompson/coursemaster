package comp31.coursemaster.services;

import java.util.List;

import org.springframework.stereotype.Service;

import comp31.coursemaster.model.entities.Course;
import comp31.coursemaster.model.entities.Student;
import comp31.coursemaster.model.repos.CourseRepo;
import comp31.coursemaster.model.repos.StudentRepo;

@Service
public class UserService {
    StudentRepo studentRepo;
    CourseRepo courseRepo;

    public UserService(StudentRepo studentRepo, CourseRepo courseRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
    }

    public boolean addUser() {
        return true;
    }

    public boolean updateUser() {
        return true;
    }

    public Iterable<Student> findStudents() {
        return studentRepo.findAll();
    }

    public List<Course> findCourses(Integer student_id) {
        return courseRepo.findCourseByStudent_Id(student_id);
    }

    public void uploadAssignment() {
        
    }
}
