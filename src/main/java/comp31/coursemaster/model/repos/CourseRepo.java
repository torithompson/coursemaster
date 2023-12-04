package comp31.coursemaster.model.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import comp31.coursemaster.model.entities.Course;

//Ethan Watson
@Repository
public interface CourseRepo extends CrudRepository<Course, Integer> {

    public List<Course> findAll();

    public Course findCourseById(Integer id);

    @Query("Select name from Course where id = :id")
    public String findNameById(Integer id);

    public List<Course> findCourseByStudent_Id(Integer student_Id);

    public Course findCourseByName(String name);

    public List<Course> findCourseByInstructorId(Integer instructor_id);
}
