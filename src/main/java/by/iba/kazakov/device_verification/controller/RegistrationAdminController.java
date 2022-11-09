package by.iba.kazakov.device_verification.controller;

import by.iba.kazakov.device_verification.models.Client;
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

import java.util.Set;

@Controller
public class RegistrationAdminController {

    @Autowired
    UserService userService;

    @Autowired
    VerifierService verifierService;


   /* @RequestMapping({"/addNewVerifierAdm"})
    public String addNewVerifierForm(Model model) {
        return "admin/addNewVerifierAdm";
    }*/


    @GetMapping({"/addNewVerifierAdm"})
    public String addNewVerifier (Model model) {
        model.addAttribute("addNewVerifierAdm", new Verifier());
        return "admin/addNewVerifierAdm";
    }
    @Transactional
    @PostMapping("/addNewVerifierAdm")
    public String addNewUser(@Validated String userLogin, @Validated String userPassword, Verifier verifier){
            //String role = "verifier";
            User user = new User();
            user.setUsername(userLogin);
            user.setPassword(userPassword);
           // user.setRole(role);
            userService.save(user);
            verifier.setIdUser(user);
            verifierService.save(verifier);
        return "admin/addNewVerifierAdmSubmit";

    }


    @RequestMapping(value = {"/addNewVerifierAdmSubmit"}, method = RequestMethod.GET)
    public String submitMeasType(Model model) {
        return "admin/addNewVerifierAdmSubmit";
    }

    @RequestMapping({"/showAllVerifiers"})
    public String showAllVerifiers(Model model) {
        Set<Verifier> verifiers = verifierService.findAll();
        model.addAttribute("verifiers", verifiers);
        return "admin/showAllVerifiers";


    }


}
