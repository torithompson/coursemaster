package comp31.coursemaster.model.entities;

import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "student")
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
public class Student extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    Integer id;
    @OneToMany(mappedBy = "student")
    List<Grade> grades;

    @OneToMany(mappedBy = "student")
    List<Payment> payments;

    public Student(String username, String password, String permissions,
            String firstName, String lastName, String email, String phoneNumber,
            String address, String city, String province, String postalCode, String country, List<Grade> grades,
            List<Payment> payments) {
        super(username, password, permissions, firstName, lastName, email, phoneNumber, address, city, province, postalCode, country);
    }
}
