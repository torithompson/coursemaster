package comp31.coursemaster.services;

import org.hibernate.mapping.List;
import org.springframework.stereotype.Service;

import comp31.coursemaster.model.entities.Student;
import comp31.coursemaster.model.repos.StudentRepo;

@Service
public class UserService {
    StudentRepo studentRepo;

    public UserService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public boolean addUser() {
        return true;
    }

    public boolean updateUser() {
        return true;
    }

    public List getUserInfo() {
        return null;
    }

    public Iterable<Student> findStudents() {
        return studentRepo.findAll();
    }
}
