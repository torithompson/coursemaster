package comp31.coursemaster.model.entities;

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
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String description;
    String startDate;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    Instructor instructor;

    @ManyToOne
    @JoinColumn(name = "student_id")
    Student student;

    public Course(String name, String description, Instructor instructor, Student student, String startDate) {
        this.name = name;
        this.description = description;
        this.instructor = instructor;
        this.startDate = startDate;
        this.student = student;
    }



}
