package comp31.coursemaster.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "PAYMENT")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    Integer payment_id;
    Integer amountOwed;
    Integer PaymentStatus;
    String firstName;
    String lastName;

    @ManyToOne
    @JoinColumn(name = "student_id")
    Student student;

    public Payment(Student studentId, Integer amountOwed, Integer paymentStatus, String firstName, String lastName) {
        this.student = studentId;
        this.amountOwed = amountOwed;
        PaymentStatus = paymentStatus;
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
