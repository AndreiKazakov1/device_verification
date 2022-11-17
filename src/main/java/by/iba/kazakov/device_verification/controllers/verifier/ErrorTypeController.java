package by.iba.kazakov.device_verification.controllers.verifier;

import by.iba.kazakov.device_verification.models.ErrorType;
import by.iba.kazakov.device_verification.models.MeasurementType;
import by.iba.kazakov.device_verification.services.serviceInterfaces.ErrorTypeService;
import by.iba.kazakov.device_verification.services.serviceInterfaces.MeasurementTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Set;

@Controller
public class ErrorTypeController {
    @Autowired
    ErrorTypeService errorTypeService;


    @GetMapping({"/verifier/addErrorType"})
    public String addErrorType (Model model) {
        model.addAttribute("errorType", new ErrorType());
        return "verifier/addErrorType";
    }


    @PostMapping("/verifier/addErrorType")
    public String saveErrorType (ErrorType errorType){
        errorTypeService.save(errorType);
        return "verifier/addErrorTypeSubmit";
    }


    @GetMapping({"/verifier/showAllErrorTypes"})
    public String errorTypeList (Model model){
        Set<ErrorType> errorTypes = errorTypeService.findAll();
        model.addAttribute("errorTypes", errorTypes);
        return "verifier/showAllErrorTypes";
    }







}
