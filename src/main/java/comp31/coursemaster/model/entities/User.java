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
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String username;
    String password;
    List<String> permissions;
    String firstName;
    String lastName;
    String email;
    String phoneNumber;
    String address;
    String city;
    String province;
    String postalCode;
    String country;

    public User(String username, String password, List<String> permissions, String firstName, String lastName,
            String email, String phoneNumber, String address, String city, String province, String postalCode,
            String country) {
        this.username = username;
        this.password = password;
        this.permissions = permissions;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
        this.country = country;
    }
}
