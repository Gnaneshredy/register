package com.example.Register.Controller;
import com.example.Register.entity.UserLogin;
import com.example.Register.repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegistrationController {

    @Autowired
    private UserLoginRepository userLoginRepository;

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register"; // Returns the name of the HTML registration file (register.html)
    }

    @PostMapping("/register")
    @ResponseBody
    public String processRegistrationForm(@RequestParam("name") String name,
                                          @RequestParam("email") String email,
                                          @RequestParam("password") String password) {
        // Create a new user with the provided information
        UserLogin newUser = new UserLogin();
        newUser.setName(name);
        newUser.setEmail(email);
        newUser.setPassword(password);

        // Save the new user to the database
        userLoginRepository.save(newUser);

        return "User registered successfully!";
    }
}
