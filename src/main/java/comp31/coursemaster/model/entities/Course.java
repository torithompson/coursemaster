package comp31.coursemaster.model.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

//Tori Thompson/Trevor Withers/Ethan Watson
@Entity
@Data
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    Integer id;
    @Column(name = "course_name")
    String name;
    String description;
    String startDate;

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @ManyToMany
    private List<Student> student;

    @OneToMany(mappedBy = "course")
    private List<Assignment> assignments;

    public Course(String name, String description, Instructor instructor, List<Student> students, String startDate,
            List<Assignment> assignment) {
        this.name = name;
        this.description = description;
        this.instructor = instructor;
        this.startDate = startDate;
        this.student = students;
        this.assignments = assignment;
    }

}
