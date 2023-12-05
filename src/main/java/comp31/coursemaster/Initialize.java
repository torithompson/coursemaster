package comp31.coursemaster;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import comp31.coursemaster.model.entities.Assignment;
import comp31.coursemaster.model.entities.Admin;
import comp31.coursemaster.model.entities.Course;
import comp31.coursemaster.model.entities.Instructor;
import comp31.coursemaster.model.entities.Payment;
import comp31.coursemaster.model.entities.Student;
import comp31.coursemaster.model.repos.AssignmentRepo;
import comp31.coursemaster.model.repos.AdminRepo;
import comp31.coursemaster.model.repos.CourseRepo;
import comp31.coursemaster.model.repos.InstructorRepo;
import comp31.coursemaster.model.repos.PaymentRepo;
import comp31.coursemaster.model.repos.StudentRepo;

/*
 * Initialize 
 * Initializes the database with hardcoded data  
 * authors: Fidy Fiaferana, Emma Lavigne, Ethan Watson, Tori Thompson, Trevor Withers
 */
@Component
public class Initialize implements CommandLineRunner {
    AdminRepo adminRepo;
    AssignmentRepo assignmentRepo;
    StudentRepo studentRepo;
    PaymentRepo paymentRepo;
    InstructorRepo instructorRepo;
    CourseRepo courseRepo;

    public Initialize(AdminRepo adminRepo, AssignmentRepo assignmentRepo, StudentRepo studentRepo,
                    PaymentRepo paymentRepo,
            InstructorRepo instructorRepo, CourseRepo courseRepo) {
        this.adminRepo = adminRepo;
        this.assignmentRepo = assignmentRepo;
        this.studentRepo = studentRepo;
        this.paymentRepo = paymentRepo;
        this.instructorRepo = instructorRepo;
        this.courseRepo = courseRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        // Students
        studentRepo.save(
                new Student("Bob", "password", "student", "Bob", "Smith", "bob.smith@school.com",
                        "343-222-2222",
                        "123 test st", "napanee", "ontario", "k3e3e3", "Canada", null,
                                        null));

        studentRepo.save(new Student("Alice", "password", "student", "Alice", "Johnson", "alice.johnson@school.com",
                "555-111-1111", "456 Main St", "Springfield", "Illinois", "62701", "USA",
                        null, null));

        studentRepo.save(new Student("Charlie", "password", "student", "Charlie", "Brown", "charlie.brown@school.com",
                "555-222-2222", "789 Oak St", "Rivertown", "Mississippi", "12345", "USA",
                        null, null));
        //instructor
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

        // Assignments
        assignmentRepo.save(new Assignment("#Make a flowchart", "System Flowcharts", "2023-12-06", null,
                        courseRepo.findCourseById(1), null));
        assignmentRepo.save(new Assignment("#Math test", "Math test", "2023-12-06", null, courseRepo.findCourseById(1),
                        null));
        assignmentRepo.save(new Assignment("PHYS201_A1", "Introduction to Mechanics", "2023-09-07", null,
                        courseRepo.findCourseById(2), null));
        assignmentRepo.save(new Assignment("PHYS201_A2", "Introduction to Thermodynamics", "2023-09-12", null,
                        courseRepo.findCourseById(2), null));
        assignmentRepo.save(new Assignment("ENG101_E1", "Persuasive Essay", "2023-09-12", null,
                        courseRepo.findCourseById(3), null));
        assignmentRepo.save(new Assignment("ENG101_E2", "Research Paper", "2023-09-17", null, courseRepo.findCourseById(3),
                        null));
        assignmentRepo.save(new Assignment("HIST202_H1", "Ancient Civilizations Research Paper", "2023-09-17", null,
                        courseRepo.findCourseById(4), null));
        assignmentRepo.save(new Assignment("HIST202_H2", "World War II Research Paper", "2023-09-22", null,
                        courseRepo.findCourseById(4), null));
        assignmentRepo.save(new Assignment("CS301_P1", "Dynamic Programming Exercise", "2023-09-22", null,
                        courseRepo.findCourseById(5), null));
        assignmentRepo.save(new Assignment("CS301_P2", "Algorithms Exercise", "2023-09-27", null,
                        courseRepo.findCourseById(5), null));

        // Admin
        adminRepo.save(new Admin("Boss", "coolboss", "admin", "Barrie", "Responsible",
                "cool.boss@coursemaster.com",
                "343-987-3645", "over the rainbow", "nowhere", "ontario", "k3e3e3",
                        "Canada"));


        // Payment
        Payment payment = new Payment(studentRepo.findStudentById(1), 100, 1, "Bob", "Smith");
        paymentRepo.save(payment);
        paymentRepo.save(new Payment(studentRepo.findStudentById(2), 20000, 1,
                        "Alice", "Johnson"));
        paymentRepo.save(new Payment(studentRepo.findStudentById(3), 0, 0,
                        "Charlie", "Brown"));


        Student bob = studentRepo.findStudentById(1);
        Student alice = studentRepo.findStudentById(2);
        Student charlie = studentRepo.findStudentById(3);

        Instructor charles = instructorRepo.findById(4);


        bob.setCourses(courseRepo.findCourseByStudent_Id(1));
        bob.setPayments(Arrays.asList(paymentRepo.findPaymentByStudentId(1)));


        alice.setCourses(courseRepo.findCourseByStudent_Id(2));
        alice.setPayments(Arrays.asList(paymentRepo.findPaymentByStudentId(2)));


        charlie.setCourses(courseRepo.findCourseByStudent_Id(3));
        charlie.setPayments(Arrays.asList(paymentRepo.findPaymentByStudentId(3)));
        studentRepo.save(bob);
        studentRepo.save(alice);
        studentRepo.save(charlie);

        charles.setCourses(Arrays.asList(courseRepo.findCourseById(1), courseRepo.findCourseById(2),courseRepo.findCourseById(3),courseRepo.findCourseById(4)));
        instructorRepo.save(charles);
    }
}
