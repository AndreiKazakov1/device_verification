package by.iba.kazakov.device_verification.controller;

import by.iba.kazakov.device_verification.services.serviceInterfaces.UserService;
import by.iba.kazakov.device_verification.services.serviceInterfaces.VerifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationAdminController {
    @Autowired
    VerifierService verifierService;
    UserService userService;

    @RequestMapping({"/verifierRegistrationFormAdm"})
    public String addNewVerifier (Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("verifierRegistrationFormAdm");
        return "admin/verifierRegistrationFormAdm";
    }
}
