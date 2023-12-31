//Author: Emma Lavigne

package comp31.coursemaster.model.entities;

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
    Integer id;

    public Admin(String username, String password, String permissions, String firstName,
            String lastName,
            String email, String phoneNumber, String address, String city, String province, String postalCode,
            String country) {
        super(username, password, permissions, firstName, lastName, email, phoneNumber, address, city, province,
                postalCode, country);
    }

}
