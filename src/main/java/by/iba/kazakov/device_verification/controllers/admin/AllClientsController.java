package by.iba.kazakov.device_verification.controllers.admin;


import by.iba.kazakov.device_verification.models.Client;
import by.iba.kazakov.device_verification.services.serviceInterfaces.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
public class AllClientsController {
    @Autowired
    ClientService clientService;

    @RequestMapping({"/allClients"})

    public String personList(Model model) {
        Set<Client> clients = clientService.findAll();
        model.addAttribute("clients", clients);
        return "admin/showAllClients";


    }}
