package by.iba.kazakov.device_verification.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class IndexController {



    /*@RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public String index(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return "index";
    }
*/
    @RequestMapping(value = {"/verifier"}, method = RequestMethod.GET)
    public String verifier(Model model) {

        return "verifier";
    }

    @GetMapping("/indexx")
    public String pageChoice(Principal principal){
        String s = (((Authentication)principal).getAuthorities()).toString();
        System.out.println(s);
        if (s.equals("[ROLE_VERIFIER]")) return "verifier";
        else return "indexx";
    }


}
