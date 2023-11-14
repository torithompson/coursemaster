package comp31.coursemaster.model.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
public class Admin extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer Id;
    public Admin(String username, String password, List<String> permissions, String firstName, String lastName,
            String email, String phoneNumber, String address, String city, String province, String postalCode,
            String country, Integer Id) {
        super(username, password, permissions, firstName, lastName, email, phoneNumber, address, city, province,
                postalCode, country);

    }

}
