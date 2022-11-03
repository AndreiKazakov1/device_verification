package by.iba.kazakov.device_verification.controller;


import by.iba.kazakov.device_verification.models.MeasurementType;
import by.iba.kazakov.device_verification.services.serviceInterfaces.UserService;
import by.iba.kazakov.device_verification.services.serviceInterfaces.VerifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {
    @Autowired
    VerifierService verifierService;
    UserService userService;

    @RequestMapping({"/verifierRegistrationForm"})
    public String addNewVerifier (Model model) {
        return "signin/verifierRegistrationForm";
    }


}
