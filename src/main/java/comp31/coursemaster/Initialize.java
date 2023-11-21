package comp31.coursemaster;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import comp31.coursemaster.model.entities.Admin;
import comp31.coursemaster.model.entities.Course;
import comp31.coursemaster.model.entities.Instructor;
import comp31.coursemaster.model.entities.Payment;
import comp31.coursemaster.model.entities.Student;
import comp31.coursemaster.model.repos.AdminRepo;
import comp31.coursemaster.model.repos.InstructorRepo;
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
    InstructorRepo instructorRepo;

    public Initialize(AdminRepo adminRepo, StudentRepo studentRepo, PaymentRepo paymentRepo,
            InstructorRepo instructorRepo) {
        this.adminRepo = adminRepo;
        this.studentRepo = studentRepo;
        this.paymentRepo = paymentRepo;
        this.instructorRepo = instructorRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        // Add your initialization code here

        Course mathCourse = new Course("Math", "College math", instructorRepo.getInstructorById(1),
                studentRepo.findStudentById(1), "2021-09-01");
        List<Course> courses = Arrays.asList(mathCourse);

        studentRepo.save(
                new Student("Bob", "password", "student", "Bob", "Smith", "bob.smith@school.com",
                        "343-222-2222",
                        "123 test st", "napanee", "ontario", "k3e3e3", "Canada", null,
                        courses));
        instructorRepo.save(new Instructor("Charles", "password", "instructor", "Charles", "Cuthbert",
                "charles.cuthbert@coursemaster.com",
                "343-222-2222", "123 test st", "napanee", "ontario", "k3e3e3", "Canada", courses, null));

        // courses
        // Payment
        Payment payment = new Payment(studentRepo.findStudentById(1), 100, 1, "Bob", "Smith");
        paymentRepo.save(payment);
        // paymentRepo.save(new Payment(studentRepo.getStudentById(2).getId(), 20000, 1,
        // "Charles", "Cuthbert"));
        // paymentRepo.save(new Payment(studentRepo.getStudentById(3).getId(), 0, 0,
        // "Jermaine", "Jerm"));
        // paymentRepo.save(new Payment(studentRepo.getStudentById(4).getId(), -780, 1,
        // "David", "Dudeson"));
        // List<Payment> payments = Arrays.asList(payment);

        adminRepo.save(
                new Admin(1, "Boss", "coolboss", "admin", "Barrie", "Responsible", "cool.boss@coursemaster.com",
                        "343-987-3645", "over the rainbow", "nowhere", "ontario", "k3e3e3", "Canada"));
    }
}
