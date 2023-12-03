//Author: Emma Lavigne

package comp31.coursemaster.services;

import org.springframework.stereotype.Service;

import comp31.coursemaster.model.entities.Admin;
import comp31.coursemaster.model.entities.User;
import comp31.coursemaster.model.repos.AdminRepo;
import comp31.coursemaster.model.repos.UserRepo;

@Service
public class AdminService {
    AdminRepo adminRepo;
    UserRepo userRepo;

    public AdminService(AdminRepo adminRepo, UserRepo userRepo) {
        this.adminRepo = adminRepo;
        this.userRepo = userRepo;
    }

    // creates new user account
    public void addUser(
        String username, 
        String password, 
        String permissions,
        String firstName,
        String lastName, 
        String email, 
        String phoneNumber, 
        String address, 
        String city, 
        String province, 
        String postalCode,
        String country) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setPermissions(permissions);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setAddress(address);
        user.setCity(city);
        user.setProvince(province);
        user.setPostalCode(postalCode);
        user.setCountry(country);
        userRepo.save(user);
    }

    public void addUser(User user) {
        userRepo.save(user);
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

    public Iterable<User> findUsers() {
        return userRepo.findAll();
    }
    
}
