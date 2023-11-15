package comp31.coursemaster.model.repos;

import org.springframework.data.repository.CrudRepository;

import comp31.coursemaster.model.entities.Admin;
import java.util.List;

public interface AdminRepo extends CrudRepository<Admin, Integer>{

    public Admin findAdminById(Integer id);

    public List<Admin> findByEmpNumber(Integer empNumber);
    
}
