package comp31.coursemaster;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import comp31.coursemaster.model.entities.Admin;
import comp31.coursemaster.model.entities.Grade;
import comp31.coursemaster.model.entities.Payment;
import comp31.coursemaster.model.entities.Student;
import comp31.coursemaster.model.repos.AdminRepo;
import comp31.coursemaster.model.repos.PaymentRepo;
import comp31.coursemaster.model.repos.StudentRepo;

@Component
public class Initialize implements CommandLineRunner {
    AdminRepo adminRepo;
    StudentRepo studentRepo;
    PaymentRepo paymentRepo;

    public Initialize(AdminRepo adminRepo, StudentRepo studentRepo, PaymentRepo paymentRepo) {
        this.adminRepo = adminRepo;
        this.studentRepo = studentRepo;
        this.paymentRepo = paymentRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        // Add your initialization code here

        // Course mathCourse = new Course("Math", "College math", "2021-09-01");
        Grade mathGrade = new Grade(90, 5, "Feedback feedback", null);
        Payment payment = new Payment(studentRepo.getStudentById(1), 100, 1,"Bob", "Smith");

        // List<Course> courses = Arrays.asList(mathCourse);
        List<Grade> grades = Arrays.asList(mathGrade);
        // List<Payment> payments = Arrays.asList(payment);
        List<String> permissions = Arrays.asList("student");
        List<String> adminPermissions = Arrays.asList("admin");
        studentRepo.save(
                new Student("Bob", "password", permissions, "Bob", "Smith", "bob.smith@school.com",
                        "343-222-2222",
                        "123 test st", "napanee", "ontario", "k3e3e3", "Canada", grades, null));
        // courses
        //Payment
        paymentRepo.save(payment);
        paymentRepo.save(new Payment(studentRepo.getStudentById(2), 20000, 1, "Charles", "Cuthbert"));
        paymentRepo.save(new Payment(studentRepo.getStudentById(3), 0, 0, "Jermaine", "Jerm"));
        paymentRepo.save(new Payment(studentRepo.getStudentById(4), -780, 1, "David", "Dudeson"));
        
        adminRepo.save(
            new Admin(1, "Boss", "coolboss", adminPermissions, "Barrie", "Responsible", "cool.boss@coursemaster.com",
                        "343-987-3645", "over the rainbow", "nowhere", "ontario", "k3e3e3", "Canada"));
    }
}
