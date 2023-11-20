package comp31.coursemaster;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import comp31.coursemaster.model.entities.Admin;
import comp31.coursemaster.model.entities.Course;
import comp31.coursemaster.model.entities.Grade;
import comp31.coursemaster.model.entities.Instructor;
import comp31.coursemaster.model.entities.Payment;
import comp31.coursemaster.model.entities.Student;
import comp31.coursemaster.model.repos.AdminRepo;
import comp31.coursemaster.model.repos.CourseRepo;
import comp31.coursemaster.model.repos.InstructorRepo;
import comp31.coursemaster.model.repos.PaymentRepo;
import comp31.coursemaster.model.repos.StudentRepo;

@Component
public class Initialize implements CommandLineRunner {
    AdminRepo adminRepo;
    StudentRepo studentRepo;
    PaymentRepo paymentRepo;
    CourseRepo courseRepo;
    InstructorRepo instructorRepo;

    public Initialize(AdminRepo adminRepo, StudentRepo studentRepo, PaymentRepo paymentRepo,
            CourseRepo courseRepo, InstructorRepo instructorRepo) {
        this.adminRepo = adminRepo;
        this.studentRepo = studentRepo;
        this.paymentRepo = paymentRepo;
        this.courseRepo = courseRepo;
        this.instructorRepo = instructorRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        // Add your initialization code here

        // Course mathCourse = new Course("Math", "College math", "2021-09-01");
        Grade mathGrade = new Grade(90, 5, "Feedback feedback", null);
        Payment payment = new Payment(studentRepo.getStudentById(1), 100, 1, "Bob", "Smith");

        // List<Course> courses = Arrays.asList(mathCourse);
        List<Grade> grades = Arrays.asList(mathGrade);
        // List<Payment> payments = Arrays.asList(payment);
        studentRepo.save(
                new Student("Bob", "password", "student", "Bob", "Smith", "bob.smith@school.com",
                        "343-222-2222",
                        "123 test st", "napanee", "ontario", "k3e3e3", "Canada", grades, null));
        // courses
        // Payment
        paymentRepo.save(payment);
        paymentRepo.save(new Payment(studentRepo.getStudentById(2), 20000, 1, "Charles", "Cuthbert"));
        paymentRepo.save(new Payment(studentRepo.getStudentById(3), 0, 0, "Jermaine", "Jerm"));
        paymentRepo.save(new Payment(studentRepo.getStudentById(4), -780, 1, "David", "Dudeson"));

        adminRepo.save(
                new Admin(1, "Boss", "coolboss", "admin", "Barrie", "Responsible", "cool.boss@coursemaster.com",
                        "343-987-3645", "over the rainbow", "nowhere", "ontario", "k3e3e3", "Canada"));

        // Courses
        courseRepo.save(new Course("MATH101", "Introduction to Mathematics", instructorRepo.findById(1), "2023-09-01"));
        courseRepo.save(new Course("PHYS201", "Physics for Engineers", instructorRepo.findById(2), "2023-09-05"));
        courseRepo.save(new Course("ENG101", "English Composition", instructorRepo.findById(3), "2023-09-10"));
        courseRepo.save(new Course("HIST202", "World History II", instructorRepo.findById(4), "2023-09-15"));
        courseRepo.save(new Course("CS301", "Advanced Algorithms", instructorRepo.findById(5), "2023-09-20"));

        // Instructor
        instructorRepo.save(new Instructor(""));
    }
}
