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
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
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
    @Autowired
    ClientService clientService;

    @GetMapping({"/admin/adminInfo"})
    public String adminInfo (Model model, Principal principal) {
        String name = principal.getName();
        Long id = userService.findByName(name);
        Administrator administrator = administratorService.findAdministratorByUserId(id);
        model.addAttribute("administrator", administrator );
        return "admin/adminInfo";
    }

//***************  changeRegKey  *****************
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
//*************   blockingUser   *******************
    @GetMapping({"/admin/blockingUser"})
    public String blockingUserVerifier(Model model) {
        Set<Verifier> verifiers = verifierService.findAll();
        model.addAttribute("verifierService", verifierService);
        model.addAttribute("verifiers", verifiers);
        return "admin/blockingUser";
    }


    @PostMapping(value = "/admin/{id}/block")
    public String blockingUserVerifier_(@PathVariable (value = "id") Long id) {
        User user = userService.findById(id);
        user.setEnabled(false);
        userService.save(user);
        return  "redirect:/admin/blockingUser";
    }

    @PostMapping(value = "/admin/{id}/unlock")
    public String unlockingUserVerifier(@PathVariable (value = "id") Long id) {
        User user = userService.findById(id);
        user.setEnabled(true);
        userService.save(user);
        return  "redirect:/admin/blockingUser";
    }

    @GetMapping({"/admin/blockingUserErr"})
    public String blockingUserVerifierErr(){
        return "admin/blockingUserErr";
    }


    @GetMapping({"/admin/blockingUserClient"})
    public String blockingUserClient(Model model) {
        Set<Client> clients = clientService.findAll();
        model.addAttribute("clientService", clientService);
        model.addAttribute("clients", clients);
        return "admin/blockingUserClient";
    }


    @PostMapping(value = "/admin/{id}/blockClient")
    public String blockingUserClient_(@PathVariable (value = "id") Long id) {
        User user = userService.findById(id);
        user.setEnabled(false);
        userService.save(user);
        return  "redirect:/admin/blockingUserClient";
    }

    @PostMapping(value = "/admin/{id}/unlockClient")
    public String unlockingUserClient(@PathVariable (value = "id") Long id) {
        User user = userService.findById(id);
        user.setEnabled(true);
        userService.save(user);
        return  "redirect:/admin/blockingUserClient";
    }




    //************* Work with Verifiers ***************
    @RequestMapping({"/admin/showAllVerifiers"})
    public String showAllVerifiers(Model model) {
        Set<Verifier> verifiers = verifierService.findAll();
        model.addAttribute("verifiers", verifiers);
        return "admin/showAllVerifiers";
    }


    //************* Work with Clients ***************

    @RequestMapping({"/admin/allClients"})
    public String personList(Model model) {
        Set<Client> clients = clientService.findAll();
        model.addAttribute("clients", clients);
        return "admin/showAllClients";
    }

    @PostMapping(value = "/admin/{id}/deleteClient")
    public String deleteClient(@PathVariable (value = "id") long id) {
        Client client = clientService.findById(id);
        Long clId = client.getIdUser().getId();
        User user = userService.findById(clId);
        userService.delete(user);
        return "redirect:/admin/allClients";
    }

    @PostMapping({"/admin/{id}/editClient"})
    public String editClient(Model model, @PathVariable (value = "id") long id) {
        Client client = clientService.findById(id);
        model.addAttribute("client", client);
        return "admin/editClient";
    }

    @PostMapping("admin/editClient")
    public String editClient_(Client client){
        clientService.save(client);
        return "redirect:/admin/allClients";
    }

    @PostMapping({"/admin/{id}/editVerifier"})
    public String editVerifier(Model model, @PathVariable (value = "id") long id) {
        Verifier verifier = verifierService.findById(id);
        model.addAttribute("verifier", verifier);
        return "admin/editVerifier";
    }

    @PostMapping("admin/editVerifier")
    public String editVerifier_(Verifier verifier){
        verifierService.save(verifier);
        return "redirect:/admin/showAllVerifiers";
    }


}


