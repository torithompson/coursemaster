package comp31.coursemaster.services;

import org.springframework.stereotype.Service;

import comp31.coursemaster.model.entities.Admin;
import comp31.coursemaster.model.entities.User;
import comp31.coursemaster.model.repos.AdminRepo;

@Service
public class AdminService {
    AdminRepo adminRepo;

    public AdminService(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }

    //creates new user account with administrative privileges 
    public void createUser() {

    }

    //removes a user account from the system
    public void deleteUser(User user) {

    }

    //updates the privileges of a user; add or revoke admin access 
    public void modifyPermissions(User user, String perm) {

    }

    public Iterable<Admin> findAdmins() {
        return adminRepo.findAll();
    }
    
}
