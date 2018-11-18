package com.group4.Kahoot3000.Controllers;

import com.group4.Kahoot3000.Forms.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class CreateController {

    @RequestMapping(value = {"/create"}, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("createGameForm", new CreateGameForm());

        return "create";
    }


    @RequestMapping(value = {"/create"}, method = RequestMethod.POST)
    public String createGameSubmit(Model model, @ModelAttribute("createGameForm") CreateGameForm createGameForm) {

        System.out.println(createGameForm.getQuestion1trueAnswer());


        return "create";
    }




}

