package comp31.coursemaster.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_id")
    Integer grade_id;
    Integer Grade;
    Integer courseId;
    String Feedback;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Grade(Integer grade, Integer courseId, String feedback, Student studentId) {
        Grade = grade;
        this.courseId = courseId;
        Feedback = feedback;
        this.student = studentId;
    }

}
