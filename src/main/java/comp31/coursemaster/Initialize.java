package comp31.coursemaster;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import comp31.coursemaster.model.entities.Admin;
import comp31.coursemaster.model.entities.Course;
import comp31.coursemaster.model.entities.Payment;
import comp31.coursemaster.model.entities.Student;
import comp31.coursemaster.model.repos.AdminRepo;
import comp31.coursemaster.model.repos.PaymentRepo;
import comp31.coursemaster.model.repos.StudentRepo;

/*
 * Initialize 
 * Initializes the database with hardcoded data  
 */
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

        Payment payment = new Payment(studentRepo.findStudentById(1), 100, 1, "Bob", "Smith");
        Course mathCourse = new Course("Math", "College math", 1,
                        studentRepo.findStudentById(1), "2021-09-01");
        List<Course> courses = Arrays.asList(mathCourse);
        List<Payment> payments = Arrays.asList(payment);

        studentRepo.save(
                new Student("Bob", "password", "student", "Bob", "Smith", "bob.smith@school.com",
                        "343-222-2222",
                                        "123 test st", "napanee", "ontario", "k3e3e3", "Canada", payments,
                                        courses));
        // courses
        // Payment
        paymentRepo.save(payment);
        paymentRepo.save(new Payment(studentRepo.findStudentById(2), 20000, 1, "Charles", "Cuthbert"));
        paymentRepo.save(new Payment(studentRepo.findStudentById(3), 0, 0, "Jermaine", "Jerm"));
        paymentRepo.save(new Payment(studentRepo.findStudentById(4), -780, 1, "David", "Dudeson"));

        adminRepo.save(
                new Admin(1, "Boss", "coolboss", "admin", "Barrie", "Responsible", "cool.boss@coursemaster.com",
                        "343-987-3645", "over the rainbow", "nowhere", "ontario", "k3e3e3", "Canada"));
    }
}
