package comp31.coursemaster.services;

import java.util.List;

import org.springframework.stereotype.Service;

import comp31.coursemaster.model.entities.Course;
import comp31.coursemaster.model.entities.Student;
import comp31.coursemaster.model.repos.CourseRepo;
import comp31.coursemaster.model.repos.StudentRepo;
import comp31.coursemaster.model.repos.UserRepo;

@Service
public class UserService {
    StudentRepo studentRepo;
    CourseRepo courseRepo;
    UserRepo userRepo;

    public UserService(StudentRepo studentRepo, CourseRepo courseRepo, UserRepo userRepo) {
        this.studentRepo = studentRepo;
        this.courseRepo = courseRepo;
        this.userRepo = userRepo;
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

    public Student findStudentById(Integer id) {
        return studentRepo.findStudentById(id);
    }

    public List<Course> findCourses(Integer student_id) {
        return courseRepo.findCourseByStudent_Id(student_id);
    }

    public void uploadAssignment() {
        
    }

    public Integer findUserIdByUserName(String username) {
        return userRepo.findIdByUsername(username);
    }

    public String findPermissionsByUserName(String username) {
        return userRepo.findPermissionsByUsername(username);
    }
}
