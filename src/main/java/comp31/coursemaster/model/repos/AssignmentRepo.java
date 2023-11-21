package comp31.coursemaster.model.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import comp31.coursemaster.model.entities.Assignment;

public interface AssignmentRepo extends CrudRepository<Assignment, Integer> {
    public List<Assignment> findAssignmentByCourseId(Integer id);
}
