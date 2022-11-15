package by.iba.kazakov.device_verification.controllers.registration;


import by.iba.kazakov.device_verification.models.Client;
import by.iba.kazakov.device_verification.models.User;
import by.iba.kazakov.device_verification.models.Verifier;
import by.iba.kazakov.device_verification.services.serviceInterfaces.ClientService;
import by.iba.kazakov.device_verification.services.serviceInterfaces.RoleService;
import by.iba.kazakov.device_verification.services.serviceInterfaces.UserService;
import by.iba.kazakov.device_verification.services.serviceInterfaces.VerifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class RegistrationController {
    @Autowired
    UserService userService;
    @Autowired
    VerifierService verifierService;

    @Autowired
    ClientService clientService;

    @Autowired
    RoleService roleService;



   /* @RequestMapping({"/verifierRegistrationForm"})
    public String newVerifierForm (Model model) {
        return "signin/verifierRegistrationForm";
    }
*/


    @GetMapping({"/verifierRegistration"})
    public String newVerifierRegistration(Model model) {
        model.addAttribute("newVerifier", new Verifier());
        return "signin/verifierRegistrationForm";


    }

    @Transactional
    @PostMapping("/verifierRegistration")
    public String addNewUserVerReg(@Validated String userLogin, @Validated String userPassword,
                                   @Validated String verifierFirstName, @Validated String verifierLastName,
                                   @Validated int verifierServiceNumber, Verifier verifier) {

        User user = new User();
        user.setUsername(userLogin);
        user.setPassword(BCrypt.hashpw(userPassword,BCrypt.gensalt(12)));
        user.setRoles(new ArrayList<>());
        user.getRoles().add(roleService.findByName("ROLE_VERIFIER"));
        userService.save(user);
        verifier.setIdUser(user);
        verifier.setVerifierFirstName(verifierFirstName);
        verifier.setVerifierLastName(verifierLastName);
        verifier.setVerifierServiceNumber(verifierServiceNumber);
        verifierService.save(verifier);
        return "signin/newVerifierRegistrationSubmit";

    }

    @RequestMapping(value = {"/newVerifierRegistrationSubmit"}, method = RequestMethod.GET)
    public String newVerifierRegistrationSubmit(Model model) {
        return "signin/newVerifierRegistrationSubmit";
    }



    @GetMapping({"/clientRegistration"})
    public String newClientRegistration(Model model) {
        model.addAttribute("newClient", new Client());
        return "signin/clientRegistrationForm";

    }

    @Transactional
    @PostMapping("/clientRegistration")
    public String addNewUserClientReg (@Validated String userLogin, @Validated String userPassword, Client client){
        User user = new User();
        user.setUsername(userLogin);
        user.setPassword(BCrypt.hashpw(userPassword,BCrypt.gensalt(12)));
        user.setRoles(new ArrayList<>());
        user.getRoles().add(roleService.findByName("ROLE_CLIENT"));
        userService.save(user);
        client.setIdUser(user);
        clientService.save(client);
        return "signin/newClientRegistrationSubmit";

    }


    @RequestMapping(value = {"/newClientRegistrationSubmit"}, method = RequestMethod.GET)
    public String newClientRegistrationSubmit(Model model) {
        return "signin/newClientRegistrationSubmit";
    }

}