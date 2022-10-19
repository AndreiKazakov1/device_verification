package by.iba.kazakov.device_verification.controller;

import by.iba.kazakov.device_verification.models.MeasurementType;
import by.iba.kazakov.device_verification.services.serviceInterfaces.MeasurementTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


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
        return "index";
    }
}
