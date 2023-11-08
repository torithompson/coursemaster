package comp31.coursemaster.services;

import java.util.List;

import comp31.coursemaster.controllers.model.entities.Announcement;
import comp31.coursemaster.controllers.model.entities.Assignment;
import comp31.coursemaster.controllers.model.entities.Course;
import comp31.coursemaster.controllers.model.entities.Student;

public class InstructorService {
    public List<Course> GetAssignedCourses() {
        return null;
    }

    public List<Student> GetAssignedStudents() {
        return null;
    }

    public List<Announcement> GetSentAnnouncements() {
        return null;
    }

    public void CreateAnnouncement() {
        new Announcement();
    }

    public void CreateAssignment() {
        new Assignment();
    }
}
