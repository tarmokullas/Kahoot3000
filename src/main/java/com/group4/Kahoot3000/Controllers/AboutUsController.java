package com.group4.Kahoot3000.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AboutUsController {

    @RequestMapping(value = {"/aboutus"}, method = RequestMethod.GET)
    public String index(Model model) {
        return "aboutus";
    }
}
