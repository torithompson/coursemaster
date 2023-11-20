package comp31.coursemaster.model.repos;

import org.springframework.data.repository.CrudRepository;

import comp31.coursemaster.model.entities.Course;

public interface CourseRepo extends CrudRepository<Course, Integer> {

}
