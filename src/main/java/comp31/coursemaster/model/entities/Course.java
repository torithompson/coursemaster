package comp31.coursemaster.model.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
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

    @ManyToMany
    @JoinColumn(name = "student_id")
    List<Student> students;

    public Course(String name, String description, Instructor instructor, List<Student> students, String startDate) {
        this.name = name;
        this.description = description;
        this.instructor = instructor;
        this.startDate = startDate;
        this.students = students;
    }

}
