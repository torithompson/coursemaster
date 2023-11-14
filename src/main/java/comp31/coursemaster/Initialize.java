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

        Course mathCourse = new Course("Math");
        Grade mathGrade = new Grade("99");
        Payment payment = new Payment("550.00");

        List<Course> courses = Arrays.asList(mathCourse);
        List<Grade> grades = Arrays.asList(mathGrade);
        List<Payment> payments = Arrays.asList(payment);

        studentRepo.save(new Student(courses, grades, payments));
        
    }
}
