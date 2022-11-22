package by.iba.kazakov.device_verification.controllers.verifier;


import by.iba.kazakov.device_verification.models.*;
import by.iba.kazakov.device_verification.services.serviceInterfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Set;

@Controller
public class DeviceInVerificationMeasurementChannelController {
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


    @GetMapping({"/verifier/addDeviceInVerificationMeasurementChannel"})
    public String addDeviceInVerificationMeasurementChannel (Model model) {
        model.addAttribute("deviceInVerificationMeasurementChannel", new DeviceInVerificationMeasurementChannel());
        Set<MeasurementChannelType> measurementChannelTypes = measurementChannelTypeService.findAll();
        MeasurementProtocolHead measurementProtocolHead = measurementProtocolHeadService.findById(measurementProtocolHeadService.returnCurrentProtocolId());
        int w = measurementProtocolHeadService.returnCurrentChannelsCount();
        System.out.println(w);

        int[] channelArr = measurementProtocolHeadService.channelArr();
        System.out.println(Arrays.toString(channelArr));

        model.addAttribute("measurementProtocolHead", measurementProtocolHead);
        model.addAttribute("measurementChannelTypes", measurementChannelTypes );
        model.addAttribute("channelArr", channelArr);
        return "verifier/addDeviceInVerificationMeasurementChannel";
    }


    @PostMapping("/verifier/addDeviceInVerificationMeasurementChannel")
    public String saveDeviceInVerificationMeasurementChannel (DeviceInVerificationMeasurementChannel deviceInVerificationMeasurementChannel)  {

            deviceInVerificationMeasurementChannelService.save(deviceInVerificationMeasurementChannel);
        return "verifier/addDeviceInVerificationMeasChSubmit";
    }





}
//addDeviceInVerificationMeasChSubmit