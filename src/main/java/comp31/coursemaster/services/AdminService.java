package comp31.coursemaster.services;

import org.springframework.stereotype.Service;

import comp31.coursemaster.model.entities.User;

@Service
public class AdminService {
    
    //creates new user account with administrative privileges 
    public void createUser() {

    }

    //removes a user account from the system
    public void deleteUser(User user) {

    }

    //updates the privileges of a user; add or revoke admin access 
    public void modifyPermissions(User user, String perm) {

    }
    
}
