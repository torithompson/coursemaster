package comp31.coursemaster.model.repos;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import comp31.coursemaster.model.entities.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
    @Query("SELECT u.id FROM User u WHERE u.username = :username")
    Integer findIdByUsername(@Param("username") String username);

    @Query("SELECT u.permissions FROM User u WHERE u.username = :username")
    String findPermissionsByUsername(String username);
}
