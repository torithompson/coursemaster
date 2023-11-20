package comp31.coursemaster.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    Instructor instructor;

    public Course(String name, String description, Instructor instructor, String startDate) {
        this.name = name;
        this.description = description;
        this.instructor = instructor;
        this.startDate = startDate;
    }

}
