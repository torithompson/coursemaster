package comp31.coursemaster.model.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import comp31.coursemaster.model.entities.Course;
import comp31.coursemaster.model.entities.Instructor;

public interface InstructorRepo extends CrudRepository<Instructor, Integer> {
    public Instructor getInstructorById(int id);

    // public List<Course> getAllCourses();
}
