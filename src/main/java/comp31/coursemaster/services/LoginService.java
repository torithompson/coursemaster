package comp31.coursemaster.services;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import comp31.coursemaster.model.entities.User;
import lombok.NoArgsConstructor;

/*
 * LoginService 
 * Validates login credentials and returns the appropriate view
 * Completed by Tori Thompson
 */
@Service
@NoArgsConstructor
public class LoginService {

    public String login(String username, User user, Model model) {
        if (username.equals("admin") && user.getPassword().equals("password"))
            return "admin";
        else if (username.equals("student") && user.getPassword().equals("password"))
            return "student";
        else if (username.equals("instructor") && user.getPassword().equals("password"))
            return "instructor";
        else
            return "login";
    }
}
