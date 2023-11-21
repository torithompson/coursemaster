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
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String name;
    String description;
    String dueDate;
    String grade;
    String student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    Course course;

    public Assignment(String name, String description, String dueDate, String grade, Course course, Student student) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.grade = grade;
        this.course = course;
        this.student = student.toString();
    }
}
