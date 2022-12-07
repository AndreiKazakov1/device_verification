package by.iba.kazakov.device_verification.controllers.admin;

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
import java.util.Set;

@Controller
public class RegistrationByAdminController {
    @Autowired
    UserService userService;
    @Autowired
    VerifierService verifierService;
    @Autowired
    RoleService roleService;
    @Autowired
    ClientService clientService;

    @GetMapping({"/admin/addNewVerifierAdm"})
    public String addNewVerifier (Model model) {
        model.addAttribute("addNewVerifierAdm", new Verifier());
        return "admin/addNewVerifierAdm";
    }
    @Transactional
    @PostMapping("/admin/addNewVerifierAdm")
    public String addNewUser(@Validated String userLogin, @Validated String userPassword, Verifier verifier){
            boolean logFlag = false;
            boolean sevrNumFlag = false;
            if (userService.loginValidation(userLogin)) logFlag = true;
            if(verifierService.verServNumValidation(verifier.getVerifierServiceNumber())) sevrNumFlag = true;

        if (logFlag && sevrNumFlag) {
            User user = new User();
            user.setUsername(userLogin);
            user.setPassword(BCrypt.hashpw(userPassword, BCrypt.gensalt(12)));
            user.setRoles(new ArrayList<>());
            user.getRoles().add(roleService.findByName("ROLE_VERIFIER"));
            userService.save(user);
            verifier.setIdUser(user);
            verifierService.save(verifier);
            return "admin/addNewVerifierAdmSubmit";
        }
        if (!logFlag) return "admin/registrationLogErrorInput";
        else return "admin/registrationServNumErrorInput";
    }


    @RequestMapping(value = {"/admin/addNewVerifierAdmSubmit"}, method = RequestMethod.GET)
    public String submitMeasType() {
        return "admin/addNewVerifierAdmSubmit";
    }

    @RequestMapping({"/admin/showAllVerifiers"})
    public String showAllVerifiers(Model model) {
        Set<Verifier> verifiers = verifierService.findAll();
        model.addAttribute("verifiers", verifiers);
        return "admin/showAllVerifiers";
    }


    //******************Client***************

    @GetMapping({"/admin/addNewClientAdm"})
    public String newClientRegistrationAdm(Model model) {
        model.addAttribute("newClient", new Client());
        return "admin/addNewClientAdm";

    }

    @Transactional
    @PostMapping("/admin/addNewClientAdm")
    public String addNewUserClientRegAdm (@Validated String userLogin, @Validated String userPassword, Client client){


        if(userService.loginValidation(userLogin)) {
            User user = new User();
            user.setUsername(userLogin);
            user.setPassword(BCrypt.hashpw(userPassword, BCrypt.gensalt(12)));
            user.setRoles(new ArrayList<>());
            user.getRoles().add(roleService.findByName("ROLE_CLIENT"));
            userService.save(user);
            client.setIdUser(user);
            clientService.save(client);
            return "admin/addNewClientAdmSubmit";
        }return "admin/registrationClientLogErrorInput";

    }


    @RequestMapping(value = {"/admin/addNewClientAdmSubmit"}, method = RequestMethod.GET)
    public String newClientRegistrationSubmit(Model model) {
        return "admin/addNewClientAdmSubmit";
    }






}
