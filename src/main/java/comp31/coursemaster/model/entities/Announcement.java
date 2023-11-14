package comp31.coursemaster.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String title;
    String body;
    String date;
    // Course course;

    public Announcement(String title, String body, String date) {
        this.title = title;
        this.body = body;
        this.date = date;
        // this.course = course;
    }
}
