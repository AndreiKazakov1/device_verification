package by.iba.kazakov.device_verification.controllers.admin;

import by.iba.kazakov.device_verification.models.User;
import by.iba.kazakov.device_verification.models.Verifier;
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
            User user = new User();
            user.setUsername(userLogin);
            user.setPassword(BCrypt.hashpw(userPassword,BCrypt.gensalt(12)));
            user.setRoles(new ArrayList<>());
            user.getRoles().add(roleService.findByName("ROLE_VERIFIER"));
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
