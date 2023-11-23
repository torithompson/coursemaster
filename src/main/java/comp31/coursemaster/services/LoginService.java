package comp31.coursemaster.services;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import comp31.coursemaster.model.entities.User;

/*
 * LoginService 
 * Validates login credentials and returns the appropriate view
 * Completed by Tori Thompson
 */
@Service
public class LoginService {
    UserService userService;

    public LoginService(UserService userService) {
        this.userService = userService;
    }

    public String login(String username, User user, Model model) {
        Integer id = userService.findUserIdByUserName(username);
        // String permission = userService.findPermissionsByUsername(username);
        if (username.equals("admin") && user.getPassword().equals("password")) {
            return "redirect:/admin?id=" + id;

        } else if (username.equals("student") && user.getPassword().equals("password")) {
            return "redirect:/student?id=" + id;
        } else if (username.equals("instructor") && user.getPassword().equals("password")){
            return "redirect:/instructor?id=" + id;
        } else
            return "login";
    }
}
