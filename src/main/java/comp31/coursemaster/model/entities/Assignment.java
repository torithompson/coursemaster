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
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer id;
    String name;
    String description;
    String dueDate;
    String grade;
    String student;
    String path;

    @ManyToOne
    @JoinColumn(name = "course_id")
    Course course;
    @ManyToOne
    Instructor instructor;

    public Assignment(String name, String description, String dueDate, String grade, Course course, Student student,
            String path) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.grade = grade;
        this.course = course;
        this.student = student.toString();
        this.path = path;
    }
}
