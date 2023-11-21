package comp31.coursemaster;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import comp31.coursemaster.model.entities.Admin;
import comp31.coursemaster.model.entities.Course;
import comp31.coursemaster.model.entities.Instructor;
import comp31.coursemaster.model.entities.Payment;
import comp31.coursemaster.model.entities.Student;
import comp31.coursemaster.model.repos.AdminRepo;
import comp31.coursemaster.model.repos.CourseRepo;
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
    CourseRepo courseRepo;

    public Initialize(AdminRepo adminRepo, StudentRepo studentRepo, PaymentRepo paymentRepo,
                    InstructorRepo instructorRepo, CourseRepo courseRepo) {
        this.adminRepo = adminRepo;
        this.studentRepo = studentRepo;
        this.paymentRepo = paymentRepo;
        this.instructorRepo = instructorRepo;
        this.courseRepo = courseRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        // Add your initialization code here

        studentRepo.save(
                new Student("Bob", "password", "student", "Bob", "Smith", "bob.smith@school.com",
                        "343-222-2222",
                        "123 test st", "napanee", "ontario", "k3e3e3", "Canada", null,
                                        null));
        instructorRepo.save(new Instructor("Charles", "password", "instructor", "Charles", "Cuthbert",
                "charles.cuthbert@coursemaster.com",
                        "343-222-2222", "123 test st", "napanee", "ontario", "k3e3e3", "Canada", null, null));

        // courses
        Course course = new Course("Math", "College math", instructorRepo.findInstructorById(1),
                        studentRepo.findStudentById(1), "2021-09-01");
        courseRepo.save(course);
        // Payment
        Payment payment = new Payment(studentRepo.findStudentById(1), 100, 1, "Bob", "Smith");
        paymentRepo.save(payment);
        // paymentRepo.save(new Payment(studentRepo.getStudentById(2).getId(), 20000, 1,
        // "Charles", "Cuthbert"));
        // paymentRepo.save(new Payment(studentRepo.getStudentById(3).getId(), 0, 0,
        // "Jermaine", "Jerm"));
        // paymentRepo.save(new Payment(studentRepo.getStudentById(4).getId(), -780, 1,
        // "David", "Dudeson"));

        adminRepo.save(
                new Admin(1, "Boss", "coolboss", "admin", "Barrie", "Responsible", "cool.boss@coursemaster.com",
                        "343-987-3645", "over the rainbow", "nowhere", "ontario", "k3e3e3", "Canada"));
    }
}
