package by.iba.kazakov.device_verification.controllers.verifier;


import by.iba.kazakov.device_verification.dateformat.DateFormat;
import by.iba.kazakov.device_verification.models.Standard;
import by.iba.kazakov.device_verification.services.serviceInterfaces.MethodologyService;
import by.iba.kazakov.device_verification.services.serviceInterfaces.StandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

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


    @PostMapping("/verifier/addStandard")
    public String saveStandard (Model model, @DateTimeFormat(pattern = "yyyy-MM-dd")  Date  standardVerificationDate, Standard standard) {
        standard.setStandardVerificationDate(standardVerificationDate);
        standardService.save(standard);
        return "verifier/addStandardSubmit";
    }


    @PostMapping({"/verifier/allStandards"})
    public String standardList (Model model){
        Set<Standard> standards = standardService.findAll();
        model.addAttribute("standard", standards );
        return "verifier/showAllstandards";
    }

    @GetMapping(value = {"/verifier/addStandardSubmit"})
    public String submitStandard() {
        return "verifier/addStandardSubmit";
    }
}
