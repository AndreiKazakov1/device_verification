package by.iba.kazakov.device_verification.controller;

import by.iba.kazakov.device_verification.models.AdminKey;
import by.iba.kazakov.device_verification.models.MeasurementType;
import by.iba.kazakov.device_verification.services.serviceInterfaces.AdminKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;
import java.util.Set;


@Controller
public class SignInController {
    @Autowired
    AdminKeyService adminKeyService;

    @RequestMapping(value = {"/signin"}, method = RequestMethod.GET)
    public String signIn(Model model) {
        return "signin/signinPage";
    }

    @RequestMapping(value = {"/registrationChoice"}, method = RequestMethod.GET)
    public String registrationChoice(Model model) {
        return "signin/registrationChoice";
    }


    @RequestMapping(value = {"/verifierRegistrationForm"}, method = RequestMethod.GET)
    public String verifierRegistrationForm(Model model) {
        return "signin/verifierRegistrationForm";
    }

    @PostMapping({"/getAdmKey"})
    public String getAdmKey(@Validated String key) {
        Set<AdminKey> adminKeys = adminKeyService.findAll();
        for (AdminKey a : adminKeys) {
          String s = a.getAdmKey();
           if (s.equals(key)) return "signin/adminKeyIsSubmitted";
            else return "signin/adminKeyIsNotSubmitted";
        }
        return null;
    }
}



