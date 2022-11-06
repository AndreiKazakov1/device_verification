package by.iba.kazakov.device_verification.controller;


import by.iba.kazakov.device_verification.models.Client;
import by.iba.kazakov.device_verification.models.User;
import by.iba.kazakov.device_verification.models.Verifier;
import by.iba.kazakov.device_verification.services.implementations.ClientServiceImpl;
import by.iba.kazakov.device_verification.services.serviceInterfaces.ClientService;
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

@Controller
public class RegistrationController {
    @Autowired
    UserService userService;
    @Autowired
    VerifierService verifierService;

    @Autowired
    ClientService clientService;



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
        String role = "verifier";
        User user = new User();
        user.setLogin(userLogin);
        user.setPassword(userPassword);
        user.setRole(role);
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
        String role = "client";
        User user = new User();
        user.setLogin(userLogin);
        user.setPassword(userPassword);
        user.setRole(role);
        userService.save(user);
        client.setIdUser(user);
        clientService.save(client);
        return "signin/newClientRegistrationSubmit";

    }




}