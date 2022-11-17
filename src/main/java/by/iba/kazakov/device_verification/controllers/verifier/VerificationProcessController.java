package by.iba.kazakov.device_verification.controllers.verifier;

import by.iba.kazakov.device_verification.models.*;
import by.iba.kazakov.device_verification.repositories.ErrorTypeRepository;
import by.iba.kazakov.device_verification.services.serviceInterfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Set;

@Controller
public class VerificationProcessController {
    @Autowired
    DeviceInVerificationService deviceInVerificationService;
    @Autowired
    MeasurementProtocolHeadService measurementProtocolHeadService;
    @Autowired
    MeasurementProtocolBodyService measurementProtocolBodyService;
    @Autowired
    MeasurementProcessService measurementProcessService;
    @Autowired
    ErrorTypeService errorTypeService;



    @GetMapping({"/verifier/measurementProtocolHead"})
    public String measurementProtocolHead (Model model) {
        model.addAttribute("measurementProtocolHead", new MeasurementProtocolHead());
        Set<DeviceInVerification> deviceInVerifications = deviceInVerificationService.findAll();
        model.addAttribute("deviceInVerifications", deviceInVerifications );
        Set<ErrorType>errorTypes = errorTypeService.findAll();
        model.addAttribute("errorTypes", errorTypes);


        return "verifier/measurementProtocolHead";
    }

/*
    @PostMapping("/verifier/addDeviceType")
    public String saveDeviceType (DeviceType deviceType)  {
        deviceTypeService.save(deviceType);
        return "verifier/addDeviceTypeSubmit";
    }
    */

   /* @PostMapping("/verifier/addMeasurementChannelType")
    public String saveMeasurementChannelType (MeasurementChannelType measurementChannelType)  {
        measurementChannelTypeService.save(measurementChannelType);
        return "verifier/addMeasurementChannelTypeSubmit";
    }
   */
}