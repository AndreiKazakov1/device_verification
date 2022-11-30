package by.iba.kazakov.device_verification.controllers.verifier;

import by.iba.kazakov.device_verification.models.*;
import by.iba.kazakov.device_verification.services.serviceInterfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class VerInfo {
    @Autowired
    VerifierService verifierService;

    @Autowired
    UserService userService;

    @GetMapping({"/verifier/verInfo"})
    public String verInfo (Model model, Principal principal) {
        String name = principal.getName();
        Long id = userService.findByName(name);
        Verifier verifier = verifierService.findByUserId(id);
        model.addAttribute("verifier", verifier );

        return "verifier/verInfo";
    }

}
