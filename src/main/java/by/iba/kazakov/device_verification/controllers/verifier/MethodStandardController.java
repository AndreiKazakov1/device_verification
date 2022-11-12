package by.iba.kazakov.device_verification.controllers.verifier;


import by.iba.kazakov.device_verification.models.Methodology;
import by.iba.kazakov.device_verification.models.Standard;
import by.iba.kazakov.device_verification.services.serviceInterfaces.MethodologyService;
import by.iba.kazakov.device_verification.services.serviceInterfaces.StandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class MethodStandardController {
    @Autowired
    StandardService standardService;

    @Autowired
    MethodologyService methodologyService;

    @GetMapping({"/verifier/addStandard"})
    public String addStandard (Model model) {
        model.addAttribute("standard", new Standard());
        return "verifier/addStandard";
    }

    @GetMapping({"/verifier/addMethodology"})
    public String addMethodology (Model model) {
        model.addAttribute("methodology", new Methodology());
        return "verifier/addMethodology";
    }


    @PostMapping("/verifier/addStandard")
    public String saveStandard (@Validated String standardName, @Validated String standardNumber,
                                @Validated String standardVerificationDate, Standard standard) throws ParseException {

        /*String pattern = "yyyy-MM-dd";
        Date date = new SimpleDateFormat(pattern).parse(standardVerificationDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        System.out.println(date);*/


        standard.setStandardName(standardName);
        standard.setStandardNumber(standardNumber);
        standard.setStandardVerificationDate(standardVerificationDate);
        standardService.save(standard);
        return "verifier/addStandardSubmit";
    }

    @PostMapping("/verifier/addMethodology")
    public String saveMethodology (Methodology methodology)  {
        methodologyService.save(methodology);
        return "verifier/addMethodologySubmit";
    }

    @GetMapping(value = {"/verifier/addStandardSubmit"})
    public String submitStandard() {
        return "verifier/addStandardSubmit";
    }

    @GetMapping(value = {"/verifier/addMethodologySubmit"})
    public String submitMethodology() {
        return "verifier/addMethodologySubmit";
    }


    @GetMapping({"/verifier/allStandards"})
    public String standardList (Model model){
        Set<Standard> standards = standardService.findAll();
        model.addAttribute("standards", standards );
        return "verifier/showAllStandards";
    }

    @GetMapping({"/verifier/allMethodologies"})
    public String MethodologiesList (Model model){
        Set<Methodology> methodologies = methodologyService.findAll();
        model.addAttribute("methodologies", methodologies );
        return "verifier/showAllMethodologies";
    }


}
