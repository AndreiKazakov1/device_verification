package by.iba.kazakov.device_verification.controllers.login_logout;

import by.iba.kazakov.device_verification.models.AdminKeyForClient;
import by.iba.kazakov.device_verification.models.AdminKeyForVerifier;
import by.iba.kazakov.device_verification.services.serviceInterfaces.AdminKeyForClientService;
import by.iba.kazakov.device_verification.services.serviceInterfaces.AdminKeyForVerifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;


@Controller
public class SignInController {
    @Autowired
    AdminKeyForVerifierService adminKeyService;
    @Autowired
    AdminKeyForClientService adminKeyForClientService;

    @RequestMapping(value = {"/","/signin"}, method = RequestMethod.GET)
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

    @PostMapping({"/registrationChoice/getAdmKeyForVerifier"})
    public String getAdmKeyVer(@Validated String key) {
        Set<AdminKeyForVerifier> adminKeyForVerifiers = adminKeyService.findAll();
        for (AdminKeyForVerifier a : adminKeyForVerifiers) {
          String s = a.getAdmKeyVerifier();
           if (s.equals(key)) return "signin/adminKeyIsSubmitted";
            else return "signin/adminKeyIsNotSubmitted";
        }
        return null;
    }

    @PostMapping({"/registrationChoice/getAdmKeyForClient"})
    public String getAdmKeyCli(@Validated String key_client) {
        Set<AdminKeyForClient> adminKeyForClients = adminKeyForClientService.findAll();
        for (AdminKeyForClient b : adminKeyForClients) {
            String l = b.getAdmKeyClient();
            if (l.equals(key_client)) return "signin/adminKeyForClientIsSubmitted";
            else return "signin/adminKeyIsNotSubmitted";
        }
        return null;
    }

}



