package comp31.coursemaster.model.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import comp31.coursemaster.model.entities.Instructor;

// Ethan Watson

@Repository
public interface InstructorRepo extends CrudRepository<Instructor, Integer> {
    // find instructor by passed id
    public Instructor findById(int id);

    // find all instructors
    public List<Instructor> findAll();

}
