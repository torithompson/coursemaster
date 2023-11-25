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

        // Payment
        Payment payment = new Payment(studentRepo.findStudentById(3), 100, 1, "Bob", "Smith");
        paymentRepo.save(payment);
        paymentRepo.save(new Payment(studentRepo.findStudentById(4), 20000, 1,
        "Alice", "Johnson"));
        paymentRepo.save(new Payment(studentRepo.findStudentById(5), 0, 0,
        "Charlie", "Brown"));

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
                        "343-222-2222", "123 test st", "napanee", "ontario", "k3e3e3", "Canada", null));

        // Courses
        courseRepo.save(new Course("MATH101", "Introduction to Mathematics", instructorRepo.findById(4),
                        studentRepo.findAll(), "2023-09-01", null));
        courseRepo.save(new Course("PHYS201", "Physics for Engineers", instructorRepo.findById(4),
                        studentRepo.findAll(), "2023-09-05", null));
        courseRepo.save(new Course("ENG101", "English Composition", instructorRepo.findById(4), studentRepo.findAll(),
                        "2023-09-10", null));
        courseRepo.save(new Course("HIST202", "World History II", instructorRepo.findById(4), studentRepo.findAll(),
                        "2023-09-15", null));
        courseRepo.save(new Course("CS301", "Advanced Algorithms", instructorRepo.findById(4), studentRepo.findAll(),
                        "2023-09-20", null));

        // Instructor
        adminRepo.save(new Admin("Boss", "coolboss", "admin", "Barrie", "Responsible",
                "cool.boss@coursemaster.com",
                "343-987-3645", "over the rainbow", "nowhere", "ontario", "k3e3e3",
                "Canada"));
    }
}
