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
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
public class Student extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    List<Course> courses;
    List<Grade> grades;
    List<Payment> payments;

    public Student(List<Course> courses, List<Grade> grades, List<Payment> payments) {
        super();
        this.courses = courses;
        this.grades = grades;
        this.payments = payments;
    }
}
