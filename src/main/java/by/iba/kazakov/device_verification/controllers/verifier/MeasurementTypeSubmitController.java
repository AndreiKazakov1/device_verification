package by.iba.kazakov.device_verification.controllers.verifier;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MeasurementTypeSubmitController {


    @RequestMapping(value = {"/verifier/addMeasTypeSub"}, method = RequestMethod.GET)
    public String submitMeasType() {
        return "verifier/addMeasurementTypeSubmit";
    }
}
