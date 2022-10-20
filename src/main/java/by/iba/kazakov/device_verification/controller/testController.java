package by.iba.kazakov.device_verification.controller;



import by.iba.kazakov.device_verification.models.Client;
import by.iba.kazakov.device_verification.services.serviceInterfaces.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@Controller
public class testController {


    @RequestMapping(value = {"/testTableX"}, method = RequestMethod.GET)
    public String index(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("tableTest");

        return "tableTest";
    }
}


/*
@Controller
public class allClientsController {
    @Autowired
    ClientService clientService;
    @RequestMapping({"/allClients"})

    public String personList(Model model) {
        Set<Client> clients = clientService.findAll();
        model.addAttribute("clients", clients);
        return "showAllClients";


    }}
*/
