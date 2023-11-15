package comp31.coursemaster.model.repos;

import org.springframework.data.repository.CrudRepository;

import comp31.coursemaster.model.entities.Student;

public interface StudentRepo extends CrudRepository<Student, Integer> {
    public Student getStudentById(int id);

    public int getGradeById(int id);

}
