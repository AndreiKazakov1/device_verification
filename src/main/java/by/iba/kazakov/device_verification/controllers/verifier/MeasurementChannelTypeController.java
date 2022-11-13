package by.iba.kazakov.device_verification.controllers.verifier;


import by.iba.kazakov.device_verification.models.DeviceType;
import by.iba.kazakov.device_verification.models.MeasurementChannelType;
import by.iba.kazakov.device_verification.models.MeasurementType;
import by.iba.kazakov.device_verification.models.Methodology;
import by.iba.kazakov.device_verification.services.serviceInterfaces.DeviceTypeService;
import by.iba.kazakov.device_verification.services.serviceInterfaces.MeasurementChannelTypeService;
import by.iba.kazakov.device_verification.services.serviceInterfaces.MeasurementTypeService;
import by.iba.kazakov.device_verification.services.serviceInterfaces.MethodologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Set;

@Controller
public class MeasurementChannelTypeController {
    @Autowired
    MeasurementChannelTypeService measurementChannelTypeService;


    @GetMapping({"/verifier/addMeasurementChannelType"})
    public String addMeasurementChannelType (Model model) {
        model.addAttribute("measurementChannel", new MeasurementChannelType());
        return "verifier/addMeasurementChannelType";
    }

    @PostMapping("/verifier/addMeasurementChannelType")
    public String saveMeasurementChannelType (MeasurementChannelType measurementChannelType)  {
        measurementChannelTypeService.save(measurementChannelType);
        return "verifier/addMeasurementChannelType";
    }

    @GetMapping(value = {"/verifier/addMeasurementChannelTypeSubmit"})
    public String submitMeasurementChannelType() {
        return "verifier/addMeasurementChannelTypeSubmit";
    }

    @GetMapping({"/verifier/showAllMeasurementChannelTypes"})
    public String measurementChannelTypeList (Model model){
        Set<MeasurementChannelType> measurementChannelTypes = measurementChannelTypeService.findAll();
        model.addAttribute("measurementChannelTypes", measurementChannelTypes );
        return "verifier/showAllMeasurementChannelTypes";
    }

}
