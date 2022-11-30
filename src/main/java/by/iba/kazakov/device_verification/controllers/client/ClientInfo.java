package by.iba.kazakov.device_verification.controllers.client;

import by.iba.kazakov.device_verification.models.Client;
import by.iba.kazakov.device_verification.models.Verifier;
import by.iba.kazakov.device_verification.services.serviceInterfaces.ClientService;
import by.iba.kazakov.device_verification.services.serviceInterfaces.UserService;
import by.iba.kazakov.device_verification.services.serviceInterfaces.VerifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.security.Principal;

@Controller
public class ClientInfo {
    @Autowired
    ClientService clientService;

    @Autowired
    UserService userService;

    @GetMapping({"/client/clientInfo"})
    public String clientInfo (Model model, Principal principal) {
        String name = principal.getName();
        Long id = userService.findByName(name);
        Client client = clientService.findClientByUserId(id);
        model.addAttribute("client", client );
        return "client/clientInfo";
    }

    @GetMapping(value = {"/client/client"})
    public String submitDeviceType() {
        return "client/client";
    }


}
