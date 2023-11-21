package comp31.coursemaster.model.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import comp31.coursemaster.model.entities.Course;

public interface CourseRepo extends CrudRepository<Course, Integer> {

    public List<Course> findAll();

    public Course findCourseById(Integer id);

    public Course findCourseByName(String name);
}
