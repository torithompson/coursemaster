package comp31.coursemaster.model.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Assignment {
    Integer id;
    String name;
    String description;
    String dueDate;
    String grade;
    Course course;
    Student student;

    public Assignment(String name, String description, String dueDate, String grade, Course course, Student student) {
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.grade = grade;
        this.course = course;
        this.student = student;
    }
}
