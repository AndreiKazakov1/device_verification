package by.iba.kazakov.device_verification.controller;

import by.iba.kazakov.device_verification.models.Client;
import by.iba.kazakov.device_verification.models.MeasurementType;
import by.iba.kazakov.device_verification.repositories.ClientRepository;
import by.iba.kazakov.device_verification.services.serviceInterfaces.ClientService;
import by.iba.kazakov.device_verification.services.serviceInterfaces.MeasurementTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashSet;
import java.util.Set;


@Controller
public class MeasurementTypeController {
    @Autowired
    MeasurementTypeService measurementTypeService;

    @GetMapping ({"/addMeasType"})
    public String addMeasType (Model model) {
        model.addAttribute("addMeasType", new MeasurementType());
        return "addMeasurementType";
    }


    @PostMapping ("/addMeasType")
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



}

