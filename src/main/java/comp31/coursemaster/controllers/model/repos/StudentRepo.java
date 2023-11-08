package comp31.coursemaster.controllers.model.repos;

import org.springframework.data.repository.CrudRepository;

import comp31.coursemaster.controllers.model.entities.Student;

public interface StudentRepo extends CrudRepository<comp31.coursemaster.controllers.model.entities.Student,Integer>{
    public Student getStudentById(int id);
    public Student updateStudent(Student student);
    public int getGradeById(int id);
    public int getGradesForStudent(int id);
}
