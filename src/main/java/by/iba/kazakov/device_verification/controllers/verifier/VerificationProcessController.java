package by.iba.kazakov.device_verification.controllers.verifier;

import by.iba.kazakov.device_verification.models.*;
import by.iba.kazakov.device_verification.repositories.ErrorTypeRepository;
import by.iba.kazakov.device_verification.services.serviceInterfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import by.iba.kazakov.device_verification.models.RowCounter;

import java.util.ArrayList;
import java.util.Arrays;
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

    //int w;
    @PostMapping("/verifier/measurementProtocolHead")
    public String saveMeasurementProtocolHead (MeasurementProtocolHead measurementProtocolHead)  {

        try {
              measurementProtocolHeadService.save(measurementProtocolHead);
            RowCounter rowCounter = new RowCounter();
            Integer w = measurementProtocolHead.getDeviceInVerificationMeasurementChannelsQuantity();
            ArrayList<RowCounter> e = rowCounter.setR(w);
            System.out.println(e);

              //w =measurementProtocolHead.getDeviceInVerificationMeasurementChannelsQuantity();

        }catch (Exception e){
            return "verifier/errorInputProtocolNumber";
        }
        return "verifier/deviceInVerificationMeasurementChannel";
    }

    @GetMapping({"/verifier/deviceInVerificationMeasurementChannel"})
    public String deviceInVerificationMeasurementChannels (Model model) {
        model.addAttribute("deviceInVerificationMeasurementChannel",
                new DeviceInVerificationMeasurementChannel());

MeasurementProtocolHead measurementProtocolHead = new MeasurementProtocolHead();

        RowCounter rowCounter = new RowCounter();
        //ArrayList<Integer> e = rowCounter.setR(w);
        //System.out.println(e);
        Integer w = measurementProtocolHead.getDeviceInVerificationMeasurementChannelsQuantity();
        ArrayList<RowCounter> e = rowCounter.setR(w);
        System.out.println(e);


        Set<MeasurementChannelType> measurementChannelTypes = measurementChannelTypeService.findAll();
        model.addAttribute("measurementProtocolHead", measurementProtocolHead);
        model.addAttribute("measurementChannelTypes", measurementChannelTypes);
        model.addAttribute("e", e);

        return "verifier/deviceInVerificationMeasurementChannel";
    }



   /* @PostMapping("/verifier/addMeasurementChannelType")
    public String saveMeasurementChannelType (MeasurementChannelType measurementChannelType)  {
        measurementChannelTypeService.save(measurementChannelType);
        return "verifier/addMeasurementChannelTypeSubmit";
    }
   */
}