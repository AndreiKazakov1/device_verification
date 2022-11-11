package by.iba.kazakov.device_verification.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {


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
