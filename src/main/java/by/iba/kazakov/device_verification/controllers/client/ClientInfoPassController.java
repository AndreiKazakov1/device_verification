package by.iba.kazakov.device_verification.controllers.client;

import by.iba.kazakov.device_verification.models.Client;
import by.iba.kazakov.device_verification.services.serviceInterfaces.ClientService;
import by.iba.kazakov.device_verification.services.serviceInterfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class ClientInfoPassController {
    @Autowired
    ClientService clientService;

    @Autowired
    UserService userService;


    @GetMapping({"/client/clientInfo"})
    public String clientInfo(Model model, Principal principal) {
        String name = principal.getName();
        Long id = userService.findByName(name);
        Client client = clientService.findClientByUserId(id);
        model.addAttribute("client", client);
        return "client/clientInfo";
    }

    @GetMapping(value = {"/client/client"})
    public String clientInfo() {
        return "client/client";
    }

    @GetMapping(value = {"/client/clientsPassUpdate"})
    public String clientsPassUpdate() {
        return "client/changeClientsPassword";
    }

    @PostMapping({"/client/clientsPassUpdate"})
    public String clientsPassUpdate(@Validated String clientsOldPass, @Validated String clientsNewPass,
                                    @Validated String clientsNewPassSubmit, Principal principal) {
        String name = principal.getName();
        Long currentClientsId = userService.findByName(name);
        Client client = clientService.findClientByUserId(currentClientsId);

        boolean f1, f2;
        f1=userService.oldClientsPassValidation(clientsOldPass, currentClientsId);
        f2=userService.twoClientsPassEquals(clientsNewPass, clientsNewPassSubmit);
        if(!f1)return "client/changeClientsOldPasswordErr";
        if(!f2) return "client/changeClientsTwoPasswordsErr";
        if(f1&&f2){
            userService.findById(currentClientsId).setPassword(BCrypt.hashpw(clientsNewPass, BCrypt.gensalt(12)));
            userService.save(client.getIdUser());
            return "client/changeClientsPasswordSubmit";
        }

        else return null;
    }




}