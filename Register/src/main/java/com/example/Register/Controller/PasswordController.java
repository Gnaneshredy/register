package com.example.Register.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PasswordController {

    @GetMapping("/forgot-password")
    public String showForgotPasswordForm() {
        return "forgot-password"; // Returns the name of the HTML forgot password file (forgot-password.html)
    }

    @PostMapping("/forgot-password")
    @ResponseBody
    public String processForgotPasswordForm(@RequestParam("email") String email) {
        // Implement logic to handle the forgot password form submission
        // Send password reset instructions to the provided email address
        return "Password reset instructions sent to your email"; // Message to display on the webpage
    }

    @GetMapping("/reset-password")
    public String showResetPasswordForm() {
        return "reset-password"; // Returns the name of the HTML reset password file (reset-password.html)
    }

    @PostMapping("/reset-password")
    @ResponseBody
    public String processResetPasswordForm(@RequestParam("email") String email,
                                           @RequestParam("password") String password) {
        // Implement logic to handle the reset password form submission
        // Reset the password for the user with the provided email address
        return "Password reset successful"; // Message to display on the webpage
    }
}
