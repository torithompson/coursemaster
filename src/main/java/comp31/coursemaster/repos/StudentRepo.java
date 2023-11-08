package comp31.coursemaster.repos;

import org.springframework.data.repository.CrudRepository;

import comp31.coursemaster.models.Student;
import lombok.NoArgsConstructor;

public interface StudentRepo extends CrudRepository<Student,Integer>{
    public Student getStudentById(int id);
    public Student updateStudent(Student student);
    public int getGradeById(int id);
    public int getGradesForStudent(int id);
}
