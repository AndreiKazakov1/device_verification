package by.iba.kazakov.device_verification.controllers.admin;

import by.iba.kazakov.device_verification.models.*;
import by.iba.kazakov.device_verification.services.serviceInterfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    @Autowired
    VerifierService verifierService;


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

    @GetMapping({"/admin/blockingUser"})
    public String blockingUser(Model model){
        Set<Verifier> verifiers = verifierService.findAll();
        model.addAttribute("verifiers", verifiers);
        return "admin/blockingUser";
    }


   /* @PostMapping({"/admin/blockingUser"})
    public String blockingUser(@Validated String verifierFirstName, @Validated String verifierLastName){
        Verifier verifier = verifierService.findByFirstSecondName(verifierFirstName, verifierLastName);
        if(verifier.getId()>0) return "redirect:/admin/adminInfo";
       else return "redirect:/admin/blockingUserErr";
        //Long id = verifier.getIdUser().getId();
        //return "admin/blockingUserErr";
    }*/



    @PostMapping(value = "/admin/{id}/block")
    public String blockingUser1(@PathVariable (value = "id") Long id) {
        User user = userService.findById(id);
        user.setEnabled(false);
        userService.save(user);
        return "redirect:/admin/block";
    }

    @GetMapping({"/admin/block"})
    public String block(){
        return "redirect:/admin/block";
    }

    @GetMapping({"/admin/blockingUserErr"})
    public String blockingUserErr(){
        return "admin/blockingUserErr";
    }

}


