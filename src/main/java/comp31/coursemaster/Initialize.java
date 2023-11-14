package comp31.coursemaster;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import comp31.coursemaster.model.entities.Course;
import comp31.coursemaster.model.entities.Grade;
import comp31.coursemaster.model.entities.Payment;
import comp31.coursemaster.model.entities.Student;
import comp31.coursemaster.model.repos.StudentRepo;

@Component
public class Initialize implements CommandLineRunner {
    StudentRepo studentRepo;

    public Initialize(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        // Add your initialization code here

        Course mathCourse = new Course("Math", "College math", "2021-09-01");
        Grade mathGrade = new Grade(90, 5, "Feedback feedback", 5);
        Payment payment = new Payment("550.00");

        List<Course> courses = Arrays.asList(mathCourse);
        List<Grade> grades = Arrays.asList(mathGrade);
        List<Payment> payments = Arrays.asList(payment);
        List<String> permissions = Arrays.asList("student");
        studentRepo.save(
                new Student("Bob", "password", permissions, "Bob", "Smith", "bob.smith@school.com",
                        "343-222-2222",
                        "123 test st", "napanee", "ontario", "k3e3e3", "Canada", courses, grades, payments));
        
    }
}
