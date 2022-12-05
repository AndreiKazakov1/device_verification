package by.iba.kazakov.device_verification.controllers.admin;

import by.iba.kazakov.device_verification.models.*;
import by.iba.kazakov.device_verification.services.serviceInterfaces.AdminKeyForClientService;
import by.iba.kazakov.device_verification.services.serviceInterfaces.AdminKeyForVerifierService;
import by.iba.kazakov.device_verification.services.serviceInterfaces.AdministratorService;
import by.iba.kazakov.device_verification.services.serviceInterfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.Set;

@Controller
public class AdminsMenuController {
    @Autowired
    UserService userService;
    @Autowired
    AdministratorService administratorService;
    @Autowired
    AdminKeyForClientService adminKeyForClientService;
    @Autowired
    AdminKeyForVerifierService adminKeyForVerifierService;


    /*@GetMapping({"/admin/admin"})
    public String returnCurrentAdmin(Model model) {
        Administrator administrator = administratorService.findById(1);
        System.out.println(administrator.getAdminFirstName());
        model.addAttribute("administrator", administrator);
        return "admin/adminInfo";
    }*/

    @GetMapping({"/admin/adminInfo"})
    public String adminInfo (Model model, Principal principal) {
        String name = principal.getName();
        Long id = userService.findByName(name);
        Administrator administrator = administratorService.findAdministratorByUserId(id);
        model.addAttribute("administrator", administrator );

        return "admin/adminInfo";
    }


    @GetMapping({"/admin/changeRegKeyClient"})
    public String changeRegKeyClient_(Model model){
        AdminKeyForClient adminKeyForClient = adminKeyForClientService.findOnlyFirst();
        model.addAttribute("adminKeyForClient", adminKeyForClient);
        return "admin/changeRegKeyClient";
    }

    @PostMapping({"/admin/changeRegKeyClient"})
    public String changeRegKeyClient(@Validated String clientsNewRegKey){
        AdminKeyForClient adminKeyForClient = adminKeyForClientService.findOnlyFirst();
        adminKeyForClientService.findOnlyFirst().setAdmKeyClient(clientsNewRegKey);
        adminKeyForClientService.save(adminKeyForClient);
        return "admin/changeRegKeyClientSubmit";
    }

    @GetMapping({"/admin/changeRegKeyVerifier"})
    public String changeRegKeyVerifier_(Model model){
        AdminKeyForVerifier adminKeyForVerifier = adminKeyForVerifierService.findOnlyFirst();
        model.addAttribute("adminKeyForVerifier", adminKeyForVerifier);
        return "admin/changeRegKeyVerifier";
    }

    @PostMapping({"/admin/changeRegKeyVerifier"})
    public String changeRegKeyVerifier(@Validated String verifiersNewRegKey){
        AdminKeyForVerifier adminKeyForVerifier = adminKeyForVerifierService.findOnlyFirst();
        adminKeyForVerifierService.findOnlyFirst().setAdmKeyVerifier(verifiersNewRegKey);
        adminKeyForVerifierService.save(adminKeyForVerifier);
        return "admin/changeRegKeyVerifierSubmit";
    }



}
