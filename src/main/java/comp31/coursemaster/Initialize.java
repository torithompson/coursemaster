package comp31.coursemaster;

import java.util.List;
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

        paymentRepo.findById(1);

        // Students
        studentRepo.save(
                new Student("Bob", "password", "student", "Bob", "Smith", "bob.smith@school.com",
                        "343-222-2222",
                        "123 test st", "napanee", "ontario", "k3e3e3", "Canada", null,
                        null));

        studentRepo.save(new Student("Alice", "password", "student", "Alice", "Johnson", "alice.johnson@school.com",
                "555-111-1111", "456 Main St", "Springfield", "Illinois", "62701", "USA",
                paymentRepo.findAll(), courseRepo.findAll()));

        studentRepo.save(new Student("Charlie", "password", "student", "Charlie", "Brown", "charlie.brown@school.com",
                "555-222-2222", "789 Oak St", "Rivertown", "Mississippi", "12345", "USA",
                paymentRepo.findAll(), courseRepo.findAll()));

        instructorRepo.save(new Instructor("Charles", "password", "instructor", "Charles", "Cuthbert",
                "charles.cuthbert@coursemaster.com",
                "343-222-2222", "123 test st", "napanee", "ontario", "k3e3e3", "Canada", null, null));

        // courses
        Course course = new Course("Math", "College math", instructorRepo.findById(1),
                studentRepo.findAll(), "2021-09-01");
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

        // Courses
        courseRepo.save(new Course("MATH101", "Introduction to Mathematics", instructorRepo.findById(1),
                studentRepo.findAll(), "2023-09-01"));
        courseRepo.save(new Course("PHYS201", "Physics for Engineers", instructorRepo.findById(2),
                studentRepo.findAll(), "2023-09-05"));
        courseRepo.save(new Course("ENG101", "English Composition", instructorRepo.findById(3), studentRepo.findAll(),
                "2023-09-10"));
        courseRepo.save(new Course("HIST202", "World History II", instructorRepo.findById(4), studentRepo.findAll(),
                "2023-09-15"));
        courseRepo.save(new Course("CS301", "Advanced Algorithms", instructorRepo.findById(5), studentRepo.findAll(),
                "2023-09-20"));

        // Instructor
        // instructorRepo.save(new Instructor(""));
        adminRepo.save(new Admin(1, "Boss", "coolboss", "admin", "Barrie", "Responsible",
                "cool.boss@coursemaster.com",
                "343-987-3645", "over the rainbow", "nowhere", "ontario", "k3e3e3",
                "Canada"));
    }
}
