package com.group4.Kahoot3000;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@Controller
public class MainController {



    private static final String TEMPLATE_MAIN= "static/main";



    @RequestMapping(path = "/", method = RequestMethod.GET)

    public String greeting(

            @RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {

        model.addAttribute("name", name);

        return TEMPLATE_MAIN;

    }
}
