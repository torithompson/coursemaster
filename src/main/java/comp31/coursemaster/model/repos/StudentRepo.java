package comp31.coursemaster.model.repos;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import comp31.coursemaster.model.entities.Student;

@Repository
public interface StudentRepo extends CrudRepository<Student, Integer> {
    public List<Student> findAll();

    public Student findStudentById(int id);

    public int findGradeById(int id);

}
