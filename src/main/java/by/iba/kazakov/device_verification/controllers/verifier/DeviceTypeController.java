package by.iba.kazakov.device_verification.controllers.verifier;

import by.iba.kazakov.device_verification.models.DeviceType;
import by.iba.kazakov.device_verification.models.MeasurementType;
import by.iba.kazakov.device_verification.models.Methodology;
import by.iba.kazakov.device_verification.services.serviceInterfaces.DeviceTypeService;
import by.iba.kazakov.device_verification.services.serviceInterfaces.MeasurementTypeService;
import by.iba.kazakov.device_verification.services.serviceInterfaces.MethodologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.Set;


@Controller
public class DeviceTypeController {
    @Autowired
    DeviceTypeService deviceTypeService;
    @Autowired
    MeasurementTypeService measurementTypeService;
    @Autowired
    MethodologyService methodologyService;


    @GetMapping({"/verifier/addDeviceType"})
    public String addDeviceType (Model model) {
        model.addAttribute("deviceType", new DeviceType());
        Set<MeasurementType> measurementTypes = measurementTypeService.findAll();
        model.addAttribute("measurementTypes", measurementTypes );
        Set<Methodology> methodologies = methodologyService.findAll();
        model.addAttribute("methodologies", methodologies );
        return "verifier/addDeviceType";
    }

    @PostMapping("/verifier/addDeviceType")
    public String saveDeviceType (DeviceType deviceType)  {
        deviceTypeService.save(deviceType);
        return "verifier/addDeviceTypeSubmit";
    }

    @GetMapping(value = {"/verifier/addDeviceTypeSubmit"})
    public String submitDeviceType() {
        return "verifier/addDeviceTypeSubmit";
    }

    @GetMapping({"/verifier/allDeviceType"})
    public String deviceTypeList (Model model){
        Set<DeviceType> deviceTypes = deviceTypeService.findAll();
        model.addAttribute("deviceTypes", deviceTypes );
        return "verifier/showAllDeviceType";
    }
}
