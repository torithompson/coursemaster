package comp31.coursemaster.services;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

    public LoginService() {
    }

    public String login(String username, String password) {
        if (username.equals("admin") && password.equals("password"))
            return "admin";
        else if (username.equals("student") && password.equals("password"))
            return "student";
        else if (username.equals("instructor") && password.equals("password"))
            return "instructor";
        else
            return "invalid";
    }
}
