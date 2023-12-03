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

//Trevor Withers
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
    String path;

    @ManyToOne
    @JoinColumn(name = "course_name")
    private Course course;

    // @ManyToOne
    // @JoinColumn(name = "instructor_id")
    // private Instructor instructor;

    public Assignment(String name, String description, String dueDate, String grade, Course course,
            String path) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.grade = grade;
        this.course = course;
        this.path = path;
        // this.instructor = instructor;
    }
}
