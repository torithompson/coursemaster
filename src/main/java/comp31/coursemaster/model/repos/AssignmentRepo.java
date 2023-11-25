package comp31.coursemaster.model.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import comp31.coursemaster.model.entities.Assignment;

// Trevor Withers
@Repository
public interface AssignmentRepo extends CrudRepository<Assignment, Integer> {
    public List<Assignment> findAssignmentByCourseId(Integer id);
}
