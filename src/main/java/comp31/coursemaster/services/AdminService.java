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
    public void addAdmin(
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
            Admin admin = new Admin();
            admin.setUsername(username);
            admin.setPassword(password);
            admin.setPermissions(permissions);
            admin.setFirstName(firstName);
            admin.setLastName(lastName);
            admin.setEmail(email);
            admin.setPhoneNumber(phoneNumber);
            admin.setAddress(address);
            admin.setCity(city);
            admin.setProvince(province);
            admin.setPostalCode(postalCode);
            admin.setCountry(country);
            adminRepo.save(admin);
    }

    public void addAdmin(Admin admin) {
        adminRepo.save(admin);
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
