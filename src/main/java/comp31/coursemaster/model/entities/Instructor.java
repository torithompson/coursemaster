package comp31.coursemaster.model.entities;

import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

// Ethan Watson

@Entity
@EqualsAndHashCode(callSuper = false)
@Data
@NoArgsConstructor
public class Instructor extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instructor_id")
    Integer id;

    @OneToMany(mappedBy = "instructor")
    private List<Course> courses;

    // instructor constructor
    public Instructor(String username, String password, String permissions,
            String firstName, String lastName, String email, String phoneNumber,
            String address, String city, String province, String postalCode,
            String country, List<Course> courses) {
        super(username, password, permissions, firstName, lastName, email, phoneNumber,
                address, city, province, postalCode, country);
    }
}
