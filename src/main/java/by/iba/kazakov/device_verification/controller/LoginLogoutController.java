package by.iba.kazakov.device_verification.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginLogoutController {

    @GetMapping("/login")
    public String login(Model model){
        return "signin/signinPage";
    }

    @GetMapping ("/logout")
    public String returnToLogin(){
        return "signin/logoutPage";
    }
}
