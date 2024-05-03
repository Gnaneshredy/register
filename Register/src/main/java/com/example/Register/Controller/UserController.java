package com.example.Register.Controller;//package com.example.Register.Controller;
//
//import com.example.Register.entity.UserLogin;
//import com.example.Register.repository.UserLoginRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UserController {
//
//    private final UserLoginRepository userLoginRepository;
//
//    @Autowired
//    public UserController(UserLoginRepository userLoginRepository) {
//        this.userLoginRepository = userLoginRepository;
//    }
//
//    public List<UserLogin> getAllUsers() {
//        return userLoginRepository.findAll();
//    }
//
//    public UserLogin getUserById(Long id) {
//        Optional<UserLogin> userOptional = userLoginRepository.findById(id);
//        return userOptional.orElse(null);
//    }
//
//    public UserLogin createUser(UserLogin user) {
//        return userLoginRepository.save(user);
//    }
//
//    public UserLogin updateUser(Long id, UserLogin userDetails) {
//        Optional<UserLogin> userOptional = userLoginRepository.findById(id);
//        if (userOptional.isPresent()) {
//            UserLogin user = userOptional.get();
//            user.setName(userDetails.getName());
//            user.setEmail(userDetails.getEmail());
//            user.setPassword(userDetails.getPassword());
//            return userLoginRepository.save(user);
//        }
//        return null;
//    }
//
//    public void deleteUser(Long id) {
//        userLoginRepository.deleteById(id);
//    }
//}
//
import com.example.Register.entity.UserLogin;
import com.example.Register.repository.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    private final UserLoginRepository userLoginRepository;

    @Autowired
    public UserController(UserLoginRepository userLoginRepository) {
        this.userLoginRepository = userLoginRepository;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login"; // Returns the name of the HTML login file (login.html)
    }

    @PostMapping("/login")
    public String processLoginForm(@RequestParam("email") String email,
                                   @RequestParam("password") String password,
                                   Model model) {
        // Check if the email and password match a user in the database
        UserLogin user = userLoginRepository.findByEmailAndPassword(email, password);
        if (user != null) {
            // Login successful, redirect to a success page or perform other actions
            return "redirect:/success"; // Redirect to a success page
        } else {
            // Login failed, display an error message
            model.addAttribute("error", "Invalid email or password. Please try again.");
            return "login"; // Return to the login form with an error message
        }
    }

    // Other methods (getAllUsers, getUserById, createUser, updateUser, deleteUser) remain unchanged
}

