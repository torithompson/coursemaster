package comp31.coursemaster.model.entities;



import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@MappedSuperclass
@EqualsAndHashCode(callSuper = false)
public class User {
    String username;
    String password;
    String permissions;
    String firstName;
    String lastName;
    String email;
    String phoneNumber;
    String address;
    String city;
    String province;
    String postalCode;
    String country;

    public User(String username, String password, String permission, String firstName, String lastName,
            String email, String phoneNumber, String address, String city, String province, String postalCode,
            String country) {
        this.username = username;
        this.password = password;
        this.permissions = permission;
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
