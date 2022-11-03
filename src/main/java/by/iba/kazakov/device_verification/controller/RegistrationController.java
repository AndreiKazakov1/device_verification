package by.iba.kazakov.device_verification.controller;


import by.iba.kazakov.device_verification.models.MeasurementType;
import by.iba.kazakov.device_verification.models.User;
import by.iba.kazakov.device_verification.models.Verifier;
import by.iba.kazakov.device_verification.services.serviceInterfaces.UserService;
import by.iba.kazakov.device_verification.services.serviceInterfaces.VerifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {
    @Autowired
    UserService userService;
    @Autowired
    VerifierService verifierService;

    @RequestMapping({"/verifierRegistrationForm"})
    public String newVerifierForm (Model model) {
        return "signin/verifierRegistrationForm";
    }


    @GetMapping({"/newVerifierRegistration"})
    public String newVerifierRegistration (Model model) {
        model.addAttribute("newVerifierRegistration", new Verifier());
        return "signin/verifierRegistrationForm";
    }
    @Transactional
    @PostMapping("/newVerifierRegistration")
    public String addNewUserReg(@Validated String userLogin, @Validated String userPassword, Verifier verifier){
        String role = "verifier";
        User user = new User();
        user.setLogin(userLogin);
        user.setPassword(userPassword);
        user.setRole(role);
        userService.save(user);
        verifier.setIdUser(user);
        verifierService.save(verifier);
        return "sigin/newVerifierRegistrationSubmit";

    }



    @RequestMapping(value = {"/newVerifierRegistrationSubmit"}, method = RequestMethod.GET)
    public String submitMeasType(Model model) {
        return "sign/newVerifierRegistrationSubmit";
    }

}
