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

    @GetMapping({"/verifier/duplicateMeasurementTypeErr"})
    public String addMeasTypeErr() {
        return "verifier/duplicateMeasurementTypeErr";
    }



    @PostMapping("/verifier/addMeasType")
    public String saveMeasType(Model model, MeasurementType measurementType) {
        try {
            measurementTypeService.save(measurementType);
        }catch (Exception e){
            return "redirect:/verifier/duplicateMeasurementTypeErr";
        }
        return "verifier/addMeasurementTypeSubmit";
    }


    @GetMapping({"/verifier/allMeasTypes"})
    public String measTypeList(Model model) {
        Set<MeasurementType> measurementTypes = measurementTypeService.findAll();
        model.addAttribute("meastypes", measurementTypes);
        return "verifier/showAllMeasurementTypes";
    }


    @PostMapping(value = "/verifier/{id}/del")
    public String deleteMeasurementType(@PathVariable (value = "id") long id) {
        MeasurementType measurementType =  measurementTypeService.findById(id);
        measurementTypeService.delete(measurementType);
        return "redirect:/verifier/allMeasTypes";
    }
}
