package comp31.coursemaster.model.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import comp31.coursemaster.model.entities.Grade;

public interface GradeRepo extends CrudRepository<Grade, Integer> {

    public List<Grade> findAll();

    public Integer findByStudentId(Integer studentId);
}
