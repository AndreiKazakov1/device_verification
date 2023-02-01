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

import java.security.Principal;
import java.util.Set;

@Controller
public class ClientsDevicesController {
    @Autowired
    ClientService clientService;
    @Autowired
    UserService userService;
    @Autowired
    DeviceInVerificationService deviceInVerificationService;

    @GetMapping({"/client/allClientsDevices"})
    public String clientInfo(Model model, Principal principal) {
        String name = principal.getName();
        Long id = userService.findByName(name);
        Client client = clientService.findClientByUserId(id);
        Long clientsId = client.getId();
        Set<DeviceInVerification> allClientsDevices = deviceInVerificationService.findAllDevicesByClientsId(clientsId);
        model.addAttribute("allClientsDevices", allClientsDevices);
        return "client/allClientsDevices";
    }
}
