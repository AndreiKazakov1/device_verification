package by.iba.kazakov.device_verification.controllers.verifier;

import by.iba.kazakov.device_verification.models.*;
import by.iba.kazakov.device_verification.services.serviceInterfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
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
    @Autowired
    DeviceInVerificationMeasurementChannelService deviceInVerificationMeasurementChannelService;
    @Autowired
    MeasurementChannelTypeService measurementChannelTypeService;



    @GetMapping({"/verifier/measurementProtocolHead"})
    public String measurementProtocolHead (Model model) {
            model.addAttribute("measurementProtocolHead", new MeasurementProtocolHead());
            Set<DeviceInVerification> deviceInVerifications = deviceInVerificationService.findAll();
            model.addAttribute("deviceInVerifications", deviceInVerifications);
            Set<ErrorType> errorTypes = errorTypeService.findAll();
            model.addAttribute("errorTypes", errorTypes);
        return "verifier/measurementProtocolHead";
    }



    int currentProtocol;
    int currentDev;
    @PostMapping("/verifier/measurementProtocolHead")
    public String saveMeasurementProtocolHead (MeasurementProtocolHead measurementProtocolHead)  {
        try {
              measurementProtocolHeadService.save(measurementProtocolHead);
               currentProtocol = measurementProtocolHead.getId();
               currentDev = measurementProtocolHead.getIdDeviceInVerification().getId();
        }catch (Exception e){
            return "verifier/errorInputProtocolNumber";
        }
        return "verifier/deviceInVerificationMeasurementChannel";
    }



    @GetMapping({"/verifier/deviceInVerificationMeasurementChannel"})
    public String deviceInVerificationMeasurementChannels (Model model) {
        model.addAttribute("deviceInVerificationMeasurementChannel",
                new DeviceInVerificationMeasurementChannel());
        MeasurementProtocolHead measurementProtocolHead =  measurementProtocolHeadService.findById(currentProtocol);
        DeviceInVerification deviceInVerification = deviceInVerificationService.findById(currentDev);
        Set<MeasurementChannelType> measurementChannelTypes = measurementChannelTypeService.findAll();
        model.addAttribute("measurementProtocolHead", measurementProtocolHead);
        model.addAttribute("measurementChannelTypes", measurementChannelTypes);
        model.addAttribute("deviceInVerification", deviceInVerification);
        return "verifier/deviceInVerificationMeasurementChannel";
    }



    @PostMapping("/verifier/deviceInVerificationMeasurementChannel")
    public String saveMeasurementChannelType (DeviceInVerificationMeasurementChannel deviceInVerificationMeasurementChannel)  {
        deviceInVerificationMeasurementChannelService.save(deviceInVerificationMeasurementChannel);
        return "verifier/deviceInVerificationMeasurementChannel";
    }

}