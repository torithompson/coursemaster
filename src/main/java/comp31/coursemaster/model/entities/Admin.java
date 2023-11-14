package comp31.coursemaster.model.entities;

import java.util.List;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Admin extends User {

    Integer empNumber;

    public Admin(Integer empNumber, String username, String password, List<String> permissions, String firstName, String lastName,
            String email, String phoneNumber, String address, String city, String province, String postalCode,
            String country) {
        super(username, password, permissions, firstName, lastName, email, phoneNumber, address, city, province,
                postalCode, country);
        this.empNumber = empNumber;
    }

}
