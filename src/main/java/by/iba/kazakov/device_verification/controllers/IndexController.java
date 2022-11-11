package by.iba.kazakov.device_verification.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
   /* @RequestMapping(value = {"/verifier"}, method = RequestMethod.GET)
    public String verifier(Model model) {

        return "verifier";
    }
*/
    @GetMapping("/index")
    public String pageChoice(Principal principal){
        String role = (((Authentication)principal).getAuthorities()).toString();
        switch (role) {
            case "[ROLE_VERIFIER]":
                return "redirect:/verifier";
            case "[ROLE_CLIENT]":
                return "redirect:/client";
            case "[ROLE_ADMIN, ROLE_CLIENT, ROLE_VERIFIER]":
                return "redirect:/admin";
        }
        System.out.println(role);
         return null;
    }


}
