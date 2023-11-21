package comp31.coursemaster.model.repos;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import comp31.coursemaster.model.entities.Student;

public interface StudentRepo extends CrudRepository<Student, Integer> {
    public List<Student> findAll();

    public Student getStudentById(int id);

    public int getGradeById(int id);

}
