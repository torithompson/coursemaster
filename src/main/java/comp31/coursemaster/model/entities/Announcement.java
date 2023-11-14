package comp31.coursemaster.model.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Announcement {
    String title;
    String body;
    String date;
    Course course;

    public Announcement(String title, String body, String date, Course course) {
        this.title = title;
        this.body = body;
        this.date = date;
        this.course = course;
    }
}
