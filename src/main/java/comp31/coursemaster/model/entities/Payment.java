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
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer Id;
    Integer studentId;
    Integer amountOwed;
    Integer PaymentStatus;

    public Payment(Integer studentId, Integer amountOwed, Integer paymentStatus) {
        this.studentId = studentId;
        this.amountOwed = amountOwed;
        PaymentStatus = paymentStatus;
    }

}
