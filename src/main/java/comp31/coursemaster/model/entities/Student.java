package comp31.coursemaster.model.entities;

import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Student extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    List<Course> courses;
    List<Grade> grades;
    List<Payment> payments;

    public Student(String username, String password, List<String> permissions,
            String firstName, String lastName, String email, String phoneNumber,
            String address, String city, String province, String postalCode, String country,
            List<Course> courses, List<Grade> grades, List<Payment> payments) {
        super(username, password, permissions, firstName, lastName, email, phoneNumber,
                address, city, province, postalCode, country);
    }
}
