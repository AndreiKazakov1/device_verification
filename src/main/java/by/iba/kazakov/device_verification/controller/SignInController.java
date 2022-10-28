package by.iba.kazakov.device_verification.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class SignInController {
    @RequestMapping(value = {"/signin"}, method = RequestMethod.GET)
    public String signIn(Model model){
        return "signin/signinTemplate";
    }

    @RequestMapping(value = {"/registrationChoice"}, method = RequestMethod.GET)
    public String registrationChoice(Model model){
        return "signin/registrationChoice";
    }
}




