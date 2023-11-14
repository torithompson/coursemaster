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
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer Id;
    public Grade(String string) {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer Id;
    Integer Grade;
    Integer courseId;
    String Feedback;
    Integer studentId;

    public Grade(Integer grade, Integer courseId, String feedback, Integer studentId) {
        Grade = grade;
        this.courseId = courseId;
        Feedback = feedback;
        this.studentId = studentId;
    }



}
