package by.iba.kazakov.device_verification.controller;

import by.iba.kazakov.device_verification.models.MeasurementType;
import by.iba.kazakov.device_verification.models.User;
import by.iba.kazakov.device_verification.models.Verifier;
import by.iba.kazakov.device_verification.services.serviceInterfaces.UserService;
import by.iba.kazakov.device_verification.services.serviceInterfaces.VerifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationAdminController {
    @Autowired
    VerifierService verifierService;
    @Autowired
    UserService userService;

    @RequestMapping({"/addNewVerifierAdm"})
    public String addNewVerifierForm(Model model) {
        return "admin/addNewVerifierAdm";
    }


    @GetMapping({"/addNewVerifierAdm"})
    public String addNewVerifier (Model model) {
       model.addAttribute("addNewVerifierAdm", new User());
        model.addAttribute("addNewVerifierAdm", new Verifier());
        return "admin/addNewVerifierAdm";
    }


    @PostMapping("/addNewVerifierAdm")
    public String saveNewVerifierAdm (Model model, Verifier verifier, User user){
        userService.save(user);
        verifierService.save(verifier);
        return "admin/addNewVerifierAdmSubmit";
    }

    @RequestMapping(value = {"/addNewVerifierAdmSubmit"}, method = RequestMethod.GET)
    public String submitMeasType(Model model) {
        return "admin/addNewVerifierAdmSubmit";
    }

}
