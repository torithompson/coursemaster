package comp31.coursemaster.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer Id;
    Integer amountOwed;
    Boolean PaymentStatus;
    @ManyToOne
    Student student;

    public Payment(Integer id, Integer amountOwed, Boolean paymentStatus) {
        Id = id;
        this.amountOwed = amountOwed;
        PaymentStatus = paymentStatus;
    }

}
