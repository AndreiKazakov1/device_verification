package by.iba.kazakov.device_verification.controllers.verifier;

import by.iba.kazakov.device_verification.models.MeasurementType;
import by.iba.kazakov.device_verification.services.serviceInterfaces.MeasurementTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@Controller
public class MeasurementTypeController {
    @Autowired
    MeasurementTypeService measurementTypeService;

    @GetMapping({"/verifier/addMeasType"})
    public String addMeasType(Model model) {
        model.addAttribute("addMeasType", new MeasurementType());
        return "verifier/addMeasurementType";
    }


    @PostMapping("/verifier/addMeasType")
    public String saveMeasType(Model model, MeasurementType measurementType) {
        measurementTypeService.save(measurementType);
        return "verifier/addMeasurementTypeSubmit";
    }


    @GetMapping({"/verifier/allMeasTypes"})
    public String measTypeList(Model model) {
        Set<MeasurementType> measurementTypes = measurementTypeService.findAll();
        model.addAttribute("meastypes", measurementTypes);
        return "verifier/showAllMeasurementTypes";
    }


    @DeleteMapping(value = "verifier/deleteMeasurementType/{id}")
    public String deleteMeasurementType(@PathVariable Long id) {
        measurementTypeService.deleteById(id);
        return "verifier/showAllMeasurementTypes";

    }

}
