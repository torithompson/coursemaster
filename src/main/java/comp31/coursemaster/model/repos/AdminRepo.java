//Author: Emma Lavigne

package comp31.coursemaster.model.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import comp31.coursemaster.model.entities.Admin;

@Repository
public interface AdminRepo extends CrudRepository<Admin, Integer>{

    public Admin findAdminById(Integer id);

}
