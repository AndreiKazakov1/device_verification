package by.iba.kazakov.device_verification.controllers.verifier;

import by.iba.kazakov.device_verification.models.*;
import by.iba.kazakov.device_verification.services.serviceInterfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.Set;

@Controller
public class VerUnfo {


    @Autowired
    VerifierService verifierService;





    @Autowired
    UserService userService;


    @GetMapping({"/verifier/verInfo"})
    public String addDeviceInVerification (Model model, Principal principal) {

        String name = principal.getName();
        Long id = userService.findByName(name);
        Verifier verifier = verifierService.findByUserId(id);
        System.out.println(verifier.getVerifierFirstName());
        model.addAttribute("verifier", verifier );

        return "verifier/verInfo";
    }



}
