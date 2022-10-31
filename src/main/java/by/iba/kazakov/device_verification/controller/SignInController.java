package by.iba.kazakov.device_verification.controller;

import by.iba.kazakov.device_verification.models.AdminKey;
import by.iba.kazakov.device_verification.services.serviceInterfaces.AdminKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Objects;
import java.util.Set;


@Controller
public class SignInController {
    @Autowired
    AdminKeyService adminKeyService;

    @RequestMapping(value = {"/signin"}, method = RequestMethod.GET)
    public String signIn(Model model){
        return "signin/signinPage";
    }

    @RequestMapping(value = {"/registrationChoice"}, method = RequestMethod.GET)
    public String registrationChoice(Model model){
        return "signin/registrationChoice";
    }

    @GetMapping({"/getAdmKey"})
    public String getAdmKey(Model model) {
        String admKey = String.valueOf(model.addAttribute("admKeyAtrb"));
        Set<AdminKey> adminKeys = adminKeyService.findAll();
        /* List<AdminKey> adminKeyList = new ArrayList<>(adminKeys.stream().toList());*/
        for (AdminKey admK : adminKeys) {
            if (Objects.equals(admK.getAdmKey(), admKey)) return "clientRegistrationForm";

        }

        return admKey;
    }









    /*
    *@GetMapping({"/addMeasType"})
    public String addMeasType (Model model) {
        model.addAttribute("addMeasType", new MeasurementType());
        return "addMeasurementType";
    }

    @PostMapping("/addMeasType")
    public String saveMeasType (Model model, MeasurementType measurementType){
        measurementTypeService.save(measurementType);
        return "addMeasurementTypeSubmit";
    }


    @RequestMapping({"/allMeasTypes"})
    public String measTypeList (Model model){
        Set<MeasurementType> measurementTypes = measurementTypeService.findAll();
        model.addAttribute("meastypes", measurementTypes );
        return "showAllMeasurementTypes";
    }
*/


}




