package comp31.coursemaster.model.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import comp31.coursemaster.model.entities.Instructor;

@Repository
public interface InstructorRepo extends CrudRepository<Instructor, Integer> {
    public Instructor findById(int id);

}
