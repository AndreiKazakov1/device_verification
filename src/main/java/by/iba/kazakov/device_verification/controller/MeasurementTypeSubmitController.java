package by.iba.kazakov.device_verification.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MeasurementTypeSubmitController {


    @RequestMapping(value = {"/addMeasTypeSub"}, method = RequestMethod.GET)
    public String submitMeasType(Model model) {
        /*ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addMeasTypeSub");
*/
        return "verifier/addMeasurementTypeSubmit";
    }
}
