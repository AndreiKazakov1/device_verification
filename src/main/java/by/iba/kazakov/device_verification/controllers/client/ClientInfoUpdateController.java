package by.iba.kazakov.device_verification.controllers.client;

import by.iba.kazakov.device_verification.models.Client;
import by.iba.kazakov.device_verification.models.DeviceInVerification;
import by.iba.kazakov.device_verification.services.serviceInterfaces.ClientService;
import by.iba.kazakov.device_verification.services.serviceInterfaces.DeviceInVerificationService;
import by.iba.kazakov.device_verification.services.serviceInterfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.Set;

@Controller
public class ClientInfoUpdateController {
    @Autowired
    ClientService clientService;
    @Autowired
    UserService userService;


    @GetMapping({"/client/editClientsInfo"})
    public String clientInfo(Model model, Principal principal) {
        String name = principal.getName();
        Long id = userService.findByName(name);
        Client client = clientService.findClientByUserId(id);
        model.addAttribute("client", client);
        return "client/editClientsInfo";
    }



    @PostMapping("client/editClientsInfo")
    public String editClient_(Client client){
        clientService.save(client);
        return "redirect:/client/clientInfo";
    }

}
