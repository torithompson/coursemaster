package comp31.coursemaster.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Admin extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    Integer empNumber;

    public Admin(Integer empNumber) {
        this.empNumber = empNumber;
    }
}
