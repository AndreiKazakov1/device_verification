package by.iba.kazakov.device_verification.controllers.verifier;


import by.iba.kazakov.device_verification.models.*;
import by.iba.kazakov.device_verification.services.serviceInterfaces.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.Set;

@Controller
public class DeviceInVerificationController {
    @Autowired
    DeviceTypeService deviceTypeService;

    @Autowired
    ClientService clientService;

    @Autowired
    VerifierService verifierService;

    @Autowired
    StandardService standardService;

    @Autowired
    DeviceInVerificationService deviceInVerificationService;

    @Autowired
    UserService userService;


    @GetMapping({"/verifier/addDeviceInVerification"})
    public String addDeviceInVerification (Model model, Principal principal) {
        model.addAttribute("deviceInVerification", new DeviceInVerification());
        Set<DeviceType> deviceTypes = deviceTypeService.findAll();
        model.addAttribute("deviceTypes", deviceTypes );
        Set<Client> clients = clientService.findAll();
        model.addAttribute("clients", clients );
        String name = principal.getName();
        Long id = userService.findByName(name);
        Verifier verifier = verifierService.findByUserId(id);
        model.addAttribute("verifier", verifier );
        Set<Standard> standards = standardService.findAll();
        model.addAttribute("standards", standards );
        return "verifier/addDeviceInVerification";
    }

    @PostMapping("/verifier/addDeviceInVerification")
    public String saveDeviceInVerification (DeviceInVerification deviceInVerification)  {
        deviceInVerificationService.save(deviceInVerification);
        return "verifier/addDeviceInVerificationSubmit";
    }



    @GetMapping(value = {"/verifier/addDeviceInVerificationSubmit"})
    public String submitDeviceInVerification() {

        return "verifier/addDeviceInVerificationSubmit";
    }

    @GetMapping({"/verifier/allDevicesInVerification"})
    public String deviceInVerificationList (Model model){
        Set<DeviceInVerification> devicesInVerifications = deviceInVerificationService.findAll();
        model.addAttribute("devicesInVerifications", devicesInVerifications );
        return "verifier/showAllDevicesInVerification";
    }

}
