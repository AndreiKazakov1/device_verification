package by.iba.kazakov.device_verification.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login(Model model){
        return "signin/signinPage";
    }

    @GetMapping ("/logout")
    public String returnToLogin(){
        return "signin/logoutPage";
    }
}
