package comp31.coursemaster.model.repos;



import org.springframework.data.repository.CrudRepository;

import comp31.coursemaster.model.entities.Instructor;

public interface InstructorRepo extends CrudRepository<Instructor, Integer> {
    public Instructor findInstructorById(int id);

}
