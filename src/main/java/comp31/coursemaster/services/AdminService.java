//Author: Emma Lavigne

package comp31.coursemaster.services;

import org.springframework.stereotype.Service;

import comp31.coursemaster.model.entities.Admin;
import comp31.coursemaster.model.entities.Instructor;
import comp31.coursemaster.model.entities.Student;
import comp31.coursemaster.model.entities.User;
import comp31.coursemaster.model.repos.AdminRepo;
import comp31.coursemaster.model.repos.InstructorRepo;
import comp31.coursemaster.model.repos.StudentRepo;
import comp31.coursemaster.model.repos.UserRepo;

@Service
public class AdminService {
    AdminRepo adminRepo;
    InstructorRepo instructorRepo;
    StudentRepo studentRepo;
    UserRepo userRepo;

    public AdminService(AdminRepo adminRepo, UserRepo userRepo, 
        StudentRepo studentRepo, InstructorRepo instructorRepo) {
        this.adminRepo = adminRepo;
        this.userRepo = userRepo;
        this.studentRepo = studentRepo;
        this.instructorRepo = instructorRepo;
    }

    // creates new user account
    public void addUser(
        String username, 
        String password, 
        String permissions,
        String firstName,
        String lastName, 
        String email, 
        String phoneNumber, 
        String address, 
        String city, 
        String province, 
        String postalCode,
        String country) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setPermissions(permissions);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setAddress(address);
        user.setCity(city);
        user.setProvince(province);
        user.setPostalCode(postalCode);
        user.setCountry(country);
        userRepo.save(user);
    }

    /*
    public void addUser(User user) {
        userRepo.save(user);
    }
    */
    public void addAdmin( 
        String username, 
        String password, 
        String permissions,
        String firstName,
        String lastName, 
        String email, 
        String phoneNumber, 
        String address, 
        String city, 
        String province, 
        String postalCode,
        String country) {
        Admin admin = new Admin();
        admin.setUsername(username);
        admin.setPassword(password);
        admin.setPermissions(permissions);
        admin.setFirstName(firstName);
        admin.setLastName(lastName);
        admin.setEmail(email);
        admin.setPhoneNumber(phoneNumber);
        admin.setAddress(address);
        admin.setCity(city);
        admin.setProvince(province);
        admin.setPostalCode(postalCode);
        admin.setCountry(country);
        adminRepo.save(admin);
    }

    public void addAdmin(User user) {
        Admin admin = new Admin();
        admin.setUsername(user.getUsername());
        admin.setPassword(user.getPassword());
        admin.setPermissions(user.getPermissions());
        admin.setFirstName(user.getFirstName());
        admin.setLastName(user.getLastName());
        admin.setEmail(user.getEmail());
        admin.setPhoneNumber(user.getPhoneNumber());
        admin.setAddress(user.getAddress());
        admin.setCity(user.getCity());
        admin.setProvince(user.getProvince());
        admin.setPostalCode(user.getPostalCode());
        admin.setCountry(user.getCountry());
        adminRepo.save(admin);
    }

    public void addStudent( 
        String username, 
        String password, 
        String permissions,
        String firstName,
        String lastName, 
        String email, 
        String phoneNumber, 
        String address, 
        String city, 
        String province, 
        String postalCode,
        String country) {
        Student student = new Student();
        student.setUsername(username);
        student.setPassword(password);
        student.setPermissions(permissions);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setPhoneNumber(phoneNumber);
        student.setAddress(address);
        student.setCity(city);
        student.setProvince(province);
        student.setPostalCode(postalCode);
        student.setCountry(country);
        studentRepo.save(student);
    }

    public void addStudent(User user) {
        Student student = new Student();
        student.setUsername(user.getUsername());
        student.setPassword(user.getPassword());
        student.setPermissions(user.getPermissions());
        student.setFirstName(user.getFirstName());
        student.setLastName(user.getLastName());
        student.setEmail(user.getEmail());
        student.setPhoneNumber(user.getPhoneNumber());
        student.setAddress(user.getAddress());
        student.setCity(user.getCity());
        student.setProvince(user.getProvince());
        student.setPostalCode(user.getPostalCode());
        student.setCountry(user.getCountry());
        studentRepo.save(student);
    }

    public void addInstructor( 
        String username, 
        String password, 
        String permissions,
        String firstName,
        String lastName, 
        String email, 
        String phoneNumber, 
        String address, 
        String city, 
        String province, 
        String postalCode,
        String country) {
        Instructor instructor = new Instructor();
        instructor.setUsername(username);
        instructor.setPassword(password);
        instructor.setPermissions(permissions);
        instructor.setFirstName(firstName);
        instructor.setLastName(lastName);
        instructor.setEmail(email);
        instructor.setPhoneNumber(phoneNumber);
        instructor.setAddress(address);
        instructor.setCity(city);
        instructor.setProvince(province);
        instructor.setPostalCode(postalCode);
        instructor.setCountry(country);
        instructorRepo.save(instructor);
    }

    public void addInstructor(User user) {
        Instructor instructor = new Instructor();
        instructor.setUsername(user.getUsername());
        instructor.setPassword(user.getPassword());
        instructor.setPermissions(user.getPermissions());
        instructor.setFirstName(user.getFirstName());
        instructor.setLastName(user.getLastName());
        instructor.setEmail(user.getEmail());
        instructor.setPhoneNumber(user.getPhoneNumber());
        instructor.setAddress(user.getAddress());
        instructor.setCity(user.getCity());
        instructor.setProvince(user.getProvince());
        instructor.setPostalCode(user.getPostalCode());
        instructor.setCountry(user.getCountry());
        instructorRepo.save(instructor);
    }

    //removes a user account from the system
    public void deleteUser(User user) {

    }

    //updates the privileges of a user; add or revoke admin access 
    public void modifyPermissions(User user, String perm) {

    }

    public Iterable<Admin> findAdmins() {
        return adminRepo.findAll();
    }

    public Iterable<User> findUsers() {
        return userRepo.findAll();
    }
    
}
